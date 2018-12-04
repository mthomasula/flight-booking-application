package BusinessLogic;

import Database.AdministratorDB;

import Database.CustomerDB;

public class Administrator extends Customer implements User {

	private static String administrator_Password="PaSsWoRd";
	
	public Administrator(String firstName, String lastName, String username, String password, String address, String zipcode, String state, String email, String securityQuestion, String securityAnswer, String ssn) {
		super(firstName, lastName, username, password, address, zipcode, state, email, securityQuestion, securityAnswer, ssn);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.zipCode= zipcode;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.ssn = ssn;
		}


	public static String getAdministratorPassword() {
		return getAdministratorPassword();
	}

	public void createFlight() {
		

}


}

