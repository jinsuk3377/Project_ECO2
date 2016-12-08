/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullReal extends Real
/*    */ {
/*    */   public NullReal()
/*    */   {
/*  6 */     super(0.0D);
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 14 */     return (o instanceof NullReal);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return "Null Real";
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 30 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullReal
 * JD-Core Version:    0.6.0
 */