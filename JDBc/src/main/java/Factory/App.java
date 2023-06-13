package Factory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;




public class App 
{
    public static void main( String[] args ) throws SQLException {
        Boolean x = true;
        while (true) {
            System.out.println("\n Employee Management");
            System.out.println("1=Create");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice < 1 || choice >= 5)
                switch (choice) {
                    case 1:
                        ArrayList<Employee> list = EmployeeDAO.readAllEmployee();
                        for (Employee employee : list) {
                            System.out.println(employee);
                        }
                        break;

                }

        }
    }}
