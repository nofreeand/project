package com.gmy.ttiannote.dao;

public class NoteContentDAO {
	/*"(_id integer primary key autoincrement,"
			+ "title varchar(50),"
			+ "content varchar(50),"
			+ "imagePathOne varchar(50),"
			+ "imagePathTwo varchar(50),"
			+ "imagePathThree varchar(50),"
			+ "imagePathFour varchar(50),"
			+ "time varchar(50)"
			+ ")";*/
	private int _id;
	private String title;
	private String content;
	private String imagePathOne;
	private String imagePathTwo;
	private String imagePathThree;
	private String imagePathFour;
	private String time;
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
	public String getImagePathOne() {
		return imagePathOne;
	}
	public void setImagePathOne(String imagePathOne) {
		this.imagePathOne = imagePathOne;
	}
	public String getImagePathTwo() {
		return imagePathTwo;
	}
	public void setImagePathTwo(String imagePathTwo) {
		this.imagePathTwo = imagePathTwo;
	}
	public String getImagePathThree() {
		return imagePathThree;
	}
	public void setImagePathThree(String imagePathThree) {
		this.imagePathThree = imagePathThree;
	}
	public String getImagePathFour() {
		return imagePathFour;
	}
	public void setImagePathFour(String imagePathFour) {
		this.imagePathFour = imagePathFour;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "NoteContentDAO [_id=" + _id + ", title=" + title + ", content="
				+ content + ", imagePathOne=" + imagePathOne
				+ ", imagePathTwo=" + imagePathTwo + ", imagePathThree="
				+ imagePathThree + ", imagePathFour=" + imagePathFour
				+ ", time=" + time + "]";
	}
	
}
