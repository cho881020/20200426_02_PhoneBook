package code.datas;

import java.util.Calendar;

public class Contract {
	
	private String name;
	private int birthYear;
	private String phoneNum;
	
	
	public Contract(String name, int birthYear, String phoneNum) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.phoneNum = phoneNum;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	public void printContractInfo() {
		
//		조경진(33세) : 010-5112-3237 같은 양식으로.
		
		System.out.println(String.format("%s(%d세) : %s", this.name, this.getKoreanAge(), this.phoneNum));
	}
	
	public int getKoreanAge() {
		
//		지금 실행시점의 나이를 그때그때 계산.
		Calendar now = Calendar.getInstance();
		
		return now.get(Calendar.YEAR)-this.birthYear+1;
	}
	

}






