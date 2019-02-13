package com.ygy.lteproj.mapper;

import com.ygy.lteproj.entity.WlwKeyApn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwKeyApnMapper {
    List<WlwKeyApn> findWlwKeyApnsByDate(Integer yesDate);
}
