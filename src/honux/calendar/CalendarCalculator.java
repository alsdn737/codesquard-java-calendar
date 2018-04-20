package honux.calendar;

import java.util.Date;
import java.util.HashMap;

public class CalendarCalculator {
	static HashMap<Date, String> scheduleMap = new HashMap<Date, String>();

	public static void CalendarShowing(int year, int month, int remainder) {
		int[] datesOfEachMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] datesOfLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] plusDays = { 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
		int[] plusDaysOfLeapYear = { 3, 1, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
		int sumDays = 0;

		String space = "   ";

		System.out.printf("   <%4d년%3d월 달력>   \n", year, month);
		System.out.println("  일   월   화   수   목   금   토");
		System.out.println("----------------------");

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {

			for (int i = 0; i < (month - 1); i++) {
				sumDays = sumDays + plusDaysOfLeapYear[i];
			}
			remainder = (remainder + sumDays) % 7;

			for (int i = 0; i < remainder; i++) {
				System.out.print(space);
			}

			for (int i = 1; i <= datesOfLeapYear[month - 1]; i++) {

				System.out.printf("%3d", i);
				if (remainder == 0) {
					if (i == datesOfLeapYear[month - 1] && i % 7 == 0) {
						continue;
					} else if (i % 7 == 0 && i != datesOfLeapYear[month - 1]) {
						System.out.println();
					}
				} else if (i % 7 == (7 - remainder) && i != datesOfEachMonth[month - 1]) {
					System.out.println();
					System.out.println();
				}
			}
		}

		else {

			for (int i = 0; i < (month - 1); i++) {
				sumDays = sumDays + plusDays[i];
			}
			remainder = (remainder + sumDays) % 7;

			for (int i = 0; i < remainder; i++) {
				System.out.print(space);
			}

			// Calendar.getInstance()Scheduler.scheduleRegister(stringDate);
			for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {

				System.out.printf("%3d", i);
				if (remainder == 0) {
					if (i == datesOfEachMonth[month - 1] && i % 7 == 0) {
						break;
					} else if (i % 7 == 0 && i != datesOfEachMonth[month - 1]) {
						System.out.println();
					}
				} else if (i % 7 == (7 - remainder) && i != datesOfEachMonth[month - 1]) {
					System.out.println();
				}
			}
		}

		System.out.println();
		System.out.println();
	}

}