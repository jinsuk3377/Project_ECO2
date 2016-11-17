package com.dankook.bsi.model;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.dankook.bsi.exception.*;
import com.dankook.bsi.util.greenbuilding.GBXmlContext;
import com.dankook.bsi.views.*;
import com.dankook.bsi.views.dataprocessing.GBXmlReader;
import com.dankook.bsi.views.dataprocessing.ReadHVAC;

public class Ui_Model {
	private GBXmlContext gbxml;
	private Info info = null;

	private MainPanel mainPanel;
	private LoadGbXml_Panel gbxmlPanel;
	private LoadHVAC_Panel hvacPanel;
	private ReadHVAC readHVAC;
	
	private static String gbxmlFilePath = "";
	private static String BIXFilePath = "";
	private static String HVACFilePath = "";
	private static boolean isConvertBIX = false;
	
	public Ui_Model() {
		this.gbxml = null;
		this.info = null;
	}
	
	public String getGbxmlFileExtention() {
		return "xml";
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public LoadGbXml_Panel getGbxmlPanel() {
		return gbxmlPanel;
	}

	public void setGbxmlPanel(LoadGbXml_Panel gbxmlPanel) {
		this.gbxmlPanel = gbxmlPanel;
	}

	public LoadHVAC_Panel getHvacPanel() {
		return hvacPanel;
	}

	public void setHvacPanel(LoadHVAC_Panel hvacPanel) {
		this.hvacPanel = hvacPanel;
	}

	public String getGbxmlFileDesc() {
		return "GreenBuild File Format (.xml)";
	}
	
	public String getHVACFileExtention() {
		return "xlsx";
	}

	public String getHVACFileDesc() {
		return "HVAC imformation Excel File (.xlsx)";
	}

	public void openGbxmlFile(String filePath) throws GBXmlValidationError {
		try {
			setGbxmlFilePath(filePath);
			info.setGbxmlFilePath(filePath);
			GBXmlReader _xmlReader = new GBXmlReader();
			Document doc = _xmlReader.createDocumentFromFile(filePath);
			this.gbxml = _xmlReader.createGBXmlContext(doc);
		} catch (SAXException e) {
			throw new GBXmlValidationError();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean openHVACFile(String filePath) throws HVACValidationError {
		
		boolean check = false;
		
		try {
			info.setHVACFilePath(filePath);
			readHVAC = new ReadHVAC(this);
			check = readHVAC.ExcelRead();
			info.printHVAC();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public void newInfo() {
		info = new Info();
	}
	
	public void setGbXMLInfo() {
		if (info==null) newInfo();
	}

	public void setHVACInfo() {		
		if (info==null) newInfo();
	}
	
	public Info getInfo() {
		return info;
	}
	
	public void setInfoValues() {
		info.setValues();
		info.printBIX();
	}

	public boolean loadedGbxmlFile() {
		return !getGbxmlFilePath().equals("");
	}

	public boolean loadedBIXFile() {
		return !getBIXFilePath().equals("");
	}

	public void setBIXFilePath(String BIXFilePath) {
		Ui_Model.BIXFilePath = BIXFilePath;
	}

	public String getBIXFilePath() {
		return Ui_Model.BIXFilePath;
	}

	public GBXmlContext getGbXml() {
		return this.gbxml;
	}

	public void setGbxmlFilePath(String gbxmlFilePath) {
		Ui_Model.gbxmlFilePath = gbxmlFilePath;
	}
//////
	public String getGbxmlFilePath() {
		return Ui_Model.gbxmlFilePath;
	}
	
	public void setHVACFilePath(String HVACFilePath) {
		Ui_Model.HVACFilePath = HVACFilePath;
	}
	
	public String getHVACFilePath() {
		return Ui_Model.HVACFilePath;
	}
	
	public void setIsConvertBIX(boolean convertBIXCheck) {
		Ui_Model.isConvertBIX = convertBIXCheck;
	}
	
	public boolean getIsConvertBIX() {
		return Ui_Model.isConvertBIX;
	}

	public void update(Object paramObject) {
		
	}	


}