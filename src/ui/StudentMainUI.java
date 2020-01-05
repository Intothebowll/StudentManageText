package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ui.TeacherMainUI.AddActionListener;
import ui.TeacherMainUI.AddScoreActionListener;
import ui.TeacherMainUI.DeleteActionListener;
import ui.TeacherMainUI.DeleteScoreActionListener;
import ui.TeacherMainUI.ExitActionListener;
import ui.TeacherMainUI.QueryActionListener;
import ui.TeacherMainUI.QueryScoreActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StudentMainUI extends JFrame{
	Container ctp2;
	StudentMainUI () {
		ctp2 = this.getContentPane();
		this.setTitle("��ӭ����ѧ������ϵͳ");
		ctp2.setLayout(new BorderLayout());
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\smainbg.png"));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		JMenuBar menBar = new JMenuBar();
		bulidMainMenu2(menBar);
		this.setJMenuBar(menBar);
		this.setBounds(100,100,400,300);
		this.setVisible(true);
	}
	public void bulidMainMenu2(JMenuBar menuBar){
		JMenu fileMenu=new JMenu("�ɼ���ѯ");
		JMenuItem queryScoreMenuItem=new JMenuItem("�ҵĳɼ�");
		queryScoreMenuItem.addActionListener(new StudentScoreListener());//ע���¼�
		fileMenu.add(queryScoreMenuItem);
		menuBar.add(fileMenu);
		
		JMenu queryMenu=new JMenu("�ɰ���ͬѧ");
		JMenuItem knowMenuItem=new JMenuItem("�˽�ta");
		//JMenuItem tellMenuItem=new JMenuItem("��ta˵");
		knowMenuItem.addActionListener(new detailActionListener());//ע���¼�
	    //tellMenuItem.addActionListener(new QueryScoreActionListener());//ע���¼�
		queryMenu.add(knowMenuItem);
		//queryMenu.add(tellMenuItem);
		menuBar.add(queryMenu);
		
		JMenu changeMenu=new JMenu("Let me go");
		JMenuItem outMenuItem=new JMenuItem("Out");
		outMenuItem.addActionListener(new ExitActionListener());//ע���¼�
		changeMenu.add(outMenuItem);
		menuBar.add(changeMenu);
	}
	class ExitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			int result = JOptionPane.showConfirmDialog(null, "���Ҫ�˳���?", "��ʾ��Ϣ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null);
			if (result == 0)
				System.exit(0);
			else if (result == 1) {
			}
		}
	}
	class StudentScoreListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		   new StudentScoreUI();
		  
		}
	}
	class detailActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new knowUI();
			
		}
	}

	public static void main(String[] args) {
		new StudentMainUI();
	}
}

