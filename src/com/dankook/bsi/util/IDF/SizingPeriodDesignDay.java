/*     */ package com.dankook.bsi.util.IDF;
/*     */ 
/*     */ import com.dankook.bsi.util.IDF.unit.Celsius;
/*     */ import com.dankook.bsi.util.IDF.unit.DryBulbTemperatureRangeModifierType;
/*     */ import com.dankook.bsi.util.IDF.unit.HumidityIndicatingType;
/*     */ import com.dankook.bsi.util.IDF.unit.MilesPerHour;
/*     */ import com.dankook.bsi.util.IDF.unit.Object_List;
/*     */ import com.dankook.bsi.util.IDF.unit.Pa;
/*     */ import com.dankook.bsi.util.IDF.unit.Real;
/*     */ 
/*     */ public class SizingPeriodDesignDay
/*     */ {
/*     */   private String name;
/*     */   private Celsius maximumDry_BulbTemperature;
/*     */   private Real dailyTemperatureRange;
/*     */   private Real humidityIndicatingConditionsAtMaximumDryBulb;
/*     */   private Pa barometricPressure;
/*     */   private MilesPerHour windSpeed;
/*     */   private Real windDirection;
/*     */   private Real skyClearness;
/*     */   private Integer rainIndicator;
/*     */   private Integer snowIndicator;
/*     */   private Integer dayOfMonth;
/*     */   private Integer month;
/*     */   private DayType dayType;
/*     */   private int dayLightSavingTimeIndicator;
/*     */   private HumidityIndicatingType humidityIndicatinType;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  24 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  28 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Celsius getMaximumDry_BulbTemperature() {
/*  32 */     return this.maximumDry_BulbTemperature;
/*     */   }
/*     */ 
/*     */   public Real getDailyTemperatureRange() {
/*  36 */     return this.dailyTemperatureRange;
/*     */   }
/*     */ 
/*     */   public Real getHumidityIndicatingConditionsAtMaximumDryBulb() {
/*  40 */     return this.humidityIndicatingConditionsAtMaximumDryBulb;
/*     */   }
/*     */ 
/*     */   public Pa getBarometricPressure() {
/*  44 */     return this.barometricPressure;
/*     */   }
/*     */ 
/*     */   public MilesPerHour getWindSpeed() {
/*  48 */     return this.windSpeed;
/*     */   }
/*     */ 
/*     */   public Real getWindDirection() {
/*  52 */     return this.windDirection;
/*     */   }
/*     */ 
/*     */   public Real getSkyClearness() {
/*  56 */     return this.skyClearness;
/*     */   }
/*     */ 
/*     */   public void setSkyClearness(Real value)
/*     */   {
/*  61 */     this.skyClearness = value;
/*     */   }
/*     */ 
/*     */   public Integer getRainIndicator() {
/*  65 */     return this.rainIndicator;
/*     */   }
/*     */   public void setRainIndicator(int value) {
/*  68 */     this.rainIndicator = Integer.valueOf(value);
/*     */   }
/*     */ 
/*     */   public Integer getSnowIndicator() {
/*  72 */     return this.snowIndicator;
/*     */   }
/*     */ 
/*     */   public void setSnowIndicator(int value) {
/*  76 */     this.snowIndicator = Integer.valueOf(value);
/*     */   }
/*     */ 
/*     */   public void setMaximumDry_BulbTemperature(Celsius value) {
/*  80 */     this.maximumDry_BulbTemperature = value;
/*     */   }
/*     */ 
/*     */   public void setDailyTemperatureRange(Real dailyTemperatureRange) {
/*  84 */     this.dailyTemperatureRange = dailyTemperatureRange;
/*     */   }
/*     */ 
/*     */   public void setHumidityIndicatingConditionsAtMaximumDryBulb(Real humidityIndicatingConditionsAtMaximumDryBulb)
/*     */   {
/*  89 */     this.humidityIndicatingConditionsAtMaximumDryBulb = humidityIndicatingConditionsAtMaximumDryBulb;
/*     */   }
/*     */ 
/*     */   public void setBarometricPressure(Pa barometricPressure) {
/*  93 */     this.barometricPressure = barometricPressure;
/*     */   }
/*     */ 
/*     */   public void setWindSpeed(MilesPerHour value) {
/*  97 */     this.windSpeed = value;
/*     */   }
/*     */ 
/*     */   public void setWindDirection(Real value) {
/* 101 */     this.windDirection = value;
/*     */   }
/*     */ 
/*     */   public Integer getDayOfMonth() {
/* 105 */     return this.dayOfMonth;
/*     */   }
/*     */ 
/*     */   public void setDayOfMonth(Integer i) {
/* 109 */     this.dayOfMonth = i;
/*     */   }
/*     */ 
/*     */   public Integer getMonth() {
/* 113 */     return this.month;
/*     */   }
/*     */ 
/*     */   public void setMonth(Integer month)
/*     */   {
/* 118 */     this.month = month;
/*     */   }
/*     */ 
/*     */   public DayType getDayType() {
/* 122 */     return this.dayType;
/*     */   }
/*     */ 
/*     */   public void setDayType(DayType type)
/*     */   {
/* 127 */     this.dayType = type;
/*     */   }
/*     */ 
/*     */   public HumidityIndicatingType getHumidityIndicatinType() {
/* 131 */     return this.humidityIndicatinType;
/*     */   }
/*     */ 
/*     */   public void setHumidityIndicatinType(HumidityIndicatingType type)
/*     */   {
/* 136 */     this.humidityIndicatinType = type;
/*     */   }
/*     */ 
/*     */   public Object_List getRalativeHumidityDayScheduleName() {
/* 140 */     return Object_List.NULL;
/*     */   }
/*     */ 
/*     */   public DryBulbTemperatureRangeModifierType getDry_BulbTemperatureRangeModifierType() {
/* 144 */     return DryBulbTemperatureRangeModifierType.NULL;
/*     */   }
/*     */ 
/*     */   public SolarModelIndicator getSolarModelIndicator() {
/* 148 */     return SolarModelIndicator.NULL;
/*     */   }
/*     */ 
/*     */   public Object_List getBeamSolarDayScheduleName() {
/* 152 */     return Object_List.NULL;
/*     */   }
/*     */ 
/*     */   public Object_List getDiffuseSolarDayScheduleName() {
/* 156 */     return Object_List.NULL;
/*     */   }
/*     */ 
/*     */   public Integer getDaylightSavingTimeIndicator() {
/* 160 */     return Integer.valueOf(this.dayLightSavingTimeIndicator);
/*     */   }
/*     */ 
/*     */   public void setDayLightSavingTimeIndicator(Integer i) {
/* 164 */     this.dayLightSavingTimeIndicator = i.intValue();
/*     */   }
/*     */ 
/*     */   public Object_List getDryBulbTemperatureRangeModifieScheduleName() {
/* 168 */     return Object_List.NULL;
/*     */   }
/*     */ 
/*     */   public String toIdfDesc() {
/* 172 */     String formatString = "SizingPeriod:DesignDay,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s,\r\n%s;\r\n";
/*     */ 
/* 194 */     String idfDesc = String.format(formatString, new Object[] { 
/* 195 */       getName(), 
/* 196 */       getMaximumDry_BulbTemperature(), 
/* 197 */       getDailyTemperatureRange().toIdfDesc(), 
/* 198 */       getHumidityIndicatingConditionsAtMaximumDryBulb(), 
/* 199 */       getBarometricPressure(), 
/* 200 */       getWindSpeed(), 
/* 201 */       getWindDirection().toIdfDesc(), 
/* 202 */       getSkyClearness().toIdfDesc(), 
/* 203 */       getRainIndicator(), 
/* 204 */       getSnowIndicator(), 
/* 205 */       getDayOfMonth(), 
/* 206 */       getMonth(), 
/* 207 */       getDayType(), 
/* 208 */       getDaylightSavingTimeIndicator(), 
/* 209 */       getHumidityIndicatinType(), 
/* 210 */       getRalativeHumidityDayScheduleName().toIdfDesc(), 
/* 211 */       getDry_BulbTemperatureRangeModifierType(), 
/* 212 */       getDryBulbTemperatureRangeModifieScheduleName().toIdfDesc(), 
/* 213 */       getSolarModelIndicator(), 
/* 214 */       getBeamSolarDayScheduleName().toIdfDesc(), 
/* 215 */       getDiffuseSolarDayScheduleName().toIdfDesc() });
/*     */ 
/* 217 */     return idfDesc;
/*     */   }
/*     */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.SizingPeriodDesignDay
 * JD-Core Version:    0.6.0
 */