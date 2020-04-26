package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		사용자의 생년을 입력받아서 > 나이로 변환.
		Scanner scan = new Scanner(System.in);
		System.out.print("태어난 년도를 입력하세요 : ");
		int birthYear = scan.nextInt();
		
		int age = 2020 - birthYear +1;
		System.out.println(age);
		
	}
}








