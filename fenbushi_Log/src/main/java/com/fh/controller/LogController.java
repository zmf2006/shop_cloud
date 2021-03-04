package com.fh.controller;

import com.fh.model.Log;
import com.fh.model.LogVo;
import com.fh.service.LogService;
import com.fh.tuils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author yiboChen
 * @create 2021-03-04 14:44
 */
@RestController
@RequestMapping("api/log/")
public class LogController {

    @Autowired
    private LogService logService;


    @RequestMapping("addLog")
    public ReturnData addLog(Log log){
        logService.addLog(log);
        return ReturnData.successs("success");
    }



    @RequestMapping("queryPageData")
    public ReturnData queryPageData(LogVo logVo){
       Map map =    logService.queryPageData(logVo);
        return ReturnData.successs(map);
    }



}
