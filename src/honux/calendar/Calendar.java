package honux.calendar;

import java.util.Scanner;

public class Calendar {

public static void CalendarShowing(int year, int month) {
	int[] daysOfEachMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	Scanner scanner = 
		// 月を入力してください。

		while(true) {
			System.out.println("月を入力してください。");
			System.out.print("cal> ");
			
			int number = scanner.nextInt();
			if (number != -1) {

		
				System.out.printf("%d월은 %d일까지 있습니다. \n", number, daysOfEachMonth[number - 1]);
				System.out.printf("        <%4d년%3d월 달력>        \n", number );
				System.out.println("  일   월   화   수   목   금   토");
				System.out.println("----------------------");
				for (int i = 1; i <= daysOfEachMonth[number-1]; i++) {
					System.out.printf("%3d/n",i);
				}
				
			} else {

		}
	}
}
}