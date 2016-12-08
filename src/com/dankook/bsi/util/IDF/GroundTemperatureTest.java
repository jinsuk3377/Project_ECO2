/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class GroundTemperatureTest
/*    */ {
/*    */   @Test
/*    */   public void DefaultGroundTemperature_Type()
/*    */   {
/* 16 */     GroundTemperature groundTemperature = new GroundTemperature();
/*    */ 
/* 19 */     Assert.assertThat(groundTemperature.type(), CoreMatchers.equalTo("BuildingSurface"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void DefaultGroundTemperature_TemperaturesByMonth()
/*    */   {
/* 26 */     GroundTemperature groundTemperature = new GroundTemperature();
/*    */ 
/* 32 */     Vector expectedTemperatures = new Vector();
/* 33 */     expectedTemperatures.add(Double.valueOf(20.030000000000001D));
/* 34 */     expectedTemperatures.add(Double.valueOf(20.030000000000001D));
/* 35 */     expectedTemperatures.add(Double.valueOf(20.129999999999999D));
/* 36 */     expectedTemperatures.add(Double.valueOf(20.300000000000001D));
/* 37 */     expectedTemperatures.add(Double.valueOf(20.43D));
/* 38 */     expectedTemperatures.add(Double.valueOf(20.52D));
/* 39 */     expectedTemperatures.add(Double.valueOf(20.620000000000001D));
/* 40 */     expectedTemperatures.add(Double.valueOf(20.77D));
/* 41 */     expectedTemperatures.add(Double.valueOf(20.780000000000001D));
/* 42 */     expectedTemperatures.add(Double.valueOf(20.550000000000001D));
/* 43 */     expectedTemperatures.add(Double.valueOf(20.440000000000001D));
/* 44 */     expectedTemperatures.add(Double.valueOf(20.199999999999999D));
/*    */ 
/* 46 */     Assert.assertThat(groundTemperature.getTemperatures(), CoreMatchers.equalTo(expectedTemperatures));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.GroundTemperatureTest
 * JD-Core Version:    0.6.0
 */