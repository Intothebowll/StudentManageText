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
		l1 = new JLabel("ѧ��");
		l2 = new JLabel("����");
		l3 = new JLabel("ѧ��");
		l4 = new JLabel("�ɼ�");
		l5 = new JLabel("ѧ��");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		bt1 = new JButton("���");
		bt2 = new JButton("�˳�");
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
		this.setTitle("��ӳɼ���Ϣ¼�����");
		this.setSize(400, 402);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {// �����࿪ʼ
					public void windowClosing(WindowEvent e) // ���˳����ڵ����д�ڱ�������
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
				
				JOptionPane.showMessageDialog(null, "insert success", "��ʾ��Ϣ",
						JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			} else { 
				JOptionPane.showMessageDialog(null, "insert failure", "��ʾ��Ϣ",
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
