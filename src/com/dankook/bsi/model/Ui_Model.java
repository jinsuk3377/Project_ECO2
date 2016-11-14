package com.dankook.bsi.model;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.dankook.bsi.exception.*;
import com.dankook.bsi.util.Ui_Observer;
import com.dankook.bsi.util.greenbuilding.GBXmlContext;
import com.dankook.bsi.views.dataprocessing.GBXmlReader;
import com.dankook.bsi.views.dataprocessing.ReadHVAC;

public class Ui_Model implements Ui_Observer {
	private GBXmlContext gbxml;
	private Info info = null;
	private static String gbxmlFilePath = "";
	private static String BIXFilePath = "";
	private static String HVACFilePath = "";
	private static boolean convertBIXCheck = false;

	public Ui_Model() {
		this.gbxml = null;
		this.info = null;
	}
	
	public String getGbxmlFileExtention() {
		return "xml";
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
			setHVACFilePath(filePath);
			info.setHVACFilePath(filePath);
			ReadHVAC readHVAC = new ReadHVAC(this);
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
	
	public void setConvertBIXCheck(boolean convertBIXCheck) {
		Ui_Model.convertBIXCheck = convertBIXCheck;
	}
	
	public boolean getConvertBIXCheck() {
		return Ui_Model.convertBIXCheck;
	}

	public void update(Object paramObject) {
		
	}	


}