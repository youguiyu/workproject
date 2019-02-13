package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.WlwLinkMax;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwLinkMaxMapper {
    List<WlwLinkMax> findMaxData(Integer yesDate);
}
