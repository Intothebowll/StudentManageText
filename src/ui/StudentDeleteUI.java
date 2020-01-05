package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.StudentDao;
public class StudentDeleteUI extends JFrame{
	JLabel l1;
	JTextField t1;
	JButton bt1, bt2;
	private JLabel lblNewLabel;
	public StudentDeleteUI () {
		l1 = new JLabel("������Ҫɾ��������Ϣ��ѧ��������");
		l1.setFont(new Font("����", Font.PLAIN, 17));
		t1 = new JTextField(20);
		bt1 = new JButton("ɾ��");
		bt2 = new JButton("�˳�");
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		l1.setBounds(54, 101, 272, 50);
		p1.add(l1);
		t1.setBounds(86, 168, 195, 30);
		p1.add(t1);
		bt1.setBounds(96, 235, 80, 30);
		p1.add(bt1);
		bt2.setBounds(190, 235, 80, 30);
		p1.add(bt2);
		
		bt1.addActionListener(new DeleteListener());
		bt2.addActionListener(new CloseListener());
		
		this.setBounds(200, 200, p1.getHeight(), p1.getHeight());
		getContentPane().add(p1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\SDel.png"));
		lblNewLabel.setBounds(0, 0, 398, 377);
		p1.add(lblNewLabel);
		this.setTitle("ɾ����ҵ������");
		this.setSize(400, 400);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {// �����࿪ʼ
					public void windowClosing(WindowEvent e) // ���˳����ڵ����д�ڱ�������
					{
						dispose();
					} // ���ڹر�
				});// ���������
	}
	class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			StudentDao oneStudentDao = new StudentDao();
			String sname = t1.getText();
			boolean issuccess = oneStudentDao.deleteStudent(sname);
            if (issuccess) {
				
				JOptionPane.showMessageDialog(null, "delete success", "��ʾ��Ϣ",
						JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
			} else { 
				JOptionPane.showMessageDialog(null, "delete failure", "��ʾ��Ϣ",
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
		new StudentDeleteUI ();
	}
}
