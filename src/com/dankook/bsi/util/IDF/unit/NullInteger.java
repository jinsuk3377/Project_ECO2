/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullInteger extends IdfInteger
/*    */ {
/*    */   public NullInteger()
/*    */   {
/*  6 */     super(0);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 12 */     return "Null Integer";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 20 */     return (o instanceof NullInteger);
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 30 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullInteger
 * JD-Core Version:    0.6.0
 */