package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.ScoreDao;
public class ScoreAddUI extends JFrame{
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton bt1, bt2;
	
	public ScoreAddUI(){
		l1 = new JLabel("学号");
		l2 = new JLabel("姓名");
		l3 = new JLabel("学科");
		l4 = new JLabel("成绩");
		l5 = new JLabel("学分");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		bt1 = new JButton("添加");
		bt2 = new JButton("退出");
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(63, 61, 80, 30);
		p1.add(l1);
		t1.setBounds(133, 61, 200, 30);
		p1.add(t1);
		l2.setBounds(63, 101, 80, 30);
		p1.add(l2);
		t2.setBounds(133, 101, 200, 30);
		p1.add(t2);
		l3.setBounds(63, 141, 80, 30);
		p1.add(l3);
		t3.setBounds(133, 141, 200, 30);
		p1.add(t3);
		l4.setBounds(63, 181, 80, 30);
		p1.add(l4);
		t4.setBounds(133, 181, 200, 30);
		p1.add(t4);
		l5.setBounds(63, 221, 80, 30);
		p1.add(l5);
		t5.setBounds(133, 221, 200, 30);
		p1.add(t5);
		bt1.setBounds(84, 300, 80, 30);
		p1.add(bt1);
		bt2.setBounds(213, 300, 80, 30);
		p1.add(bt2);
		
		bt1.addActionListener(new AddListener());
		bt2.addActionListener(new CloseListener());
		
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		getContentPane().add(p1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\Add.png"));
		lblNewLabel.setBounds(-27, -17, 421, 372);
		p1.add(lblNewLabel);
		this.setTitle("添加成绩信息录入界面");
		this.setSize(400, 402);
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
			ScoreDao oneScoreDao = new ScoreDao();
			int num = Integer.parseInt(t1.getText());
			String sname = t2.getText();
			String course = t3.getText();
			int score = Integer.parseInt(t4.getText());
			int credit = Integer.parseInt(t5.getText());
			boolean issuccess = oneScoreDao.addScore(num, sname,course,score,credit);
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
		new ScoreAddUI();
	}
}
