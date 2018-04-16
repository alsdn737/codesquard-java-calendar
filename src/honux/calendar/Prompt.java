package honux.calendar;

import java.util.Scanner;

public class Prompt {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 해달 월의 일수를 구해줍니다.
		final String YEAR_PROMPT = "year> ";
		final String MONTH_PROMPT = "month> ";
		int year = 0;
		int month = 1;
		
		int[] plusDays = { 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
		int[] plusDaysOfLeapYear = { 3, 1, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
		String[] daysOfWeek = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

		int leapYear = 0;
		int notLeapYear = 0;
		int sumYear = 0;


		int sumPlusDays = 0;
		int remainder = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("년을 입력하세요.");
		System.out.print(YEAR_PROMPT);
		year = scanner.nextInt();

		System.out.println("월을 입력하세요.");
		System.out.print(MONTH_PROMPT);
		month = scanner.nextInt();

		
		/**
		 * 윤년과 윤년이 아닌 해로 분기처리 후
		 * 매달의 일수를 7로 나눈 나머지 만큼 더하는 방식으로 특정 달의 1일의 첫 요일을 계산
		 *  
		 */
		for (int i = 0; i < year; i++) {

			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				leapYear = leapYear + 1;
				sumPlusDays = sumPlusDays + 2;
				for (int j = 0; j < month-1 ; j++) {
					sumPlusDays = sumPlusDays + plusDaysOfLeapYear[j];
				}
			} else {
				notLeapYear = notLeapYear + 1;
				sumPlusDays = sumPlusDays + 1;
				// System.out.println("sumPlusDays : "+ );
				
				for (int j = 0; j < month-1 ; j++) {
					sumPlusDays = sumPlusDays + plusDays[j];
				}
				
			}

		}
		
		

		sumYear = leapYear + notLeapYear;
		System.out.println("sumYear : " + sumYear);
		System.out.println("sumPlusDays : " + sumPlusDays);
		remainder = sumPlusDays % 7;
		System.out.println("remainder : " + remainder);
		System.out.println("dayofWeek : " + daysOfWeek[remainder]);

	

	 Calendar.CalendarShowing(year, month, remainder);
	}
}
