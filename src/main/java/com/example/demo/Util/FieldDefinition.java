package com.example.demo.Util;

public class FieldDefinition {

    private String fieldName;
    private int length;
    private boolean isVariableLength;

    public FieldDefinition(String fieldName, int length) {
        this(fieldName, length, false);
    }

    public FieldDefinition(String fieldName, int length, boolean isVariableLength) {
        this.fieldName = fieldName;
        this.length = length;
        this.isVariableLength = isVariableLength;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getLength() {
        return length;
    }

    public boolean isVariableLength() {
        return isVariableLength;
    }

}
