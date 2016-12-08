/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class testIdfBasic
/*    */ {
/*    */   @Test
/*    */   public void testCreate()
/*    */   {
/* 13 */     IDF idf = new IDF();
/* 14 */     SimulationParameters simulationParam = idf.getSimulationParameters();
/*    */ 
/* 17 */     Assert.assertNotNull(simulationParam);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.testIdfBasic
 * JD-Core Version:    0.6.0
 */