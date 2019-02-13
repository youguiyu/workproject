package com.ygy.syh.domain.wlw;

import java.math.BigDecimal;

public class AppCell {
    private String CITY_NAME;
    private String DATE_ID;
    private String KPI_NAME;
    private String TERMINAL_App_Name;
    private String Cell_Name;
    private BigDecimal KPI_VALUE;
    private Integer KPI_COUNT;
    private Integer IMSI_NUM;
    private BigDecimal IMSI_BAD_RATE;

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public String getDATE_ID() {
        return DATE_ID;
    }

    public void setDATE_ID(String DATE_ID) {
        this.DATE_ID = DATE_ID;
    }

    public String getKPI_NAME() {
        return KPI_NAME;
    }

    public void setKPI_NAME(String KPI_NAME) {
        this.KPI_NAME = KPI_NAME;
    }

    public String getTERMINAL_App_Name() {
        return TERMINAL_App_Name;
    }

    public void setTERMINAL_App_Name(String TERMINAL_App_Name) {
        this.TERMINAL_App_Name = TERMINAL_App_Name;
    }

    public String getCell_Name() {
        return Cell_Name;
    }

    public void setCell_Name(String cell_Name) {
        Cell_Name = cell_Name;
    }

    public BigDecimal getKPI_VALUE() {
        return KPI_VALUE;
    }

    public void setKPI_VALUE(BigDecimal KPI_VALUE) {
        this.KPI_VALUE = KPI_VALUE;
    }

    public Integer getKPI_COUNT() {
        return KPI_COUNT;
    }

    public void setKPI_COUNT(Integer KPI_COUNT) {
        this.KPI_COUNT = KPI_COUNT;
    }

    public Integer getIMSI_NUM() {
        return IMSI_NUM;
    }

    public void setIMSI_NUM(Integer IMSI_NUM) {
        this.IMSI_NUM = IMSI_NUM;
    }

    public BigDecimal getIMSI_BAD_RATE() {
        return IMSI_BAD_RATE;
    }

    public void setIMSI_BAD_RATE(BigDecimal IMSI_BAD_RATE) {
        this.IMSI_BAD_RATE = IMSI_BAD_RATE;
    }
}
