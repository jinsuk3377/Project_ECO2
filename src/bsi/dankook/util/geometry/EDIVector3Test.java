/*    */ package bsi.dankook.util.geometry;
/*    */ 
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class EDIVector3Test
/*    */ {
/*    */   @Test
/*    */   public void Equals()
/*    */   {
/* 14 */     EDIVector3 vector1 = new EDIVector3(Double.valueOf(1.0D), Double.valueOf(2.0D), Double.valueOf(3.0D));
/* 15 */     EDIVector3 vector2 = new EDIVector3(Double.valueOf(1.0D), Double.valueOf(2.0D), Double.valueOf(3.0D));
/*    */ 
/* 17 */     Assert.assertThat(vector1, CoreMatchers.equalTo(vector1));
/* 18 */     Assert.assertThat(vector1, CoreMatchers.equalTo(vector2));
/* 19 */     Assert.assertThat(vector2, CoreMatchers.not(CoreMatchers.equalTo(new EDIVector3(Double.valueOf(2.0D), Double.valueOf(3.0D), Double.valueOf(4.0D)))));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.geometry.EDIVector3Test
 * JD-Core Version:    0.6.0
 */