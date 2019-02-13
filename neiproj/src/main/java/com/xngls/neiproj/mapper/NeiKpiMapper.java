package com.xngls.neiproj.mapper;



import com.xngls.neiproj.entity.NeiKpi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface NeiKpiMapper {
    int insert(NeiKpi record);

    int insertSelective(NeiKpi record);
    List<NeiKpi> getList();

    NeiKpi findNeiKpiByKpiInfo(String kpiInfo);

    List<NeiKpi> findXiangqingData(Map<String, Object> map);

    List<NeiKpi> getKpiAllInfo(String serarchText);
    List<NeiKpi> getKpiAllInfotemp();

    List<NeiKpi> findNeiKpiByKpiName(String kpiName);

    List<NeiKpi> findNeiKpiByKpiInfo2(String kpiInfo);

    List<NeiKpi> getKpiAllInfotemp1();

    List<NeiKpi> getKpiAllInfo1(String serarchText);
}