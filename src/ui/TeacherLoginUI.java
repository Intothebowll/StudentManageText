package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.TeacherDao;
public class TeacherLoginUI extends JFrame {
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton bt1, bt2;
	Container cp;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public TeacherLoginUI(){
		l1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		l2 = new JLabel("\u5BC6    \u7801\uFF1A");
		t1 = new JTextField(12);
		t2 = new JPasswordField(12);
		bt1 = new JButton("登录");
		bt2 = new JButton("退出");
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(81, 114, 80, 40);
		p1.add(l1);
		t1.setBounds(160, 119, 115, 30);
		p1.add(t1);
		l2.setBounds(81, 177, 80, 40);
		p1.add(l2);
		t2.setBounds(160, 182, 115, 30);
		p1.add(t2);
		bt1.setBounds(98, 244, 80, 30);
		p1.add(bt1);
		bt2.setBounds(179, 244, 80, 30);
		p1.add(bt2);
		bt1.addActionListener(new LoginActionListener());//注册事件
		bt2.addActionListener(new ExitActionListener());//注册事件
		
		cp = getContentPane();
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		cp.add(p1);
		
		lblNewLabel_1 = new JLabel("\u6559\u5E08\u767B\u5F55 / Login");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 22));
		lblNewLabel_1.setBounds(81, 43, 225, 58);
		p1.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\tbg.png"));
		lblNewLabel.setBounds(0, 0, 384, 355);
		p1.add(lblNewLabel);
		this.setTitle("教师登录界面");
		this.setSize(402, 402);
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

			String st1 = t1.getText();
			String st2 = t2.getText();
			TeacherDao oneTeacherDao = new TeacherDao();
			boolean isSuccess = oneTeacherDao.queryTeacher(st1, st2);
			if (isSuccess) {
				new TeacherMainUI();
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
		new TeacherLoginUI();	
	}
}
