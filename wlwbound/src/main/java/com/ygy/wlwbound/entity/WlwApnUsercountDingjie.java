package com.ygy.wlwbound.entity;

import java.math.BigDecimal;

public class WlwApnUsercountDingjie {

    private String apn;
    private Integer date_id;
    private String name;
    private String type;
    private Long user_count;
    private Long user_count_reference;

    private BigDecimal user_count_rate;//*100

    private BigDecimal attach_suc_rate;//*100

    private BigDecimal attach_line;
    private BigDecimal pdp_line;

    private BigDecimal per_user_flow_kb;

    private BigDecimal  per_user_flow_kb_reference;


    private BigDecimal per_user_flow_kb_rate;//*100

    private Long imsi_cnt_today;///10000

    private Long imsi_cnt_yes;///10000


    private String user_count_dingjie_conclusion;

    private Long user_count_others;
    private Long user_count_reference_others;
    private BigDecimal user_count_others_rate;
    private BigDecimal attach_suc_ratio;
    private Integer  user_count_flag;
    private  Integer attach_suc_rate_flag;
    private Integer per_user_flow_flag;
    private  Integer  user_count_others_flag;

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

    public Integer getDate_id() {
        return date_id;
    }

    public void setDate_id(Integer date_id) {
        this.date_id = date_id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUser_count() {
        return user_count;
    }

    public void setUser_count(Long user_count) {
        this.user_count = user_count;
    }

    public Long getUser_count_reference() {
        return user_count_reference;
    }

    public void setUser_count_reference(Long user_count_reference) {
        this.user_count_reference = user_count_reference;
    }

    public BigDecimal getUser_count_rate() {
        return user_count_rate;
    }

    public void setUser_count_rate(BigDecimal user_count_rate) {
        this.user_count_rate = user_count_rate;
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

    public BigDecimal getPer_user_flow_kb() {
        return per_user_flow_kb;
    }

    public void setPer_user_flow_kb(BigDecimal per_user_flow_kb) {
        this.per_user_flow_kb = per_user_flow_kb;
    }

    public BigDecimal getPer_user_flow_kb_reference() {
        return per_user_flow_kb_reference;
    }

    public void setPer_user_flow_kb_reference(BigDecimal per_user_flow_kb_reference) {
        this.per_user_flow_kb_reference = per_user_flow_kb_reference;
    }

    public BigDecimal getPer_user_flow_kb_rate() {
        return per_user_flow_kb_rate;
    }

    public void setPer_user_flow_kb_rate(BigDecimal per_user_flow_kb_rate) {
        this.per_user_flow_kb_rate = per_user_flow_kb_rate;
    }

    public Long getImsi_cnt_today() {
        return imsi_cnt_today;
    }

    public void setImsi_cnt_today(Long imsi_cnt_today) {
        this.imsi_cnt_today = imsi_cnt_today;
    }

    public Long getImsi_cnt_yes() {
        return imsi_cnt_yes;
    }

    public void setImsi_cnt_yes(Long imsi_cnt_yes) {
        this.imsi_cnt_yes = imsi_cnt_yes;
    }

    public String getUser_count_dingjie_conclusion() {
        return user_count_dingjie_conclusion;
    }

    public void setUser_count_dingjie_conclusion(String user_count_dingjie_conclusion) {
        this.user_count_dingjie_conclusion = user_count_dingjie_conclusion;
    }

    public Long getUser_count_others() {
        return user_count_others;
    }

    public void setUser_count_others(Long user_count_others) {
        this.user_count_others = user_count_others;
    }

    public Long getUser_count_reference_others() {
        return user_count_reference_others;
    }

    public void setUser_count_reference_others(Long user_count_reference_others) {
        this.user_count_reference_others = user_count_reference_others;
    }

    public BigDecimal getUser_count_others_rate() {
        return user_count_others_rate;
    }

    public void setUser_count_others_rate(BigDecimal user_count_others_rate) {
        this.user_count_others_rate = user_count_others_rate;
    }

    public BigDecimal getAttach_suc_ratio() {
        return attach_suc_ratio;
    }

    public void setAttach_suc_ratio(BigDecimal attach_suc_ratio) {
        this.attach_suc_ratio = attach_suc_ratio;
    }

    public Integer getUser_count_flag() {
        return user_count_flag;
    }

    public void setUser_count_flag(Integer user_count_flag) {
        this.user_count_flag = user_count_flag;
    }

    public Integer getAttach_suc_rate_flag() {
        return attach_suc_rate_flag;
    }

    public void setAttach_suc_rate_flag(Integer attach_suc_rate_flag) {
        this.attach_suc_rate_flag = attach_suc_rate_flag;
    }

    public Integer getPer_user_flow_flag() {
        return per_user_flow_flag;
    }

    public void setPer_user_flow_flag(Integer per_user_flow_flag) {
        this.per_user_flow_flag = per_user_flow_flag;
    }

    public Integer getUser_count_others_flag() {
        return user_count_others_flag;
    }

    public void setUser_count_others_flag(Integer user_count_others_flag) {
        this.user_count_others_flag = user_count_others_flag;
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