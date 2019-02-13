package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.WlwLinkCmiot;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwLinkCmiotMapper {
    List<WlwLinkCmiot> findGaueData(Integer yesDate);
}
