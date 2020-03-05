package com.asem.regestration.model.dao.impl;

import com.asem.regestration.model.dao.StudentDAO;
import com.asem.regestration.model.dao.utils.DataSourcePool;
import com.asem.regestration.model.entity.Student;

import java.sql.*;

public class StudentDAOIMpl implements StudentDAO {
    private String userName;
    private String passwored;
    private String host;
    private String databaseName;
    private DataSourcePool dataSourcePool;






    public StudentDAOIMpl(String userName, String passwored, String host, String databaseName) {
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
    public Student findById(String id) throws SQLException {
        String sql="select *from student2.student where student.id="+id+"";

        PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        String iD=resultSet.getString(1);
        String fn=resultSet.getString(2);
        String ln=resultSet.getString(3);
        String Email=resultSet.getString(4);
        String password=resultSet.getString(5);
        String jy=resultSet.getString(6);



        Student student=new Student(iD,fn,ln,Email,password,jy);
        return student;
    }

    @Override

    public Student findByEmail(String email) throws SQLException {
        String sql="select *from student2.student where student.email="+email+"";
        PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        String id=resultSet.getString(1);
        String fn=resultSet.getString(2);
        String ln=resultSet.getString(3);
        String Email=resultSet.getString(4);
        String password=resultSet.getString(5);
        String jy=resultSet.getString(6);



        Student student=new Student(id,fn,ln,Email,password,jy);
        return student;
    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        String sql="delete from student2.student where student.id="+id+"";
        Statement statement=getConnection().createStatement();
        int resultSet=statement.executeUpdate(sql);




    }
   @Override
    public void creat(Student student) throws SQLException {
        String iD=student.getId();
        String fn=student.getFirstName();
        String ln=student.getLastName();
        String Email=student.getEmail();
        String password=student.getPassword();
        String jy=student.getJoinYear();
       PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into student2.student (id, firstName, lastName, email, password, joinYear) values (?,?,?,?,?,?)");
       preparedStatement.setString(1,iD);
       preparedStatement.setString(2,fn);
       preparedStatement.setString(3,ln);
       preparedStatement.setString(4,Email);
       preparedStatement.setString(5,password);
       preparedStatement.setString(6,jy);
       preparedStatement.executeUpdate();







    }
   @Override
    public void update(Student student) throws SQLException {



    }
}
