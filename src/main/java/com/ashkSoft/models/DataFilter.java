package com.ashkSoft.models;

import java.math.BigDecimal;

public class DataFilter {

    private int indCode;
    private int operatorCode;
    private BigDecimal value;

    public DataFilter(int indCode, int operatorCode, BigDecimal value) {
        this.indCode = indCode;
        this.operatorCode = operatorCode;
        this.value = value;
    }

    public int getIndCode() {
        return indCode;
    }

    public void setIndCode(int indCode) {
        this.indCode = indCode;
    }

    public int getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(int operatorCode) {
        this.operatorCode = operatorCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
