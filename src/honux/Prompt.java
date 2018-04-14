package honux;

import java.util.Scanner;

public class Prompt {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 해달 월의 일수를 구해줍니다.
		final String YEAR_PROMPT = "year> ";
		final String MONTH_PROMPT = "month> ";
		final String DAY_PROMPT = "day> ";

		int year = 0;
		int month = 0;
		String day = "";
		while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("년을 입력하세요.");
			System.out.print(YEAR_PROMPT);
			year = scanner.nextInt();

			System.out.println("월을 입력하세요.");
			System.out.print(MONTH_PROMPT);
			month = scanner.nextInt();

			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print(DAY_PROMPT);
			day = scanner.next();
			
			if (year == -1 || month <1 || month > 12){
				System.out.println("입력이 잘못되었습니다.");
				break;
			}
			
			else{
				Calendar.CalendarShowing(year, month, day);
			}

			}
		}

	}

