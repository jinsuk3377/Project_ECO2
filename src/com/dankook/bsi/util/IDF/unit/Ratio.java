/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Ratio
/*    */ {
/*  5 */   public static final Ratio NULL = new NullRatio();
/*  6 */   private Double value = Double.valueOf(0.0D);
/*    */ 
/*    */   public Ratio(double d) {
/*  9 */     this.value = Double.valueOf(d);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 14 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 20 */     if ((o instanceof Ratio))
/*    */     {
/* 22 */       Ratio ratio = (Ratio)o;
/* 23 */       return this.value.equals(ratio.value);
/*    */     }
/*    */ 
/* 27 */     return this.value.equals(o);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Ratio
 * JD-Core Version:    0.6.0
 */