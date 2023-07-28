/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lenovo
 */
public class LibUtil {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            String url ="jdbc:mysql://localhost:3306/library2";
            String username = "root";
            String password = "Vidhi@2016";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            
        }
        return conn;
    }
}
