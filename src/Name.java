
public class Name {
	private String firstName;
	private String middleName;
	private String lastName;

	public Name(String fullName) {
		if (fullName.indexOf(' ') == -1)
			fullName = fullName + " N/A";
		int pos1 = fullName.indexOf(' ');
		int pos2 = fullName.lastIndexOf(' ');
		this.firstName = fullName.substring(0, pos1);
		if (pos1 != pos2) {
			this.middleName = fullName.substring(pos1 + 1, pos2);
		} else {
			this.middleName = "";
		}
		this.lastName = fullName.substring(pos2 + 1);

	}

	public String getFullName() {

		return firstName + " " + middleName + " " + lastName;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getMiddleName() {

		return middleName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}