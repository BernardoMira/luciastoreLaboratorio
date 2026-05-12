package storeapp.services.port;

import storeapp.domain.Category;
import storeapp.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPersistencePort {

    Product saveProduct(Product product, Category category);
    Optional<Product> findProductById(int id);
    List<Product> findAllProducts();
    Product updateProduct(Product product, Category category);
    void  deleteProduct(int id);

}
