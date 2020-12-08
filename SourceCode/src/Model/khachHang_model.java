package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Connection.ConnectionDB;
import Entities.KhachHang_entity;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
     /*
 * Author: Nguyễn Đình Thông
 */
public class khachHang_model extends ConnectionDB{
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String Getall = "SELECT * FROM KhachHang ";
    String add="INSERT INTO KhachHang (hoTenKH,soCMND,gioiTinh,ngaySinh,email,soDienThoai,diaChi) VALUES (?,?,?,?,?,?,?)";
    String update="UPDATE  KhachHang SET hoTenKH=?,soCMND=?,gioiTinh=?,ngaySinh=?,email=?,soDienThoai=?,diaChi=? Where maKH=?";
    String delete="DELETE  FROM KhachHang WHERE maKH=?";

    KhachHang_entity kh = new KhachHang_entity();
    public ArrayList<KhachHang_entity> getData(){
        ArrayList<KhachHang_entity> ob_kh=new ArrayList<>();
        //mở connection
        conn=openConnection();
        try {
            pst=conn.prepareCall(Getall);
            rs=pst.executeQuery();
            while(rs.next()){
                KhachHang_entity kh=new KhachHang_entity();
                kh.setMaKH(rs.getString("maKH"));
                kh.setHoTenKH(rs.getString("hoTenKH"));
                kh.setSoCMND(rs.getString("soCMND"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setNgaySinh(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("ngaySinh")));
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
    public boolean themKhachHang(KhachHang_entity kh_e) throws SQLException{
        boolean check = false;
        conn = openConnection();
        try{
            pst = conn.prepareCall(add);
            pst.setString(1,kh_e.getHoTenKH());
            pst.setString(2,kh_e.getSoCMND());
            pst.setBoolean(3,kh_e.isGioiTinh());
            pst.setString(4, kh_e.getNgaySinh());
            pst.setString(5,kh_e.getEmail());
            pst.setString(6,kh_e.getSoDienThoai());
            pst.setString(7,kh_e.getDiachi());
            int k = pst.executeUpdate();
            if(k>0){
                check = true;
            }
        }catch(SQLException ex){
                        Logger.getLogger(khachHang_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    public boolean capNhatKhachHang(KhachHang_entity kh_e) throws SQLException{
        boolean check = false;
        conn = openConnection();
        try{
            pst=conn.prepareCall(update);
            pst.setString(1, kh_e.getHoTenKH());
            pst.setString(2, kh_e.getSoCMND());
            pst.setBoolean(3,kh_e.isGioiTinh());
            pst.setString(4, kh_e.getNgaySinh());
            pst.setString(5, kh_e.getEmail());
            pst.setString(6, kh_e.getSoDienThoai());
            pst.setString(7, kh_e.getDiachi());
            pst.setString(8, kh_e.getMaKH());
            int l=pst.executeUpdate();
            if(l>0){
                check=true;
            }
        }catch(SQLException e){
            Logger.getLogger(khachHang_model.class.getName()).log(Level.SEVERE, null, e);

        }
        return check;
    }
    public boolean xoaKhachHang(String maKh){
        boolean check = false;
        try{
            pst = conn.prepareCall(delete);
            pst.setString(1,maKh);
            int p = pst.executeUpdate();
            if(p>0){
                check = true;
            }
        }catch(Exception e){
                        Logger.getLogger(khachHang_model.class.getName()).log(Level.SEVERE, null, e);

        }
        return check;
    }


}
