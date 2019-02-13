package com.ygy.lteproj.mapper;

import com.github.pagehelper.Page;
import com.ygy.lteproj.entity.AppCell;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AppCellMapper {

    Page<AppCell> findByPage(Map<String ,String> map);
    List<AppCell> findByPage2(Map<String ,String> map);
 }
