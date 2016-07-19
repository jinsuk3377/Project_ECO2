package bsi.dankook.main;

import java.awt.*;
import javax.swing.*;

public class EDI_Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTabbedPane Tab;// add

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EDI_Main frame = new EDI_Main();
					frame.setTitle("ECO2 Simulator");
					frame.setDefaultCloseOperation(3);
					frame.setSize(700, 700);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EDI_Main() {

		setLayout(null);
		setMenuBar();

	}
	
	public void setMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		add(menuBar);

		JMenu mnhelp = new JMenu("Help");
		mnhelp.setActionCommand("Help");
		menuBar.add(mnhelp);

		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mnhelp.add(mntmNewMenuItem);
		
	}
}