package lt.lhu.training08.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Objects;

import lt.lhu.training08.util.GenerateId;

public class Note {

	private int id;
	private String title;
	private String content;
	private Date d;

	public Note() {
	}

	public Note(int id, String title, String content, Date d) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.d = d;
	}

	public Note(String title, String content, Date d) {
		this.id = GenerateId.getInstance().nextId();
		this.title = title;
		this.content = content;
		this.d = d;
	}

	public Note(String title, String content) {
		this.id = GenerateId.getInstance().nextId();
		this.title = title;
		this.content = content;
		this.d = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, d, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(content, other.content) && Objects.equals(d, other.d) && id == other.id
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", d=" + format.format(d) + "]";
	}

	public String serializeToString() {
		return "Note id=" + id + " title=" + title + " content=" + content + " d=" + d.getTime();
	}

	public static Note deserializeFromString(String line) {
		String[] params = line.split("\\s+");

		String id = params[1].split("=")[1];
		String title = params[2].split("=")[1];
		String content = params[3].split("=")[1];
		String date = params[4].split("=")[1];

		// Создать новый объект типа "Note"
		Note note = new Note();

		// Присвоить значения разделенных частей объекту "Note"
		note.setId(Integer.parseInt(id));
		note.setTitle(title);
		note.setContent(content);
		note.setD(new Date(Long.parseLong(date)));

		// Вернуть объект "Note"
		return note;
	}
}
