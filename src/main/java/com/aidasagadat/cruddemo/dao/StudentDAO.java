package com.aidasagadat.cruddemo.dao;

import com.aidasagadat.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findBylastName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();

}
