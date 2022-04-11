package com.yefer.crud.service;

import com.yefer.crud.entity.Student;
import com.yefer.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository  studentRepository;

    @Override
    public List<Student>listStudent(String keyWord) {
        if(keyWord != null ){
            return studentRepository.findAll(keyWord);
        }
        return studentRepository.findAll();
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student searchStudentForId(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);

    }


}
