package com.fh.tuils;

public class ReturnData {

  private Integer code;

  private String message;

  private Object data;

  private ReturnData(){

    }

    public  static ReturnData successs(Object data){
        ReturnData rd=new ReturnData();
        rd.setCode(200);
        rd.setMessage("操作成功");
        rd.setData(data);
        return  rd;
    }

    public  static ReturnData error(Integer code,String message){
        ReturnData rd=new ReturnData();
        rd.setCode(code);
        rd.setMessage(message);

        return  rd;
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
