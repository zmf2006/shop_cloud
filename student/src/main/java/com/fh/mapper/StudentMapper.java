package com.fh.mapper;

import com.fh.bean.StudentBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {


    void add(StudentBean studentBean);

    List<StudentBean> query();

    void updateStudent(StudentBean studentBean);

    void deleteStudent(Integer id);
}
