package com.ygy.syh.domain;

import java.io.Serializable;

public class ProvinceNd implements Serializable{

    private String userCity;
    private String cityName;
    private Integer userCount;


    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
