package lt.lhu.training08.dao;

import java.util.List;

import lt.lhu.training08.entity.Note;

public interface NoteBookDao {
	
	void save(Note n) throws DaoException;

	List<Note> allNotes() throws DaoException;

}
