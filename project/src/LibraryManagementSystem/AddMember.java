/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class AddMember {
    public static void addMemberMenu(){
        System.out.println("Reached the add member menu");
        Member m=new Member();
        Scanner sc = new Scanner(System.in);
        int addstatus=0;
        
        while(addstatus==0){
            try{
                System.out.println("Enter the member id");
                m.setMemberId(Integer.parseInt(sc.nextLine().toString()));
                
                System.out.println("Enter the member name");
                m.setMemberName(sc.nextLine().toString());
                
                addMember(m);
                addstatus =1;
            }catch(Exception e){
                addstatus=0;
            }
        }
    }
   public static void addMember(Member m) throws SQLException{
       String insertQuery ="insert into members (member_id,member_name,doj) VALUES (?,?,NOW())";
       try(Connection conn=LibUtil.getConnection()){
           conn.setAutoCommit(false);
           try(PreparedStatement pstmt = conn.prepareStatement(insertQuery)){
               pstmt.setInt(1,m.getMemberId());
               pstmt.setString(2, m.getMemberName());
               int rowsaffected =pstmt.executeUpdate();
               if(rowsaffected>0){
                   System.out.println("Member is sucessfully added");
                   conn.commit();
               }else{
                   conn.rollback();
               }
           }
       }catch(SQLException e){
           e.printStackTrace();
       }
   }
}
