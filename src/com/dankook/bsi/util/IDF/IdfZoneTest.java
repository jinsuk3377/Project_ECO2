/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.geometry.EDIVector3;
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class IdfZoneTest
/*    */ {
/*    */   @Test
/*    */   public void DefaultIdfZone()
/*    */   {
/* 19 */     IdfZone zone = new IdfZone();
/*    */ 
/* 22 */     Assert.assertThat(zone, CoreMatchers.not(CoreMatchers.nullValue()));
/*    */ 
/* 24 */     Assert.assertThat(Double.valueOf(zone.directionOfRelativeNorth()), CoreMatchers.is(Double.valueOf(0.0D)));
/* 25 */     Assert.assertThat(zone.origin(), CoreMatchers.equalTo(new EDIVector3(Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D))));
/* 26 */     Assert.assertThat(zone.type(), CoreMatchers.is(Integer.valueOf(1)));
/* 27 */     Assert.assertThat(zone.multiplier(), CoreMatchers.is(Double.valueOf(1.0D)));
/* 28 */     Assert.assertThat(zone.ceilingHeight(), CoreMatchers.is("autocalculate"));
/* 29 */     Assert.assertThat(zone.volume(), CoreMatchers.is("autocalculate"));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.IdfZoneTest
 * JD-Core Version:    0.6.0
 */