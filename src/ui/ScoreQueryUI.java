package ui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import model.Score;
import dao.ScoreDao;

public class ScoreQueryUI extends JFrame{
	JLabel selectionLabel;
	JPanel topPanel;
	JButton retrievalButton;
	JTextField keywordText;
	Container container;
	String fieldSelected;
	int selectedNum;
	JTable table; 
	JScrollPane bookScrollPane;
	JPanel bottomPanel;
	
	public ScoreQueryUI(){
		container = this.getContentPane();
		selectionLabel = new JLabel("ѧ������");
		keywordText = new JTextField("", 20);
		retrievalButton = new JButton("��ѯ");
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		keywordText.setSize(topPanel.getWidth() / 2, topPanel.getWidth());
		topPanel.add(selectionLabel);
		topPanel.add(keywordText);
		topPanel.add(retrievalButton);
		this.add(BorderLayout.NORTH, topPanel);
		
		retrievalButton.addActionListener(new RetrievalActionListener());//��������ťע���¼�
		
		table = new JTable();
		bookScrollPane = new JScrollPane(table);
		this.add(BorderLayout.CENTER, bookScrollPane);
		bottomPanel = new JPanel();
		this.add(BorderLayout.SOUTH, bottomPanel);
		
		this.setTitle("ѧ����Ϣ������ѯϵͳ");
		this.setSize(600, 450);
		this.setVisible(true);
	}
	
	class RetrievalActionListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String key = keywordText.getText();
			ScoreDao oneScore=new ScoreDao();
			ArrayList lis = oneScore.queryScore(key);
			
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
			DefaultTableModel model = new DefaultTableModel(content, head);
			table.setModel(model);
			repaint();
		}
	}
	public static void main(String[] args) {
		new ScoreQueryUI();
	}

}
