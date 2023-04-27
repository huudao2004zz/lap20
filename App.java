package VN.fptaptech;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        int choice,num;
        EmployeeDAO dao = new EmployeeImpl();
        Employee e;//defaue null
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("*****Menu****");
            System.out.println("1:getemployee by Id ");
            System.out.println("2:add Employee");
            System.out.println("3.Update employee");
            System.out.println("4.Delete employ");
            System.out.println("5.get all employee");
            System.out.println("6.exit");
            System.out.println("your choice : ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Id: ");
                    String id1 = sc.nextLine();
                    e = dao.getEmployeeById(id1);
                    break;
                case 5:
                    System.out.println("Employee Data");
                    System.out.println("---------------------");
                    dao.getAllEmployee();
                    System.out.println("---------------------");
                    break;
                case 4:
                    System.out.println("enter id to delete  : ");
                    String id2 = sc.nextLine();
                    sc.nextLine();
                    dao.deleteEmployee(id2);
                    break;
                case 2:
                    System.out.println("enter id : ");
                    String id = sc.nextLine();
                    sc.nextLine();
                    System.out.println(" enter name : ");
                    String name = sc.nextLine();
                    System.out.println(" Salary is : ");
                    String salary = sc.nextLine();

                    Employee e1 = new Employee(id,name,salary);
                    dao.addEmployee(e1);
                    break;
                case 3:
                    System.out.println("enter id to update : ");
                    String id3 = sc.nextLine();
                    sc.nextLine();
                    System.out.println("enter name to update : ");
                    String name1 = sc.next();
                    e = dao.updateEmployee(id3,name1);
                    break;
            }

            num = sc.nextInt();
        }while (num == 6);
    }
}
