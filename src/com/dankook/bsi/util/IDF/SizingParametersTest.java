/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class SizingParametersTest
/*    */ {
/*    */   @Test
/*    */   public void toIdfDesc_ElementName()
/*    */   {
/* 16 */     SizingParameters sizingParameters = new SizingParameters();
/*    */ 
/* 19 */     String idfDesc = sizingParameters.toIdfDesc()
/* 20 */       .replace("\n", "").replace("\r", "");
/* 21 */     String[] elements = idfDesc.split(",");
/*    */ 
/* 24 */     Assert.assertThat(Integer.valueOf(elements.length), CoreMatchers.is(Integer.valueOf(4)));
/* 25 */     Assert.assertThat(elements[0], CoreMatchers.is("Sizing:Parameters"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void toIdfDdesc_ElementsWithoutComment()
/*    */   {
/* 32 */     SizingParameters sizingParameters = new SizingParameters();
/*    */ 
/* 35 */     String idfDesc = sizingParameters.toIdfDesc()
/* 36 */       .replace("\n", "").replace("\r", "");
/* 37 */     String[] elements = idfDesc.split(",");
/*    */ 
/* 40 */     Assert.assertThat(elements[1], CoreMatchers.is("1.2"));
/* 41 */     Assert.assertThat(elements[2], CoreMatchers.is("1.2"));
/* 42 */     Assert.assertThat(elements[3], CoreMatchers.is(";"));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.SizingParametersTest
 * JD-Core Version:    0.6.0
 */