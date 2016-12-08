/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class testSimulationParameters
/*    */ {
/*    */   @Test
/*    */   public void testCreate()
/*    */   {
/* 12 */     SimulationParameters sp = new SimulationParameters();
/* 13 */     SimulationControl sc = sp.getSimulationControl();
/* 14 */     Assert.assertNotNull(sc);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.testSimulationParameters
 * JD-Core Version:    0.6.0
 */