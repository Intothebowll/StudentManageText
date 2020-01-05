package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ui.StudentLoginUI;

import model.Score;
import model.Student;
import Connection.DBconnection;

public class ScoreDao {

	/*
	 * queryScore,queryScore1,addScore,deleteScor
		���÷ֱ���Ϊ��ʦ�û��ṩ��ѯѧ���ɼ���Ϣ���ܣ�Ϊѧ���û��ṩ
		ѯ���˳ɼ���Ϣ���ܣ���ӳɼ���Ϣ��ɾ���ɼ���Ϣ

	 */
	public ArrayList queryScore(String key) {
		ArrayList lis = new ArrayList();
		Connection con = DBconnection.getConnection();
		Statement stm;

		try {
			stm = con.createStatement();
			String sql = "select * from score where sname like  '%" + key
					+ "%' ";
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Score score = new Score(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getInt(5));
				lis.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	public ArrayList queryScore1(String key) {
		ArrayList lis = new ArrayList();
		Connection con = DBconnection.getConnection();
		Statement stm;

		try {
			stm = con.createStatement();
			String sql = "select * from score where sname like  '%" + StudentLoginUI.st1
					+ "%' ";
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Score score = new Score(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getInt(5));
				lis.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	

	public boolean addScore(int num, String sname, String course, int score,
			int credit) {
		Connection con = DBconnection.getConnection();
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("insert into score values(?,?,?,?,?)");
			pst.setInt(1, num);
			pst.setString(2, sname);
			pst.setString(3, course);
			pst.setInt(4, score);
			pst.setInt(5, credit);
			int count = pst.executeUpdate();// �����޸ĵļ�¼��
			if (count == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteScore(String key) {
		Connection con = DBconnection.getConnection();
		Statement stm;
		try {
			stm = con.createStatement();
			String sql = "delete from score where sname like  '%" + key + "%' ";
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
}
