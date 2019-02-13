package com.ygy.syh.service;

import com.ygy.syh.domain.ChinaNd;
import com.ygy.syh.domain.ProvinceNd;
import com.ygy.syh.domain.Video;
import java.util.List;
import java.util.Map;


public interface SyhService {
    Map<String,Object> getChina4GToNdData();
    List<ChinaNd> getChina2GToNdData();

    List<ProvinceNd> getProvince2GToNdData();

    Map<String,Object> getProvince4GToNdData();

    Map<String,Object> getFengjinquData();

    List<Integer> getJiudianData();

    List<Map<String,Object>> getBisaichangdiData();

    List<Map<String,Object>> getZdData();

    Map<String,Object> getTopData();

    Map<String,Object> getVideoTopData();

    Map<String,Object> getVideoCdData();


    List<Video> getVideoZdqyData();
}
