package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		전화 번호부 예제 시작 - 최진아
		printMenu();
		
		
	}
	
	static void printMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("***** 전화번호부 *****");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 목록 조회");
		System.out.println("0. 프로그램 종료");
		System.out.println("*******************");
		System.out.println("메뉴 선택 : ");
		
		int userInput = scan.nextInt();
		
	}
	
	
}








