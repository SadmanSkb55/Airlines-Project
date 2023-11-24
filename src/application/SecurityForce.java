package application;

public class SecurityForce {
	 private String forceName;

	    public SecurityForce(String forceName) {
	        this.forceName = forceName;
	    }

	    public void performSecurityCheck() {
	        System.out.println("Performing security check by " + forceName);
	    }

	    // Method Overloading: Added a new method with different parameters
	    public void performSecurityCheck(String location) {
	        System.out.println("Performing security check at " + location + " by " + forceName);
	    }

		
}
