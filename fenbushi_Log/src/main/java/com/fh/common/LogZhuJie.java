package com.fh.common;

import com.alibaba.fastjson.JSONObject;
import com.fh.controller.LogController;
import com.fh.model.Log;
import com.fh.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author huangp
 * @create 2020-12-20 14:02
 */
@Component
@Aspect //声明切面类
public class LogZhuJie {

    @Resource
    private LogService logService;

    @Before("execution(* com.fh.controller.*.*(..))")

    public void writeLog(JoinPoint joinPoint){
        Log log = new Log();
        //获取方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法对象
        Method method = methodSignature.getMethod();
        //判断此方法是否需要记录日志
        //判断方法上是否有日志记录
        aop_log annotation = method.getAnnotation(aop_log.class);
        if (annotation !=null){
            Object[] args = joinPoint.getArgs();

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < args.length; i++) {
                Object param = args[i];
                sb.append("第"+i+1+"个参数是:"+ JSONObject.toJSONString(param));
            }

            //设置参数
            log.setParams(sb.toString());

            System.out.println("有记录了");
            //获取操作内容
            String value = annotation.value();
            log.setContent(value);
            logService.addLog(log);
        }
    }


}
