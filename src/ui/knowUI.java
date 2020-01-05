package ui;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import model.Score;
import model.Student2;
import dao.ScoreDao;
import dao.StudentDao;

public class knowUI extends JFrame{
	
	//String aa=StudentLoginUI.st1;
	JLabel selectionLabel;
	JPanel topPanel;
	Container container;
	JTable table; 
	JScrollPane bookScrollPane;
	JPanel bottomPanel;
	
	public knowUI(){
		container = this.getContentPane();
		selectionLabel = new JLabel("���ͬ��ͬѧ��");
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(selectionLabel);
		this.add(BorderLayout.NORTH, topPanel);
		
		table = new JTable();
		bookScrollPane = new JScrollPane(table);
		this.add(BorderLayout.CENTER, bookScrollPane);
		bottomPanel = new JPanel();
		this.add(BorderLayout.SOUTH, bottomPanel);
		
		this.setTitle("ͬ��ͬѧ����");
		this.setSize(600, 450);
		this.setVisible(true);
		
		StudentDao sd=new StudentDao();
		ArrayList lis = sd.detailStudent();
		Vector<String> head = new Vector();
		head.add("�༶");
		head.add("ѧ��");
		head.add("����");
		head.add("�Ա�");
		
		Vector<Vector> content = new Vector();
		for (int i = 0; i < lis.size(); i++) {
			Vector row = new Vector();
			Student2 s2 = (Student2) lis.get(i);
			row.add(s2.getMyclass());
			row.add(s2.getNum());
			row.add(s2.getSname());
			row.add(s2.getSex());
			content.add(row);
		}

		//�������ģ�� ��Ŀ���ǲ������
		DefaultTableModel model = new DefaultTableModel(content, head);
		table.setModel(model);
		//�ػ����
		repaint();
		
		
		
		
		
	}
}
