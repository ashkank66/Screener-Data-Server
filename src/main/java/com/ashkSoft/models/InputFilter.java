package com.ashkSoft.models;

import java.util.List;

public class InputFilter {

    private java.util.List<Integer> inss;
    private SortFilter sortFilter;
    private boolean def;
    private List<Operate> operates;

    public InputFilter(List<Integer> inss, SortFilter sortFilter, boolean def, List<Operate> operates) {
        this.inss = inss;
        this.sortFilter = this.sortFilter;
        this.def = def;
        this.operates = operates;
    }

    public List<Integer> getInss() {
        return inss;
    }

    public void setInss(List<Integer> inss) {
        this.inss = inss;
    }

    public SortFilter getSortFilter() {
        return sortFilter;
    }

    public void setSortFilter(SortFilter sortFilter) {
        this.sortFilter = sortFilter;
    }

    public boolean isDef() {
        return def;
    }

    public void setDef(boolean def) {
        this.def = def;
    }

    public List<Operate> getOperates() {
        return operates;
    }

    public void setOperates(List<Operate> operates) {
        this.operates = operates;
    }
}
