/*     */ package com.dankook.bsi.util.IDF;
/*     */ 
/*     */ import com.dankook.bsi.util.IDF.*;
/*     */ import com.dankook.bsi.util.geometry.EDIVector3;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class IdfFileWriter
/*     */ {
/*     */   IDF idf;
/* 514 */   String RESULT_TIMESTEP_MONTHLY = "Monthly";
/* 515 */   String RESULT_TEIMSTEP_DAILY = "Daily";
/*     */ 
/* 944 */   Integer significantFigure = Integer.valueOf(2);
/* 945 */   String[] months = { "", "January", "February", "March", "April", "May", 
/* 946 */     "June", "July", "August", "September", "October", "November", 
/* 947 */     "December" };
/*     */ 
/*     */   public IdfFileWriter(IDF idf)
/*     */   {
/*  20 */     this.idf = idf;
/*     */   }
/*     */ 
/*     */   public IdfFileWriter() {
/*     */   }
/*     */ 
/*     */   public StringBuffer getIdfFileTextFrom() throws Exception {
/*  27 */     StringBuffer buffer = new StringBuffer();
/*     */ 
/*  29 */     writeSimulationParameters(this.idf, buffer);
/*  30 */     writeLocationClimateWeatherFileAccess(this.idf, buffer);
/*     */ 
/*  32 */     writeScheduleTypeLimits(buffer);
/*     */ 
/*  34 */     writeScheduleDayHourly(this.idf, buffer);
/*  35 */     writeScheduleWeekDailies(this.idf, buffer);
/*  36 */     writeYearSchedules(this.idf, buffer);
/*  37 */     writeGlobalScheduleCompact(this.idf, buffer);
/*     */ 
/*  39 */     writeMaterials(this.idf, buffer);
/*  40 */     writeWindowMaterials(this.idf, buffer);
/*     */ 
/*  42 */     writeConstructionAndMaterialForAir(this.idf.buildingSurfaces, buffer);
/*  43 */     writeConstructions(this.idf, buffer);
/*     */ 
/*  46 */     writetGlobalGeometryRules(this.idf, buffer);
/*     */ 
/*  48 */     //writeZoneAndItsParameters(this.idf, buffer);
/*  49 */     writeIdfZoneList(this.idf.zoneLists, buffer);
/*     */ 
/*  51 */     writeBuildingSurfaces(this.idf.buildingSurfaces, buffer);
/*  52 */     writeFenestrationSurface(this.idf, buffer);
/*     */ 
/*  54 */     //writeZoneSimulationControl(this.idf, buffer);
/*  55 */     writeZoneVentilations(this.idf, buffer);
/*     */ 
/*  57 */     writeOutputSurfaces(buffer);
/*  58 */     writeOutputVariables(ResultTimeStep.Monthly, buffer);
/*  59 */     writeCompactScheduleForGlobal(buffer);
/*     */ 
/*  61 */     //writeHVACTemplates(buffer);
/*     */ 
/*  63 */     return buffer;
/*     */   }
/*     */ 
/*
private void writeHVACTemplates(StringBuffer buffer)
{
HvacTemplates templates = this.idf.getHvacTemplate();

if (this.idf.isVAVSystem())
{
buffer.append(templates.toIdfDesc());
 buffer.append(this.idf.getDesignDays().toIdfDesc());
 buffer.append(this.idf.getSizingParameters().toIdfDesc());
  buffer.append(getScheduleForVAV());
  }
  }
*/
/*     */   private String getScheduleForVAV() {
/*  80 */     String scheduleDesc = "Schedule:Compact,\r\nFanAvailSched,           !- Name\r\nFraction,                !- Schedule Type Limits Name\r\nThrough: 12/31,          !- Field 1\r\nFor: WeekDays CustomDay1 CustomDay2,  !- Field 2\r\nUntil: 8:00, 0.0,        !- Field 4\r\nUntil: 21:00, 1.0,       !- Field 6\r\nUntil: 24:00, 0.0,       !- Field 8\r\nFor: Weekends Holiday,   !- Field 9\r\nUntil: 24:00, 0.0,       !- Field 11\r\nFor: SummerDesignDay,    !- Field 12\r\nUntil: 24:00, 1.0,       !- Field 14\r\nFor: WinterDesignDay,    !- Field 15\r\nUntil: 24:00, 1.0;       !- Field 17\r\n";
/*     */ 
/*  95 */     scheduleDesc = scheduleDesc + "Schedule:Compact,\r\nMin OA Sched,            !- Name\r\nFraction,                !- Schedule Type Limits Name\r\nThrough: 12/31,          !- Field 1\r\nFor: WeekDays CustomDay1 CustomDay2,  !- Field 2\r\nUntil: 8:00, 0.0,        !- Field 4\r\nUntil: 21:00, 1.0,       !- Field 6\r\nUntil: 24:00, 0.0,       !- Field 8\r\nFor: Weekends Holiday,   !- Field 9\r\nUntil: 24:00, 0.0,       !- Field 11\r\nFor: SummerDesignDay,    !- Field 12\r\nUntil: 24:00, 1.0,       !- Field 14\r\nFor: WinterDesignDay,    !- Field 15\r\nUntil: 24:00, 1.0;       !- Field 17";
/*     */ 
/* 109 */     return scheduleDesc;
/*     */   }
/*     */ 
/*     */   private void writeLocationClimateWeatherFileAccess(IDF idf, StringBuffer buffer)
/*     */   {
/* 114 */     writeLocation(idf, buffer);
/* 115 */     writeRunPeriod(buffer);
/* 116 */     writeGroundTemperature(idf.getGroundTemperature(), buffer);
/*     */   }
/*     */ 
/*     */   private void writeSimulationParameters(IDF idf, StringBuffer buffer)
/*     */   {
/* 121 */     writeVersion(idf, buffer);
/* 122 */     writeSimulationControl(idf.getSimulationParameters().getSimulationControl(), buffer);
/* 123 */     writeBuilding(idf, buffer);
/* 124 */     writeAlgorithm(idf, buffer);
/* 125 */     writeTimeStep(idf, buffer);
/*     */   }
/*     */ 
/*     */   private void writeConstructionAndMaterialForAir(HashMap<String, BuildingSurface> hashOfSurface, StringBuffer buffer)
/*     */   {
/* 130 */     for (String key : hashOfSurface.keySet()) {
/* 131 */       BuildingSurface buildingSurface = (BuildingSurface)hashOfSurface.get(key);
/*     */ 
/* 133 */       if (buildingSurface.constructionName
/* 133 */         .equals("Construction-Air")) {
/* 134 */         buffer.append("Material:NoMass, \r\nAir BuildingSurface-Material,             !- Name\t\t\r\nRough,                   !- Roughness\t\t\r\n17.42;             !- Thermal Resistance {m2-K/W}\t\t\r\n\r\n");
/*     */ 
/* 140 */         buffer.append("Construction, \r\nConstruction-Air,                  !- Name\t\r\nAir BuildingSurface-Material;   \t\t              !- Outside Layer \t\r\n\r\n");
/*     */ 
/* 146 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   void writeVersion(IDF idf, StringBuffer sb) {
/* 152 */     if ((idf == null) || (sb == null)) {
/* 153 */       throw new NullPointerException();
/*     */     }
/*     */ 
/* 156 */     sb.append("Version," + idf.getVersion() + "; \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeSimulationControl(SimulationControl simulationControl, StringBuffer sb)
/*     */   {
/* 161 */     if ((simulationControl == null) || (sb == null)) {
/* 162 */       throw new NullPointerException();
/*     */     }
/*     */ 
/* 165 */     sb.append("SimulationControl, \r\n" + 
/* 166 */       simulationControl.doZoneSizingCalculation + 
/* 167 */       ",                      !- Do Zone Sizing Calculation \r\n" + 
/* 168 */       simulationControl.doSystemSizingCalculation + 
/* 169 */       ",                      !- Do System Sizing Calculation \r\n" + 
/* 170 */       simulationControl.doPlantSizingCalculation + 
/* 171 */       ",                      !- Do Plant Sizing Calculation \r\n" + 
/* 172 */       simulationControl.runSimulationForSizingPeriods + 
/* 173 */       ",                      !- Run Simulation for Sizing Periods \r\n" + 
/* 174 */       simulationControl.runSimulationForWeatherFileRunPeriods + 
/* 175 */       ";                     !- Run Simulation for Weather File Run Periods \r\n\r\n");
/*     */   }
/*     */ 
/*     */   public void writeBuilding(IDF idf, StringBuffer sb) {
/* 179 */     if ((idf == null) || (sb == null)) {
/* 180 */       throw new NullPointerException();
/*     */     }
/*     */ 
/* 183 */     sb.append("Building, \r\n");
/* 184 */     sb.append("EDI_Test,               !- Name \r\n");
/* 185 */     sb.append(idf.getBuilding().northAxis + 
/* 186 */       ",                       !- North Axis {deg} \r\n");
/* 187 */     sb.append(idf.getBuilding().terrain + 
/* 188 */       ",                 !- Terrain \r\n");
/* 189 */     sb.append(idf.getBuilding().lodsConvergenceTolerance + 
/* 190 */       ",           !- Loads Convergence Tolerance Value \r\n");
/* 191 */     sb.append(idf.getBuilding().temperatureConvergenceTolerance + 
/* 192 */       ",               !- Temperature Convergence Tolerance Value {deltaC} \r\n");
/* 193 */     sb.append(idf.getBuilding().solarDistribution + 
/* 194 */       ", !- Solar Distribution \r\n");
/* 195 */     sb.append(idf.getBuilding().maximumNumberOfWarmupDays + 
/* 196 */       ";                      !- Maximum Number of Warmup Days \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeAlgorithm(IDF idf, StringBuffer sb) {
/* 200 */     if ((idf == null) || (sb == null)) {
/* 201 */       throw new NullPointerException();
/*     */     }
/*     */ 
/* 204 */     sb.append("SurfaceConvectionAlgorithm:Inside," + 
/* 205 */       idf.surfaceConvectionAlgorithmInside + "; \r\n\r\n");
/* 206 */     sb.append("SurfaceConvectionAlgorithm:Outside," + 
/* 207 */       idf.surfaceConvectionAlgorithmOutside + "; \r\n\r\n");
/* 208 */     sb.append("HeatBalanceAlgorithm," + idf.heatBalanceAlgorithm + 
/* 209 */       "; \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeTimeStep(IDF idf, StringBuffer sb) {
/* 213 */     if ((idf == null) || (sb == null)) {
/* 214 */       throw new NullPointerException();
/*     */     }
/* 216 */     sb.append("Timestep," + idf.getTimeStep() + "; \r\n\r\n");
/*     */   }
/*     */ 
/*     */   public void writeLocation(IDF idf, StringBuffer sb) {
/* 220 */     if ((idf == null) || (sb == null)) {
/* 221 */       throw new NullPointerException();
/*     */     }
/*     */ 
/* 224 */     SiteLocation siteLocation = idf.siteLocation;
/*     */ 
/* 226 */     sb.append("Site:Location, \r\n" + siteLocation.name + 
/* 227 */       ",  \t\t !- Name \r\n" + siteLocation.latitude + 
/* 228 */       ",              !- Latitude {deg} \r\n" + 
/* 229 */       siteLocation.longitude + 
/* 230 */       ",             !- Longitude {deg} \r\n" + 
/* 231 */       siteLocation.timeZone + 
/* 232 */       ",                       !- Time Zone {hr} \r\n" + 
/* 233 */       siteLocation.elevation + 
/* 234 */       ";                       !- Elevation {m} \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeRunPeriod(StringBuffer sb)
/*     */   {
/* 239 */     sb.append("RunPeriod, \r\n,                        !- Name \r\n1,                       !- Begin Month \r\n1,                       !- Begin Day of Month \r\n12,                      !- End Month \r\n31,                      !- End Day of Month \r\nUseWeatherFile,          !- Day of Week for Start Day \r\nYes,                     !- Use Weather File Holidays and Special Days \r\nYes,                     !- Use Weather File Daylight Saving Period \r\nNo,                      !- Apply Weekend Holiday Rule \r\nYes,                     !- Use Weather File Rain Indicators \r\nYes;                     !- Use Weather File Snow Indicators \r\n\r\n");
/*     */   }
/*     */ 
/*     */   public void writeScheduleTypeLimits(StringBuffer sb)
/*     */   {
/* 254 */     sb.append("ScheduleTypeLimits, \r\nAny Number;              !- Name \r\n\r\n");
/*     */ 
/* 257 */     sb.append("ScheduleTypeLimits, \r\nFraction,                !- Name \r\n0.0,                     !- Lower Limit Value \r\n1.0,                     !- Upper Limit Value \r\nCONTINUOUS;              !- Numeric Type \r\n\r\n");
/*     */ 
/* 263 */     sb.append("ScheduleTypeLimits, \r\nTemperature,             !- Name \r\n-60,                     !- Lower Limit Value \r\n200,                     !- Upper Limit Value \r\nCONTINUOUS;              !- Numeric Type \r\n\r\n");
/*     */ 
/* 269 */     sb.append("ScheduleTypeLimits, \r\nControl Type,            !- Name \r\n0,                       !- Lower Limit Value \r\n4,                       !- Upper Limit Value \r\nDISCRETE;                !- Numeric Type \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeScheduleDayHourly(IDF idf, StringBuffer sb)
/*     */   {
/* 277 */     if ((idf == null) || (sb == null)) {
/* 278 */       throw new NullPointerException();
/*     */     }
/* 280 */     Vector <ScheduleDayHourly>scheduleDayHourlys = idf.scheduleDayHourlys;
/*     */ 
/* 282 */     for (ScheduleDayHourly scheduleDayHourly : scheduleDayHourlys) {
/* 283 */       sb.append("Schedule:Day:Hourly, \r\n" + scheduleDayHourly.name + 
/* 284 */         ",                  !- Name\t\r\n" + 
/* 285 */         scheduleDayHourly.scheduleTypeLimitsName + 
/* 286 */         ",                !- Schedule Type Limits Name\t\r\n");
/*     */ 
/* 288 */       for (int hour = 0; hour < 24; hour++) {
/* 289 */         Boolean zoneIndexIsList = Boolean.valueOf(hour == 23);
/* 290 */         String divider = zoneIndexIsList.booleanValue() ? ";" : ",";
/*     */ 
/* 292 */         sb.append(scheduleDayHourly.hours.get(hour) + divider + 
/* 293 */           "                     !- Hour " + (hour + 1) + 
/* 294 */           "\t\t\r\n");
/*     */       }
/* 296 */       sb.append("\r\n");
/*     */     }
/*     */   }
/*     */ 
/*
public void writeZoneAndItsParameters(IDF idf, StringBuffer sb) {
   assert (idf != null);
    assert (sb != null);

  for (String key : idf.getZones().keySet()) {
      IdfZone idfZone = (IdfZone)idf.getZones().get(key);

    writeZone(idfZone, sb);
     writeInternalGains(sb, idfZone);

    if (!idf.isVAVSystem()) {
       writeIdealLoadsAirSystem(idfZone.idealLoadsAirSystem, sb);
    writeZoneEquipment(idfZone, sb);
      }

    if (idfZone.scheduleCompact != null)
         writeScheduleCompact(idfZone.scheduleCompact, sb);
    }
  }
*/
/*     */   private void writeIdealLoadsAirSystem(IdealLoadsAirSystem idealLoadsAirSystem, StringBuffer sb)
/*     */   {
/* 325 */     sb.append("ZoneHVAC:IdealLoadsAirSystem,\t\r\n" + 
/* 326 */       idealLoadsAirSystem.name + 
/* 327 */       ",                !- Name\t\t\r\n" + 
/* 328 */       idealLoadsAirSystem.zoneSupplyAirzNodeName + 
/* 329 */       ",                  !- Zone Supply Air Node Name\t\t\r\n" + 
/* 330 */       idealLoadsAirSystem.heatingSupplyAirTemperature + 
/* 331 */       ",                      !- Heating Supply Air Temperature {C}\t\t\r\n" + 
/* 332 */       idealLoadsAirSystem.coolingSupplyAirTemperature + 
/* 333 */       ",                      !- Cooling Supply Air Temperature {C}\t\t\r\n" + 
/* 334 */       idealLoadsAirSystem.heatingSupplyAirHumidityRatio + 
/* 335 */       ",                   !- Heating Supply Air Humidity Ratio {kg-H2O/kg-air}\t\r\n" + 
/* 336 */       idealLoadsAirSystem.coolingSupplyAirHumidityRatio + 
/* 337 */       ",                   !- Cooling Supply Air Humidity Ratio {kg-H2O/kg-air}\t\r\n" + 
/* 338 */       idealLoadsAirSystem.heatinglimit + 
/* 339 */       ",                 !- Heating Limit\t\r\n" + 
/* 340 */       idealLoadsAirSystem.maximumHeatingAirFlowRate + 
/* 341 */       ",                !- Maximum Heating Air Flow Rate {m3/s}\t\r\n" + 
/* 342 */       idealLoadsAirSystem.coolingLimit + 
/* 343 */       ",                 !- Cooling Limit\t\r\n" + 
/* 344 */       idealLoadsAirSystem.maximumCoolingAirFlowRate + 
/* 345 */       ",                !- Maximum Cooling Air Flow Rate {m3/s}\t\r\n" + 
/* 346 */       idealLoadsAirSystem.outdoorAir + 
/* 347 */       ",            !- Outdoor Air\t\t\r\n" + 
/* 348 */       idealLoadsAirSystem.outdoorAirFlowRate + 
/* 349 */       ";                !- Outdoor Air Flow Rate {m3/s}\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writeZoneEquipment(IdfZone idfZone, StringBuffer sb)
/*     */   {
/* 354 */     writeHVACEquipmentList(sb, idfZone.equipmentList);
/* 355 */     writeHVACEquipmentConnections(sb, idfZone.equipmentConnections);
/*     */   }
/*     */ 
/*     */   private void writeHVACEquipmentList(StringBuffer sb, EquipmentList equipmentList)
/*     */   {
/* 360 */     sb.append("ZoneHVAC:EquipmentList,\t\r\n" + equipmentList.name + 
/* 361 */       ",\t\t    !- Name\t\r\n");
/*     */ 
/* 363 */     for (int index = 0; index < equipmentList.zoneEquipments.size(); index++) {
/* 364 */       ZoneEquipment zoneEquipment = 
/* 365 */         (ZoneEquipment)equipmentList.zoneEquipments
/* 365 */         .get(index);
/* 366 */       sb.append(zoneEquipment.objectType + ",  !- Zone Equipment " + (
/* 367 */         index + 1) + " Object Type\t\t\r\n" + zoneEquipment.name + 
/* 368 */         ",                !- Zone Equipment " + (index + 1) + 
/* 369 */         " Name\t\t\r\n" + zoneEquipment.coolingSequence + 
/* 370 */         ",                       \t\t!- Zone Equipment " + (
/* 371 */         index + 1) + " Cooling Sequence\t\t\r\n" + 
/* 372 */         zoneEquipment.heatingOrNoLoadSequence + 
/* 373 */         ";                      \t\t!- Zone Equipment " + (
/* 374 */         index + 1) + " Heating or No-Load Sequence\t\t\r\n\r\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void writeHVACEquipmentConnections(StringBuffer sb, EquipmentConnections equipmentConnections)
/*     */   {
/* 380 */     sb.append("ZoneHVAC:EquipmentConnections,\t\t\r\n" + 
/* 381 */       equipmentConnections.zoneName + 
/* 382 */       ",               !- Zone Name\t\r\n" + 
/* 383 */       equipmentConnections.conditioningEquipmentListName + 
/* 384 */       ",     !- Zone Conditioning Equipment List Name\t\r\n" + 
/* 385 */       equipmentConnections.zoneAirInletNodeOrNodeListName + 
/* 386 */       ",               !- Zone Air Inlet Node or NodeList Name\t\r\n" + 
/* 387 */       equipmentConnections.airExhaustNodeOrNodeListName + 
/* 388 */       ",                         !- Zone Air Exhaust Node or NodeList Name\t\r\n" + 
/* 389 */       equipmentConnections.airNodeName + 
/* 390 */       ",               !- Zone Air Node Name\t\t\r\n" + 
/* 391 */       equipmentConnections.returnAirNodeName + 
/* 392 */       ";               !- Zone Return Air Node Name\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writeInternalGains(StringBuffer sb, IdfZone idfZone) {
/* 396 */     writePeople(idfZone.people, sb);
/* 397 */     writeLights(idfZone.lights, sb);
/* 398 */     writeElectricEquipment(idfZone.electricEquipment, sb);
/*     */   }
/*     */ 
/*     */   private void writeElectricEquipment(ElectricEquipment electricEquipment, StringBuffer sb)
/*     */   {
/* 403 */     sb.append("ElectricEquipment,\t\t\r\n" + 
/* 404 */       electricEquipment.name + 
/* 405 */       ",      !- Name\t\r\n" + 
/* 406 */       electricEquipment.zoneOrZoneListName + 
/* 407 */       ",             !- Zone or ZoneList Name\t\r\n" + 
/* 408 */       electricEquipment.scheduleName + 
/* 409 */       ",           !- Schedule Name\t\r\n" + 
/* 410 */       electricEquipment.designLevelCalculationMethod + 
/* 411 */       ",             !- Design Level Calculation Method\t\t\r\n" + 
/* 412 */       ",       \t\t\t     !- Design Level {W}\t\r\n" + 
/* 413 */       electricEquipment.wattsPerZoneFloorArea + 
/* 414 */       ",           !- Watts per Zone Floor Area {W/m2}\t\r\n" + 
/* 415 */       ",                       !- Watts per Person {W/person}\t\t\r\n" + 
/* 416 */       "0,                      !- Fraction Latent\t\t\r\n" + 
/* 417 */       "0.3000000,              !- Fraction Radiant\t\r\n" + 
/* 418 */       "0;                      !- Fraction Lost\t\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writeLights(Lights lights, StringBuffer sb) {
/* 422 */     sb.append("Lights,\t\r\n" + 
/* 423 */       lights.name + 
/* 424 */       ",      !- Name\t\r\n" + 
/* 425 */       lights.zoneOrZoneListName + 
/* 426 */       ",             !- Zone or ZoneList Name\t\r\n" + 
/* 427 */       lights.scheduleName + 
/* 428 */       ",    !- Schedule Name\t\r\n" + 
/* 429 */       lights.designLevelCalculationMethod + 
/* 430 */       ",             !- Design Level Calculation Method\t\t\r\n" + 
/* 431 */       ",       \t\t\t\t !- Lighting Level {W}\t\r\n" + 
/* 432 */       lights.wattsPerZoneFloorArea + 
/* 433 */       ",           !- Watts per Zone Floor Area {W/m2}\t\r\n" + 
/* 434 */       ",                       !- Watts per Person {W/person}\t\t\r\n" + 
/* 435 */       "0,                      !- Return Air Fraction\t\t\r\n" + 
/* 436 */       "0.2000000,              !- Fraction Radiant\t\r\n" + 
/* 437 */       "0.2000000,              !- Fraction Visible\t\r\n" + 
/* 438 */       "0,                      !- Fraction Replaceable\t\r\n" + 
/* 439 */       "GeneralLights;          !- End-Use Subcategory\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writePeople(People people, StringBuffer sb) {
/* 443 */     sb.append("People,\t\t\r\n" + 
/* 444 */       people.name + 
/* 445 */       ",      !- Name\t\r\n" + 
/* 446 */       people.zoneOrZoneListName + 
/* 447 */       ",             !- Zone or ZoneList Name\t\r\n" + 
/* 448 */       people.numberOfPeopleScheduleName + 
/* 449 */       ",       !- Number of People Schedule Name\t\r\n" + 
/* 450 */       people.numberOfPeopleCalculationMethod + 
/* 451 */       ",                 !- Number of People Calculation Method\t\r\n" + 
/* 452 */       people.numberOfPeople + 
/* 453 */       ",    \t !- Number of People\t\r\n" + 
/* 454 */       ",                       !- People per Zone Floor Area {person/m2}\t\r\n" + 
/* 455 */       ",                       !- Zone Floor Area per Person {m2/person}\t\r\n" + 
/* 456 */       "0.3000000,              !- Fraction Radiant\t\r\n" + 
/* 457 */       ",                       !- Sensible Heat Fraction\t\r\n" + 
/* 458 */       people.activityLevelScheduleName + 
/* 459 */       ",           !- Activity Level Schedule Name\t\r\n" + 
/* 460 */       ",                       !- Carbon Dioxide Generation Rate {m3/s-W}\t\r\n" + 
/* 461 */       ",                       !- Enable ASHRAE 55 Comfort Warnings\t\r\n" + 
/* 462 */       "zoneaveraged,           !- Mean Radiant Temperature Calculation Type\t\r\n" + 
/* 463 */       ",                       !- Surface Name/Angle Factor List Name\t\t\r\n" + 
/* 464 */       ",           \t\t\t !- Work Efficiency Schedule Name\t\r\n" + 
/* 465 */       ",           \t\t\t !- Clothing Insulation Schedule Name\t\r\n" + 
/* 466 */       ";        \t\t\t\t !- Air Velocity Schedule Name\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writeZone(IdfZone idfZone, StringBuffer sb) {
/* 470 */     sb.append("Zone, \t\r\n" + 
/* 471 */       idfZone.name + 
/* 472 */       ",              !- Name \r\n" + 
/* 473 */       idfZone.directionOfRelativeNorth() + 
/* 474 */       ",                       !- Direction of Relative North {deg} \r\n" + 
/* 475 */       idfZone.origin().x + 
/* 476 */       ",                       !- X Origin {m} \r\n" + 
/* 477 */       idfZone.origin().y + 
/* 478 */       ",                       !- Y Origin {m} \r\n" + 
/* 479 */       idfZone.origin().y + 
/* 480 */       ",                       !- Z Origin {m} \r\n" + 
/* 481 */       idfZone.type() + ",                       !- Type \r\n" + 
/* 482 */       idfZone.multiplier() + 
/* 483 */       ",                       !- Multiplier \r\n" + 
/* 484 */       idfZone.ceilingHeight() + 
/* 485 */       ",           !- Ceiling Height {m} \r\n" + idfZone.volume() + 
/* 486 */       ";           !- Volume {m3} \r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writeConstructions(IDF idf, StringBuffer sb) {
/* 490 */     Vector <Construction>idfConstructions = idf.constructions;
/* 491 */     for (Construction construction : idfConstructions) {
/* 492 */       sb.append("Construction, \r\n");
/* 493 */       sb.append(construction.name + ",                  !- Name\t\r\n");
/* 494 */       int materialIndex = 0;
/* 495 */       for (; materialIndex < construction
/* 495 */         .getLayers().size(); materialIndex++) {
/* 496 */         Boolean isLastIndex = Boolean.valueOf(materialIndex == construction
/* 497 */           .getLayers().size() - 1);
/* 498 */         String divider = isLastIndex.booleanValue() ? ";" : ",";
/* 499 */         sb.append((String)construction.getLayers().get(materialIndex) + divider + 
/* 500 */           getCommentOfLayerBy(materialIndex));
/*     */       }
/* 502 */       sb.append("\r\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getCommentOfLayerBy(int materialIndex) {
/* 507 */     if (materialIndex == 0) {
/* 508 */       return "              !- Outside Layer \t\r\n";
/*     */     }
/* 510 */     return "                    !- Layer " + (materialIndex + 1) + 
/* 511 */       "\t\t\r\n";
/*     */   }
/*     */ 
/*     */   public void writeCompactScheduleForGlobal(StringBuffer sb)
/*     */   {
/* 519 */     sb.append("Schedule:Compact, \r\nZone Control Type Sched, !- Name \r\nControl Type,            !- Schedule Type Limits Name \r\nThrough: 3/31,\r\nFor: AllDays,\r\nUntil: 24:00, 1,\r\nThrough: 9/30,\r\nFor: AllDays,\r\nUntil: 24:00, 2,\r\nThrough: 12/31,\r\nFor: AllDays,\r\nUntil: 24:00, 1;\r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeOutputVariables(ResultTimeStep resultTimeStep, StringBuffer sb)
/*     */   {
/* 534 */     sb.append("Output:Variable,*,Zone/Sys Sensible Cooling Rate," + 
/* 535 */       describeForResultTimeStep(resultTimeStep) + "; \r\n\r\n");
/*     */ 
/* 537 */     sb.append("Output:Variable,*,Zone/Sys Sensible Heating Rate," + 
/* 538 */       describeForResultTimeStep(resultTimeStep) + "; \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeOutputSurfaces(StringBuffer sb) {
/* 542 */     sb.append("Output:Surfaces:Drawing,DXF,Triangulate3DFace; \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writetGlobalGeometryRules(IDF idf, StringBuffer sb) {
/* 546 */     GlobalGeometryRules globalGeometryRules = idf.globalGeometryRules;
/*     */ 
/* 548 */     sb.append("GlobalGeometryRules, \r\n" + 
/* 549 */       globalGeometryRules.startingVertexPosition + 
/* 550 */       ",         !- Starting Vertex Position \r\n" + 
/* 551 */       globalGeometryRules.vertexEntryDirection + 
/* 552 */       ",        !- Vertex Entry Direction \r\n" + 
/* 553 */       globalGeometryRules.coordinateSystem + 
/* 554 */       ";   !- Coordinate System \r\n\r\n");
/*     */   }
/*     */ 
/*     */   void writeGlobalScheduleCompact(IDF idf, StringBuffer sb) {
/* 558 */     if (thereIsZoneVentilation(idf))
/* 559 */       sb.append("Schedule:Compact, \r\nVEN-SCHED,                !- Name \r\nANY NUMBER,              !- Schedule Type Limits Name \r\nThrough: 12/31,\r\nFor: Alldays,\r\nUntil: 24:00, 1.00;\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private boolean thereIsZoneVentilation(IDF idf)
/*     */   {
/* 568 */     return idf.getZoneVentilations().size() > 0;
/*     */   }
/*     */ 
/*     */   private String describeForResultTimeStep(ResultTimeStep timeStep) {
/* 572 */     switch (timeStep) {
/*     */     case Daily:
/* 574 */       return "Monthly";
/*     */     case Monthly:
/* 576 */       return "Daily";
/*     */     }
/* 578 */     return null;
/*     */   }
/*     */ 
/*     */   public void writeScheduleWeekDailies(IDF idf, StringBuffer sb) {
/* 582 */     Vector <ScheduleWeekDaily>scheduleWeekDailies = idf.scheduleWeekDailies;
/*     */ 
/* 584 */     for (ScheduleWeekDaily scheduleWeekDaily : scheduleWeekDailies)
/* 585 */       sb.append("Schedule:Week:Daily, \r\n" + 
/* 586 */         scheduleWeekDaily.name + 
/* 587 */         ",                 !- Name\t\r\n" + 
/* 588 */         scheduleWeekDaily.sunDaySchedule + 
/* 589 */         ",                 !- Sunday Schedule:Day Name\t\r\n" + 
/* 590 */         scheduleWeekDaily.monthDaySchedule + 
/* 591 */         ",                    !- Monday Schedule:Day Name\t\r\n" + 
/* 592 */         scheduleWeekDaily.tuesDaySchedule + 
/* 593 */         ",                    !- Tuesday Schedule:Day Name\t\r\n" + 
/* 594 */         scheduleWeekDaily.wednesDaySchedule + 
/* 595 */         ",                    !- Wednesday Schedule:Day Name\t\r\n" + 
/* 596 */         scheduleWeekDaily.thursDaySchedule + 
/* 597 */         ",                    !- Thursday Schedule:Day Name\t\r\n" + 
/* 598 */         scheduleWeekDaily.friDaySchedule + 
/* 599 */         ",                    !- Friday Schedule:Day Name\t\r\n" + 
/* 600 */         scheduleWeekDaily.saturDaySchedule + 
/* 601 */         ",                    !- Saturday Schedule:Day Name\t\r\n" + 
/* 602 */         scheduleWeekDaily.holiDaySchedule + 
/* 603 */         ",                    !- Holiday Schedule:Day Name\t\r\n" + 
/* 604 */         scheduleWeekDaily.summerDesignDaySchedule + 
/* 605 */         ",                    !- SummerDesignDay Schedule:Day Name\t\r\n" + 
/* 606 */         scheduleWeekDaily.winterDesignDaySchedule + 
/* 607 */         ",                    !- WinterDesignDay Schedule:Day Name\t\r\n" + 
/* 608 */         scheduleWeekDaily.customDay1Schedule + 
/* 609 */         ",                    !- CustomDay1 Schedule:Day Name\t\r\n" + 
/* 610 */         scheduleWeekDaily.customDay2Schedule + 
/* 611 */         ";                    !- CustomDay2 Schedule:Day Name\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   public void writeYearSchedules(IDF idf, StringBuffer sb)
/*     */   {
/* 616 */     if ((idf == null) || (sb == null)) {
/* 617 */       throw new NullPointerException();
/*     */     }
/* 619 */     Vector <ScheduleYear>scheduleYears = idf.scheduleYears;
/*     */ 
/* 621 */     for (ScheduleYear scheduleYear : scheduleYears)
/* 622 */       sb.append("Schedule:Year, \r\n" + scheduleYear.name + 
/* 623 */         ",                !- Name\t\r\n" + 
/* 624 */         scheduleYear.typeLimitsName + 
/* 625 */         ",                !- Schedule Type Limits Name\t\r\n" + 
/* 626 */         scheduleYear.weekName + 
/* 627 */         ",                 !- Schedule:Week Name 1\t\r\n" + 
/* 628 */         scheduleYear.startMonth + 
/* 629 */         ",                       !- Start Month 1\t\r\n" + 
/* 630 */         scheduleYear.startDay + 
/* 631 */         ",                       !- Start Day 1\t\r\n" + 
/* 632 */         scheduleYear.endMonth + 
/* 633 */         ",                      !- End Month 1\t\r\n" + 
/* 634 */         scheduleYear.endDay + 
/* 635 */         ";                      !- End Day 1\t\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   public void writeIdfZoneList(HashMap<String, IdfZoneList> zoneLists, StringBuffer stringBuffer)
/*     */   {
/* 641 */     for (String zoneListId : zoneLists.keySet()) {
/* 642 */       IdfZoneList zoneList = (IdfZoneList)zoneLists.get(zoneListId);
/*     */ 
/* 644 */       stringBuffer.append("ZoneList,\r\n");
/* 645 */       stringBuffer.append(zoneList.id() + ",              !- Name\r\n");
/*     */ 
/* 647 */       for (int i = 0; i < zoneList.getNumberOfZones(); i++) {
/* 648 */         Boolean zoneIndexIsList = Boolean.valueOf(i == zoneList.getNumberOfZones() - 1);
/* 649 */         String divider = zoneIndexIsList.booleanValue() ? ";" : ",";
/*     */ 
/* 651 */         stringBuffer.append(zoneList.getZoneIdRef(i) + divider + 
/* 652 */           "     \t  !- Zone " + (i + 1) + " Name\r\n");
/*     */       }
/* 654 */       stringBuffer.append("\r\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void writeMaterials(IDF idf, StringBuffer sb1) {
/* 659 */     if ((idf == null) || (sb1 == null)) {
/* 660 */       throw new NullPointerException();
/*     */     }
/* 662 */     Vector <Material>idfMaterials = idf.idfMaterials;
/*     */ 
/* 664 */     for (Material idfMaterial : idfMaterials) {
/* 665 */       sb1.append(getMaterialTitle(idfMaterial) + ",\r\n");
/* 666 */       sb1.append(idfMaterial.name + ",  !- Name \r\n");
/* 667 */       sb1.append(idfMaterial.getRoughness() + 
/* 668 */         ",                   !- Roughness\r\n");
/* 669 */       if (idfMaterial.hasMass()) {
/* 670 */         sb1.append(idfMaterial.getThickness() + 
/* 671 */           ",               !- Thickness {m}\r\n");
/* 672 */         sb1.append(idfMaterial.getConductvity() + 
/* 673 */           ",               !- Conductivity {W/m-K}\r\n");
/* 674 */         sb1.append(idfMaterial.getDensity() + 
/* 675 */           ",                !- Density {kg/m3}\r\n");
/* 676 */         sb1.append(idfMaterial.getSpecificHeat() + 
/* 677 */           ",                !- Specific Heat {J/kg-K}\r\n");
/*     */       } else {
/* 679 */         sb1.append(idfMaterial.thermalResistance + 
/* 680 */           ",             !- Thermal Resistance {m2-K/W}\r\n");
/*     */       }
/*     */ 
/* 683 */       sb1.append(idfMaterial.getThermalAbsorptance() + 
/* 684 */         ",               !- Thermal Absorptance\r\n\r\n");
/* 685 */       sb1.append(idfMaterial.getSolarAbsorptance() + 
/* 686 */         ",               !- Solar Absorptance\r\n");
/* 687 */       sb1.append(idfMaterial.getVisibleAbsorptance() + 
/* 688 */         ";               !- Visible Absorptance\r\n\r\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getMaterialTitle(Material idfMaterial) {
/* 693 */     if (idfMaterial.hasMass()) {
/* 694 */       return "Material";
/*     */     }
/* 696 */     return "Material:NoMass";
/*     */   }
/*     */ 
/*     */   private void writeSurfacePropertiesOnZoneToBuffer(StringBuffer currentZoneInfo, BuildingSurface idfSurface)
/*     */   {
/* 702 */     currentZoneInfo
/* 703 */       .append("BuildingSurface:Detailed, \r\n" + 
/* 704 */       idfSurface.name + 
/* 705 */       ",           !- Name \r\n" + 
/* 706 */       idfSurface.surfaceType + 
/* 707 */       ",                    !- Surface Type \r\n" + 
/* 708 */       idfSurface.constructionName + 
/* 709 */       ",                  !- Construction Name \r\n" + 
/* 710 */       (String)idfSurface.zoneNames.get(0) + 
/* 711 */       ",               !- Zone Name \r\n" + 
/* 712 */       idfSurface.boundaryCondition + 
/* 713 */       ",                        !- Outside Boundary Condition \r\n" + 
/* 714 */       idfSurface.boundaryConditionObject + 
/* 715 */       ",                        !- Outside Boundary Condition Object \r\n" + 
/* 716 */       idfSurface.sunExposure + 
/* 717 */       ",              !- Sun Exposure \r\n" + 
/* 718 */       idfSurface.windExporsure + 
/* 719 */       ",             !- Wind Exposure \r\n" + 
/* 720 */       idfSurface.viewFactor() + 
/* 721 */       ",                        !- View Factor to Ground \r\n" + 
/* 722 */       idfSurface.vertices.size() + 
/* 723 */       ",                       !- Number of Vertices \r\n");
/*     */   }
/*     */ 
/*     */   private void writeVerticesToSurfaceBuffer(StringBuffer currentZoneInfo, Vector<EDIVector3> vertices)
/*     */   {
/* 729 */     for (int cnt = 0; cnt < vertices.size(); cnt++)
/*     */     {
/* 731 */       currentZoneInfo.append(
/* 732 */         String.format("%.6f", new Object[] { ((EDIVector3)vertices.get(cnt)).x }) + 
/* 733 */         "," + String.format("%.6f", new Object[] { ((EDIVector3)vertices.get(cnt)).y }) + "," + 
/* 734 */         String.format("%.6f", new Object[] { ((EDIVector3)vertices.get(cnt)).z }));
/*     */ 
/* 736 */       Boolean lastElement = Boolean.valueOf(cnt == vertices.size() - 1);
/* 737 */       String divider = lastElement.booleanValue() ? ";" : ",";
/* 738 */       currentZoneInfo.append(divider + " \t\t\t!- Vertex " + (cnt + 1) + 
/* 739 */         " {m} \r\n");
/*     */     }
/* 741 */     currentZoneInfo.append("\r\n");
/*     */   }
/*     */ 
/*     */   StringBuffer getSurfaceInfoBuffer(BuildingSurface idfSurface)
/*     */   {
/* 746 */     StringBuffer idfSurfaceBuffer = new StringBuffer();
/* 747 */     writeSurfacePropertiesOnZoneToBuffer(idfSurfaceBuffer, idfSurface);
/* 748 */     writeVerticesToSurfaceBuffer(idfSurfaceBuffer, idfSurface.vertices);
/* 749 */     return idfSurfaceBuffer;
/*     */   }
/*     */ 
/*     */   public void writeWindowMaterials(IDF idf, StringBuffer sb1) {
/* 753 */     if ((idf == null) || (sb1 == null))
/* 754 */       throw new NullPointerException();
/* 755 */     Vector <WindowMaterialSimpleGlazingSystem>windowMaterials = idf.windowMaterials;
/*     */ 
/* 757 */     for (WindowMaterialSimpleGlazingSystem windowMaterial : windowMaterials)
/* 758 */       sb1.append("WindowMaterial:SimpleGlazingSystem, \r\n" + 
/* 759 */         windowMaterial.name + ",            !- Name \r\n" + 
/* 760 */         windowMaterial.uFactor + 
/* 761 */         ",                       !- U-Factor {W/m2-K} \r\n" + 
/* 762 */         windowMaterial.solarHeatGainCoefficient + 
/* 763 */         ",            !- Solar Heat Gain Coefficient  \r\n" + 
/* 764 */         windowMaterial.visibleTransmittance + 
/* 765 */         "; \t\t\t!- Visible Transmittance \r\n\r\n");
/*     */   }
/*     */ 
/*     */   public void writeBuildingSurfaces(HashMap<String, BuildingSurface> hashOfSurface, StringBuffer bufferForSurfaces)
/*     */   {
/* 773 */     for (String surfaceKey : hashOfSurface.keySet()) {
/* 774 */       BuildingSurface buildingSurface = (BuildingSurface)hashOfSurface.get(surfaceKey);
/* 775 */       bufferForSurfaces.append(getSurfaceInfoBuffer(buildingSurface));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void writeFenestrationSurface(IDF idf, StringBuffer sb) throws Exception
/*     */   {
/* 781 */     for (String key : idf.buildingSurfaces.keySet()) {
/* 782 */       BuildingSurface buildingSurface = (BuildingSurface)idf.buildingSurfaces.get(key);
/*     */ 
/* 784 */       if (buildingSurface.fenestrationSurfaces == null) {
/*     */         continue;
/*     */       }
/* 787 */       for (FenestrationSurface fenestrationSurface : buildingSurface.fenestrationSurfaces) {
/* 788 */         sb.append("FenestrationSurface:Detailed,    \r\n" + 
/* 789 */           fenestrationSurface.name + 
/* 790 */           ",  \t      !- Name \r\n" + 
/* 791 */           fenestrationSurface.surfaceType + 
/* 792 */           ",                  !- Surface Type \r\n" + 
/* 793 */           fenestrationSurface.constructionName + 
/* 794 */           ",         !- Construction Name \r\n" + 
/* 795 */           fenestrationSurface.buildingSurfaceName + 
/* 796 */           ",           !- Building Surface Name \r\n" + 
/* 797 */           ",                        !- Outside Boundary Condition Object \r\n" + 
/* 798 */           "0.5000000,               !- View Factor to Ground \r\n" + 
/* 799 */           ",                        !- Shading Control Name \r\n" + 
/* 800 */           ",                        !- Frame and Divider Name \r\n" + 
/* 801 */           "1.0,                     !- Multiplier \r\n" + 
/* 802 */           fenestrationSurface.numberOfVerrices + 
/* 803 */           ",                       !- Number of Vertices \r\n");
/*     */ 
/* 805 */         writeVerticesToSurfaceBuffer(sb, 
/* 806 */           fenestrationSurface.vertexCoordinate);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*
public void writeZoneSimulationControl(IDF idf, StringBuffer sb) {
    for (String key : idf.zoneLists.keySet())
   {
      IdfZoneList zoneList = (IdfZoneList)idf.zoneLists.get(key);

      if (!idf.isVAVSystem()) {
        writeZoneControl(zoneList.zoneControl, sb);
       writeThermostatSetpoints(zoneList.thermostatSetpoints, sb);
      }
      writeScheduleCompactForZone(zoneList, sb);
    }
  }
*/
/*     */   private void writeZoneControl(ZoneControl zoneControl, StringBuffer sb)
/*     */   {
/* 826 */     sb.append("ZoneControl:Thermostat,\t\r\n" + zoneControl.name + 
/* 827 */       ",     \t\t\t!- Name\t\r\n" + zoneControl.zoneOrZoneListName + 
/* 828 */       ",               \t\t\t\t!- Zone or ZoneList Name\t\r\n" + 
/* 829 */       zoneControl.controlTypeScheduleName + 
/* 830 */       ", \t\t\t\t!- Control Type Schedule Name\t\t\r\n" + 
/* 831 */       ((ControlObject)zoneControl.controlObjects.get(0)).type + 
/* 832 */       ", \t\t!- Control 1 Object Type\t\t\r\n" + 
/* 833 */       ((ControlObject)zoneControl.controlObjects.get(0)).name + 
/* 834 */       ",\t\t\t\t!- Control 1 Name\t\t\r\n" + 
/* 835 */       ((ControlObject)zoneControl.controlObjects.get(1)).type + 
/* 836 */       ",  \t!- Control 2 Object Type\t\t\r\n" + 
/* 837 */       ((ControlObject)zoneControl.controlObjects.get(1)).name + 
/* 838 */       ";\t\t\t\t!- Control 2 Name\t\t\r\n\r\n");
/*     */   }
/*     */ 
/*     */   private void writeThermostatSetpoints(Vector<ThermostatSetpoint> thermostatSetpoints, StringBuffer sb)
/*     */   {
/* 843 */     for (ThermostatSetpoint thermostatSetpointInZone : thermostatSetpoints)
/*     */     {
/* 845 */       sb.append("ThermostatSetpoint:" + thermostatSetpointInZone.type + 
/* 846 */         ",\t\t\r\n" + thermostatSetpointInZone.name + 
/* 847 */         ", !- Name\t\t\r\n" + 
/* 848 */         thermostatSetpointInZone.setpointTemperatureScheduleName + 
/* 849 */         ";        !- Setpoint Temperature Schedule Name\t\r\n\r\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void writeScheduleCompactForZone(IdfZoneList zoneList, StringBuffer sb)
/*     */   {
/* 855 */     for (ScheduleCompact scheduleCompact : zoneList.scheduleCompacts)
/* 856 */       writeScheduleCompact(scheduleCompact, sb);
/*     */   }
/*     */ 
/*     */   private void writeScheduleCompact(ScheduleCompact scheduleCompact, StringBuffer sb)
/*     */   {
/* 862 */     sb.append("Schedule:Compact, \r\n" + scheduleCompact.name + 
/* 863 */       ",       !- Name \r\n" + 
/* 864 */       scheduleCompact.scheduleTypeLimitsName + 
/* 865 */       ",             !- Schedule Type Limits Name \r\n");
/*     */ 
/* 867 */     for (Through through : scheduleCompact.throughs) {
/* 868 */       sb.append("Through: " + through.date + ",\r\n");
/* 869 */       for (For forday : through.fors) {
/* 870 */         sb.append("For: " + forday.day + ",\r\n");
/*     */ 
/* 872 */         for (int untilIndex = 0; untilIndex < forday.untils.size(); untilIndex++) {
/* 873 */           Until until = (Until)forday.untils.get(untilIndex);
/*     */ 
/* 875 */           if (through == scheduleCompact.throughs
/* 876 */             .lastElement());
/* 875 */           boolean currentUntilIsLastElement = 
/* 877 */             (forday == through.fors.lastElement()) && 
/* 878 */             (until == forday.untils.lastElement());
/*     */ 
/* 880 */           String divier = ",";
/* 881 */           if (currentUntilIsLastElement) {
/* 882 */             divier = ";";
/*     */           }
/*     */ 
/* 885 */           sb.append("Until: " + 
/* 886 */             ((Until)forday.untils.get(untilIndex)).getTime() + ", " + 
/* 887 */             ((Until)forday.untils.get(untilIndex)).getValue() + divier + 
/* 888 */             "\r\n");
/*     */         }
/*     */       }
/*     */     }
/* 892 */     sb.append("\r\n");
/*     */   }
/*     */ 
/*     */   private void writeZoneVentilations(IDF idf, StringBuffer sb) {
/* 896 */     for (ZoneVentilation zoneVentilation : idf.getZoneVentilations())
/* 897 */       writeZoneVentilation(zoneVentilation, sb);
/*     */   }
/*     */ 
/*     */   private void writeZoneVentilation(ZoneVentilation zoneVentilation, StringBuffer buffer)
/*     */   {
/* 903 */     buffer.append("ZoneVentilation:DesignFlowRate,\r\n" + 
/* 904 */       zoneVentilation.name + 
/* 905 */       ",                        !- Name\r\n" + 
/* 906 */       zoneVentilation.zoneListName + 
/* 907 */       ",                        !- Zone or ZoneList Name\r\n" + 
/* 908 */       zoneVentilation.scheduleName + 
/* 909 */       ",                        !- Schedule Name\r\n" + 
/* 910 */       zoneVentilation.getDesignFlowRateCalculationMethod() + 
/* 911 */       ",         !- Design Flow Rate Calculation Method\r\n" + 
/* 912 */       ",                        !- Design Flow Rate {m3/s}\r\n" + 
/* 913 */       ",                        !- Flow Rate per Zone Floor Area {m3/s-m2}\r\n" + 
/* 914 */       ",                        !- Flow Rate per Person {m3/s-person}\r\n" + 
/* 915 */       zoneVentilation.getAirChangePerHour() + 
/* 916 */       ",                        !- Air Changes per Hour\r\n" + 
/* 917 */       zoneVentilation.ventilationType + 
/* 918 */       ",                 !- Ventilation Type\r\n" + 
/* 919 */       zoneVentilation.fanPressureRise + 
/* 920 */       ",                        !- Fan Pressure Rise {Pa}\r\n" + 
/* 921 */       zoneVentilation.fanTotalEfficiency + 
/* 922 */       ",                       !- Fan Total Efficiency\r\n" + 
/* 923 */       zoneVentilation.constantTermCoefficient + 
/* 924 */       ",                       !- Constant Term Coefficient\r\n" + 
/* 925 */       zoneVentilation.temperatureTermCoefficient + 
/* 926 */       ",                        !- Temperature Term Coefficient\r\n" + 
/* 927 */       zoneVentilation.velocityTermCoefficient + 
/* 928 */       ",                        !- Velocity Term Coefficient\r\n" + 
/* 929 */       zoneVentilation.velocitySquaredTermCoefficient + 
/* 930 */       ",                        !- Velocity Squared Term Coefficient\r\n" + 
/* 931 */       ",                    !- Minimum Indoor Temperature {C}\r\n" + 
/* 932 */       ",                        !- Minimum Indoor Temperature Schedule Name\r\n" + 
/* 933 */       ",                     !- Maximum Indoor Temperature {C}\r\n" + 
/* 934 */       ",                        !- Maximum Indoor Temperature Schedule Name\r\n" + 
/* 935 */       ",                    !- Delta Temperature {deltaC}\r\n" + 
/* 936 */       ",                        !- Delta Temperature Schedule Name\r\n" + 
/* 937 */       ",                    !- Minimum Outdoor Temperature {C}\r\n" + 
/* 938 */       ",                        !- Minimum Outdoor Temperature Schedule Name\r\n" + 
/* 939 */       ",                     !- Maximum Outdoor Temperature {C}\r\n" + 
/* 940 */       ",                        !- Maximum Outdoor Temperature Schedule Name\r\n" + 
/* 941 */       ";                      !- Maximum Wind Speed {m/s}\r\n");
/*     */   }
/*     */ 
/*     */   public void writeGroundTemperature(GroundTemperature groundTemp, StringBuffer target)
/*     */   {
/* 952 */     target.append("Site:GroundTemperature:BuildingSurface,\r\n");
/*     */ 
/* 954 */     for (int i = 0; i < groundTemp.getTemperatures().size(); i++) {
/* 955 */       String temperature = String.format("%." + this.significantFigure + "f", new Object[] { 
/* 956 */         groundTemp.getTemperatures().get(i) });
/* 957 */       target.append(temperature);
/*     */ 
/* 959 */       String divider = ",";
/* 960 */       if (i == groundTemp.getTemperatures().size() - 1) {
/* 961 */         divider = ";";
/*     */       }
/* 963 */       int currentMonth = i + 1;
/* 964 */       target.append(divider + getGroundTempValueCommentBy(currentMonth));
/*     */     }
/*     */ 
/* 967 */     target.append("\r\n");
/*     */   }
/*     */ 
/*     */   private String getGroundTempValueCommentBy(int month) {
/* 971 */     assert (month <= 12);
/* 972 */     return "!- " + this.months[month] + " Ground Temperature {C}\r\n";
/*     */   }
/*     */ 
/*     */   public void writeIdfFile(StringBuffer sb, String fileName) throws IOException
/*     */   {
/* 977 */     FileWriter f = new FileWriter(new File(fileName));
/* 978 */     f.write(sb.toString());
/* 979 */     f.close();
/*     */   }
/*     */ 
/*     */   static enum ResultTimeStep
/*     */   {
/*  16 */     Monthly, Daily;
/*     */   }
/*     */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IdfFileWriter
 * JD-Core Version:    0.6.0
 */