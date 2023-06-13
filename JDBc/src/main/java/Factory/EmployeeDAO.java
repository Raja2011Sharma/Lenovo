package Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {
    public EmployeeDAO() throws SQLException {
    }

    public static ArrayList<Employee> readAllEmployee() throws SQLException {
        ArrayList<Employee> emplist = new ArrayList<Employee>();
        Connection con = DB.connect();
        String Query = query.select;
        Statement statement = con.prepareStatement(Query);
//        System.out.println("\n st ="+statement);

        ResultSet rs = statement.executeQuery(Query);
        while (rs.next()) {
            Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4));
            emplist.add(emp);
        }
        statement.close();
        return emplist;
    }



}
