package lt.lhu.training08.controller.impl;

import java.util.List;

import lt.lhu.training08.controller.Command;
import lt.lhu.training08.entity.Note;
import lt.lhu.training08.logic.LogicException;
import lt.lhu.training08.logic.LogicProvider;
import lt.lhu.training08.logic.NoteBookLogic;
import lt.lhu.training08.output.NotebookOutput;

public class ShowAllNotesCommand implements Command {
	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {

		String response = "";

		try {
			List<Note> notes = logic.allNotes();

			response = NotebookOutput.convertNotesToString(notes);
		} catch (LogicException e) {
			response = "Error!!!";
		}

		return response;
	}

}
