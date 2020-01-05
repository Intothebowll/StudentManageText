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
		selectionLabel = new JLabel("检索方式");
		fieldComboBox = new JComboBox();
		fieldComboBox.addItem("请选择...");
		fieldComboBox.addItem("学号");
		fieldComboBox.addItem("姓名");
		fieldComboBox.addItem("年龄");
		fieldComboBox.addItem("性别");
		fieldComboBox.addItem("系别");
		
	    fieldComboBox.addItemListener(new SelectedListener()); // 下拉列表框注册事件注册事件
		
		keywordText = new JTextField("", 20);
		retrievalButton = new JButton("检索");
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		keywordText.setSize(topPanel.getWidth() / 2, topPanel.getWidth());
		topPanel.add(selectionLabel);
		topPanel.add(fieldComboBox);
		topPanel.add(keywordText);
		topPanel.add(retrievalButton);
		this.add(BorderLayout.NORTH, topPanel);
		
	    retrievalButton.addActionListener(new RetrievalActionListener());//给检索按钮注册事件
		
		table = new JTable();
		bookScrollPane = new JScrollPane(table);
		this.add(BorderLayout.CENTER, bookScrollPane);
		bottomPanel = new JPanel();
		this.add(BorderLayout.SOUTH, bottomPanel);
		
		this.setTitle("学生信息检索查询系统");
		this.setSize(600, 450);
		this.setVisible(true);
	}
	
	class SelectedListener implements ItemListener{

		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				selectedNum = fieldComboBox.getSelectedIndex();//获取文本信息
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
			head.add("学号");
			head.add("姓名");
			head.add("年龄");
			head.add("性别");
			head.add("系别");
	
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
