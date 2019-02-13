package com.xngls.neiproj.mapper;

import com.xngls.neiproj.entity.KpiModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface KpiModeMapper {
    List<KpiModel> findeKpiByTimeRange(Map<String,Integer> map);
}
