package lt.lhu.training08.input.command.impl;

import lt.lhu.training08.controller.Controller;
import lt.lhu.training08.input.command.Command;

public class ConsoleShowAllNotes implements Command {
	private Controller controller = Controller.getInstance();

	@Override
	public void execute() {
		System.out.println("show all notes");

		String request = "SHOW_ALL_NOTES";

		// ----------------------------------------------

		String response;

		response = controller.doAction(request);

		// ----------------------------------------------------------

		System.out.println(response);

	}

}
