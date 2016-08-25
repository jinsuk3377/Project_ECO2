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

public class HvacHeatPump extends JPanel {
	
	private JCheckBox HeatPumpCheckBox = new JCheckBox();
	private JLabel HeatPumpLabel = new JLabel();
	private JButton plusButton;
	private JButton minusButton;

	private ArrayList<JLabel> CountLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> NameLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> NameTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> TypeLabelAL = new ArrayList<JLabel>();
	private ArrayList<JComboBox> TypeComboBoxAL = new ArrayList<JComboBox>();
	private ArrayList<JLabel> SourceLabelAL = new ArrayList<JLabel>();
	private ArrayList<JComboBox> SourceComboBoxAL = new ArrayList<JComboBox>();
	private ArrayList<JLabel> C_CoolingLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> C_CapacityLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> C_CapacityTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> C_CapacitysubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> C_PowerLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> C_PowerTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> C_PowersubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> C_COPLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> C_COPTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> H_HeatingLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> H_CapacityLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> H_CapacityTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> H_CapacitysubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> H_PowerLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> H_PowerTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> H_PowersubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> H_COPLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> H_COPTextFieldAL = new ArrayList<JTextField>();

	private ArrayList<JPanel> JPanelAL = new ArrayList<JPanel>();
	private FlowLayout flowLayout;
	private int btnCounter;
	private int i;
	public final static int CountOfNodes = 10;

	public HvacHeatPump() {

		start();
		
	}
	
	public void start(){
		
		JPanel MainPanel = new JPanel();
		add(MainPanel);
		MainPanel.setLayout(new GridLayout(0, 4));

		// JScrollPane panelPane = new JScrollPane(MainPanel);

		JPanelAL = new ArrayList<JPanel>();
		btnCounter = 0;

		for (i = 0; i < 4 * (3 * CountOfNodes + 1); i++) {
			JPanelAL.add(new JPanel());
			flowLayout = (FlowLayout) JPanelAL.get(i).getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			if (i == 0)
				flowLayout.setAlignment(FlowLayout.LEFT);
			MainPanel.add(JPanelAL.get(i));
		}

		HeatPumpCheckBox = new JCheckBox();
		JPanelAL.get(0).add(HeatPumpCheckBox);

		HeatPumpLabel = new JLabel("HeatPump");
		HeatPumpLabel.setFont(new Font("Consolas", Font.BOLD, 14));
		JPanelAL.get(0).add(HeatPumpLabel);

		FlowLayout flowLayout = (FlowLayout) JPanelAL.get(3).getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		
		plusButton = new JButton("+");
		JPanelAL.get(3).add(plusButton);
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnCounter == 9)
					return;
				btnCounter++;
				ComponentsSetVisibleTrue();
			}
		});
		plusButton.setPreferredSize(new Dimension(20, 20));
		plusButton.setFont(new Font("Consolas", Font.PLAIN, 10));
		plusButton.setMargin(new Insets(0, 0, 0, 0));

		minusButton = new JButton("-");
		JPanelAL.get(3).add(minusButton);
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnCounter == 0)
					return;
				ComponentsSetVisibleFalse();
				btnCounter--;
			}
		});
		minusButton.setPreferredSize(new Dimension(20, 20));
		minusButton.setFont(new Font("Consolas", Font.PLAIN, 10));
		minusButton.setMargin(new Insets(0, 0, 0, 0));

		for (i = 0; i < CountOfNodes; i++) {

			CountLabelAL.add(new JLabel(String.valueOf(i + 1) + "."));
			JPanelAL.get(12 * i + 4).add(CountLabelAL.get(i));
			CountLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 11));
			CountLabelAL.get(i).setForeground(Color.RED);
			CountLabelAL.get(i).setVisible(false);

			NameLabelAL.add(new JLabel("Name"));
			JPanelAL.get(12 * i + 4).add(NameLabelAL.get(i));
			NameLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			NameLabelAL.get(i).setVisible(false);

			NameTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 4).add(NameTextFieldAL.get(i));
			NameTextFieldAL.get(i).setColumns(5);
			NameTextFieldAL.get(i).setVisible(false);

			TypeLabelAL.add(new JLabel("Type"));
			JPanelAL.get(12 * i + 8).add(TypeLabelAL.get(i));
			TypeLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			TypeLabelAL.get(i).setVisible(false);

			TypeComboBoxAL.add(new JComboBox());
			JPanelAL.get(12 * i + 8).add(TypeComboBoxAL.get(i));
			TypeComboBoxAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			TypeComboBoxAL.get(i).setModel(
					new DefaultComboBoxModel(
							new String[] { "Air", "Water" }));
			TypeComboBoxAL.get(i).setMaximumRowCount(2);
			TypeComboBoxAL.get(i).setVisible(false);
			
			SourceLabelAL.add(new JLabel("Source"));
			JPanelAL.get(12 * i + 12).add(SourceLabelAL.get(i));
			SourceLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 12));
			SourceLabelAL.get(i).setVisible(false);

			SourceComboBoxAL.add(new JComboBox());
			JPanelAL.get(12 * i + 12).add(SourceComboBoxAL.get(i));
			SourceComboBoxAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			SourceComboBoxAL.get(i).setModel(
					new DefaultComboBoxModel(
							new String[] { "Electricity", "Gas" }));
			SourceComboBoxAL.get(i).setMaximumRowCount(2);
			SourceComboBoxAL.get(i).setVisible(false);
			
			C_CoolingLabelAL.add(new JLabel(" Cool: "));
			JPanelAL.get(12 * i + 5).add(C_CoolingLabelAL.get(i));
			C_CoolingLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			C_CoolingLabelAL.get(i).setForeground(Color.BLUE);
			C_CoolingLabelAL.get(i).setVisible(false);
			
			C_CapacityLabelAL.add(new JLabel("Capacity"));
			JPanelAL.get(12 * i + 5).add(C_CapacityLabelAL.get(i));
			C_CapacityLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			C_CapacityLabelAL.get(i).setVisible(false);
			
			C_CapacityTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 5).add(C_CapacityTextFieldAL.get(i));
			C_CapacityTextFieldAL.get(i).setColumns(4);
			C_CapacityTextFieldAL.get(i).setVisible(false);
			
			C_CapacitysubLabelAL.add(new JLabel("kW "));
			JPanelAL.get(12 * i + 6).add(C_CapacitysubLabelAL.get(i));
			C_CapacitysubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			C_CapacitysubLabelAL.get(i).setVisible(false);
			
			C_PowerLabelAL.add(new JLabel("      Power"));
			JPanelAL.get(12 * i + 6).add(C_PowerLabelAL.get(i));
			C_PowerLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			C_PowerLabelAL.get(i).setVisible(false);
			
			C_PowerTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 6).add(C_PowerTextFieldAL.get(i));
			C_PowerTextFieldAL.get(i).setColumns(4);
			C_PowerTextFieldAL.get(i).setVisible(false);
			
			C_PowersubLabelAL.add(new JLabel("kW"));
			JPanelAL.get(12 * i + 7).add(C_PowersubLabelAL.get(i));
			C_PowersubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			C_PowersubLabelAL.get(i).setVisible(false);
			
			C_COPLabelAL.add(new JLabel("      COP"));
			JPanelAL.get(12 * i + 7).add(C_COPLabelAL.get(i));
			C_COPLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			C_COPLabelAL.get(i).setVisible(false);
			
			C_COPTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 7).add(C_COPTextFieldAL.get(i));
			C_COPTextFieldAL.get(i).setColumns(4);
			C_COPTextFieldAL.get(i).setVisible(false);
			
			H_HeatingLabelAL.add(new JLabel(" Heat: "));
			JPanelAL.get(12 * i + 9).add(H_HeatingLabelAL.get(i));
			H_HeatingLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			H_HeatingLabelAL.get(i).setForeground(Color.RED);
			H_HeatingLabelAL.get(i).setVisible(false);
			
			H_CapacityLabelAL.add(new JLabel("Capacity"));
			JPanelAL.get(12 * i + 9).add(H_CapacityLabelAL.get(i));
			H_CapacityLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			H_CapacityLabelAL.get(i).setVisible(false);
			
			H_CapacityTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 9).add(H_CapacityTextFieldAL.get(i));
			H_CapacityTextFieldAL.get(i).setColumns(4);
			H_CapacityTextFieldAL.get(i).setVisible(false);
			
			H_CapacitysubLabelAL.add(new JLabel("kW "));
			JPanelAL.get(12 * i + 10).add(H_CapacitysubLabelAL.get(i));
			H_CapacitysubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			H_CapacitysubLabelAL.get(i).setVisible(false);
			
			H_PowerLabelAL.add(new JLabel("      Power"));
			JPanelAL.get(12 * i + 10).add(H_PowerLabelAL.get(i));
			H_PowerLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			H_PowerLabelAL.get(i).setVisible(false);
			
			H_PowerTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 10).add(H_PowerTextFieldAL.get(i));
			H_PowerTextFieldAL.get(i).setColumns(4);
			H_PowerTextFieldAL.get(i).setVisible(false);
			
			H_PowersubLabelAL.add(new JLabel("kW"));
			JPanelAL.get(12 * i + 11).add(H_PowersubLabelAL.get(i));
			H_PowersubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			H_PowersubLabelAL.get(i).setVisible(false);
			
			H_COPLabelAL.add(new JLabel("      COP"));
			JPanelAL.get(12 * i + 11).add(H_COPLabelAL.get(i));
			H_COPLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			H_COPLabelAL.get(i).setVisible(false);
			
			H_COPTextFieldAL.add(new JTextField());
			JPanelAL.get(12 * i + 11).add(H_COPTextFieldAL.get(i));
			H_COPTextFieldAL.get(i).setColumns(4);
			H_COPTextFieldAL.get(i).setVisible(false);
			
			flowLayout = (FlowLayout) JPanelAL.get(12 * i + 5).getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			
			flowLayout = (FlowLayout) JPanelAL.get(12 * i + 6).getLayout();
			flowLayout.setAlignment(FlowLayout.CENTER);
			
			flowLayout = (FlowLayout) JPanelAL.get(12 * i + 7).getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			
			flowLayout = (FlowLayout) JPanelAL.get(12 * i + 9).getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			
			flowLayout = (FlowLayout) JPanelAL.get(12 * i + 10).getLayout();
			flowLayout.setAlignment(FlowLayout.CENTER);
			
			flowLayout = (FlowLayout) JPanelAL.get(12 * i + 11).getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
						
		}

		ComponentsSetVisibleTrue();
	}

	void ComponentsSetVisibleTrue() {
		CountLabelAL.get(btnCounter).setVisible(true);
		NameLabelAL.get(btnCounter).setVisible(true);
		NameTextFieldAL.get(btnCounter).setVisible(true);
		TypeLabelAL.get(btnCounter).setVisible(true);
		TypeComboBoxAL.get(btnCounter).setVisible(true);
		SourceLabelAL.get(btnCounter).setVisible(true);
		SourceComboBoxAL.get(btnCounter).setVisible(true);
		C_CoolingLabelAL.get(btnCounter).setVisible(true);
		C_CapacityLabelAL.get(btnCounter).setVisible(true);
		C_CapacityTextFieldAL.get(btnCounter).setVisible(true);
		C_CapacitysubLabelAL.get(btnCounter).setVisible(true);
		C_PowerLabelAL.get(btnCounter).setVisible(true);
		C_PowerTextFieldAL.get(btnCounter).setVisible(true);
		C_PowersubLabelAL.get(btnCounter).setVisible(true);
		C_COPLabelAL.get(btnCounter).setVisible(true);
		C_COPTextFieldAL.get(btnCounter).setVisible(true);
		H_HeatingLabelAL.get(btnCounter).setVisible(true);
		H_CapacityLabelAL.get(btnCounter).setVisible(true);
		H_CapacityTextFieldAL.get(btnCounter).setVisible(true);
		H_CapacitysubLabelAL.get(btnCounter).setVisible(true);
		H_PowerLabelAL.get(btnCounter).setVisible(true);
		H_PowerTextFieldAL.get(btnCounter).setVisible(true);
		H_PowersubLabelAL.get(btnCounter).setVisible(true);
		H_COPLabelAL.get(btnCounter).setVisible(true);
		H_COPTextFieldAL.get(btnCounter).setVisible(true);
	}

	void ComponentsSetVisibleFalse() {
		CountLabelAL.get(btnCounter).setVisible(false);
		NameLabelAL.get(btnCounter).setVisible(false);
		NameTextFieldAL.get(btnCounter).setVisible(false);
		TypeLabelAL.get(btnCounter).setVisible(false);
		TypeComboBoxAL.get(btnCounter).setVisible(false);
		SourceLabelAL.get(btnCounter).setVisible(false);
		SourceComboBoxAL.get(btnCounter).setVisible(false);
		C_CoolingLabelAL.get(btnCounter).setVisible(false);
		C_CapacityLabelAL.get(btnCounter).setVisible(false);
		C_CapacityTextFieldAL.get(btnCounter).setVisible(false);
		C_CapacitysubLabelAL.get(btnCounter).setVisible(false);
		C_PowerLabelAL.get(btnCounter).setVisible(false);
		C_PowerTextFieldAL.get(btnCounter).setVisible(false);
		C_PowersubLabelAL.get(btnCounter).setVisible(false);
		C_COPLabelAL.get(btnCounter).setVisible(false);
		C_COPTextFieldAL.get(btnCounter).setVisible(false);
		H_HeatingLabelAL.get(btnCounter).setVisible(false);
		H_CapacityLabelAL.get(btnCounter).setVisible(false);
		H_CapacityTextFieldAL.get(btnCounter).setVisible(false);
		H_CapacitysubLabelAL.get(btnCounter).setVisible(false);
		H_PowerLabelAL.get(btnCounter).setVisible(false);
		H_PowerTextFieldAL.get(btnCounter).setVisible(false);
		H_PowersubLabelAL.get(btnCounter).setVisible(false);
		H_COPLabelAL.get(btnCounter).setVisible(false);
		H_COPTextFieldAL.get(btnCounter).setVisible(false);
	}
	
}
