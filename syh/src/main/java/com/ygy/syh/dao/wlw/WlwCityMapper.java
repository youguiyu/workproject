package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.WlwCity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwCityMapper {
    List<WlwCity> findWlwCityByDateId(Integer yesDate);
}
