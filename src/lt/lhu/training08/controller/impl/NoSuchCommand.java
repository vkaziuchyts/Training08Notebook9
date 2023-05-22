package lt.lhu.training08.controller.impl;

import lt.lhu.training08.controller.Command;

public class NoSuchCommand implements Command{

	@Override
	public String execute(String request) {

		return "No such command!";
	}

}
