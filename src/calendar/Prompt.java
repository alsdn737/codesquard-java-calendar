package calendar;

import java.util.Scanner;

public class Prompt {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 해달 월의 일수를 구해줍니다.
final String YEAR_PROMPT = "year> ";
final String MONTH_PROMPT = "month> ";

		int year = 0;
		int month = 0;		
	while(true){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("년을 입력하세요.");
		System.out.print(YEAR_PROMPT);
			 year = scanner.nextInt();
			
			System.out.println("월을 입력하세요.");
			System.out.print(MONTH_PROMPT);
			 month = scanner.nextInt();
			 
			 Calendar.CalendarShowing(year, month);
			 
			 if(month == -1){
				 break;
			 }
	}
			
	
	}				



}
