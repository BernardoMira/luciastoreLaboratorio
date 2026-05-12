package storeapp.infraestructure.out.adapters;

import storeapp.domain.Category;
import storeapp.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {


    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product("Laptop", 999.99,50,true, new Category("Electronics", "Disponible")),
                    new Product("Laptop", 999.99,50,true, new Category("Electronics", "Disponible"))

            )
    );



}
