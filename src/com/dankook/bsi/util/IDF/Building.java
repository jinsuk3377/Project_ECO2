/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.unit.Degree;
/*    */ 
/*    */ public class Building
/*    */ {
/*  7 */   public String name = "";
/*    */   public Degree northAxis;
/*  9 */   public String terrain = "";
/*    */   public Double lodsConvergenceTolerance;
/*    */   public Double temperatureConvergenceTolerance;
/*    */   public String solarDistribution;
/*    */   public Integer maximumNumberOfWarmupDays;
/* 15 */   private String[] solarDistributions = { "MinimumShadowing", "FullExterior", "FullInteriorAndExterior", "FullExteriorWithReflections", "FullInteriorAndExteriorWithReflections" };
/*    */ 
/*    */   public Building(String name) {
/* 18 */     this.name = name;
/* 19 */     setToDefault();
/*    */   }
/*    */ 
/*    */   public int getNuberOfOptionForSolarDist()
/*    */   {
/* 24 */     return this.solarDistributions.length;
/*    */   }
/*    */ 
/*    */   public String getSolarDistOption(int i)
/*    */   {
/* 29 */     return this.solarDistributions[i];
/*    */   }
/*    */ 
/*    */   private void setToDefault()
/*    */   {
/* 34 */     this.northAxis = new Degree(Double.valueOf(0.0D));
/* 35 */     this.terrain = "Suburbs";
/* 36 */     this.lodsConvergenceTolerance = Double.valueOf(0.039999999D);
/* 37 */     this.temperatureConvergenceTolerance = Double.valueOf(0.4D);
/* 38 */     this.solarDistribution = "FullExterior";
/* 39 */     this.maximumNumberOfWarmupDays = Integer.valueOf(25);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.Building
 * JD-Core Version:    0.6.0
 */