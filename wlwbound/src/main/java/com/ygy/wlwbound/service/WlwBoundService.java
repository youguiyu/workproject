package com.ygy.wlwbound.service;

import com.ygy.wlwbound.entity.*;
import com.ygy.wlwbound.model.PageModel;
import com.ygy.wlwbound.model.WlwApnDingjieModel;

import java.util.List;
import java.util.Map;

public interface WlwBoundService {
    List<WlwApnDingjieModel> findByPage(int time);

    Integer getTime();

    List<WlwApnDingjieModel> findByPage2(PageModel p);

    List<WlwApnUsercountDingjie> getApnxiangxqingData(String apn, Integer dateId, String type);

    List<WlwApnFlowDingjie> getApnxiangxqingflowData(String apn, int dateId, String type);

    List<WlwApnAttachDingjie> getApnxiangxqingattachData(String apn, int dateId, String type);

    List<WlwApnPdpDingjie> getApnxiangxqingpdpData(String apn, int dateId, String type);

    List<Map<String, String>> getWarnApns(int temp);

    List<WlwEciDingjie> get4GTableData(PageModel pageModel);

    Integer getZhichaTime();

    List<WlwEciPdpDingjie> get2GTableData(PageModel pageModel);

    WlwEci4gDingjie getZhicha4gData(int dateId, String cityName, long eci);

    WlwEciPdp2gDingjie getZhicha2gData(int parseInt, String cityName, int parseLong, int parseLong1);
}
