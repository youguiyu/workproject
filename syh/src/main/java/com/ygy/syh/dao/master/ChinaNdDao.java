package com.ygy.syh.dao.master;

import com.ygy.syh.domain.ChinaNd;
import com.ygy.syh.domain.TopCell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ChinaNdDao {
    /**
     * 根据十分钟粒度查询全国漫游到宁德人流量
     */
    public List<ChinaNd> queryBy4GTime(@Param("tableName")String tableName);

    List<ChinaNd> queryBy2GTime(@Param("tableName")String tableName);
    String selectTableByName(@Param("tableName")String tableName);
    Integer selectTms4GUsercount(@Param("tableName")String tableName);
    Integer selectBq4GUsercount(@Param("tableName")String tableName);
    Integer selectBsy4GUsercount(@Param("tableName")String tableName);
    Integer selectCph4GUsercount(@Param("tableName")String tableName);
    Integer selectDss4GUsercount(@Param("tableName")String tableName);
    Integer selectLyx4GUsercount(@Param("tableName")String tableName);

    Integer selectTms2GUsercount(@Param("tableName")String tableName);
    Integer selectBq2GUsercount(@Param("tableName")String tableName);
    Integer selectBsy2GUsercount(@Param("tableName")String tableName);
    Integer selectCph2GUsercount(@Param("tableName")String tableName);
    Integer selectDss2GUsercount(@Param("tableName")String tableName);
    Integer selectLyx2GUsercount(@Param("tableName")String tableName);


    Integer selectWh4GUsercount(@Param("tableName")String tableName);
    Integer selectGj4GUsercount(@Param("tableName")String tableName);
    Integer selectHt4GUsercount(@Param("tableName")String tableName);
    Integer selectJjl4GUsercount(@Param("tableName")String tableName);
    Integer selectHwj4GUsercount(@Param("tableName")String tableName);
    Integer selectMd4GUsercount(@Param("tableName")String tableName);
    Integer selectHedf4GUsercount(@Param("tableName")String tableName);
    Integer selectHedf2GUsercount(@Param("tableName")String tableName);
    Integer selectJhw4GUsercount(@Param("tableName")String tableName);
    Integer selectMl4GUsercount(@Param("tableName")String tableName);
    Integer selectSda4GUsercount(@Param("tableName")String tableName);
    Integer selectWdjh4GUsercount(@Param("tableName")String tableName);
    Integer selectWdjh2GUsercount(@Param("tableName")String tableName);
    Integer selectTwt4GUsercount(@Param("tableName")String tableName);
    Integer selectLqgj4GUsercount(@Param("tableName")String tableName);
    Integer selectLqgj2GUsercount(@Param("tableName")String tableName);
    Integer selectCx4GUsercount(@Param("tableName")String tableName);
    Integer selectDj4GUsercount(@Param("tableName")String tableName);
    Integer selectDh4GUsercount(@Param("tableName")String tableName);
    Integer selectDh2GUsercount(@Param("tableName")String tableName);
    Integer selectJy4GUsercount(@Param("tableName")String tableName);
    Integer selectJy2GUsercount(@Param("tableName")String tableName);
    Integer selectXbg4GUsercount(@Param("tableName")String tableName);
    Integer selectXbg2GUsercount(@Param("tableName")String tableName);





    Integer selectFaat4GUsercount(@Param("tableName")String tableName);
    Integer selectFaat2GUsercount(@Param("tableName")String tableName);
    Integer selectFatyc4GUsercount(@Param("tableName")String tableName);
    Integer selectFatyc2GUsercount(@Param("tableName")String tableName);
    Integer selectFayz4GUsercount(@Param("tableName")String tableName);
    Integer selectFayz2GUsercount(@Param("tableName")String tableName);
    Integer selectFdymq4GUsercount(@Param("tableName")String tableName);
    Integer selectFdymq2GUsercount(@Param("tableName")String tableName);
    Integer selectGtcphs4GUsercount(@Param("tableName")String tableName);
    Integer selectGtcphs2GUsercount(@Param("tableName")String tableName);
    Integer selectNdtyzx4GUsercount(@Param("tableName")String tableName);
    Integer selectNdtyzx2GUsercount(@Param("tableName")String tableName);
    Integer selectNdxsy4GUsercount(@Param("tableName")String tableName);
    Integer selectNdxsy2GUsercount(@Param("tableName")String tableName);
    Integer selectNdwz4GUsercount(@Param("tableName")String tableName);
    Integer selectNdwz2GUsercount(@Param("tableName")String tableName);
    Integer selectPnbyc4GUsercount(@Param("tableName")String tableName);
    Integer selectPnxyz4GUsercount(@Param("tableName")String tableName);
    Integer selectSntyg4GUsercount(@Param("tableName")String tableName);
    Integer selectSntyg2GUsercount(@Param("tableName")String tableName);
    Integer selectXpglst4GUsercount(@Param("tableName")String tableName);
    Integer selectXppqg4GUsercount(@Param("tableName")String tableName);
    Integer selectXpyyg4GUsercount(@Param("tableName")String tableName);
    Integer selectZrtyg4GUsercount(@Param("tableName")String tableName);
    Integer selectZrtyg2GUsercount(@Param("tableName")String tableName);
    Integer selectZntyg4GUsercount(@Param("tableName")String tableName);
    Integer selectZntyg2GUsercount(@Param("tableName")String tableName);


    Integer selectNdqcbz4GUsercount(@Param("tableName")String tableName);
    Integer selectNdqcbz2GUsercount(@Param("tableName")String tableName);
    Integer selectNdqcnz4GUsercount(@Param("tableName")String tableName);
    Integer selectNdqcnz2GUsercount(@Param("tableName")String tableName);
    Integer selectNdz4GUsercount(@Param("tableName")String tableName);
    Integer selectNdz2GUsercount(@Param("tableName")String tableName);
    Integer selectNdbx4GUsercount(@Param("tableName")String tableName);
    Integer selectNdbx2GUsercount(@Param("tableName")String tableName);
    Integer selectNdwd4GUsercount(@Param("tableName")String tableName);
    Integer selectNdwd2GUsercount(@Param("tableName")String tableName);

    List<TopCell> selectTop5xiaoqu4G(@Param("tableName")String tableName);
    List<TopCell> selectLow5xiaoqu4G(@Param("tableName")String tableName);



}
