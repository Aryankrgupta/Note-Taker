package application;

public class Notes {
	private String title;
	private String note;
	private String id;
	private String time;
	private String userId;
	
	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public Notes(String title, String note, String id, String time, String userId) {
		super();
		this.title = title;
		this.note = note;
		this.id = id;
		this.time = time;
		this.userId = userId;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public Notes(String title, String note, String id, String time) {
		this.title = title;
		this.note = note;
		this.id = id;
		this.time = time;
	}



	public Notes(String title, String note, String id) {
		this.title = title;
		this.note = note;
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Notes [title=" + title + ", note=" + note + ", id=" + id + "]";
	}
	
	
}
