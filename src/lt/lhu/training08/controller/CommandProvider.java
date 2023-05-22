package lt.lhu.training08.controller;

import java.util.HashMap;

import java.util.Map;

import lt.lhu.training08.controller.impl.AddNoteCommand;
import lt.lhu.training08.controller.impl.FindByContentCommand;
import lt.lhu.training08.controller.impl.FindByDateCommand;
import lt.lhu.training08.controller.impl.NoSuchCommand;
import lt.lhu.training08.controller.impl.ShowAllNotesCommand;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("ADD_NOTE", new AddNoteCommand());
		commands.put("FIND_BY_CONTENT", new FindByContentCommand());
		commands.put("NO_SUCH_COMMAND", new NoSuchCommand());
		commands.put("FIND_BY_DATE", new FindByDateCommand());
		commands.put("SHOW_ALL_NOTES", new ShowAllNotesCommand());
	}

	public Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		if (command == null) {
			command = commands.get("NO_SUCH_COMMAND");
		}

		return command;
	}

}
