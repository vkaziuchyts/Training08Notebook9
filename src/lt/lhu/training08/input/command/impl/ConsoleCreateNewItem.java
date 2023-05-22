package lt.lhu.training08.input.command.impl;

import java.util.Scanner;

import lt.lhu.training08.controller.Controller;
import lt.lhu.training08.input.command.Command;

public class ConsoleCreateNewItem implements Command {
private Controller controller = Controller.getInstance();
	
	@Override
	public void execute() {
		String title;
		String content;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title > ");
		title = sc.nextLine();

		System.out.print("Enter content > ");
		content = sc.nextLine();

		String request = "ADD_NOTE title='" + title + "' content='" + content + "'";

		//----------------------------------------------------------
		
		String response;
		
		response = controller.doAction(request);
		
		//----------------------------------------------------------
		
		System.out.println(response);
		
	}
	

}