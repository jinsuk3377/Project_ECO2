/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class DryBulbTemperatureRangeModifierType extends Choice
/*    */ {
/*  5 */   public static final DryBulbTemperatureRangeModifierType NULL = new NullDryBulbTemperatureRangeModifierType();
/*    */ 
/*    */   public DryBulbTemperatureRangeModifierType(String type)
/*    */   {
/*  9 */     super(type);
/* 10 */     add("MultiplierSchedule");
/* 11 */     add("DifferenceSchedule");
/* 12 */     add("DefaultMultipliers");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.DryBulbTemperatureRangeModifierType
 * JD-Core Version:    0.6.0
 */