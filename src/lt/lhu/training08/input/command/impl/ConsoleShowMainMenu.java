package lt.lhu.training08.input.command.impl;

import lt.lhu.training08.input.ConcreteMenu;
import lt.lhu.training08.input.Display;
import lt.lhu.training08.input.InputTerminal;
import lt.lhu.training08.input.Menu;
import lt.lhu.training08.input.MenuBuilder;
import lt.lhu.training08.input.MenuSelectionSystem;
import lt.lhu.training08.input.command.Command;
import lt.lhu.training08.input.command.CommandProvider;
import lt.lhu.training08.input.command.MenuCommand;

public class ConsoleShowMainMenu implements Command {
	private MenuSelectionSystem menuSystem = MenuBuilder.getInstance().getMenuSystem();
	private Display display = MenuBuilder.getInstance().getDisplay();
	private InputTerminal terminal = MenuBuilder.getInstance().getTerminal();

	@Override
	public void execute() {
		ConcreteMenu menu;
		CommandProvider provider = CommandProvider.getInstance();

		menu = menuSystem.getMenu(Menu.MAIN_MENU);
		int decision;
		while ((decision = doChoose(menu)) != MenuCommand.EXIT_CODE.getConsoleCode()) {

			Command command = provider.getCommand(MenuCommand.valueOf(decision));
			command.execute();

		}

	}

	private int doChoose(ConcreteMenu m) {
		int decision;

		display.printMenu(m);
		decision = terminal.input();

		return decision;
	}

}