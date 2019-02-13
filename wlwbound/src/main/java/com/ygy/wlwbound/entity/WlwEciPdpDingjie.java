package com.ygy.wlwbound.entity;

import java.math.BigDecimal;

public class WlwEciPdpDingjie {
    private Integer date_id;
    private String city_name;
    private String county_name;
    private String towns_name;
    private String cell_name;
    private String out_in_door;
    private String ws_name;
    private long lac;
    private long cid;
    private BigDecimal pdp_suc_rate;
    private Integer pdp_count;
    private BigDecimal pdp_suc_rate_reference;
    private Integer pdp_count_reference;
    private  String result_flag;


    public Integer getDate_id() {
        return date_id;
    }

    public void setDate_id(Integer date_id) {
        this.date_id = date_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public String getTowns_name() {
        return towns_name;
    }

    public void setTowns_name(String towns_name) {
        this.towns_name = towns_name;
    }

    public String getCell_name() {
        return cell_name;
    }

    public void setCell_name(String cell_name) {
        this.cell_name = cell_name;
    }

    public String getOut_in_door() {
        return out_in_door;
    }

    public void setOut_in_door(String out_in_door) {
        this.out_in_door = out_in_door;
    }

    public String getWs_name() {
        return ws_name;
    }

    public void setWs_name(String ws_name) {
        this.ws_name = ws_name;
    }

    public long getLac() {
        return lac;
    }

    public void setLac(long lac) {
        this.lac = lac;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public BigDecimal getPdp_suc_rate() {
        return pdp_suc_rate;
    }

    public void setPdp_suc_rate(BigDecimal pdp_suc_rate) {
        this.pdp_suc_rate = pdp_suc_rate;
    }

    public Integer getPdp_count() {
        return pdp_count;
    }

    public void setPdp_count(Integer pdp_count) {
        this.pdp_count = pdp_count;
    }

    public BigDecimal getPdp_suc_rate_reference() {
        return pdp_suc_rate_reference;
    }

    public void setPdp_suc_rate_reference(BigDecimal pdp_suc_rate_reference) {
        this.pdp_suc_rate_reference = pdp_suc_rate_reference;
    }

    public Integer getPdp_count_reference() {
        return pdp_count_reference;
    }

    public void setPdp_count_reference(Integer pdp_count_reference) {
        this.pdp_count_reference = pdp_count_reference;
    }

    public String getResult_flag() {
        return result_flag;
    }

    public void setResult_flag(String result_flag) {
        this.result_flag = result_flag;
    }
}
