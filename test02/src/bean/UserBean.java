package bean;

public class UserBean {
	private int userid;
	private String username;
	private String password;
	private String phone;
	private String workplace;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public UserBean(String username, String password, String phone,
			String workplace) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.workplace = workplace;
	}
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
}
