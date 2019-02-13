package com.ygy.wlwbound.dao;

import com.ygy.wlwbound.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface WlwApnDingjieDao {
    List<WlwApnDingjie> findWlwApnByTime(Integer maxtime);
    Integer  findMaxTime();

    List<WlwApnUsercountDingjie> findApnBytiaojia(Map<String, Object> map);

    List<WlwApnFlowDingjie> findApnBytiaojia2(Map<String, Object> map);

    List<WlwApnAttachDingjie> findApnBytiaojia3(Map<String, Object> map);

    List<WlwApnPdpDingjie> findApnBytiaojia4(Map<String, Object> map);
    List<WlwApnDingjie> findUserByTimeRange(Map<String, Integer> map);
    List<WlwApnDingjie> findFlowByTimeRange(Map<String, Integer> map);
    List<WlwApnDingjie> findAttachByTimeRange(Map<String, Integer> map);
    List<WlwApnDingjie> findPdpByTimeRange(Map<String, Integer> map);


}
