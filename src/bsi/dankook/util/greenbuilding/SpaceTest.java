/*    */ package bsi.dankook.util.greenbuilding;
/*    */ 
/*    */ import org.hamcrest.CoreMatchers;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class SpaceTest
/*    */ {
/*    */   @Test
/*    */   public void createSpaceWithId()
/*    */   {
/* 18 */     Assert.assertThat(new Space("Space1").id(), CoreMatchers.is("Space1"));
/* 19 */     Assert.assertThat(new Space("Space2").id(), CoreMatchers.is("Space2"));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.SpaceTest
 * JD-Core Version:    0.6.0
 */