package com.xngls.neiproj.mapper;

import com.xngls.neiproj.entity.NeiKpiView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface NeiKpiViewMapper {
    List<NeiKpiView> findNeiKpiViewByTiao(Map<String,Object> map);

    List<NeiKpiView> findNeiKpiViewByTiao2(Map<String, Object> map);
    List<NeiKpiView> findNeiKpiViewByTiao3(Map<String, Object> map);
    List<NeiKpiView> findNeiKpiViewByTiao4(Map<String, Object> map);

}
