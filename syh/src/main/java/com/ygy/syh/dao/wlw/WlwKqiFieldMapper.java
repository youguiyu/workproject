package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.WlwKqiField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwKqiFieldMapper {
    List<WlwKqiField> findzuoyouData(Integer yesDate);
}
