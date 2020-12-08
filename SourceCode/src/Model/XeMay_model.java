package Model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionDB;
import Entities.HangXe_entity;
import Entities.LoaiXe_entity;
import Entities.MauXe_entity;
import Entities.XeMay_entity;
     /*
 * Author: Phan Xuân Bách, Mai Thị Thanh Thúy, Nguyễn Đình Thông
 */
public class XeMay_model extends ConnectionDB {
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    XeMay_entity xm= new XeMay_entity();
    String Getall="SELECT * FROM XeMay";
    String delete="DELETE  FROM XeMay WHERE maXe=?";
    // các lệnh loại xe
    String get_loaixe = "SELECT * FROM LoaiXe";
    String add_loai = "INSERT INTO LoaiXe(tenLoaiXe) VALUES (?)";
    String update_loai = "UPDATE LoaiXe SET tenLoaiXe=? WHERE maLoaiXe=?";
    String del_loai = "DELETE From LoaiXe WHERE maLoaiXe=?";
    // các lệnh hãng xe
    String getdl = "SELECT * FROM HangXe";
    String add_hang = "INSERT INTO HangXe(tenHang) VALUES (?)";
    String update_hang = "UPDATE HangXe SET tenHang=? WHERE maHangXe=?";
    String del_hang = "DELETE FROM HangXe WHERE maHangXe=?";
    // các lệnh màu xe
    String getMau = "SELECT * FROM MauXe";
    String add_mau = "INSERT INTO MauXe(mauXe) VALUES (?)";
    String update_mau = "UPDATE MauXe SET mauXe=? WHERE maMauXe=?";
    String del_mau = "DELETE FROM MauXe WHERE maMauXe=?";
    // các lệnh xe máy
    String get_xe = "SELECT * FROM XeMay";
    String add_xe="INSERT INTO XeMay (tenXe,soKhung,soMay,maHangXe,maLoaiXe,maMauXe,dungTich,soLuongXe,giaXe,anhXe) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String update_xe_anh="UPDATE XeMay SET tenXe=?,soKhung=?,soMay=?,maHangXe=?,maLoaiXe=?,maMauXe=?,dungTich=?,soLuongXe=?,giaXe=?,anhXe=? WHERE maXe=?";
    String update_xe="UPDATE XeMay SET tenXe=?,soKhung=?,soMay=?,maHangXe=?,maLoaiXe=?,maMauXe=?,dungTich=?,soLuongXe=?,giaXe=? WHERE maXe=?";
    String Dis_xe="DELETE FROM XeMay WHERE maXe=?";
    String hang_id_xe="SELECT * FROM HangXe WHERE maHangXe=?";
    String loai_id_xe="SELECT * FROM LoaiXe  Where maLoaiXe=?";
    String mau_id_xe="SELECT * FROM MauXe WHERE maMauXe=?";
    //=====================Loai Xe=================================
    public ArrayList<LoaiXe_entity> getLoaiXe() {
        ArrayList<LoaiXe_entity> lk = new ArrayList<>();
        
        conn = openConnection();

        try {
            pst = conn.prepareCall(get_loaixe);
            rs = pst.executeQuery();
            while (rs.next()) {
            	LoaiXe_entity hj = new LoaiXe_entity();
                hj.setMaLoaiXe(rs.getString("maLoaiXe"));
                hj.setTenLoaiXe(rs.getString("tenLoaiXe"));
                lk.add(hj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lk;
    }

    public boolean add_loai_xe(LoaiXe_entity lx_e) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(add_loai);
            pst.setString(1, lx_e.getTenLoaiXe());
            int y = pst.executeUpdate();
            if (y > 0) {
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean update_loai_xe(LoaiXe_entity lx_e) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(update_loai);
            pst.setString(1, lx_e.getTenLoaiXe());
            pst.setString(2, lx_e.getMaLoaiXe());
            int l = pst.executeUpdate();
            if (l > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean Dis_Loai_xe(String ma_loai) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(del_loai);
            pst.setString(1, ma_loai);
            int h = pst.executeUpdate();
            if (h > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn);
        }
        
        return check;
    }

    public boolean xoaXeMay(String maxe){
        boolean check = false;
        try{
            pst = conn.prepareCall(delete);
            pst.setString(1,maxe);
            int p = pst.executeUpdate();
            if(p>0){
                check = true;
            }
        }catch(Exception e){
                        Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, e);

        }
        return check;
    }
    
    //=====================hãng xe=====================
    public ArrayList<HangXe_entity> getHangXe() {
        ArrayList<HangXe_entity> ob_hang = new ArrayList<>();
        conn = openConnection();
        try {
            pst = conn.prepareCall(getdl);
            rs = pst.executeQuery();
            while (rs.next()) {
                HangXe_entity hx_e = new HangXe_entity();
                hx_e.setMaHang(rs.getString("maHangXe"));
                hx_e.setTenHang(rs.getString("tenHang"));
                ob_hang.add(hx_e);

            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ob_hang;
    }

    public boolean add_hang(HangXe_entity hx_e) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(add_hang);
            pst.setString(1, hx_e.getTenHang());
            int p = pst.executeUpdate();
            if (p > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean updateHangXe(HangXe_entity hx_e) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(update_hang);
            pst.setString(1, hx_e.getTenHang());
            pst.setString(2, hx_e.getMaHang());
            int l = pst.executeUpdate();
            if (l > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean disHangXe(String ma_hang) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(del_hang);
            pst.setString(1, ma_hang);
            int q = pst.executeUpdate();
            if (q > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.openConnection();
        }
        return check;

    }
    //================================ màu xe=======================
    public ArrayList<MauXe_entity> getMauXe() {
        ArrayList<MauXe_entity> ob_mau = new ArrayList<>();
        conn = openConnection();
        try {
            pst = conn.prepareCall(getMau);
            rs = pst.executeQuery();
            while (rs.next()) {
                MauXe_entity mx_e = new MauXe_entity();
                mx_e.setMaMau(rs.getString("maMauXe"));
                mx_e.setTenMau(rs.getString("mauXe"));
                ob_mau.add(mx_e);

            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ob_mau;
    }
    public boolean Dis_mau_xe(String ma_mau){
        boolean check=false;
        conn=openConnection();
        try {
            pst=conn.prepareCall(del_mau);
            pst.setString(1, ma_mau);
            int  t=pst.executeUpdate();
            if(t>0){
                check=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public boolean add_mau_xe(MauXe_entity mx_e){
        boolean check=false;
        conn=openConnection();
        try {
            pst=conn.prepareCall(add_mau);
            pst.setString(1, mx_e.getTenMau());
            int p=pst.executeUpdate();
            if(p>0){
                check=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check;
    }
    public boolean updateMauXe(MauXe_entity mx_e) {
        boolean check = false;
        conn = openConnection();
        try {
            pst = conn.prepareCall(update_mau);
            pst.setString(1, mx_e.getTenMau());
            pst.setString(2, mx_e.getMaMau());
            int l = pst.executeUpdate();
            if (l > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    //===============================xe máy=========================
    public ArrayList<XeMay_entity> getDL_xe(){
        ArrayList<XeMay_entity> ob_xe=new ArrayList<>();
        conn=openConnection();
        try {
            pst=conn.prepareCall(get_xe);
            rs=pst.executeQuery();
            while(rs.next()){

                XeMay_entity xm_e=new XeMay_entity();
                xm_e.setMaXe(rs.getString("maXe"));
                xm_e.setTenXe(rs.getString("tenXe"));
                xm_e.setGiaXe(rs.getDouble("giaXe"));
                xm_e.setMa_Loai(rs.getString("maLoaiXe"));
                xm_e.setMa_Hang(rs.getString("maHangXe"));
                xm_e.setMa_Mau(rs.getString("maMauXe"));
                xm_e.setBit(rs.getBytes("anhXe"));
                xm_e.setSoKhung(rs.getString("soKhung"));
                xm_e.setSoMay(rs.getString("soMay"));
                xm_e.setDungTich(rs.getFloat("dungTich"));
                xm_e.setSoLuongXe(rs.getInt("soLuongXe"));
                ob_xe.add(xm_e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return ob_xe;
    }
    //////////////////////////////////////////
    public ArrayList<HangXe_entity> hangxe_id(String ma_hang){
        ArrayList<HangXe_entity> ob_h=new ArrayList<>();
         conn=openConnection();
         try {
             pst=conn.prepareCall(hang_id_xe);
             pst.setString(1, ma_hang);
             rs=pst.executeQuery();
             while(rs.next()){
                 HangXe_entity hx_e=new HangXe_entity();
                 hx_e.setMaHang(rs.getString("maHangXe"));
                 hx_e.setTenHang(rs.getString("tenHang"));
                 ob_h.add(hx_e);
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return ob_h;
     }
     public ArrayList<LoaiXe_entity> loaixe_id(String ma_loai){
        ArrayList<LoaiXe_entity> ob_l=new ArrayList<>();
         conn=openConnection();
         try {
             pst=conn.prepareCall(loai_id_xe);
             pst.setString(1, ma_loai);
             rs=pst.executeQuery();
             while(rs.next()){
            	 LoaiXe_entity lx_e=new LoaiXe_entity();
                 lx_e.setMaLoaiXe(rs.getString("maLoaiXe"));
                 lx_e.setTenLoaiXe(rs.getString("tenLoaiXe"));
                 ob_l.add(lx_e);
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return ob_l;
     }
     public ArrayList<MauXe_entity> mauxe_id(String ma_mau){
        ArrayList<MauXe_entity> ob_m=new ArrayList<>();
         conn=openConnection();
         try {
             pst=conn.prepareCall(mau_id_xe);
             pst.setString(1, ma_mau);
             rs=pst.executeQuery();
             while(rs.next()){
            	 MauXe_entity mx_e=new MauXe_entity();
                 mx_e.setMaMau(rs.getString("maMauXe"));
                 mx_e.setTenMau(rs.getString("mauXe"));
                 ob_m.add(mx_e);
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return ob_m;
     }
     public boolean add_xe_may(XeMay_entity xm_e){
         boolean check=true;
         conn=openConnection();
         try {
             
             pst=conn.prepareCall(add_xe);
             pst.setString(1, xm_e.getTenXe());
             pst.setString(2, xm_e.getSoKhung());
             pst.setString(3, xm_e.getSoMay());
             pst.setString(4, xm_e.getMa_Hang());
             pst.setString(5, xm_e.getMa_Loai());
             pst.setString(6, xm_e.getMa_Mau());
             pst.setFloat(7, xm_e.getDungTich());
             pst.setInt(8, xm_e.getSoLuongXe());
             pst.setDouble(9, xm_e.getGiaXe());
             pst.setBlob(10, xm_e.getAnhXe());
             int k=pst.executeUpdate();
             if(k>0){
                 check=true;
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return check;
     }
     public boolean update_anh_xe(XeMay_entity xm){
         boolean check=false;
         conn=openConnection();
         try {
             pst=conn.prepareCall(update_xe_anh);
             pst.setString(1, xm.getTenXe());
             pst.setString(2, xm.getSoKhung());
             pst.setString(3, xm.getSoMay());
             pst.setString(4, xm.getMa_Hang());
             pst.setString(5, xm.getMa_Loai());
             pst.setString(6, xm.getMa_Mau());
             pst.setFloat(7, xm.getDungTich());
             pst.setInt(8, xm.getSoLuongXe());
             pst.setDouble(9, xm.getGiaXe());
             pst.setBlob(10, xm.getAnhXe());
             pst.setString(11, xm.getMaXe());
             int p=pst.executeUpdate();
             if(p>0){
                 check=true;
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return check;
     }
     public boolean update_xe(XeMay_entity xm){
         boolean check=false;
         conn=openConnection();
         try {
             pst=conn.prepareCall(update_xe);
             pst.setString(1, xm.getTenXe());
             pst.setString(2, xm.getSoKhung());
             pst.setString(3, xm.getSoMay());
             pst.setString(4, xm.getMa_Hang());
             pst.setString(5, xm.getMa_Loai());
             pst.setString(6, xm.getMa_Mau());
             pst.setFloat(7, xm.getDungTich());
             pst.setInt(8, xm.getSoLuongXe());
             pst.setDouble(9, xm.getGiaXe());
             pst.setString(10, xm.getMaXe());
             int p=pst.executeUpdate();
             if(p>0){
                 check=true;
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return check;
     }
     public boolean Dis_xe_may(String ma_xe){
         boolean check=false;
         conn=openConnection();
         try {
             pst=conn.prepareCall(Dis_xe);
             pst.setString(1, ma_xe);
             int k=pst.executeUpdate();
             if(k>0){
                 check=true;
             }
         } catch (SQLException ex) {
             Logger.getLogger(XeMay_model.class.getName()).log(Level.SEVERE, null, ex);
         }
         return check;
     }

    
}
