package com.dankook.bsi.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.xml.sax.SAXException;

import com.dankook.bsi.util.geometry.*;
import com.dankook.bsi.main.Ui_Main;
import com.dankook.bsi.model.*;
import com.dankook.bsi.simulation.CsvWriter;
import com.dankook.bsi.util.Ui_Observer;
import com.dankook.bsi.views.dataprocessing.*;

public class MainPanel extends JPanel implements Ui_Observer, ActionListener {
	
	private static final long serialVersionUID = 1L;
	private LoadGbXml_Panel loadGbXmlPanel;
	private LoadHVAC_Panel loadHVACPanel;
	//private InfoGbXml_Panel infoGbXmlPanel;
	//private BarChartDemo barchartDemo;
	//private BarChartDemo2 barchartDemo2;
	//private BarChartDemo3 barchartDemo3;
	private BarChartFrame barchartFrame;
	private CsvWriter csvWriter;
	//private GbXmltoBIX gbxmltoBIX = new GbXmltoBIX();
	
	public final JButton simulationButton = new JButton("Simulation");

	private Ui_Model _model = null;

	public MainPanel(Ui_Model model) throws IOException {
		this._model = model;
		//barchartDemo = new BarChartDemo(getName());
		//barchartDemo2 = new BarChartDemo2(getName());
		//barchartDemo3 = new BarChartDemo3(getName());
		csvWriter = new CsvWriter(_model);
		createLoadGbXmlPanel();
		createLoadHVACPanel();
		createSimulationButton();
		//createInfoGbXmlPanel();
		
		setLayout(null);
		//setSize(800, 950);
		setSize(800, 340);
		
		refreshView();
	}
	
	private void createLoadGbXmlPanel() {
		loadGbXmlPanel = new LoadGbXml_Panel(_model);
		loadGbXmlPanel.setSize(660, 95);
		loadGbXmlPanel.setToolTipText("");
		loadGbXmlPanel.setModel(_model);
		loadGbXmlPanel.setLocation(10, 35);
		add(loadGbXmlPanel);
	}
	
	private void createLoadHVACPanel() {
		loadHVACPanel = new LoadHVAC_Panel(_model);
		loadHVACPanel.setSize(660, 95);
		loadHVACPanel.setToolTipText("");
		loadHVACPanel.setModel(_model);
		loadHVACPanel.setLocation(10, 135);
		add(loadHVACPanel);
	}
	/*
	private void createInfoGbXmlPanel() {
		infoGbXmlPanel = new InfoGbXml_Panel(_model);
		infoGbXmlPanel.setSize(660, 660);
		infoGbXmlPanel.setToolTipText("");
		infoGbXmlPanel.setModel(_model);
		infoGbXmlPanel.setLocation(10, 150);
		add(infoGbXmlPanel);
	}
	*/
	
	private void createSimulationButton() {
		simulationButton.setForeground(SystemColor.desktop);
		simulationButton.setFont(new Font("Consolas", 0, 13));
		//simulationButton.setBounds(535, 820, 132, 28);
		simulationButton.setBounds(535, 250, 132, 28);
		simulationButton.addActionListener(this);
		add(simulationButton);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.simulationButton) {
			
			if (!_model.getConvertBIXCheck()) JOptionPane.showMessageDialog(null, 
					"Press ... button in BIM Model Upload dialog and import your building information model file that gbXML format.", 
					"Message: Simulation", JOptionPane.INFORMATION_MESSAGE);
			
			else {
				
				_model.setInfoValues(); // Simulation
				
				try {
					csvWriter.csvWriter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							barchartFrame = new BarChartFrame(_model);
							barchartFrame.setTitle("test");
							barchartFrame.setDefaultCloseOperation(3);
							barchartFrame.setSize(1000, 700);
							barchartFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
			
			
			//barchartDemo.start();
			//barchartDemo2.start();
			//barchartDemo3.start();
		}
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
