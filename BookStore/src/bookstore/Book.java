package bookstore;



import java.sql.*;

import dbConnection.DbConnect;
public class Book {
private String title;
private String author;
private double price;
private Date releaseDate;

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}
public void addBook(String title, String author, double price,Date releaseDate) throws ClassNotFoundException, SQLException 
{ DbConnect con;
PreparedStatement pstmt;
con = new DbConnect();

pstmt = con.MyConnec().prepareStatement("INSERT INTO `book`(id,title,author,price,releaseDate) VALUES (?, ?, ?, ?, ?)");
pstmt.setNString(1, null );
pstmt.setString(2, title );
pstmt.setString(3, author );
pstmt.setDouble(4,price);
pstmt.setDate(5, releaseDate );
           System.out.println("ajout avec success");
           pstmt.executeUpdate();
	
}
public  void consultBook() throws ClassNotFoundException, SQLException
{Connection con =null;
Statement stmt = null;

Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
con = DriverManager.getConnection(url,"root","");
stmt = con.createStatement();

String sql = "SELECT id,title,author,price,releaseDate FROM book";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
    //Retrieve by column name
    int id  = rs.getInt("id");
    String title = rs.getString("title");
    String author = rs.getString("author");
    Double price = rs.getDouble("price");
    Date releaseDate = rs.getDate("releaseDate");

    //Display values
    System.out.print("ID: " + id);
    System.out.print(", title: " + title);
    System.out.print(", author: " + author);
    System.out.println(", price: " + price);
    System.out.println(", release Date: " + releaseDate);
 }
}
public void deleteBook(long id) throws ClassNotFoundException, SQLException
{  DbConnect con;
PreparedStatement pstmt;
con = new DbConnect();
try {
pstmt = con.MyConnec().prepareStatement("DELETE FROM book WHERE id =?");

pstmt.setLong(1,id);
pstmt.executeUpdate();
System.out.println("deleted succefully");
}
catch(SQLException e)
{e.printStackTrace();}
       
    }
public void updateBook(int id,String title, String author, double price,Date releaseDate) throws ClassNotFoundException, SQLException
{   Connection con =null;
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";
con = DriverManager.getConnection(url,"root","");
try {
PreparedStatement pstmt = con.prepareStatement("UPDATE book SET author = ?,title = ?,price = ?,releasedate = ? WHERE id = ?");

pstmt.setString(1, author );
pstmt.setString(2, title );
pstmt.setDouble(3,price);
pstmt.setDate(4, releaseDate );
pstmt.setInt(5, id );

           pstmt.executeUpdate();
           System.out.println("updated succefully");}
catch(SQLException e)
{e.printStackTrace();}
       
    }
}
