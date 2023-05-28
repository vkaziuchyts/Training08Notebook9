package lt.lhu.training08.controller.impl;

import lt.lhu.training08.controller.Command;

import lt.lhu.training08.logic.LogicException;
import lt.lhu.training08.logic.LogicProvider;
import lt.lhu.training08.logic.NoteBookLogic;

public class AddNoteCommand implements Command {
	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();
	
	@Override
	public String execute(String request) {
		String[] params = request.split("\\s(?=(([^\']*\'){2})*[^\']*$)\\s*");
		
		String title = params[1].split("=")[1];
		String content = params[2].split("=")[1];
		
		String response = "";
		
		try {
			logic.add(title, content);
			response = "Your note wad added in notebook.";
		} catch (LogicException e) {
			response = "Error!!!";
		}
		
		return response;
	}

}
