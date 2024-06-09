package enums;

public enum OrderEnum {
    BEFORE("BEFORE"),
    AFTER("AFTER");

    private String value;

    public String getValue() {
        return value;
    }

    OrderEnum(String val) {
        this.value = val;
    }
}
