package com.dankook.bsi.views;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dankook.bsi.exception.GBXmlValidationError;
import com.dankook.bsi.model.*;

public class InfoGbXml_Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Ui_Model _model;
	
	String gbxmlFilePath;

	//건축물 기본정보
	private JLabel basicLabel;
	private JLabel buildingNameLabel;
	private JTextField buildingNameTextField; 
	private JLabel buildingAddrLabel;
	private JTextField buildingAddrTextField; 
	private JLabel GFALabel; //연면적
	private JTextField GFATextField; 
	private JLabel floorLabel;
	private JTextField floorTextField;
	
	//건축물 상세정보
	private JLabel detailLabel;
	private JLabel buildingLabel;
	private JLabel mainPointLabel;
	private JTextField mainPointTextField;
	
	private JLabel southLabel;
	private JLabel westLabel;
	private JLabel northLabel;
	private JLabel eastLabel;
	private JLabel exteriorAreaLabel;
	private JTextField exteriorAreaSouthTextField;
	private JTextField exteriorAreaWestTextField;
	private JTextField exteriorAreaNorthTextField;
	private JTextField exteriorAreaEastTextField;
	private JLabel exteriorAreaSouthUnitLabel;
	private JLabel exteriorAreaWestUnitLabel;
	private JLabel exteriorAreaNorthUnitLabel;
	private JLabel exteriorAreaEastUnitLabel;
	
	private JLabel windowAreaLabel;
	private JTextField windowAreaSouthTextField;
	private JTextField windowAreaWestTextField;
	private JTextField windowAreaNorthTextField;
	private JTextField windowAreaEastTextField;
	private JLabel windowAreaSouthUnitLabel;
	private JLabel windowAreaWestUnitLabel;
	private JLabel windowAreaNorthUnitLabel;
	private JLabel windowAreaEastUnitLabel;
	private JLabel exteriorWallAreaLabel;
	private JTextField exteriorWallAreaSouthTextField;
	private JTextField exteriorWallAreaWestTextField;
	private JTextField exteriorWallAreaNorthTextField;
	private JTextField exteriorWallAreaEastTextField;
	private JLabel exteriorWallAreaSouthUnitLabel;
	private JLabel exteriorWallAreaWestUnitLabel;
	private JLabel exteriorWallAreaNorthUnitLabel;
	private JLabel exteriorWallAreaEastUnitLabel;
	
	private JLabel exteriorWallUValueLabel;
	private JLabel roofUValueLabel;
	private JLabel floorUValueLabel;
	private JLabel windowUValueLabel;
	private JLabel windowSHGCUValueLabel;
	private JTextField exteriorWallUValueTextField;
	private JTextField roofUValueTextField;
	private JTextField floorUValueTextField;
	private JTextField windowUValueTextField;
	private JTextField windowSHGCUValueTextField;
	private JLabel exteriorWallUValueUnitLabel;
	private JLabel roofUValueUnitLabel;
	private JLabel floorUValueUnitLabel;
	private JLabel windowUValueUnitLabel;
	
	private JLabel HVACLabel;
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
	
	private JLabel renewableEnergyLabel;
	private JLabel solarThermalLabel;
	private JLabel photovoltaicLabel;
	private JLabel geothlermaHeatPumpLabel;
	private JLabel areaLabel;
	private JLabel volumn2Label;
	private JTextField solarThermalAreaTextField;
	private JTextField photovoltaicAreaTextField;
	private JTextField geothlermaHeatPumpVolumnTextField;
	private JLabel solarThermalAreaUnitLabel;
	private JLabel photovoltaicAreaUnitLabel;
	private JLabel geothlermaHeatPumpVolumnUnitLabel;
	private JLabel efficiency2Label;
	private JTextField geothlermaHeatPumpEfficiencyTextField;
	private JLabel geothlermaHeatPumpEfficiencyUnitLabel;
	
	public InfoGbXml_Panel() {
		setLayout(null);
		setBounds(10, 10, 770, 450);

		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BIM Information", 4, 2, null,
				new Color(0, 0, 255)));
		
		createBasicInfo();
		createDetailAreaInfo();
		createDetailUValueInfo();
		createDetailHVACInfo();
		createDetailRenewableEnergyInfo();
		
	}
	
	private void createBasicInfo() {
		
		
		
		basicLabel = new JLabel("건축물 기본정보");
		basicLabel.setBounds(15, 25, 150, 15);
		basicLabel.setFont(new Font("바탕", Font.PLAIN, 13));
		basicLabel.setForeground(Color.BLUE);
		add(basicLabel);
		
		buildingNameLabel = new JLabel("건물명");
		buildingNameLabel.setBounds(20, 50, 50, 15);
		buildingNameLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(buildingNameLabel);
		
		buildingNameTextField = new JTextField("한국건설기술연구원");
		buildingNameTextField.setBounds(80, 48, 120, 20);
		buildingNameTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		buildingNameTextField.setEditable(false);
		add(buildingNameTextField);
		
		buildingAddrLabel = new JLabel("주소");
		buildingAddrLabel.setBounds(330, 50, 50, 15);
		buildingAddrLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(buildingAddrLabel);
		
		buildingAddrTextField = new JTextField("경기도 고양시 일산서구");
		buildingAddrTextField.setBounds(390, 48, 150, 20);
		buildingAddrTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		buildingAddrTextField.setEditable(false);
		add(buildingAddrTextField);
		
		GFALabel = new JLabel("연면적");
		GFALabel.setBounds(20, 75, 50, 15);
		GFALabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(GFALabel);
		
		GFATextField = new JTextField("13117.3");
		GFATextField.setBounds(80, 73, 60, 20);
		GFATextField.setFont(new Font("바탕", Font.PLAIN, 12));
		GFATextField.setEditable(false);
		add(GFATextField);
		
		floorLabel = new JLabel("층수");
		floorLabel.setBounds(330, 75, 50, 15);
		floorLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(floorLabel);
		
		floorTextField = new JTextField("5");
		floorTextField.setBounds(390, 73, 40, 20);
		floorTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		floorTextField.setEditable(false);
		add(floorTextField);
		
	}
	
	private void createDetailAreaInfo() {
		
		detailLabel = new JLabel("건축물 상세정보");
		detailLabel.setBounds(15, 115, 150, 15);
		detailLabel.setFont(new Font("바탕", Font.PLAIN, 13));
		detailLabel.setForeground(Color.BLUE);
		add(detailLabel);
		
		buildingLabel = new JLabel("<건축>");
		buildingLabel.setBounds(595, 113, 70, 15);
		buildingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		buildingLabel.setForeground(Color.BLUE);
		add(buildingLabel);
		
		mainPointLabel = new JLabel("주 방위");
		mainPointLabel.setBounds(160, 117, 70, 15);
		mainPointLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(mainPointLabel);
		
		mainPointTextField = new JTextField("남");
		mainPointTextField.setBounds(210, 115, 20, 18);
		mainPointTextField.setFont(new Font("바탕", Font.PLAIN, 11));
		mainPointTextField.setEditable(false);
		add(mainPointTextField);
		
		southLabel = new JLabel("남");
		southLabel.setBounds(20, 165, 50, 15);
		southLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(southLabel);
		
		westLabel = new JLabel("서");
		westLabel.setBounds(20, 190, 50, 15);
		westLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(westLabel);
		
		northLabel = new JLabel("북");
		northLabel.setBounds(20, 215, 50, 15);
		northLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(northLabel);
		
		eastLabel = new JLabel("동");
		eastLabel.setBounds(20, 240, 50, 15);
		eastLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(eastLabel);
		
		exteriorAreaLabel = new JLabel("외피면적");
		exteriorAreaLabel.setBounds(72, 140, 50, 15);
		exteriorAreaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(exteriorAreaLabel);
		
		exteriorAreaSouthTextField = new JTextField("1772.133");
		exteriorAreaSouthTextField.setBounds(65, 163, 55, 20);
		exteriorAreaSouthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaSouthTextField.setEditable(false);
		add(exteriorAreaSouthTextField);
		
		exteriorAreaWestTextField = new JTextField("866.0667");
		exteriorAreaWestTextField.setBounds(65, 188, 55, 20);
		exteriorAreaWestTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaWestTextField.setEditable(false);
		add(exteriorAreaWestTextField);
		
		exteriorAreaNorthTextField = new JTextField("1772.133");
		exteriorAreaNorthTextField.setBounds(65, 213, 55, 20);
		exteriorAreaNorthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaNorthTextField.setEditable(false);
		add(exteriorAreaNorthTextField);
		
		exteriorAreaEastTextField = new JTextField("866.0667");
		exteriorAreaEastTextField.setBounds(65, 238, 55, 20);
		exteriorAreaEastTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaEastTextField.setEditable(false);
		add(exteriorAreaEastTextField);
		
		exteriorAreaSouthUnitLabel = new JLabel("m2");
		exteriorAreaSouthUnitLabel.setBounds(124, 166, 20, 15);
		exteriorAreaSouthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaSouthUnitLabel);
		
		exteriorAreaWestUnitLabel = new JLabel("m2");
		exteriorAreaWestUnitLabel.setBounds(124, 191, 20, 15);
		exteriorAreaWestUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaWestUnitLabel);
		
		exteriorAreaNorthUnitLabel = new JLabel("m2");
		exteriorAreaNorthUnitLabel.setBounds(124, 216, 20, 15);
		exteriorAreaNorthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaNorthUnitLabel);
		
		exteriorAreaEastUnitLabel = new JLabel("m2");
		exteriorAreaEastUnitLabel.setBounds(124, 241, 20, 15);
		exteriorAreaEastUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaEastUnitLabel);
		
		windowAreaLabel = new JLabel("창면적");
		windowAreaLabel.setBounds(172, 140, 50, 15);
		windowAreaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(windowAreaLabel);
		
		windowAreaSouthTextField = new JTextField("886.0666");
		windowAreaSouthTextField.setBounds(165, 163, 55, 20);
		windowAreaSouthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaSouthTextField.setEditable(false);
		add(windowAreaSouthTextField);
		
		windowAreaWestTextField = new JTextField("531.6399");
		windowAreaWestTextField.setBounds(165, 188, 55, 20);
		windowAreaWestTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaWestTextField.setEditable(false);
		add(windowAreaWestTextField);
		
		windowAreaNorthTextField = new JTextField("1063.279");
		windowAreaNorthTextField.setBounds(165, 213, 55, 20);
		windowAreaNorthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaNorthTextField.setEditable(false);
		add(windowAreaNorthTextField);
		
		windowAreaEastTextField = new JTextField("531.6399");
		windowAreaEastTextField.setBounds(165, 238, 55, 20);
		windowAreaEastTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaEastTextField.setEditable(false);
		add(windowAreaEastTextField);
		
		windowAreaSouthUnitLabel = new JLabel("m2");
		windowAreaSouthUnitLabel.setBounds(224, 166, 20, 15);
		windowAreaSouthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaSouthUnitLabel);
		
		windowAreaWestUnitLabel = new JLabel("m2");
		windowAreaWestUnitLabel.setBounds(224, 191, 20, 15);
		windowAreaWestUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaWestUnitLabel);
		
		windowAreaNorthUnitLabel = new JLabel("m2");
		windowAreaNorthUnitLabel.setBounds(224, 216, 20, 15);
		windowAreaNorthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaNorthUnitLabel);
		
		windowAreaEastUnitLabel = new JLabel("m2");
		windowAreaEastUnitLabel.setBounds(224, 241, 20, 15);
		windowAreaEastUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaEastUnitLabel);
		
		exteriorWallAreaLabel = new JLabel("벽체면적");
		exteriorWallAreaLabel.setBounds(272, 140, 50, 15);
		exteriorWallAreaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(exteriorWallAreaLabel);
		
		exteriorWallAreaSouthTextField = new JTextField("886.0666");
		exteriorWallAreaSouthTextField.setBounds(265, 163, 55, 20);
		exteriorWallAreaSouthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaSouthTextField.setEditable(false);
		add(exteriorWallAreaSouthTextField);
		
		exteriorWallAreaWestTextField = new JTextField("354.4267");
		exteriorWallAreaWestTextField.setBounds(265, 188, 55, 20);
		exteriorWallAreaWestTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaWestTextField.setEditable(false);
		add(exteriorWallAreaWestTextField);
		
		exteriorWallAreaNorthTextField = new JTextField("708.8533");
		exteriorWallAreaNorthTextField.setBounds(265, 213, 55, 20);
		exteriorWallAreaNorthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaNorthTextField.setEditable(false);
		add(exteriorWallAreaNorthTextField);
		
		exteriorWallAreaEastTextField = new JTextField("354.4267");
		exteriorWallAreaEastTextField.setBounds(265, 238, 55, 20);
		exteriorWallAreaEastTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaEastTextField.setEditable(false);
		add(exteriorWallAreaEastTextField);
		
		exteriorWallAreaSouthUnitLabel = new JLabel("m2");
		exteriorWallAreaSouthUnitLabel.setBounds(324, 166, 20, 15);
		exteriorWallAreaSouthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaSouthUnitLabel);
		
		exteriorWallAreaWestUnitLabel = new JLabel("m2");
		exteriorWallAreaWestUnitLabel.setBounds(324, 191, 20, 15);
		exteriorWallAreaWestUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaWestUnitLabel);
		
		exteriorWallAreaNorthUnitLabel = new JLabel("m2");
		exteriorWallAreaNorthUnitLabel.setBounds(324, 216, 20, 15);
		exteriorWallAreaNorthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaNorthUnitLabel);
		
		exteriorWallAreaEastUnitLabel = new JLabel("m2");
		exteriorWallAreaEastUnitLabel.setBounds(324, 241, 20, 15);
		exteriorWallAreaEastUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaEastUnitLabel);
		
	}
	
	private void createDetailUValueInfo() {
		
		exteriorWallUValueLabel = new JLabel("외벽 열관류율");
		exteriorWallUValueLabel.setBounds(402, 140, 100, 15);
		exteriorWallUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(exteriorWallUValueLabel);
		
		roofUValueLabel = new JLabel("지붕 열관류율");
		roofUValueLabel.setBounds(402, 165, 100, 15);
		roofUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(roofUValueLabel);
		
		floorUValueLabel = new JLabel("바닥 열관류율");
		floorUValueLabel.setBounds(402, 190, 100, 15);
		floorUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(floorUValueLabel);
		
		windowUValueLabel = new JLabel("창호 열관류율");
		windowUValueLabel.setBounds(402, 215, 100, 15);
		windowUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(windowUValueLabel);
		
		windowSHGCUValueLabel = new JLabel("창호 SHGC");
		windowSHGCUValueLabel.setBounds(402, 240, 100, 15);
		windowSHGCUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(windowSHGCUValueLabel);
		
		exteriorWallUValueTextField = new JTextField("0.47");
		exteriorWallUValueTextField.setBounds(502, 138, 40, 20);
		exteriorWallUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallUValueTextField.setEditable(false);
		add(exteriorWallUValueTextField);
		
		roofUValueTextField = new JTextField("0.29");
		roofUValueTextField.setBounds(502, 163, 40, 20);
		roofUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		roofUValueTextField.setEditable(false);
		add(roofUValueTextField);
		
		floorUValueTextField = new JTextField("0.41");
		floorUValueTextField.setBounds(502, 188, 40, 20);
		floorUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		floorUValueTextField.setEditable(false);
		add(floorUValueTextField);
		
		windowUValueTextField = new JTextField("3.4");
		windowUValueTextField.setBounds(502, 213, 40, 20);
		windowUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowUValueTextField.setEditable(false);
		add(windowUValueTextField);
		
		windowSHGCUValueTextField = new JTextField("0.56");
		windowSHGCUValueTextField.setBounds(502, 238, 40, 20);
		windowSHGCUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowSHGCUValueTextField.setEditable(false);
		add(windowSHGCUValueTextField);
		
		exteriorWallUValueUnitLabel = new JLabel("W/m2K");
		exteriorWallUValueUnitLabel.setBounds(547, 142, 100, 15);
		exteriorWallUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallUValueUnitLabel);
		
		roofUValueUnitLabel = new JLabel("W/m2K");
		roofUValueUnitLabel.setBounds(547, 167, 100, 15);
		roofUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(roofUValueUnitLabel);
		
		floorUValueUnitLabel = new JLabel("W/m2K");
		floorUValueUnitLabel.setBounds(547, 192, 100, 15);
		floorUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(floorUValueUnitLabel);
		
		windowUValueUnitLabel = new JLabel("W/m2K");
		windowUValueUnitLabel.setBounds(547, 217, 100, 15);
		windowUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowUValueUnitLabel);
		
	}
	
	private void createDetailHVACInfo() {
		
		HVACLabel = new JLabel("<설비>");
		HVACLabel.setBounds(595, 257, 70, 15);
		HVACLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		HVACLabel.setForeground(Color.BLUE);
		add(HVACLabel);
		
		systemLabel = new JLabel("기기방식");
		systemLabel.setBounds(110, 280, 70, 15);
		systemLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(systemLabel);
		
		volumnLabel = new JLabel("용량");
		volumnLabel.setBounds(210, 280, 70, 15);
		volumnLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(volumnLabel);
		
		efficiencyLabel = new JLabel("효율");
		efficiencyLabel.setBounds(310, 280, 70, 15);
		efficiencyLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(efficiencyLabel);
		
		lightingDensityLabel = new JLabel("조명밀도");
		lightingDensityLabel.setBounds(510, 280, 70, 15);
		lightingDensityLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(lightingDensityLabel);
		
		heatingLabel = new JLabel("난방기기");
		heatingLabel.setBounds(20, 305, 70, 15);
		heatingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(heatingLabel);
		
		heatingPumpLabel= new JLabel("급탕기기");
		heatingPumpLabel.setBounds(20, 330, 70, 15);
		heatingPumpLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(heatingPumpLabel);
		
		coolingLabel = new JLabel("냉방기기");
		coolingLabel.setBounds(20, 355, 70, 15);
		coolingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(coolingLabel);
		
		lightingLabel = new JLabel("조명기기");
		lightingLabel.setBounds(420, 305, 70, 15);
		lightingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(lightingLabel);
		
		heatingSystemComboBox = new JComboBox();
		heatingSystemComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "보일러", "지역난방", "EHP" }));
		heatingSystemComboBox.setBounds(103, 304, 75, 18);
		heatingSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		add(heatingSystemComboBox);
		
		heatingPumpSystemComboBox = new JComboBox();
		heatingPumpSystemComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "보일러", "지역난방", "EHP" }));
		heatingPumpSystemComboBox.setBounds(103, 329, 75, 18);
		heatingPumpSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		add(heatingPumpSystemComboBox);
		heatingPumpSystemComboBox.setSelectedIndex(1);
		
		coolingSystemComboBox = new JComboBox();
		coolingSystemComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "압축식", "흡수식", "EHP" }));
		coolingSystemComboBox.setBounds(103, 354, 75, 18);
		coolingSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		add(coolingSystemComboBox);
		coolingSystemComboBox.setSelectedIndex(2);
		
		lightingDensityTextField = new JTextField("15");
		lightingDensityTextField.setBounds(507, 303, 55, 20);
		lightingDensityTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		lightingDensityTextField.setEditable(false);
		add(lightingDensityTextField);
		
		lightingDensityUnitLabel = new JLabel("W/m2");
		lightingDensityUnitLabel.setBounds(566, 307, 60, 15);
		lightingDensityUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(lightingDensityUnitLabel);
		
		heatingVolumnTextField = new JTextField("868.3653");
		heatingVolumnTextField.setBounds(200, 303, 55, 20);
		heatingVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingVolumnTextField.setEditable(false);
		add(heatingVolumnTextField);
		
		heatingPumpVolumnTextField = new JTextField("561.4204");
		heatingPumpVolumnTextField.setBounds(200, 328, 55, 20);
		heatingPumpVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingPumpVolumnTextField.setEditable(false);
		add(heatingPumpVolumnTextField);
		
		coolingVolumnTextField = new JTextField("717.5163");
		coolingVolumnTextField.setBounds(200, 353, 55, 20);
		coolingVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		coolingVolumnTextField.setEditable(false);
		add(coolingVolumnTextField);
		
		heatingVolumnUnitLabel = new JLabel("kW");
		heatingVolumnUnitLabel.setBounds(259, 307, 60, 15);
		heatingVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(heatingVolumnUnitLabel);
		
		heatingPumpVolumnUnitLabel = new JLabel("kW");
		heatingPumpVolumnUnitLabel.setBounds(259, 332, 60, 15);
		heatingPumpVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(heatingPumpVolumnUnitLabel);
		
		coolingVolumnUnitLabel = new JLabel("kW");
		coolingVolumnUnitLabel.setBounds(259, 357, 60, 15);
		coolingVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(coolingVolumnUnitLabel);
		
		heatingEfficiencyTextField = new JTextField("100");
		heatingEfficiencyTextField.setBounds(305, 303, 30, 20);
		heatingEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingEfficiencyTextField.setEditable(false);
		add(heatingEfficiencyTextField);
		
		heatingPumpEfficiencyTextField = new JTextField("88");
		heatingPumpEfficiencyTextField.setBounds(305, 328, 30, 20);
		heatingPumpEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingPumpEfficiencyTextField.setEditable(false);
		add(heatingPumpEfficiencyTextField);
		
		coolingEfficiencyTextField = new JTextField("3.78");
		coolingEfficiencyTextField.setBounds(305, 353, 45, 20);
		coolingEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		coolingEfficiencyTextField.setEditable(false);
		add(coolingEfficiencyTextField);
		
		heatingEfficiencyUnitLabel = new JLabel("%");
		heatingEfficiencyUnitLabel.setBounds(339, 306, 60, 15);
		heatingEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(heatingEfficiencyUnitLabel);
		
		heatingPumpEfficiencyUnitLabel = new JLabel("%");
		heatingPumpEfficiencyUnitLabel.setBounds(339, 331, 60, 15);
		heatingPumpEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(heatingPumpEfficiencyUnitLabel);
		
		coolingEfficiencyUnitLabel = new JLabel("COP");
		coolingEfficiencyUnitLabel.setBounds(354, 356, 70, 15);
		coolingEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(coolingEfficiencyUnitLabel);
		
		/*
		 * 
		
		private JLabel heatingEfficiencyUnitLabel;
		private JLabel heatingPumpEfficiencyUnitLabel;
		private JLabel coolingEfficiencyUnitLabel;
		 */
	}
	
	private void createDetailRenewableEnergyInfo() {
		
		renewableEnergyLabel = new JLabel("<신재생>");
		renewableEnergyLabel.setBounds(583, 373, 70, 15);
		renewableEnergyLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		renewableEnergyLabel.setForeground(Color.BLUE);
		add(renewableEnergyLabel);

		areaLabel = new JLabel("면적");
		areaLabel.setBounds(100, 396, 70, 15);
		areaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(areaLabel);
		
		volumn2Label = new JLabel("용량");
		volumn2Label.setBounds(370, 396, 70, 15);
		volumn2Label.setFont(new Font("바탕", Font.PLAIN, 12));
		add(volumn2Label);
		
		efficiency2Label = new JLabel("효율");
		efficiency2Label.setBounds(470, 396, 70, 15);
		efficiency2Label.setFont(new Font("바탕", Font.PLAIN, 12));
		add(efficiency2Label);
		
		solarThermalLabel = new JLabel("태양열");
		solarThermalLabel.setBounds(20, 421, 70, 15);
		solarThermalLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(solarThermalLabel);
		
		photovoltaicLabel= new JLabel("태양광");
		photovoltaicLabel.setBounds(20, 446, 70, 15);
		photovoltaicLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(photovoltaicLabel);
		
		solarThermalAreaTextField = new JTextField("");
		solarThermalAreaTextField.setBounds(93, 421, 55, 20);
		solarThermalAreaTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		add(solarThermalAreaTextField);
		
		photovoltaicAreaTextField = new JTextField("");
		photovoltaicAreaTextField.setBounds(93, 446, 55, 20);
		photovoltaicAreaTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		add(photovoltaicAreaTextField);
		
		solarThermalAreaUnitLabel = new JLabel("m2");
		solarThermalAreaUnitLabel.setBounds(152, 421, 60, 15);
		solarThermalAreaUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(solarThermalAreaUnitLabel);
		
		photovoltaicAreaUnitLabel = new JLabel("m2");
		photovoltaicAreaUnitLabel.setBounds(152, 446, 60, 15);
		photovoltaicAreaUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(photovoltaicAreaUnitLabel);
		
		geothlermaHeatPumpLabel = new JLabel("지열히트펌프");
		geothlermaHeatPumpLabel.setBounds(260, 421, 90, 15);
		geothlermaHeatPumpLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(geothlermaHeatPumpLabel);
		
		geothlermaHeatPumpVolumnTextField = new JTextField("");
		geothlermaHeatPumpVolumnTextField.setBounds(363, 421, 55, 20);
		geothlermaHeatPumpVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		add(geothlermaHeatPumpVolumnTextField);
		
		geothlermaHeatPumpVolumnUnitLabel = new JLabel("kW");
		geothlermaHeatPumpVolumnUnitLabel.setBounds(422, 421, 60, 15);
		geothlermaHeatPumpVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(geothlermaHeatPumpVolumnUnitLabel);
		
		geothlermaHeatPumpEfficiencyTextField = new JTextField("");
		geothlermaHeatPumpEfficiencyTextField.setBounds(463, 421, 45, 20);
		geothlermaHeatPumpEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		add(geothlermaHeatPumpEfficiencyTextField);
		
		geothlermaHeatPumpEfficiencyUnitLabel = new JLabel("COP");
		geothlermaHeatPumpEfficiencyUnitLabel.setBounds(514, 421, 70, 15);
		geothlermaHeatPumpEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(geothlermaHeatPumpEfficiencyUnitLabel);
	
	}
	
	public void updateInfo() {
		
	}

	public void setModel(Ui_Model model) {
		this._model = model;
	}

	public String getGbxmlFilePath() {
		return gbxmlFilePath;
	}

	public void update(Object eventDispatcher) {
		updateInfo();
	}
}