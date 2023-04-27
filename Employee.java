package VN.fptaptech;


//EMployeee emtity aka employee table
public class Employee {
    private String Id;

    public Employee() {
    }

    private String name;
    private String salary;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String id, String name, String salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

}
