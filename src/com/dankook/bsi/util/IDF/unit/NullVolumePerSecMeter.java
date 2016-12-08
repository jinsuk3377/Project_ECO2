/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullVolumePerSecMeter extends VolumePerSecMeter
/*    */ {
/*    */   public String toString()
/*    */   {
/*  8 */     return "Null m3/s*m2";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 15 */     return (o instanceof NullVolumePerSecMeter);
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 24 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullVolumePerSecMeter
 * JD-Core Version:    0.6.0
 */