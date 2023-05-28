package lt.lhu.training08.controller.impl;

import java.util.Date;
import java.util.List;

import lt.lhu.training08.controller.Command;
import lt.lhu.training08.entity.Note;
import lt.lhu.training08.logic.LogicException;
import lt.lhu.training08.logic.LogicProvider;
import lt.lhu.training08.logic.NoteBookLogic;
import lt.lhu.training08.output.NotebookOutput;

public class FindByContentCommand implements Command {
	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {
		String[] params = request.split("\\s(?=(([^\']*\'){2})*[^\']*$)\\s*");// "FIND_BY_CONTENT content='" + content

		String content = params[1].split("=")[1];

		// ------------------------------

		String response = "";
		try {
			List<Note> notes = logic.find(content);

			response = NotebookOutput.convertNotesToString(notes);
		} catch (LogicException e) {
			response = "Error!!!";
		}

		return response;

	}

}
