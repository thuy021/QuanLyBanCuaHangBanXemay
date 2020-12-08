/*
 * author: Mai Thị Thanh Thúy
 */
package Model;

import static Connection.ConnectionDB.openConnection;
import Entities.HoaDon_entity;
import Entities.KhachHang_entity;
import Entities.NhanVien_entity;
import Entities.XeMay_entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDon_model {
	Connection conn = null;
	PreparedStatement pst;
	ResultSet rs;
	/*
	 * Truy vấn cơ sở dữ liệu từ databass
	 */
	String get_dl_hd = "SELECT * FROM HoaDon";
	String add_hd = "INSERT INTO HoaDon (maNV,maKH,ngayLap,tongTien) VALUES (?,?,?,?)";
	String nv_id = "SELECT * FROM NhanVien WHERE maNV=?";
	String kh_id = "SELECT * FROM KhachHang WHERE maKH=?";
	String nhanvien = "SELECT * FROM NhanVien order by hoTen asc";
	String khachhang = "SELECT * FROM KhachHang order by maKH DESC ";
	// chi tiết hóa đơn
	String get_ct_hd = "SELECT * FROM ChiTietHoaDon";
	String add_ct = "INSERT INTO ChiTietHoaDon (maHD,maXe,soLuong,donGia,thanhTien,thueXe) VALUES (?,?,?,?,?,?)";
	String xe_may = "SELECT DISTINCT * from XeMay";
	String xe_id = "SELECT DISTINCT * FROM XeMay WHERE maXe=?";
	String tongtien = "select sum(thanhTien) from ChiTietHoaDon group by maHD";

	String xuat_xe_hd = "UPDATE HoaDon  WHERE maHD=?";
	String xuat_xe_ct = "UPDATE ChiTietHoaDon WHERE maHD=?";
	// xuat hoa don
	String caulenh = "SELECT HoaDon.maHD,HoaDon.maKH,HoaDon.maNV,ChiTietHoaDon.maXe,ChiTietHoaDon.soLuong,ChiTietHoaDon.donGia,ChiTietHoaDon.thanhTien,HoaDon.tongTien\n"
			+ "FROM HoaDon,ChiTietHoaDon WHERE HoaDon.maHD=? and ChiTietHoaDon.maHD=?";
	String ban_xe = "SELECT HoaDon.maHD,HoaDon.maKH, ChiTietHoaDon.maXe,ChiTietHoaDon.soLuong,ChiTietHoaDon.donGia,ChiTietHoaDon.thanhTien,HoaDon.ngayLap FROM HoaDon,ChiTietHoaDon where HoaDon.maHD=ChiTietHoaDon.maHD";
	String xe_ban_chay = "SELECT top 10 ChiTietHoaDon.maXe,ChiTietHoaDon.donGia, SUM(ChiTietHoaDon.soLuong) AS TONG FROM HoaDon,ChiTietHoaDon WHERE HoaDon.maHD =ChiTietHoaDon.maHD GROUP BY ChiTietHoaDon.maXe,ChiTietHoaDon.donGia ORDER BY SUM(ChiTietHoaDon.soLuong) DESC";
	String xe_con = "SELECT XeMay.maXe,XeMay.tenXe,XeMay.soLuongXe,XeMay.maMauXe,XeMay.giaXe FROM XeMay WHERE XeMay.soLuongXe > 0";


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
	 * Lấy thông tin của nhân viên
	 */
	public ArrayList<NhanVien_entity> getNV() {
		ArrayList<NhanVien_entity> ob_nv = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(nhanvien);
			rs = pst.executeQuery();
			while (rs.next()) {
				NhanVien_entity nv_e = new NhanVien_entity();
				nv_e.setMaNV(rs.getString("maNV"));
				nv_e.setHoTen(rs.getString("hoTen"));
				ob_nv.add(nv_e);
			}
		} catch (SQLException ex) {
			Logger.getLogger(NhanVien_model.class.getName()).log(Level.SEVERE, null, ex);
		}

		return ob_nv;
	}

	/*
	 * Thêm hóa đơn
	 */
	public boolean add_hd(HoaDon_entity hd_e) {
		boolean check = false;
		conn = openConnection();
		try {
			pst = conn.prepareCall(add_hd);
			pst.setString(1, hd_e.getMaNV());
			pst.setString(2, hd_e.getMaKH());
			pst.setString(3, hd_e.getNgayLapHoaDon());
			pst.setFloat(4, hd_e.getTongTien());
			int t = pst.executeUpdate();
			if (t > 0) {
				check = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return check;
	}

	/*
	 * Lấy mã nhân viên
	 */
	public ArrayList<NhanVien_entity> getIDnhanvien(String ma_nv) {
		ArrayList<NhanVien_entity> ob_id_nv = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(nv_id);
			pst.setString(1, ma_nv);
			rs = pst.executeQuery();
			while (rs.next()) {
				NhanVien_entity nv_e = new NhanVien_entity();
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
	public ArrayList<KhachHang_entity> getIDkhachhang(String ma_kh) {
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
	public ArrayList<KhachHang_entity> getComboKH() {
		ArrayList<KhachHang_entity> ob_kh = new ArrayList<>();
		// mở connection
		conn = openConnection();
		try {
			pst = conn.prepareCall(khachhang);
			rs = pst.executeQuery();
			while (rs.next()) {
				KhachHang_entity kh = new KhachHang_entity();
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

	/*
	 * Lấy thông tin của hóa đơn từ combobox
	 */
	public ArrayList<HoaDon_entity> getComboMaHD() {
		ArrayList<HoaDon_entity> ob_hd = new ArrayList<>();
		// mở connection
		conn = openConnection();
		try {
			pst = conn.prepareCall(get_dl_hd);
			rs = pst.executeQuery();
			while (rs.next()) {
				HoaDon_entity hd = new HoaDon_entity();
				hd.setMaHoaDon(rs.getString("maHD"));
				hd.setMaNV(rs.getString("maNV"));
				hd.setMaKH(rs.getString("maKH"));
				hd.setNgayLapHoaDon(rs.getString("ngayLap"));
				hd.setTongTien(rs.getFloat("tongTien"));
				ob_hd.add(hd);
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
	 * Thêm chi tiết hóa đơn
	 */
	public boolean add_ct_dh(HoaDon_entity hd_e) {
		boolean check = false;
		conn = openConnection();
		try {
			pst = conn.prepareCall(add_ct);
			pst.setString(1, hd_e.getMaHoaDon());
			pst.setString(2, hd_e.getMaXe());
			pst.setInt(3, hd_e.getSoLuong());
			pst.setFloat(4, hd_e.getDonGia());
			pst.setFloat(5, hd_e.getThanhTien());
			pst.setFloat(6, hd_e.getThueXe());
			int f = pst.executeUpdate();
			if (f > 0) {
				check = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return check;
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
	 * Lấy thông tin để xuất hóa đơn
	 */
	public List<HoaDon_entity> hoa_don_output(String ma_hd, String ctx) {
		List<HoaDon_entity> ob_hd = new ArrayList<HoaDon_entity>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(caulenh);
			pst.setString(1, ma_hd);
			pst.setString(2, ctx);
			rs = pst.executeQuery();
			while (rs.next()) {
				HoaDon_entity hd_x = new HoaDon_entity();
				hd_x.setMaHoaDon(rs.getString("maHD"));
				hd_x.setMaKH(rs.getString("maKH"));
				hd_x.setMaNV(rs.getString("maNV"));
				hd_x.setMaXe(rs.getString("maXe"));
				hd_x.setDonGia(rs.getFloat("donGia"));
				hd_x.setSoLuong(rs.getInt("soLuong"));
				hd_x.setThanhTien(rs.getFloat("thanhTien"));
				hd_x.setTongTien(rs.getFloat("tongTien"));
				ob_hd.add(hd_x);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ob_hd;
	}

	public boolean xuat_xe(String ma_hd) {
		boolean check = false;
		conn = openConnection();
		try {
			HoaDon_entity hd_e = new HoaDon_entity();
			pst = conn.prepareCall(xuat_xe_hd);
			pst.setString(1, ma_hd);
			int j = pst.executeUpdate();
			if (j > 0) {
				check = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return check;
	}

	public boolean xuat_xe_ctx(String ma_hd) {
		boolean check = false;
		conn = openConnection();
		try {
			HoaDon_entity hd_e = new HoaDon_entity();
			pst = conn.prepareCall(xuat_xe_ct);
			pst.setString(1, ma_hd);
			int t = pst.executeUpdate();
			if (t > 0) {
				check = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return check;
	}

	public ArrayList<HoaDon_entity> ban_xe() {
		ArrayList<HoaDon_entity> ob_hd = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(ban_xe);
			rs = pst.executeQuery();
			while (rs.next()) {
				HoaDon_entity hd_x = new HoaDon_entity();
				hd_x.setMaHoaDon(rs.getString("maHD"));
				hd_x.setMaKH(rs.getString("maKH"));
				hd_x.setMaXe(rs.getString("maXe"));
				hd_x.setDonGia(rs.getFloat("donGia"));
				hd_x.setSoLuong(rs.getInt("soLuong"));
				hd_x.setThanhTien(rs.getFloat("thanhTien"));
				hd_x.setNgayLapHoaDon(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngayLap")));
				//hd_x.setThueXe(rs.getFloat("thueXe"));
				ob_hd.add(hd_x);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ob_hd;
	}

	public ArrayList<HoaDon_entity> xe_ban_chay_nhat() {
		ArrayList<HoaDon_entity> ob_cn = new ArrayList<>();
		conn = openConnection();
		try {
			pst = conn.prepareCall(xe_ban_chay);
			rs = pst.executeQuery();
			int x = 0;
			while (rs.next()) {
				x = rs.getInt("TONG");
				HoaDon_entity hd_e = new HoaDon_entity();
				hd_e.setMaXe(rs.getString("maXe"));
				hd_e.setDonGia(rs.getFloat("donGia"));
				hd_e.setBanChay(x);
				ob_cn.add(hd_e);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ob_cn;
	}
        public ArrayList<XeMay_entity>xe_con_trong_kho(){
           ArrayList<XeMay_entity> ob_xe=new ArrayList<>();
           conn = openConnection();
           try{
               pst = conn.prepareCall(xe_con);
               rs = pst.executeQuery();
               int x=0;
               while(rs.next()){
                   XeMay_entity hd_x = new XeMay_entity();
                   hd_x.setMaXe(rs.getString("maXe"));
                   hd_x.setTenXe(rs.getString("tenXe"));
                   hd_x.setMauXe(rs.getString("maMauXe"));
                   hd_x.setSoLuongXe(rs.getInt("soLuongXe"));
                   hd_x.setGiaXe(rs.getDouble("giaXe"));
                   ob_xe.add(hd_x);
               }
           }catch(SQLException ex){
               Logger.getLogger(HoaDon_model.class.getName()).log(Level.SEVERE, null, ex);
           }
           return ob_xe;
       }
}
