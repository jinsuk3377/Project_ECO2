/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.unit.Degree;
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class DegreeTest
/*    */ {
/*    */   @Test
/*    */   public void Defulat()
/*    */   {
/* 15 */     Assert.assertThat(new Degree().toString(), CoreMatchers.equalTo("0.0"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void Equal() {
/* 21 */     Assert.assertThat(new Degree(Double.valueOf(1.0D)), CoreMatchers.equalTo(new Degree(Double.valueOf(1.0D))));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void Different() {
/* 27 */     Assert.assertThat(new Degree(Double.valueOf(1.0D)), CoreMatchers.not(CoreMatchers.equalTo(new Degree(Double.valueOf(2.0D)))));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void CreateByString()
/*    */   {
/* 34 */     Degree five = new Degree("5.0");
/*    */ 
/* 37 */     Assert.assertThat(five.getValue(), CoreMatchers.is(Double.valueOf(5.0D)));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.DegreeTest
 * JD-Core Version:    0.6.0
 */