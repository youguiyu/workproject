package com.xngls.neiproj.service;

import com.github.pagehelper.Page;
import com.xngls.neiproj.entity.KpiModel;
import com.xngls.neiproj.entity.NeiKpi;
import com.xngls.neiproj.entity.NeiKpiAndNeiValue;
import com.xngls.neiproj.model.MyException;
import com.xngls.neiproj.model.QushiModel;
import com.xngls.neiproj.model.ZhibiaoTiaoModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface NeiService {
    List<NeiKpiAndNeiValue> findByPage(ZhibiaoTiaoModel zhibiaoTiaoModel);

    Map<String,Object> findByQushiData(QushiModel qushiModel);

    List<Map<String,Object>> getRadar1Data();

    List<Map<String,Object>> getRadar2Data();

    Map<String,Object> getMapData();

    Map<String,Object> getMapLineData(String city);

    List<Map<String, Object>> getPingGuTalbeA(String dateId, String bussinessType);

    List<NeiKpiAndNeiValue> findByPage2(Map<String, Object> map);

    Map<String,Object> findByQushiData2(QushiModel qushiModel);

    Map<String ,Object> batchImport(String fileName, MultipartFile file)throws Exception;

    List<KpiModel> findKpiModes(Map<String,Integer> map);

    List<NeiKpi> getXiangxiData(Integer dateId, String fetchPlatform);

    List<NeiKpi> getKpiAllInfo(String serarchText);

    List<NeiKpi> getKpiAllInfo1(String searchText);
}
