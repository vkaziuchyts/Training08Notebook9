package lt.lhu.training08.output;

import java.util.List;

import lt.lhu.training08.entity.Note;

public class NotebookOutput {
	private NotebookOutput() {
	}

	public static final String convertNotesToString(List<Note> notes) {
		if (notes == null || notes.size() <= 0) {
			return "Нет записей для вывода.";
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (Note n : notes) {
			stringBuilder.append(n.toString());
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

}
