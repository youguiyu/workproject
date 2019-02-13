package com.ygy.worldcup.dao;

import com.ygy.worldcup.domain.VideoQs;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface VideoQsDao {
    List<VideoQs> findAll();
    List<VideoQs> findlastTimeData();
    List<VideoQs> getAllTime(Map<String , Object> map);
    List<VideoQs> getAllHisData(Map<String , Object> map);
    String getMaxTime();
 }
