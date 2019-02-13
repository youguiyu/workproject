package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.WlwLinkApn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwLinkApnMapper {


    List<WlwLinkApn> findWlwLinkApnByDate(Integer yesDate);
}
