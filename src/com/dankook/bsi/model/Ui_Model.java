package com.dankook.bsi.model;

import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.dankook.bsi.exception.*;
import com.dankook.bsi.util.Ui_Observer;
import com.dankook.bsi.util.IDF.IDF;
import com.dankook.bsi.util.greenbuilding.GBXmlContext;
import com.dankook.bsi.views.*;
import com.dankook.bsi.views.dataprocessing.GBXmlReader;
import com.dankook.bsi.views.dataprocessing.ReadHVAC;

import com.dankook.bsi.util.IDF.GBXmlToIdfConverter;

import com.dankook.bsi.util.Ui_Observer;

public class Ui_Model implements Ui_Observer {
	
	private Vector<Ui_Observer> _views = new Vector();
	private GBXmlContext gbxml;
	private Info info = null;
	private IDF idf;
	
	private MainPanel mainPanel;
	private ReadHVAC readHVAC;

	private static String gbxmlFilePath = "";
	private static String BIXFilePath = "";
	private static String HVACFilePath = "";
	private static int isConvertBIX = 0;
	private static int isImportHVAC = 0;
	
	public Ui_Model() {
		this.gbxml = null;
		this.info = null;
	}
	
	public void addObserver(Ui_Observer view) {
		this._views.add(view);
	}
	
	public void notifyAllToAllViews() {
		for (Ui_Observer view : this._views)
		{
			view.update(this);
		}
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

	public ReadHVAC getHvacRead() {
		return readHVAC;
	}

	public void setHvacRead(ReadHVAC readHVAC) {
		this.readHVAC = readHVAC;
	}

	public String getGbxmlFileDesc() {
		return "GreenBuild File Format (.xml)";
	}
	
	public String getHVACFileExtentionXlsx() {
		return "xlsx";
	}

	public String getHVACFileDescXlsx() {
		return "HVAC imformation Excel File (.xlsx)";
	}
	
	public String getHVACFileExtentionXls() {
		return "xls";
	}
	
	public String getHVACFileDescXls() {
		return "HVAC imformation Excel File (.xls)";
	}

	public void openGbxmlFile(String filePath) throws GBXmlValidationError {
		try {
		
			setGbxmlFilePath(filePath);
			info.setGbxmlFilePath(filePath);
			GBXmlReader _xmlReader = new GBXmlReader();
			Document doc = _xmlReader.createDocumentFromFile(filePath);
			this.gbxml = _xmlReader.createGBXmlContext(doc);
			this.idf = new GBXmlToIdfConverter().convert(this.gbxml);
			notifyAllToAllViews();
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
			//info.printHVAC();
			info.printHVACTest();
			notifyAllToAllViews();
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
	
	public IDF getIdf() {
		return idf;
	}

	public void setIdf(IDF idf) {
		this.idf = idf;
		notifyAllToAllViews();
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
	
	public static void setConvertBIX(int convertBIXCheck) {
		Ui_Model.isConvertBIX = convertBIXCheck;
	}
	
	public static int isConvertBIX() {
		return Ui_Model.isConvertBIX;
	}

	public static void setImportHVAC(int isImportHVAC) {
		Ui_Model.isImportHVAC = isImportHVAC;
	}
	
	public static int isImportHVAC() {
		return isImportHVAC;
	}

	public void update(Object eventDispatcher) {

		notifyAllToAllViews();
	}


}