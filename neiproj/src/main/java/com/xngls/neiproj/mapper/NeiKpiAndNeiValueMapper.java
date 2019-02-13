package com.xngls.neiproj.mapper;

import com.github.pagehelper.Page;
import com.xngls.neiproj.entity.NeiKpiAndNeiValue;
import com.xngls.neiproj.entity.NeiKpiViewTotal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface NeiKpiAndNeiValueMapper {

    List<NeiKpiAndNeiValue> selectDataBytiaojian(Map<String ,Object> map);

    List<NeiKpiAndNeiValue> findqushiData(Map<String, Object> map1);

    List<NeiKpiAndNeiValue> selectDataBytiaojian2(Map<String, Object> map1);

    List<NeiKpiAndNeiValue> findqushiData2(Map<String, Object> map1);

    List<NeiKpiViewTotal> findqushiData2Time(Map<String, Object> map1);


    List<NeiKpiAndNeiValue> puanduanshifouyoushuju(Map<String, Object> map);

    Boolean updateKpiValue(Map<String,Object>map);

    int insertNeiValue(Map<String, Object> map);

    List<NeiKpiAndNeiValue> selectNeiValuesByTimeRange(Map<String, Integer> timeRange);
}
