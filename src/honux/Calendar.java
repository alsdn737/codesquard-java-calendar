package honux;

public class Calendar {

	public static void CalendarShowing(int year, int month, String day) {
		int[] datesOfEachMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29 };
		

			System.out.printf("%d월은 %d일까지 있습니다. \n", month, datesOfEachMonth[month - 1]);
			System.out.printf("   <%4d년%3d월 달력>   \n", year, month);
			System.out.println("  일   월   화   수   목   금   토");
			System.out.println("----------------------");

			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				switch (day) {
				case "SU":
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 일요일부터 시작하는 달은
						if (i % 7 == 0) {
							System.out.println();
						}
					}
					break;
				case "MO":
					System.out.print("   ");
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 6) {
							System.out.println();
						}
					}
					break;
				case "TU":
					System.out.printf("      ");
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 5) {
							System.out.println();
						}
					}

					break;
				case "WE":
					System.out.printf("         ");
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 4) {
							System.out.println();
						}
					}

					break;
				case "TH":
					System.out.printf("            ");
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 3) {
							System.out.println();
						}
					}

					break;
				case "FR":
					System.out.printf("               ");
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 2) {
							System.out.println();
						}
					}

					break;
				case "SA":
					System.out.printf("                  ");
					for (int i = 1; i <= datesOfEachMonth[12]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 1) {
							System.out.println();
						}
					}
					break;
				}
				System.out.println();
				System.out.println();
			} else {

				switch (day) {
				case "SU":
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 일요일부터 시작하는 달은
						if (i % 7 == 0) {
							System.out.println();
						}
					}
					break;
				case "MO":
					System.out.print("   ");
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 6) {
							System.out.println();
						}
					}
					break;
				case "TU":
					System.out.printf("      ");
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 5) {
							System.out.println();
						}
					}

					break;
				case "WE":
					System.out.printf("         ");
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 4) {
							System.out.println();
						}
					}

					break;
				case "TH":
					System.out.printf("            ");
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 3) {
							System.out.println();
						}
					}

					break;
				case "FR":
					System.out.printf("               ");
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 2) {
							System.out.println();
						}
					}

					break;
				case "SA":
					System.out.printf("                  ");
					for (int i = 1; i <= datesOfEachMonth[month - 1]; i++) {
						System.out.printf("%3d", i);
						// 월요일부터 시작하는 달은
						if (i % 7 == 1) {
							System.out.println();
						}
					}
					break;
				}
				System.out.println();
				System.out.println();
			}
		}
	}

