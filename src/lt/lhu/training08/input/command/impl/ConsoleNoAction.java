package lt.lhu.training08.input.command.impl;

import lt.lhu.training08.input.command.Command;

public class ConsoleNoAction implements Command {
	@Override
	public void execute() {
		System.out.println("Такое действие пока не выполняется. Извините.");
	}

}
