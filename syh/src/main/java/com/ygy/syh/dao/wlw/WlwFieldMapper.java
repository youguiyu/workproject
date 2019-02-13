package com.ygy.syh.dao.wlw;

import com.ygy.syh.domain.wlw.WlwField;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface WlwFieldMapper {
    List<WlwField> findWlwFieldByWeek(Map<String, Object> map);

    List<WlwField> findWlwFieldByWeekand(Map<String, Object> map);
}
