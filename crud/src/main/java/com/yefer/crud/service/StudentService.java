package com.yefer.crud.service;

import com.yefer.crud.entity.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface StudentService {

    public List<Student> listStudent(String keyWord);

    public Student saveStudent(Student student);

    public Student searchStudentForId(Integer id);

    public Student updateStudent(Student student);

    public void deleteStudent(Integer id);

}
