package storeapp.services;

import storeapp.domain.enums.CustomerTypeEnum;
import storeapp.infraestructure.in.utils.FormValidator;

public class CustomerTypeSelector {

    public static String customerTypeSelector() {

        System.out.println("Seleccione el tipo de cliente");

        System.out.println("1.Nuevo 2. Antiguo 3. Castigado 4. En Mora");
        String value;
        int selection = FormValidator.validateInt("Opcion");
        switch (selection) {
            case 1:
                value = (CustomerTypeEnum.NUEVO.getDescription());
                break;
            case 2:
                value = (CustomerTypeEnum.ANTIGUO.getDescription());
                break;
            default:
                value = "Seleccione una opcion valida";
                break;
        }

        return value;
    }

}
