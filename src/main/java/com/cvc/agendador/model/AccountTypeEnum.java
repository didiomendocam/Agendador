package com.cvc.agendador.model;

public enum AccountTypeEnum {
    SAVINGS("SAVINGS"),
    JUDICIAL("JUDICIAL"),
    PHYSICAL("PHYSICAL");

    private String value;

    private AccountTypeEnum(String description) {
        this.setValue(description);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String state) {
        this.value = state;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
