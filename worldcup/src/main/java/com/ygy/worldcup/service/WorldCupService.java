package com.ygy.worldcup.service;

import com.ygy.worldcup.domain.VideoQs;

import java.util.List;
import java.util.Map;

public interface WorldCupService {

    List<Map<String,Object>> getNowData();
    Map<String,Object> getHisData(int temp);
}
