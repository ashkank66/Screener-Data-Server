package com.ashkSoft.models;

import com.ashkSoft.enums.IndEnum;

import java.math.BigDecimal;
import java.util.TreeMap;

public class IndTree {

    TreeMap<BigDecimal, InsCodes> rbTree;
    IndEnum ind;

    public IndTree(IndEnum ind) {
        this.ind = ind;
        rbTree = new TreeMap<>();
    }

    public TreeMap<BigDecimal, InsCodes> getRbTree() {
        return rbTree;
    }

    public void setRbTree(TreeMap<BigDecimal, InsCodes> rbTree) {
        this.rbTree = rbTree;
    }

    public IndEnum getInd() {
        return ind;
    }

    public void setInd(IndEnum ind) {
        this.ind = ind;
    }
}
