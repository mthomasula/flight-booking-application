package BusinessLogic;

import BusinessLogic.Flight;
import Database.CustomerDB;

public class Customer implements User {
	//
	protected String firstName;
	protected String lastName;
	protected static String username;
	protected String password;
	protected String address;
	protected String zipcode;
	protected String state;
	protected String country;
	protected String email;
	protected String securityQuestion;
	protected String securityAnswer;
	protected String ssn;
	
	//constructor to fill info for user
	public Customer(String firstName, String lastName, String username, String password, String address, String zipcode,
			String state, String country, String email, String securityQuestion, String securityAnswer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.ssn = ssn;
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

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Customer.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	//returns true if username and password passed is same as username and password of user
	public static void loginCredentials(String password){
			try {
				if(!password.equals(password)) 
				throw new Exception("Invalid password");
			} catch (Exception e) {
				System.out.println("Invalid Password. Please try again");
			}
		}
		
	//If the string passed is equal to the security answer, then the password is displayed
	public void resetForgottenCredentials(String securityAnswer) {
		if(this.securityAnswer.equals(securityAnswer))
			System.out.println(this.getPassword());
	}
	
	@Override
	public String toString() {
		return ("Name:"+ this.getFirstName() + " " + this.getLastName() + "\n Username:" + this.getUsername());
	}
	
	public void searchFlight() {
		
	}
	
}

