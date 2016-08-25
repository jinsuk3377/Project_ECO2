package com.dankook.bsi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dankook.bsi.model.Ui_Model;

public class HvacAutomatic extends JPanel {

	Ui_Model _model;
	
	private JLabel systemLabel;
	private JLabel volumnLabel;
	private JLabel efficiencyLabel;
	private JLabel lightingDensityLabel;
	private JLabel heatingLabel;
	private JLabel heatingPumpLabel;
	private JLabel coolingLabel;
	private JLabel lightingLabel;
	
	private JComboBox heatingSystemComboBox;
	private JComboBox heatingPumpSystemComboBox;
	private JComboBox coolingSystemComboBox;
	private JTextField lightingDensityTextField;
	private JLabel lightingDensityUnitLabel;
	
	private JTextField heatingVolumnTextField;
	private JTextField heatingPumpVolumnTextField;
	private JTextField coolingVolumnTextField;
	private JLabel heatingVolumnUnitLabel;
	private JLabel heatingPumpVolumnUnitLabel;
	private JLabel coolingVolumnUnitLabel;
	
	private JTextField heatingEfficiencyTextField;
	private JTextField heatingPumpEfficiencyTextField;
	private JTextField coolingEfficiencyTextField;
	private JLabel heatingEfficiencyUnitLabel;
	private JLabel heatingPumpEfficiencyUnitLabel;
	private JLabel coolingEfficiencyUnitLabel;
	
	public HvacAutomatic () {
		
		setLayout(null);
		createHVACinfo ();
	}
	
	
	public void createHVACinfo () {
		
		systemLabel = new JLabel("기기방식");
		systemLabel.setBounds(110, 10, 70, 15);
		systemLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(systemLabel);
		
		volumnLabel = new JLabel("용량");
		volumnLabel.setBounds(210, 10, 70, 15);
		volumnLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(volumnLabel);
		
		efficiencyLabel = new JLabel("효율");
		efficiencyLabel.setBounds(310, 10, 70, 15);
		efficiencyLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(efficiencyLabel);
		
		lightingDensityLabel = new JLabel("조명밀도");
		lightingDensityLabel.setBounds(510, 10, 70, 15);
		lightingDensityLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(lightingDensityLabel);
		
		heatingLabel = new JLabel("난방기기");
		heatingLabel.setBounds(20, 35, 70, 15);
		heatingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(heatingLabel);
		
		heatingPumpLabel= new JLabel("급탕기기");
		heatingPumpLabel.setBounds(20, 60, 70, 15);
		heatingPumpLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(heatingPumpLabel);
		
		coolingLabel = new JLabel("냉방기기");
		coolingLabel.setBounds(20, 85, 70, 15);
		coolingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(coolingLabel);
		
		lightingLabel = new JLabel("조명기기");
		lightingLabel.setBounds(420, 35, 70, 15);
		lightingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(lightingLabel);
		
		heatingSystemComboBox = new JComboBox();
		heatingSystemComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "보일러", "지역난방", "EHP" }));
		heatingSystemComboBox.setBounds(103, 34, 75, 18);
		heatingSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		add(heatingSystemComboBox);
		
		heatingPumpSystemComboBox = new JComboBox();
		heatingPumpSystemComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "보일러", "지역난방", "EHP" }));
		heatingPumpSystemComboBox.setBounds(103, 59, 75, 18);
		heatingPumpSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		add(heatingPumpSystemComboBox);
		heatingPumpSystemComboBox.setSelectedIndex(1);
		
		coolingSystemComboBox = new JComboBox();
		coolingSystemComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "압축식", "흡수식", "EHP" }));
		coolingSystemComboBox.setBounds(103, 83, 75, 18);
		coolingSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		add(coolingSystemComboBox);
		coolingSystemComboBox.setSelectedIndex(2);
		
		lightingDensityTextField = new JTextField("15");
		lightingDensityTextField.setBounds(507, 33, 55, 20);
		lightingDensityTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		lightingDensityTextField.setEditable(false);
		add(lightingDensityTextField);
		
		lightingDensityUnitLabel = new JLabel("W/m2");
		lightingDensityUnitLabel.setBounds(566, 37, 60, 15);
		lightingDensityUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(lightingDensityUnitLabel);
		
		heatingVolumnTextField = new JTextField("868.3653");
		heatingVolumnTextField.setBounds(200, 33, 55, 20);
		heatingVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingVolumnTextField.setEditable(false);
		add(heatingVolumnTextField);
		
		heatingPumpVolumnTextField = new JTextField("561.4204");
		heatingPumpVolumnTextField.setBounds(200, 58, 55, 20);
		heatingPumpVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingPumpVolumnTextField.setEditable(false);
		add(heatingPumpVolumnTextField);
		
		coolingVolumnTextField = new JTextField("717.5163");
		coolingVolumnTextField.setBounds(200, 83, 55, 20);
		coolingVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		coolingVolumnTextField.setEditable(false);
		add(coolingVolumnTextField);
		
		heatingVolumnUnitLabel = new JLabel("kW");
		heatingVolumnUnitLabel.setBounds(259, 37, 60, 15);
		heatingVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(heatingVolumnUnitLabel);
		
		heatingPumpVolumnUnitLabel = new JLabel("kW");
		heatingPumpVolumnUnitLabel.setBounds(259, 62, 60, 15);
		heatingPumpVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(heatingPumpVolumnUnitLabel);
		
		coolingVolumnUnitLabel = new JLabel("kW");
		coolingVolumnUnitLabel.setBounds(259, 87, 60, 15);
		coolingVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(coolingVolumnUnitLabel);
		
		heatingEfficiencyTextField = new JTextField("100");
		heatingEfficiencyTextField.setBounds(305, 33, 30, 20);
		heatingEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingEfficiencyTextField.setEditable(false);
		add(heatingEfficiencyTextField);
		
		heatingPumpEfficiencyTextField = new JTextField("88");
		heatingPumpEfficiencyTextField.setBounds(305, 58, 30, 20);
		heatingPumpEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingPumpEfficiencyTextField.setEditable(false);
		add(heatingPumpEfficiencyTextField);
		
		coolingEfficiencyTextField = new JTextField("3.78");
		coolingEfficiencyTextField.setBounds(305, 83, 45, 20);
		coolingEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		coolingEfficiencyTextField.setEditable(false);
		add(coolingEfficiencyTextField);
		
		heatingEfficiencyUnitLabel = new JLabel("%");
		heatingEfficiencyUnitLabel.setBounds(339, 36, 60, 15);
		heatingEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(heatingEfficiencyUnitLabel);
		
		heatingPumpEfficiencyUnitLabel = new JLabel("%");
		heatingPumpEfficiencyUnitLabel.setBounds(339, 61, 60, 15);
		heatingPumpEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(heatingPumpEfficiencyUnitLabel);
		
		coolingEfficiencyUnitLabel = new JLabel("COP");
		coolingEfficiencyUnitLabel.setBounds(354, 86, 70, 15);
		coolingEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(coolingEfficiencyUnitLabel);
		
	}
}
