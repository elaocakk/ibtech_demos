package streams_demo;

public class Employee {

	private String name;
	private int salary;
	
	public Employee(String name,int salary) {
		this.name = name;
		this.salary = salary;
	}	
	
	public int getSalary( ) {
		return this.salary;
	}
	
	public String getEmployeeInfo( ) {
		return ( this.name + "-" + this.salary ) ;
	}
}
