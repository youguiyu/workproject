package com.ygy.lteproj.service;

import com.github.pagehelper.Page;
import com.ygy.lteproj.entity.AppCell;
import com.ygy.lteproj.model.TableModel;

import java.util.List;
import java.util.Map;

public interface LteDataService {
    List<TableModel> getLteTableData(Map<String,String>map);

    List<Map<String,Object>> getWeekData(Map<String, String> map);

   // List<AppCell>getzhiChaTableData(Map<String, String> map);
    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<AppCell> findByPage(int pageNo, int pageSize,Map<String ,String> map);
}
