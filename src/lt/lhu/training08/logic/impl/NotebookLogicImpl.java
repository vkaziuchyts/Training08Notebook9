package lt.lhu.training08.logic.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import lt.lhu.training08.dao.DaoException;
import lt.lhu.training08.dao.DaoProvider;
import lt.lhu.training08.dao.NoteBookDao;
import lt.lhu.training08.entity.Note;
import lt.lhu.training08.logic.LogicException;
import lt.lhu.training08.logic.NoteBookLogic;

public class NotebookLogicImpl implements NoteBookLogic {

	private final DaoProvider provider = DaoProvider.getInstance();
	private final NoteBookDao dao = provider.getNoteBookDao();
	
	public void add(Note n) throws LogicException {
		
		try {
			dao.save(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	public void add(String title, String content) throws LogicException {

		Note n = new Note(title, content);
		try {
			dao.save(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	public List<Note> find(String text) throws LogicException{
		List<Note> result = new ArrayList<Note>();
		
		List<Note> myNotes = null;
		try {
			myNotes = dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		for(Note n : myNotes) {
			if(isTextInNote(n, text)) {
				result.add(n);
			}
		}
		
		return result;

	}
	
	private boolean isTextInNote(Note n, String text) {
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}
	
	
	public List<Note> find(Date date) throws LogicException{
		List<Note> result = new ArrayList<Note>();
		
		try {
			List<Note> myNotes = dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		// ...d1.equals(d2);
		
		return result;
		
	}
	

	public List<Note> allNotes() throws LogicException{
		try {
			return dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

}
