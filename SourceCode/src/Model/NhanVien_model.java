package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionDB;
import Entities.KhachHang_entity;
import Entities.NhanVien_entity;
     /*
 * Author: Phan Xuân Bách
 */
public class NhanVien_model extends ConnectionDB{
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String Getall="SELECT * FROM NhanVien";
    String add="INSERT INTO NhanVien (hoTen,soCMND,gioiTinh,ngaySinh,email,soDienThoai,taiKhoan,matKhau,diaChi,chucVu) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String delete="DELETE  FROM NhanVien WHERE maNV=?";
    String update="UPDATE  NhanVien SET hoTen=?,soCMND=?,gioiTinh=?,ngaySinh=?,email=?,soDienThoai=?,taiKhoan=?,matKhau=?,diaChi=?,chucVu=? Where maNV=?";
    NhanVien_entity nv = new NhanVien_entity();
      /*
 * Đưa dữ liệu lên table
 */
    public ArrayList<NhanVien_entity> getData(){
    	 ArrayList<NhanVien_entity> ob_nv=new ArrayList<>();
         //mở connection
         conn=openConnection();
         try {
             pst=conn.prepareCall(Getall);
             rs= pst.executeQuery();
             while(rs.next()){
            	        	 
               NhanVien_entity nv_e=new NhanVien_entity();

               nv_e.setMaNV(rs.getString("maNV") );
               nv_e.setHoTen(rs.getString("hoTen"));
               nv_e.setSoCMND(rs.getString("soCMND"));
               nv_e.setGioiTinh(rs.getBoolean("gioiTinh"));
               nv_e.setNgaySinh(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngaySinh")));
               nv_e.setEmail(rs.getString("email"));
               nv_e.setSoDienThoai(rs.getString("soDienThoai"));
               nv_e.setTaiKhoan(rs.getString("taiKhoan"));
               nv_e.setMatKhau(rs.getString("matKhau"));
               nv_e.setDiachi(rs.getString("diaChi"));
               nv_e.setChucVu(rs.getString("chucVu"));
               ob_nv.add(nv_e);
               
               
             }
         }catch(SQLException ex) {
        	 ex.printStackTrace();
         }
		return ob_nv;
    }
         /*
 * Thêm nhân viên
 */
    public boolean themNhanVien(NhanVien_entity nv_e) throws SQLException{
        boolean check = false;
        conn = openConnection();
        try{
            pst = conn.prepareCall(add);
           // pst.setString(1,nv_e.getMaNV());
            pst.setString(1,nv_e.getHoTen());
            pst.setString(2,nv_e.getSoCMND());
            pst.setBoolean(3,nv_e.isGioiTinh());
            pst.setString(4, nv_e.getNgaySinh());
            pst.setString(5,nv_e.getEmail());
            pst.setString(6,nv_e.getSoDienThoai());
            pst.setString(7, nv_e.getTaiKhoan());
            pst.setString(8, nv_e.getMatKhau());
            pst.setString(9,nv_e.getDiachi());
            pst.setString(10, nv_e.getChucVu());
            
            int k = pst.executeUpdate();
            if(k>0){
                check = true;
            }
        }catch(SQLException ex){
                        Logger.getLogger(NhanVien_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
         /*
 * Xóa nhân viên
 */
    public boolean xoaNhanVien(String manv){
        boolean check = false;
        try{
            pst = conn.prepareCall(delete);
            pst.setString(1,manv);
            int p = pst.executeUpdate();
            if(p>0){
                check = true;
            }
        }catch(Exception e){
                        Logger.getLogger(NhanVien_model.class.getName()).log(Level.SEVERE, null, e);

        }
        return check;
    }
         /*
 * Cập nhật nhân viên
 */
    public boolean capNhatNhanVien(NhanVien_entity nv_e) throws SQLException{
        boolean check = false;
        conn = openConnection();
        try{
            pst=conn.prepareCall(update);
            pst.setString(1, nv_e.getHoTen());
            pst.setString(2, nv_e.getSoCMND());
            pst.setBoolean(3,nv_e.isGioiTinh());
            pst.setString(4, nv_e.getNgaySinh());
            pst.setString(5, nv_e.getEmail());
            pst.setString(6, nv_e.getSoDienThoai());
            pst.setString(7, nv_e.getTaiKhoan());
            pst.setString(8, nv_e.getMatKhau());
            pst.setString(9, nv_e.getDiachi());
            pst.setString(10, nv_e.getChucVu());
            pst.setString(11, nv_e.getMaNV());
            int l=pst.executeUpdate();
            if(l>0){
                check=true;
            }
        }catch(SQLException e){
            Logger.getLogger(NhanVien_model.class.getName()).log(Level.SEVERE, null, e);

        }
        return check;
    }

}
