package com.ygy.syh.service.wlw.impl;


import com.ygy.syh.dao.wlw.WlwApnMapper;
import com.ygy.syh.domain.wlw.WlwApn;
import com.ygy.syh.service.wlw.WlwApnService;
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
