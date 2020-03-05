package com.asem.regestration.model.dao;

import com.asem.regestration.model.entity.Courses;
import com.asem.regestration.model.entity.Student;

import java.sql.SQLException;

public interface CourseDAO {

    Courses findById(int id) throws SQLException;
    void deleteCourse(int id) throws SQLException;
    void creat(Courses courses) throws SQLException;
    void update(Courses courses);

}
