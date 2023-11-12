import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {

    //1st
    private final Integer employeeId;
    private final String employeeName;
    private  final Date doj;
    private final List<String> mobile;

    private final Address address;

    //3rd step
    public Employee(Integer employeeId, String employeeName, Date doj, List<String> mobile, Address address) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.doj = doj;
        this.mobile = mobile;
        this.address = address;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Date getDoj() {
        return (Date) doj.clone();
    }

    public Address getAddress() {
        return new Address(address.getCity(), address.getZip());//address;
    }

    public List<String> getMobile() {
        return new ArrayList<>(mobile);//Collections.unmodifiableList(mobile);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", doj=" + doj +
                ", mobile=" + mobile +
                ", address=" + address +
                '}';
    }
}
