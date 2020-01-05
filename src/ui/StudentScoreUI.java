package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import model.Score;
import dao.ScoreDao;

public class StudentScoreUI extends JFrame{
	
	String aa=StudentLoginUI.st1;
	JLabel selectionLabel;
	JPanel topPanel;
	Container container;
	JTable table; 
	JScrollPane bookScrollPane;
	JPanel bottomPanel;
	
	public StudentScoreUI(){
		container = this.getContentPane();
		selectionLabel = new JLabel(aa+"ͬѧ��ѧ�ڳɼ�����");
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(selectionLabel);
		this.add(BorderLayout.NORTH, topPanel);
		
		table = new JTable();
		bookScrollPane = new JScrollPane(table);
		this.add(BorderLayout.CENTER, bookScrollPane);
		bottomPanel = new JPanel();
		this.add(BorderLayout.SOUTH, bottomPanel);
		
		this.setTitle("ѧ���ɼ���ѯ");
		this.setSize(600, 450);
		this.setVisible(true);
		
		ScoreDao oneScore=new ScoreDao();
		ArrayList lis = oneScore.queryScore(aa);
		Vector<String> head = new Vector();
		head.add("ѧ��");
		head.add("����");
		head.add("ѧ��");
		head.add("�ɼ�");
		head.add("ѧ��");
		
		Vector<Vector> content = new Vector();
		for (int i = 0; i < lis.size(); i++) {
			Vector row = new Vector();
			Score oneScore1 = (Score) lis.get(i);
			row.add(oneScore1.getNum());
			row.add(oneScore1.getSname());
			row.add(oneScore1.getCourse());
			row.add(oneScore1.getScore());
			row.add(oneScore1.getCredit());
			content.add(row);
		}

		//�������ģ�� ��Ŀ���ǲ������
		DefaultTableModel model = new DefaultTableModel(content, head);
		table.setModel(model);
		//�ػ����
		repaint();
	}
}
