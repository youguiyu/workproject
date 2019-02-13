package com.ygy.wlwbound.dao;

import com.ygy.wlwbound.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public interface WlwEciDingjieDao {
    List<WlwEciDingjie> get4GTableData(Integer timeselect);

    Integer findMaxTime();

    List<WlwEciPdpDingjie> get2GTableData(Integer timeselect);

    WlwEci4gDingjie getZhicha4gData(Map<String, Object> map);

    WlwEciPdp2gDingjie getZhicha2gData(Map<String, Object> map);
}
