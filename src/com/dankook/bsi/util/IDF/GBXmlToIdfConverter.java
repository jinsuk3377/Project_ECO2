/*     */ package com.dankook.bsi.util.IDF;
/*     */ 
/*     */ import com.dankook.bsi.util.greenbuilding.*;
/*     */ import com.dankook.bsi.util.IDF.*;
import com.dankook.bsi.util.IDF.unit.Degree;

/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ import org.w3c.dom.Document;

import com.dankook.bsi.views.dataprocessing.GBXmlReader;
/*     */ 
/*     */ public class GBXmlToIdfConverter
/*     */ {
/*     */   GBXmlReader _xmlReader;
/* 370 */   int numberOfNodePerZone = 3;
/*     */ 
/* 469 */   private Boolean SHEP = Boolean.valueOf(false);
/*     */ 
/*     */   public GBXmlToIdfConverter()
/*     */   {
/*  24 */     this._xmlReader = new GBXmlReader();
/*     */   }
/*     */ 
/*     */   public void convertFromGbXmlToIdf(String gbxml_path, String destFilePath)
/*     */   {
/*     */     try {
/*  30 */       Document doc = this._xmlReader.createDocumentFromFile(gbxml_path);
/*  31 */       GBXmlContext gbxml = this._xmlReader.createGBXmlContext(doc);
/*  32 */       IDF idf = convert(gbxml);
/*  33 */       IdfFileWriter idfWriter = new IdfFileWriter(idf);
/*  34 */       StringBuffer idfFileText = idfWriter.getIdfFileTextFrom();
/*  35 */       idfWriter.writeIdfFile(idfFileText, destFilePath);
/*     */     } catch (Exception e) {
/*  37 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public IDF convert(GBXmlContext gbxml)
/*     */   {
/*  43 */     if (gbxml.documentHistory.equals("SHEP")) {
/*  44 */       this.SHEP = Boolean.valueOf(true);
/*     */     }
/*  46 */     IDF idf = new IDF();
/*  47 */     makeBuildingFromLocation(gbxml.location, idf);
/*  48 */     idf.setZones(makeZonesFromSpace(gbxml.spaces));
/*  49 */     idf.buildingSurfaces = makeBuildingSurfacesFrom(gbxml.surfaces);
/*     */ 
/*  51 */     build_IdfZoneAndBuildingSurface_Relation(idf.getZones(), idf.buildingSurfaces);
/*     */ 
/*  53 */     idf.zoneLists = makeZoneListBySpacesAndZones(gbxml.spaces, gbxml.zones);
/*  54 */     idf.siteLocation = makeSiteLocationFrom(gbxml.location);
/*  55 */     idf.scheduleDayHourlys = makeScheduleDayHourlys(gbxml.daySchedules);
/*  56 */     idf.scheduleWeekDailies = makeScheduleWeekDaily(gbxml.weekSchedules);
/*  57 */     idf.scheduleYears = makeScheduleYear(gbxml.schedules);
/*  58 */     idf.idfMaterials = makeIdfMaterialsFrom(gbxml.materials);
/*     */ 
/*  60 */     idf.windowMaterials = makeWindowMaterialsFrom(gbxml.windowTypes);
/*     */ 
/*  62 */     idf.constructions.addAll(makeConstructionsFrom(idf.windowMaterials));
/*  63 */     idf.constructions.addAll(makeConstructionsFrom(gbxml.constructions, gbxml.layerHashMap));
/*     */ 
/*  65 */     readZoneVentilations(gbxml.zones, idf);
/*  66 */     return idf;
/*     */   }
/*     */ 
/*     */   private void makeBuildingFromLocation(Location location, IDF idf)
/*     */   {
/*  71 */     if (!location.getCADmodelAzimuth().equals(""))
/*     */     {
/*  73 */       idf.getBuilding().northAxis = new Degree(location.getCADmodelAzimuth());
/*     */     }
/*     */   }
/*     */ 
/*     */   public HashMap<String, IdfZone> makeZonesFromSpace(Vector<Space> spaces)
/*     */   {
/*  79 */     HashMap idfZones = new HashMap();
/*     */ 
/*  81 */     int spaceIndex = 0;
/*  82 */     for (Space space : spaces)
/*     */     {
/*  84 */       IdfZone newIdfZone = makeIdfZoneFrom(space, spaceIndex);
/*  85 */       idfZones.put(newIdfZone.name, newIdfZone);
/*     */ 
/*  87 */       spaceIndex++;
/*     */     }
/*  89 */     return idfZones;
/*     */   }
/*     */ 
/*     */   public HashMap<String, BuildingSurface> makeBuildingSurfacesFrom(HashMap<String, Surface> gbXmlSurfaces)
/*     */   {
/*  95 */     HashMap buildingSurfaces = 
/*  96 */       new HashMap();
/*     */ 
/*  98 */     for (String curSurfaceKey : gbXmlSurfaces.keySet())
/*     */     {
/* 100 */       Surface surface = (Surface)gbXmlSurfaces.get(curSurfaceKey);
/*     */ 
/* 102 */       BuildingSurface buildingSurface = makeBuildingSurfaceFrom(surface);
/* 103 */       buildingSurfaces.put(buildingSurface.name, buildingSurface);
/*     */     }
/* 105 */     return buildingSurfaces;
/*     */   }
/*     */ 
/*     */   public void build_IdfZoneAndBuildingSurface_Relation(HashMap<String, IdfZone> idfZones, HashMap<String, BuildingSurface> buildingSurfaces)
/*     */   {
/* 117 */     Vector <BuildingSurface>newSurfaces = new Vector();
/*     */ 
/* 119 */     for (String currentSurfaceName : buildingSurfaces.keySet())
/*     */     {
/* 121 */       BuildingSurface currentSurface = (BuildingSurface)buildingSurfaces.get(currentSurfaceName);
/*     */ 
/* 123 */       IdfZone targetZone = (IdfZone)idfZones.get(currentSurface.zoneNames.get(0));
/* 124 */       targetZone.buildingSurfaces.add(currentSurface);
/*     */ 
/* 126 */       if (currentSurface.boundaryCondition != "Surface")
/*     */         continue;
/* 128 */       BuildingSurface newSurface = currentSurface.clone();
/* 129 */       newSurfaces.add(newSurface);
/*     */ 
/* 131 */       IdfZone anotherZoneToAdd = (IdfZone)idfZones.get(currentSurface.zoneNames.get(1));
/* 132 */       anotherZoneToAdd.buildingSurfaces.add(newSurface);
/*     */ 
/* 134 */       newSurface.boundaryConditionObject = currentSurface.name;
/* 135 */       newSurface.zoneNames.remove(0);
/*     */ 
/* 137 */       Collections.reverse(newSurface.vertices);
/*     */ 
/* 139 */       currentSurface.boundaryConditionObject = newSurface.name;
/* 140 */       currentSurface.zoneNames.remove(1);
/*     */ 
/* 142 */       if (!currentSurface.surfaceType.equals("Floor"))
/*     */         continue;
/* 144 */       currentSurface.surfaceType = "Ceiling";
/*     */     }
/*     */ 
/* 149 */     for (BuildingSurface curNewSurface : newSurfaces)
/*     */     {
/* 151 */       buildingSurfaces.put(curNewSurface.name, curNewSurface);
/*     */     }
/*     */   }
/*     */ 
/*     */   public HashMap<String, IdfZoneList> makeZoneListBySpacesAndZones(Vector<Space> spaces, Vector<Zone> zones)
/*     */   {
/* 160 */     HashMap zoneLists = new HashMap();
/*     */ 
/* 162 */     for (Zone zone : zones)
/*     */     {
/* 164 */       IdfZoneList zoneList = new IdfZoneList(zone.id());
/*     */ 
/* 166 */       zoneList.zoneControl = createDefaultZoneControl(zoneList);
/* 167 */       zoneList.thermostatSetpoints = createDefaultThermostatSetPoints(zoneList);
/* 168 */       zoneList.scheduleCompacts.add(createDefaultHeatingScheduleCompact(zone));
/* 169 */       zoneList.scheduleCompacts.add(createDefaultCoolingScheduleCompact(zone));
/*     */ 
/* 171 */       zoneLists.put(zoneList.id(), zoneList);
/*     */     }
/*     */ 
/* 174 */     for (Space space : spaces) {
/* 175 */       IdfZoneList zoneListSpaceOn = (IdfZoneList)zoneLists.get(space.getZoneIdRef());
/* 176 */       zoneListSpaceOn.addZoneIdRef(space.id());
/*     */     }
/* 178 */     return zoneLists;
/*     */   }
/*     */ 
/*     */   private ZoneControl createDefaultZoneControl(IdfZoneList zone)
/*     */   {
/* 183 */     ZoneControl zoneControl = new ZoneControl();
/* 184 */     zoneControl.name = (zone.id() + " Thermostat");
/* 185 */     zoneControl.zoneOrZoneListName = zone.id();
/* 186 */     zoneControl.controlTypeScheduleName = "Zone Control Type Sched";
/*     */ 
/* 188 */     ControlObject controlObject = new ControlObject();
/* 189 */     controlObject.type = "ThermostatSetpoint:SingleHeating";
/* 190 */     controlObject.name = (zone.id() + "Heating Setpoint with SB");
/* 191 */     zoneControl.controlObjects.add(controlObject);
/*     */ 
/* 193 */     controlObject = new ControlObject();
/* 194 */     controlObject.type = "ThermostatSetpoint:SingleCooling";
/* 195 */     controlObject.name = (zone.id() + "Cooling Setpoint with SB");
/* 196 */     zoneControl.controlObjects.add(controlObject);
/* 197 */     return zoneControl;
/*     */   }
/*     */ 
/*     */   private Vector<ThermostatSetpoint> createDefaultThermostatSetPoints(IdfZoneList zone)
/*     */   {
/* 203 */     Vector thermostatSetpoints = new Vector();
/* 204 */     ThermostatSetpoint thermostatSetpoint = new ThermostatSetpoint();
/* 205 */     thermostatSetpoint.type = "SingleCooling";
/* 206 */     thermostatSetpoint.name = (zone.id() + "Cooling Setpoint with SB");
/* 207 */     thermostatSetpoint.setpointTemperatureScheduleName = (zone.id() + "Cooling Setpoints");
/* 208 */     thermostatSetpoints.add(thermostatSetpoint);
/*     */ 
/* 210 */     ThermostatSetpoint thermostatSetpoint2 = new ThermostatSetpoint();
/* 211 */     thermostatSetpoint2.type = "SingleHeating";
/* 212 */     thermostatSetpoint2.name = (zone.id() + "Heating Setpoint with SB");
/* 213 */     thermostatSetpoint2.setpointTemperatureScheduleName = (zone.id() + "Heating Setpoints");
/* 214 */     thermostatSetpoints.add(thermostatSetpoint2);
/* 215 */     return thermostatSetpoints;
/*     */   }
/*     */ 
/*     */   private void readZoneVentilations(Vector<Zone> zones, IDF idf)
/*     */   {
/* 220 */     Vector zoneVentilations = idf.getZoneVentilations();
/* 221 */     for (Zone zone : zones)
/*     */     {
/* 223 */       if (zone.airChangesPerHour.equals(""))
/*     */         continue;
/* 225 */       ZoneVentilation zoneVentilation = new ZoneVentilation();
/* 226 */       zoneVentilation.name = (zone.id() + "_Ventilation");
/* 227 */       zoneVentilation.zoneListName = zone.id();
/* 228 */       zoneVentilation.setAirChangePerHour(Double.valueOf(Double.parseDouble(zone.airChangesPerHour)));
/*     */ 
/* 230 */       zoneVentilations.add(zoneVentilation);
/*     */     }
/*     */   }
/*     */ 
/*     */   private ScheduleCompact createDefaultHeatingScheduleCompact(Zone zone)
/*     */   {
/* 239 */     ScheduleCompact scheduleCompact = new ScheduleCompact();
/* 240 */     scheduleCompact.name = (zone.id() + "Heating Setpoints");
/* 241 */     scheduleCompact.scheduleTypeLimitsName = "Temperature";
/* 242 */     Through through = new Through();
/* 243 */     through.date = "12/31";
/*     */ 
/* 245 */     For forday = new For();
/* 246 */     forday.day = "AllDays";
/* 247 */     forday.untils.add(new Until("7:00", 15.0D));
/* 248 */     forday.untils.add(new Until("17:00", Double.parseDouble(zone.designHeatT)));
/* 249 */     forday.untils.add(new Until("24:00", 15.0D));
/* 250 */     through.fors.add(forday);
/*     */ 
/* 252 */     scheduleCompact.throughs.add(through);
/* 253 */     return scheduleCompact;
/*     */   }
/*     */ 
/*     */   private ScheduleCompact createDefaultCoolingScheduleCompact(Zone zone)
/*     */   {
/* 259 */     ScheduleCompact scheduleCompact = new ScheduleCompact();
/* 260 */     scheduleCompact.name = (zone.id() + "Cooling Setpoints");
/* 261 */     scheduleCompact.scheduleTypeLimitsName = "Temperature";
/* 262 */     Through through = new Through();
/* 263 */     through.date = "12/31";
/*     */ 
/* 265 */     For forday = new For();
/* 266 */     forday.day = "AllDays";
/* 267 */     forday.untils.add(new Until("7:00", 30.0D));
/* 268 */     forday.untils.add(new Until("20:00", Double.parseDouble(zone.designCoolT)));
/* 269 */     forday.untils.add(new Until("24:00", 30.0D));
/* 270 */     through.fors.add(forday);
/*     */ 
/* 272 */     scheduleCompact.throughs.add(through);
/* 273 */     return scheduleCompact;
/*     */   }
/*     */ 
/*     */   public IdfZone makeIdfZoneFrom(Space space, int spaceIndex)
/*     */   {
/* 278 */     IdfZone idfZone = new IdfZone();
/* 279 */     idfZone.name = space.id();
/* 280 */     buildInternalGainsInto(idfZone, space);
/* 281 */     buildZoneForcedAirUnits(idfZone, space, spaceIndex);
/* 282 */     buildZoneEquipment(idfZone, space, spaceIndex);
/*     */ 
/* 284 */     idfZone.scheduleCompact = makeScheduleCompactFrom(space);
/*     */ 
/* 286 */     return idfZone;
/*     */   }
/*     */ 
/*     */   private ScheduleCompact makeScheduleCompactFrom(Space space)
/*     */   {
/* 292 */     if (space.getTotalPeopleHeatGain() == "") {
/* 293 */       return null;
/*     */     }
/* 295 */     ScheduleCompact scheduleCompact = new ScheduleCompact();
/* 296 */     scheduleCompact.name = (space.id() + "_ActSch");
/* 297 */     scheduleCompact.scheduleTypeLimitsName = "Any Number";
/*     */ 
/* 300 */     Through through = new Through();
/* 301 */     through.date = "12/31";
/*     */ 
/* 304 */     For scheduleFor = new For();
/* 305 */     scheduleFor.day = "AllDays";
/* 306 */     scheduleFor.untils.add(new Until("24:00", Double.parseDouble(space.getTotalPeopleHeatGain())));
/*     */ 
/* 308 */     through.fors.add(scheduleFor);
/*     */ 
/* 310 */     scheduleCompact.throughs.add(through);
/*     */ 
/* 312 */     return scheduleCompact;
/*     */   }
/*     */ 
/*     */   private void buildZoneForcedAirUnits(IdfZone idfZone, Space space, int spaceIndex)
/*     */   {
/* 318 */     idfZone.idealLoadsAirSystem = makeIdealLoadsAirSystem(space, spaceIndex);
/*     */   }
/*     */ 
/*     */   private void buildZoneEquipment(IdfZone idfZone, Space space, int spaceIndex)
/*     */   {
/* 323 */     idfZone.equipmentList = makeEquipmentListFrom(space);
/* 324 */     idfZone.equipmentConnections = makeEquipmentConnectionsFrom(space, spaceIndex);
/*     */   }
/*     */ 
/*     */   private void buildInternalGainsInto(IdfZone idfZone, Space space)
/*     */   {
/* 329 */     idfZone.people = makePeopleFrom(space);
/* 330 */     idfZone.lights = makeLightsFrom(space);
/* 331 */     idfZone.electricEquipment = makeElectricEquipmentFrom(space);
/*     */   }
/*     */ 
/*     */   private Lights makeLightsFrom(Space space)
/*     */   {
/* 336 */     Lights lights = new Lights();
/* 337 */     lights.name = (space.id() + " Lights");
/* 338 */     lights.zoneOrZoneListName = space.id();
/* 339 */     lights.scheduleName = space.lightScheduleIdRef;
/* 340 */     lights.designLevelCalculationMethod = "Watts/Area";
/* 341 */     lights.wattsPerZoneFloorArea = space.LightPower;
/* 342 */     return lights;
/*     */   }
/*     */ 
/*     */   private People makePeopleFrom(Space space)
/*     */   {
/* 347 */     People people = new People();
/* 348 */     people.name = (space.id() + " People");
/* 349 */     people.zoneOrZoneListName = space.id();
/* 350 */     people.numberOfPeopleScheduleName = space.peopleScheduleIdRef;
/* 351 */     people.numberOfPeople = space.peopleNumber;
/* 352 */     people.activityLevelScheduleName = (space.id() + "_ActSch");
/* 353 */     return people;
/*     */   }
/*     */ 
/*     */   private IdealLoadsAirSystem makeIdealLoadsAirSystem(Space space, int spaceIndex)
/*     */   {
/* 359 */     IdealLoadsAirSystem idealLoadsAirSystem = new IdealLoadsAirSystem();
/* 360 */     idealLoadsAirSystem.name = (space.id() + " Air");
/* 361 */     idealLoadsAirSystem.zoneSupplyAirzNodeName = ("NODE_" + spaceIndex * this.numberOfNodePerZone);
/*     */ 
/* 363 */     idealLoadsAirSystem.heatingSupplyAirTemperature = "50";
/* 364 */     idealLoadsAirSystem.coolingSupplyAirTemperature = "13";
/* 365 */     idealLoadsAirSystem.heatingSupplyAirHumidityRatio = Double.valueOf(0.015D);
/* 366 */     idealLoadsAirSystem.coolingSupplyAirHumidityRatio = Double.valueOf(0.01D);
/* 367 */     return idealLoadsAirSystem;
/*     */   }
/*     */ 
/*     */   private EquipmentConnections makeEquipmentConnectionsFrom(Space space, int spaceIndex)
/*     */   {
/* 376 */     EquipmentConnections equipmentConnections = new EquipmentConnections();
/* 377 */     equipmentConnections.zoneName = space.id();
/* 378 */     equipmentConnections.conditioningEquipmentListName = (space.id() + " Equipment");
/* 379 */     equipmentConnections.zoneAirInletNodeOrNodeListName = ("NODE_" + spaceIndex * this.numberOfNodePerZone);
/* 380 */     equipmentConnections.airExhaustNodeOrNodeListName = "";
/* 381 */     equipmentConnections.airNodeName = ("NODE_" + (spaceIndex * this.numberOfNodePerZone + 1));
/* 382 */     equipmentConnections.returnAirNodeName = ("NODE_" + (spaceIndex * this.numberOfNodePerZone + 2));
/* 383 */     return equipmentConnections;
/*     */   }
/*     */ 
/*     */   private EquipmentList makeEquipmentListFrom(Space space)
/*     */   {
/* 389 */     EquipmentList equipmentList = new EquipmentList();
/* 390 */     equipmentList.name = (space.id() + " Equipment");
/*     */ 
/* 393 */     ZoneEquipment newZoneEquipment = new ZoneEquipment();
/* 394 */     newZoneEquipment.objectType = "ZoneHVAC:IdealLoadsAirSystem";
/* 395 */     newZoneEquipment.name = (space.id() + " Air");
/* 396 */     newZoneEquipment.coolingSequence = Integer.valueOf(1);
/* 397 */     newZoneEquipment.heatingOrNoLoadSequence = Integer.valueOf(1);
/*     */ 
/* 399 */     equipmentList.zoneEquipments.add(newZoneEquipment);
/*     */ 
/* 401 */     return equipmentList;
/*     */   }
/*     */ 
/*     */   private ElectricEquipment makeElectricEquipmentFrom(Space space)
/*     */   {
/* 406 */     ElectricEquipment electricEquipment = new ElectricEquipment();
/* 407 */     electricEquipment.name = (space.id() + " ElecEq");
/* 408 */     electricEquipment.zoneOrZoneListName = space.id();
/* 409 */     electricEquipment.scheduleName = space.equipmentScheduleIdRef;
/* 410 */     electricEquipment.designLevelCalculationMethod = "Watts/Area";
/* 411 */     electricEquipment.wattsPerZoneFloorArea = space.EquipPower;
/* 412 */     return electricEquipment;
/*     */   }
/*     */ 
/*     */   public BuildingSurface makeBuildingSurfaceFrom(Surface surface)
/*     */   {
/* 419 */     BuildingSurface buildingSurface = new BuildingSurface();
/* 420 */     buildingSurface.name = surface.id;
/* 421 */     buildingSurface.zoneNames = ((Vector)surface.adjacentSpaceIds.clone());
/* 422 */     buildingSurface.constructionName = determineConstructionName(surface);
/* 423 */     buildingSurface.vertices = ((Vector)surface.cartesianPoints.clone());
/*     */ 
/* 426 */     buildingSurface.sunExposure = determineSunExposure(surface);
/* 427 */     buildingSurface.windExporsure = determineWindExposure(surface);
/* 428 */     buildingSurface.surfaceType = determineIdfSurfaceType(surface.surfaceType);
/* 429 */     buildingSurface.boundaryCondition = determineOutsideBoundaryCondition(surface);
/* 430 */     buildingSurface.boundaryConditionObject = determineOutsideBoundaryConditionObject(surface);
/*     */ 
/* 432 */     buildingSurface.fenestrationSurfaces = makeFenestrationSurfacesFrom(surface);
/* 433 */     return buildingSurface;
/*     */   }
/*     */ 
/*     */   private String determineIdfSurfaceType(String surfaceType)
/*     */   {
/* 438 */     if (surfaceType.equals("ExteriorWall"))
/* 439 */       surfaceType = "Wall";
/* 440 */     else if (surfaceType.equals("InteriorWall"))
/* 441 */       surfaceType = "Wall";
/* 442 */     else if (surfaceType.equals("InteriorFloor"))
/* 443 */       surfaceType = "Floor";
/* 444 */     else if (surfaceType.equals("Roof"))
/* 445 */       surfaceType = "Roof";
/* 446 */     else if (surfaceType.equals("Air"))
/* 447 */       surfaceType = "Wall";
/* 448 */     else if (surfaceType.equals("SlabOnGrade"))
/* 449 */       surfaceType = "Floor";
/* 450 */     else if (surfaceType.equals("RaisedFloor")) {
/* 451 */       surfaceType = "Roof";
/*     */     }
/* 453 */     return surfaceType;
/*     */   }
/*     */ 
/*     */   private String determineConstructionName(Surface surface)
/*     */   {
/*     */     String constructionName;
/* 459 */     if (surface.surfaceType.equals("Air"))
/*     */     {
/* 461 */       constructionName = "Construction-Air";
/*     */     }
/*     */     else {
/* 464 */       constructionName = surface.constructionIdRef;
/*     */     }
/* 466 */     return constructionName;
/*     */   }
/*     */ 
/*     */   private String determineOutsideBoundaryCondition(Surface targetSurface)
/*     */   {
/*     */     String boundaryCondition;
/* 475 */     if (zonesShare(targetSurface))
/*     */     {
/* 477 */       boundaryCondition = determineSharedZoneCase(targetSurface);
/*     */     }
/*     */     else
/*     */     {
/* 480 */       if (targetSurface.surfaceType.equals("SlabOnGrade"))
/* 481 */         boundaryCondition = "Ground";
/*     */       else {
/* 483 */         boundaryCondition = "Outdoors";
/*     */       }
/*     */     }
/* 486 */     return boundaryCondition;
/*     */   }
/*     */ 
/*     */   private String determineSharedZoneCase(Surface targetSurface)
/*     */   {
/*     */     String boundaryCondition;
/* 492 */     if (sameZonesShare(targetSurface))
/*     */     {
/* 494 */       boundaryCondition = "Ground";
/*     */     }
/*     */     else
/*     */     {
/* 497 */       if (zonesOnSameFloorShare(targetSurface))
/*     */       {
/* 499 */         boundaryCondition = "Surface";
/*     */       }
/*     */       else
/*     */       {
/* 502 */         if (this.SHEP.booleanValue())
/* 503 */           boundaryCondition = "Zone";
/*     */         else
/* 505 */           boundaryCondition = "Surface";
/*     */       }
/*     */     }
/* 508 */     return boundaryCondition;
/*     */   }
/*     */ 
/*     */   private String determineOutsideBoundaryConditionObject(Surface surface)
/*     */   {
/*     */     String boundaryConditionObject;
/* 514 */     if (zonesShare(surface))
/*     */     {
/* 516 */       if (sameZonesShare(surface))
/*     */       {
/* 518 */         boundaryConditionObject = "";
/*     */       }
/*     */       else
/*     */       {
	              if (surface.adjacentSpaceIds.size() == 0)
	            	  boundaryConditionObject = "";
/* 521 */         else if (zonesOnSameFloorShare(surface))
/*     */         {
/* 523 */           boundaryConditionObject = (String)surface.adjacentSpaceIds.get(1);
/*     */         }
/*     */         else {
/* 526 */           boundaryConditionObject = (String)surface.adjacentSpaceIds.get(1);
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 532 */       boundaryConditionObject = "";
/*     */     }
/* 534 */     return boundaryConditionObject;
/*     */   }
/*     */ 
/*     */   private String determineWindExposure(Surface surface)
/*     */   {
/*     */     String windExposure;
/* 540 */     if (surface.adjacentSpaceIds.size() == 1)
/*     */     {
/* 542 */       if (surface.surfaceType.equals("SlabOnGrade"))
/*     */       {
/* 544 */         windExposure = "NoWind";
/*     */       }
/*     */       else
/* 547 */         windExposure = "WindExposed";
/*     */     }
/*     */     else {
/* 550 */       windExposure = "NoWind";
/*     */     }
/* 552 */     return windExposure;
/*     */   }
/*     */ 
/*     */   private String determineSunExposure(Surface surface)
/*     */   {
/*     */     String sunExposure;
/* 558 */     if (surface.adjacentSpaceIds.size() == 1)
/*     */     {
/* 560 */       if (surface.surfaceType.endsWith("SlabOnGrade"))
/*     */       {
/* 562 */         sunExposure = "NoSun";
/*     */       }
/*     */       else
/* 565 */         sunExposure = "SunExposed";
/*     */     }
/*     */     else {
/* 568 */       sunExposure = "NoSun";
/*     */     }
/* 570 */     return sunExposure;
/*     */   }
/*     */ 
/*     */   private boolean zonesOnSameFloorShare(Surface targetSurface)
/*     */   {
/* 575 */     assert (sameZonesShare(targetSurface));
/*     */ 
/* 581 */     return (!targetSurface.surfaceType.equals("Ceiling")) && 
/* 578 */       (!targetSurface.surfaceType.equals("InteriorFloor")) && 
/* 579 */       (!targetSurface.surfaceType.equals("UndergroundCeiling"));
/*     */   }
/*     */ 
/*     */   private boolean zonesShare(Surface targetSurface)
/*     */   {
/* 588 */     return targetSurface.adjacentSpaceIds.size() != 1;
/*     */   }
/*     */ 
/*     */   private boolean sameZonesShare(Surface targetSurface)
/*     */   {
/* 593 */     assert (zonesShare(targetSurface));
/*     */ 	  if ( targetSurface.adjacentSpaceIds.size() == 0 ) return false;
/* 595 */     return ((String)targetSurface.adjacentSpaceIds.get(0)).equals(
/* 596 */       targetSurface.adjacentSpaceIds.get(1));
/*     */   }
/*     */ 
/*     */   private Vector<FenestrationSurface> makeFenestrationSurfacesFrom(Surface surface)
/*     */   {
/* 603 */     Vector fenestrationSurfaces = new Vector();
/* 604 */     for (Opening opening : surface.getOpenings())
/*     */     {
/* 606 */       FenestrationSurface fenestrationSurface = new FenestrationSurface();
/* 607 */       fenestrationSurface.name = opening.id;
/* 608 */       fenestrationSurface.surfaceType = "Window";
/* 609 */       fenestrationSurface.constructionName = (opening.windowtypeIdRef + "_con");
/* 610 */       fenestrationSurface.buildingSurfaceName = surface.id;
/* 611 */       fenestrationSurface.viewFactorToGround = Double.valueOf(0.5D);
/* 612 */       fenestrationSurface.multiplier = Double.valueOf(1.0D);
/* 613 */       fenestrationSurface.numberOfVerrices = Integer.valueOf(4);
/* 614 */       fenestrationSurface.vertexCoordinate = ((Vector)opening.points.clone());
/* 615 */       fenestrationSurfaces.add(fenestrationSurface);
/*     */     }
/* 617 */     return fenestrationSurfaces;
/*     */   }
/*     */ 
/*     */   private SiteLocation makeSiteLocationFrom(Location location)
/*     */   {
/* 622 */     SiteLocation siteLocation = new SiteLocation();
/*     */ 
/* 624 */     siteLocation.name = location.name().replaceAll(",", "");
/* 625 */     siteLocation.latitude = new Degree(location.latitude());
/* 626 */     siteLocation.longitude = new Degree(location.longitude());
/* 627 */     return siteLocation;
/*     */   }
/*     */ 
/*     */   private Vector<ScheduleDayHourly> makeScheduleDayHourlys(Vector<DaySchedule> daySchedules)
/*     */   {
/* 633 */     Vector scheduleDayHourlys = new Vector();
/*     */ 
/* 635 */     for (DaySchedule daySchedule : daySchedules)
/*     */     {
/* 637 */       ScheduleDayHourly scheduleDayHourly = new ScheduleDayHourly();
/*     */ 
/* 639 */       scheduleDayHourly.name = daySchedule.id();
/* 640 */       scheduleDayHourly.scheduleTypeLimitsName = daySchedule.type();
/*     */ 
/* 643 */       for (int hour = 0; hour < 24; hour++) {
/* 644 */         scheduleDayHourly.hours.add(Double.valueOf(Double.parseDouble(daySchedule.scheduleValues[hour])));
/*     */       }
/*     */ 
/* 647 */       scheduleDayHourlys.add(scheduleDayHourly);
/*     */     }
/* 649 */     return scheduleDayHourlys;
/*     */   }
/*     */ 
/*     */   private Vector<ScheduleWeekDaily> makeScheduleWeekDaily(Vector<WeekSchedule> weekSchedules)
/*     */   {
/* 654 */     if (weekSchedules == null) throw new NullPointerException();
/*     */ 
/* 656 */     Vector scheduleWeekDailies = new Vector();
/* 657 */     for (WeekSchedule weekSchedule : weekSchedules)
/*     */     {
/* 659 */       ScheduleWeekDaily scheduleWeekDaily = new ScheduleWeekDaily();
/*     */ 
/* 661 */       scheduleWeekDaily.name = weekSchedule.id();
/*     */ 
/* 663 */       scheduleWeekDaily.sunDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 664 */       scheduleWeekDaily.monthDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 665 */       scheduleWeekDaily.tuesDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 666 */       scheduleWeekDaily.wednesDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 667 */       scheduleWeekDaily.thursDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 668 */       scheduleWeekDaily.friDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 669 */       scheduleWeekDaily.saturDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 670 */       scheduleWeekDaily.holiDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 671 */       scheduleWeekDaily.summerDesignDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 672 */       scheduleWeekDaily.winterDesignDaySchedule = weekSchedule.day.dayScheduleIdRef();
/* 673 */       scheduleWeekDaily.customDay1Schedule = weekSchedule.day.dayScheduleIdRef();
/* 674 */       scheduleWeekDaily.customDay2Schedule = weekSchedule.day.dayScheduleIdRef();
/*     */ 
/* 676 */       scheduleWeekDailies.add(scheduleWeekDaily);
/*     */     }
/* 678 */     return scheduleWeekDailies;
/*     */   }
/*     */ 
/*     */   private Vector<ScheduleYear> makeScheduleYear(Vector<Schedule> schedules)
/*     */   {
/* 683 */     if (schedules == null) throw new NullPointerException();
/*     */ 
/* 685 */     Vector scheduleYears = new Vector();
/*     */ 
/* 687 */     for (Schedule schedule : schedules)
/*     */     {
/* 689 */       ScheduleYear scheduleYear = new ScheduleYear();
/* 690 */       scheduleYear.name = schedule.id();
/* 691 */       scheduleYear.typeLimitsName = schedule.type();
/* 692 */       scheduleYear.weekName = schedule.yearSchedule.weekScheduleIdRef;
/* 693 */       scheduleYear.startMonth = Integer.parseInt(schedule.yearSchedule.beginDateString.substring(5, 7));
/* 694 */       scheduleYear.startDay = Integer.parseInt(schedule.yearSchedule.beginDateString.substring(8, 10));
/* 695 */       scheduleYear.endMonth = Integer.parseInt(schedule.yearSchedule.endDateString.substring(5, 7));
/* 696 */       scheduleYear.endDay = Integer.parseInt(schedule.yearSchedule.endDateString.substring(8, 10));
/*     */ 
/* 698 */       scheduleYears.add(scheduleYear);
/*     */     }
/* 700 */     return scheduleYears;
/*     */   }
/*     */ 
/*     */   private Vector<com.dankook.bsi.util.IDF.Material> makeIdfMaterialsFrom(Vector<com.dankook.bsi.util.greenbuilding.Material> materials)
/*     */   {
/* 708 */     Vector idfMaterials = new Vector();
/*     */ 
/* 710 */     for (com.dankook.bsi.util.greenbuilding.Material material : materials)
/*     */     {
/* 712 */       com.dankook.bsi.util.IDF.Material idfMaterial = new com.dankook.bsi.util.IDF.Material();
/*     */ 
/* 714 */       idfMaterial.name = material.id();
/* 715 */       idfMaterial.setThickness(material.M_Thcikness);
/* 716 */       idfMaterial.setConductvity(material.M_Conductivity);
/* 717 */       idfMaterial.setDensity(material.M_Density);
/* 718 */       idfMaterial.setSpecificHeat(material.M_SpecificHeat);
/* 719 */       idfMaterial.thermalResistance = material.R_Value;
/*     */ 
/* 721 */       idfMaterials.add(idfMaterial);
/*     */     }
/* 723 */     return idfMaterials;
/*     */   }
/*     */ 
/*     */   private Vector<WindowMaterialSimpleGlazingSystem> makeWindowMaterialsFrom(Vector<WindowType> windowTypes)
/*     */   {
/* 729 */     Vector windowMaterials = new Vector();
/*     */ 
/* 731 */     for (WindowType windowType : windowTypes)
/*     */     {
/* 733 */       WindowMaterialSimpleGlazingSystem windowMaterial = new WindowMaterialSimpleGlazingSystem();
/* 734 */       windowMaterial.name = windowType.id();
/* 735 */       windowMaterial.uFactor = windowType.U_Value();
/* 736 */       windowMaterial.solarHeatGainCoefficient = windowType.solarHeatGainCoeff();
/* 737 */       windowMaterial.visibleTransmittance = windowType.transmittance();
/* 738 */       windowMaterials.add(windowMaterial);
/*     */     }
/* 740 */     return windowMaterials;
/*     */   }
/*     */ 
/*     */   private Vector<com.dankook.bsi.util.IDF.Construction> makeConstructionsFrom(Vector<WindowMaterialSimpleGlazingSystem> windowMaterials)
/*     */   {
/* 746 */     Vector constructions = new Vector();
/* 747 */     for (WindowMaterialSimpleGlazingSystem windowMaterial : windowMaterials)
/*     */     {
/* 749 */       com.dankook.bsi.util.IDF.Construction construction = new com.dankook.bsi.util.IDF.Construction();
/* 750 */       construction.name = (windowMaterial.name + "_con");
/* 751 */       construction.setOutsideLayer(windowMaterial.name);
/* 752 */       constructions.add(construction);
/*     */     }
/* 754 */     return constructions;
/*     */   }
/*     */ 
/*     */   private Vector<com.dankook.bsi.util.IDF.Construction> makeConstructionsFrom(Vector<com.dankook.bsi.util.greenbuilding.Construction> constructions, HashMap<String, Layer> layerHashMap)
/*     */   {
/* 761 */     Vector idfConstructions = new Vector();
/* 762 */     for (com.dankook.bsi.util.greenbuilding.Construction gbxmlConstruction : constructions)
/*     */     {
/* 765 */       Vector materials = new Vector();
/* 766 */       for (String LayerId : gbxmlConstruction.getLayerIds())
/*     */       {
/* 768 */         Layer layer = (Layer)layerHashMap.get(LayerId);
/* 769 */         materials.addAll(layer.materials);
/*     */       }
/*     */ 
/* 772 */       if (materials.isEmpty()) break;
/* 773 */       com.dankook.bsi.util.IDF.Construction idfConstruction = new com.dankook.bsi.util.IDF.Construction();
/* 774 */       idfConstruction.name = gbxmlConstruction.id();
/* 775 */       idfConstruction.getLayers().addAll(materials);
/* 776 */       idfConstructions.add(idfConstruction);
/*     */     }
/* 778 */     return idfConstructions;
/*     */   }
/*     */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GBXmlToIdfConverter
 * JD-Core Version:    0.6.0
 */