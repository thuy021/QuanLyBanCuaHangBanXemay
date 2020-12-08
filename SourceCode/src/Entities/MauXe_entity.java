package Entities;

public class MauXe_entity {
	String maMau;
	String tenMau;
	public MauXe_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MauXe_entity(String maMau, String tenMau) {
		super();
		this.maMau = maMau;
		this.tenMau = tenMau;
	}
	public String getMaMau() {
		return maMau;
	}
	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	
}
