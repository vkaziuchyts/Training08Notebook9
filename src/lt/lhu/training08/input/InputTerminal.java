package lt.lhu.training08.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputTerminal {

	private Scanner sc = new Scanner(System.in);

	public int input() {

		int variant = 0;

		System.out.println(" - Make a choice. >");
		if (sc.hasNextInt()) {
			variant = sc.nextInt();
			return variant;
		} else {
			sc.nextLine();
			System.out.println(" Not valid input");
			return -1;
		}
	}

	public String inputTitle() {

		String title = null;

		System.out.println(" - Enter title. >");

		while (title == null || title == "") {
			title = sc.nextLine();
		}

		return title;
	}

	public String inputContent() {

		String content = null;

		System.out.println(" - Enter content. >");

		while (content == null || content == "") {
			content = sc.nextLine();
		}

		return content;
	}

	public Date inputDate() throws ParseException {

		String date = null;
		System.out.println(" - Enter date in dd.MM.yyyy format. >");

		while (date == null || date == "") {

			date = sc.nextLine();
		}

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");

		return format.parse(date);
	}

}
