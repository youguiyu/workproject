package com.ygy.syh.dao.cluster;

import com.ygy.syh.domain.Video;
import com.ygy.syh.domain.VideoCell;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoCellDao {

    List<VideoCell> queryByVideoUser(@Param("tableName")String tableName);
    List<VideoCell> queryByVideoFlow(@Param("tableName")String tableName);
    List<VideoCell> queryByVideoWait(@Param("tableName")String tableName);

    Video queryByVideoFaat(@Param("tableName")String tableName);
    Video queryByVideoFatyg(@Param("tableName")String tableName);
    Video queryByVideoFayz(@Param("tableName")String tableName);
    Video queryByVideoFdymqg(@Param("tableName")String tableName);
    Video queryByVideoGtcphs(@Param("tableName")String tableName);
    Video queryByVideoNdtyzx(@Param("tableName")String tableName);
    Video queryByVideoNdxsy(@Param("tableName")String tableName);
    Video queryByVideoNdwz(@Param("tableName")String tableName);
    Video queryByVideoPnbyc(@Param("tableName")String tableName);
    Video queryByVideoPnyz(@Param("tableName")String tableName);
    Video queryByVideoSntyg(@Param("tableName")String tableName);
    Video queryByVideoXpglst(@Param("tableName")String tableName);
    Video queryByVideoXpstpqg(@Param("tableName")String tableName);
    Video queryByVideoXpyyg(@Param("tableName")String tableName);
    Video queryByVideoZrtyg(@Param("tableName")String tableName);
    Video queryByVideoZntyg(@Param("tableName")String tableName);
    List<Video> queryByVideoZdqy(@Param("tableName")String tableName);
    String selectTableByName(@Param("tableName")String tableName);
}
