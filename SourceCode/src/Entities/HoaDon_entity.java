package Entities;

import java.util.Date;

public class HoaDon_entity {
	String maHoaDon;
	String maNV;
	String maKH;
	String ngayLapHoaDon;
	float tongTien;

	String maXe;
	int soLuong;
	float donGia;
	float thanhTien;
	float thueXe;
	int banChay;
    public  HoaDon_entity(){
        
    }

    public HoaDon_entity(String maHoaDon, String maNV, String maKH, String ngayLapHoaDon, float tongTien, String maXe, int soLuong, float donGia, float thanhTien, float thueXe, int banChay) {
        this.maHoaDon = maHoaDon;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
        this.maXe = maXe;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.thueXe = thueXe;
        this.banChay = banChay;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(String ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public float getThueXe() {
        return thueXe;
    }

    public void setThueXe(float thueXe) {
        this.thueXe = thueXe;
    }

    public int getBanChay() {
        return banChay;
    }

    public void setBanChay(int banChay) {
        this.banChay = banChay;
    }


}
