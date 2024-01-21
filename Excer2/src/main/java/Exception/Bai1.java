package Exception;

import java.util.logging.FileHandler;

public class Bai1 {
	private String firstName;
	private String lastName;
	private String proFile;
	public Bai1(String firstName, String lastName, String proFile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.proFile = proFile;
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
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	
	
	
}
