package com.fh.service.impl;

import com.fh.bean.StudentBean;
import com.fh.mapper.StudentMapper;
import com.fh.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public void addStudent(StudentBean studentBean) {
        studentMapper.add(studentBean);
    }

    @Override
    public List<StudentBean> query() {

        return studentMapper.query();

    }

    @Override
    public void updateStudent(StudentBean studentBean) {
        studentMapper.updateStudent(studentBean);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }
}
