package application;

public class EmployeeX {
	protected static String name;
    protected static String dept;

    public EmployeeX(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + dept);
    }
}
