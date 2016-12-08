/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class IdealLoadsAirSystem
/*    */ {
/*    */   public String name;
/*    */   public String zoneSupplyAirzNodeName;
/*    */   public String heatingSupplyAirTemperature;
/*    */   public String coolingSupplyAirTemperature;
/*    */   public Double heatingSupplyAirHumidityRatio;
/*    */   public Double coolingSupplyAirHumidityRatio;
/*    */   public String heatinglimit;
/*    */   public String maximumHeatingAirFlowRate;
/*    */   public String coolingLimit;
/*    */   public String maximumCoolingAirFlowRate;
/*    */   public String outdoorAir;
/*    */   public String outdoorAirFlowRate;
/*    */ 
/*    */   public IdealLoadsAirSystem()
/*    */   {
/* 21 */     setToDefault();
/*    */   }
/*    */ 
/*    */   private void setToDefault()
/*    */   {
/* 26 */     this.heatinglimit = "NoLimit";
/* 27 */     this.maximumHeatingAirFlowRate = "autosize";
/* 28 */     this.coolingLimit = "NoLimit";
/* 29 */     this.maximumCoolingAirFlowRate = "autosize";
/* 30 */     this.outdoorAir = "NoOutdoorAir";
/* 31 */     this.outdoorAirFlowRate = "autosize";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.IdealLoadsAirSystem
 * JD-Core Version:    0.6.0
 */