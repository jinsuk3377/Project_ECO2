/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class ChillerType extends Choice
/*    */ {
/*    */   public ChillerType(String chillerType)
/*    */   {
/*  8 */     super(chillerType);
/*  9 */     add("DistrictChilledWater");
/* 10 */     add("ElectricCentrifugalChiller");
/* 11 */     add("ElectricReciprocationgChiller");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.ChillerType
 * JD-Core Version:    0.6.0
 */