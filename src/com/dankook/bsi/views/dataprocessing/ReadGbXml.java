package com.dankook.bsi.views.dataprocessing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.xpath.XPathAPI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.xerces.parsers.DOMParser;
import org.apache.xml.serialize.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dankook.bsi.model.Info;

public class ReadGbXml extends Thread {

	private Info _info;
	
	private DOMParser parser;
	private Document doc;
	private NodeList nList;
	private Node nNode;
	
	public ReadGbXml(Info info) throws IOException, SAXException {
		_info = info;
		StartReadGbXml();
	}
	
	public void StartReadGbXml() throws SAXException, IOException {
        
		parser = new DOMParser();
		//parser.parse(_info.getGbxmlFilePath());   //XML문서 파싱
		parser.parse("test.xml");
        doc = parser.getDocument();
        doc.getDocumentElement().normalize();
        
        //nList = doc.getElementsByTagName("Campus");
        
        if(_info.getArea()==0) getNode(doc.getChildNodes(), "Area");
        
	}
	
	public void run() {
		
	}
	
	public void getNode(NodeList nodeList, String what) throws IOException {
		
		if(what.equals("Area")) {
			nodeList = doc.getElementsByTagName("Campus");
		}
		
	    //int type = node.getNodeType();
	    
	    for (int i=0; i<nList.getLength(); i++) {
	    	
	    }
	    /*
	    switch(type) {
	        case Node.DOCUMENT_NODE:   // NODE가 DOCUMENT_NODE인 경우 
	        	 //reader.write("DOC: " + node.getNodeName() + "\n");
	             Document d = (Document)node;
	             getNode(d.getDocumentElement());   
	             break;
	        case Node.ELEMENT_NODE:   // NODE가 ELEMENT_NODE인 경우 
	        	 //reader.write("ELEMENT: " + node.getNodeName() + "\n");
	        	
	        	 if(_info.getArea() == 0) {
	        		 ;
	        	 }
	        	 else if(node.getNodeName().equals("Building")) {
	        		 
	        	 }
	        	 else if(node.getNodeName().equals("")) {
	        		 
	        	 }
	        	 
	             NamedNodeMap attrs = node.getAttributes();
	             int len = attrs.getLength();
	             for(int i=0; i < len; i++) {
	            	 getNode(attrs.item(i));
	             }
	             
	             NodeList children = node.getChildNodes();
	             if(children != null) {
	                  int n = children.getLength();
	                  for(int i=0; i < n; i++) {
	                	  getNode(children.item(i));	
	                  }
	             }
	             break;
	    }
	    */
	}
	
	//public void get
	
	public static void main(String[] args) throws IOException, SAXException{
		
		Info info = new Info();
		ReadGbXml readgbxml = new ReadGbXml(info);
	}
}
