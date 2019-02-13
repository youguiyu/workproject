package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.WlwKeyApn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwKeyApnMapper {
    List<WlwKeyApn> findWlwKeyApnsByDate(Integer yesDate);
}
