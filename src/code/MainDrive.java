package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		프로그램 시작시 메뉴 출력
		printMenu();
		
	}
	
	static void printMenu() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("***** 전화번호부 *****");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 목록 조회");
		System.out.println("0. 프로그램 종료");
		System.out.println("*******************");
		System.out.print("메뉴 선택 : ");
		
		int userInput = scan.nextInt();
		
		
	}
	
}








