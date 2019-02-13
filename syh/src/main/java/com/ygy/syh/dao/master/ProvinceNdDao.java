package com.ygy.syh.dao.master;


import com.ygy.syh.domain.ProvinceNd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProvinceNdDao {
    /**
     * 根据十分钟粒度查询全省漫游到宁德人流量
     */
    public List<ProvinceNd> queryBy4GTime(@Param("tableName")String tableName);
    public List<ProvinceNd> queryBy2GTime(@Param("tableName")String tableName);
}
