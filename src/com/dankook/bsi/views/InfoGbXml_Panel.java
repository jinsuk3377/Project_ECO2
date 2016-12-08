package com.dankook.bsi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dankook.bsi.exception.GBXmlValidationError;
import com.dankook.bsi.model.*;
import com.dankook.bsi.util.Ui_Observer;

public class InfoGbXml_Panel extends JPanel implements Ui_Observer, ActionListener {
	private static final long serialVersionUID = 1L;

	private Ui_Model _model;

	private String gbxmlFilePath;

	// 건축물 기본정보
	private JLabel basicLabel;
	private JLabel buildingNameLabel;
	private JTextField buildingNameTextField;
	private JLabel buildingAddrLabel;
	private JTextField buildingAddrTextField;
	private JLabel GFALabel; // 연면적
	private JTextField GFATextField;
	private JLabel floorLabel;
	private JTextField floorTextField;

	// 건축물 상세정보
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

	// 전기설비정보
	private JLabel equipmentLabel;
	private JLabel HVACLabel;
	private ButtonGroup RadioGroup;
	private JRadioButton HVACRadioButton1;
	private JRadioButton HVACRadioButton2;

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
	
	private boolean isPressRadioButton2 = false;

	/*
	 * private JLabel renewableEnergyLabel; private JLabel solarThermalLabel;
	 * private JLabel photovoltaicLabel; private JLabel geothlermaHeatPumpLabel;
	 * private JLabel areaLabel; private JLabel volumn2Label; private JTextField
	 * solarThermalAreaTextField; private JTextField photovoltaicAreaTextField;
	 * private JTextField geothlermaHeatPumpVolumnTextField; private JLabel
	 * solarThermalAreaUnitLabel; private JLabel photovoltaicAreaUnitLabel;
	 * private JLabel geothlermaHeatPumpVolumnUnitLabel; private JLabel
	 * efficiency2Label; private JTextField
	 * geothlermaHeatPumpEfficiencyTextField; private JLabel
	 * geothlermaHeatPumpEfficiencyUnitLabel;
	 */

	public InfoGbXml_Panel(Ui_Model model) {
		_model = model;
		this._model.addObserver(this);

		setLayout(null);
		setBounds(10, 10, 770, 410);

		createBasicInfo();
		createDetailAreaInfo();
		createDetailUValueInfo();
		createDetailHVACInfo();
		// createDetailRenewableEnergyInfo();
	}

	private void createBasicInfo() {

		basicLabel = new JLabel("건축물 기본정보");
		basicLabel.setBounds(5, 10, 150, 15);
		basicLabel.setFont(new Font("바탕", Font.PLAIN, 13));
		basicLabel.setForeground(Color.BLUE);
		add(basicLabel);

		buildingNameLabel = new JLabel("건물명");
		buildingNameLabel.setBounds(10, 35, 50, 15);
		buildingNameLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(buildingNameLabel);

		buildingNameTextField = new JTextField("");
		buildingNameTextField.setBounds(70, 33, 120, 20);
		buildingNameTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		buildingNameTextField.setEditable(false);
		add(buildingNameTextField);

		buildingAddrLabel = new JLabel("주소");
		buildingAddrLabel.setBounds(320, 35, 50, 15);
		buildingAddrLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(buildingAddrLabel);

		buildingAddrTextField = new JTextField("");
		buildingAddrTextField.setBounds(380, 33, 150, 20);
		buildingAddrTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		buildingAddrTextField.setEditable(false);
		add(buildingAddrTextField);

		GFALabel = new JLabel("연면적");
		GFALabel.setBounds(10, 60, 50, 15);
		GFALabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(GFALabel);

		GFATextField = new JTextField("");
		GFATextField.setBounds(70, 58, 60, 20);
		GFATextField.setFont(new Font("바탕", Font.PLAIN, 12));
		GFATextField.setEditable(false);
		add(GFATextField);

		floorLabel = new JLabel("층수");
		floorLabel.setBounds(320, 60, 50, 15);
		floorLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(floorLabel);

		floorTextField = new JTextField("");
		floorTextField.setBounds(380, 58, 40, 20);
		floorTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		floorTextField.setEditable(false);
		add(floorTextField);

	}

	private void createDetailAreaInfo() {

		detailLabel = new JLabel("건축물 상세정보");
		detailLabel.setBounds(5, 95, 150, 15);
		detailLabel.setFont(new Font("바탕", Font.PLAIN, 13));
		detailLabel.setForeground(Color.BLUE);
		add(detailLabel);

		buildingLabel = new JLabel("<건축>");
		buildingLabel.setBounds(585, 93, 70, 15);
		buildingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		buildingLabel.setForeground(Color.BLUE);
		add(buildingLabel);

		mainPointLabel = new JLabel("주 방위");
		mainPointLabel.setBounds(150, 97, 70, 15);
		mainPointLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(mainPointLabel);

		mainPointTextField = new JTextField("남");
		mainPointTextField.setBounds(200, 95, 20, 18);
		mainPointTextField.setFont(new Font("바탕", Font.PLAIN, 11));
		mainPointTextField.setEditable(false);
		add(mainPointTextField);

		southLabel = new JLabel("남");
		southLabel.setBounds(10, 145, 50, 15);
		southLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(southLabel);

		westLabel = new JLabel("서");
		westLabel.setBounds(10, 170, 50, 15);
		westLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(westLabel);

		northLabel = new JLabel("북");
		northLabel.setBounds(10, 195, 50, 15);
		northLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(northLabel);

		eastLabel = new JLabel("동");
		eastLabel.setBounds(10, 220, 50, 15);
		eastLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(eastLabel);

		exteriorAreaLabel = new JLabel("외피면적");
		exteriorAreaLabel.setBounds(62, 120, 50, 15);
		exteriorAreaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(exteriorAreaLabel);

		exteriorAreaSouthTextField = new JTextField("");
		exteriorAreaSouthTextField.setBounds(55, 143, 55, 20);
		exteriorAreaSouthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaSouthTextField.setEditable(false);
		add(exteriorAreaSouthTextField);

		exteriorAreaWestTextField = new JTextField("");
		exteriorAreaWestTextField.setBounds(55, 168, 55, 20);
		exteriorAreaWestTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaWestTextField.setEditable(false);
		add(exteriorAreaWestTextField);

		exteriorAreaNorthTextField = new JTextField("");
		exteriorAreaNorthTextField.setBounds(55, 193, 55, 20);
		exteriorAreaNorthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaNorthTextField.setEditable(false);
		add(exteriorAreaNorthTextField);

		exteriorAreaEastTextField = new JTextField("");
		exteriorAreaEastTextField.setBounds(55, 218, 55, 20);
		exteriorAreaEastTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorAreaEastTextField.setEditable(false);
		add(exteriorAreaEastTextField);

		exteriorAreaSouthUnitLabel = new JLabel("m2");
		exteriorAreaSouthUnitLabel.setBounds(114, 146, 20, 15);
		exteriorAreaSouthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaSouthUnitLabel);

		exteriorAreaWestUnitLabel = new JLabel("m2");
		exteriorAreaWestUnitLabel.setBounds(114, 171, 20, 15);
		exteriorAreaWestUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaWestUnitLabel);

		exteriorAreaNorthUnitLabel = new JLabel("m2");
		exteriorAreaNorthUnitLabel.setBounds(114, 196, 20, 15);
		exteriorAreaNorthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaNorthUnitLabel);

		exteriorAreaEastUnitLabel = new JLabel("m2");
		exteriorAreaEastUnitLabel.setBounds(114, 221, 20, 15);
		exteriorAreaEastUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorAreaEastUnitLabel);

		windowAreaLabel = new JLabel("창면적");
		windowAreaLabel.setBounds(162, 120, 50, 15);
		windowAreaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(windowAreaLabel);

		windowAreaSouthTextField = new JTextField("");
		windowAreaSouthTextField.setBounds(155, 143, 55, 20);
		windowAreaSouthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaSouthTextField.setEditable(false);
		add(windowAreaSouthTextField);

		windowAreaWestTextField = new JTextField("");
		windowAreaWestTextField.setBounds(155, 168, 55, 20);
		windowAreaWestTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaWestTextField.setEditable(false);
		add(windowAreaWestTextField);

		windowAreaNorthTextField = new JTextField("");
		windowAreaNorthTextField.setBounds(155, 193, 55, 20);
		windowAreaNorthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaNorthTextField.setEditable(false);
		add(windowAreaNorthTextField);

		windowAreaEastTextField = new JTextField("");
		windowAreaEastTextField.setBounds(155, 218, 55, 20);
		windowAreaEastTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowAreaEastTextField.setEditable(false);
		add(windowAreaEastTextField);

		windowAreaSouthUnitLabel = new JLabel("m2");
		windowAreaSouthUnitLabel.setBounds(214, 146, 20, 15);
		windowAreaSouthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaSouthUnitLabel);

		windowAreaWestUnitLabel = new JLabel("m2");
		windowAreaWestUnitLabel.setBounds(214, 171, 20, 15);
		windowAreaWestUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaWestUnitLabel);

		windowAreaNorthUnitLabel = new JLabel("m2");
		windowAreaNorthUnitLabel.setBounds(214, 196, 20, 15);
		windowAreaNorthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaNorthUnitLabel);

		windowAreaEastUnitLabel = new JLabel("m2");
		windowAreaEastUnitLabel.setBounds(214, 221, 20, 15);
		windowAreaEastUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowAreaEastUnitLabel);

		exteriorWallAreaLabel = new JLabel("벽체면적");
		exteriorWallAreaLabel.setBounds(262, 120, 50, 15);
		exteriorWallAreaLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(exteriorWallAreaLabel);

		exteriorWallAreaSouthTextField = new JTextField("");
		exteriorWallAreaSouthTextField.setBounds(255, 143, 55, 20);
		exteriorWallAreaSouthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaSouthTextField.setEditable(false);
		add(exteriorWallAreaSouthTextField);

		exteriorWallAreaWestTextField = new JTextField("");
		exteriorWallAreaWestTextField.setBounds(255, 168, 55, 20);
		exteriorWallAreaWestTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaWestTextField.setEditable(false);
		add(exteriorWallAreaWestTextField);

		exteriorWallAreaNorthTextField = new JTextField("");
		exteriorWallAreaNorthTextField.setBounds(255, 193, 55, 20);
		exteriorWallAreaNorthTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaNorthTextField.setEditable(false);
		add(exteriorWallAreaNorthTextField);

		exteriorWallAreaEastTextField = new JTextField("");
		exteriorWallAreaEastTextField.setBounds(255, 218, 55, 20);
		exteriorWallAreaEastTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallAreaEastTextField.setEditable(false);
		add(exteriorWallAreaEastTextField);

		exteriorWallAreaSouthUnitLabel = new JLabel("m2");
		exteriorWallAreaSouthUnitLabel.setBounds(314, 146, 20, 15);
		exteriorWallAreaSouthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaSouthUnitLabel);

		exteriorWallAreaWestUnitLabel = new JLabel("m2");
		exteriorWallAreaWestUnitLabel.setBounds(314, 171, 20, 15);
		exteriorWallAreaWestUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaWestUnitLabel);

		exteriorWallAreaNorthUnitLabel = new JLabel("m2");
		exteriorWallAreaNorthUnitLabel.setBounds(314, 196, 20, 15);
		exteriorWallAreaNorthUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaNorthUnitLabel);

		exteriorWallAreaEastUnitLabel = new JLabel("m2");
		exteriorWallAreaEastUnitLabel.setBounds(314, 221, 20, 15);
		exteriorWallAreaEastUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallAreaEastUnitLabel);

	}

	private void createDetailUValueInfo() {

		exteriorWallUValueLabel = new JLabel("외벽 열관류율");
		exteriorWallUValueLabel.setBounds(392, 125, 100, 15);
		exteriorWallUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(exteriorWallUValueLabel);

		roofUValueLabel = new JLabel("지붕 열관류율");
		roofUValueLabel.setBounds(392, 150, 100, 15);
		roofUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(roofUValueLabel);

		floorUValueLabel = new JLabel("바닥 열관류율");
		floorUValueLabel.setBounds(392, 175, 100, 15);
		floorUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(floorUValueLabel);

		windowUValueLabel = new JLabel("창호 열관류율");
		windowUValueLabel.setBounds(392, 200, 100, 15);
		windowUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(windowUValueLabel);

		windowSHGCUValueLabel = new JLabel("창호 SHGC");
		windowSHGCUValueLabel.setBounds(392, 225, 100, 15);
		windowSHGCUValueLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(windowSHGCUValueLabel);

		exteriorWallUValueTextField = new JTextField("");
		exteriorWallUValueTextField.setBounds(492, 123, 40, 20);
		exteriorWallUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		exteriorWallUValueTextField.setEditable(false);
		add(exteriorWallUValueTextField);

		roofUValueTextField = new JTextField("");
		roofUValueTextField.setBounds(492, 148, 40, 20);
		roofUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		roofUValueTextField.setEditable(false);
		add(roofUValueTextField);

		floorUValueTextField = new JTextField("");
		floorUValueTextField.setBounds(492, 173, 40, 20);
		floorUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		floorUValueTextField.setEditable(false);
		add(floorUValueTextField);

		windowUValueTextField = new JTextField("");
		windowUValueTextField.setBounds(492, 198, 40, 20);
		windowUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowUValueTextField.setEditable(false);
		add(windowUValueTextField);

		windowSHGCUValueTextField = new JTextField("");
		windowSHGCUValueTextField.setBounds(492, 223, 40, 20);
		windowSHGCUValueTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		windowSHGCUValueTextField.setEditable(false);
		add(windowSHGCUValueTextField);

		exteriorWallUValueUnitLabel = new JLabel("W/m2K");
		exteriorWallUValueUnitLabel.setBounds(537, 127, 100, 15);
		exteriorWallUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(exteriorWallUValueUnitLabel);

		roofUValueUnitLabel = new JLabel("W/m2K");
		roofUValueUnitLabel.setBounds(537, 152, 100, 15);
		roofUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(roofUValueUnitLabel);

		floorUValueUnitLabel = new JLabel("W/m2K");
		floorUValueUnitLabel.setBounds(537, 177, 100, 15);
		floorUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(floorUValueUnitLabel);

		windowUValueUnitLabel = new JLabel("W/m2K");
		windowUValueUnitLabel.setBounds(537, 202, 100, 15);
		windowUValueUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(windowUValueUnitLabel);

	}

	private void createDetailHVACInfo() {

		equipmentLabel = new JLabel("전기 설비정보");
		equipmentLabel.setBounds(5, 263, 150, 15);
		equipmentLabel.setFont(new Font("바탕", Font.PLAIN, 13));
		equipmentLabel.setForeground(Color.BLUE);
		add(equipmentLabel);

		systemLabel = new JLabel("기기방식");
		systemLabel.setBounds(110, 290, 70, 15);
		systemLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(systemLabel);

		volumnLabel = new JLabel("용량");
		volumnLabel.setBounds(210, 290, 70, 15);
		volumnLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(volumnLabel);

		efficiencyLabel = new JLabel("효율");
		efficiencyLabel.setBounds(310, 290, 70, 15);
		efficiencyLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(efficiencyLabel);

		lightingDensityLabel = new JLabel("조명밀도");
		lightingDensityLabel.setBounds(510, 290, 70, 15);
		lightingDensityLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(lightingDensityLabel);

		heatingLabel = new JLabel("난방기기");
		heatingLabel.setBounds(20, 315, 70, 15);
		heatingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(heatingLabel);

		heatingPumpLabel = new JLabel("급탕기기");
		heatingPumpLabel.setBounds(20, 340, 70, 15);
		heatingPumpLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(heatingPumpLabel);

		coolingLabel = new JLabel("냉방기기");
		coolingLabel.setBounds(20, 365, 70, 15);
		coolingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(coolingLabel);

		lightingLabel = new JLabel("조명기기");
		lightingLabel.setBounds(420, 315, 70, 15);
		lightingLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		add(lightingLabel);

		heatingSystemComboBox = new JComboBox();
		heatingSystemComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "보일러", "지역난방", "EHP" }));
		heatingSystemComboBox.setBounds(103, 314, 75, 18);
		heatingSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		heatingSystemComboBox.setEnabled(false);
		add(heatingSystemComboBox);

		heatingPumpSystemComboBox = new JComboBox();
		heatingPumpSystemComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "보일러", "지역난방", "EHP" }));
		heatingPumpSystemComboBox.setBounds(103, 339, 75, 18);
		heatingPumpSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		heatingPumpSystemComboBox.setEnabled(false);
		add(heatingPumpSystemComboBox);

		coolingSystemComboBox = new JComboBox();
		coolingSystemComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "압축식", "흡수식", "EHP" }));
		coolingSystemComboBox.setBounds(103, 364, 75, 18);
		coolingSystemComboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		coolingSystemComboBox.setEnabled(false);
		add(coolingSystemComboBox);

		lightingDensityTextField = new JTextField("");
		lightingDensityTextField.setBounds(507, 313, 55, 20);
		lightingDensityTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		lightingDensityTextField.setEditable(false);
		add(lightingDensityTextField);

		lightingDensityUnitLabel = new JLabel("W/m2");
		lightingDensityUnitLabel.setBounds(566, 317, 60, 15);
		lightingDensityUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(lightingDensityUnitLabel);

		heatingVolumnTextField = new JTextField("");
		heatingVolumnTextField.setBounds(200, 313, 55, 20);
		heatingVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingVolumnTextField.setEditable(false);
		add(heatingVolumnTextField);

		heatingPumpVolumnTextField = new JTextField("");
		heatingPumpVolumnTextField.setBounds(200, 338, 55, 20);
		heatingPumpVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingPumpVolumnTextField.setEditable(false);
		add(heatingPumpVolumnTextField);

		coolingVolumnTextField = new JTextField("");
		coolingVolumnTextField.setBounds(200, 363, 55, 20);
		coolingVolumnTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		coolingVolumnTextField.setEditable(false);
		add(coolingVolumnTextField);

		heatingVolumnUnitLabel = new JLabel("kW");
		heatingVolumnUnitLabel.setBounds(259, 317, 60, 15);
		heatingVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(heatingVolumnUnitLabel);

		heatingPumpVolumnUnitLabel = new JLabel("kW");
		heatingPumpVolumnUnitLabel.setBounds(259, 342, 60, 15);
		heatingPumpVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(heatingPumpVolumnUnitLabel);

		coolingVolumnUnitLabel = new JLabel("kW");
		coolingVolumnUnitLabel.setBounds(259, 367, 60, 15);
		coolingVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(coolingVolumnUnitLabel);

		heatingEfficiencyTextField = new JTextField("");
		heatingEfficiencyTextField.setBounds(305, 313, 34, 20);
		heatingEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingEfficiencyTextField.setEditable(false);
		add(heatingEfficiencyTextField);

		heatingPumpEfficiencyTextField = new JTextField("");
		heatingPumpEfficiencyTextField.setBounds(305, 338, 34, 20);
		heatingPumpEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		heatingPumpEfficiencyTextField.setEditable(false);
		add(heatingPumpEfficiencyTextField);

		coolingEfficiencyTextField = new JTextField("");
		coolingEfficiencyTextField.setBounds(305, 363, 45, 20);
		coolingEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN, 12));
		coolingEfficiencyTextField.setEditable(false);
		add(coolingEfficiencyTextField);

		heatingEfficiencyUnitLabel = new JLabel("%");
		heatingEfficiencyUnitLabel.setBounds(343, 316, 60, 15);
		heatingEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(heatingEfficiencyUnitLabel);

		heatingPumpEfficiencyUnitLabel = new JLabel("%");
		heatingPumpEfficiencyUnitLabel.setBounds(343, 341, 60, 15);
		heatingPumpEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 11));
		add(heatingPumpEfficiencyUnitLabel);

		coolingEfficiencyUnitLabel = new JLabel("COP");
		coolingEfficiencyUnitLabel.setBounds(354, 366, 70, 15);
		coolingEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
		add(coolingEfficiencyUnitLabel);

		HVACLabel = new JLabel("<설비>");
		HVACLabel.setBounds(585, 260, 70, 15);
		HVACLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		HVACLabel.setForeground(Color.BLUE);
		add(HVACLabel);

		RadioGroup = new ButtonGroup();

		HVACRadioButton1 = new JRadioButton("자동");
		HVACRadioButton1.setBounds(270, 263, 70, 15);
		HVACRadioButton1.setFont(new Font("바탕", Font.PLAIN, 11));
		HVACRadioButton1.setForeground(Color.BLUE);
		HVACRadioButton1.addActionListener(this);
		HVACRadioButton1.setActionCommand("1");
		HVACRadioButton1.setSelected(true);
		RadioGroup.add(HVACRadioButton1);
		add(HVACRadioButton1);

		HVACRadioButton2 = new JRadioButton("수동");
		HVACRadioButton2.setBounds(340, 263, 70, 15);
		HVACRadioButton2.setFont(new Font("바탕", Font.PLAIN, 11));
		HVACRadioButton2.setForeground(Color.BLUE);
		HVACRadioButton2.addActionListener(this);
		HVACRadioButton2.setActionCommand("1");
		RadioGroup.add(HVACRadioButton2);
		add(HVACRadioButton2);

	}

	/*
	 * private void createDetailRenewableEnergyInfo() {
	 * 
	 * renewableEnergyLabel = new JLabel("<신재생>");
	 * renewableEnergyLabel.setBounds(583, 555, 70, 15);
	 * renewableEnergyLabel.setFont(new Font("바탕", Font.PLAIN, 12));
	 * renewableEnergyLabel.setForeground(Color.BLUE);
	 * add(renewableEnergyLabel);
	 * 
	 * areaLabel = new JLabel("면적"); areaLabel.setBounds(100, 571, 70, 15);
	 * areaLabel.setFont(new Font("바탕", Font.PLAIN, 12)); add(areaLabel);
	 * 
	 * volumn2Label = new JLabel("용량"); volumn2Label.setBounds(370, 571, 70,
	 * 15); volumn2Label.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(volumn2Label);
	 * 
	 * efficiency2Label = new JLabel("효율"); efficiency2Label.setBounds(470, 571,
	 * 70, 15); efficiency2Label.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(efficiency2Label);
	 * 
	 * solarThermalLabel = new JLabel("태양열"); solarThermalLabel.setBounds(20,
	 * 596, 70, 15); solarThermalLabel.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(solarThermalLabel);
	 * 
	 * photovoltaicLabel= new JLabel("태양광"); photovoltaicLabel.setBounds(20,
	 * 621, 70, 15); photovoltaicLabel.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(photovoltaicLabel);
	 * 
	 * solarThermalAreaTextField = new JTextField("");
	 * solarThermalAreaTextField.setBounds(93, 596, 55, 20);
	 * solarThermalAreaTextField.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(solarThermalAreaTextField);
	 * 
	 * photovoltaicAreaTextField = new JTextField("");
	 * photovoltaicAreaTextField.setBounds(93, 621, 55, 20);
	 * photovoltaicAreaTextField.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(photovoltaicAreaTextField);
	 * 
	 * solarThermalAreaUnitLabel = new JLabel("m2");
	 * solarThermalAreaUnitLabel.setBounds(152, 596, 60, 15);
	 * solarThermalAreaUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
	 * add(solarThermalAreaUnitLabel);
	 * 
	 * photovoltaicAreaUnitLabel = new JLabel("m2");
	 * photovoltaicAreaUnitLabel.setBounds(152, 621, 60, 15);
	 * photovoltaicAreaUnitLabel.setFont(new Font("바탕", Font.PLAIN, 10));
	 * add(photovoltaicAreaUnitLabel);
	 * 
	 * geothlermaHeatPumpLabel = new JLabel("지열히트펌프");
	 * geothlermaHeatPumpLabel.setBounds(260, 596, 90, 15);
	 * geothlermaHeatPumpLabel.setFont(new Font("바탕", Font.PLAIN, 12));
	 * add(geothlermaHeatPumpLabel);
	 * 
	 * geothlermaHeatPumpVolumnTextField = new JTextField("");
	 * geothlermaHeatPumpVolumnTextField.setBounds(363, 596, 55, 20);
	 * geothlermaHeatPumpVolumnTextField.setFont(new Font("바탕", Font.PLAIN,
	 * 12)); add(geothlermaHeatPumpVolumnTextField);
	 * 
	 * geothlermaHeatPumpVolumnUnitLabel = new JLabel("kW");
	 * geothlermaHeatPumpVolumnUnitLabel.setBounds(422, 596, 60, 15);
	 * geothlermaHeatPumpVolumnUnitLabel.setFont(new Font("바탕", Font.PLAIN,
	 * 10)); add(geothlermaHeatPumpVolumnUnitLabel);
	 * 
	 * geothlermaHeatPumpEfficiencyTextField = new JTextField("");
	 * geothlermaHeatPumpEfficiencyTextField.setBounds(463, 596, 45, 20);
	 * geothlermaHeatPumpEfficiencyTextField.setFont(new Font("바탕", Font.PLAIN,
	 * 12)); add(geothlermaHeatPumpEfficiencyTextField);
	 * 
	 * geothlermaHeatPumpEfficiencyUnitLabel = new JLabel("COP");
	 * geothlermaHeatPumpEfficiencyUnitLabel.setBounds(514, 596, 70, 15);
	 * geothlermaHeatPumpEfficiencyUnitLabel.setFont(new Font("바탕", Font.PLAIN,
	 * 10)); add(geothlermaHeatPumpEfficiencyUnitLabel);
	 * 
	 * }
	 */

	public void setModel(Ui_Model model) {
		this._model = model;
	}

	public String getGbxmlFilePath() {
		return gbxmlFilePath;
	}
	
	public void setHVACRadioButton1 () {
		
		isPressRadioButton2 = false;
		
		heatingSystemComboBox.setEnabled(false);
		heatingPumpSystemComboBox.setEnabled(false);
		coolingSystemComboBox.setEnabled(false);
		
		heatingVolumnTextField.setEditable(false);
		heatingPumpVolumnTextField.setEditable(false);
		coolingVolumnTextField.setEditable(false);

		heatingEfficiencyTextField.setEditable(false);
		heatingPumpEfficiencyTextField.setEditable(false);
		coolingEfficiencyTextField.setEditable(false);
		
		lightingDensityTextField.setEditable(false);
		
	}
	
	public void setHVACRadioButton2 () {
		
		isPressRadioButton2 = true;
		
		heatingSystemComboBox.setEnabled(true);
		heatingPumpSystemComboBox.setEnabled(true);
		coolingSystemComboBox.setEnabled(true);
		
		heatingVolumnTextField.setEditable(true);
		heatingPumpVolumnTextField.setEditable(true);
		coolingVolumnTextField.setEditable(true);

		heatingEfficiencyTextField.setEditable(true);
		heatingPumpEfficiencyTextField.setEditable(true);
		coolingEfficiencyTextField.setEditable(true);
		
		lightingDensityTextField.setEditable(true);
		
	}

	public void updateInfo() {
		
		if(_model.isConvertBIX()==1) {
			
			_model.setConvertBIX(_model.isConvertBIX()+1);
		
			GFATextField.setText(String.valueOf(_model.getInfo().getArea()));
			floorTextField.setText(String.valueOf(_model.getInfo().getFloor()));
			exteriorWallUValueTextField.setText(String.valueOf(_model.getInfo().getU_wall()));
			roofUValueTextField.setText(String.valueOf(_model.getInfo().getU_window()));
			floorUValueTextField.setText(String.valueOf(_model.getInfo().getU_roof()));
			windowUValueTextField.setText(String.valueOf(_model.getInfo().getU_floor()));
			windowSHGCUValueTextField.setText(String.valueOf(_model.getInfo().getSHGC()));
	
			exteriorAreaNorthTextField.setText(String.valueOf(_model.getInfo().getEach_shell_area()[0]));
			exteriorAreaEastTextField.setText(String.valueOf(_model.getInfo().getEach_shell_area()[1]));
			exteriorAreaSouthTextField.setText(String.valueOf(_model.getInfo().getEach_shell_area()[2]));
			exteriorAreaWestTextField.setText(String.valueOf(_model.getInfo().getEach_shell_area()[3]));
			windowAreaNorthTextField.setText(String.valueOf(_model.getInfo().getEach_window_area()[0]));
			windowAreaEastTextField.setText(String.valueOf(_model.getInfo().getEach_window_area()[1]));
			windowAreaSouthTextField.setText(String.valueOf(_model.getInfo().getEach_window_area()[2]));
			windowAreaWestTextField.setText(String.valueOf(_model.getInfo().getEach_window_area()[3]));
			exteriorWallAreaNorthTextField.setText(String.valueOf(_model.getInfo().getEach_wall_area()[0]));
			exteriorWallAreaEastTextField.setText(String.valueOf(_model.getInfo().getEach_wall_area()[1]));
			exteriorWallAreaSouthTextField.setText(String.valueOf(_model.getInfo().getEach_wall_area()[2]));
			exteriorWallAreaWestTextField.setText(String.valueOf(_model.getInfo().getEach_wall_area()[3]));
			
		}
		
		if(_model.isImportHVAC()==1) {
			
			setHVACRadioButton1 ();
			_model.setImportHVAC(_model.isImportHVAC()+1);
			
			if (_model.getInfo().getHeatingSystemType().name().equals("보일러"))
				heatingSystemComboBox.setSelectedIndex(1);
			else if (_model.getInfo().getHeatingSystemType().name().equals("지역난방"))
				heatingSystemComboBox.setSelectedIndex(2);
			else if (_model.getInfo().getHeatingSystemType().name().equals("EHP"))
				heatingSystemComboBox.setSelectedIndex(3);
			else
				heatingSystemComboBox.setSelectedIndex(0);
			
			if (_model.getInfo().getHeatingPumpSystemType().name().equals("보일러"))
				heatingPumpSystemComboBox.setSelectedIndex(1);
			else if (_model.getInfo().getHeatingPumpSystemType().name().equals("지역난방"))
				heatingPumpSystemComboBox.setSelectedIndex(2);
			else if (_model.getInfo().getHeatingPumpSystemType().name().equals("EHP"))
				heatingPumpSystemComboBox.setSelectedIndex(3);
			else
				heatingPumpSystemComboBox.setSelectedIndex(0);
			
			if (_model.getInfo().getCoolingSystemType().name().equals("압축식"))
				coolingSystemComboBox.setSelectedIndex(1);
			else if (_model.getInfo().getCoolingSystemType().name().equals("흡수식"))
				coolingSystemComboBox.setSelectedIndex(2);
			else if (_model.getInfo().getCoolingSystemType().name().equals("EHP"))
				coolingSystemComboBox.setSelectedIndex(3);
			else
				coolingSystemComboBox.setSelectedIndex(0);
			
			heatingVolumnTextField.setText(String.valueOf(_model.getInfo().getHeatingVolumn()));
			heatingPumpVolumnTextField.setText(String.valueOf(_model.getInfo().getHeatingPumpVolumn()));
			coolingVolumnTextField.setText(String.valueOf(_model.getInfo().getCoolingVolumn()));

			heatingEfficiencyTextField.setText(String.valueOf(_model.getInfo().getHeatingEfficiency()));
			heatingPumpEfficiencyTextField.setText(String.valueOf(_model.getInfo().getHeatingPumpEfficiency()));
			coolingEfficiencyTextField.setText(String.valueOf(_model.getInfo().getCoolingEfficiency()));
			
			lightingDensityTextField.setText(String.valueOf(_model.getInfo().getLightingDensity()));
			
		}
	}

	public void update(Object eventDispatcher) {
		updateInfo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		 if (arg0.getSource() == this.HVACRadioButton1) {
			 setHVACRadioButton1 ();
		 }
		 
		 if (arg0.getSource() == this.HVACRadioButton2) {
			 setHVACRadioButton2 ();
		 }
		 
	}

}