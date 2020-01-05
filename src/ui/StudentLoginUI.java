 package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import dao.StudentDao;

public class StudentLoginUI extends JFrame{
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton bt1, bt2;
	Container cp;
	
	public static String st1;
	public String st2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public StudentLoginUI(){
		l1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		l2 = new JLabel("\u5BC6    \u7801\uFF1A");
		t1 = new JTextField(12);
		t2 = new JPasswordField(12);
		bt1 = new JButton("成绩查询");
		bt2 = new JButton("退出");
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(89, 132, 80, 40);
		p1.add(l1);
		t1.setBounds(167, 137, 120, 30);
		p1.add(t1);
		l2.setBounds(89, 185, 80, 40);
		p1.add(l2);
		t2.setBounds(167, 190, 120, 30);
		p1.add(t2);
		bt1.setBounds(95, 248, 93, 30);
		p1.add(bt1);
		bt2.setBounds(190, 248, 93, 30);
		p1.add(bt2);
		bt1.addActionListener(new LoginActionListener());//注册事件
		bt2.addActionListener(new ExitActionListener());//注册事件
		
		cp = getContentPane();
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		cp.add(p1);
		
		lblNewLabel_1 = new JLabel("\u5B66\u751F\u767B\u5F55 / Login");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 22));
		lblNewLabel_1.setBounds(89, 60, 212, 46);
		p1.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\sbg.png"));
		lblNewLabel.setBounds(0, 0, 382, 353);
		p1.add(lblNewLabel);
		this.setTitle("学生登录界面");
		this.setSize(400, 400);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					} 
				});
	}
	class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			//actionPerformed方法组件发生“有意义”的事件时会调用这个方法
			st1 = t1.getText();
			st2 = t2.getText();
			StudentDao oneStudentDao = new StudentDao();
			boolean isSuccess = oneStudentDao.studentLogin(st1, st2);
			if (isSuccess) {
				new StudentMainUI(); //如果信息对上了，就跳转到StudentScoreUI界面
				dispose();
			} else
				JOptionPane.showMessageDialog(null, "用户名密码错误", "提示信息",
						JOptionPane.INFORMATION_MESSAGE);
		}
	}
	class ExitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentLoginUI();
		
	}
}
