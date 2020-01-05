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
		Connection con=db.getConnection();    //���������ݿ�
		boolean isfound=false;
		PreparedStatement pst; //��Statement���ӽӿ�,���Դ����ռλ����SQL��䣬�ṩ�˲���ռλ�������ķ���
		try {
			pst = con.prepareStatement("select * from studentlogin where sname=? and password=?");
			pst.setString(1, sname);
		    pst.setString(2,password);
			ResultSet rs=pst.executeQuery(); //ִ�в�ѯ��䣬ִ�к󷵻ش����ѯ�����ResultSet����
			   if(rs.next())  //��ı���
			      isfound=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		   
		   System.out.println(isfound);
		   return isfound;
	}
	
	
	public boolean addStudent(int num, String sname, String sex, int age,
			String dept) {
		Connection con = DBconnection.getConnection(); //���������ݿ�
		PreparedStatement pst;  //����һ��PreparedStatement�������ڴ�sql���
		try {
			pst = con.prepareStatement("insert into student values(?,?,?,?,?)");

			pst.setInt(1, num);
			pst.setString(2, sname);
			pst.setString(3, sex);
			pst.setInt(4, age);
			pst.setString(5, dept);

			int count = pst.executeUpdate();// �����޸ĵļ�¼����jdbc�Ĳ������
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

		ArrayList lis = new ArrayList(); //ArrayList ��һ��������У��൱�� ��̬���飬�൱��Ϊ�˺��淵��һ�����
		Connection con = DBconnection.getConnection();
		Statement stm; //����һ��Statement�������ڴ�sql���
		try {
			stm = con.createStatement();
			String sql = "select * from student where " + field + " like  '%"
					+ key + "%' ";
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getString(5));
				lis.add(student);  //�Ѳ鵽�����ݼ��뵽lis��
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis; //����һ�����
	}

	public boolean deleteStudent(String key) { //key������delete����е�sname��ѧ��������

		Connection con = DBconnection.getConnection();//�������ݿ�
		Statement stm; //����һ��Statement�������ڴ�sql���
		try {
			stm = con.createStatement();
			String sql = "delete from student where sname like  '%"
					+ key + "%' "; //�൱�ڡ�%sname%��
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

