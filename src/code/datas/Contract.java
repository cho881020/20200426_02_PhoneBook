package code.datas;

import java.util.Calendar;

public class Contract {
	
	private String name;
	private int birthYear;
	private String phoneNUm;
	
	public Contract(String name, int birthYear, String phoneNUm) {
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
	
	
	public void printContractInfo() {
//		조경진(33세) : 010-5112-3237 같은 양식으로.
		System.out.println(String.format("%s(%d세) : %d", this.name, this.getKoreanAge(), this.phoneNUm));
	}
	
	public int getKoreanAge() {
		
//		지금 실행 시점의 나이를 그때그때 계산.
		Calendar now = Calendar.getInstance();
		
		return now.get(Calendar.YEAR) - this.birthYear;
	}

}
