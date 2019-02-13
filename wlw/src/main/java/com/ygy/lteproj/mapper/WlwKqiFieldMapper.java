package com.ygy.lteproj.mapper;

import com.ygy.lteproj.entity.WlwKqiField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WlwKqiFieldMapper {
    List<WlwKqiField> findzuoyouData(Integer yesDate);
}
