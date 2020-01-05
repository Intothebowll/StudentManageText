package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TeacherMainUI extends JFrame{
Container ctp;
     TeacherMainUI(){
		ctp = this.getContentPane();
		this.setTitle("��ӭ����ѧ������ϵͳ��");
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
		
		JMenu queryMenu=new JMenu("��ѯ");
		JMenuItem queryMenuItem=new JMenuItem("ѧ��������Ϣ");
		JMenuItem queryScoreMenuItem=new JMenuItem("ѧ���ɼ���ѯ");
		queryMenuItem.addActionListener(new QueryActionListener());//ע���¼�
	    queryScoreMenuItem.addActionListener(new QueryScoreActionListener());//ע���¼�
		queryMenu.add(queryMenuItem);
		queryMenu.add(queryScoreMenuItem);
		menuBar.add(queryMenu);
		
		JMenu changeMenu=new JMenu("�޸�");
		JMenuItem addMenuItem=new JMenuItem("����������Ϣ");
		JMenuItem deleteMenuItem=new JMenuItem("ɾ����ҵ����Ϣ");
		JMenuItem addScoreMenuItem=new JMenuItem("���ӳɼ���Ϣ");
		JMenuItem deleteScoreMenuItem=new JMenuItem("ɾ���ɼ���Ϣ");
		addMenuItem.addActionListener(new AddActionListener());//ע���¼�
		deleteMenuItem.addActionListener(new DeleteActionListener());//ע���¼�
		addScoreMenuItem.addActionListener(new AddScoreActionListener());//ע���¼�
		deleteScoreMenuItem.addActionListener(new DeleteScoreActionListener());//ע���¼�
		changeMenu.add(addMenuItem);
		changeMenu.add(deleteMenuItem);
		changeMenu.add(addScoreMenuItem);
		changeMenu.add(deleteScoreMenuItem);
		menuBar.add(changeMenu);
		
		JMenu fileMenu=new JMenu("�˳�");
		JMenuItem exitMenuItem=new JMenuItem("out��");
		exitMenuItem.addActionListener(new ExitActionListener());//ע���¼�
		fileMenu.add(exitMenuItem);
		menuBar.add(fileMenu);
	}
	class ExitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			int result = JOptionPane.showConfirmDialog(null, "���Ҫ�Ƴ���?", "��ʾ��Ϣ",
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
