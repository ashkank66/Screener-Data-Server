package com.ashkSoft.managers;

import com.ashkSoft.enums.IndEnum;
import com.ashkSoft.enums.InsEnum;
import com.ashkSoft.models.*;

import java.math.BigDecimal;
import java.util.*;

public class PuppetMaster {

    private List<TreeMap<BigDecimal, InsCodes>> indTrees;
    private List<List<BigDecimal>> dataSet;

    public PuppetMaster() {
        dataSet = new ArrayList<>();
        indTrees = new ArrayList<>();
        populateTrees();
        tempFillData();
        printWholeTreeData();
        getRequiredMap();
    }

    private void populateTrees() {
        for (int i = 0; i < IndEnum.values().length; i++) {
            TreeMap<BigDecimal, InsCodes> indTree = new TreeMap<>();
            indTrees.add(indTree);
        }
    }

    public void addIndDataToTrees(BigDecimal data, InsEnum ins, IndEnum ind) {
        indTrees.get(ind.getCode()).getRbTree().put(data, new InsCodes(ins));

    }

    private void tempFillData() {
        InsEnum[] inss = InsEnum.values();
        IndEnum[] inds = IndEnum.values();
        BigDecimal[] dataList = new BigDecimal[]{
                new BigDecimal("12"),
                new BigDecimal("3"),
                new BigDecimal("6"),
                new BigDecimal("25"),
                new BigDecimal("5"),
                new BigDecimal("0"),
                new BigDecimal("10"),
                new BigDecimal("83"),
                new BigDecimal("63"),
                new BigDecimal("84"),
                new BigDecimal("38"),
                new BigDecimal("42"),
                new BigDecimal("88"),
                new BigDecimal("32"),
                new BigDecimal("44.4"),
                new BigDecimal("88"),
        };
        int i = 0;
        for (IndEnum ind : inds) {
            for (InsEnum ins : inss) {
                InsCodes insCodes = new InsCodes(ins);
                TreeMap<BigDecimal, InsCodes> rbTree = indTrees.get(ind.getCode()).getRbTree();
                InsCodes possibleIndex = rbTree.get(dataList[i]);
                if (possibleIndex != null) {
                    insCodes.addIndices(possibleIndex.getIndices());
                }
                rbTree.put(dataList[i], insCodes);
                i++;
            }
        }

    }

    private void printWholeTreeData() {

        for (int i = 0; i < 4; i++) {
            IndTree indTree = indTrees.get(i);
            Iterator<BigDecimal> iterator = indTree.getRbTree().descendingKeySet().descendingIterator();
            while (iterator.hasNext()) {
                BigDecimal next = iterator.next();
                InsCodes insCodes = indTree.getRbTree().get(next);
                List<Integer> list = insCodes.getIndices();
                for (int index : list)
                    System.out.println(next + " -> " + index);
            }
        }
    }

    public List<Integer> filterIndTreeMap(Operate operate) {
        TreeMap<BigDecimal,InsCodes> indTree = indTrees.get(operate.getInd());
        BigDecimal value1 = new BigDecimal(operate.getValue1());
        BigDecimal value2;
        switch (operate.getOperator()){
            case 0:
                return getInsList(indTree.subMap(value1,false,indTree.lastKey(),true).values());
            case 1:
                return getInsList(indTree.subMap(value1,true,indTree.lastKey(),true).values());
            case 2:
                return getInsList(indTree.subMap(indTree.firstKey(),true,value1,false).values());
            case 3:
                //TODO operate value might not be present in treeMap
                return getInsList(indTree.subMap(indTree.firstKey(),true,value1,true).values());
            case 4:
                value2 = new BigDecimal(operate.getValue2());
                return getInsList(indTree.subMap(value1,true,value2,true).values());
            case 5:
                value2 = new BigDecimal(operate.getValue2());
                Collection<InsCodes> insList = indTree.subMap(indTree.firstKey(),true,value1,true).values();
                insList.addAll(indTree.subMap(value2, true, indTree.lastKey(), true).values());
                return getInsList(insList);
            case 6:
                return indTree.get(value1).getIndices();
            case 7:
                indTree.remove(value1);
                return getInsList(indTree.values());
        }

    }

    public void getRequiredMap() {
        System.out.println("*********");
        SortedMap<BigDecimal, InsCodes> bigDecimalIndexWrapperSortedMap = filterIndTreeMap(new BigDecimal("44.4"), IndEnum.ST);
        Iterator<Map.Entry<BigDecimal, InsCodes>> iterator = bigDecimalIndexWrapperSortedMap.entrySet().iterator();
//        for (BigDecimal big : bigDecimalIndexWrapperSortedMap.keySet()){
//
//        }
        System.out.println(bigDecimalIndexWrapperSortedMap);
//        while(iterator.hasNext()){
//            Map.Entry<BigDecimal, IndexWrapper> next = iterator.next();
//            List<int[]> indices = next.getValue().getIndices();
//            for (int[] index : indices)
//                System.out.println(next.getKey() + " -> " + index[0] + " " + index[1]);
//        }

    }

    public OutputData getRequestedData(InputFilter filter) {
        //TODO decide were should this line be, cause it take 800 inss long list
        List<Integer> sortedInss = getSortedInss(filter.getSortFilter());
        List<List<Integer>> filteredInss = new ArrayList<>();
        for (Operate operate : filter.getOperates()){
            filteredInss.add(filterIndTreeMap(operate));
        }
    }

    private List<Integer> getSortedInss(SortFilter filter) {
        TreeMap indTree = indTrees.get(filter.getInd());
        Collection<InsCodes> values;
        if (filter.isAscending())
            values = indTree.values();
        else {
            NavigableMap navigableMap = indTree.descendingMap();
            values = navigableMap.values();
        }
        return getInsList(values);

    }

    private List<Integer> getInsList(Collection<InsCodes> values){
        List<Integer> result = new ArrayList<>();

        for (InsCodes value : values) {
            result.addAll(value.getIndices());
        }

        return result;
    }
}


//    List<IndCapital> indCapitals;
////    List<InsCapital> insCapitals;
////    Map<IndCapitalEnum,Integer> indMap;
////    Map<InsCapitalEnum,InsCapital> insMap;
////
////    public PuppetMaster() {
////        initilize();
////    }

//    private void initilize() {
//        indCapitals = new ArrayList<>();
//        insCapitals = new ArrayList<>();
//        indMap = new HashMap<>();
//        insMap = new HashMap<>();
//        temporaryFillCapitalsList();
//        init();
//        printData();
//    }
//
//    private void temporaryFillCapitalsList() {
//        IndCapital newCapital = new IndCapital(0,"RSI");
//        indMap.put(IndCapitalEnum.RSI,0);
//        IndCapital newCapital2 = new IndCapital(1,"MACD");
//        indMap.put(IndCapitalEnum.MACD,1);
//        IndCapital newCapital3 = new IndCapital(2,"MA");
//        indMap.put(IndCapitalEnum.MA,2);
//        IndCapital newCapital4 = new IndCapital(3,"ST");
//        indMap.put(IndCapitalEnum.ST,3);
//        indCapitals.add(newCapital);
//        indCapitals.add(newCapital2);
//        indCapitals.add(newCapital3);
//        indCapitals.add(newCapital4);
//        InsCapital neewCapital = new InsCapital(0,"ZOB");
//        insMap.put(InsCapitalEnum.ZOB,neewCapital);
//        InsCapital neewCapital2 = new InsCapital(1,"SAP");
//        insMap.put(InsCapitalEnum.SAP,neewCapital2);
//        InsCapital neewCapital3 = new InsCapital(2,"KHOD");
//        insMap.put(InsCapitalEnum.KHOD,neewCapital3);
//        InsCapital neewCapital4 = new InsCapital(3,"SHET");
//        insMap.put(InsCapitalEnum.SHET,neewCapital4);
//        insCapitals.add(neewCapital);
//        insCapitals.add(neewCapital2);
//        insCapitals.add(neewCapital3);
//        insCapitals.add(neewCapital4);
//
//    }
//
//    private void addNodeToDataset(BigDecimal value, InsCapitalEnum insCapitalEnum, IndCapitalEnum indCapitalEnum){
//        SuperNode node = new SuperNode(value,insCapitalEnum);
//        SuperNode row = insMap.get(insCapitalEnum);
//        while (row.hasNextInd())
//            row = row.getRight();
//        row.setRight(node);
//        node.setLeft(row);
//        SuperNode column = indCapitals.get(indMap.get(indCapitalEnum));
//        while (column.hasNextIns())
//            column = column.getDown();
//        column.setDown(node);
//        node.setUp(column);
//    }
//
//    private void init(){
//        addNodeToDataset(new BigDecimal("12"),InsCapitalEnum.ZOB,IndCapitalEnum.RSI);
//        addNodeToDataset(new BigDecimal("9"),InsCapitalEnum.ZOB,IndCapitalEnum.MACD);
//        addNodeToDataset(new BigDecimal("15"),InsCapitalEnum.ZOB,IndCapitalEnum.MA);
//        addNodeToDataset(new BigDecimal("3"),InsCapitalEnum.ZOB,IndCapitalEnum.ST);
//        addNodeToDataset(new BigDecimal("3"),InsCapitalEnum.SAP,IndCapitalEnum.RSI);
//        addNodeToDataset(new BigDecimal("9"),InsCapitalEnum.SAP,IndCapitalEnum.MACD);
//        addNodeToDataset(new BigDecimal("12"),InsCapitalEnum.SAP,IndCapitalEnum.MA);
//        addNodeToDataset(new BigDecimal("4"),InsCapitalEnum.SAP,IndCapitalEnum.ST);
//        addNodeToDataset(new BigDecimal("8"),InsCapitalEnum.KHOD,IndCapitalEnum.RSI);
//        addNodeToDataset(new BigDecimal("3"),InsCapitalEnum.KHOD,IndCapitalEnum.MACD);
//        addNodeToDataset(new BigDecimal("7"),InsCapitalEnum.KHOD,IndCapitalEnum.MA);
//        addNodeToDataset(new BigDecimal("12"),InsCapitalEnum.KHOD,IndCapitalEnum.ST);
//        addNodeToDataset(new BigDecimal("10"),InsCapitalEnum.SHET,IndCapitalEnum.RSI);
//        addNodeToDataset(new BigDecimal("6"),InsCapitalEnum.SHET,IndCapitalEnum.MACD);
//        addNodeToDataset(new BigDecimal("5"),InsCapitalEnum.SHET,IndCapitalEnum.MA);
//        addNodeToDataset(new BigDecimal("8"),InsCapitalEnum.SHET,IndCapitalEnum.ST);
//    }
//
//    MergeModule mergeModule = new MergeModule();
//
//    private void printData(){
//        printing(insMap.get(InsCapitalEnum.ZOB));
//        printing(insMap.get(InsCapitalEnum.SAP));
//        printing(insMap.get(InsCapitalEnum.KHOD));
//        printing(insMap.get(InsCapitalEnum.SHET));
////        System.out.println("**********************");
//        SuperNode down = indCapitals.get(0).getDown();
//        SuperNode down1 = indCapitals.get(1).getDown();
//        SuperNode down2 = indCapitals.get(2).getDown();
//        SuperNode down3 = indCapitals.get(3).getDown();
//        down.DIRECTION = DirectionEnum.DOWN;
//        down1.DIRECTION = DirectionEnum.DOWN;
//        down2.DIRECTION = DirectionEnum.DOWN;
//        down3.DIRECTION = DirectionEnum.DOWN;
//        SuperNode result = mergeModule.mergeSort(down);
//        result.DIRECTION = DirectionEnum.DOWN;
//        List<InsCapitalEnum> sort = getSort(result);
//        for (InsCapitalEnum ins : sort)
//            System.out.println(ins);
////        System.out.println();
////        SuperNode result1 = mergeModule.mergeSort(down1);
////        SuperNode result2 = mergeModule.mergeSort(down2);
////        SuperNode result3 = mergeModule.mergeSort(down3);
////        printing2(result);
////        printing2(result1);
////        printing2(result2);
////        printing2(result3);
////        printing2(indCapitals.get(1));
////        printing2(indCapitals.get(2));
////        printing2(indCapitals.get(3));
//        printSortedWholeDataSet(sort);
//    }
//
//    private void printing(Capital capital){
////        in
//        SuperNode insNode = capital.getRight();
//        System.out.print(insNode.getValue()+"\t");
//        while (insNode.hasNextInd()) {
//            insNode = insNode.getRight();
//            System.out.print(insNode.getValue()+"\t");
//        }
//        System.out.println();
//    }
//
//    private void printing2(SuperNode insNode){
////        SuperNode insNode = node.getDown();
//        System.out.print(insNode.getValue()+"\t");
//        while (insNode.hasNextIns()) {
//            insNode = insNode.getDown();
//            System.out.print(insNode.getValue()+"\t");
//        }
//        System.out.println();
//    }
//
//    private List<InsCapitalEnum> getSort(SuperNode firstNode){
//        List<InsCapitalEnum> sortedList = new ArrayList<>();
//        while (firstNode!=null) {
//            sortedList.add(firstNode.getInstrument());
//            firstNode = firstNode.getNext();
//        }
//        return sortedList;
//    }
//
//    private void printSortedWholeDataSet(List<InsCapitalEnum> sortedInstruments){
//        StringBuilder sb = new StringBuilder();
//        for (InsCapitalEnum instrument: sortedInstruments){
//            sb.append(instrument).append("\t");
//            SuperNode ind = insMap.get(instrument).getRight();
//            while (ind!=null) {
//                sb.append(ind.getValue()).append("\t");
//                ind = ind.getNext(DirectionEnum.RIGHT);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb.toString());
//    }

