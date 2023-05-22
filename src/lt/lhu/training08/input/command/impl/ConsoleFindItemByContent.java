package lt.lhu.training08.input.command.impl;

import lt.lhu.training08.controller.Controller;
import lt.lhu.training08.input.command.Command;

public class ConsoleFindItemByContent implements Command {
private Controller controller = Controller.getInstance();
	
	@Override
	public void execute() {
		
		String request = "FIND_BY_CONTENT content='kkkkk'";
		
		//----------------------------------------------
		
        String response;
		
		response = controller.doAction(request);
		
		//----------------------------------------------------------
		
		System.out.println(response);

	}

}