package honux.calendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * +----------------------+ | 1. 일정 등록 | 2. 일정 검색 | 3. 달력 보기 | h. 도움말 q. 종료
 * +----------------------+ 명령 (1, 2, 3, h, q) > 1 [일정 등록] 날짜를 입력하세요. >
 * 2016-06-05 일정을 입력하세요. > 자바지기에게 밥 얻어먹기 일정이 등록되었습니다. 명령 (1, 2, 3, h, q) > 2 [일정
 * 검색] 날짜를 입력하세요. > 2016-06-05 1개의 일정이 있습니다. 1. 자바지기에게 밥 얻어먹기 명령 (1, 2, 3, h, q)
 * q Bye
 * 
 * @author トマト
 *
 */

public class Scheduler {
	static String stringDate;
	static String toDo;
	static Map<Date, String> scheduleMap = new HashMap<Date, String>();
	ArrayList<String> schedule;
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> scheduleofTheDate = new ArrayList<String>();
	static Calendar calendar;
	static FormatSwitch dateDate;
	static Date date;

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		String stringYear = String.valueOf(cal.get(Calendar.YEAR));
		String stringMonth = String.valueOf((cal.get(Calendar.MONTH) + 1));
		int year = Integer.parseInt(stringYear);
		int month = Integer.parseInt(stringMonth);

		int remainder = 0;

		BufferedReader br = null;
		if (new File("test.txt").exists()) {

			try {
				br = new BufferedReader(new FileReader(new File("test.txt")));
				String buffer = "";

				while ((buffer = br.readLine()) != null) {
					System.out.println(buffer); // 한줄씩 읽어서 Print 합니다.
				}
			} catch (Exception e2) {

				e2.printStackTrace();
			}

			// 한줄씩 읽는 메소드가 readLine() 입니다.

		} else {
			System.out.println("아직 저장된 일정이 없습니다.");
		}
		Prompt.prompt(year, month, remainder);
		topPage();

	}

	public static void topPage() {

		System.out.println("+----------------------+");
		System.out.println("|1. 일정등록                               |");
		System.out.println("|2. 일정검색                               |");
		System.out.println("|3. 달력보기                               |");
		System.out.println("|h. 도움말                                  |");
		System.out.println("|q. 종료                                     |");
		System.out.println("+----------------------+");
		System.out.println("명령 (1, 2, 3, h, q)");
		System.out.print("> ");

		String command = scanner.next();

		switch (command) {
		case "1":
			try {
				scheduleRegister(scanner, calendar);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;
		case "2":
			System.out.println("[일정 검색] 날짜를 입력하세요. ex)2018-04-18");
			System.out.print("> ");
			stringDate = scanner.next();
			try {
				scheduleSearch(stringDate);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			break;
		case "3":
			/*
			 * System.out.println("[일정 변경] 날짜를 입력하세요. ex)2018-04-18");
			 * System.out.print("> "); stringDate = scanner.next(); try {
			 * scheduleRevise(stringDate); } catch (ParseException e) {
			 * 
			 * e.printStackTrace(); }
			 * 
			 * 
			 */ break;
		case "h":

			break;
		case "q":
			System.out.println("BYE BYE");
			System.exit(0);
			break;
		default:
			break;
		}

		// to close scanner in main method

	}

	public static void scheduleRegister(Scanner s, Calendar c) throws ParseException, IOException {

		// toDo를 저장해야 하는
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt"), true));

		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력하세요. ex)1989-02-23");
		System.out.print("> ");
		String stringDate = s.next();
		bw.write(stringDate);
		bw.write(" : ");
		String text = "";
		System.out.println("일정을 입력하세요.");
		System.out.print("> ");
		// parameter에 넣은 scanner가 재활용이 안 되서 Scanner 를 생성했다.
		Scanner scanner = new Scanner(System.in);
		text = scanner.nextLine();

		try {
			dateDate = new FormatSwitch(stringDate);
			date = dateDate.formatSwitch(stringDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		scheduleMap.put(date, text);
		bw.write(text);
		bw.newLine();
		bw.write("");
		System.out.println("일정이 등록되었습니다.");
		bw.close();
		Scheduler.topPage();
		scanner.close();

	}

	public static void scheduleSearch(String stringDate) throws ParseException {

		dateDate = new FormatSwitch(stringDate);
		date = dateDate.formatSwitch(stringDate);

		// Unlikely argument type FormatSwitch for get(Object) on a Map<Date,
		// String>
		String plan = scheduleMap.get(date); // FormatSwitch 클래스로 받은 값 date가
												// Date형식의 값을 가져올지 확싳치 않아서 나는 경고
		FileReader fr;

		if (new File("test.txt").exists()) {

			try {
				fr = new FileReader("test.txt");
				BufferedReader br = new BufferedReader(fr);
				String brString = null;

				while (((brString = br.readLine()) != null)) {

					String[] schedule = brString.split(" : ");
					plan = schedule[1];
					if (stringDate.equals(schedule[0])) {
						System.out.println(plan);
					} else {
						continue;
					}

				}
				br.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

			// 한줄씩 읽는 메소드가 readLine() 입니다.

		} else {
			System.out.println("아직 저장된 일정이 없습니다.");
		}

		Scheduler.topPage();

	}

}
