package storeapp.userinterface;

import storeapp.infraestructure.in.utils.FormValidator;
import storeapp.infraestructure.in.view.*;

import java.sql.SQLOutput;

public class MenuApp {



    private final CustomerView customerView;
    private final AdminView adminView;
    private final CategoryView categoryView;
    private final ProductView productView;
    private final OrderView orderView;

    public MenuApp(CustomerView customerView, AdminView adminView, CategoryView categoryView,ProductView productView, OrderView orderView) {
        this.customerView = customerView;
        this.adminView = adminView;
        this.categoryView = categoryView;
        this.productView = productView;
        this.orderView = orderView;
    }

    public void showMainMenu(){

        System.out.println("Bienvenido a la tienda online");


        int init = FormValidator.validateInt("Presione 1 para iniciar la aplicacion");


        while(init != 0){

            System.out.println("Selecione 1. Registrar Usuario 2. Iniciar Sesion 3. Salir");
            int option = FormValidator.validateInt("Seleccione una opcion");


            switch (option){
                case 1:
                    System.out.println("Registrar Usuario");
                    System.out.println("1. Cliente 2. Administrador");
                    int userType = FormValidator.validateInt("Seleccione el tipo de usuario");

                    if (userType == 1){
                        customerView.createCustomer();
                    }else if(userType == 2){
                        adminView.createAdmin();
                    }else{
                        System.out.println("Opcion no valida, por favor seleccione una opcion valida");
                    }

                    break;
                case 2:
                    System.out.println("Iniciar Sesion");
                    String profile = profileSelector();
                    menuApplication(true, profile);
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }


    public String profileSelector(){

      String value = "";
        while (true){
            System.out.println("Seleccione su perfil 1. Administrador 2. Cliente");
            int option = FormValidator.validateInt("Opcion");


            switch (option){
                case 1:
                    value = "admin";
                    break;
                case 2:
                    value = "customer";
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
            if (!value.isEmpty()){
                break;
            }
        }
        return value;
    }


    public void menuApplication(boolean authenticated, String profile){

        while(authenticated){

                if(profile.equals("admin")){
                    showMenuAdmin();
                }else if(profile.equals("customer")){
                    boolean runMenu = true;
                    showMenuCustomer(runMenu);
                }else{
                    System.out.println("Perfil no reconocido, por favor seleccione un perfil valido");
                }

        }

    }


    public void showMenuAdmin(){

        while (true){
            System.out.println("Menu Administrador");
            System.out.println("1. Gestionar Productos 2. Gestionar Categorias 3. Gestionar Clientes 4. Gestionar Ordenes 5. Salir");
            int option = FormValidator.validateInt("Seleccione una opcion");


            switch (option){
                case 1:
                    System.out.println("Gestionar Productos");
                    showMenuProducts();
                    break;
                case 2:
                    System.out.println("Gestionar Categorias");
                    showMenuCategories();
                    break;
                case 3:
                    System.out.println("Gestionar Clientes");
                    boolean runMenu = true;
                    customerMenuAdmin();
                    break;
                case 4:
                    System.out.println("Gestionar Ordenes");
                    showMenuOrders();
                    break;
                case 5:
                    System.out.println("Saliendo del menu de administrador");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }


    public void showMenuCustomer(boolean runMenu){

        System.out.println("Menu Cliente");
        while (runMenu) {

            System.out.println("1. Crear mi perfil 2. Ver mi perfil por id 3. Modifica mi perfil 4. Volver al menu anterior");

            int option = FormValidator.validateInt("Seleccione una opcion");
            switch (option) {
                case 1:
                    System.out.println("Crear mi perfil");
                    customerView.createCustomer();
                    break;
                case 2:
                    System.out.println("Ver mi  perfil");
                    customerView.getCustumerById();
                    break;
                case 3:
                    System.out.println("Modificar mi perfil");
                    customerView.updateCustomer();
                    break;
                case 4:
                    System.out.println("Cerrando la sesion y volviendo al menu anterior");
                    showMainMenu();
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }

    public void showMenuCategories(){
        System.out.println("Menu Categorias");
        while (true) {
            System.out.println("1. Crear Categoria 2. Ver categoria por id 3. Modificar categoria 4. Ver categorias 5. Eliminar categoria 6. Volver al menu anterior");
            int option = FormValidator.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    System.out.println("Crear categoria");
                    categoryView.createCategory();
                    break;
                case 2:
                    System.out.println("Ver categoria por id");
                    int id = FormValidator.validateInt("Ingrese el id de la categoria a buscar");
                    //categoryView.getCategoryById(id);
                    break;
                case 3:
                    System.out.println("Modificar categoria");
                    //categoryView.updateCategory();
                    break;
                case 4:
                    System.out.println("Ver categorias");
                    //categoryView.getAllCategories();
                    break;
                case 5:
                    System.out.println("Eliminar categoria");
                    int idDelete = FormValidator.validateInt("Ingrese el id de la categoria a eliminar");
                    //categoryView.deleteCategoryById(idDelete);
                    break;
                case 6:
                    System.out.println("Volviendo al menu anterior");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }


    public void showMenuProducts(){

        System.out.println("Menu Productos");
        while (true) {
            System.out.println("1. Crear Producto 2. Ver Producto por id 3. Modificar Producto 4. Ver productos 5. Eliminar producto 6. Volver al menu anterior");
            int option = FormValidator.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    System.out.println("Crear Producto");
                    productView.createProduct();
                    break;
                case 2:
                    System.out.println("Ver Producto por id");
                    int id = FormValidator.validateInt("Ingrese el id del Producto a buscar");
                    //categoryView.getCategoryById(id);
                    break;
                case 3:
                    System.out.println("Modificar producto");
                    //categoryView.updateCategory();
                    break;
                case 4:
                    System.out.println("Ver productos");
                    //categoryView.getAllCategories();
                    break;
                case 5:
                    System.out.println("Eliminar producto");
                    int idDelete = FormValidator.validateInt("Ingrese el id de la categoria a eliminar");
                    //categoryView.deleteCategoryById(idDelete);
                    break;
                case 6:
                    System.out.println("Volviendo al menu anterior");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }


    public void showMenuOrders(){

        System.out.println("Menu Ordenes");
        while (true) {
            System.out.println("1. Crear Orden 2. Ver Orden por id 3. Modificar Orden 4. Ver ordenes 5. Eliminar orden 6. Volver al menu anterior");
            int option = FormValidator.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    System.out.println("Crear Orden");
                    orderView.createOrder();
                    break;
                case 2:
                    System.out.println("Ver Orden por id");
                    orderView.getOrderById();
                    break;
                case 3:
                    System.out.println("Modificar orden");
                    //categoryView.updateCategory();
                    break;
                case 4:
                    System.out.println("Ver ordenes");
                    //categoryView.getAllCategories();
                    break;
                case 5:
                    System.out.println("Eliminar orden");
                    int idDelete = FormValidator.validateInt("Ingrese el id de la categoria a eliminar");
                    //categoryView.deleteCategoryById(idDelete);
                    break;
                case 6:
                    System.out.println("Volviendo al menu anterior");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }


    public void customerMenuAdmin(){

        System.out.println("Menu Cliente");
        while (true) {

            System.out.println("1. Crear Perfil Cliente 2. Ver perfil por id 3. Modifica perfil 4. Ver perfiles 5. eliminar Perfil 6.Volver al menu anterior");

            int option = FormValidator.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    System.out.println("Crear perfil");
                    customerView.createCustomer();
                    break;
                case 2:
                    System.out.println("Ver perfil por id");
                    System.out.println("Buscar perfil");
                    customerView.getCustumerById();
                    break;
                case 3:
                    System.out.println("Modificar perfil");
                    customerView.updateCustomer();
                    break;
                case 4:
                    System.out.println("Ver perfiles");
                    adminView.getAllCustomers();
                    break;
                case 5:
                    System.out.println("Eliminar perfil");
                    int idDelete = FormValidator.validateInt("Ingrese el id del perfil a eliminar");
                    adminView.deleteCustomerById(idDelete);
                    break;
                case 6:
                    System.out.println("Volviendo al menu anterior");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }
}
