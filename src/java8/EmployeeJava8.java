package java8;

import java.util.Arrays;
import java.util.List;


public class EmployeeJava8 {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;

    public EmployeeJava8(Integer id, String name, Double salary, Integer age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeJava8{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public List<EmployeeJava8> getEmployeeList() {
        int x=0;
     return Arrays.asList(
             new EmployeeJava8(x++,"swathi",500.0,19),
             new EmployeeJava8(x++,"swapna",800.0,35),
             new EmployeeJava8(x++,"siva",1000.0,32),
             new EmployeeJava8(x++,"siva",1500.0,32),
                new EmployeeJava8(x++,"prasad",4000.0,59),
                new EmployeeJava8(x++,"ravi",2000.0,17),
                new EmployeeJava8(x++,"raju",8000.0,24),
                new EmployeeJava8(x++,"raghu",21000.0,23),
                new EmployeeJava8(x++,"ragava",12000.0,45)
        );

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmployeeJava8() {
    }
}
