package com.fragnostic.playground.glue;

public class SomeAccesors {

    private String fieldOne;
    private String fieldTwo;

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    @Override
    public String toString() {
        return String.format("%s %s", fieldOne, fieldTwo);
    }
}
