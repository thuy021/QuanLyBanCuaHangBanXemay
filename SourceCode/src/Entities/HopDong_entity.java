package Entities;

import java.util.Date;

public class HopDong_entity {
	private String maHopDong;
	private String maHoaDon;
	private String ngayLapHopdong;
	public HopDong_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDong_entity(String maHopDong, String maHoaDon, String ngayLapHopdong) {
		super();
		this.maHopDong = maHopDong;
		this.maHoaDon = maHoaDon;
		this.ngayLapHopdong = ngayLapHopdong;
	}
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getNgayLapHopdong() {
		return ngayLapHopdong;
	}
	public void setNgayLapHopdong(String ngayLapHopdong) {
		this.ngayLapHopdong = ngayLapHopdong;
	}
	

}
