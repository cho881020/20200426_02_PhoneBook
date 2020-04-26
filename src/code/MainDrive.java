package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		프로그램 시작시 메뉴 출력
		printMenu();
		
	}
	
	static void printMenu() {
		
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("***** 전화번호부 *****");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 목록 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("*******************");
			System.out.print("메뉴 선택 : ");
			
			int userInput = scan.nextInt();
			
			if (userInput == 0) {
				System.out.println("프로그램을 종료합니다..");
				break;
			}
			else if (userInput == 1) {
				addPhoneNum();
			}
			else if (userInput == 2) {
//				TODO - 모든 전화번호 목록 출력	
			}
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("1/2/0 중에 입력해주세요.");
				
				try {
//					프로그램 일시정지 코드 (1초)
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
		
//		이름(String) / 생년(int) / 전화번호(String)
		
		System.out.println("*** 전화번호 등록 ***");
		System.out.print("이름 입력 : ");
		String inputName = scan.nextLine();
		
		System.out.print("생년 : ");
		int inputYear = scan.nextInt();
//		남아있는 엔터키를 제거하기 위한 문장.
		scan.nextLine();
		
		System.out.print("전화번호 : ");
		String inputPhoneNum = scan.nextLine(); 
		
//		System.out.println(String.format("%s / %d / %s", inputName, inputYear, inputPhoneNum));
		
//		입력된 항목들을 한줄의 String으로 묶어서 파일에 추가 저장.
		File myPhoneBookFile = new File("phoneBook.csv");
		
		try {
			FileWriter fw = new FileWriter(myPhoneBookFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
//			이름,생년,폰번 => 한줄로 기록.
			
			String content = String.format("%s,%d,%s", inputName, inputYear, inputPhoneNum);
			
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








