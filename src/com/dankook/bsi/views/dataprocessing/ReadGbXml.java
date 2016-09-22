package com.dankook.bsi.views.dataprocessing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
import com.dankook.bsi.model.Ui_Model;

public class ReadGbXml extends Thread {

	private Ui_Model _model;

	private DOMParser parser;
	private Document doc;

	public ReadGbXml(Ui_Model model) throws IOException, SAXException {
		_model = model;
	}

	public void StartReadGbXml() throws SAXException, IOException {

		parser = new DOMParser();
		// parser.parse(_info.getGbxmlFilePath()); //XML문서 파싱
		parser.parse("test.xml");
		doc = parser.getDocument();
		doc.getDocumentElement().normalize();

		// nList = doc.getElementsByTagName("Campus");

		if (_model.getInfo().getArea() == 0) {
			getNode("Area");
			getNode("U-value");
		}
			

	}
	
	public void run() {

	}

	public void getNode(String what) throws IOException {
		
		Element element;
		
		if(what.equals("Area")) {
			NodeList nList = doc.getElementsByTagName("Campus");
			NodeList nodeList;
			for(int i=0; i<nList.getLength(); i++) {
				element = (Element) nList.item(i);
				
				if(element.hasChildNodes()) {
					nodeList = element.getElementsByTagName("Building");
					
					for(int j=0; j<nodeList.getLength(); j++) {
						Element temp = (Element) nodeList.item(j);
						
						if(temp.hasChildNodes()) {
							NodeList area = temp.getElementsByTagName("Area");
							Double d = Double.parseDouble(area.item(0).getTextContent());
							if(d != 0) {
								_model.getInfo().setArea(d);
								System.out.println(_model.getInfo().getArea());
								return;
							}
						}
					}
				}
			}
		}
		
		else if(what.equals("U-value")) {
			NodeList nList = doc.getElementsByTagName("Envelope");
			NodeList nodeList, nodeAttrList;
			
			ArrayList<String> iArrayList = new ArrayList<String>(); //Construction id
			ArrayList<Double> uArrayList = new ArrayList<Double>(); //Construction U-Value
			
			for(int i=0; i<nList.getLength(); i++) {
				element = (Element) nList.item(i);
				
				if(element.hasChildNodes()) {
					nodeList = element.getElementsByTagName("Construction");
					
					for(int j=0; j<nodeList.getLength(); j++) {
						Element temp = (Element) nodeList.item(j);
						String id = temp.getAttribute("id");
						
						NodeList uvalue = temp.getElementsByTagName("U-value");
						Node u = uvalue.item(0);
						if(u.hasChildNodes()) {
							Double d = Double.parseDouble(u.getTextContent());
							if(d != 0) {
								System.out.println(id);
								System.out.println(d);
								iArrayList.add(id);
								uArrayList.add(d);
							}
						}
					}
				}
			}
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

}
