package storeapp.services.port;

import storeapp.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerPersistencePort {

    Customer saveCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(int id);
    Customer updateCustomer(int id, Customer customer);
    void deleteCustomer(int id);

}
