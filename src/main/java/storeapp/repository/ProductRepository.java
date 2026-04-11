package storeapp.repository;

import storeapp.domain.Category;
import storeapp.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {


    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "Laptop", 999.99,50,true, new Category(1, "Electronics", true))

            )
    );



}
