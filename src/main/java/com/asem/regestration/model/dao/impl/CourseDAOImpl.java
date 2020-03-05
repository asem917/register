package com.asem.regestration.model.dao.impl;

import com.asem.regestration.model.dao.CourseDAO;
import com.asem.regestration.model.dao.utils.DataSourcePool;
import com.asem.regestration.model.entity.Courses;
import com.asem.regestration.model.entity.Student;

import java.sql.*;

public class CourseDAOImpl implements CourseDAO {
    private String userName;
    private String passwored;
    private String host;
    private String databaseName;
    private DataSourcePool dataSourcePool;


    public CourseDAOImpl(String userName, String passwored, String host, String databaseName) {
        this.userName=userName;
        this.passwored=passwored;
        this.host=host;
        this.databaseName=databaseName;
        this.dataSourcePool=new DataSourcePool(userName,passwored,host,databaseName);

    }
    public Connection getConnection() throws SQLException {

        return dataSourcePool.getConnections().getConnection();

    }





    @Override
    public Courses findById(int id) throws SQLException {
        String sql="select *from student2.course where course.courseId="+id+"";

        PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        int iD=resultSet.getInt(1);
        String name=resultSet.getString(2);
        String teacherName=resultSet.getString(3);
        Courses courses=new Courses(iD,name,teacherName);





        return courses;
    }

    @Override
    public void deleteCourse(int id) throws SQLException {
        String sql="delete from student2.course where courseId="+id+"";
        Statement statement=getConnection().createStatement();
        int resultSet=statement.executeUpdate(sql);

    }

    @Override
    public void creat(Courses courses) throws SQLException {

        int iD=courses.getCourseId();
        String name=courses.getCourseName();
        String teName=courses.getTeacherName();

        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into student2.course (courseId, courseName, teacherName) values (?,?,?)");
        preparedStatement.setInt(1,iD);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,teName);

        preparedStatement.executeUpdate();




    }

    @Override
    public void update(Courses courses) {

    }
}
