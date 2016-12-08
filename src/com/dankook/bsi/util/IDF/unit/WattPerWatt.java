/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class WattPerWatt
/*    */ {
/*    */   private Double value;
/*    */ 
/*    */   public WattPerWatt(double v)
/*    */   {
/*  9 */     this.value = Double.valueOf(v);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 15 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 21 */     if ((o instanceof WattPerWatt))
/*    */     {
/* 23 */       WattPerWatt wpw = (WattPerWatt)o;
/* 24 */       return this.value.equals(wpw.value);
/*    */     }
/*    */ 
/* 27 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.WattPerWatt
 * JD-Core Version:    0.6.0
 */