package lt.lhu.training08.util;

import lt.lhu.training08.dao.DaoException;
import lt.lhu.training08.dao.DaoProvider;
import lt.lhu.training08.dao.NoteBookDao;
import lt.lhu.training08.entity.Note;

import java.util.List;

public class GenerateId {
	private static final GenerateId INSTANCE = new GenerateId();

	private final DaoProvider provider = DaoProvider.getInstance();

	private int nextId = 1;

	private GenerateId() {
		try {
			NoteBookDao dao = provider.getNoteBookDao();
			List<Note> notes = dao.allNotes();
			if (notes != null && !notes.isEmpty()) {
				nextId = notes.get(notes.size() - 1).getId();
				nextId++;
			}
		} catch (DaoException e) {
			System.out.println("The first run of the program, so there are no notes.");
		}
	}

	public int nextId() {
		return nextId++;
	}

	public static GenerateId getInstance() {
		return INSTANCE;
	}

}
