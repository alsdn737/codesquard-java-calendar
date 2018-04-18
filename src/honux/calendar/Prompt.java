package honux.calendar;

//import java.util.Scanner;

public class Prompt {

	public static void prompt(int year, int month, int remainder) {

		// 현재 날짜/시간 등의 각종 정보 얻기

		// 해달 월의 일수를 구해줍니다.

		int sumPlusDays = 0;
		/**
		 * 윤년과 윤년이 아닌 해로 분기처리 후 매달의 일수를 7로 나눈 나머지 만큼 더하는 방식으로 특정 달의 1일의 첫 요일을 계산
		 * 
		 */
		for (int i = 1; i <= year; i++) {

			if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {

				sumPlusDays = sumPlusDays + 2;

			} else {
				sumPlusDays = sumPlusDays + 1;
			}
		}
		remainder = sumPlusDays % 7;

		CalendarCalculator.CalendarShowing(year, month, remainder);
	}
}
