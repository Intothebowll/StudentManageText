package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.ScoreDao;
public class ScoreDeleteUI extends JFrame{
	JLabel l1;
	JTextField t1;
	JButton bt1, bt2;
	private JLabel lblNewLabel;
	public ScoreDeleteUI(){
		l1 = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u6210\u7EE9\u4FE1\u606F\u7684\u5B66\u751F\u59D3\u540D");
		t1 = new JTextField(20);
		bt1 = new JButton("删除");
		bt2 = new JButton("退出");
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(74, 103, 225, 30);
		p1.add(l1);
		t1.setBounds(92, 162, 199, 30);
		p1.add(t1);
		bt1.setBounds(105, 224, 80, 30);
		p1.add(bt1);
		bt2.setBounds(196, 224, 80, 30);
		p1.add(bt2);
		
		bt1.addActionListener(new DeleteListener());
		bt2.addActionListener(new CloseListener());
		
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		getContentPane().add(p1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\Del.png"));
		lblNewLabel.setBounds(0, -12, 406, 379);
		p1.add(lblNewLabel);
		this.setTitle("删除成绩信息界面");
		this.setSize(400, 400);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {// 匿名类开始
					public void windowClosing(WindowEvent e) // 把退出窗口的语句写在本方法中
					{
						dispose();
					} // 窗口关闭
				});// 匿名类结束
	}
	class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ScoreDao oneScoreDao = new ScoreDao();
			String sname = t1.getText();
			boolean issuccess = oneScoreDao.deleteScore(sname);
            if (issuccess) {
				
				JOptionPane.showMessageDialog(null, "delete success", "提示信息",
						JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
			} else { 
				JOptionPane.showMessageDialog(null, "delete failure", "提示信息",
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
		new ScoreDeleteUI ();
	}
}
