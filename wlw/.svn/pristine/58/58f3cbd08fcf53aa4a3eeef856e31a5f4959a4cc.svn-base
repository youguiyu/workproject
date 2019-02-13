package com.ygy.lteproj.service.impl;

import com.ygy.lteproj.entity.WlwApn;
import com.ygy.lteproj.mapper.WlwApnMapper;
import com.ygy.lteproj.service.WlwApnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "wlwapnService")
public class WlwApnServiceImpl implements WlwApnService {
    @Autowired
    private WlwApnMapper wlwapnMapper;

    @Override
    public List<WlwApn> getAllApns() {
       List<WlwApn> list = wlwapnMapper.selectAll();
       return list;
    }
}
