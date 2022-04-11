package com.yefer.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.yefer.crud.entity.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    @Query("SELECT s FROM Student s WHERE"
            +" CONCAT(s.id, s.name, s.lastname, s.email)"
            +" LIKE %?1%")
    public List<Student> findAll(String keyWord);
}
