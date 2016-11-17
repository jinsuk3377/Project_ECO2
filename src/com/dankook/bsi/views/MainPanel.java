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
	// private InfoGbXml_Panel infoGbXmlPanel;
	private BarChartFrame barchartFrame;
	private CsvWriter csvWriter;

	public final JButton simulationButton = new JButton("Simulation");

	private Ui_Model _model = null;

	public MainPanel(Ui_Model model) throws IOException {
		this._model = model;
		csvWriter = new CsvWriter(_model);
		createGbXmlPanel();
		createHVACPanel();
		createSimulationButton();

		setLayout(null);
		setSize(800, 340);

		refreshView();
	}

	private void createGbXmlPanel() {
		loadGbXmlPanel = new LoadGbXml_Panel(_model);
		loadGbXmlPanel.setSize(660, 95);
		loadGbXmlPanel.setToolTipText("");
		loadGbXmlPanel.setModel(_model);
		loadGbXmlPanel.setLocation(10, 35);
		add(loadGbXmlPanel);
		_model.setGbxmlPanel(loadGbXmlPanel);
	}

	private void createHVACPanel() {
		loadHVACPanel = new LoadHVAC_Panel(_model);
		loadHVACPanel.setSize(660, 95);
		loadHVACPanel.setToolTipText("");
		loadHVACPanel.setModel(_model);
		loadHVACPanel.setLocation(10, 135);
		add(loadHVACPanel);
		_model.setHvacPanel(loadHVACPanel);
	}
	/*
	 * private void createInfoGbXmlPanel() { infoGbXmlPanel = new
	 * InfoGbXml_Panel(_model); infoGbXmlPanel.setSize(660, 660);
	 * infoGbXmlPanel.setToolTipText(""); infoGbXmlPanel.setModel(_model);
	 * infoGbXmlPanel.setLocation(10, 150); add(infoGbXmlPanel); }
	 */

	private void createSimulationButton() {
		simulationButton.setForeground(SystemColor.desktop);
		simulationButton.setFont(new Font("Consolas", 0, 13));
		simulationButton.setBounds(535, 250, 132, 28);
		simulationButton.addActionListener(this);
		add(simulationButton);
		simulationButton.setEnabled(false);
	}

	private void refreshView() {
		if (this._model != null) {
			updateSimulationButton();
		}
	}

	private void updateSimulationButton() {
		if (_model.getIsConvertBIX())
			simulationButton.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.simulationButton) {

			if (!_model.getIsConvertBIX())
				JOptionPane.showMessageDialog(null,
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

		}
	}
	
	public void update() {
		refreshView();
	}
}
