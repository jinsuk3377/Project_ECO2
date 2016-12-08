/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullWatt extends Watt
/*    */ {
/*    */   public NullWatt()
/*    */   {
/*  8 */     super(0.0D);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 13 */     return "";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 19 */     return (o instanceof NullWatt);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullWatt
 * JD-Core Version:    0.6.0
 */