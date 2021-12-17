package com.ashkSoft.enums;

public enum OperatorEnum {

    ABOVE(0),
    ABOVE_EQUAL(1),
    BELOW(2),
    BELOW_EQUAL(3),
    BETWEEN(4),
    OUTSIDE(5),
    EQUAL(6),
    NOT_EQUAL(7);

    private int code;

    OperatorEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
