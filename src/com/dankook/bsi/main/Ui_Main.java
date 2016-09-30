package com.dankook.bsi.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.dankook.bsi.model.Ui_Model;
import com.dankook.bsi.util.Ui_Observer;
import com.dankook.bsi.views.*;
import com.opencsv.CSVWriter;

public class Ui_Main extends JFrame implements Ui_Observer {
	
	private static final long serialVersionUID = 1L;
	private Ui_Model _model;
	private MainPanel mainPanel;
	private JTabbedPane Tab;// add

	public static void main(String[] args){
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui_Main frame = new Ui_Main();
					frame.setTitle("ECO2 Simulator");
					frame.setDefaultCloseOperation(3);
					//frame.setSize(700, 900);
					frame.setSize(700, 250);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Ui_Main() throws IOException {
		
		_model = new Ui_Model();
		mainPanel = new MainPanel(_model);

		add(mainPanel);
		setMenuBar();
	}
	
	public void setMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		mainPanel.add(menuBar);

		JMenu mnhelp = new JMenu("Help");
		mnhelp.setActionCommand("Help");
		menuBar.add(mnhelp);

		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mnhelp.add(mntmNewMenuItem);
		
	}

	@Override
	public void update(Object paramObject) {
		// TODO Auto-generated method stub
		
	}
}