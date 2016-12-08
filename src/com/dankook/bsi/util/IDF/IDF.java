/*     */ package com.dankook.bsi.util.IDF;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class IDF
/*     */ {
/*     */   public HashMap<String, BuildingSurface> buildingSurfaces;
/*     */   public HashMap<String, IdfZoneList> zoneLists;
/*  16 */   private Vector<ZoneVentilation> _zoneVentilations = new Vector();
/*  17 */   private GroundTemperature _groundTemperature = new GroundTemperature();
/*     */   private Version version;
/*     */   public String surfaceConvectionAlgorithmInside;
/*     */   public String surfaceConvectionAlgorithmOutside;
/*     */   public String heatBalanceAlgorithm;
/*     */   public SiteLocation siteLocation;
/*     */   public Vector<ScheduleDayHourly> scheduleDayHourlys;
/*     */   public Vector<ScheduleWeekDaily> scheduleWeekDailies;
/*     */   public Vector<ScheduleYear> scheduleYears;
/*     */   public Vector<Material> idfMaterials;
/*     */   public Vector<WindowMaterialSimpleGlazingSystem> windowMaterials;
/*     */   public Vector<Construction> constructionsForWindowType;
/*  30 */   public Vector<Construction> constructions = new Vector();
/*  31 */   public GlobalGeometryRules globalGeometryRules = new GlobalGeometryRules();
/*     */   public static final String IDEAL_LOAD_AIR_SYSTEM = "IdealLoadAirSystem";
/*     */   public static final String VAV_SYSTEM = "Vav";
/*     */   public static final String FanCoil = "FanCoil";
/*     */   public static final String CAV = "CAV";
/*  38 */   private String hvacSystemType = "IdealLoadAirSystem";
/*     */   private TimeStep _timeStep;
/*     */   private Building building;
/*     */   private ZoneControls zoneControls;
/*     */   private SimulationParameters simulationParameters;
/*     */   private ThermostatSetpoints thermostatSetpoints;
/*     */   private HashMap<String, IdfZone> hashOfZones;
/*  47 */   private DesignDays designDays = null;
/*  49 */   private SizingParameters sizingParameters = new SizingParameters();
/*     */ 
/*  51 */   private WeatherInfo weatherInfo = null;
/*     */ 
/*     */   public IDF()
/*     */   {
/*  55 */     this.hashOfZones = new HashMap();
/*  56 */     this.simulationParameters = new SimulationParameters();
/*  57 */     this.zoneControls = new ZoneControls();
/*  58 */     this.thermostatSetpoints = new ThermostatSetpoints();
/*     */ 
/*  60 */     setToDefault();
/*     */   }
/*     */ 
/*     */   private void setToDefault()
/*     */   {
/*  65 */     setVersion(new Version(Double.valueOf(6.0D)));
/*  66 */     this._timeStep = new TimeStep(6);
/*  67 */     this.building = new Building("UnknownBuilding");
/*  68 */     this.surfaceConvectionAlgorithmInside = "TARP";
/*  69 */     this.surfaceConvectionAlgorithmOutside = "DOE-2";
/*  70 */     this.heatBalanceAlgorithm = "ConductionTransferFunction";
/*     */ 
/*  72 */     setGlobalGeometryRulesToDefault();
/*     */   }
/*     */ 
/*     */   private void setGlobalGeometryRulesToDefault()
/*     */   {
/*  77 */     this.globalGeometryRules.startingVertexPosition = "LowerLeftCorner";
/*  78 */     this.globalGeometryRules.vertexEntryDirection = "CounterClockWise";
/*  79 */     this.globalGeometryRules.coordinateSystem = "Relative";
/*     */   }
/*     */ 
/*     */   public GroundTemperature getGroundTemperature()
/*     */   {
/*  84 */     return this._groundTemperature;
/*     */   }
/*     */ 
/*     */   public Vector<ZoneVentilation> getZoneVentilations()
/*     */   {
/*  89 */     return this._zoneVentilations;
/*     */   }
/*     */ 
/*     */   public void setVersion(Version version)
/*     */   {
/*  94 */     assert (version != null);
/*  95 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public Version getVersion()
/*     */   {
/* 100 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setTimeStep(TimeStep timeStep)
/*     */   {
/* 105 */     this._timeStep = timeStep;
/*     */   }
/*     */ 
/*     */   public TimeStep getTimeStep()
/*     */   {
/* 110 */     return this._timeStep;
/*     */   }
/*     */ 
/*     */   public Building getBuilding()
/*     */   {
/* 115 */     return this.building;
/*     */   }
/*     */ 
/*     */   public ZoneControls getZoneControls()
/*     */   {
/* 120 */     return this.zoneControls;
/*     */   }
/*     */ 
/*     */   public ThermostatSetpoints getThermostatSetpoints()
/*     */   {
/* 125 */     if (this.hvacSystemType.equals("IdealLoadAirSystem")) {
/* 126 */       return this.thermostatSetpoints;
/*     */     }
/*     */ 
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   public ZoneHvac getZoneHvac()
/*     */   {
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   public SimulationParameters getSimulationParameters()
/*     */   {
/* 140 */     return this.simulationParameters;
/*     */   }
/*     */ 
/*     */   public LocationClimateWeatherFileAccess getLocationClimateWeatherFileAccess()
/*     */   {
/* 150 */     LocationClimateWeatherFileAccess lcwFileAcesss = new LocationClimateWeatherFileAccess();
/* 151 */     lcwFileAcesss.setSizingPeriod(new SizingPeriod());
/* 152 */     return lcwFileAcesss;
/*     */   }
/*     */ 
/*     */   public String getHvacSystemType()
/*     */   {
/* 169 */     return this.hvacSystemType;
/*     */   }
/*     */ 
/*     */   public void addZone(IdfZone zone)
/*     */   {
/* 174 */     getZones().put(zone.name, zone);
/*     */   }
/*     */ 
/*     */   public HashMap<String, IdfZone> getZones() {
/* 178 */     return this.hashOfZones;
/*     */   }
/*     */ 
/*     */   public void setZones(HashMap<String, IdfZone> hashOfZones) {
/* 182 */     this.hashOfZones = hashOfZones;
/*     */   }
/*     */ 
/*     */   public DesignDays getDesignDays()
/*     */   {
/* 187 */     return this.designDays;
/*     */   }
/*     */ 
/*     */   public void setDesignDays(DesignDays designDays) {
/* 191 */     this.designDays = designDays;
/*     */   }
/*     */ 
/*     */   public SizingParameters getSizingParameters() {
/* 195 */     return this.sizingParameters;
/*     */   }
/*     */ 
/*     */   public void setSizingParameters(SizingParameters sizingParameters) {
/* 199 */     this.sizingParameters = sizingParameters;
/*     */   }
/*     */ 
/*     */   public void setSimulationParameters(SimulationParameters simulationParameters)
/*     */   {
/* 209 */     this.simulationParameters = simulationParameters;
/*     */   }
/*     */ 
/*     */   public void setWeatherInfo(WeatherInfo weatherInfo) {
/* 217 */     this.weatherInfo = weatherInfo;
/* 218 */     this.siteLocation.name = weatherInfo.getName();
/*     */   }
/*     */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.IDF
 * JD-Core Version:    0.6.0
 */