package bookstore;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dbConnection.DbConnect;

public class User {
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String tel;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void adduser() throws ClassNotFoundException, SQLException
	{
		DbConnect con;
		PreparedStatement pstmt;
		con = new DbConnect();
		System.out.println(" login ");
        Scanner a1 = new Scanner( System.in );
        String log   = a1.nextLine();
        System.out.println(" mdp ");
        Scanner a2 = new Scanner( System.in );
        String mdp   = a2.nextLine();
        System.out.println(" Last Name ");
        Scanner a3 = new Scanner( System.in );
        String nom   = a3.nextLine();
        System.out.println(" First Name ");
        Scanner a4 = new Scanner( System.in );
        String prenom   = a4.nextLine();
        System.out.println(" phone ");
        Scanner a5 = new Scanner( System.in );
        String tel  = a5.nextLine();
        pstmt = con.MyConnec().prepareStatement("INSERT INTO `user`(login,mdp,nom,prenom,tel) VALUES (?, ?, ?, ?, ?)");
		pstmt.setNString(1, log );
		pstmt.setString(2, mdp );
		pstmt.setString(3, nom );
		pstmt.setString(4,prenom);
		pstmt.setString(5, tel );
		           System.out.println("ajout avec success");
		           pstmt.executeUpdate();
	}
	public void consultuser() throws ClassNotFoundException, SQLException
	{
		 DbConnect con;
		 PreparedStatement pstmt;
		 con = new DbConnect();
		  pstmt = con.MyConnec().prepareStatement("SELECT * FROM user "); 
		 ResultSet rs = pstmt.executeQuery();
		 int i=0;
		 while (rs.next()) {
			 
			    String login = rs.getString("login");
			    String mdp = rs.getString("mdp");
			    String nom = rs.getString("nom");
			    String prenom = rs.getString("prenom");
			    String tel = rs.getString("tel");
			    

			    //Display values
			    System.out.print("login: " + login);
			    System.out.print(", password: " + mdp);
			    System.out.print(", nom: " + nom);
			    System.out.print(", prenom: " + prenom);
			    System.out.print(", phone: " + tel);
	}
	}
}

