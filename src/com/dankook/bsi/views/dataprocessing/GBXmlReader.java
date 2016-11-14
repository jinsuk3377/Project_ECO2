/*     */ package com.dankook.bsi.views.dataprocessing;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.validation.Schema;
/*     */ import javax.xml.validation.SchemaFactory;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;

import com.dankook.bsi.exception.*;
import com.dankook.bsi.util.geometry.EDIVector3;
import com.dankook.bsi.util.greenbuilding.*;
/*     */ 
/*     */ public class GBXmlReader
/*     */ {
/*     */   public Document createDocumentFromFile(String gbxml_path)
/*     */     throws Exception
/*     */   {
/*     */     Document gbxmlDOM;
/*     */     try
/*     */     {
/*  36 */       gbxmlDOM = buildDOM(gbxml_path);
/*     */     }
/*     */     catch (SAXException e)
/*     */     {
/*  44 */       gbxmlDOM = null;
/*  45 */       throw new GBXmlLodingFailed();
/*     */     }
/*  47 */     return gbxmlDOM;
/*     */   }
/*     */ 
/*     */   private void ensureValidity(String gbxml_path)
/*     */     throws Exception
/*     */   {
/*  54 */     File gbxmlSchemaFile = new File("./data/GreenBuildingXML.xsd");
/*  55 */     Schema gbxmlSchema = loadGBXmlSchema(gbxmlSchemaFile);
/*     */ 
/*  57 */     JAXBContext jc = JAXBContext.newInstance(gbxml_path);
/*  58 */     Unmarshaller u = jc.createUnmarshaller();
/*  59 */     u.setSchema(gbxmlSchema);
/*     */   }
/*     */ 
/*     */   private Document buildDOM(String gbxml_path) throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  64 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  65 */     factory.setValidating(false);
/*  66 */     factory.setIgnoringElementContentWhitespace(true);
/*  67 */     DocumentBuilder builder = factory.newDocumentBuilder();
/*  68 */     return builder.parse(new InputSource(gbxml_path));
/*     */   }
/*     */ 
/*     */   private Schema loadGBXmlSchema(File gbxmlSchemaFile) throws SAXException
/*     */   {
/*  73 */     SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
/*  74 */     Schema gbxmlSchema = sf.newSchema(gbxmlSchemaFile);
/*  75 */     return gbxmlSchema;
/*     */   }
/*     */ 
/*     */   public GBXmlContext createGBXmlContext(Document doc) throws Exception
/*     */   {
/*  80 */     GBXmlContext gbxmlContext = new GBXmlContext();
/*  81 */     gbxmlContext.spaces = collectSpaces(doc);
/*  82 */     gbxmlContext.surfaces = collectSurfaces(doc);
/*  83 */     gbxmlContext.weekSchedules = collectWeekSchedules(doc);
/*  84 */     gbxmlContext.daySchedules = collectDaySchedulesFromXMLDocument(doc);
/*  85 */     gbxmlContext.schedules = collectSchedules(doc);
/*  86 */     gbxmlContext.zones = collectZonesFrom(doc);
/*  87 */     gbxmlContext.materials = collectMaterials(doc);
/*  88 */     gbxmlContext.windowTypes = collectWindowTypes(doc);
/*  89 */     gbxmlContext.location = collectLocation(doc);
/*  90 */     gbxmlContext.layerHashMap = computeLayers(doc);
/*  91 */     gbxmlContext.constructions = collectConstructions(doc);
/*  92 */     gbxmlContext.documentHistory = collectProgramInfo(doc);
/*     */ 
/*  94 */     return gbxmlContext;
/*     */   }
/*     */ 
/*     */   private HashMap<String, Surface> collectSurfaces(Document doc) throws Exception
/*     */   {
/*  99 */     HashMap gbxmlSurfaces = new HashMap();
/* 100 */     NodeList surfaceList = doc.getElementsByTagName("Surface");
/*     */ 
/* 102 */     for (int i = 0; i < surfaceList.getLength(); i++)
/*     */     {
/* 104 */       Node surfaceNode = surfaceList.item(i);
/* 105 */       Element surfaceElement = (Element)surfaceNode;
/*     */ 
/* 107 */       Surface surface = new Surface();
/* 108 */       surface.id = surfaceElement.getAttribute("id");
/*     */ 
/* 110 */       if (surfaceElement.getAttribute("surfaceType") != null) {
/* 111 */         surface.surfaceType = surfaceElement.getAttribute("surfaceType");
/*     */       }
/*     */ 
/* 114 */       if (surfaceElement.getAttribute("constructionIdRef") != null) {
/* 115 */         surface.constructionIdRef = surfaceElement
/* 116 */           .getAttribute("constructionIdRef");
/*     */       }
/*     */ 
/* 119 */       Node curSurfaceElement = surfaceNode.getFirstChild();
/* 120 */       while (curSurfaceElement != null)
/*     */       {
/* 123 */         if (curSurfaceElement.getNodeName().equals("AdjacentSpaceId"))
/*     */         {
/* 125 */           surface.adjacentSpaceIds.add(((Element)curSurfaceElement)
/* 126 */             .getAttribute("spaceIdRef"));
/*     */         }
/*     */ 
/* 129 */         if (curSurfaceElement.getNodeName().equals("PlanarGeometry"))
/*     */         {
/* 131 */           Node polyLoop = ((Element)curSurfaceElement).getElementsByTagName("PolyLoop").item(0);
/* 132 */           if (polyLoop == null) {
/* 133 */             throw new Exception();
/*     */           }
/* 135 */           surface.cartesianPoints = collectCatesianPointsPolyLoop(polyLoop);
/*     */         }
/*     */ 
/* 138 */         if (curSurfaceElement.getNodeName().equals("Opening"))
/*     */         {
/* 140 */           Opening opening = readOpening(curSurfaceElement);
/* 141 */           surface.getOpenings().add(opening);
/*     */         }
/* 121 */         curSurfaceElement = curSurfaceElement.getNextSibling();
/*     */       }
/*     */ 
/* 144 */       gbxmlSurfaces.put(surface.id, surface);
/*     */     }
/* 146 */     return gbxmlSurfaces;
/*     */   }
/*     */ 
/*     */   private Vector<EDIVector3> collectCatesianPointsPolyLoop(Node polyLoop)
/*     */     throws Exception
/*     */   {
/* 152 */     if (!polyLoop.getNodeName().equals("PolyLoop")) {
/* 153 */       throw new Exception();
/*     */     }
/* 155 */     Vector points = new Vector();
/*     */ 
/* 157 */     NodeList cartesians = polyLoop.getChildNodes();
/* 158 */     int cartesianPointIdx = 0;
/* 159 */     while (cartesianPointIdx < cartesians.getLength())
/*     */     {
/* 162 */       Node cartesianPoint = cartesians.item(cartesianPointIdx);
/* 163 */       if (cartesianPoint.getNodeName().equals("CartesianPoint"))
/*     */       {
/* 168 */         NodeList coordinates = ((Element)cartesianPoint).getElementsByTagName("Coordinate");
/* 169 */         EDIVector3 vec3Point = new EDIVector3();
/* 170 */         vec3Point.x = Double.valueOf(Double.parseDouble(coordinates.item(0).getTextContent()));
/* 171 */         vec3Point.y = Double.valueOf(Double.parseDouble(coordinates.item(1).getTextContent()));
/* 172 */         vec3Point.z = Double.valueOf(Double.parseDouble(coordinates.item(2).getTextContent()));
/*     */ 
/* 174 */         points.add(vec3Point);
/*     */       }
/* 160 */       cartesianPointIdx++;
/*     */     }
/*     */ 
/* 176 */     return points;
/*     */   }
/*     */ 
/*     */   Vector<Space> collectSpaces(Document doc)
/*     */   {
/* 181 */     NodeList spaceList = doc.getElementsByTagName("Space");
/* 182 */     Vector gbXmlSpaces = new Vector();
/*     */ 
/* 184 */     for (int i = 0; i < spaceList.getLength(); i++)
/*     */     {
/* 186 */       Element spaceElement = (Element)spaceList.item(i);
/*     */ 
/* 188 */       Space space = new Space(spaceElement.getAttribute("id"));
/* 189 */       space.setZoneIdRef(spaceElement.getAttribute("zoneIdRef"));
/* 190 */       space.peopleScheduleIdRef = spaceElement.getAttribute("peopleScheduleIdRef");
/* 191 */       space.lightScheduleIdRef = spaceElement.getAttribute("lightScheduleIdRef");
/* 192 */       space.equipmentScheduleIdRef = spaceElement.getAttribute("equipmentScheduleIdRef");
/*     */ 
/* 194 */       Node curSpaceElement = spaceElement.getFirstChild();
/* 195 */       while (curSpaceElement != null)
/*     */       {
/* 198 */         if (curSpaceElement.getNodeName().equals("Name")) {
/* 199 */           space.name = readContent(curSpaceElement);
/*     */         }
/* 201 */         if (curSpaceElement.getNodeName().equals("PeopleNumber")) {
/* 202 */           space.peopleNumber = curSpaceElement.getTextContent();
/*     */         }
/* 204 */         if (curSpaceElement.getNodeName().equals("LightPowerPerArea")) {
/* 205 */           space.LightPower = curSpaceElement.getTextContent();
/*     */         }
/* 207 */         if (curSpaceElement.getNodeName().equals("EquipPowerPerArea")) {
/* 208 */           space.EquipPower = curSpaceElement.getTextContent();
/*     */         }
/* 210 */         if (curSpaceElement.getNodeName().equals("PeopleHeatGain"))
/*     */         {
/* 212 */           PeopleHeatGain heatGain = new PeopleHeatGain();
/* 213 */           heatGain.unit = ((Element)curSpaceElement).getAttribute("unit");
/* 214 */           heatGain.heatGatinType = ((Element)curSpaceElement).getAttribute("heatGainType");
/* 215 */           heatGain.value = ((Element)curSpaceElement).getTextContent();
/*     */ 
/* 217 */           space.getPeopleHeatGains().add(heatGain);
/*     */         }
/* 196 */         curSpaceElement = curSpaceElement.getNextSibling();
/*     */       }
/*     */ 
/* 220 */       gbXmlSpaces.add(space);
/*     */     }
/* 222 */     return gbXmlSpaces;
/*     */   }
/*     */ 
/*     */   WindowType readWindowType(Element windowTypeElement)
/*     */   {
/* 228 */     WindowType newWindowType = new WindowType(windowTypeElement.getAttribute("id"));
/*     */ 
/* 230 */     Node elementOfWindowType = windowTypeElement.getFirstChild();
/* 231 */     while (elementOfWindowType != null)
/*     */     {
/* 234 */       if (elementOfWindowType.getNodeName().equals("U-value")) {
/* 235 */         newWindowType.setUValue(readContent(elementOfWindowType));
/*     */       }
/*     */ 
/* 238 */       if (elementOfWindowType.getNodeName().equals("SolarHeatGainCoeff")) {
/* 239 */         SolarHeatGainCoeff solarHeatGainCoeff = readSolarHeatGainCoeff(
/* 240 */           (Element)elementOfWindowType);
/* 241 */         newWindowType.addSolarHeatGainCoeff(solarHeatGainCoeff);
/*     */       }
/*     */ 
/* 244 */       if (elementOfWindowType.getNodeName().equals("Transmittance"))
/*     */       {
/* 246 */         newWindowType.setTransmittance(readContent(elementOfWindowType));
/*     */       }
/* 232 */       elementOfWindowType = elementOfWindowType.getNextSibling();
/*     */     }
/*     */ 
/* 249 */     return newWindowType;
/*     */   }
/*     */ 
/*     */   private String readContent(Node node) {
/* 253 */     return node.getTextContent();
/*     */   }
/*     */ 
/*     */   SolarHeatGainCoeff readSolarHeatGainCoeff(Element solarHeatGainCoeffElem)
/*     */   {
/* 258 */     SolarHeatGainCoeff solarHeatGainCoeff = new SolarHeatGainCoeff();
/* 259 */     solarHeatGainCoeff.value = Double.parseDouble(solarHeatGainCoeffElem.getTextContent());
/*     */ 
/* 261 */     solarHeatGainCoeff.unit = solarHeatGainCoeffElem.getAttribute("unit");
/*     */ 
/* 263 */     if (solarHeatGainCoeffElem.hasAttribute("solarIncidentAngle"))
/*     */     {
/* 265 */       solarHeatGainCoeff.solarIncidentAngle = solarHeatGainCoeffElem
/* 266 */         .getAttribute("solarIncidentAngle");
/*     */     }
/* 268 */     return solarHeatGainCoeff;
/*     */   }
/*     */ 
/*     */   Vector<WindowType> collectWindowTypes(Document doc)
/*     */   {
/* 273 */     Vector windowTypes = new Vector();
/* 274 */     NodeList windowTypeNodes = doc.getElementsByTagName("WindowType");
/* 275 */     for (int i = 0; i < windowTypeNodes.getLength(); i++)
/*     */     {
/* 277 */       Element windowTypeElem = (Element)windowTypeNodes.item(i);
/* 278 */       WindowType windowType = readWindowType(windowTypeElem);
/*     */ 
/* 280 */       Node nodeOfWindowType = windowTypeElem.getFirstChild();
/* 281 */       while (nodeOfWindowType != null)
/*     */       {
/* 284 */         if (nodeOfWindowType.getNodeName().equals("Name"))
/*     */         {
/* 286 */           windowType.name = nodeOfWindowType.getTextContent();
/*     */         }
/* 282 */         nodeOfWindowType = nodeOfWindowType.getNextSibling();
/*     */       }
/*     */ 
/* 289 */       windowTypes.add(windowType);
/*     */     }
/* 291 */     return windowTypes;
/*     */   }
/*     */ 
/*     */   private Vector<Zone> collectZonesFrom(Document doc)
/*     */   {
/* 296 */     Vector zones = new Vector();
/* 297 */     NodeList zoneNodes = doc.getElementsByTagName("Zone");
/* 298 */     for (int i = 0; i < zoneNodes.getLength(); i++)
/*     */     {
/* 300 */       Element zoneElement = (Element)zoneNodes.item(i);
/* 301 */       Zone zone = new Zone(zoneElement.getAttribute("id"));
/*     */ 
/* 303 */       Node nodeOfZone = zoneElement.getFirstChild();
/* 304 */       while (nodeOfZone != null)
/*     */       {
/* 307 */         if (nodeOfZone.getNodeName().equals("AirChangesPerHour")) {
/* 308 */           zone.airChangesPerHour = nodeOfZone.getTextContent();
/*     */         }
/* 310 */         if (nodeOfZone.getNodeName().equals("DesignHeatT")) {
/* 311 */           zone.designHeatT = nodeOfZone.getTextContent();
/*     */         }
/* 313 */         if (nodeOfZone.getNodeName().equals("DesignCoolT"))
/* 314 */           zone.designCoolT = nodeOfZone.getTextContent();
/* 305 */         nodeOfZone = nodeOfZone.getNextSibling();
/*     */       }
/*     */ 
/* 317 */       zones.add(zone);
/*     */     }
/* 319 */     return zones;
/*     */   }
/*     */ 
/*     */   Location collectLocation(Document xmlDocument)
/*     */   {
/* 324 */     Location location = new Location();
/* 325 */     Node locationNode = xmlDocument.getElementsByTagName("Location").item(0);
/*     */ 
/* 327 */     Node nodeOfLocation = locationNode.getFirstChild();
/* 328 */     while (nodeOfLocation != null)
/*     */     {
/* 331 */       String elementName = nodeOfLocation.getNodeName();
/*     */ 
/* 333 */       if (elementName.equals("Name")) {
/* 334 */         location.setName(nodeOfLocation.getTextContent());
/*     */       }
/*     */ 
/* 337 */       if (elementName.equals("Latitude")) {
/* 338 */         location.setLatitude(nodeOfLocation.getTextContent());
/*     */       }
/*     */ 
/* 341 */       if (elementName.equals("Longitude")) {
/* 342 */         location.setLongitude(nodeOfLocation.getTextContent());
/*     */       }
/*     */ 
/* 345 */       if (elementName.equals("CADModelAzimuth"))
/* 346 */         location.setCADModelAzimuth(nodeOfLocation.getTextContent());
/* 329 */       nodeOfLocation = nodeOfLocation.getNextSibling();
/*     */     }
/*     */ 
/* 349 */     return location;
/*     */   }
/*     */ 
/*     */   public Vector<Material> collectMaterials(Document doc) {
/* 353 */     assert (doc != null);
/* 354 */     NodeList materialNodes = doc.getElementsByTagName("Material");
/* 355 */     Vector materials = new Vector();
/*     */ 
/* 357 */     for (int i = 0; i < materialNodes.getLength(); i++)
/*     */     {
/* 359 */       Element elementMaterial = (Element)materialNodes.item(i);
/*     */ 
/* 361 */       Material material = new Material(elementMaterial.getAttribute("id"));
/* 362 */       Node elementOfMaterial = elementMaterial.getFirstChild();
/* 363 */       while (elementOfMaterial != null)
/*     */       {
/* 366 */         if (elementOfMaterial.getNodeName().equals("Thickness"))
/* 367 */           material.M_Thcikness = elementOfMaterial.getTextContent();
/* 368 */         if (elementOfMaterial.getNodeName().equals("Conductivity"))
/* 369 */           material.M_Conductivity = elementOfMaterial.getTextContent();
/* 370 */         if (elementOfMaterial.getNodeName().equals("Density"))
/* 371 */           material.M_Density = elementOfMaterial.getTextContent();
/* 372 */         if (elementOfMaterial.getNodeName().equals("SpecificHeat"))
/* 373 */           material.M_SpecificHeat = elementOfMaterial.getTextContent();
/* 374 */         if (elementOfMaterial.getNodeName().equals("R-value"))
/* 375 */           material.R_Value = elementOfMaterial.getTextContent();
/* 364 */         elementOfMaterial = elementOfMaterial.getNextSibling();
/*     */       }
/*     */ 
/* 378 */       materials.add(material);
/*     */     }
/* 380 */     return materials;
/*     */   }
/*     */ 
/*     */   Vector<WeekSchedule> collectWeekSchedules(Document doc)
/*     */   {
/* 385 */     NodeList weekScheduleNodes = doc.getElementsByTagName("WeekSchedule");
/*     */ 
/* 387 */     Vector weekSchedules = new Vector();
/* 388 */     for (int i = 0; i < weekScheduleNodes.getLength(); i++)
/*     */     {
/* 390 */       Element weekScheduleElement = (Element)weekScheduleNodes.item(i);
/*     */ 
/* 392 */       WeekSchedule weekSchedule = new WeekSchedule(
/* 393 */         weekScheduleElement.getAttribute("id"), 
/* 394 */         weekScheduleElement.getAttribute("type"));
/*     */ 
/* 396 */       Element dayElement = (Element)weekScheduleElement.getElementsByTagName("Day").item(0);
/* 397 */       weekSchedule.day = 
/* 398 */         new Day(dayElement.getAttribute("dayType"), 
/* 398 */         dayElement.getAttribute("dayScheduleIdRef"));
/*     */ 
/* 400 */       weekSchedules.add(weekSchedule);
/*     */     }
/* 402 */     return weekSchedules;
/*     */   }
/*     */ 
/*     */   Vector<DaySchedule> collectDaySchedulesFromXMLDocument(Document doc) throws Exception
/*     */   {
/* 407 */     NodeList dayScheduleNodes = doc.getElementsByTagName("DaySchedule");
/*     */ 
/* 409 */     Vector daySchedules = new Vector();
/* 410 */     for (int i = 0; i < dayScheduleNodes.getLength(); i++)
/*     */     {
/* 412 */       Node curDaySchedule = dayScheduleNodes.item(i);
/* 413 */       DaySchedule daySchedule = new DaySchedule(
/* 414 */         ((Element)dayScheduleNodes.item(i)).getAttribute("id"), 
/* 415 */         ((Element)dayScheduleNodes.item(i)).getAttribute("type"));
/*     */ 
/* 417 */       daySchedule.scheduleValues = new String[24];
/* 418 */       NodeList daySchileValueNodes = curDaySchedule.getChildNodes();
/*     */ 
/* 420 */       int dayIndex = 0;
/* 421 */       for (int a = 0; a < daySchileValueNodes.getLength(); a++)
/*     */       {
/* 423 */         Node daySchileValueNode = daySchileValueNodes.item(a);
/* 424 */         if (daySchileValueNode.getNodeType() != 1)
/*     */           continue;
/* 426 */         daySchedule.scheduleValues[(dayIndex++)] = daySchileValueNode.getTextContent();
/*     */       }
/* 428 */       daySchedules.add(daySchedule);
/*     */     }
/* 430 */     return daySchedules;
/*     */   }
/*     */ 
/*     */   private String collectProgramInfo(Document doc)
/*     */   {
/* 436 */     NodeList ProgramNameList = doc.getElementsByTagName("ProductName");
/* 437 */     if (ProgramNameList.getLength() > 0) {
/* 438 */       Element programInfoElem = (Element)ProgramNameList.item(0);
/* 439 */       String productName = programInfoElem.getTextContent();
/* 440 */       return productName;
/*     */     }
/* 442 */     return "";
/*     */   }
/*     */ 
/*     */   public Vector<Construction> collectConstructions(Document doc) {
/* 446 */     NodeList constructionNodes = doc.getElementsByTagName("Construction");
/*     */ 
/* 448 */     Vector constructions = new Vector();
/* 449 */     int constructionIndex = 0;
/* 450 */     while (constructionIndex < constructionNodes.getLength())
/*     */     {
/* 453 */       Element elementConstruction = (Element)constructionNodes.item(constructionIndex);
/* 454 */       Construction construction = new Construction(elementConstruction.getAttribute("id"));
/*     */ 
/* 456 */       Node nodeOfConstruction = elementConstruction.getFirstChild();
/* 457 */       while (nodeOfConstruction != null)
/*     */       {
/* 460 */         if (nodeOfConstruction.getNodeName().equals("LayerId"))
/*     */         {
/* 462 */           String layerId = ((Element)nodeOfConstruction).getAttribute("layerIdRef");
/* 463 */           construction.getLayerIds().add(layerId);
/*     */         }
/* 458 */         nodeOfConstruction = nodeOfConstruction.getNextSibling();
/*     */       }
/*     */ 
/* 466 */       constructions.add(construction);
/*     */ 
/* 451 */       constructionIndex++;
/*     */     }
/*     */ 
/* 468 */     return constructions;
/*     */   }
/*     */ 
/*     */   Vector<Schedule> collectSchedules(Document doc)
/*     */   {
/* 473 */     Vector schedules = new Vector();
/*     */ 
/* 475 */     NodeList scheduleNodes = doc.getElementsByTagName("Schedule");
/* 476 */     for (int i = 0; i < scheduleNodes.getLength(); i++)
/*     */     {
/* 478 */       Element scheduleElement = (Element)scheduleNodes.item(i);
/* 479 */       Schedule schedule = new Schedule(scheduleElement.getAttribute("id"), 
/* 480 */         scheduleElement.getAttribute("type"));
/*     */ 
/* 482 */       if (scheduleElement.getElementsByTagName("Name").getLength() == 1) {
/* 483 */         schedule.name = scheduleElement.getElementsByTagName("Name").item(0).getTextContent();
/*     */       }
/*     */ 
/* 486 */       Element yearScheduleElem = (Element)scheduleElement.getElementsByTagName("YearSchedule").item(0);
/* 487 */       YearSchedule yearSchedule = new YearSchedule(yearScheduleElem.getAttribute("id"));
/* 488 */       yearSchedule.beginDateString = yearScheduleElem.getElementsByTagName("BeginDate").item(0).getTextContent();
/* 489 */       yearSchedule.endDateString = yearScheduleElem.getElementsByTagName("EndDate").item(0).getTextContent();
/* 490 */       yearSchedule.weekScheduleIdRef = ((Element)yearScheduleElem.getElementsByTagName("WeekScheduleId").item(0))
/* 491 */         .getAttribute("weekScheduleIdRef");
/* 492 */       schedule.yearSchedule = yearSchedule;
/* 493 */       schedules.add(schedule);
/*     */     }
/* 495 */     return schedules;
/*     */   }
/*     */ 
/*     */   HashMap<String, Layer> computeLayers(Document doc)
/*     */   {
/* 500 */     NodeList layerNodes = doc.getElementsByTagName("Layer");
/* 501 */     HashMap layerHashMap = new HashMap();
/*     */ 
/* 503 */     for (int i = 0; i < layerNodes.getLength(); i++)
/*     */     {
/* 505 */       Element elementLayer = (Element)layerNodes.item(i);
/* 506 */       Layer layer = new Layer();
/*     */ 
/* 508 */       layer.materials = new ArrayList();
/* 509 */       Node nn = elementLayer.getFirstChild();
/* 510 */       while (nn != null)
/*     */       {
/* 513 */         if (nn.getNodeName().equals("MaterialId"))
/*     */         {
/* 515 */           String materialIdRef = ((Element)nn).getAttribute("materialIdRef");
/* 516 */           layer.materials.add(materialIdRef);
/*     */         }
/* 511 */         nn = nn.getNextSibling();
/*     */       }
/*     */ 
/* 519 */       layerHashMap.put(elementLayer.getAttribute("id"), layer);
/*     */     }
/* 521 */     return layerHashMap;
/*     */   }
/*     */ 
/*     */   Opening readOpening(Node nodeOfSurface) throws Exception
/*     */   {
/* 526 */     Opening opening = new Opening();
/* 527 */     Element openingElement = (Element)nodeOfSurface;
/* 528 */     opening.windowtypeIdRef = openingElement.getAttribute("windowTypeIdRef");
/* 529 */     opening.id = openingElement.getAttribute("id");
/*     */ 
/* 531 */     Node elementOfOpening = openingElement.getFirstChild();
/* 532 */     while (elementOfOpening != null)
/*     */     {
/* 535 */       if (elementOfOpening.getNodeName().equals("Name")) {
/* 536 */         opening.openingName = elementOfOpening.getTextContent();
/*     */       }
/* 538 */       if (elementOfOpening.getNodeName().equals("PlanarGeometry"))
/*     */       {
/* 540 */         Element polyLoop = (Element)((Element)elementOfOpening)
/* 541 */           .getElementsByTagName("PolyLoop").item(0);
/* 542 */         opening.points = collectCatesianPointsPolyLoop(polyLoop);
/*     */       }
/* 533 */       elementOfOpening = elementOfOpening.getNextSibling();
/*     */     }
/*     */ 
/* 545 */     return opening;
/*     */   }
/*     */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GBXmlReader
 * JD-Core Version:    0.6.0
 */