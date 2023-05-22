package lt.lhu.training08.input;

import lt.lhu.training08.input.command.Command;
import lt.lhu.training08.input.command.CommandProvider;
import lt.lhu.training08.input.command.MenuCommand;

public class ConsoleMenu {

	public void execute() {

		Command command = CommandProvider.getInstance().getCommand(MenuCommand.SHOW_MAIN_MENU);
		command.execute();
	}

}
