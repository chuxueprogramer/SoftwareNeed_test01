package bean;

import java.util.Date;

public class NeedBean {
	private int nd_id;
	private String nd_name;
	private String nd_ms;
	private String nd_type;
	private int nd_pa;
	private float nd_money;
	private int nd_state;
	private String nd_advice;
	private Date nd_time;
	
	public NeedBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNd_id() {
		return nd_id;
	}
	public void setNd_id(int nd_id) {
		this.nd_id = nd_id;
	}
	public String getNd_name() {
		return nd_name;
	}
	public void setNd_name(String nd_name) {
		this.nd_name = nd_name;
	}
	public String getNd_ms() {
		return nd_ms;
	}
	public void setNd_ms(String nd_ms) {
		this.nd_ms = nd_ms;
	}
	public String getNd_type() {
		return nd_type;
	}
	public void setNd_type(String nd_type) {
		this.nd_type = nd_type;
	}
	public int getNd_pa() {
		return nd_pa;
	}
	public void setNd_pa(int nd_pa) {
		this.nd_pa = nd_pa;
	}
	public float getNd_money() {
		return nd_money;
	}
	public void setNd_money(float nd_money) {
		this.nd_money = nd_money;
	}
	public int getNd_state() {
		return nd_state;
	}
	public void setNd_state(int nd_state) {
		this.nd_state = nd_state;
	}
	public String getNd_advice() {
		return nd_advice;
	}
	public void setNd_advice(String nd_advice) {
		this.nd_advice = nd_advice;
	}
	public Date getNd_time() {
		return nd_time;
	}
	public void setNd_time(Date nd_time) {
		this.nd_time = nd_time;
	}

	public NeedBean(String nd_name, String nd_ms, String nd_type, int nd_pa,
			float nd_money) {
		super();
		this.nd_name = nd_name;
		this.nd_ms = nd_ms;
		this.nd_type = nd_type;
		this.nd_pa = nd_pa;
		this.nd_money = nd_money;
	}
	
	
}
