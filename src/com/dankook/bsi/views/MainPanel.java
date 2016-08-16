package com.dankook.bsi.views;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dankook.bsi.model.Ui_Model;
import com.dankook.bsi.util.Ui_Observer;
import com.dankook.bsi.views.dataprocessing.*;

public class MainPanel extends JPanel implements Ui_Observer, ActionListener {
	
	private static final long serialVersionUID = 1L;
	private LoadGbXml_Panel loadGbXmlPanel;
	private InfoGbXml_Panel infoGbXmlPanel;
	//private GbXmltoBIX gbxmltoBIX = new GbXmltoBIX();
	
	public final JButton simulationButton = new JButton("Simulation");

	private Ui_Model _model = null;

	public MainPanel(Ui_Model model) {
		this._model = model;

		createLoadGbXmlPanel();
		createSimulationButton();
		createInfoGbXmlPanel();
		
		setLayout(null);
		setSize(800, 800);

		refreshView();
	}
	
	private void createLoadGbXmlPanel() {
		loadGbXmlPanel = new LoadGbXml_Panel();
		loadGbXmlPanel.setSize(660, 95);
		loadGbXmlPanel.setToolTipText("");
		loadGbXmlPanel.setModel(_model);
		loadGbXmlPanel.setLocation(10, 35);
		add(loadGbXmlPanel);
	}
	
	private void createInfoGbXmlPanel() {
		infoGbXmlPanel = new InfoGbXml_Panel();
		infoGbXmlPanel.setSize(660, 500);
		infoGbXmlPanel.setToolTipText("");
		infoGbXmlPanel.setModel(_model);
		infoGbXmlPanel.setLocation(10, 150);
		add(infoGbXmlPanel);
	}
	
	private void createSimulationButton() {
		simulationButton.setForeground(SystemColor.desktop);
		simulationButton.setFont(new Font("Consolas", 0, 13));
		simulationButton.setBounds(535, 660, 132, 28);
		simulationButton.addActionListener(this);
		add(simulationButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public void update(Object eventDispatcher) {
		refreshView();
	}

	private void refreshView() {
		if (this._model != null) {
			updateSimulationButton();
		}
	}

	private void updateSimulationButton() {
		
	}

	/*
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(this.generateBIXButton)) {
			convert();
		}
		
	}
	
	private void convert() {
		
		gbxmltoBIX.setPath(_model.getGbxmlFilePath());
		gbxmltoBIX.startConvert();
		int rightPosition = 0;
        for(int i=0; i < _model.getGbxmlFilePath().length(); i++){
            if(_model.getGbxmlFilePath().charAt(i) == '\\'){
                 rightPosition = i+1; 
                 // do what ever you want with character and its position
            }
        }
        _model.setBIXFilePath(_model.getGbxmlFilePath().substring(0, rightPosition));
	}
	*/
	
}
