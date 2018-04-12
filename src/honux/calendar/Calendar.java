package honux.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
// 해달 월의 일수를 구해줍니다.
		System.out.println("  일   월   화   수   목   금   토");
		System.out.println("----------------------");
		System.out.println("  1  2  3  4  5  6  7");
		System.out.println("  8  9 10 11 12 13 14");
		System.out.println(" 15 16 17 18 19 20 21");
		System.out.println(" 22 23 24 25 26 27 28");

		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		int k = Integer.parseInt(number);
		int[] j = { 28, 30, 31 };
		if (k == 1 || k == 3 || k == 5 || k == 7 || k == 8 || k == 10 || k == 12) {
			System.out.printf("%d월은 %d일까지 있습니다.", k, j[2]);
		}
		;
		if (k == 4 || k == 6 || k == 9 || k == 11) {
			System.out.printf("%d월은 %d일까지 있습니다.", k, j[1]);
		}
		;
		if (k == 2) {
			System.out.printf("%d월은 %d일까지 있습니다.", k, j[0]);
		}
		scanner.close();
	}
}
