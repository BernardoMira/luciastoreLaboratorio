package storeapp.services.input;

import storeapp.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustumerService {

    // Estos metodos abstratos se configuran en el contrato
    public Customer createCustomer(int id, String name, String lastName, String email, String password, boolean status, double quote, String customerType);
    public Optional<Customer> getCustomerById(int id);
    public Optional<Customer> getCustomerByEmail(String email);
    public Customer updateCustomer(int id);




}
