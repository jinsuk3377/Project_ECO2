package com.dankook.bsi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.dankook.bsi.util.geometry.*;

import com.dankook.bsi.model.*;
import com.dankook.bsi.simulation.CsvWriter;
import com.dankook.bsi.util.Ui_Observer;

public class MainPanel extends JPanel implements Ui_Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	private LoadGbXml_Panel loadGbXmlPanel;
	private LoadHVAC_Panel loadHVACPanel;
	private ModelViewPanel modelViewPanel;
	private InfoGbXml_Panel infoGbXmlPanel;
	private BarChartFrame barchartFrame;
	private CsvWriter csvWriter;
	
	private JScrollPane infoGbXmlJScrollPane;

	public final JButton simulationButton = new JButton("Simulation");

	private Ui_Model _model = null;

	public MainPanel(Ui_Model model) throws IOException {
		this._model = model;
		this._model.addObserver(this);
		csvWriter = new CsvWriter(_model);
		createGbXmlPanel();
		createModelViewPanel();
		createInfoGbXmlPanel();
		createHVACPanel();
		createSimulationButton();

		setLayout(null);
		setSize(700, 850);

		refreshView();
	}

	private void createGbXmlPanel() {
		loadGbXmlPanel = new LoadGbXml_Panel(_model);
		loadGbXmlPanel.setSize(660, 95);
		loadGbXmlPanel.setToolTipText("");
		loadGbXmlPanel.setModel(_model);
		loadGbXmlPanel.setLocation(10, 25);
		add(loadGbXmlPanel);
	}
	
	private void createHVACPanel() {
		loadHVACPanel = new LoadHVAC_Panel(_model);
		loadHVACPanel.setSize(660, 95);
		loadHVACPanel.setToolTipText("");
		loadHVACPanel.setModel(_model);
		loadHVACPanel.setLocation(10, 120);
		add(loadHVACPanel);
	}

	private void createModelViewPanel() {
		modelViewPanel = new ModelViewPanel(_model);
		modelViewPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Model View", 4, 2, null,
				new Color(0, 0, 255)));
		modelViewPanel.setBounds(10, 215, 660, 290);
		add(modelViewPanel);
	}

	private void createInfoGbXmlPanel() {
		infoGbXmlPanel = new InfoGbXml_Panel(_model);
		infoGbXmlPanel.setPreferredSize(new Dimension(650, 410));
		infoGbXmlPanel.setToolTipText("");
		infoGbXmlPanel.setModel(_model);
		
		infoGbXmlJScrollPane = new JScrollPane(infoGbXmlPanel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		infoGbXmlJScrollPane.setBounds(10, 505, 660, 250);
		infoGbXmlJScrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BIM Information", 4, 2, null,
				new Color(0, 0, 255)));
		
		add(infoGbXmlJScrollPane, BorderLayout.CENTER);
	}
	
	private void createSimulationButton() {
		simulationButton.setForeground(SystemColor.desktop);
		simulationButton.setFont(new Font("Consolas", 0, 13));
		simulationButton.setBounds(535, 770, 132, 28);
		simulationButton.addActionListener(this);
		add(simulationButton);
		simulationButton.setEnabled(false);
	}

	private void updateSimulationButton() {
		if (_model.isConvertBIX()>0)
			simulationButton.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.simulationButton) {

			if (_model.isConvertBIX()==0)
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

	public void refreshView() {
		if (this._model != null) {
			updateSimulationButton();
		}
	}

	public void update(Object eventDispatcher) {
		refreshView();
	}
}
