package com.ygy.wlwbound.entity;

import java.math.BigDecimal;

public class WlwApnAttachDingjie {

    private String apn;
    private Integer date_id;
    private String name;
    private String type;


    private BigDecimal attach_suc_rate;//*100

    private BigDecimal attach_line;



    private BigDecimal pdp_line;
    private Long attach_count;
    private Long attach_count_reference;
    private BigDecimal attach_count_rate;

    private Integer attach_count_flag;


    private BigDecimal  attach_succ_rate_today;
    private BigDecimal attach_succ_rate_yes;

    private String attach_suc_rate_dingjie_conclusion;


    private BigDecimal attach_count_others_rate;
    private Integer  attach_suc_others_rate_flag;

    private BigDecimal attach_suc_ratio;

    private  Integer attach_suc_rate_flag;

    private BigDecimal mme_attach_succ_rate_bad;
    private BigDecimal mme_attach_succ_rate_bad_ratio;
    private Integer mme_attach_succ_rate_flag;

    private String model_name_bad;

    private String model_desc_bad;

    private Integer user_count_model_bad;
    private BigDecimal model_attach_suc_rate_bad;
    private BigDecimal model_attach_suc_rate_bad_ratio;

    private String model_name_good;
    private String model_desc_good;

    private Integer user_count_model_good;

    private BigDecimal model_attach_suc_rate_good;
    private BigDecimal model_attach_suc_rate_good_ratio;
    private Integer model_flag;



    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public Integer getDate_id() {
        return date_id;
    }

    public void setDate_id(Integer date_id) {
        this.date_id = date_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAttach_suc_rate() {
        return attach_suc_rate;
    }

    public void setAttach_suc_rate(BigDecimal attach_suc_rate) {
        this.attach_suc_rate = attach_suc_rate;
    }

    public BigDecimal getAttach_line() {
        return attach_line;
    }

    public void setAttach_line(BigDecimal attach_line) {
        this.attach_line = attach_line;
    }

    public BigDecimal getPdp_line() {
        return pdp_line;
    }

    public void setPdp_line(BigDecimal pdp_line) {
        this.pdp_line = pdp_line;
    }

    public Long getAttach_count() {
        return attach_count;
    }

    public void setAttach_count(Long attach_count) {
        this.attach_count = attach_count;
    }

    public Long getAttach_count_reference() {
        return attach_count_reference;
    }

    public void setAttach_count_reference(Long attach_count_reference) {
        this.attach_count_reference = attach_count_reference;
    }

    public BigDecimal getAttach_count_rate() {
        return attach_count_rate;
    }

    public void setAttach_count_rate(BigDecimal attach_count_rate) {
        this.attach_count_rate = attach_count_rate;
    }

    public BigDecimal getAttach_succ_rate_today() {
        return attach_succ_rate_today;
    }

    public void setAttach_succ_rate_today(BigDecimal attach_succ_rate_today) {
        this.attach_succ_rate_today = attach_succ_rate_today;
    }

    public BigDecimal getAttach_succ_rate_yes() {
        return attach_succ_rate_yes;
    }

    public void setAttach_succ_rate_yes(BigDecimal attach_succ_rate_yes) {
        this.attach_succ_rate_yes = attach_succ_rate_yes;
    }

    public String getAttach_suc_rate_dingjie_conclusion() {
        return attach_suc_rate_dingjie_conclusion;
    }

    public void setAttach_suc_rate_dingjie_conclusion(String attach_suc_rate_dingjie_conclusion) {
        this.attach_suc_rate_dingjie_conclusion = attach_suc_rate_dingjie_conclusion;
    }

    public Integer getAttach_count_flag() {
        return attach_count_flag;
    }

    public void setAttach_count_flag(Integer attach_count_flag) {
        this.attach_count_flag = attach_count_flag;
    }

    public BigDecimal getAttach_count_others_rate() {
        return attach_count_others_rate;
    }

    public void setAttach_count_others_rate(BigDecimal attach_count_others_rate) {
        this.attach_count_others_rate = attach_count_others_rate;
    }

    public Integer getAttach_suc_others_rate_flag() {
        return attach_suc_others_rate_flag;
    }

    public void setAttach_suc_others_rate_flag(Integer attach_suc_others_rate_flag) {
        this.attach_suc_others_rate_flag = attach_suc_others_rate_flag;
    }

    public BigDecimal getAttach_suc_ratio() {
        return attach_suc_ratio;
    }

    public void setAttach_suc_ratio(BigDecimal attach_suc_ratio) {
        this.attach_suc_ratio = attach_suc_ratio;
    }

    public Integer getAttach_suc_rate_flag() {
        return attach_suc_rate_flag;
    }

    public void setAttach_suc_rate_flag(Integer attach_suc_rate_flag) {
        this.attach_suc_rate_flag = attach_suc_rate_flag;
    }

    public BigDecimal getMme_attach_succ_rate_bad() {
        return mme_attach_succ_rate_bad;
    }

    public void setMme_attach_succ_rate_bad(BigDecimal mme_attach_succ_rate_bad) {
        this.mme_attach_succ_rate_bad = mme_attach_succ_rate_bad;
    }

    public BigDecimal getMme_attach_succ_rate_bad_ratio() {
        return mme_attach_succ_rate_bad_ratio;
    }

    public void setMme_attach_succ_rate_bad_ratio(BigDecimal mme_attach_succ_rate_bad_ratio) {
        this.mme_attach_succ_rate_bad_ratio = mme_attach_succ_rate_bad_ratio;
    }

    public Integer getMme_attach_succ_rate_flag() {
        return mme_attach_succ_rate_flag;
    }

    public void setMme_attach_succ_rate_flag(Integer mme_attach_succ_rate_flag) {
        this.mme_attach_succ_rate_flag = mme_attach_succ_rate_flag;
    }

    public String getModel_name_bad() {
        return model_name_bad;
    }

    public void setModel_name_bad(String model_name_bad) {
        this.model_name_bad = model_name_bad;
    }

    public String getModel_desc_bad() {
        return model_desc_bad;
    }

    public void setModel_desc_bad(String model_desc_bad) {
        this.model_desc_bad = model_desc_bad;
    }

    public Integer getUser_count_model_bad() {
        return user_count_model_bad;
    }

    public void setUser_count_model_bad(Integer user_count_model_bad) {
        this.user_count_model_bad = user_count_model_bad;
    }

    public BigDecimal getModel_attach_suc_rate_bad() {
        return model_attach_suc_rate_bad;
    }

    public void setModel_attach_suc_rate_bad(BigDecimal model_attach_suc_rate_bad) {
        this.model_attach_suc_rate_bad = model_attach_suc_rate_bad;
    }

    public BigDecimal getModel_attach_suc_rate_bad_ratio() {
        return model_attach_suc_rate_bad_ratio;
    }

    public void setModel_attach_suc_rate_bad_ratio(BigDecimal model_attach_suc_rate_bad_ratio) {
        this.model_attach_suc_rate_bad_ratio = model_attach_suc_rate_bad_ratio;
    }

    public String getModel_name_good() {
        return model_name_good;
    }

    public void setModel_name_good(String model_name_good) {
        this.model_name_good = model_name_good;
    }

    public String getModel_desc_good() {
        return model_desc_good;
    }

    public void setModel_desc_good(String model_desc_good) {
        this.model_desc_good = model_desc_good;
    }

    public Integer getUser_count_model_good() {
        return user_count_model_good;
    }

    public void setUser_count_model_good(Integer user_count_model_good) {
        this.user_count_model_good = user_count_model_good;
    }

    public BigDecimal getModel_attach_suc_rate_good() {
        return model_attach_suc_rate_good;
    }

    public void setModel_attach_suc_rate_good(BigDecimal model_attach_suc_rate_good) {
        this.model_attach_suc_rate_good = model_attach_suc_rate_good;
    }

    public BigDecimal getModel_attach_suc_rate_good_ratio() {
        return model_attach_suc_rate_good_ratio;
    }

    public void setModel_attach_suc_rate_good_ratio(BigDecimal model_attach_suc_rate_good_ratio) {
        this.model_attach_suc_rate_good_ratio = model_attach_suc_rate_good_ratio;
    }

    public Integer getModel_flag() {
        return model_flag;
    }

    public void setModel_flag(Integer model_flag) {
        this.model_flag = model_flag;
    }
}
