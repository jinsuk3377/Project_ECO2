package com.dankook.bsi.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.dankook.bsi.exception.*;
import com.dankook.bsi.util.greenbuilding.GBXmlContext;

public class Ui_Model implements Ui_Observer {
	private GBXmlContext gbxml;
	private static String gbxmlFilePath = "";
	private static String BIXFilePath = "";

	public Ui_Model() {
		this.gbxml = null;
	}

	public String getGbxmlFileExtention() {
		return "xml";
	}

	public String getGbxmlFileDesc() {
		return "GreenBuild File Format";
	}

	public void openGbxmlFile(String filePath) throws GBXmlValidationError {
		try {
			GBXmlReader _xmlReader = new GBXmlReader();
			Document doc = _xmlReader.createDocumentFromFile(filePath);
			this.gbxml = _xmlReader.createGBXmlContext(doc);
			setGbxmlFilePath(filePath);
		} catch (SAXException e) {
			throw new GBXmlValidationError();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean loadedGbxmlFile() {
		return !getGbxmlFilePath().equals("");
	}

	public boolean loadedBIXFile() {
		return !getBIXFilePath().equals("");
	}

	public void setBIXFilePath(String BIXFilePath) {
		this.BIXFilePath = BIXFilePath;
	}

	public String getBIXFilePath() {
		return this.BIXFilePath;
	}

	public GBXmlContext getGbXml() {
		return this.gbxml;
	}

	public void setGbxmlFilePath(String gbxmlFilePath) {
		this.gbxmlFilePath = gbxmlFilePath;
	}

	public String getGbxmlFilePath() {
		return this.gbxmlFilePath;
	}

	@Override
	public void update(Object paramObject) {
		// TODO Auto-generated method stub
		
	}

}