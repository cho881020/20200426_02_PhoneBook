package code.datas;

public class contract {
	
	private String name;
	private int birthYear;
	private String phoneNUm;
	
	public contract(String name, int birthYear, String phoneNUm) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.phoneNUm = phoneNUm;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getPhoneNUm() {
		return phoneNUm;
	}
	public void setPhoneNUm(String phoneNUm) {
		this.phoneNUm = phoneNUm;
	}

}
