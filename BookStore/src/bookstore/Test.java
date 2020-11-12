package bookstore;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dbConnection.DbConnect;

public class Test {
	
	
	public static void totalPrice() throws ClassNotFoundException {
		double Totalprice=0;
        try {
        	 DbConnect con;
        	 PreparedStatement pstmt;
        	 con = new DbConnect();
            pstmt = con.MyConnec().prepareStatement("SELECT pricecl FROM cmdline ");
           
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                {
                 Totalprice += Double.parseDouble(rs.getString("pricecl"));
                }
            System.out.println();
            System.out.println("total to pay "+Totalprice);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
       
       
    }

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Book book = new Book();
		User u =new User();
		int a=0;
		int r=0;
		int b=0;
		int c=0;
		do {
			System.out.println("\n"+"Choissisez:");
			System.out.println("1: Update book ");
			System.out.println("2: Add book ");
			System.out.println("3: Store ");
			System.out.println("4: Command ");
			System.out.println("5: delete book ");
			System.out.println("6: add user ");
			System.out.println("7: users List ");
			System.out.println("8:basket  ");
			System.out.println("9:quit  ");
			Scanner s = new Scanner( System.in );
	        a   = s.nextInt();
	        switch(a)
	        {case 1:{
		System.out.println("Put  the book's id you want to update ");
        Scanner sc9 = new Scanner( System.in );
        int idu   = sc9.nextInt();
		
	     System.out.println(" title ");
	        Scanner sc = new Scanner( System.in );
	        String title   = sc.nextLine();
	        System.out.println(" author ");
	        Scanner sc1 = new Scanner( System.in );
	        String author   = sc1.nextLine();
	        System.out.println(" price ");
	        Scanner sc3 = new Scanner( System.in );
	        Double price   = sc3.nextDouble();
	        System.out.println("enter the release date of the book TO UPDATE (yyyy-mm-dd)");
            Scanner sc5 = new Scanner( System.in );
            String doj=sc5.next();
java.sql.Date releaseDate=java.sql.Date.valueOf(doj);
//			book.addBook(title, author, price, releaseDate);
    
book.updateBook(idu, title,author, price, releaseDate);
break;}
	        case 2:{r=0;
	        	do {
	        	try { System.out.println("Put in the book's title ");
		        Scanner sc = new Scanner( System.in );
		        String title   = sc.nextLine();
		        System.out.println("Put in the book's author ");
		        Scanner sc1 = new Scanner( System.in );
		        String author   = sc1.nextLine();
		        System.out.println("Put in the book's price ");
		        Scanner sc3 = new Scanner( System.in );
		        Double price   = sc3.nextDouble();
		        System.out.println("enter the release date of the book (yyyy-mm-dd)");
                Scanner sc5 = new Scanner( System.in );
                String doj=sc5.next();
java.sql.Date releaseDate=java.sql.Date.valueOf(doj);
				book.addBook(title, author, price, releaseDate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	System.out.println("do you want to add another book 1:yes 2:no ");
	        	Scanner scr = new Scanner( System.in );
	    		r = scr.nextInt();}while(r==1);
	        	break;}
	        case 3:{
	        try {
				book.consultBook();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;}
	        case 4:{c=0;
	        	book.consultBook();
	        CmdLine ca = new CmdLine();
	        do {
	        ca.addCommandeline();
	        System.out.println("do you want to add another command 1:yes 2:no ");
        	Scanner scr = new Scanner( System.in );
    		c = scr.nextInt();
	        }while(c==1);break;}
	        case 5:{
	        System.out.println("Put  the book's id you want to delete ");
	        Scanner sc8 = new Scanner( System.in );
	        int idd   = sc8.nextInt();
	        book.deleteBook(idd);
	       break; }
	        case 6:
	        	{b=0;
	        		do {
	        		u.adduser();
	        		System.out.println("do you want to add another user 1:yes 2:no ");
		        	Scanner scr = new Scanner( System.in );
		    		b = scr.nextInt();} while(b==1);
	        		break;}
	        case 7:{
	        	u.consultuser();
	      break;  }
	        case 8:
	        {
	        	 
	        	    DbConnect con;
	       		 PreparedStatement pstmt;
	       		 con = new DbConnect();
	       		  pstmt = con.MyConnec().prepareStatement("SELECT * FROM cmdline "); 
	       		 ResultSet rs = pstmt.executeQuery();
	       		 int i=0;
	       		 while (rs.next()) {
	       			 
	       			    String idcl = rs.getString("idcl");
	       			    String idb = rs.getString("idb");
	       			    String priceb = rs.getString("priceb");
	       			    String qte = rs.getString("qte");
	       			    String pricecl = rs.getString("pricecl");
	       			    

	       			    //Display values
	       			    System.out.print("\n"+"id commande: " + idcl);
	       			    System.out.print(", id book: " + idb);
	       			    System.out.print(", price book: " +priceb);
	       			    System.out.print(", quantity: " + qte);
	       			    System.out.print(", total price: " + pricecl);
	       			    
	       	}
	        	    
	       		totalPrice();	
	        break;}
	        case 9: 
	        	 DbConnect con;
	        	 PreparedStatement pstmt;
	        	 con = new DbConnect();
	        	 try {
	        	 pstmt = con.MyConnec().prepareStatement("TRUNCATE TABLE cmdline ");

	        	
	        	 pstmt.executeUpdate();
	        	 System.out.println("a la prochaine");
	        	 }
	        	 catch(SQLException e)
	        	 {e.printStackTrace();}
	        	break;}
	        }
		while(a!=9);
		System.exit(0);
	}

}

