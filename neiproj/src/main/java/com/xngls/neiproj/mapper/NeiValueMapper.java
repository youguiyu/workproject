package com.xngls.neiproj.mapper;


import com.xngls.neiproj.entity.NeiValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface NeiValueMapper {
    int insert(NeiValue record);
    int insertData(List<NeiValue> list);

    int insertSelective(NeiValue record);

    List<Map<String, Object>> getReportBydDate(@Param("firstDate") Integer firstDate ,@Param("lastDate") Integer lastDate ,@Param("business_type")  String business_type);
    List<Map<String, Object>> getReportAllBydDate(@Param("firstDate") Integer firstDate ,@Param("lastDate") Integer lastDate);
    List<Map<String, Object>> getAllBydDate(@Param("firstDate") Integer firstDate ,@Param("lastDate") Integer lastDate);
}