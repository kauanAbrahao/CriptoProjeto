package com.example.CriptoProjeto.entity.enums;

public enum EnumHighLow {

    HIGH("High", 1),
    LOW("Low", 0);


    private String nameValue;
    private int value;

     EnumHighLow(String nameValue, int value){
        this.nameValue = nameValue;
        this.value = value;
    }

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
