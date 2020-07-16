package coursework8002Part1Package;

public final class Name {
	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// constructor goes here
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char charAt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toUpperCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
