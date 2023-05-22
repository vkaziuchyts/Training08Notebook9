package lt.lhu.training08.logic;

import lt.lhu.training08.logic.impl.NotebookLogicImpl;

public final class LogicProvider {
	private static final LogicProvider INSTANCE = new LogicProvider();

	private final NoteBookLogic noteBookLogic = new NotebookLogicImpl();

	public NoteBookLogic getNoteBookLogic() {
		return noteBookLogic;
	}

	public static LogicProvider getInstance() {
		return INSTANCE;
	}

}
