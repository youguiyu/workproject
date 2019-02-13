package com.ygy.syh.service.wlw;

import java.util.List;
import java.util.Map;

public interface WlwService {

    Map<String,Object> getZuoDaData(String temp);
    List<Map<String,Object>> getZuoDaLineData();

    Map<String,Object> getZuoyouData(String temp);

    Map<String,Object> getZuoQiangData(String temp);
}
