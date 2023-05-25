package lt.lhu.training08.input.command.impl;

import lt.lhu.training08.controller.Controller;
import lt.lhu.training08.input.command.Command;

public class ConsoleNoAction implements Command {
	private Controller controller = Controller.getInstance();

	@Override
	public void execute() {
		System.out.println("The user made an incorrect input");

		String request = "NO_SUCH_COMMAND";

		// ----------------------------------------------

		String response;

		response = controller.doAction(request);

		// ----------------------------------------------------------

		System.out.println(response);

	}

}
