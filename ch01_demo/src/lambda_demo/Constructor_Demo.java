package lambda_demo;

public class Constructor_Demo {

	public static void main(String[] args) {
		
		ConstructorDemoInterface cdi = Student :: new ;
		Student studentName = cdi.getStudentInfo("Ela");
		
	}
}


class Student {
	
	Student(String name) {
		System.out.println(name);
	}	
	
}

interface ConstructorDemoInterface {
	
	public Student getStudentInfo(String name);
}

