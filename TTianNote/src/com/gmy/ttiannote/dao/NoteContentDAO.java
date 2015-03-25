package com.gmy.ttiannote.dao;

public class NoteContentDAO {
	         /*_id 
			+ "title varchar(50),"
			+ "content varchar(50),"
			+ "imagePath varchar(50),"
			+ "time varchar(50)"
			+ ")";
	*/
	private int _id;
	private String title;
	private String content;
	private String imagePath;
	private String time;
	
	
	public NoteContentDAO() {
		// TODO Auto-generated constructor stub
	}


	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
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


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
}
