/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Meter
/*    */ {
/*  5 */   public static final NullMeter NULL = new NullMeter(0.0D);
/*    */   private Double value;
/*    */ 
/*    */   public Meter(double meter)
/*    */   {
/* 10 */     this.value = Double.valueOf(meter);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 15 */     return this.value.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Meter
 * JD-Core Version:    0.6.0
 */