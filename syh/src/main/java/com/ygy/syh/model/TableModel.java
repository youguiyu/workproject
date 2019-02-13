package com.ygy.syh.model;

import java.math.BigDecimal;

public class TableModel implements Comparable<TableModel>{
    private String cityName;
    private Integer cityId;
    private BigDecimal ZbAttachSuc;
    private Integer ZcAttachSuc;

    public Integer getCityId() {
        return cityId;
    }
    @Override
    public int compareTo(TableModel t){
        return t.getCityId().compareTo(this.getCityId());
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    private BigDecimal ZbAttachDelay;
    private Integer ZcAttachDelay;
    private BigDecimal ZbEpsSuc;
    private Integer ZcEpsSuc;
    private BigDecimal ZbEpsDelay;
    private Integer ZcEpsDelay;
    private BigDecimal ZbDnsSuc;
    private Integer ZcDnsSuc;
    private BigDecimal ZbDnsDelay;
    private Integer ZcDnsDelay;
    private BigDecimal ZbTcpHxSuc;
    private Integer ZcTcpHxSuc;
    private BigDecimal ZbTcpHxDelay;
    private Integer ZcTcpHxDelay;
    private BigDecimal ZbTcpWxSuc;
    private Integer ZcTcpwxSuc;
    private BigDecimal ZbTcpWxDelay;
    private Integer ZcTcpWxDelay;
    private BigDecimal ZbHttpSuc;
    private Integer ZcHttpSuc;
    private BigDecimal ZbHttpDelay;
    private Integer ZcHttpDelay;
    private BigDecimal ZbHttpLoad;
    private Integer ZcHttpLoad;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public BigDecimal getZbAttachSuc() {
        return ZbAttachSuc;
    }

    public void setZbAttachSuc(BigDecimal zbAttachSuc) {
        ZbAttachSuc = zbAttachSuc;
    }

    public Integer getZcAttachSuc() {
        return ZcAttachSuc;
    }

    public void setZcAttachSuc(Integer zcAttachSuc) {
        ZcAttachSuc = zcAttachSuc;
    }

    public BigDecimal getZbAttachDelay() {
        return ZbAttachDelay;
    }

    public void setZbAttachDelay(BigDecimal zbAttachDelay) {
        ZbAttachDelay = zbAttachDelay;
    }

    public Integer getZcAttachDelay() {
        return ZcAttachDelay;
    }

    public void setZcAttachDelay(Integer zcAttachDelay) {
        ZcAttachDelay = zcAttachDelay;
    }

    public BigDecimal getZbEpsSuc() {
        return ZbEpsSuc;
    }

    public void setZbEpsSuc(BigDecimal zbEpsSuc) {
        ZbEpsSuc = zbEpsSuc;
    }

    public Integer getZcEpsSuc() {
        return ZcEpsSuc;
    }

    public void setZcEpsSuc(Integer zcEpsSuc) {
        ZcEpsSuc = zcEpsSuc;
    }

    public BigDecimal getZbEpsDelay() {
        return ZbEpsDelay;
    }

    public void setZbEpsDelay(BigDecimal zbEpsDelay) {
        ZbEpsDelay = zbEpsDelay;
    }

    public Integer getZcEpsDelay() {
        return ZcEpsDelay;
    }

    public void setZcEpsDelay(Integer zcEpsDelay) {
        ZcEpsDelay = zcEpsDelay;
    }

    public BigDecimal getZbDnsSuc() {
        return ZbDnsSuc;
    }

    public void setZbDnsSuc(BigDecimal zbDnsSuc) {
        ZbDnsSuc = zbDnsSuc;
    }

    public Integer getZcDnsSuc() {
        return ZcDnsSuc;
    }

    public void setZcDnsSuc(Integer zcDnsSuc) {
        ZcDnsSuc = zcDnsSuc;
    }

    public BigDecimal getZbDnsDelay() {
        return ZbDnsDelay;
    }

    public void setZbDnsDelay(BigDecimal zbDnsDelay) {
        ZbDnsDelay = zbDnsDelay;
    }

    public Integer getZcDnsDelay() {
        return ZcDnsDelay;
    }

    public void setZcDnsDelay(Integer zcDnsDelay) {
        ZcDnsDelay = zcDnsDelay;
    }

    public BigDecimal getZbTcpHxSuc() {
        return ZbTcpHxSuc;
    }

    public void setZbTcpHxSuc(BigDecimal zbTcpHxSuc) {
        ZbTcpHxSuc = zbTcpHxSuc;
    }

    public Integer getZcTcpHxSuc() {
        return ZcTcpHxSuc;
    }

    public void setZcTcpHxSuc(Integer zcTcpHxSuc) {
        ZcTcpHxSuc = zcTcpHxSuc;
    }

    public BigDecimal getZbTcpHxDelay() {
        return ZbTcpHxDelay;
    }

    public void setZbTcpHxDelay(BigDecimal zbTcpHxDelay) {
        ZbTcpHxDelay = zbTcpHxDelay;
    }

    public Integer getZcTcpHxDelay() {
        return ZcTcpHxDelay;
    }

    public void setZcTcpHxDelay(Integer zcTcpHxDelay) {
        ZcTcpHxDelay = zcTcpHxDelay;
    }

    public BigDecimal getZbTcpWxSuc() {
        return ZbTcpWxSuc;
    }

    public void setZbTcpWxSuc(BigDecimal zbTcpWxSuc) {
        ZbTcpWxSuc = zbTcpWxSuc;
    }

    public Integer getZcTcpwxSuc() {
        return ZcTcpwxSuc;
    }

    public void setZcTcpwxSuc(Integer zcTcpwxSuc) {
        ZcTcpwxSuc = zcTcpwxSuc;
    }

    public BigDecimal getZbTcpWxDelay() {
        return ZbTcpWxDelay;
    }

    public void setZbTcpWxDelay(BigDecimal zbTcpWxDelay) {
        ZbTcpWxDelay = zbTcpWxDelay;
    }

    public Integer getZcTcpWxDelay() {
        return ZcTcpWxDelay;
    }

    public void setZcTcpWxDelay(Integer zcTcpWxDelay) {
        ZcTcpWxDelay = zcTcpWxDelay;
    }

    public BigDecimal getZbHttpSuc() {
        return ZbHttpSuc;
    }

    public void setZbHttpSuc(BigDecimal zbHttpSuc) {
        ZbHttpSuc = zbHttpSuc;
    }

    public Integer getZcHttpSuc() {
        return ZcHttpSuc;
    }

    public void setZcHttpSuc(Integer zcHttpSuc) {
        ZcHttpSuc = zcHttpSuc;
    }

    public BigDecimal getZbHttpDelay() {
        return ZbHttpDelay;
    }

    public void setZbHttpDelay(BigDecimal zbHttpDelay) {
        ZbHttpDelay = zbHttpDelay;
    }

    public Integer getZcHttpDelay() {
        return ZcHttpDelay;
    }

    public void setZcHttpDelay(Integer zcHttpDelay) {
        ZcHttpDelay = zcHttpDelay;
    }

    public BigDecimal getZbHttpLoad() {
        return ZbHttpLoad;
    }

    public void setZbHttpLoad(BigDecimal zbHttpLoad) {
        ZbHttpLoad = zbHttpLoad;
    }

    public Integer getZcHttpLoad() {
        return ZcHttpLoad;
    }

    public void setZcHttpLoad(Integer zcHttpLoad) {
        ZcHttpLoad = zcHttpLoad;
    }
}
