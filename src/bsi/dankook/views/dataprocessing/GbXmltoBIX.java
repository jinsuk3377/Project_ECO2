package bsi.dankook.views.dataprocessing;

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

public class GbXmltoBIX {
	
	private String gbxmlFilePath = "";

	public void setPath(String path) {
		gbxmlFilePath = path;
	}

	public void startConvert() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Document doc = null;
		try {
			doc = db.parse(new FileInputStream(gbxmlFilePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
				

		// ���ϴ� ��带 ã�Ƽ� �ִ� �۾�
		NodeList nl = null;
		try {
			nl = XPathAPI.selectNodeList(doc, "//Location");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Node toInsert = null;
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//Building");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//Surface");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//Campus/Name");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Campus");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//Construction");
		} catch (TransformerException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Envelope");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//Material");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Envelope");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//WindowType");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Envelope");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//Layer");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NodeList toInsertList = null;
		try {
			toInsertList = XPathAPI.selectNodeList(doc2, "//Construction");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NodeList n1 = null;
		try {
			n1 = XPathAPI.selectNodeList(doc, "//LayerId");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			nl = XPathAPI.selectNodeList(doc, "//YearSchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Schedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (nl == null) {
			System.out.println("YearSchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		Node toMove = (Element) nl.item(0);
		Node newOne = doc2.importNode(toMove, true);
		if (toInsert instanceof Element) {
			Element e = (Element) toInsert;
			e.appendChild(newOne);
		}
		NodeList nlW = null;
		try {
			nlW = XPathAPI.selectNodeList(doc, "//WeekSchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (nlW == null) {
			System.out.println("WeekSchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		toMove = (Element) nlW.item(0);
		newOne = doc2.importNode(toMove, true);
		if (toInsert instanceof Element) {
			Element e = (Element) toInsert;
			e.appendChild(newOne);
		}
		NodeList nlD = null;
		try {
			nlD = XPathAPI.selectNodeList(doc, "//DaySchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (nlD == null) {
			System.out.println("DaySchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}

		toMove = (Element) nlD.item(0);
		newOne = doc2.importNode(toMove, true);
		if (toInsert instanceof Element) {
			Element e = (Element) toInsert;
			e.appendChild(newOne);
		}
		try {
			nl = XPathAPI.selectNodeList(doc, "//YearSchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toInsert = XPathAPI.selectSingleNode(doc2, "//Schedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (nl == null) {
			System.out.println("YearSchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		toMove = (Element) nl.item(1);
		newOne = doc2.importNode(toMove, true);
		if (toInsert instanceof Element) {
			Element e = (Element) toInsert;
			e.appendChild(newOne);
		}
		try {
			nlW = XPathAPI.selectNodeList(doc, "//WeekSchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (nlW == null) {
			System.out.println("WeekSchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		toMove = (Element) nlW.item(1);
		newOne = doc2.importNode(toMove, true);
		if (toInsert instanceof Element) {
			Element e = (Element) toInsert;
			e.appendChild(newOne);
		}
		try {
			nlD = XPathAPI.selectNodeList(doc, "//DaySchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (nlD == null) {
			System.out.println("DaySchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}

		toMove = (Element) nlD.item(1);
		newOne = doc2.importNode(toMove, true);
		if (toInsert instanceof Element) {
			Element e = (Element) toInsert;
			e.appendChild(newOne);
		}

		try {
			nl = XPathAPI.selectNodeList(doc, "//Schedule/Name");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		NodeList nlY = null;
		try {
			nlY = XPathAPI.selectNodeList(doc2, "//YearSchedule");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (nlY == null) {
			System.out.println("YearSchedule" + " 이 파일이 존재하지 않습니다.");
			return;
		}

		toMove = (Element) nl.item(0);
		newOne = doc2.importNode(toMove, true);
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

		try {
			nl = XPathAPI.selectNodeList(doc, "//Zone");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Node Zonen = null;
		try {
			Zonen = XPathAPI.selectSingleNode(doc2,
					"//BuildingInformationGreenSchema");
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (Zonen == null) {
			System.out.println("Zone" + " 이 파일이 존재하지 않습니다.");
			return;
		}
		toMove = (Element) nl.item(0);
		newOne = doc2.importNode(toMove, true);
		if (Zonen instanceof Node) {
			Node e = (Node) Zonen;
			e.appendChild(newOne);
		}

		// //////////// Remove Node///////////////////////////////////
		NodeList n = null;
		try {
			n = XPathAPI.selectNodeList(doc2, "//LayerId");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int temp = 0; temp < n.getLength(); temp++) {
			if (n.item(temp).getNodeName().equals("LayerId")) {
				Node pr = n.item(temp).getParentNode();
				pr.removeChild(n.item(temp));
			}
		}
		// ///////////// ModifyAttr//////////////////////////////////
		Node id = null;
		try {
			id = XPathAPI.selectSingleNode(doc, "//Campus");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NamedNodeMap CampusAttr = id.getAttributes();
		Node NodeAttr = CampusAttr.getNamedItem("id");

		Campus.setAttribute("id", NodeAttr.getTextContent());
		// ///////////////////////////////////////////////////////////

		// ///////////////////////////////////////////////////////
		Element YearSchedule1 = (Element) doc2.getElementsByTagName(
				"YearSchedule").item(0);
		Node S1Id = null;
		try {
			S1Id = XPathAPI.selectNodeList(doc, "//Schedule").item(0);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NamedNodeMap attr1 = S1Id.getAttributes();

		YearSchedule1.setAttribute("id", attr1.getNamedItem("id")
				.getTextContent());
		YearSchedule1.setAttribute("type", attr1.getNamedItem("type")
				.getTextContent());

		Element YearSchedule2 = (Element) doc2.getElementsByTagName(
				"YearSchedule").item(1);
		Node S2Id = null;
		try {
			S2Id = XPathAPI.selectNodeList(doc, "//Schedule").item(1);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NamedNodeMap attr2 = S2Id.getAttributes();
		YearSchedule2.setAttribute("id", attr2.getNamedItem("id")
				.getTextContent());
		YearSchedule2.setAttribute("type", attr2.getNamedItem("type")
				.getTextContent());

		// //////////BuildingInformationGreenSchema attributes add/////////////

		Node BuildingInfo = null;
		try {
			BuildingInfo = XPathAPI.selectSingleNode(doc, "//gbXML");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		XMLSerializer serializer = null;
		try {
			serializer = new XMLSerializer(new FileWriter("test.xml"), format);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			serializer.serialize(doc2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			serializer.endDocument();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Success");
	}

}
