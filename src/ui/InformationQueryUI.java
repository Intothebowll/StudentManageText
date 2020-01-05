package ui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.*;
import model.Student;
import dao.StudentDao;

public class InformationQueryUI extends JFrame{
	JLabel selectionLabel;
	JComboBox fieldComboBox;
	JPanel topPanel;
	JButton retrievalButton;
	JTextField keywordText;
	Container container;
	String fieldSelected;
	int selectedNum;
	JTable table; 
	JScrollPane bookScrollPane;
	JPanel bottomPanel;
	
	public InformationQueryUI(){
		container = this.getContentPane();
		selectionLabel = new JLabel("������ʽ");
		fieldComboBox = new JComboBox();
		fieldComboBox.addItem("��ѡ��...");
		fieldComboBox.addItem("ѧ��");
		fieldComboBox.addItem("����");
		fieldComboBox.addItem("����");
		fieldComboBox.addItem("�Ա�");
		fieldComboBox.addItem("ϵ��");
		
	    fieldComboBox.addItemListener(new SelectedListener()); // �����б��ע���¼�ע���¼�
		
		keywordText = new JTextField("", 20);
		retrievalButton = new JButton("����");
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		keywordText.setSize(topPanel.getWidth() / 2, topPanel.getWidth());
		topPanel.add(selectionLabel);
		topPanel.add(fieldComboBox);
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
	
	class SelectedListener implements ItemListener{

		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				selectedNum = fieldComboBox.getSelectedIndex();//��ȡ�ı���Ϣ
			}
		}
	}
	class RetrievalActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			switch (selectedNum) {
			case 1:
				fieldSelected = "num";
				break;
			case 2:
				fieldSelected = "sname";
				break;
			case 3:
				fieldSelected = "age";
				break;
			case 4:
				fieldSelected = "sex";
				break;
			case 5:
				fieldSelected = "dept";
				break;
			}
			String key = keywordText.getText();
			StudentDao oneStudentDao = new StudentDao();
			ArrayList lis = oneStudentDao.queryStudent(fieldSelected, key);
			
			Vector<String> head = new Vector();
			head.add("ѧ��");
			head.add("����");
			head.add("����");
			head.add("�Ա�");
			head.add("ϵ��");
	
			Vector<Vector> content = new Vector();
			for (int i = 0; i < lis.size(); i++) {
				Vector row = new Vector();
				Student oneStudent = (Student) lis.get(i);
				row.add(oneStudent.getNum());
				row.add(oneStudent.getSname());
				row.add(oneStudent.getAge());
				row.add(oneStudent.getSex());
				row.add(oneStudent.getDept());
				content.add(row);
			}
			DefaultTableModel model = new DefaultTableModel(content, head);
			table.setModel(model);
			repaint();
		}
	}
	public static void main(String[] args) {
		new InformationQueryUI();
	}
}
