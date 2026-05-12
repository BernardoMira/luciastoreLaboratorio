package storeapp.services;

import org.w3c.dom.ls.LSOutput;
import storeapp.domain.enums.CustomerState;
import storeapp.infraestructure.in.utils.FormValidator;

public class CustomerStateSelector {


    public static String customerStateSelector() {
        int option = FormValidator.validateInt("Seleccione el estado del cliente: \n1. Activo\n2. Inactivo\n3. Suspendido\n4. Eliminado\nOpción: ");
        String state = "";
        switch (option) {
            case 1:
                state = CustomerState.ACTIVE.getDescription();
                break;
            case 2:
                state = CustomerState.INACTIVE.getDescription();
                break;
            default:
                System.out.println("Opción no válida, por favor seleccione una opción válida.");
                return customerStateSelector();
        }
        return state;
    }

}
