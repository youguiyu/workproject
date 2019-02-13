package com.xngls.neiproj.mapper;

import com.xngls.neiproj.entity.NeiBullient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface NeiBullientMapper {

    List<NeiBullient> selectBullientBytiaojian(Map<String,Object> map);


    List<NeiBullient> selectBullientBytiaojianTemp(Map<String, Object> map);
}
