package com.fh.controller;

import com.fh.bean.StudentBean;
import com.fh.service.StudentService;
import com.fh.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student/")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     *  新增
     * @param studentBean
     * @return
     */
    @RequestMapping("addStudent")
   public ResultData addStudent(
                                    @RequestBody StudentBean studentBean){
        studentService.addStudent(studentBean);
       return  ResultData.success(null);
   }


    /**
     * 查询 全部数据
     * @return
     */
    @RequestMapping("queryData")
    public ResultData queryData(){

        return  ResultData.success(studentService.query());
    }


    /**
     * 修改
     * @param studentBean
     * @return
     */
    @RequestMapping("updateStudent")
   public ResultData updateStudent(@RequestBody  StudentBean studentBean){
        studentService.updateStudent(studentBean);
        return  ResultData.success(null);
   }


   @RequestMapping("deleteStudent")
    public ResultData deleteStudent(@RequestParam(value = "id")  Integer id){
        studentService.deleteStudent(id);
        return  ResultData.success(null);
    }

}
