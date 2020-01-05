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
		this.setTitle("欢迎进入学生自助系统");
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
		JMenu fileMenu=new JMenu("成绩查询");
		JMenuItem queryScoreMenuItem=new JMenuItem("我的成绩");
		queryScoreMenuItem.addActionListener(new StudentScoreListener());//注册事件
		fileMenu.add(queryScoreMenuItem);
		menuBar.add(fileMenu);
		
		JMenu queryMenu=new JMenu("可爱的同学");
		JMenuItem knowMenuItem=new JMenuItem("了解ta");
		//JMenuItem tellMenuItem=new JMenuItem("跟ta说");
		knowMenuItem.addActionListener(new detailActionListener());//注册事件
	    //tellMenuItem.addActionListener(new QueryScoreActionListener());//注册事件
		queryMenu.add(knowMenuItem);
		//queryMenu.add(tellMenuItem);
		menuBar.add(queryMenu);
		
		JMenu changeMenu=new JMenu("Let me go");
		JMenuItem outMenuItem=new JMenuItem("Out");
		outMenuItem.addActionListener(new ExitActionListener());//注册事件
		changeMenu.add(outMenuItem);
		menuBar.add(changeMenu);
	}
	class ExitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			int result = JOptionPane.showConfirmDialog(null, "真的要退出吗?", "提示信息",
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

