/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullCelsius extends Celsius
/*    */ {
/*    */   public NullCelsius()
/*    */   {
/*  7 */     super(0.0D);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 12 */     return "";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 18 */     return (o instanceof NullCelsius);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullCelsius
 * JD-Core Version:    0.6.0
 */