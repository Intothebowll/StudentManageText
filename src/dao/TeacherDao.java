package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DBconnection;


public class TeacherDao {

	public boolean queryTeacher(String tname,String password) {
		DBconnection db=new DBconnection();
		Connection con=db.getConnection();
		boolean isfound=false;
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from teacher where tname=? and password=?");
			pst.setString(1, tname);
		    pst.setString(2,password);
			ResultSet rs=pst.executeQuery();
			   if(rs.next())
			      isfound=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		   
		   System.out.println(isfound);
		   return isfound;
	}
	public static void main(String[] args) {
	}
}
