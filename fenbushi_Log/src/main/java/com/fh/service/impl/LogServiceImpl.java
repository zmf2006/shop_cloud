package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.model.Log;
import com.fh.model.LogVo;
import com.fh.service.LogService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yiboChen
 * @create 2021-03-04 14:57
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private HttpServletRequest request;


    @Override
    public void addLog(Log log) {

        log.setIpAddr(request.getRemoteAddr());
                            //java对象转 json字符串
        String logJsonStr =   JSONObject.toJSONString(log);
        Jedis jedis=new Jedis("192.168.233.129");
        jedis.set("logData",logJsonStr);
        //释放资源
        jedis.close();
    }

    @Override
    public Map queryPageData(LogVo logVo) {
          Map map =  new HashMap();

        Jedis jedis = new Jedis("192.168.233.129");
        String logData = jedis.get("logData");
        //json字符串 转 java对象
        JSONObject jsonObject = JSONObject.parseObject(logData);
        jedis.close();
        map.put("logData",jsonObject);
        return map ;
    }
}
