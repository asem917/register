package com.asem.regestration.model.dao;

import com.asem.regestration.model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
     Student findById(String id) throws SQLException;
    Student findByEmail(String email) throws SQLException;
    void deleteStudent(String id) throws SQLException;
    void creat(Student student) throws SQLException;
    void update(Student student) throws SQLException;
}
