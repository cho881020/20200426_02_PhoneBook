package code.datas;

import java.util.Calendar;

public class Contract {

	private String name;
	private int birthYear;
	private String phoneNum;

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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Contract(String name, int birthYear, String phoneNum) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.phoneNum = phoneNum;
	}

	public void printContractInfo() {
		System.out.println(String.format("%s(%d세) : %s", this.name, this.getKoreanAge(), this.phoneNum));
	}

	public int getKoreanAge() {

		Calendar now = Calendar.getInstance();

		return now.get(Calendar.YEAR) - this.birthYear + 1;
	}

}
