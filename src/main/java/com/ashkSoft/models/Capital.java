//package com.ashkSoft.models;
//
//import com.ashkSoft.enums.DataListType;
//import com.ashkSoft.enums.DirectionEnum;
//
//public abstract class Capital extends Index {
//
//    private Index firstPosition;
//    public DataListType type;
//    private String subject;
//    private int capitalId;
//
//
//    public Capital(int capitalId, String subject) {
//        this.capitalId = capitalId;
//        this.subject = subject;
//    }
//
//    public void setDirection(DirectionEnum direction) {
//        this.DIRECTION = direction;
//    }
//
//    public Index getFirstPosition() {
//        return firstPosition;
//    }
//
//    public void setFirstPosition(Index firstPosition) {
//        this.firstPosition = firstPosition;
//    }
//
//    public DataListType getType() {
//        return type;
//    }
//
//    public void setType(DataListType type) {
//        this.type = type;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public int getCapitalId() {
//        return capitalId;
//    }
//
//    public void setCapitalId(int capitalId) {
//        this.capitalId = capitalId;
//    }
//
//}
