package com.ashkSoft.models;

public class SortFilter {

    private int ind;
    private boolean ascending;

    public SortFilter(int ind, boolean ascending) {
        this.ind = ind;
        this.ascending = ascending;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
