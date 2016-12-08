/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class HeatingType extends Choice
/*    */ {
/*    */   public HeatingType(String string)
/*    */   {
/*  8 */     super(string);
/*  9 */     add("HotWater");
/* 10 */     add("Electric");
/* 11 */     add("None");
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 17 */     if ((o instanceof HeatingType))
/*    */     {
/* 19 */       return super.equals(o);
/*    */     }
/*    */ 
/* 22 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.HeatingType
 * JD-Core Version:    0.6.0
 */