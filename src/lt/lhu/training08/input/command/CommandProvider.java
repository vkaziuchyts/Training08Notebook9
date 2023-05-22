package lt.lhu.training08.input.command;

import java.util.LinkedHashMap;
import java.util.Map;

import lt.lhu.training08.input.command.impl.ConsoleCreateNewItem;
import lt.lhu.training08.input.command.impl.ConsoleFindItemByContent;
import lt.lhu.training08.input.command.impl.ConsoleFindItemByDate;
import lt.lhu.training08.input.command.impl.ConsoleNoAction;
import lt.lhu.training08.input.command.impl.ConsoleShowAllNotes;
import lt.lhu.training08.input.command.impl.ConsoleShowFindMenu;
import lt.lhu.training08.input.command.impl.ConsoleShowMainMenu;

public final class CommandProvider {
	private static final CommandProvider instance = new CommandProvider();

	private Map<MenuCommand, Command> commands = new LinkedHashMap<>();

	private CommandProvider() {
		commands.put(MenuCommand.SHOW_MAIN_MENU, new ConsoleShowMainMenu());
		commands.put(MenuCommand.SHOW_FIND_MENU, new ConsoleShowFindMenu());
		commands.put(MenuCommand.CREATE_NEW_ITEM, new ConsoleCreateNewItem());
		commands.put(MenuCommand.FIND_BY_DATE, new ConsoleFindItemByDate());
		commands.put(MenuCommand.NO_MENU_ACTION, new ConsoleNoAction());
		commands.put(MenuCommand.SHOW_ALL_NOTES, new ConsoleShowAllNotes());
		commands.put(MenuCommand.FIND_BY_CONTENT, new ConsoleFindItemByContent());
	}

	public Command getCommand(MenuCommand commandName) {
		return commands.get(commandName);
	}

	public static CommandProvider getInstance() {
		return instance;
	}

}
