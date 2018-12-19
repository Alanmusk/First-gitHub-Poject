package entity;

public class ApplyInfo {
	
	private int applyId;
	private String name;
	private int age;
	private String classRoom;
	private String game;
	
	
	public ApplyInfo() {
		super();
	}
	public ApplyInfo(int applyId, String name, int age, String classRoom, String game) {
		super();
		this.applyId = applyId;
		this.name = name;
		this.age = age;
		this.classRoom = classRoom;
		this.game = game;
	}
	
	public ApplyInfo( String name, int age, String classRoom, String game) {
		super();		
		this.name = name;
		this.age = age;
		this.classRoom = classRoom;
		this.game = game;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	
	
	
}
