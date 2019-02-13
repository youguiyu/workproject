package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.FWywjQs;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface FWywjQsMapper {
    List<FWywjQs> getFWywjQsByDate(Integer dateId);
    List<FWywjQs> geFWywjQsByCityName(String cityName);
   List<FWywjQs> getFWywjQsByDateAndVenderName(Map<String, Object> map);

    List<FWywjQs> getFWywjQsByliduaAndzhibiao(Map<String, Object> map);
}
