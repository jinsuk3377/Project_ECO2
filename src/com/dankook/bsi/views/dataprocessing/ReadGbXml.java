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

public class ReadGbXml {

	private Ui_Model _model;

	private DOMParser parser;
	private Document doc;

	public ReadGbXml(Ui_Model model) throws IOException, SAXException {
		_model = model;
	}

	public void StartReadGbXml() throws SAXException, IOException {

		parser = new DOMParser();
		parser.parse("test.xml");
		doc = parser.getDocument();
		doc.getDocumentElement().normalize();

		if (_model.getInfo().getArea() == 0) {
			getNode();
		}

	}

	public void getNode() throws IOException {

		Element element;

		NodeList nList = doc.getElementsByTagName("Envelope");
		NodeList nodeList, nodeAttrList;

		ArrayList<String> iArrayList = new ArrayList<String>(); // Construction id
		ArrayList<Double> iuArrayList = new ArrayList<Double>(); // Construction U-Value

		ArrayList<String> wArrayList = new ArrayList<String>(); // Window id
		ArrayList<Double> wuArrayList = new ArrayList<Double>(); // Window U-Value
		ArrayList<Double> wshgcArrayList = new ArrayList<Double>(); // window SHGC unit="Fraction"

		double[] each_shell_area = { 0, 0, 0, 0 }; // 외피면적, index 순서 S,W,N,E
		double[] each_wall_area = { 0, 0, 0, 0 }; // 벽체면적, index 순서 S,W,N,E
		double[] each_window_area = { 0, 0, 0, 0 }; // 창면적, index 순서 S,W,N,E
		double total_area = 0;
		double roof_area = 0;
		int floor = 0;

		for (int i = 0; i < nList.getLength(); i++) {
			element = (Element) nList.item(i);

			if (element.hasChildNodes()) {
				nodeList = element.getElementsByTagName("Construction");

				for (int j = 0; j < nodeList.getLength(); j++) {
					Element temp = (Element) nodeList.item(j);
					String id = temp.getAttribute("id");

					NodeList uvalue = temp.getElementsByTagName("U-value");
					Node u = uvalue.item(0);
					if (u.hasChildNodes()) {
						Double d = Double.parseDouble(u.getTextContent());
						if (d != 0) {
							iArrayList.add(id);
							iuArrayList.add(d);
						}
					} else {
						System.out.println("Error Construction");
					}
				}

				nodeList = element.getElementsByTagName("WindowType");

				for (int j = 0; j < nodeList.getLength(); j++) {
					Element temp = (Element) nodeList.item(j);
					String id = temp.getAttribute("id");

					NodeList uvalue = temp.getElementsByTagName("U-value");
					Node u = uvalue.item(0);
					NodeList shgc = temp.getElementsByTagName("SolarHeatGainCoeff");
					Node s = shgc.item(0); // solarIncidentAngle = "0"

					if (u.hasChildNodes() && s.hasChildNodes()) {
						Double d = Double.parseDouble(u.getTextContent());
						Double ds = Double.parseDouble(s.getTextContent());
						if (d != 0 && ds != 0) {
							wArrayList.add(id);
							wuArrayList.add(d);
							wshgcArrayList.add(ds);
						}
					} else {
						System.out.println("Error WindowType");
					}
				}
			}
		}

		nList = doc.getElementsByTagName("Campus");

		for (int i = 0; i < nList.getLength(); i++) {
			element = (Element) nList.item(i);

			if (element.hasChildNodes()) {
				nodeList = element.getElementsByTagName("Surface");

				for (int j = 0; j < nodeList.getLength(); j++) {
					Element temp = (Element) nodeList.item(j);
					String type = temp.getAttribute("surfaceType");

					if (type.equals("ExteriorWall")) {
						String cid = temp.getAttribute("constructionIdRef");
						if (cid != null) {
							int index = iArrayList.indexOf(cid);
							_model.getInfo().setU_wall(iuArrayList.get(index));
						} else {
							System.out.println("Error ExteriorWall constructionIdRef");
						}

						NodeList wNodeList = temp.getElementsByTagName("Opening");

						for (int k = 0; k < wNodeList.getLength(); k++) {
							Element w = (Element) wNodeList.item(k);
							String wid = w.getAttribute("windowTypeIdRef");
							if (wid != null) {
								int index = wArrayList.indexOf(wid);
								_model.getInfo().setU_window(wuArrayList.get(index));
								_model.getInfo().setSHGC(wshgcArrayList.get(index));
							} else {
								System.out.println("Error ExteriorWall Opening windowTypeIdRef");
							}

							String name = w.getElementsByTagName("Name").item(0).getTextContent();
							String testname = name;
							name = name.substring(0, 1);

							NodeList windowNodeList = w.getElementsByTagName("RectangularGeometry");
							double area1 = 0;
							Node width = null, height = null;

							for (int l = 0; l < windowNodeList.getLength(); l++) {
								Element a = (Element) windowNodeList.item(l);
								width = a.getElementsByTagName("Width").item(0);
								height = a.getElementsByTagName("Height").item(0);
							}

							area1 = Double.parseDouble(width.getTextContent())
									* Double.parseDouble(height.getTextContent());
							if (area1 == 0) {
								System.out.println("Error Opening RectangularGeometry width * height = 0");
								return;
							}
							System.out.println("window " + testname + " " + String.valueOf(area1)); //add test code
							if (name.equals("S")) {
								each_window_area[0] += area1;
							} else if (name.equals("W")) {
								each_window_area[1] += area1;
							} else if (name.equals("N")) {
								each_window_area[2] += area1;
							} else if (name.equals("E")) {
								each_window_area[3] += area1;
							} else {
								System.out.println("Error Opening Name");
							}
						}

						// http://help.autodesk.com/view/RVT/2016/KOR/?guid=GUID-B98B799E-EDCD-43B7-BAB3-953856BE43D0
						// Name 노드에 대한 관련 정보
						// ex) N-101-102-E-W-D-84
						// N = 방향 [N/NE/E/SE/S/SW/W/NW/N/T/B/X]
						// (북쪽 벡터에서 22.5도 섹터 내에 이는 모든 표면에서 문자 N 등을 가져옴) (위를 향하는
						// 수평 표면 상단은 문자 T, 아래를 향하는 수평 표면 하단은 문자 B) (음영 표면은 구분을
						// 위해 문자 X를 가져옴)

						String name = temp.getElementsByTagName("Name").item(0).getTextContent();
						String testname = name;
						name = name.substring(0, 1);

						NodeList shellNodeList = temp.getElementsByTagName("RectangularGeometry");
						double area2 = 0;
						Node width = null, height = null;

						for (int l = 0; l < shellNodeList.getLength(); l++) {
							if(width!=null && height!=null) break;
							Element a = (Element) shellNodeList.item(l);
							width = a.getElementsByTagName("Width").item(0);
							height = a.getElementsByTagName("Height").item(0);
						}

						area2 = Double.parseDouble(width.getTextContent()) * Double.parseDouble(height.getTextContent());
						if (area2 == 0) {
							System.out.println("Error ExteriorWall RectangularGeometry width * height = 0");
							return;
						}
						System.out.println("ExteriorWall " + testname + " " + String.valueOf(area2)); //add test code
						if (name.equals("S")) {
							each_shell_area[0] += area2;
						} else if (name.equals("W")) {
							each_shell_area[1] += area2;
						} else if (name.equals("N")) {
							each_shell_area[2] += area2;
						} else if (name.equals("E")) {
							each_shell_area[3] += area2;
						} else {
							System.out.println("Error ExteriorWall Name");
						}
						
					} else if (type.equals("InteriorFloor")) {
						String cid = temp.getAttribute("constructionIdRef");
						if (cid != null) {
							int index = iArrayList.indexOf(cid);
							_model.getInfo().setU_floor(iuArrayList.get(index));
							
							NodeList shellNodeList = temp.getElementsByTagName("RectangularGeometry");
							double area = 0;
							Node width = null, height = null;

							for (int l = 0; l < shellNodeList.getLength(); l++) {
								Element a = (Element) shellNodeList.item(l);
								width = a.getElementsByTagName("Width").item(0);
								height = a.getElementsByTagName("Height").item(0);
							}

							area = Double.parseDouble(width.getTextContent()) * Double.parseDouble(height.getTextContent());
							if (area == 0) {
								System.out.println("Error InteriorFloor RectangularGeometry width * height = 0");
								return;
							}
							total_area += area;
							//floor++;

						} else {
							System.out.println("Error InteriorFloor constructionIdRef");
						}
					} else if (type.equals("Roof")) {
						String cid = temp.getAttribute("constructionIdRef");
						if (cid != null) {
							int index = iArrayList.indexOf(cid);
							_model.getInfo().setU_roof(iuArrayList.get(index));
							
							NodeList shellNodeList = temp.getElementsByTagName("RectangularGeometry");
							double area = 0;
							Node width = null, height = null;

							for (int l = 0; l < shellNodeList.getLength(); l++) {
								Element a = (Element) shellNodeList.item(l);
								width = a.getElementsByTagName("Width").item(0);
								height = a.getElementsByTagName("Height").item(0);
							}

							area = Double.parseDouble(width.getTextContent()) * Double.parseDouble(height.getTextContent());
							if (area == 0) {
								System.out.println("Error Roof RectangularGeometry width * height = 0");
								return;
							}
							roof_area += area;
							
						} else {
							System.out.println("Error InteriorFloor constructionIdRef");
						}
					}
				}
			}
		}
		floor = (int) (Math.round( total_area / roof_area ));
		
		for (int i = 0; i < 4; i++) {
			each_wall_area[i] = each_shell_area[i] - each_window_area[i];
		}
				
		_model.getInfo().setEach_shell_area(each_shell_area);
		_model.getInfo().setEach_wall_area(each_wall_area);
		_model.getInfo().setEach_window_area(each_window_area);
		_model.getInfo().setArea(total_area);
		_model.getInfo().setRoof_area(roof_area);
		_model.getInfo().setFloor(floor);

		print();
	}
	
	public void print() {
		System.out.printf("Area : %-15f\n", _model.getInfo().getArea());
		System.out.printf("Roof_Area : %-15f\n", _model.getInfo().getRoof_area());
		System.out.printf("Floor : %-15d\n", _model.getInfo().getFloor());
		System.out.printf("외벽열관류율 : %-15f\n", _model.getInfo().getU_wall());
		System.out.printf("창호열관류율 : %-15f\n", _model.getInfo().getU_window());
		System.out.printf("지붕열관류율 : %-15f\n", _model.getInfo().getU_roof());
		System.out.printf("바닥열관류율 : %-15f\n", _model.getInfo().getU_floor());
		System.out.printf("SHGC : %-15f\n", _model.getInfo().getSHGC());
		System.out.printf("외피면적(N) : %-12f", _model.getInfo().getEach_shell_area()[0]);
		System.out.printf("외피면적(E) : %-12f", _model.getInfo().getEach_shell_area()[1]);
		System.out.printf("외피면적(S) : %-12f", _model.getInfo().getEach_shell_area()[2]);
		System.out.printf("외피면적(W) : %-12f\n", _model.getInfo().getEach_shell_area()[3]);
		System.out.printf("창면적(N) : %-13f", _model.getInfo().getEach_window_area()[0]);
		System.out.printf("창면적(E) : %-13f", _model.getInfo().getEach_window_area()[1]);
		System.out.printf("창면적(S) : %-13f", _model.getInfo().getEach_window_area()[2]);
		System.out.printf("창면적(W) : %-13f\n", _model.getInfo().getEach_window_area()[3]);
		System.out.printf("벽체면적(N) : %-12f", _model.getInfo().getEach_wall_area()[0]);
		System.out.printf("벽체면적(E) : %-12f", _model.getInfo().getEach_wall_area()[1]);
		System.out.printf("벽체면적(S) : %-12f", _model.getInfo().getEach_wall_area()[2]);
		System.out.printf("벽체면적(W) : %-12f\n", _model.getInfo().getEach_wall_area()[3]);

	}
}
