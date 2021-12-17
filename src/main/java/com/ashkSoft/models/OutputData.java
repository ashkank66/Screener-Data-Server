package com.ashkSoft.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OutputData implements Serializable {

    List<List<BigDecimal>> outputData;

    public OutputData(List<List<BigDecimal>> outputData) {
        this.outputData = outputData;
    }

    public List<List<BigDecimal>> getOutputData() {
        return outputData;
    }

    public void setOutputData(List<List<BigDecimal>> outputData) {
        this.outputData = outputData;
    }
}
