package VN.fptaptech;
//define all the function

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
    //define all the function
    public Employee getEmployeeById(String id) throws SQLException;
    //return 1 list employee
//    public ArrayList<Employee> getAllEmployee();

    public void  getAllEmployee() throws SQLException;
    public Employee addEmployee( Employee e) throws SQLException;
    public Employee deleteEmployee(String Id)throws SQLException;
    public Employee updateEmployee(String Id,String name)throws  SQLException;

}
