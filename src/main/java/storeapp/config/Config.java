package storeapp.config;

import storeapp.domain.Admin;
import storeapp.infraestructure.in.view.CategoryView;
import storeapp.infraestructure.in.view.ProductView;
import storeapp.infraestructure.out.adapters.CategoryRepositoryDB;
import storeapp.infraestructure.out.adapters.CustomerRepository;
import storeapp.infraestructure.out.adapters.CustomerRepositoryDB;
import storeapp.infraestructure.out.adapters.ProductRepositoryDB;
import storeapp.infraestructure.out.db.DataBaseConnection;
import storeapp.infraestructure.out.mapper.CategoryRowMapper;
import storeapp.infraestructure.out.mapper.CustomerRowMapper;
import storeapp.infraestructure.out.mapper.ProductRowMapper;
import storeapp.infraestructure.out.mapper.RowMapper;
import storeapp.services.AdminServiceImpl;
import storeapp.services.CategoryInputAdapter;
import storeapp.services.ProductInputAdapter;
import storeapp.services.input.*;
import storeapp.services.CustumerServiceImpl;
import storeapp.services.port.CategoryPersistencePort;
import storeapp.services.port.CustomerPersistencePort;
import storeapp.services.port.ProductPersistencePort;
import storeapp.userinterface.MenuApp;
import storeapp.infraestructure.in.view.AdminView;
import storeapp.infraestructure.in.view.CustomerView;

import java.sql.Connection;

public class Config {

    public static MenuApp createMenuApp(){

        // esto es un patron Simple Factory, se encarga de crear los objetos necesarios para la aplicacion, y devolver un objeto MenuApp con todos los objetos necesarios para la aplicacion,
        // esto es para evitar tener que crear los objetos en el main, y tener
        // todo el codigo de creacion de objetos en un solo lugar, y asi poder cambiar la implementacion de los objetos sin tener que cambiar el codigo del main,
        //  por ejemplo si queremos cambiar la implementacion de CustomerServiceImpl por otra implementacion, solo tenemos que cambiar el codigo de esta clase,
        //  y no tenemos que cambiar el codigo del main, esto es una buena practica de programacion, ya que nos permite tener un codigo mas limpio y mantenible.

        Admin admin = new Admin();

        Connection connection = DataBaseConnection.getInstance().getConnection();
        CustomerRowMapper rowMapperCustomer = new CustomerRowMapper();
        CategoryRowMapper rowMapperCategory = new CategoryRowMapper();
        ProductRowMapper rowMapperProduct = new ProductRowMapper();

        ProductPersistencePort productPersistencePort = new ProductRepositoryDB(connection, rowMapperProduct);
        ProductUseCase productService = new ProductInputAdapter(productPersistencePort);
        ProductView productView = new ProductView(productService);

        CategoryPersistencePort categoryRepositoryDB = new CategoryRepositoryDB(connection, rowMapperCategory);
        CategoryUseCase categoryService = new CategoryInputAdapter(categoryRepositoryDB);
        CategoryView categoryView = new CategoryView(categoryService);

        CustomerPersistencePort customerRepository = new CustomerRepository();
        CustomerPersistencePort customerRepositoryDB = new CustomerRepositoryDB(connection, rowMapperCustomer);
        CustumerService customerService = new CustumerServiceImpl(customerRepositoryDB);
        CustomerView customerView = new CustomerView( customerService);

        CustumerAdminService custumerAdminService = new AdminServiceImpl(admin, customerRepositoryDB);
        AdminService adminServiceImpl = new AdminServiceImpl(admin,customerRepositoryDB);
        AdminView adminView = new AdminView(adminServiceImpl, admin,custumerAdminService);


        return new MenuApp(customerView, adminView,categoryView, productView);

    }










}
