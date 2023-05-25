package lt.lhu.training08.input;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lt.lhu.training08.entity.Note;

public class Display {

	public void printMenu(ConcreteMenu m) {

		Set<Map.Entry<Integer, String>> items = m.getItems();
		for (Map.Entry<Integer, String> item : items) {
			System.out.println(item.getKey() + " " + item.getValue());
		}
	}

	public void printNotes(List<Note> notes) {
		String message = (notes == null || notes.isEmpty()) ? "Заметки не найдены" : "";
		System.out.println(message);
		for (Note note : notes) {
			System.out.println(note);
		}
	}
}
