package com.dankook.bsi.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class HvacBoiler extends JPanel
{
	private JCheckBox BoilerCheckBox = new JCheckBox();
	private JLabel BoilerLabel = new JLabel();
	private JButton plusButton;
	private JButton minusButton;
	
	private ArrayList<JLabel> CountLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> NameLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> NameTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> TypeLabelAL = new ArrayList<JLabel>();
	private ArrayList<JComboBox> TypeComboBoxAL = new ArrayList<JComboBox>();
	private ArrayList<JLabel> FuelTypeLabelAL = new ArrayList<JLabel>();
	private ArrayList<JComboBox> FuelTypeComboBoxAL = new ArrayList<JComboBox>();
	private ArrayList<JLabel> EfficiencyLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> EfficiencyTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> EfficiencysubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> PumpPowerLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> PumpPowerTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> PumpPowersubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> PipeLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> PipeTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> PipesubLabelAL = new ArrayList<JLabel>();
	
	private ArrayList<JPanel> JPanelAL = new ArrayList<JPanel>();
	private FlowLayout flowLayout;
	private int btnCounter;
	private int i;
	public final static int CountOfNodes = 10;
	

	public HvacBoiler() {

		start();
		
	}
	
	public void start(){
		
		JPanel MainPanel = new JPanel();
		add(MainPanel);
		MainPanel.setLayout(new GridLayout(0, 4));
		
		//JScrollPane panelPane = new JScrollPane(MainPanel);

		JPanelAL = new ArrayList<JPanel>();
		btnCounter = 0;
		
		for(i = 0; i < 4 * (2*CountOfNodes + 1); i++){
			JPanelAL.add(new JPanel());
			flowLayout = (FlowLayout) JPanelAL.get(i).getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			if(i == 0) flowLayout.setAlignment(FlowLayout.LEFT);
			MainPanel.add(JPanelAL.get(i));
		}
		
		BoilerCheckBox = new JCheckBox();
		JPanelAL.get(0).add(BoilerCheckBox);

		BoilerLabel = new JLabel("Boiler");
		BoilerLabel.setFont(new Font("Consolas", Font.BOLD, 14));
		JPanelAL.get(0).add(BoilerLabel);
		
		plusButton = new JButton("+");
		JPanelAL.get(3).add(plusButton);
		plusButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(btnCounter == 9) return;
				btnCounter++;
				ComponentsSetVisibleTrue();
			}
		});   
		plusButton.setPreferredSize(new Dimension(20, 20));
		plusButton.setFont(new Font("Consolas", Font.PLAIN, 10));
		plusButton.setMargin(new Insets(0, 0, 0, 0));
		
		minusButton = new JButton("-");
		JPanelAL.get(3).add(minusButton);
		minusButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(btnCounter == 0) return;
				ComponentsSetVisibleFalse();
				btnCounter--;
			}
		});
		minusButton.setPreferredSize(new Dimension(20, 20));
		minusButton.setFont(new Font("Consolas", Font.PLAIN, 10));
		minusButton.setMargin(new Insets(0, 0, 0, 0));
		
		for(i = 0; i < CountOfNodes; i++){
			
			CountLabelAL.add(new JLabel(String.valueOf(i+1)+"."));
			JPanelAL.get(8*i+4).add(CountLabelAL.get(i));
			CountLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 11));
			CountLabelAL.get(i).setForeground(Color.RED);
			CountLabelAL.get(i).setVisible(false);
			
			NameLabelAL.add(new JLabel("Name"));
			JPanelAL.get(8*i+4).add(NameLabelAL.get(i));
			NameLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			NameLabelAL.get(i).setVisible(false);

			NameTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+4).add(NameTextFieldAL.get(i));
			NameTextFieldAL.get(i).setColumns(5);
			NameTextFieldAL.get(i).setVisible(false);

			TypeLabelAL.add(new JLabel("Type"));
			JPanelAL.get(8*i+5).add(TypeLabelAL.get(i));
			TypeLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			TypeLabelAL.get(i).setVisible(false);

			TypeComboBoxAL.add(new JComboBox());
			JPanelAL.get(8*i+5).add(TypeComboBoxAL.get(i));
			TypeComboBoxAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			TypeComboBoxAL.get(i).setModel(new DefaultComboBoxModel(new String[] {
					"Steam", "HotWater" }));
			TypeComboBoxAL.get(i).setMaximumRowCount(2);
			TypeComboBoxAL.get(i).setVisible(false);

			FuelTypeLabelAL.add(new JLabel("FuelTyp"));
			JPanelAL.get(8*i+6).add(FuelTypeLabelAL.get(i));
			FuelTypeLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 11));
			FuelTypeLabelAL.get(i).setVisible(false);

			FuelTypeComboBoxAL.add(new JComboBox());
			JPanelAL.get(8*i+6).add(FuelTypeComboBoxAL.get(i));
			FuelTypeComboBoxAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			FuelTypeComboBoxAL.get(i).setModel(new DefaultComboBoxModel(new String[] {
					"Electricity", "NaturalGas", "Oil" }));
			FuelTypeComboBoxAL.get(i).setMaximumRowCount(3);
			FuelTypeComboBoxAL.get(i).setVisible(false);
			
			EfficiencyLabelAL.add(new JLabel("Efficiency"));
			JPanelAL.get(8*i+7).add(EfficiencyLabelAL.get(i));
			EfficiencyLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 11));
			EfficiencyLabelAL.get(i).setVisible(false);

			EfficiencyTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+7).add(EfficiencyTextFieldAL.get(i));
			EfficiencyTextFieldAL.get(i).setColumns(5);
			EfficiencyTextFieldAL.get(i).setVisible(false);
			
			EfficiencysubLabelAL.add(new JLabel("%"));
			JPanelAL.get(8*i+7).add(EfficiencysubLabelAL.get(i));
			EfficiencysubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			EfficiencysubLabelAL.get(i).setVisible(false);
			
			PumpPowerLabelAL.add(new JLabel("PumpPower"));
			JPanelAL.get(8*i+10).add(PumpPowerLabelAL.get(i));
			PumpPowerLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 11));
			PumpPowerLabelAL.get(i).setVisible(false);
			
			PumpPowerTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+10).add(PumpPowerTextFieldAL.get(i));
			PumpPowerTextFieldAL.get(i).setColumns(5);
			PumpPowerTextFieldAL.get(i).setVisible(false);
			
			PumpPowersubLabelAL.add(new JLabel("kW"));
			JPanelAL.get(8*i+10).add(PumpPowersubLabelAL.get(i));
			PumpPowersubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			PumpPowersubLabelAL.get(i).setVisible(false);
			
			PipeLabelAL.add(new JLabel("Pipe"));
			JPanelAL.get(8*i+11).add(PipeLabelAL.get(i));
			PipeLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			PipeLabelAL.get(i).setVisible(false);
			
			PipeTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+11).add(PipeTextFieldAL.get(i));
			PipeTextFieldAL.get(i).setColumns(5);
			PipeTextFieldAL.get(i).setVisible(false);
			
			PipesubLabelAL.add(new JLabel("m"));
			JPanelAL.get(8*i+11).add(PipesubLabelAL.get(i));
			PipesubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			PipesubLabelAL.get(i).setVisible(false);
			
		}
		
		ComponentsSetVisibleTrue();
	}
	
	void ComponentsSetVisibleTrue(){
		CountLabelAL.get(btnCounter).setVisible(true);
		NameLabelAL.get(btnCounter).setVisible(true);
		NameTextFieldAL.get(btnCounter).setVisible(true);
		TypeLabelAL.get(btnCounter).setVisible(true);
		TypeComboBoxAL.get(btnCounter).setVisible(true);
		FuelTypeLabelAL.get(btnCounter).setVisible(true);
		FuelTypeComboBoxAL.get(btnCounter).setVisible(true);
		EfficiencyLabelAL.get(btnCounter).setVisible(true);
		EfficiencyTextFieldAL.get(btnCounter).setVisible(true);
		EfficiencysubLabelAL.get(btnCounter).setVisible(true);
		PumpPowerLabelAL.get(btnCounter).setVisible(true);
		PumpPowerTextFieldAL.get(btnCounter).setVisible(true);
		PumpPowersubLabelAL.get(btnCounter).setVisible(true);
		PipeLabelAL.get(btnCounter).setVisible(true);
		PipeTextFieldAL.get(btnCounter).setVisible(true);
		PipesubLabelAL.get(btnCounter).setVisible(true);
	}
	
	void ComponentsSetVisibleFalse(){
		CountLabelAL.get(btnCounter).setVisible(false);
		NameLabelAL.get(btnCounter).setVisible(false);
		NameTextFieldAL.get(btnCounter).setVisible(false);
		TypeLabelAL.get(btnCounter).setVisible(false);
		TypeComboBoxAL.get(btnCounter).setVisible(false);
		FuelTypeLabelAL.get(btnCounter).setVisible(false);
		FuelTypeComboBoxAL.get(btnCounter).setVisible(false);
		EfficiencyLabelAL.get(btnCounter).setVisible(false);
		EfficiencyTextFieldAL.get(btnCounter).setVisible(false);
		EfficiencysubLabelAL.get(btnCounter).setVisible(false);
		PumpPowerLabelAL.get(btnCounter).setVisible(false);
		PumpPowerTextFieldAL.get(btnCounter).setVisible(false);
		PumpPowersubLabelAL.get(btnCounter).setVisible(false);
		PipeLabelAL.get(btnCounter).setVisible(false);
		PipeTextFieldAL.get(btnCounter).setVisible(false);
		PipesubLabelAL.get(btnCounter).setVisible(false);
	}
	
}
