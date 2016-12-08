/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class CondenserWaterTemperatureControlType extends Choice
/*    */ {
/*  6 */   public static CondenserWaterTemperatureControlType NULL = new NULLCondenserWaterTemperatureControlType();
/*    */ 
/*    */   public CondenserWaterTemperatureControlType()
/*    */   {
/* 10 */     setToDefault();
/*    */   }
/*    */ 
/*    */   public CondenserWaterTemperatureControlType(String string) {
/* 14 */     super(string);
/* 15 */     setToDefault();
/*    */   }
/*    */ 
/*    */   private void setToDefault() {
/* 19 */     add("OutdoorWetBulbTemperature");
/* 20 */     add("SpecifiedSetpoint");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.CondenserWaterTemperatureControlType
 * JD-Core Version:    0.6.0
 */