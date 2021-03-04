package com.fh.utils;
//统一规范 接口的返回值   code  message  data
public class ResultData {

    private  Integer code;

    private String message;

    private Object data;


    /*  为了安全性   构造方法 私有化  */
    private ResultData(){

    }

    /*  提供一个公共的访问方法     返回此成功对象  */

    public static ResultData success(Object data){
        ResultData rs=new ResultData();
        rs.setCode(200);
        rs.setMessage("操作成功");
        rs.setData(data);
        return rs;
    }

    public static ResultData error(Integer code, String message){
        ResultData rs=new ResultData();
        rs.setCode(code);
        rs.setMessage(message);
        return  rs;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
