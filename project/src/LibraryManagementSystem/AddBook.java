/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Lenovo
 */
public class AddBook {
    public static void addbookmenu(){
        System.out.println("Reached addbook menu");
        Book b= new Book();
        Scanner sc = new Scanner(System.in);
        int addStatus=0;
        
        while(addStatus==0){
            try{
            System.out.println("Enter the isbnCode");
            b.setIsbnCode(sc.nextLine());
            System.out.println("Enter the book name");
            b.setBookName(sc.nextLine());
            System.out.println("Enter the book desc");
            b.setBookdesc(sc.nextLine());
            System.out.println("Enter the author name");
            b.setAuthorName(sc.nextLine());
            System.out.println("Enter the subject");
            b.setSubjectName(sc.nextLine());
            System.out.println("Enter the units available");
            b.setUnitAvailable(Integer.parseInt(sc.nextLine()));
            
            addBook(b);
            addStatus=1;
            }catch(Exception e){
                addStatus=0;
            }
        }
    }

  public static void addBook(Book b) {
    String insertQuery = "INSERT INTO books (isbn_code, book_name, book_desc, author_name, subject_name, unit_available) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = LibUtil.getConnection()) {
        conn.setAutoCommit(false); // Disable autocommit

        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, b.getIsbnCode());
            pstmt.setString(2, b.getBookName());
            pstmt.setString(3, b.getBookdesc());
            pstmt.setString(4, b.getAuthorName());
            pstmt.setString(5, b.getSubjectName());
            pstmt.setInt(6, b.getUnitAvailable());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Added Book successfully");
                conn.commit();
            } else {
                conn.rollback();
            }
        }

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}
}
