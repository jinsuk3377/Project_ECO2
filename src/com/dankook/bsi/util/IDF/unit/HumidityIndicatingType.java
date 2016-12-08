/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class HumidityIndicatingType extends Choice
/*    */ {
/*    */   public HumidityIndicatingType(String type)
/*    */   {
/*  6 */     super(type);
/*  7 */     add("WetBulb");
/*  8 */     add("DewPoint");
/*  9 */     add("HumidityRatio");
/* 10 */     add("Enthalpy");
/* 11 */     add("Schedule");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.HumidityIndicatingType
 * JD-Core Version:    0.6.0
 */