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

import org.apache.xml.serialize.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dankook.bsi.model.Info;
import com.dankook.bsi.model.Ui_Model;

public class GbXmltoBIX extends Thread {
	
	private Ui_Model _model;
	private Info _info;
	private String gbxmlFilePath = "";

	public GbXmltoBIX (Ui_Model model) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		_model = model;
		_info = _model.getInfo();
		gbxmlFilePath = model.getGbxmlFilePath();
	}
	
	public void start() {
		try {
			startGbxmlToBIX();
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startGbxmlToBIX() throws NullPointerException, ParserConfigurationException, SAXException, IOException, TransformerException{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(new FileInputStream(gbxmlFilePath));
		Document doc2 = db.newDocument();

		Element root = doc2.createElement("BuildingInformationGreenSchema");
		doc2.appendChild(root);
		Element Campus = doc2.createElement("Campus");
		root.appendChild(Campus);
		Element Envelope = doc2.createElement("Envelope");
		root.appendChild(Envelope);
		Element Schedule = doc2.createElement("Schedule");
		root.appendChild(Schedule);
		Element Systems = doc2.createElement("System");
		root.appendChild(Systems);
			
		NodeList nl = XPathAPI.selectNodeList(doc, "//Location");
		
		Node toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		
		if (nl == null) {
			System.out.println("Location" + " 이 파일이 존재하지 않습니다.");
			return;
		}

		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
	
		nl = XPathAPI.selectNodeList(doc, "//Building");
		
		toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		
		if (nl == null) {
			System.out.println("Building" + " 이 파일이 존재하지 않습니다.");
			return;
		}

		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//Surface");
		
		toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		
		if (nl == null) {
			System.out.println("Surface" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//Campus/Name");
		
		toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		
		if (nl == null) {
			System.out.println("Name" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//Construction");
		
		toInsert = XPathAPI.selectSingleNode(doc2, "//Envelope");
		
		if (nl == null) {
			System.out.println("Construction" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//Material");
		
		toInsert = XPathAPI.selectSingleNode(doc2, "//Envelope");
		
		if (nl == null) {
			System.out.println("Material" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//WindowType");

		toInsert = XPathAPI.selectSingleNode(doc2, "//Envelope");
		
		if (nl == null) {
			System.out.println("WindowType" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		for (int temp = 0; temp < nl.getLength(); temp++) {
			Element toMove = (Element) nl.item(temp);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//Layer");
		
		NodeList toInsertList = null;
		
		toInsertList = XPathAPI.selectNodeList(doc2, "//Construction");
		
		NodeList n1 = null;
		
		n1 = XPathAPI.selectNodeList(doc, "//LayerId");
		
		if (nl == null) {
			System.out.println("Surface" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		for (int temp = 0; temp < nl.getLength(); temp++) {
			NamedNodeMap attr1 = nl.item(temp).getAttributes();
			NamedNodeMap attr2 = n1.item(temp).getAttributes();
			if (attr1.getNamedItem("id").getNodeValue()
					.equals(attr2.getNamedItem("layerIdRef").getNodeValue())) {
				NodeList list = nl.item(temp).getChildNodes();
				for (int idx = 0; idx < list.getLength(); idx++) {
					Node toMove = (Node) list.item(idx);

					Node newOne = doc2.importNode(toMove, true);
					if (toInsertList.item(temp) instanceof Element) {
						Element e = (Element) toInsertList.item(temp);
						e.appendChild(newOne);
					}
				}
			}
		}
		// ////////////////////////// Schedule
		// ////////////////////////// Insert////////////////////////////////////
		
		nl = XPathAPI.selectNodeList(doc, "//YearSchedule");
		toInsert = XPathAPI.selectSingleNode(doc2, "//Schedule");
		
		if(nl.getLength() == 0) {
			System.out.println("YearSchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nl.item(0);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		NodeList nlW = XPathAPI.selectNodeList(doc, "//WeekSchedule");
		
		if(nlW.getLength() == 0) {
			System.out.println("WeekSchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nlW.item(0);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		NodeList nlD = XPathAPI.selectNodeList(doc, "//DaySchedule");
		
		if(nlD.getLength() == 0) {
			System.out.println("DaySchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nlD.item(0);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nl = XPathAPI.selectNodeList(doc, "//YearSchedule");
		toInsert = XPathAPI.selectSingleNode(doc2, "//Schedule");
		
		if(nl.getLength() == 0) {
			System.out.println("YearSchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nl.item(1);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nlW = XPathAPI.selectNodeList(doc, "//WeekSchedule");
		
		if(nlW.getLength() == 0) {
			System.out.println("WeekSchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nlW.item(1);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}
		
		nlD = XPathAPI.selectNodeList(doc, "//DaySchedule");
		
		if(nlD.getLength() == 0) {
			System.out.println("WeekSchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nlD.item(1);
			Node newOne = doc2.importNode(toMove, true);
			if (toInsert instanceof Element) {
				Element e = (Element) toInsert;
				e.appendChild(newOne);
			}
		}

		nl = XPathAPI.selectNodeList(doc, "//Schedule/Name");
		
		NodeList nlY = XPathAPI.selectNodeList(doc2, "//YearSchedule");

		if(nlY.getLength() == 0) {
			System.out.println("YearSchedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nl.item(0);
			Node newOne = doc2.importNode(toMove, true);
			if (nlY.item(0) instanceof Node) {
				Node e = (Node) nlY.item(0);
				e.appendChild(newOne);
			}
			
			toMove = (Element) nl.item(1);
			newOne = doc2.importNode(toMove, true);
			if (nlY.item(0) instanceof Node) {
				Node e = (Node) nlY.item(1);
				e.appendChild(newOne);
			}
		}

		nl = XPathAPI.selectNodeList(doc, "//Zone");
		
		Node Zonen = XPathAPI.selectSingleNode(doc2,
					"//BuildingInformationGreenSchema");
		
		if(nl.getLength() == 0) {
			System.out.println("Zone" + "의 item이 존재하지 않습니다.");
		}
		else {
			Node toMove = (Element) nl.item(0);
			Node newOne = doc2.importNode(toMove, true);
			if (Zonen instanceof Node) {
				Node e = (Node) Zonen;
				e.appendChild(newOne);
			}
		}

		////////////// Remove Node///////////////////////////////////
		NodeList n = XPathAPI.selectNodeList(doc2, "//LayerId");
		
		if(n.getLength() == 0) {
			System.out.println("LayerId" + "의 item이 존재하지 않습니다.");
		}
		else {
			for (int temp = 0; temp < n.getLength(); temp++) {
				if (n.item(temp).getNodeName().equals("LayerId")) {
					Node pr = n.item(temp).getParentNode();
					pr.removeChild(n.item(temp));
				}
			}
		}
		
		// ///////////// ModifyAttr//////////////////////////////////
		Node id = XPathAPI.selectSingleNode(doc, "//Campus");

		NamedNodeMap CampusAttr = id.getAttributes();
		Node NodeAttr = CampusAttr.getNamedItem("id");

		Campus.setAttribute("id", NodeAttr.getTextContent());
		// ///////////////////////////////////////////////////////////

		// ///////////////////////////////////////////////////////
		
		NodeList n2 = doc2.getElementsByTagName("YearSchedule");
		
		if(n2.getLength() == 0) {
			System.out.println("Schedule" + "의 item이 존재하지 않습니다.");
		}
		else {
			Element YearSchedule1 = (Element) n2.item(0);
			n = XPathAPI.selectNodeList(doc, "//Schedule");
			
			if(n.getLength() == 0) {
				System.out.println("Schedule" + "의 item이 존재하지 않습니다.");
			}
			else {
				Node S1Id = n.item(0);
				NamedNodeMap attr1 = S1Id.getAttributes();

				YearSchedule1.setAttribute("id", attr1.getNamedItem("id")
						.getTextContent());
				YearSchedule1.setAttribute("type", attr1.getNamedItem("type")
						.getTextContent());
			}
			
			Element YearSchedule2 = (Element) n2.item(1);
			Node S2Id = XPathAPI.selectNodeList(doc, "//Schedule").item(1);
			
			if(n.getLength() == 0) {
				System.out.println("Schedule" + "의 item이 존재하지 않습니다.");
			}
			else {
				Node S1Id = n.item(0);
				NamedNodeMap attr1 = S1Id.getAttributes();

				YearSchedule1.setAttribute("id", attr1.getNamedItem("id")
						.getTextContent());
				YearSchedule1.setAttribute("type", attr1.getNamedItem("type")
						.getTextContent());
				
				NamedNodeMap attr2 = S2Id.getAttributes();
				YearSchedule2.setAttribute("id", attr2.getNamedItem("id")
						.getTextContent());
				YearSchedule2.setAttribute("type", attr2.getNamedItem("type")
						.getTextContent());
			}
		}
		
		// //////////BuildingInformationGreenSchema attributes add/////////////

		Node BuildingInfo = XPathAPI.selectSingleNode(doc, "//gbXML");

		NamedNodeMap gbXMLAttr = BuildingInfo.getAttributes();

		Node useSIUnitsForResults = gbXMLAttr
				.getNamedItem("useSIUnitsForResults");
		root.setAttribute("useSIUnitsForResults",
				useSIUnitsForResults.getTextContent());

		Node temperatureUnit = gbXMLAttr.getNamedItem("temperatureUnit");
		root.setAttribute("temperatureUnit", temperatureUnit.getTextContent());

		Node lengthUnit = gbXMLAttr.getNamedItem("lengthUnit");
		root.setAttribute("lengthUnit", lengthUnit.getTextContent());

		Node areaUnit = gbXMLAttr.getNamedItem("areaUnit");
		root.setAttribute("areaUnit", areaUnit.getTextContent());

		Node volumeUnit = gbXMLAttr.getNamedItem("volumeUnit");
		root.setAttribute("volumeUnit", volumeUnit.getTextContent());

		Node version = gbXMLAttr.getNamedItem("version");
		root.setAttribute("version", "0.1");

		Node xmlns = gbXMLAttr.getNamedItem("xmlns");
		root.setAttribute("xmlns", "http://bsi.dankook.ac.kr/schema");

		//Node xmlnsxsi = gbXMLAttr.getNamedItem("xmlns:xsi");
		//root.setAttribute("xmlns:xsi", xmlnsxsi.getTextContent());

		//Node xsischemaLocation = gbXMLAttr.getNamedItem("xsi:schemaLocation");
		/*root.setAttribute(
				"xsi:schemaLocation",
				xsischemaLocation
						.getTextContent()
						.replace("GreenBuildingXML_Ver6.00.xsd", "BIX_v3.xsd")
						.replace("http://www.gbxml.org/schema",
								"http://bsi.dankook.ac.kr/schema"));
*/
		OutputFormat format = new OutputFormat(doc2, "UTF-8", true);
		XMLSerializer serializer = new XMLSerializer(new FileWriter("test.xml"), format);
		
		serializer.serialize(doc2);
		
		serializer.endDocument();
		
		System.out.println("Success");
	}

}
