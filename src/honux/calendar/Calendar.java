package honux.calendar;

public class Calendar {

	public static void CalendarShowing(int year, int month, int remainder) {
		int[] datesOfEachMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] datesOfLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		String space = "   ";

		System.out.printf("%d월은 %d일까지 있습니다. \n", month, datesOfEachMonth[month - 1]);
		System.out.printf("   <%4d년%3d월 달력>   \n", year, month);
		System.out.println("  일   월   화   수   목   금   토");
		System.out.println("----------------------");

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {

			for (int i = 0; i < remainder; i++) {
				System.out.print(space);
			}

			for (int i = 1; i <= datesOfLeapYear[month - 1]; i++) {

				System.out.printf("%3d", i);
				if (remainder == 0) {
					if (i % 7 == 0) {
						System.out.println();
					}
				} else if (i % 7 == (remainder - 1)) {
					System.out.println();
				}
			}
		} else {
			for (int i = 0; i < remainder; i++) {
				System.out.print(space);
			}

			for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {

				System.out.printf("%3d", i);
				if (remainder == 0) {
					if (i % 7 == 0) {
						System.out.println();
					}
				} else if (i % 7 == (remainder - 1)) {
					System.out.println();
				}
			}
		}

		System.out.println();
		System.out.println();
	}
}
