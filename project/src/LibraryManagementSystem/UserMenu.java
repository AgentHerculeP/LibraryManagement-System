/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.util.Scanner;

/**101
 *
 * @author Lenovo
 */
public class UserMenu {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       String input="";
       while(input!="5"){
           System.out.println("-------------------------------------");
           System.out.println("-------------------------------------");
           
           System.out.println("Slect the following options");
           System.out.println("Enter 1 for adding the book");
           System.out.println("Enter 2 for adding a member");
           System.out.println("Enter 3 for issuing the book");
           System.out.println("Enter 4 for returning the book");
           System.out.println("Enter 5 to exit");
           input=processUserInput(sc.nextLine().toString());
       }
    }
    public static String processUserInput(String in){
           switch(in){
               case "1":
                   System.out.println("You have selected option 1 to add a book");
                   AddBook.addbookmenu();
                   break;
               case "2":
                   System.out.println("You have selected option 2 for adding a member");
                   AddMember.addMemberMenu();
                   break;
               case "3":
                   System.out.println("You have selected option 3 for issuing the book");
                   LibFunctions.callIssueMenu();
                   break;
               case "4":
                   System.out.println("You have selected option 4 for returning the book");
                   LibFunctions.callreturnMenu();
                   break;
               default:
                   System.out.println("Thanks for working on this!");
           }
           return"5";
    }
    
}
