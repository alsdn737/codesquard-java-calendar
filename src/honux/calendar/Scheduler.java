package honux.calendar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*
* +----------------------+
*| 1. 일정 등록           
*| 2. 일정 검색           
*| 3. 달력 보기
*| h. 도움말 q. 종료
*+----------------------+
*명령 (1, 2, 3, h, q)
*> 1
*[일정 등록] 날짜를 입력하세요.
*> 2016-06-05
*일정을 입력하세요.
*> 자바지기에게 밥 얻어먹기
*일정이 등록되었습니다.
*명령 (1, 2, 3, h, q)
*>  2
*[일정 검색] 날짜를 입력하세요.
*> 2016-06-05
*1개의 일정이 있습니다.
*1. 자바지기에게 밥 얻어먹기
*명령 (1, 2, 3, h, q)
*q
*Bye
* @author トマト
*
*/

public class Scheduler {
	static String stringDate;
	static String toDo;
	static Map<Date, ArrayList<String>> scheduleMap = new HashMap<Date, ArrayList<String>>();
	ArrayList<String> schedule;
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> scheduleofTheDate = new ArrayList<String>();


	
public static void main(String [] args) {
	
	
			Calendar cal = Calendar.getInstance();
			String stringYear = String.valueOf(cal.get(Calendar.YEAR));
			String stringMonth = String.valueOf((cal.get(Calendar.MONTH)+1));
int year =	Integer.parseInt(stringYear);
int month =	Integer.parseInt(stringMonth);

int remainder = 0;
Prompt.prompt(year, month, remainder);
	topPage();
	
};

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
		System.out.println("[일정 등록] 날짜를 입력하세요. ex)1989-02-23");

		System.out.print("> ");
		//ex) 2016-06-05  "-"`을 기준으로 자르기.
		stringDate = scanner.next();
		System.out.println("일정을 입력하세요.");
		System.out.print("> ");
		Scanner scheduleInput = new Scanner(System.in);
		toDo = scheduleInput.nextLine();	

	
		try {

			scheduleRegister(stringDate, toDo);
		} catch (ParseException e) {

			e.printStackTrace();
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
		System.out.println("[일정 변경] 날짜를 입력하세요. ex)2018-04-18");
		System.out.print("> ");
		stringDate = scanner.next();
		try {
			scheduleRevise(stringDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		
		break;
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



public static void scheduleRegister(String stringDate, String toDo) throws ParseException {

	//toDo를 저장해야 하는
	
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
	scheduleMap.put(date, scheduleofTheDate);
	System.out.println("일정이 등록되었습니다.");
	Scheduler.topPage();
}

public static String scheduleSearch(String stringDate) throws ParseException {
	
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
	ArrayList<String> plan = scheduleMap.get(date);
	if(plan == null) {
		System.out.println("일정이 없습니다.");
	}
	else {
	 for (int i = 1; i < plan.size()+1; i++) {
		System.out.printf("%d. ",i);
		System.out.println(plan.get(i));
	}
			
		
	System.out.println(plan);
	}
	Scheduler.topPage();
	return "";
	
}

public static void scheduleRevise(String stringDate) throws ParseException {
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
	if (date== null) {
		System.out.println("날짜를 다시 입력해 주세요.");
	}
	else {
	System.out.println("변경된 일정을 입력하세요.");
	System.out.println(scheduleMap.get(date));
	System.out.print("> ");
	Scanner scheduleInput = new Scanner(System.in);
	toDo = scheduleInput.nextLine();	
	scheduleMap.put(date, scheduleofTheDate);
	System.out.println("일정이 변경되었습니다.");
	Scheduler.topPage();
	scheduleInput.close();
	}
}

}
