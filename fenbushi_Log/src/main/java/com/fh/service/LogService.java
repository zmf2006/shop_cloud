package com.fh.service;

import com.fh.model.Log;
import com.fh.model.LogVo;
import com.fh.tuils.ReturnData;

import java.util.Map;

/**
 * @author yiboChen
 * @create 2021-03-04 14:57
 */
public interface LogService {
    void addLog(Log log);

    Map queryPageData(LogVo logVo);
}
