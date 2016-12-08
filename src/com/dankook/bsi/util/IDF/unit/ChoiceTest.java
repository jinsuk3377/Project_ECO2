/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class ChoiceTest
/*    */ {
/*    */   @Test
/*    */   public void Create()
/*    */   {
/* 14 */     Choice choice = new Choice();
/*    */ 
/* 17 */     List keys = choice.getKeys();
/*    */ 
/* 20 */     Assert.assertThat(Integer.valueOf(keys.size()), CoreMatchers.is(Integer.valueOf(0)));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void AddKey()
/*    */   {
/* 27 */     Choice choice = new Choice();
/*    */ 
/* 30 */     choice.add("None");
/*    */ 
/* 33 */     Assert.assertThat(Integer.valueOf(choice.getKeys().size()), CoreMatchers.is(Integer.valueOf(1)));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.ChoiceTest
 * JD-Core Version:    0.6.0
 */