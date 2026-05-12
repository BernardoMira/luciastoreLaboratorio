package storeapp.infraestructure.in.view;

import storeapp.domain.enums.CategoryStateEnum;
import storeapp.infraestructure.in.utils.FormValidator;
import storeapp.services.CategoryStateSelector;
import storeapp.services.input.CategoryUseCase;

public class CategoryView {

    private final CategoryUseCase categoryUseCase;

    public CategoryView(CategoryUseCase categoryUseCase){
        this.categoryUseCase = categoryUseCase;
    }

    public void createCategory(){

        String description = FormValidator.validateString("Ingrese la descripción de la categoría: ");
        String status = CategoryStateSelector.CategoryState();

        categoryUseCase.createCategory(description, status);


    }



}
