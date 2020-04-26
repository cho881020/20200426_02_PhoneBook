package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import code.datas.Contract;

public class MainDrive {

	public static void main(String[] args) {
		
//		전화 번호부 예제 시작 - 최진아
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
				System.out.println("프로그램을 종료 합니다.");
				break;
			}
			else if (userInput == 1) {
				addPhoneNum();
			}
			else if (userInput == 2) {
				readAllPhoneNumbers();
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
//		이름에 , 가 들어있다면 - 으로 변환 시켜줌.
		inputName = inputName.replace(",", "-");
		
		System.out.print("생년 : ");
		int inputYear = scan.nextInt();
//		남아있는 엔터키를 제거하기 위한 문장.
		scan.nextLine();
		
		Calendar now = Calendar.getInstance();
		if (inputYear > now.get(Calendar.YEAR)) {
			System.out.println("출생년도는 올해보다 클 수 없습니다.");
			return;
		}
		
		System.out.print("전화번호 : ");
		String inputPhoneNum = scan.nextLine();		
		inputPhoneNum = inputPhoneNum.replace(",", "-");
		
		
//		System.out.println(String.format("%s / %d / %s", inputName, inputYear, inputPhoneNum));
		
//		입력된 항목들을 한줄의 String으로 묶어서 파일에 추가 저장.
		
		File myPhoneBookFile = new File("phoneBook.csv");
		
		try {
			FileWriter fw = new FileWriter(myPhoneBookFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
//			이름,생년.폰번 => 한줄로 기록.
			
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
	
	static void readAllPhoneNumbers() {
		
//		파일을 읽어서 모든 전화번호를 콘솔에 출력 (syso)
		
		File myFile = new File("phoneBook.csv");
		
//		연락처 목록을 담아둘 ArrayList
		List<Contract> myContracts = new ArrayList<Contract>();
		
		try {
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			
			while (true) {
				String contentLine = br.readLine();
				
				if (contentLine == null) {
					System.out.println("목록 전부 불러옴");
					break;
				}
				
//				System.out.println(contentLine);
				
//				contentLine을 가지고 => contract 객체로 변환.
				
				String[] infos = contentLine.split(",");
				
				Contract contract = new Contract(infos[0], Integer.parseInt(infos[1]), infos[2]);
				myContracts.add(contract);
				
			}
			
			br.close();
			fr.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		파일에 있는 모든 연락처가 => myContracts에 Contract 형태로 옮겨담아짐.
		
		for (Contract c : myContracts) {
			
//			c의 정보를 가공해서 출력
//			최진아(26세) : 010-8957-3251 같은 양식으로.
			c.printContractInfo();
			
		}
		
		
	}
	
	
}








