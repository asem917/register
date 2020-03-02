import com.asem.regestration.model.dao.impl.StudentDAOIMpl;
import com.asem.regestration.model.dao.utils.DataSourcePool;
import com.asem.regestration.model.dao.utils.WraperConnection;
import com.asem.regestration.model.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentDAOIMpl studentDAOIMpl=new StudentDAOIMpl("root","root@JEA","localhost","student2");
       Connection connection= studentDAOIMpl.getConnection();

       Statement statement=connection.createStatement();
      //  int resultSet=statement.executeUpdate("insert  into student2.student (id, firstName, lastName, email, password, joinYear)"+
        //        "values ('30','motaz','hussin','moataz@yahoo.com','addd','2015')");

        Student student=new Student("40","ss","sad","asd","asda0","asdsa");
        studentDAOIMpl.creat(student);





    }
    public static int calculat(int... number){
        for (int n:number){

        }
    }
}
