package com.ashkSoft.enums;

public enum InsEnum {

    ZOB(0),SAP(1),KHOD(2),SHET(3);

    private int code;

    InsEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
