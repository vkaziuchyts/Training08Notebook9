package lt.lhu.training08.start;

import java.util.List;

import lt.lhu.training08.entity.Note;
import lt.lhu.training08.input.ConsoleMenu;
import lt.lhu.training08.logic.LogicException;
import lt.lhu.training08.logic.impl.NotebookLogicImpl;
import lt.lhu.training08.output.NotebookOutput;

public class Main {

	public static void main(String[] args) throws LogicException {
		ConsoleMenu menu = new ConsoleMenu();
		
		NotebookLogicImpl logic = new NotebookLogicImpl();
		
		logic.add("title1", "content1");
		logic.add("title2", "content2");
		logic.add("title3", "content3");
		
		List<Note> myNotes = logic.allNotes();
		
		NotebookOutput output = new NotebookOutput();
		
		output.print("all notes", myNotes);
		
		
	}

}
