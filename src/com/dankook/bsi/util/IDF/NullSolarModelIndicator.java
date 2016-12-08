/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class NullSolarModelIndicator extends SolarModelIndicator
/*    */ {
/*    */   public NullSolarModelIndicator()
/*    */   {
/*  7 */     super("");
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 15 */     return (o instanceof NullSolarModelIndicator);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.NullSolarModelIndicator
 * JD-Core Version:    0.6.0
 */