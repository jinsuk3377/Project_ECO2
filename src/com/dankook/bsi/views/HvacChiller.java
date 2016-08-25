package com.dankook.bsi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class HvacChiller extends JPanel {

	private JCheckBox ChillerCheckBox = new JCheckBox();
	private JLabel ChillerLabel = new JLabel();
	private JButton plusButton;
	private JButton minusButton;
	
	private ArrayList<JLabel> CountLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> NameLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> NameTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> TypeLabelAL = new ArrayList<JLabel>();
	private ArrayList<JComboBox> TypeComboBoxAL = new ArrayList<JComboBox>();
	private ArrayList<JLabel> CapacityLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> CapacityTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> CapacitysubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> COPLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> COPTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> COPsubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> CHWPumpLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> CHWPumpTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> CHWPumpsubLabelAL = new ArrayList<JLabel>();
	private ArrayList<JLabel> CWPumpLabelAL = new ArrayList<JLabel>();
	private ArrayList<JTextField> CWPumpTextFieldAL = new ArrayList<JTextField>();
	private ArrayList<JLabel> CWPumpsubLabelAL = new ArrayList<JLabel>();
	
	private ArrayList<JPanel> JPanelAL = new ArrayList<JPanel>();
	private FlowLayout flowLayout;
	private int btnCounter;
	private int i;
	public final static int CountOfNodes = 10;
	

	public HvacChiller() {
		//_model.getGbxmlFilePath().substring(0, _model.getGbxmlFilePath().length()-15)
		//CapacityTextFieldAL.get(0).getText();
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
		
		ChillerCheckBox = new JCheckBox();
		JPanelAL.get(0).add(ChillerCheckBox);
		
		

		ChillerLabel = new JLabel("Chiller");
		ChillerLabel.setFont(new Font("Consolas", Font.BOLD, 14));
		JPanelAL.get(0).add(ChillerLabel);
		
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
					"Compression", "Absorption" }));
			
			TypeComboBoxAL.get(i).setMaximumRowCount(2);
			TypeComboBoxAL.get(i).setVisible(false);

			CapacityLabelAL.add(new JLabel("Capacity"));
			JPanelAL.get(8*i+6).add(CapacityLabelAL.get(i));
			CapacityLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			CapacityLabelAL.get(i).setVisible(false);

			CapacityTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+6).add(CapacityTextFieldAL.get(i));
			CapacityTextFieldAL.get(i).setColumns(5);
			CapacityTextFieldAL.get(i).setVisible(false);			
			
			CapacitysubLabelAL.add(new JLabel("kW"));
			JPanelAL.get(8*i+6).add(CapacitysubLabelAL.get(i));
			CapacitysubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			CapacitysubLabelAL.get(i).setVisible(false);

			COPLabelAL.add(new JLabel("COP"));
			JPanelAL.get(8*i+7).add(COPLabelAL.get(i));
			COPLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			COPLabelAL.get(i).setVisible(false);

			COPTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+7).add(COPTextFieldAL.get(i));
			COPTextFieldAL.get(i).setColumns(5);
			COPTextFieldAL.get(i).setVisible(false);
			
			COPsubLabelAL.add(new JLabel("  "));
			JPanelAL.get(8*i+7).add(COPsubLabelAL.get(i));
			COPsubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			COPsubLabelAL.get(i).setVisible(false);
			
			CHWPumpLabelAL.add(new JLabel("CHWPump"));
			JPanelAL.get(8*i+10).add(CHWPumpLabelAL.get(i));
			CHWPumpLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			CHWPumpLabelAL.get(i).setVisible(false);
			
			CHWPumpLabelAL.add(new JLabel("CHWPump"));
			JPanelAL.get(8*i+10).add(CHWPumpLabelAL.get(i));
			CHWPumpLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			CHWPumpLabelAL.get(i).setVisible(false);
			
			CHWPumpTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+10).add(CHWPumpTextFieldAL.get(i));
			CHWPumpTextFieldAL.get(i).setColumns(5);
			CHWPumpTextFieldAL.get(i).setVisible(false);
			
			CHWPumpsubLabelAL.add(new JLabel("kW"));
			JPanelAL.get(8*i+10).add(CHWPumpsubLabelAL.get(i));
			CHWPumpsubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			CHWPumpsubLabelAL.get(i).setVisible(false);
			
			CWPumpLabelAL.add(new JLabel("CWPump"));
			JPanelAL.get(8*i+11).add(CWPumpLabelAL.get(i));
			CWPumpLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 13));
			CWPumpLabelAL.get(i).setVisible(false);
			
			CWPumpTextFieldAL.add(new JTextField());
			JPanelAL.get(8*i+11).add(CWPumpTextFieldAL.get(i));
			CWPumpTextFieldAL.get(i).setColumns(5);
			CWPumpTextFieldAL.get(i).setVisible(false);
			
			CWPumpsubLabelAL.add(new JLabel("kW"));
			JPanelAL.get(8*i+11).add(CWPumpsubLabelAL.get(i));
			CWPumpsubLabelAL.get(i).setFont(new Font("Consolas", Font.PLAIN, 10));
			CWPumpsubLabelAL.get(i).setVisible(false);
			
		}
		
		ComponentsSetVisibleTrue();
		
	}
	
	void ComponentsSetVisibleTrue(){
		CountLabelAL.get(btnCounter).setVisible(true);
		NameLabelAL.get(btnCounter).setVisible(true);
		NameTextFieldAL.get(btnCounter).setVisible(true);
		TypeLabelAL.get(btnCounter).setVisible(true);
		TypeComboBoxAL.get(btnCounter).setVisible(true);
		CapacityLabelAL.get(btnCounter).setVisible(true);
		CapacityTextFieldAL.get(btnCounter).setVisible(true);
		CapacitysubLabelAL.get(btnCounter).setVisible(true);
		COPLabelAL.get(btnCounter).setVisible(true);
		COPTextFieldAL.get(btnCounter).setVisible(true);
		COPsubLabelAL.get(btnCounter).setVisible(true);
		CHWPumpLabelAL.get(btnCounter).setVisible(true);
		CHWPumpTextFieldAL.get(btnCounter).setVisible(true);
		CHWPumpsubLabelAL.get(btnCounter).setVisible(true);
		CWPumpLabelAL.get(btnCounter).setVisible(true);
		CWPumpTextFieldAL.get(btnCounter).setVisible(true);
		CWPumpsubLabelAL.get(btnCounter).setVisible(true);
	}
	
	void ComponentsSetVisibleFalse(){
		CountLabelAL.get(btnCounter).setVisible(false);
		NameLabelAL.get(btnCounter).setVisible(false);
		NameTextFieldAL.get(btnCounter).setVisible(false);
		TypeLabelAL.get(btnCounter).setVisible(false);
		TypeComboBoxAL.get(btnCounter).setVisible(false);
		CapacityLabelAL.get(btnCounter).setVisible(false);
		CapacityTextFieldAL.get(btnCounter).setVisible(false);
		CapacitysubLabelAL.get(btnCounter).setVisible(false);
		COPLabelAL.get(btnCounter).setVisible(false);
		COPTextFieldAL.get(btnCounter).setVisible(false);
		COPsubLabelAL.get(btnCounter).setVisible(false);
		CHWPumpLabelAL.get(btnCounter).setVisible(false);
		CHWPumpTextFieldAL.get(btnCounter).setVisible(false);
		CHWPumpsubLabelAL.get(btnCounter).setVisible(false);
		CWPumpLabelAL.get(btnCounter).setVisible(false);
		CWPumpTextFieldAL.get(btnCounter).setVisible(false);
		CWPumpsubLabelAL.get(btnCounter).setVisible(false);
	}

}
