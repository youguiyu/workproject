package com.ygy.syh.dao.wlw;


import com.ygy.syh.domain.wlw.TableStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TableStatusMapper {
    List<TableStatus> findTableStatusByDate(Integer date);
}
