/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullCubicMeterPerSec extends CubicMeterPerSec
/*    */ {
/*    */   public NullCubicMeterPerSec()
/*    */   {
/*  8 */     super(0.0D);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 13 */     return "Null m3/s";
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 19 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullCubicMeterPerSec
 * JD-Core Version:    0.6.0
 */