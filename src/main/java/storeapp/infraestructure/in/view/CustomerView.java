package storeapp.infraestructure.in.view;

import storeapp.domain.Customer;
import storeapp.services.CustomerTypeSelector;
import storeapp.services.input.CustumerService;
import storeapp.infraestructure.in.utils.FormValidator;

import java.util.List;

public class CustomerView {

    private final CustumerService customerService;


    public CustomerView(CustumerService customerService){
        this.customerService = customerService;
    }

    public void createCustomer(){

        int id = FormValidator.validateInt("Ingrese id cliente: ");
        String name = FormValidator.validateString("Ingrese nombre cliente: ");
        String lastName = FormValidator.validateString("Ingrese apellido cliente: ");
        String email = FormValidator.validateString("Ingrese email cliente: ");
        String password = FormValidator.validateString("Ingrese password cliente: ");
        boolean status = FormValidator.validateBoolean("Ingrese estado cliente: 1. Activo 2. Inactivo ");
        double quote = FormValidator.validateDouble("Ingrese cupo cliente: ");
        String customerType = CustomerTypeSelector.customerTypeSelector();

        customerService.createCustomer(id, name, lastName, email, password, status, quote, customerType);

    }

    public void getCustumerById() {
        System.out.println("Buscar cliente por id");
        int id_customer = FormValidator.validateInt("Ingrese el Id a Buscar");
        Customer customer = customerService.getCustomerById(id_customer).orElseThrow();
        System.out.println("Cliente encontrado: " + customer.getName() + " " + customer.getLastName());
    }


    public void updateCustomer(){

        customerService.updateCustomer(FormValidator.validateInt("Ingrese id cliente: "));
    }





}
