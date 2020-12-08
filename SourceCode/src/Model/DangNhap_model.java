/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Connection.ConnectionDB.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phan Xuan Bach
 * kiểm tra xác thực dữ liệu đăng nhập
 */
public class DangNhap_model {
    public static Connection conn;
    public static  PreparedStatement pst;
    public static ResultSet rs;
    public static ResultSet loginData(String taikhoan,String matkhau){
        String manager="SELECT * FROM NhanVien WHERE taiKhoan=? and matKhau=?";
        conn=openConnection();
        try {
            pst=conn.prepareCall(manager);
            pst.setString(1, taikhoan);
            pst.setString(2, matkhau);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DangNhap_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
