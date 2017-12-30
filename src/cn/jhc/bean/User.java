package cn.jhc.bean;

public class User {
	private int id;
	private String username;
	private String password;
	private String filename;
	private String sex;
	private String interests;
	public User() {}
	public User(String username, String password, String filename, String sex, String interests) {
		super();
		this.username = username;
		this.password = password;
		this.filename = filename;
		this.sex = sex;
		this.interests = interests;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	
}
