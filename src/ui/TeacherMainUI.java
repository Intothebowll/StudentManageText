package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TeacherMainUI extends JFrame{
Container ctp;
     TeacherMainUI(){
		ctp = this.getContentPane();
		this.setTitle("欢迎进入学生管理系统！");
		ctp.setLayout(new BorderLayout());
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\1  Java\\Eclipse1.8\\information storage\\StudentManageText\\magin\\tmainbg.png"));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		buildMainMenu(menuBar);
		this.setJMenuBar(menuBar);
		this.setBounds(100, 100, 400, 300);
		this.setVisible(true);
	}
	public void buildMainMenu(JMenuBar menuBar){
		
		JMenu queryMenu=new JMenu("查询");
		JMenuItem queryMenuItem=new JMenuItem("学生基本信息");
		JMenuItem queryScoreMenuItem=new JMenuItem("学生成绩查询");
		queryMenuItem.addActionListener(new QueryActionListener());//注册事件
	    queryScoreMenuItem.addActionListener(new QueryScoreActionListener());//注册事件
		queryMenu.add(queryMenuItem);
		queryMenu.add(queryScoreMenuItem);
		menuBar.add(queryMenu);
		
		JMenu changeMenu=new JMenu("修改");
		JMenuItem addMenuItem=new JMenuItem("增加新生信息");
		JMenuItem deleteMenuItem=new JMenuItem("删除毕业生信息");
		JMenuItem addScoreMenuItem=new JMenuItem("增加成绩信息");
		JMenuItem deleteScoreMenuItem=new JMenuItem("删除成绩信息");
		addMenuItem.addActionListener(new AddActionListener());//注册事件
		deleteMenuItem.addActionListener(new DeleteActionListener());//注册事件
		addScoreMenuItem.addActionListener(new AddScoreActionListener());//注册事件
		deleteScoreMenuItem.addActionListener(new DeleteScoreActionListener());//注册事件
		changeMenu.add(addMenuItem);
		changeMenu.add(deleteMenuItem);
		changeMenu.add(addScoreMenuItem);
		changeMenu.add(deleteScoreMenuItem);
		menuBar.add(changeMenu);
		
		JMenu fileMenu=new JMenu("退出");
		JMenuItem exitMenuItem=new JMenuItem("out！");
		exitMenuItem.addActionListener(new ExitActionListener());//注册事件
		fileMenu.add(exitMenuItem);
		menuBar.add(fileMenu);
	}
	class ExitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			int result = JOptionPane.showConfirmDialog(null, "真的要推出吗?", "提示信息",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null);
			if (result == 0)
				System.exit(0);
			else if (result == 1) {
			}
		}
	}
	class QueryScoreActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		   new ScoreQueryUI();
		  
		}
	}
	class QueryActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new InformationQueryUI();
			
		}
	}
	class AddActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new StudentAddUI();
	    }
	}
	class DeleteActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new StudentDeleteUI();
	    }
	}
	class AddScoreActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new ScoreAddUI();
		}
	}
	class DeleteScoreActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new ScoreDeleteUI();
		}
	}
	public static void main(String[] args) {
		new TeacherMainUI();
	}
}
