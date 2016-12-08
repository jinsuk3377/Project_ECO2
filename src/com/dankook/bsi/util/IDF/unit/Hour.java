/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Hour
/*    */ {
/*  5 */   public static final NullHour NULL = new NullHour(0.0D);
/*    */   private Double value;
/*    */ 
/*    */   public Hour(double hour)
/*    */   {
/*  8 */     this.value = Double.valueOf(hour);
/*    */   }
/*    */ 
/*    */   public Double getValue()
/*    */   {
/* 15 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return this.value.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Hour
 * JD-Core Version:    0.6.0
 */