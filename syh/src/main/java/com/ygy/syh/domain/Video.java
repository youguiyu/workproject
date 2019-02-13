package com.ygy.syh.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Video implements Serializable{

    private String labelCn;
    private Integer dateId;
    private String hourId;
    private BigDecimal totalFlow;
    private long imsiCnt;
    private BigDecimal money;
    private BigDecimal avgthrouputdl;
    private BigDecimal smoothPlayback;

    private BigDecimal succrate;
    private BigDecimal waittime;
    private BigDecimal playDurationrate;
    private BigDecimal pauseCnt;
    private BigDecimal playDurationavg;
    private BigDecimal httpSuc;
    private BigDecimal httpDelay;
    private String maxrate;
    private String bestrate;
    private BigDecimal tag;

    public String getLabelCn() {
        return labelCn;
    }

    public void setLabelCn(String labelCn) {
        this.labelCn = labelCn;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getHourId() {
        return hourId;
    }

    public void setHourId(String hourId) {
        this.hourId = hourId;
    }

    public BigDecimal getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(BigDecimal totalFlow) {
        this.totalFlow = totalFlow;
    }

    public long getImsiCnt() {
        return imsiCnt;
    }

    public void setImsiCnt(long imsiCnt) {
        this.imsiCnt = imsiCnt;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getAvgthrouputdl() {
        return avgthrouputdl;
    }

    public void setAvgthrouputdl(BigDecimal avgthrouputdl) {
        this.avgthrouputdl = avgthrouputdl;
    }

    public BigDecimal getSmoothPlayback() {
        return smoothPlayback;
    }

    public void setSmoothPlayback(BigDecimal smoothPlayback) {
        this.smoothPlayback = smoothPlayback;
    }

    public BigDecimal getSuccrate() {
        return succrate;
    }

    public void setSuccrate(BigDecimal succrate) {
        this.succrate = succrate;
    }

    public BigDecimal getWaittime() {
        return waittime;
    }

    public void setWaittime(BigDecimal waittime) {
        this.waittime = waittime;
    }

    public BigDecimal getPlayDurationrate() {
        return playDurationrate;
    }

    public void setPlayDurationrate(BigDecimal playDurationrate) {
        this.playDurationrate = playDurationrate;
    }

    public BigDecimal getPauseCnt() {
        return pauseCnt;
    }

    public void setPauseCnt(BigDecimal pauseCnt) {
        this.pauseCnt = pauseCnt;
    }

    public BigDecimal getPlayDurationavg() {
        return playDurationavg;
    }

    public void setPlayDurationavg(BigDecimal playDurationavg) {
        this.playDurationavg = playDurationavg;
    }

    public BigDecimal getHttpSuc() {
        return httpSuc;
    }

    public void setHttpSuc(BigDecimal httpSuc) {
        this.httpSuc = httpSuc;
    }

    public BigDecimal getHttpDelay() {
        return httpDelay;
    }

    public void setHttpDelay(BigDecimal httpDelay) {
        this.httpDelay = httpDelay;
    }

    public String getMaxrate() {
        return maxrate;
    }

    public void setMaxrate(String maxrate) {
        this.maxrate = maxrate;
    }

    public String getBestrate() {
        return bestrate;
    }

    public void setBestrate(String bestrate) {
        this.bestrate = bestrate;
    }

    public BigDecimal getTag() {
        return tag;
    }

    public void setTag(BigDecimal tag) {
        this.tag = tag;
    }
}
