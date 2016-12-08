/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class MilesPerHour
/*    */ {
/*    */   private Double value;
/*    */ 
/*    */   public MilesPerHour(double d)
/*    */   {
/*  8 */     this.value = Double.valueOf(d);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 14 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 20 */     if ((o instanceof MilesPerHour))
/*    */     {
/* 22 */       MilesPerHour arg = (MilesPerHour)o;
/* 23 */       return this.value.equals(arg.value);
/*    */     }
/*    */ 
/* 26 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.MilesPerHour
 * JD-Core Version:    0.6.0
 */