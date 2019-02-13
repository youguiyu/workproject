package com.ygy.syh.domain;

import java.io.Serializable;

public class TopCell implements Serializable{

    private String cellName;
    private Integer countNum;

    public String getCellName() {
        return this.cellName.split("-")[1];
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }
}
