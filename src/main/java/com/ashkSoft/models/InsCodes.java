package com.ashkSoft.models;

import com.ashkSoft.enums.IndEnum;
import com.ashkSoft.enums.InsEnum;

import java.util.ArrayList;
import java.util.List;

public class InsCodes {

    private List<Integer> insCodes;

    public InsCodes(InsEnum ins){
        insCodes = new ArrayList<>();
        insCodes.add(ins.getCode());
    }

    public List<Integer> getIndices() {
        return insCodes;
    }

    public void setIndices(List<Integer> insCodes) {
        this.insCodes = insCodes;
    }

    public void addIndices(List<Integer> insCodes) {
        this.insCodes.addAll(insCodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int index : insCodes)
            sb.append(index).append(" ** ");
        return "IndexWrapper{" +
                "insCodes=" + sb.toString() +
                '}';
    }
}

//    private String Ind;
//    private String Ins;
//    private SuperNode up, down, left, right;
//    private BigDecimal value;
//    private int position;
//    public DirectionEnum DIRECTION;
//    private InsCapitalEnum instrument;
//
//    public SuperNode() {
//    }
//
//    public void setNext(DirectionEnum direction, SuperNode node){
//        switch (direction){
//            case UP:
//                setUp(node);
//                break;
//            case DOWN:
//                setDown(node);
//                break;
//            case LEFT:
//                setLeft(node);
//                break;
//            case RIGHT:
//            default:
//                setRight(node);
//        }
//    }
//
//    public SuperNode getNext(DirectionEnum direction){
//        switch (direction){
//            case UP:
//                return getUp();
//            case DOWN:
//                return getDown();
//            case LEFT:
//                return getLeft();
//            case RIGHT:
//            default:
//                return getRight();
//        }
//    }
//
//    public SuperNode getNext(){
//        return getNext(DIRECTION);
//    }
//
//    public void setNext(SuperNode node){
//        setNext(DIRECTION,node);
//    }
//
//    public SuperNode(BigDecimal value, InsCapitalEnum instrument){
//        this.value = value;
//        this.instrument = instrument;
//    }
//
//    public boolean hasNextInd(){
//        return right!=null;
//    }
//
//    public boolean hasNextIns(){
//        return down!=null;
//    }
//
//    public String getInd() {
//        return Ind;
//    }
//
//    public void setInd(String ind) {
//        Ind = ind;
//    }
//
//    public String getIns() {
//        return Ins;
//    }
//
//    public void setIns(String ins) {
//        Ins = ins;
//    }
//
//    public SuperNode getUp() {
//        return up;
//    }
//
//    public void setUp(SuperNode up) {
//        this.up = up;
//    }
//
//    public SuperNode getDown() {
//        return down;
//    }
//
//    public void setDown(SuperNode down) {
//        this.down = down;
//    }
//
//    public SuperNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(SuperNode left) {
//        this.left = left;
//    }
//
//    public SuperNode getRight() {
//        return right;
//    }
//
//    public void setRight(SuperNode right) {
//        this.right = right;
//    }
//
//    public BigDecimal getValue() {
//        return value;
//    }
//
//    public void setValue(BigDecimal value) {
//        this.value = value;
//    }
//
//    public int getPosition() {
//        return position;
//    }
//
//    public void setPosition(int position) {
//        this.position = position;
//    }
//
//    public InsCapitalEnum getInstrument() {
//        return instrument;
//    }
//
//    public void setInstrument(InsCapitalEnum instrument) {
//        this.instrument = instrument;
//    }