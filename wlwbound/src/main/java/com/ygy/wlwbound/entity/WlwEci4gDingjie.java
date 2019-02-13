package com.ygy.wlwbound.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class WlwEci4gDingjie implements Serializable {

    private Integer date_id;
    private String city_name;
    private String county_name;
    private String cell_name;
    private String honeycomb_type;
    private String vendor_name;
    private String ws_name;
    private long eci;
    private BigDecimal attach_suc_rate;
    private Integer attach_count;
    private BigDecimal attach_suc_rate_reference;
    private Integer attach_count_reference;
    private BigDecimal attach_succ_rate_4g;
    private BigDecimal attach_cnt_4g;
    private String model_name;
    private String model_desc;
    private long user_count_s1mme_model;
    private long attach_count_model;
    private BigDecimal attach_suc_rate_model;
    private String apn;
    private String name;
    private long user_count_s1mme_apn;
    private long attach_count_apn;
    private BigDecimal attach_suc_rate_apn;

    private  String result_flag;

    private Integer attach_suc_rate_reference_flag;
    private Integer terminal_s1mme_flag;
    private Integer attach_suc_rate_4g_flag;
    private Integer apn_s1mme_flag;

    public Integer getAttach_suc_rate_reference_flag() {
        return attach_suc_rate_reference_flag;
    }

    public void setAttach_suc_rate_reference_flag(Integer attach_suc_rate_reference_flag) {
        this.attach_suc_rate_reference_flag = attach_suc_rate_reference_flag;
    }

    public Integer getTerminal_s1mme_flag() {
        return terminal_s1mme_flag;
    }

    public void setTerminal_s1mme_flag(Integer terminal_s1mme_flag) {
        this.terminal_s1mme_flag = terminal_s1mme_flag;
    }

    public Integer getAttach_suc_rate_4g_flag() {
        return attach_suc_rate_4g_flag;
    }

    public void setAttach_suc_rate_4g_flag(Integer attach_suc_rate_4g_flag) {
        this.attach_suc_rate_4g_flag = attach_suc_rate_4g_flag;
    }

    public Integer getApn_s1mme_flag() {
        return apn_s1mme_flag;
    }

    public void setApn_s1mme_flag(Integer apn_s1mme_flag) {
        this.apn_s1mme_flag = apn_s1mme_flag;
    }

    public Integer getAttach_count() {
        return attach_count;
    }

    public void setAttach_count(Integer attach_count) {
        this.attach_count = attach_count;
    }

    public Integer getAttach_count_reference() {
        return attach_count_reference;
    }

    public void setAttach_count_reference(Integer attach_count_reference) {
        this.attach_count_reference = attach_count_reference;
    }

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

    public String getCell_name() {
        return cell_name;
    }

    public void setCell_name(String cell_name) {
        this.cell_name = cell_name;
    }

    public String getHoneycomb_type() {
        return honeycomb_type;
    }

    public void setHoneycomb_type(String honeycomb_type) {
        this.honeycomb_type = honeycomb_type;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getWs_name() {
        return ws_name;
    }

    public void setWs_name(String ws_name) {
        this.ws_name = ws_name;
    }

    public long getEci() {
        return eci;
    }

    public void setEci(long eci) {
        this.eci = eci;
    }

    public BigDecimal getAttach_suc_rate() {
        return attach_suc_rate;
    }

    public void setAttach_suc_rate(BigDecimal attach_suc_rate) {
        this.attach_suc_rate = attach_suc_rate;
    }

    public BigDecimal getAttach_suc_rate_reference() {
        return attach_suc_rate_reference;
    }

    public void setAttach_suc_rate_reference(BigDecimal attach_suc_rate_reference) {
        this.attach_suc_rate_reference = attach_suc_rate_reference;
    }

    public BigDecimal getAttach_succ_rate_4g() {
        return attach_succ_rate_4g;
    }

    public void setAttach_succ_rate_4g(BigDecimal attach_succ_rate_4g) {
        this.attach_succ_rate_4g = attach_succ_rate_4g;
    }

    public BigDecimal getAttach_cnt_4g() {
        return attach_cnt_4g;
    }

    public void setAttach_cnt_4g(BigDecimal attach_cnt_4g) {
        this.attach_cnt_4g = attach_cnt_4g;
    }

    public String getResult_flag() {
        return result_flag;
    }

    public void setResult_flag(String result_flag) {
        this.result_flag = result_flag;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_desc() {
        return model_desc;
    }

    public void setModel_desc(String model_desc) {
        this.model_desc = model_desc;
    }

    public long getUser_count_s1mme_model() {
        return user_count_s1mme_model;
    }

    public void setUser_count_s1mme_model(long user_count_s1mme_model) {
        this.user_count_s1mme_model = user_count_s1mme_model;
    }

    public long getAttach_count_model() {
        return attach_count_model;
    }

    public void setAttach_count_model(long attach_count_model) {
        this.attach_count_model = attach_count_model;
    }

    public BigDecimal getAttach_suc_rate_model() {
        return attach_suc_rate_model;
    }

    public void setAttach_suc_rate_model(BigDecimal attach_suc_rate_model) {
        this.attach_suc_rate_model = attach_suc_rate_model;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUser_count_s1mme_apn() {
        return user_count_s1mme_apn;
    }

    public void setUser_count_s1mme_apn(long user_count_s1mme_apn) {
        this.user_count_s1mme_apn = user_count_s1mme_apn;
    }

    public long getAttach_count_apn() {
        return attach_count_apn;
    }

    public void setAttach_count_apn(long attach_count_apn) {
        this.attach_count_apn = attach_count_apn;
    }

    public BigDecimal getAttach_suc_rate_apn() {
        return attach_suc_rate_apn;
    }

    public void setAttach_suc_rate_apn(BigDecimal attach_suc_rate_apn) {
        this.attach_suc_rate_apn = attach_suc_rate_apn;
    }
}
