import com.asem.regestration.model.dao.impl.CourseDAOImpl;
import com.asem.regestration.model.dao.impl.StudentDAOIMpl;
import com.asem.regestration.model.dao.utils.DataSourcePool;
import com.asem.regestration.model.dao.utils.WraperConnection;
import com.asem.regestration.model.entity.Courses;
import com.asem.regestration.model.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        CourseDAOImpl courseDAO=new CourseDAOImpl("root","root@JEA","localhost","student2");

        Courses courses=new Courses(60,"java","ali");
        courseDAO.creat(courses);

        StudentDAOIMpl studentDAOIMpl=new StudentDAOIMpl("root","root@JEA","localhost","student2");
      Student student=new Student("511","asem","tbaileh","asd@fdsv.com","adad","2020");
         studentDAOIMpl.creat(student);



        //  int resultSet=statement.executeUpdate("insert  into student2.student (id, firstName, lastName, email, password, joinYear)"+
        //        "values ('30','motaz','hussin','moataz@yahoo.com','addd','2015')");




       courseDAO.deleteCourse(20);





    }

}
