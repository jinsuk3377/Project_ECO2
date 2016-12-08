/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.unit.IdfInteger;
/*    */ import com.dankook.bsi.util.IDF.unit.Real;
/*    */ 
/*    */ public class SizingParameters
/*    */   implements IdfElement
/*    */ {
/*    */   public Real getHeatingSizingFactor()
/*    */   {
/* 10 */     return new Real(1.2D);
/*    */   }
/*    */ 
/*    */   public Real getCoolingSizingFactor() {
/* 14 */     return new Real(1.2D);
/*    */   }
/*    */ 
/*    */   public IdfInteger getTimestepsInAveragingWindow() {
/* 18 */     return IdfInteger.NULL;
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 24 */     String formatString = "Sizing:Parameters,\r\n%s,\r\n%s,\r\n%s;\r\n";
/*    */ 
/* 26 */     String idfDesc = String.format(formatString, new Object[] { 
/* 27 */       getHeatingSizingFactor().toIdfDesc(), 
/* 28 */       getCoolingSizingFactor().toIdfDesc(), 
/* 29 */       getTimestepsInAveragingWindow().toIdfDesc() });
/* 30 */     return idfDesc;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.SizingParameters
 * JD-Core Version:    0.6.0
 */