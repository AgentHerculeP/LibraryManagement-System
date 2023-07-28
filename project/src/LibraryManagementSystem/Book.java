/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

/**
 *
 * @author Lenovo
 */
public class Book {
    private String isbnCode;
    private String bookName;
    private String bookdesc;
    private String authorName;
    private String subjectName;
    private Integer unitAvailable;

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookdesc() {
        return bookdesc;
    }

    public void setBookdesc(String bookdesc) {
        this.bookdesc = bookdesc;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getUnitAvailable() {
        return unitAvailable;
    }

    public void setUnitAvailable(Integer unitAvailable) {
        this.unitAvailable = unitAvailable;
    }
    
    public Book(){
        
    }
    public Book(String isbnCode,String bookname,String bookdesc,String authorname,String subjectname,Integer unitsavailable){
        this.isbnCode= isbnCode;
        this.bookName = bookname;
        this.authorName=authorname;
        this.bookdesc=bookdesc;
        this.subjectName=subjectname;
        this.unitAvailable=unitsavailable;
    }
}
