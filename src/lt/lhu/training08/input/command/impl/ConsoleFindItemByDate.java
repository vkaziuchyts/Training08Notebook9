package lt.lhu.training08.input.command.impl;

import java.util.Scanner;

import lt.lhu.training08.controller.Controller;
import lt.lhu.training08.input.command.Command;

public class ConsoleFindItemByDate implements Command {
	private Controller controller = Controller.getInstance();

	@Override
	public void execute() {
		System.out.println("find item by date");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date in dd.MM.yyyy format. > ");
		String date = sc.nextLine();

		String request = "FIND_BY_DATE date=" + date;

		// ----------------------------------------------------------

		String response = controller.doAction(request);

		// ----------------------------------------------------------

		System.out.println(response);
	}
}
