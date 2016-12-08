/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class Version
/*    */ {
/*    */   private Double _version;
/*    */ 
/*    */   public Version(Double version)
/*    */   {
/*  9 */     this._version = version;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 14 */     return String.format("%.1f", new Object[] { this._version });
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.Version
 * JD-Core Version:    0.6.0
 */