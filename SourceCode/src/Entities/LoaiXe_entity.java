package Entities;

public class LoaiXe_entity {
	 String maLoaiXe;
	 String tenLoaiXe;
	public LoaiXe_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiXe_entity(String maLoaiXe, String tenLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.tenLoaiXe = tenLoaiXe;
	}
	public String getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	
}
