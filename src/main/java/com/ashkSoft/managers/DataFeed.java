package com.ashkSoft.managers;

import com.ashkSoft.enums.IndEnum;
import com.ashkSoft.enums.InsEnum;
import com.ashkSoft.models.InsCodes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DataFeed {

    BigDecimal[][] mainDataSet;
    List<TreeMap<BigDecimal, InsCodes>> indTrees;

    public DataFeed() {
        mainDataSet = new BigDecimal[InsEnum.values().length][IndEnum.values().length];
        indTrees = new ArrayList<>();
        populateIndList();
    }

    private void populateIndList() {
        IndEnum[] inds = IndEnum.values();
        for (int i = 0 ; i < inds.length ; i++){
            indTrees.add(new TreeMap<>());
        }
    }

    public void addNode(BigDecimal value, InsEnum ins , IndEnum ind){
        addNodeToMainDataset(value,ins,ind);
        addNodeToIndTrees(value,ins,ind);
    }

    private void addNodeToMainDataset(BigDecimal value, InsEnum ins , IndEnum ind){
        mainDataSet[ins.getCode()][ind.getCode()] = value;
    }

    private void addNodeToIndTrees(BigDecimal value, InsEnum ins , IndEnum ind){
        InsCodes currentInsCodes = new InsCodes(ins);
        TreeMap<BigDecimal, InsCodes> indTree = indTrees.get(ind.getCode());
        InsCodes possibleInsCode = indTree.get(value);
        if (possibleInsCode != null){
            currentInsCodes.addIndices(possibleInsCode.getIndices());
        }
        indTree.put(value, currentInsCodes);
//        indTrees.get(ind.getCode()).put(value,new InsCodes(ins));
    }
}
