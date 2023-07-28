/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class LibFunctions {
    public static void callIssueMenu(){
        System.out.println("Reached inside the issue book menu");
        Member m = new Member();
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        int addstatus =0;
        
        while(addstatus ==0){
            try{
                System.out.println("Enter the member id ");
                m.setMemberId(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("enter the isbn code ");
                b.setIsbnCode(sc.nextLine());
                issueBook(m,b);
                addstatus=1;
            }catch(Exception e){
                addstatus=0;
            }
        }
    }
    public static void issueBook(Member m,Book b){
       Connection conn = LibUtil.getConnection();
    try {
        conn.setAutoCommit(false);
        String selectQuery = "SELECT m.member_id, b.isbn_code, mbr.rec_id FROM members m, books b, member_book_record mbr " +
                             "WHERE m.member_id = ? AND b.isbn_code = ? AND m.member_id = mbr.member_id " +
                             "AND b.isbn_code = mbr.isbn_code AND mbr.dor IS NULL";

        PreparedStatement pstmtSelect = conn.prepareStatement(selectQuery);
        pstmtSelect.setInt(1, m.getMemberId());
        pstmtSelect.setString(2, b.getIsbnCode());

        ResultSet rs = pstmtSelect.executeQuery();

        if (rs.next()) {
            System.out.println("The book is already issued and cannot be issued again");
        } else {
            String insertQuery = "INSERT INTO member_book_record (member_id, isbn_code, doi, dor) VALUES (?, ?, NOW(), NULL)";

            PreparedStatement pstmtInsert = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmtInsert.setInt(1, m.getMemberId());
            pstmtInsert.setString(2, b.getIsbnCode());

            int k = pstmtInsert.executeUpdate();

            if (k > 0) {
                ResultSet generatedKeys = pstmtInsert.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int recId = generatedKeys.getInt(1);
                    System.out.println("The book has been issued with record ID: " + recId);

                    String updateQuery = "UPDATE books SET unit_available = (unit_available - 1) WHERE isbn_code = ?";
                    PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery);
                    pstmtUpdate.setString(1, b.getIsbnCode());

                    int updateResult = pstmtUpdate.executeUpdate();

                    if (updateResult > 0) {
                        conn.commit();
                    } else {
                        conn.rollback();
                    }
                } else {
                    conn.rollback();
                }
            } else {
                conn.rollback();
            }
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public static void callreturnMenu(){
        System.out.println("Reached inside the return book menu");
        Member m = new Member();
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        int addstatus =0;
        
        while(addstatus ==0){
            try{
                System.out.println("Enter the member id ");
                m.setMemberId(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("enter the isbn code ");
                b.setIsbnCode(sc.nextLine());
                returnBook(m,b);
                addstatus=1;
            }catch(Exception e){
                addstatus=0;
            }
        }
    }
    
    public static void returnBook(Member m,Book b){
        Connection conn = LibUtil.getConnection();
        try{
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs =null;
            String qry="select m.member_id,b.isbn_code,mbr.rec_id from members m,books b,member_book_record mbr\n"+"where m.member_id="+m.getMemberId()+"\n"+"and b.isbn_code ='"+b.getIsbnCode()+"'\n"+"and m.member_id=mbr.member_id\n"+"and b.isbn_code=mbr.isbn_code and mbr.dor is null";
            rs = stmt.executeQuery(qry);
            if(rs.next()){
                Integer recId=rs.getInt(3);
                System.out.println("The book is already issued and starting the process to return");
                int k = stmt.executeUpdate("update books set unit_available=(unit_available+1) where isbn_code='"+b.getIsbnCode()+"'");
                if(k>0){
                    k=stmt.executeUpdate("update member_book_record set dor=NOW() where rec_id ="+recId+"");
                    conn.commit();
                    System.out.println("The book is returned sucessfully");
                }else{
                    conn.rollback();
                }
            }else{
                System.out.println("This book is not issued for the user");
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
