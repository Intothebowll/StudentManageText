package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.StudentDao;
public class StudentAddUI extends JFrame{
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton bt1, bt2;
	private JLabel lblNewLabel;
	public StudentAddUI() {
		l1 = new JLabel("学号");
		l2 = new JLabel("姓名");
		l3 = new JLabel("性别");
		l4 = new JLabel("年龄");
		l5 = new JLabel("系别");
		t1 = new JTextField(12);
		t2 = new JTextField(24);
		t3 = new JTextField(24);
		t4 = new JTextField(24);
		t5 = new JTextField(6);
		bt1 = new JButton("添加");
		bt2 = new JButton("退出");
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(60, 58, 80, 30);
		p1.add(l1);
		t1.setBounds(130, 58, 200, 30);
		p1.add(t1);
		l2.setBounds(60, 98, 80, 30);
		p1.add(l2);
		t2.setBounds(130, 98, 200, 30);
		p1.add(t2);
		l3.setBounds(60, 138, 80, 30);
		p1.add(l3);
		t3.setBounds(130, 138, 200, 30);
		p1.add(t3);
		l4.setBounds(60, 178, 80, 30);
		p1.add(l4);
		t4.setBounds(130, 178, 200, 30);
		p1.add(t4);
		l5.setBounds(60, 218, 80, 30);
		p1.add(l5);
		t5.setBounds(130, 218, 200, 30);
		p1.add(t5);
		bt1.setBounds(83, 283, 80, 30);
		p1.add(bt1);
		bt2.setBounds(223, 283, 80, 30);
		p1.add(bt2);
		
		bt1.addActionListener(new AddListener());
		bt2.addActionListener(new CloseListener());
		
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		getContentPane().add(p1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\SAdd.png"));
		lblNewLabel.setBounds(-14, -13, 413, 376);
		p1.add(lblNewLabel);
		this.setTitle("增添新生录入界面");
		this.setSize(401, 400);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {// 匿名类开始
					public void windowClosing(WindowEvent e) // 把退出窗口的语句写在本方法中
					{
						dispose();
					} 
				});
	}
	
	class AddListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			StudentDao oneStudentDao = new StudentDao();
			int num = Integer.parseInt(t1.getText());
			String sname = t2.getText();
			String sex = t3.getText();
			int age = Integer.parseInt(t4.getText());
			String dept = t5.getText();
			boolean issuccess = oneStudentDao.addStudent(num, sname, sex,age,dept);
			if (issuccess) {
				
				JOptionPane.showMessageDialog(null, "insert success", "提示信息",
						JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			} else { 
				JOptionPane.showMessageDialog(null, "insert failure", "提示信息",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	class CloseListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	public static void main(String[] args) {
		new StudentAddUI();
	}
}
