/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class YesNoTest
/*    */ {
/*    */   @Test
/*    */   public void YES_Should_Print_Yes()
/*    */   {
/* 12 */     Assert.assertThat(YesNo.YES.toString(), CoreMatchers.equalTo("Yes"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void YES_Shouldnt_Print_No() {
/* 18 */     Assert.assertThat(YesNo.YES.toString(), CoreMatchers.not(CoreMatchers.equalTo("No")));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void NO_Should_Print_No() {
/* 24 */     Assert.assertThat(YesNo.NO.toString(), CoreMatchers.equalTo("No"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void YES_Shouldnt_Print_Yes() {
/* 30 */     Assert.assertThat(YesNo.NO.toString(), CoreMatchers.not(CoreMatchers.equalTo("Yes")));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void YES_And_NO_AreDifferent() {
/* 36 */     Assert.assertThat(YesNo.YES, CoreMatchers.not(CoreMatchers.equalTo(YesNo.NO)));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void YesAndAnotherYes_HaveToBe_Same()
/*    */   {
/* 43 */     YesNo yes = YesNo.YES;
/* 44 */     YesNo anotherYes = YesNo.YES;
/*    */ 
/* 47 */     Assert.assertThat(yes, CoreMatchers.equalTo(anotherYes));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.YesNoTest
 * JD-Core Version:    0.6.0
 */