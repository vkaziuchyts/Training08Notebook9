package lt.lhu.training08.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lt.lhu.training08.dao.DaoException;
import lt.lhu.training08.dao.NoteBookDao;
import lt.lhu.training08.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	@Override
	public void save(Note n) throws DaoException {
		FileWriter writer = null;

		try {
			writer = new FileWriter("my_notes.txt", true);
			writer.write(n.toString());
			writer.write(System.lineSeparator());
		} catch (IOException e) {
			throw new DaoException("Failed to save note.", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					throw new DaoException("Failed to close FileWriter.", e);
				}
			}
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException {

		List<Note> notes = new ArrayList<>();
		BufferedReader reader = null;

		try {
			File file = new File("my_notes.txt");
			reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				Note note = Note.fromString(line); // Предполагается, что у вас есть метод fromString() для создания
													// объекта Note из строки
				notes.add(note);
			}
		} catch (IOException e) {
			throw new DaoException("Failed to read notes from file.", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DaoException("Failed to close BufferedReader.", e);
				}
			}
		}

		return notes;
	}

}
