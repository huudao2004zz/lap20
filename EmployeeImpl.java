package VN.fptaptech;

import jdbcdemo.MySQLConnection;

import java.sql.*;

public class EmployeeImpl implements EmployeeDAO {

    Employee e = new Employee();

    @Override
    public Employee getEmployeeById(String ID) throws SQLException {
        Connection conn = MySQLConnection.getMySQLConnection();
        String query = "select * from employee where id = " + ID;
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        while (resultSet.next()){
            String id = resultSet.getString(1);
            e.setId(id);
            String name = resultSet.getString(2);
            e.setName(name);
            String salary = resultSet.getString(3);
            e.setSalary(salary);
            System.out.println("         employee data        ");
            System.out.println("*******************************");
            System.out.println("Id : " + id);
            System.out.println("name : " + name);
            System.out.println("salary : " + salary);

        }
        return e;
    }

    @Override
    public void getAllEmployee() throws SQLException {
        String query = "select * from employee";
        Connection connection = MySQLConnection.getMySQLConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            String id = rs.getString(1);
            e.setId(id);
            String name = rs.getString(2);
            e.setName(name);
            String salary = rs.getString(3);
            e.setSalary(salary);

            System.out.println(" Id : " + rs.getString(id));
            System.out.println(" name : " + rs.getString(name));
            System.out.println(" salary : " + rs.getString(salary));
        }

    }

    @Override
    public Employee addEmployee(Employee e) throws  SQLException {
        Connection connection = MySQLConnection.getMySQLConnection();
        PreparedStatement pre = connection.prepareStatement( " insert into employee values (?,?,?) ");
        pre.setString(1, e.getId());
        pre.setString(2, e.getName());
        pre.setString(3, e.getSalary());
        int newCount = pre.executeUpdate();
        if (newCount > 0 ){
            System.out.println("added succesfully.......");
        }else
        System.out.println("failed to add ");
        return null;
    }

    @Override
    public Employee deleteEmployee(String Id) throws  SQLException{
        Connection connection = MySQLConnection.getMySQLConnection();
        String query ="delete from employee where id = (?) ";
        PreparedStatement pre = connection.prepareStatement( query);
        pre.setString(1,Id);
        int newCount = pre.executeUpdate();
        if (newCount > 0 ){
            System.out.println("delete succesfully.......");
        }else
            System.out.println("failed to delete ");
        return null;
    }

    @Override
    public Employee updateEmployee(String Id, String name) throws  SQLException{
        Connection connection = MySQLConnection.getMySQLConnection();
        String query ="update employee set name = ? where id = ? ";
        PreparedStatement pre = connection.prepareStatement( query);
        pre.setString(1,name);
        pre.setString(2,Id);

        int newCount = pre.executeUpdate();
        if (newCount > 0 ){
            System.out.println("update succesfully.......");
        }else
            System.out.println("failed to update ");
        return null;
    }
}
