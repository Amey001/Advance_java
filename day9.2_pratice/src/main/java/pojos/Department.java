package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department extends BaseEntity {
	@Column(name="department_name",length = 30,unique = true)
	private String departmentName;
	@Column(length = 50)
	private String location;
	// Department 1---->* Emps
	@OneToMany(mappedBy = "assignedDept",cascade = CascadeType.ALL)
	private List<Employee> empList = new ArrayList<>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName, String location) {
		super();
		this.departmentName = departmentName;
		this.location = location;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	//add new Employee
	public void AddnewEmp(Employee emp)
	{
		System.out.println(" adding new employee :: ");
		empList.add(emp);
		emp.setAssignedDept(this);
		
	}
	public void deleteEmp(Employee emp)
	{
		empList.remove(emp);
		emp.setAssignedDept(null);
	}
	
	// Project tip :
	// DO NOT add any association fields in toString (to avoid recursion)
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", location=" + location + "]";
	}
	
	
}
