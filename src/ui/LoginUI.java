 package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginUI extends JFrame {
	JLabel l1;
	JButton bt1, bt2;
	Container cp; //创建一个容器

	public LoginUI() {
		l1 = new JLabel("请选择用户类型");
		l1.setForeground(new Color(219, 112, 147));
		l1.setFont(new Font("宋体", Font.BOLD, 18));
		bt1 = new JButton("教师");
		bt1.setFont(new Font("楷体", Font.BOLD, 15));
		bt1.setBackground(Color.PINK);
		bt2 = new JButton("学生");
		bt2.setFont(new Font("楷体", Font.BOLD, 15));
		bt2.setBackground(Color.PINK);
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(123, 146, 139, 40);
		p1.add(l1);
		bt1.setBounds(92, 199, 80, 30);
		p1.add(bt1);
		bt2.setBounds(197, 199, 87, 30);
		p1.add(bt2);
		bt1.addActionListener(new TeacherLoginActionListener());//注册事件
		bt2.addActionListener(new StudentLoginActionListener());//注册事件
		cp = getContentPane();
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		cp.add(p1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\bg.png"));
		lblNewLabel.setBounds(0, 0, 381, 354);
		p1.add(lblNewLabel);
		this.setTitle("用户登录界面");
		this.setSize(399, 401);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  //窗口被关闭时调用
				System.exit(0);
			}
		});
	}
	class TeacherLoginActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new TeacherLoginUI();
			dispose();
		}
	}
    class StudentLoginActionListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		new StudentLoginUI();
    		dispose();
    	}
	}
	
	public static void main(String[] args) {
		new LoginUI();	//调用这个LoginUI
	}
}
