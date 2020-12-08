/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thang
 */
public class ConnectionDB {
    private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=PTUDOfficial";
    private static final String USER="sa";
    private static final String PASS="sapassword";
    public  static Connection openConnection(){
        Connection conn=null;
        try {
            Class.forName(DRIVER);
            try {
                conn=DriverManager.getConnection(URL,USER,PASS);
            } catch (SQLException ex) {
               
            }
        } catch (ClassNotFoundException ex) {
             System.out.println("Không Thể Kết Nối Tới Cơ Sở Dữ Liệu");
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
