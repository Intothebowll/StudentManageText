package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Score;
import model.Student;
import model.Student2;
import Connection.DBconnection;

public class StudentDao {
	
	
	public boolean studentLogin(String sname,String password) {
		DBconnection db=new DBconnection();
		Connection con=db.getConnection();    //连接上数据库
		boolean isfound=false;
		PreparedStatement pst; //是Statement的子接口,可以传入带占位符的SQL语句，提供了补充占位符变量的方法
		try {
			pst = con.prepareStatement("select * from studentlogin where sname=? and password=?");
			pst.setString(1, sname);
		    pst.setString(2,password);
			ResultSet rs=pst.executeQuery(); //执行查询语句，执行后返回代表查询结果的ResultSet对象
			   if(rs.next())  //表的遍历
			      isfound=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		   
		   System.out.println(isfound);
		   return isfound;
	}
	
	
	public boolean addStudent(int num, String sname, String sex, int age,
			String dept) {
		Connection con = DBconnection.getConnection(); //连接上数据库
		PreparedStatement pst;  //创建一个PreparedStatement对象用于传sql语句
		try {
			pst = con.prepareStatement("insert into student values(?,?,?,?,?)");

			pst.setInt(1, num);
			pst.setString(2, sname);
			pst.setString(3, sex);
			pst.setInt(4, age);
			pst.setString(5, dept);

			int count = pst.executeUpdate();// 返回修改的记录数，jdbc的操作语句
			if (count == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public ArrayList queryStudent(String field, String key) {

		ArrayList lis = new ArrayList(); //ArrayList 是一个数组队列，相当于 动态数组，相当于为了后面返回一个表格
		Connection con = DBconnection.getConnection();
		Statement stm; //创建一个Statement对象用于传sql语句
		try {
			stm = con.createStatement();
			String sql = "select * from student where " + field + " like  '%"
					+ key + "%' ";
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getString(5));
				lis.add(student);  //把查到的内容加入到lis中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis; //返回一个表格
	}

	public boolean deleteStudent(String key) { //key：传给delete语句中的sname（学生姓名）

		Connection con = DBconnection.getConnection();//连接数据库
		Statement stm; //创建一个Statement对象用于传sql语句
		try {
			stm = con.createStatement();
			String sql = "delete from student where sname like  '%"
					+ key + "%' "; //相当于‘%sname%’
			System.out.println(sql);
			int count = stm.executeUpdate(sql);  
			if (count == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList detailStudent() {
		ArrayList lis = new ArrayList();
		Connection con = DBconnection.getConnection();
		Statement stm;

		try {
			stm = con.createStatement();
			String sql = "select * from studentmember where myclass like  '%" + 3
					+ "%' ";
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Student2 s2 = new Student2(rs.getString(1), rs.getInt(2), rs
						.getString(3), rs.getString(4));
				lis.add(s2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
}
}

