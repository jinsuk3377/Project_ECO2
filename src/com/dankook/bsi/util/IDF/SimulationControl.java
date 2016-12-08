/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class SimulationControl
/*    */ {
/*    */   public YesNo doZoneSizingCalculation;
/*    */   public YesNo doSystemSizingCalculation;
/*    */   public YesNo doPlantSizingCalculation;
/*    */   public YesNo runSimulationForSizingPeriods;
/*    */   public YesNo runSimulationForWeatherFileRunPeriods;
/*    */ 
/*    */   public SimulationControl()
/*    */   {
/* 54 */     setToDefault();
/*    */   }
/*    */ 
/*    */   private void setToDefault()
/*    */   {
/* 61 */     this.doZoneSizingCalculation = YesNo.NO;
/* 62 */     this.doSystemSizingCalculation = YesNo.NO;
/* 63 */     this.doPlantSizingCalculation = YesNo.NO;
/*    */ 
/* 66 */     this.runSimulationForSizingPeriods = YesNo.NO;
/* 67 */     this.runSimulationForWeatherFileRunPeriods = YesNo.YES;
/*    */   }
/*    */ 
/*    */   public SimulationControl getSimulationControl()
/*    */   {
/* 76 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.SimulationControl
 * JD-Core Version:    0.6.0
 */