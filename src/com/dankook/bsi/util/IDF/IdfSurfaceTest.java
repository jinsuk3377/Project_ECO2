/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class IdfSurfaceTest
/*    */ {
/*    */   @Test
/*    */   public void ViewFactorToGround_SurfaceType_is_Wall()
/*    */   {
/* 15 */     BuildingSurface surface = new BuildingSurface();
/*    */ 
/* 18 */     surface.surfaceType = "Wall";
/*    */ 
/* 21 */     Assert.assertThat(surface.viewFactor(), CoreMatchers.is("0.5"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void ViewFactorToGround_SurfaceType_is_Roof()
/*    */   {
/* 28 */     BuildingSurface surface = new BuildingSurface();
/*    */ 
/* 31 */     surface.surfaceType = "Roof";
/*    */ 
/* 34 */     Assert.assertThat(surface.viewFactor(), CoreMatchers.is("0"));
/*    */   }
/*    */ 
/*    */   @Test
/*    */   public void ViewFactorToGround_SurfaceType_is_()
/*    */   {
/* 41 */     BuildingSurface surface = new BuildingSurface();
/*    */ 
/* 44 */     surface.surfaceType = "Floor";
/*    */ 
/* 47 */     Assert.assertThat(surface.viewFactor(), CoreMatchers.is("1"));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.IdfSurfaceTest
 * JD-Core Version:    0.6.0
 */