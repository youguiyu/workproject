/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.xngls.neiproj.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xngls.neiproj.entity.NeiKpi;
import com.xngls.neiproj.entity.NeiValue;
import com.xngls.neiproj.mapper.NeiKpiMapper;
import com.xngls.neiproj.mapper.NeiValueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
@Service
public class NeiReportService {


    @Autowired
    private NeiKpiMapper neiKpiMapper;
    @Autowired
    private NeiValueMapper neiValueMapper;

    public List<NeiKpi> getAllKpi() throws Exception {

        // 获取
        List<NeiKpi> typeList = neiKpiMapper.getList();

        return typeList;
    }

    public int insertNeiValue(NeiValue neiValue) throws Exception {

        return neiValueMapper.insert(neiValue);
    }

    public List<Map<String, Object>> getReportBydDate(Integer firstDate ,Integer lastDate,String business_type) {

        return neiValueMapper.getReportBydDate( firstDate , lastDate, business_type);
    }
    public List<Map<String, Object>> getReportAllBydDate(Integer firstDate ,Integer lastDate) {

        return neiValueMapper.getReportAllBydDate( firstDate , lastDate);
    }
    public List<Map<String, Object>> getAllBydDate(Integer firstDate ,Integer lastDate) {

        return neiValueMapper.getAllBydDate( firstDate , lastDate);
    }

}
