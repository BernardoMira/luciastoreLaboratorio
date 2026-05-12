package storeapp.domain.enums;

public enum CustomerTypeEnum {

    NUEVO ("Cliente Nuevo"),
    ANTIGUO ("Antiguo"),
    CASTIGADO ("Castigado"),
    EN_MORA ("En Mora");

    private final String description;

    CustomerTypeEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
