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

import Entities.HangXe_entity;
import Entities.HoaDon_entity;
import Entities.HopDong_entity;
import Entities.KhachHang_entity;
import Entities.LoaiXe_entity;
import Entities.MauXe_entity;
import Entities.NhanVien_entity;
import Entities.XeMay_entity;

public class HopDong_model {
	Connection conn = null;
	PreparedStatement pst;
	ResultSet rs;

	// hóa đơn
	String get_dl_hd = "SELECT * FROM HoaDon";
	// Chi tiết hóa đơn
	String get_ct_hd = "SELECT * FROM ChiTietHoaDon";
	// xe
	String xe_id = "SELECT DISTINCT * FROM XeMay WHERE maXe=?";
    String xe_may="SELECT DISTINCT * from XeMay";
    String tenxe_id = "SELECT DISTINCT * FROM XeMay WHERE tenXe=?";
	//NV
	String nv_id = "SELECT DISTINCT * FROM NhanVien WHERE maNV=?";
	//KH
	String kh_id = "SELECT DISTINCT * FROM KhachHang WHERE maKH=?";
	//Hóa đơn
	String hd_id = "SELECT DISTINCT * FROM HoaDon WHERE maHD=?";
	// hang
	String hang_id = "SELECT DISTINCT * FROM HangXe WHERE maHangXe=?";
	// Loai
	String loai_id = "SELECT DISTINCT * FROM LoaiXe WHERE maLoaiXe=?";
	// Mau
	String mau_id = "SELECT DISTINCT * FROM MauXe WHERE maMauXe=?";

	//Hợp đồng
	String add_hd = "INSERT INTO HopDong (maHD,ngayLapHopDong) VALUES (?,?)";
	String get_dl_hdg = "SELECT * FROM HopDong";
	String hop_dong ="SELECT HopDong.maHopDong,HopDong.ngayLapHopDong,NhanVien.hoTen,NhanVien.ngaySinh,NhanVien.soCMND,KhachHang.hoTenKH,KhachHang.ngaySinh,KhachHang.soCMND,KhachHang.diaChi,XeMay.tenXe,XeMay.soKhung,XeMay.soMay,HangXe.tenHang,LoaiXe.tenLoaiXe,MauXe.mauXe,XeMay.giaXe,XeMay.dungTich,ChiTietHoaDon.soLuong\n"
                +"FROM HoaDon JOIN ChiTietHoaDon ON HoaDon.maHD = ChiTietHoaDon.maHD JOIN HopDong ON HoaDon.maHD = HopDong.maHD JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV JOIN XeMay ON ChiTietHoaDon.maXe = XeMay.maXe JOIN MauXe ON XeMay.maMauXe = MauXe.maMauXe JOIN LoaiXe ON XeMay.maLoaiXe = LoaiXe.maLoaiXe JOIN HangXe On XeMay.maHangXe = HangXe.maHangXe\n"
                +"WHERE HoaDon.maHD = HopDong.maHD";
	public ArrayList<HopDong_entity> get_hd() {
		ArrayList<HopDong_entity> ob_hd = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(get_dl_hdg);
			rs = pst.executeQuery();
			while (rs.next()) {
				HopDong_entity hd_e = new HopDong_entity();
				hd_e.setMaHopDong(rs.getString("maHopDong"));
				hd_e.setMaHoaDon(rs.getString("maHD"));
				hd_e.setNgayLapHopdong(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngayLapHopDong")));
				ob_hd.add(hd_e);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HopDong_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ob_hd;
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
				xm_e.setSoKhung(rs.getString("soKhung"));
				xm_e.setGiaXe(rs.getFloat("giaXe"));
				ob_id_xe.add(xm_e);
			}

		} catch (Exception e) {
		}
		return ob_id_xe;
	}

	/*
	 * Lấy mã nhân viên
	 */
	public ArrayList<NhanVien_entity> getIDNV(String ma_nv) {
		ArrayList<NhanVien_entity> ob_id_nv = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(nv_id);
			pst.setString(1, ma_nv);
			rs = pst.executeQuery();
			while (rs.next()) {
				NhanVien_entity nv_e = new NhanVien_entity();
				nv_e.setMaNV(rs.getString("maNV"));
				nv_e.setHoTen(rs.getString("hoTen"));	
				nv_e.setNgaySinh(rs.getString("ngaySinh"));
				nv_e.setSoCMND(rs.getString("soCMND"));
				ob_id_nv.add(nv_e);
			}

		} catch (Exception e) {
		}
		return ob_id_nv;
	}
	
	/*
	 * Lấy mã khách hàng
	 */
	public ArrayList<KhachHang_entity> getIDKH(String ma_kh) {
		ArrayList<KhachHang_entity> ob_id_kh = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(kh_id);
			pst.setString(1, ma_kh);
			rs = pst.executeQuery();
			while (rs.next()) {
				KhachHang_entity kh_e = new KhachHang_entity();
				kh_e.setMaKH(rs.getString("maKH"));
				kh_e.setHoTenKH(rs.getString("hoTenKH"));	
				kh_e.setNgaySinh(rs.getString("ngaySinh"));
				kh_e.setSoCMND(rs.getString("soCMND"));
				kh_e.setDiachi(rs.getString("diaChi"));
				ob_id_kh.add(kh_e);
			}

		} catch (Exception e) {
		}
		return ob_id_kh;
	}
	/*
	 * Lấy mã hóa đơn
	 */
	public ArrayList<HoaDon_entity> getIDHD(String ma_hd) {
		ArrayList<HoaDon_entity> ob_id_hd = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(hd_id);
			pst.setString(1, ma_hd);
			rs = pst.executeQuery();
			while (rs.next()) {
				HoaDon_entity hd_e = new HoaDon_entity();
				hd_e.setMaHoaDon(rs.getString("maHD"));
				hd_e.setNgayLapHoaDon(rs.getString("ngayLap"));
				
				ob_id_hd.add(hd_e);
			}

		} catch (Exception e) {
		}
		return ob_id_hd;
	}

	/*
	 * Lấy thông tin xe từ combobobx
	 */
	public ArrayList<XeMay_entity> getCombo_xe() {
		ArrayList<XeMay_entity> ob_xe = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(xe_may);
			rs = pst.executeQuery();
			while (rs.next()) {
				XeMay_entity xm_e = new XeMay_entity();
				xm_e.setMaXe(rs.getString("maXe"));
				xm_e.setTenXe(rs.getString("tenXe"));
				xm_e.setSoKhung(rs.getString("soKhung"));
				xm_e.setSoMay(rs.getString("soMay"));
				xm_e.setMa_Hang(rs.getString("maHangXe"));
				xm_e.setMa_Loai(rs.getString("maLoaiXe"));
				xm_e.setMa_Mau(rs.getString("maMauXe"));
				xm_e.setDungTich(rs.getInt("dungTich"));
				xm_e.setSoLuongXe(rs.getInt("soLuongXe"));
				xm_e.setGiaXe(rs.getFloat("giaXe"));
				xm_e.setBit(rs.getBytes("anhXe"));
				ob_xe.add(xm_e);
			}
		} catch (SQLException ex) {
			Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
		}

		return ob_xe;
	}
	
	/*
	 * Lấy ten xe
	 */
	public ArrayList<XeMay_entity> getIDTenXe(String ten_xe) {
		ArrayList<XeMay_entity> ob_id_xe = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(tenxe_id);
			pst.setString(1, ten_xe);
			rs = pst.executeQuery();
			while (rs.next()) {
				XeMay_entity xm_e = new XeMay_entity();
				xm_e.setTenXe(rs.getString("tenXe"));
				xm_e.setSoKhung(rs.getString("soKhung"));
				xm_e.setGiaXe(rs.getFloat("giaXe"));
				xm_e.setSoMay(rs.getString("soMay"));
				xm_e.setDungTich(rs.getInt("dungTich"));
				ob_id_xe.add(xm_e);
			}

		} catch (Exception e) {
		}
		return ob_id_xe;
	}
	
	/*
	 * Lấy mã hãng
	 */
	public ArrayList<HangXe_entity > getIDHang(String mahang) {
		ArrayList<HangXe_entity> ob_id_hang = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(hang_id);
			pst.setString(1, mahang);
			rs = pst.executeQuery();
			while (rs.next()) {
				HangXe_entity hang_e = new HangXe_entity();
				hang_e.setMaHang(rs.getString("maHangXe"));
				hang_e.setTenHang(rs.getString("tenHang"));
				
				ob_id_hang.add(hang_e);
			}

		} catch (Exception e) {
		}
		return ob_id_hang;
	}
	/*
	 * Lấy mã loại
	 */
	public ArrayList<LoaiXe_entity > getIDLoai(String maloai) {
		ArrayList<LoaiXe_entity> ob_id_loai = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(loai_id);
			pst.setString(1, maloai);
			rs = pst.executeQuery();
			while (rs.next()) {
				LoaiXe_entity loai_e = new LoaiXe_entity();
				loai_e.setMaLoaiXe(rs.getString("maLoaiXe"));
				loai_e.setTenLoaiXe(rs.getString("tenLoaiXe"));
				
				ob_id_loai.add(loai_e);
			}

		} catch (Exception e) {
		}
		return ob_id_loai;
	}
	
	/*
	 * Lấy mã màu
	 */
	public ArrayList<MauXe_entity > getIDMau(String mamau) {
		ArrayList<MauXe_entity> ob_id_mau = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(mau_id);
			pst.setString(1, mamau);
			rs = pst.executeQuery();
			while (rs.next()) {
				MauXe_entity loai_e = new MauXe_entity();
				loai_e.setMaMau(rs.getString("maMauXe"));
				loai_e.setTenMau(rs.getString("mauXe"));
				
				ob_id_mau.add(loai_e);
			}

		} catch (Exception e) {
		}
		return ob_id_mau;
	}
	/*
	 * Thêm hợp đồng
	 */
	public boolean add_hd(HopDong_entity hd_e) {
		boolean check = false;
		conn = openConnection();
		try {
			pst = conn.prepareCall(add_hd);
			pst.setString(1, hd_e.getMaHoaDon());
			pst.setString(2, hd_e.getNgayLapHopdong());
			int t = pst.executeUpdate();
			if (t > 0) {
				check = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(HopDong_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return check;
	}
        public ArrayList<HopDong_entity> hop_dong_output() {
           ArrayList<HopDong_entity> ob_hd=new ArrayList<>();
           ArrayList<NhanVien_entity> ob_nv=new ArrayList<>();
           ArrayList<KhachHang_entity> ob_kh=new ArrayList<>();
           ArrayList<XeMay_entity> ob_xm=new ArrayList<>();
           conn = openConnection();
           try{
               pst = conn.prepareCall(hop_dong);
               rs = pst.executeQuery();
               int x=0;
               while(rs.next()){
                   HopDong_entity hd_x = new HopDong_entity();
                   hd_x.setMaHopDong(rs.getString("maHopDong"));
                   hd_x.setMaHoaDon(rs.getString("maHD"));
                   hd_x.setNgayLapHopdong(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngayLapHopDong")));
                   ob_hd.add(hd_x);
                   NhanVien_entity nv = new NhanVien_entity();
                   nv.setHoTen(rs.getString("hoTen"));
                   nv.setNgaySinh(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngaySinh")));
                   nv.setSoCMND(rs.getString("soCMND"));
                   ob_nv.add(nv);
                   KhachHang_entity kh = new KhachHang_entity();
                   kh.setHoTenKH(rs.getString("hoTenKH"));
                   kh.setNgaySinh(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngaySinh")));
                   kh.setSoCMND(rs.getString("soCMND"));
                   kh.setDiachi(rs.getString("diaChi"));
                   ob_kh.add(kh);
               }
           }catch(SQLException ex){
               Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
           }
           return ob_hd;
	}
}
