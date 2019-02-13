package com.ygy.syh.dao.wlw;




import com.ygy.syh.domain.wlw.WlwApn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwApnMapper {

    List<WlwApn> selectAll();
}
