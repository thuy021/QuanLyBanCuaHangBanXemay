package Entities;

import java.util.Date;

public class NhanVien_entity {
	private String maNV;
	private String hoTen;
	private String soCMND;
	private boolean gioiTinh;
	private String ngaySinh;
	private String email;
	private String soDienThoai;
	private String taiKhoan;
	private String matKhau;
	private String diachi;
	private String chucVu;
	public NhanVien_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

    public NhanVien_entity(String maNV, String hoTen, String soCMND, boolean gioiTinh, String ngaySinh, String email, String soDienThoai, String taiKhoan, String matKhau, String diachi, String chucVu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.soCMND = soCMND;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.diachi = diachi;
        this.chucVu = chucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "NhanVien_entity{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", soCMND=" + soCMND + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", email=" + email + ", soDienThoai=" + soDienThoai + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", diachi=" + diachi + ", chucVu=" + chucVu + '}';
    }
        

}
