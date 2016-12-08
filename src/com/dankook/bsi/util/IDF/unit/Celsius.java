/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Celsius
/*    */ {
/*  5 */   public static final Celsius NULL = new NullCelsius();
/*    */   private Double value;
/*    */ 
/*    */   public Double getValue()
/*    */   {
/* 11 */     return this.value;
/*    */   }
/*    */ 
/*    */   public Celsius(double value)
/*    */   {
/* 16 */     this.value = Double.valueOf(value);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 21 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 26 */     if ((o instanceof Celsius))
/*    */     {
/* 28 */       Celsius celsius = (Celsius)o;
/* 29 */       return this.value.equals(celsius.value);
/*    */     }
/*    */ 
/* 32 */     return this.value.equals(o);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Celsius
 * JD-Core Version:    0.6.0
 */