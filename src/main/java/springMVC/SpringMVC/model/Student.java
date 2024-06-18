package springMVC.SpringMVC.model;

public class Student {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String gender;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String country, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
