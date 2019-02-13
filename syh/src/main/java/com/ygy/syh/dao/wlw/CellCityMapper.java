package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.CellCity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CellCityMapper {
    List<CellCity> getCellCityByDate(Integer dateId);
    List<CellCity> getCellCityByCityName(String cityName);
    //List<CellCity> getCellCityByDateAndCityName(Map<Integer,String> map);
}
