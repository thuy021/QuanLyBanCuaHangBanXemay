package Model;

import static Connection.ConnectionDB.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entities.HoaDon_entity;
import Entities.KhachHang_entity;
import Entities.NhanVien_entity;
import Entities.XeMay_entity;

public class QLHD_model {
    Connection conn = null;
    PreparedStatement pst;
    ResultSet rs;
/*
 * Truy vấn cơ sở dữ liệu từ databass
 */
    String get_dl_hd = "SELECT * FROM HoaDon";
    String get_ct_hd = "SELECT * FROM ChiTietHoaDon";
    String nv_id="SELECT * FROM NhanVien WHERE maNV=?";
    String kh_id="SELECT * FROM KhachHang WHERE maKH=?";
    String xe_id="SELECT DISTINCT * FROM XeMay WHERE maXe=?";
    String khachhang="SELECT * FROM KhachHang";
    String nhanvien = "SELECT * FROM NhanVien";
    
    /**
     * Lấy dữ liệu từ database lên table
     */
        public ArrayList<HoaDon_entity> get_hd() {
            ArrayList<HoaDon_entity> ob_hd = new ArrayList<>();
            conn = openConnection();
            try {
                pst = conn.prepareCall(get_dl_hd);
                rs = pst.executeQuery();
                while (rs.next()) {
                    HoaDon_entity hd_e = new HoaDon_entity();
                    hd_e.setMaHoaDon(rs.getString("maHD"));
                    hd_e.setMaNV(rs.getString("maNV"));
                    hd_e.setMaKH(rs.getString("maKH"));
                    hd_e.setNgayLapHoaDon(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngayLap")));
                    hd_e.setTongTien(rs.getFloat("tongTien"));
                    ob_hd.add(hd_e);

                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ob_hd;
        }
        /*
* Lấy dữ liệu chi tiết hóa đơn lên table
*/
   public ArrayList<HoaDon_entity> get_ct() {
       ArrayList<HoaDon_entity> ob_ct = new ArrayList<>();
       conn = openConnection();
       try {
           pst = conn.prepareCall(get_ct_hd);
           rs = pst.executeQuery();
           while (rs.next()) {
               HoaDon_entity hd_e = new HoaDon_entity();
               hd_e.setMaHoaDon(rs.getString("maHD"));
               hd_e.setMaXe(rs.getString("maXe"));
               hd_e.setSoLuong(rs.getInt("soLuong"));
               hd_e.setDonGia(rs.getFloat("donGia"));
               hd_e.setThanhTien(rs.getFloat("thanhTien"));
               hd_e.setThueXe(rs.getFloat("thueXe"));
               ob_ct.add(hd_e);

           }
       } catch (SQLException ex) {
           Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
       }
       return ob_ct;
   }
   /*
* Lấy mã nhân viên
*/
 public ArrayList<NhanVien_entity> getIDnhanvien(String ma_nv){
     ArrayList<NhanVien_entity> ob_id_nv=new ArrayList<>();
     conn=openConnection();
     try {
         pst=conn.prepareCall(nv_id);
         pst.setString(1,ma_nv);
         rs=pst.executeQuery();
         while(rs.next()){
             NhanVien_entity nv_e=new NhanVien_entity();
             nv_e.setTaiKhoan(rs.getString("maNV"));
             nv_e.setHoTen(rs.getString("hoTen"));
             nv_e.setSoCMND(rs.getString("soCMND"));
            // nv_e.setGioiTinh(rs.getString("gioiTinh"));
             nv_e.setNgaySinh(rs.getString("ngaySinh"));
             nv_e.setEmail(rs.getString("email"));
             nv_e.setSoDienThoai(rs.getString("soDienThoai"));
             nv_e.setTaiKhoan(rs.getString("taiKhoan"));
             nv_e.setMatKhau(rs.getString("matKhau"));
             nv_e.setDiachi(rs.getString("diaChi"));
             nv_e.setChucVu(rs.getString("chucVu"));
             ob_id_nv.add(nv_e);
         }
         
     } catch (Exception e) {
     }
     return ob_id_nv;
 }
  /*
* Lấy mã khách hàng
*/
   public ArrayList<KhachHang_entity> getIDkhachhang(String ma_kh){
     ArrayList<KhachHang_entity> ob_id_kh=new ArrayList<>();
     conn=openConnection();
     try {
         pst=conn.prepareCall(kh_id);
         pst.setString(1,ma_kh);
         rs=pst.executeQuery();
         while(rs.next()){
             KhachHang_entity kh_e=new KhachHang_entity();
             kh_e.setMaKH(rs.getString("maKH"));
             kh_e.setHoTenKH(rs.getString("hoTenKH"));
             ob_id_kh.add(kh_e);
         }
         
     } catch (Exception e) {
     }
     return ob_id_kh;
 }
    /*
* Lấy mã xe
*/
	public ArrayList<XeMay_entity> getIDxe(String ma_xe) {
		ArrayList<XeMay_entity> ob_id_xe = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(xe_id);
			pst.setString(1, ma_xe);
			rs = pst.executeQuery();
			while (rs.next()) {
				XeMay_entity xm_e = new XeMay_entity();
				xm_e.setMaXe(rs.getString("maXe"));
				xm_e.setTenXe(rs.getString("tenXe"));
				xm_e.setGiaXe(rs.getFloat("giaXe"));
				ob_id_xe.add(xm_e);
			}

		} catch (Exception e) {
		}
		return ob_id_xe;
	}
	 /*
	 * Lấy thông tin của khách hàng từ combobox
	 */
	    public ArrayList<KhachHang_entity> getComboKH(){
	        ArrayList<KhachHang_entity> ob_kh=new ArrayList<>();
	        //mở connection
	        conn=openConnection();
	        try {
	            pst=conn.prepareCall(khachhang);
	            rs=pst.executeQuery();
	            while(rs.next()){
	                KhachHang_entity kh=new KhachHang_entity();
	                kh.setMaKH(rs.getString("maKH"));
	                kh.setHoTenKH(rs.getString("hoTenKH"));
	                kh.setSoCMND(rs.getString("soCMND"));
	                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
	                kh.setNgaySinh(rs.getString("ngaySinh"));
	                kh.setEmail(rs.getString("email"));
	                kh.setSoDienThoai(rs.getString("soDienThoai"));
	                kh.setDiachi(rs.getString("diaChi"));
	                ob_kh.add(kh);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(khachHang_model.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return ob_kh;
	    }
	    public ArrayList<NhanVien_entity> getComboNV(){
	        ArrayList<NhanVien_entity> ob_nv=new ArrayList<>();
	        //mở connection
	        conn=openConnection();
	        try {
	            pst=conn.prepareCall(nhanvien);
	            rs=pst.executeQuery();
	            while(rs.next()){
	            	NhanVien_entity nv=new NhanVien_entity();
	            	nv.setMaNV(rs.getString("maNV"));
	            	nv.setHoTen(rs.getString("hoTen"));
	            	nv.setSoCMND(rs.getString("soCMND"));
	            	nv.setGioiTinh(rs.getBoolean("gioiTinh"));
	            	nv.setNgaySinh(rs.getString("ngaySinh"));
	            	nv.setEmail(rs.getString("email"));
	            	nv.setSoDienThoai(rs.getString("soDienThoai"));
	                nv.setTaiKhoan(rs.getString("taiKhoan"));
	                nv.setMatKhau(rs.getString("matKhau"));
	            	nv.setDiachi(rs.getString("diaChi"));
	            	nv.setChucVu(rs.getString("chucVu"));
	                ob_nv.add(nv);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(NhanVien_model.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return ob_nv;
	    }

}
