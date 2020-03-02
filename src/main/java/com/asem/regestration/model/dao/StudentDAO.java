package com.asem.regestration.model.dao;

import com.asem.regestration.model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
     Student findById(String id) throws SQLException;
    Student findByEmail(String email) throws SQLException;
    void deletStudent(String id);
    void creat(Student student) throws SQLException;
    void update(Student student);
}
