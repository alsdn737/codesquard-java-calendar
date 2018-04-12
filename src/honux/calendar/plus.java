package honux.calendar;

import java.util.Scanner;

public class plus {
// 두 수의 합을 구하는 프로그램을 만든다.
	public static void main(String [] args) {
	Scanner scanner = new Scanner(System.in);
	String twoNumbers = scanner.nextLine();
	String[] splitNum = twoNumbers.split(" ");
	int first = Integer.parseInt(splitNum[0]);
	int second = Integer.parseInt(splitNum[1]);
	System.out.printf("%d와 %d의 합은 %d입니다.", first, second, (first + second));
	
	
}
}