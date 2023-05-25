package lt.lhu.training08.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lt.lhu.training08.controller.Command;
import lt.lhu.training08.entity.Note;
import lt.lhu.training08.logic.LogicException;
import lt.lhu.training08.logic.LogicProvider;
import lt.lhu.training08.logic.NoteBookLogic;
import lt.lhu.training08.output.NotebookOutput;

public class FindByDateCommand implements Command {
	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {
		String[] params = request.split("\\s+");// "FIND_BY_DATE date='29.04.2023'"

		String dateString = params[1].split("=")[1];// 29.04.2023

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");

		// ========================

		String response = "";

		try {
			Date date = format.parse(dateString);
			List<Note> notes = logic.find(date);

			response = NotebookOutput.convertNotesToString(notes);
		} catch (LogicException e) {
			response = "Error!!!";
		} catch (ParseException e) {
			response = "Parsing date error! Date should be in dd.MM.yyyy format.";
		}

		return response;
	}
}
