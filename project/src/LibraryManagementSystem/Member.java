/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Member {
    private Integer memberId;
    private String memberName;
    private Date DateOfJoining;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(Date DateOfJoining) {
        this.DateOfJoining = DateOfJoining;
    }
    
    public Member(){
        
    }
    public Member(Integer memberid,String membername,Date dateofjoining){
        this.memberId = memberid;
        this.memberName=membername;
        this.DateOfJoining=dateofjoining;
    }
    
    
}
