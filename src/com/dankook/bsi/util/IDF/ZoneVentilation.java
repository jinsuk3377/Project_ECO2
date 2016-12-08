/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class ZoneVentilation
/*    */ {
/*    */   private Double airChangePerHour;
/*    */   private String _designFlowRateCalculationMethod;
/*  7 */   public String name = "";
/*  8 */   public String zoneListName = "";
/*  9 */   public String scheduleName = "";
/* 10 */   public String ventilationType = "";
/*    */   public Double fanPressureRise;
/*    */   public Double fanTotalEfficiency;
/*    */   public Double constantTermCoefficient;
/*    */   public Double temperatureTermCoefficient;
/*    */   public Double velocityTermCoefficient;
/*    */   public Double velocitySquaredTermCoefficient;
/*    */ 
/*    */   public ZoneVentilation()
/*    */   {
/* 20 */     setToDefault();
/*    */   }
/*    */ 
/*    */   private void setToDefault() {
/* 24 */     setAirChangePerHour(Double.valueOf(0.0D));
/* 25 */     this._designFlowRateCalculationMethod = "AirChanges/Hour";
/* 26 */     this.scheduleName = "VEN-SCHED";
/*    */ 
/* 28 */     this.ventilationType = "Natural";
/* 29 */     this.fanPressureRise = Double.valueOf(0.0D);
/* 30 */     this.fanTotalEfficiency = Double.valueOf(1.0D);
/* 31 */     this.constantTermCoefficient = Double.valueOf(0.606D);
/* 32 */     this.temperatureTermCoefficient = Double.valueOf(0.020199999D);
/* 33 */     this.velocityTermCoefficient = Double.valueOf(0.00059800001D);
/* 34 */     this.velocitySquaredTermCoefficient = Double.valueOf(0.0D);
/*    */   }
/*    */ 
/*    */   public String getDesignFlowRateCalculationMethod()
/*    */   {
/* 41 */     return this._designFlowRateCalculationMethod;
/*    */   }
/*    */ 
/*    */   public void setAirChangePerHour(Double airChangePerHour)
/*    */   {
/* 46 */     this.airChangePerHour = airChangePerHour;
/*    */   }
/*    */ 
/*    */   public Double getAirChangePerHour()
/*    */   {
/* 51 */     return this.airChangePerHour;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.ZoneVentilation
 * JD-Core Version:    0.6.0
 */