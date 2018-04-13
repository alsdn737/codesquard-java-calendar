package honux.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		// 해달 월의 일수를 구해줍니다.
		int[] daysOfEachMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int number = 0;

		// 繰り返しの回数
		System.out.println("繰り返しの回数を入力してください");
		Scanner scanner = new Scanner(System.in);
		int numberOfMonth = scanner.nextInt();
		int[] numberArray = new int[numberOfMonth];
		// 月を入力してください。

		System.out.println("月を入力してください。");
		for (int i = 0; i < numberOfMonth; i++) {
			number = scanner.nextInt();
			numberArray[i] = number;

		}
		for (int i = 0; i < numberOfMonth; i++) {
			number = numberArray[i];
			System.out.printf("%d월은 %d일까지 있습니다. \n", number, daysOfEachMonth[number - 1]);
		}

		scanner.close();

		System.out.println("  일   월   화   수   목   금   토");
		System.out.println("----------------------");
		System.out.println("  1  2  3  4  5  6  7");
		System.out.println("  8  9 10 11 12 13 14");
		System.out.println(" 15 16 17 18 19 20 21");
		System.out.println(" 22 23 24 25 26 27 28");

	}
}