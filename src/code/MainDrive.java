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

				readAllPhoneNums();
			}
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("1/2/0 중에 입력해주세요.");
				
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
		System.out.print("이름 입력 : ");
		String inputName = scan.nextLine();
		inputName = inputName.replace(",", "-");
		
		System.out.print("생년 : ");
		int inputYear = scan.nextInt();
		scan.nextLine();
		
		Calendar now = Calendar.getInstance();
		if (inputYear > now.get(Calendar.YEAR)) {
			System.out.println("출생년도는 올해보다 클 수 없습니다.");
			return;
		}
		
		System.out.print("전화번호 : ");
		String inputPhoneNum = scan.nextLine();
		
		inputPhoneNum = inputPhoneNum.replace(",", "-");
		
		File myPhoneBookFile = new File("phoneBook.csv");
		
		try {
			FileWriter fw = new FileWriter(myPhoneBookFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String content = String.format("%s,%d,%s", inputName, inputYear, inputPhoneNum);
			
			bw.append(content);
			bw.newLine();
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static void readAllPhoneNums() {
		
		File myFile = new File("phoneBook.csv");
		
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
				
				String[] infos = contentLine.split(",");
				
				Contract contract = new Contract(infos[0], Integer.parseInt(infos[1]), infos[2]);
				myContracts.add(contract);
				
				
			}
			
			br.close();
			fr.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("총 %d개의 연락처 등록됨", myContracts.size()));
		
		for (Contract c : myContracts) {
			
			c.printContractInfo();
			
		}
		
		
		
	}
	
}








