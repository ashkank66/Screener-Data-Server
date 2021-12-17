package com.ashkSoft.enums;

public enum IndEnum {

    RSI(0),MACD(1),MA(2),ST(3);

    private int code;

    IndEnum(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
