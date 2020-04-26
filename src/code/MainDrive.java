package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

//		전화 번호부 예제 시작 - 김재환
		printMenu();

	}

	static void printMenu() {
		while (true) {

			Scanner scan = new Scanner(System.in);
			System.out.println("***** 전화번호부 *****");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 목록 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("******************");
			System.out.print("메뉴 선택: ");

			int userInput = scan.nextInt();

			if (userInput == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;

			}

			else if (userInput == 1) {
				
				addPhoneNum();

			} else if (userInput == 2) {
//			TODO - 모든 전화번호 목록 출력

			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("1/2/0중에 입력해주세요.");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
	
	static void addPhoneNum() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** 전화번호 등록 ***");
		System.out.print("이름 입력: ");
		String inputName = scan.nextLine();
		
		System.out.print("생년: ");
		int inputYear = scan.nextInt();
		
		scan.nextLine();
		
		System.out.print("전화번호: ");
		String inputPhoneNum = scan.nextLine();
		
		
//		System.out.println(String.format("%s / %d / %s", inputName , inputYear , inputPhoneNum));
		
		File myPhoneBookFile = new File("ohineBook.csv");
		
		try {
			FileWriter fw = new FileWriter(myPhoneBookFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String content = String.format("%s,%d,%s",	inputName , inputYear , inputPhoneNum);
			
			bw.append(content);
			bw.newLine();
			
			
			
			bw.close();
			fw.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
