package dto;

public class Admin {
	
	private Integer id;
	private String loginId;
	private String loginPass;
	private String name;
	
	public Admin(Integer id, String loginId, String loginPass, String name) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.loginPass = loginPass;
		this.name = name;
	}
	
	public void Admin1(Integer object, String string, String string2, String string3) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
