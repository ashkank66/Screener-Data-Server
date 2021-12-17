package com.ashkSoft.models;

public class Operate {

    private String value1;
    private String value2;
    private int operator;
    private int ind;


    public Operate(String value1, int operator, int ind) {
        this.value1 = value1;
        this.operator = operator;
        this.ind = ind;
    }

    public Operate(String value1, String value2, int operator, int ind) {
        this.value1 = value1;
        this.value2 = value2;
        this.operator = operator;
        this.ind = ind;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }
}
