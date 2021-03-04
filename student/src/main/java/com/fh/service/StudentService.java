package com.fh.service;

import com.fh.bean.StudentBean;

import java.util.List;


public interface StudentService {
    void addStudent(StudentBean studentBean);

    List query();

    void updateStudent(StudentBean studentBean);

    void deleteStudent(Integer id);
}
