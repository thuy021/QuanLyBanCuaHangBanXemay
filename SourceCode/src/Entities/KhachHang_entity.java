package Entities;

import java.util.Date;

public class KhachHang_entity {
	private String maKH;
	private String hoTenKH;
	private String soCMND;
	private boolean gioiTinh;
	private String ngaySinh;
	private String email;
	private String soDienThoai;
	private String diachi;
	public KhachHang_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

    public KhachHang_entity(String maKH, String hoTenKH, String soCMND, boolean gioiTinh, String ngaySinh, String email, String soDienThoai, String diachi) {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
        this.soCMND = soCMND;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diachi = diachi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "KhachHang_entity{" + "maKH=" + maKH + ", hoTenKH=" + hoTenKH + ", soCMND=" + soCMND + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", email=" + email + ", soDienThoai=" + soDienThoai + ", diachi=" + diachi + '}';
    }        
}
