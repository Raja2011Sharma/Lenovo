package utils;

public class KaryakaryaDataEntryFormControl {
	// login
	public String email;
	public String password;
	public String otp;
	// form control
	public String name;
	public String fatherName;
	public String designation;
	public String hasSmartPhone;
	public String phoneNumber;
	public String primaryMemberId;
	public String age;
	public String gender;
	public String whatsApp;

	public String getKaryakartaEmail() {
		return email;

	}

	public String getKaryakartaPassword() {
		return password;
	}

	public String getKaryakartaOtp() {
		return otp;
	}

	public String getKaryakartaName() {
		return name;
	}

	public String getKaryakartaRelationName() {
		return fatherName;
	}

	public String getKaryakartaDesignation() {
		return designation;
	}

	public String getKaryakartahasSmartPhone() {
		return hasSmartPhone;
	}

	public String getKaryakartaphoneNumber() {
		return phoneNumber;
	}

	public String setKaryakartaEmail(String emailValue, String password_value) {
		return this.email = emailValue;
	}

	public KaryakaryaDataEntryFormControl(String login_email, String login_password, String login_otp) {

		this.email = login_email;
		this.password = login_password;
		this.otp = login_otp;
	}

	public KaryakaryaDataEntryFormControl(String name, String relationName, String designation, String hasSmartPhone,
			String phoneNumber, String primaryMemberId, String age, String gender, String whatsApp) {
		this.name = name;
		this.fatherName = relationName;
		this.designation = designation;
		this.hasSmartPhone = hasSmartPhone;
		this.phoneNumber = phoneNumber;
		this.primaryMemberId = primaryMemberId;
		this.age = age;
		this.gender = gender;
		this.whatsApp = whatsApp;
	}

}
