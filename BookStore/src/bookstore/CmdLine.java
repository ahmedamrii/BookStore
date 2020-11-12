package bookstore;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dbConnection.DbConnect;

public class CmdLine {
	

	public void addCommandeline() throws ClassNotFoundException, SQLException
    { double pricebook = 0;
    DbConnect con;
    PreparedStatement pstmt;
    con = new DbConnect();
    System.out.println("Put the book's id you want to command ");
    Scanner sc1 = new Scanner( System.in );
    long idBook   = sc1.nextLong();
    System.out.println("Put the quantity ");
    Scanner sc2 = new Scanner( System.in );
    int quantite   = sc2.nextInt();
     try {
            pstmt = con.MyConnec().prepareStatement("SELECT * FROM Book where id = ? ");
            pstmt.setDouble(1,idBook);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                {
                 pricebook =Double.parseDouble(rs.getString("price"));
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
    pstmt =  con.MyConnec().prepareStatement("INSERT INTO `cmdline`(idcl,idb,priceb,qte,pricecl) VALUES ( ?, ?, ?, ?,?)");
    pstmt.setNString(1, null );
    pstmt.setLong(2, idBook );
    pstmt.setDouble(3,pricebook);
    pstmt.setInt(4, quantite );
    pstmt.setDouble(5,pricebook*quantite );
    System.out.println("addition with success");
    pstmt.executeUpdate();
    }
}
