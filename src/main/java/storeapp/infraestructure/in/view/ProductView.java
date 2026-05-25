package storeapp.infraestructure.in.view;

import storeapp.infraestructure.in.utils.FormValidator;
import storeapp.infraestructure.in.view.helpers.ProductStateSelector;
import storeapp.services.input.ProductUseCase;

public class ProductView {


    private final ProductUseCase productUseCase;

    public ProductView(ProductUseCase productUseCase){
        this.productUseCase = productUseCase;
    }

    public void createProduct(){
        System.out.println("Creating product...");

        String description = FormValidator.validateString("Ingrese la descripción del producto: ");
        double price = FormValidator.validateDouble("Ingrese el precio del producto: ");
        int stock = FormValidator.validateInt("Ingrese la cantidad del producto: ");
        boolean status = ProductStateSelector.ProductState();
        int categoryId = FormValidator.validateInt("Ingrese el id de la categoria del producto: ");

        productUseCase.createProduct(description, price, stock, status, categoryId);
    }



}
