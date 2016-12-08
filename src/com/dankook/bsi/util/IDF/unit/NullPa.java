/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullPa extends Pa
/*    */ {
/*    */   public NullPa()
/*    */   {
/*  6 */     super(Double.valueOf(0.0D));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 12 */     return "";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 20 */     return (o instanceof NullPa);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullPa
 * JD-Core Version:    0.6.0
 */