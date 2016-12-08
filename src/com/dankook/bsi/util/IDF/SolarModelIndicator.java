/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.unit.Choice;
/*    */ 
/*    */ public class SolarModelIndicator extends Choice
/*    */ {
/*  7 */   public static final SolarModelIndicator NULL = new NullSolarModelIndicator();
/*    */ 
/*    */   public SolarModelIndicator(String indicator) {
/* 10 */     super(indicator);
/* 11 */     add("ASHRAEClearSky");
/* 12 */     add("ZhangHuang");
/* 13 */     add("Schedule");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.SolarModelIndicator
 * JD-Core Version:    0.6.0
 */