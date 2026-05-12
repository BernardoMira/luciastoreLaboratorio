package storeapp.domain.enums;

public enum CustomerState {

    ACTIVE("true"),
    INACTIVE("false");


    private final String description;

    CustomerState(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


}
