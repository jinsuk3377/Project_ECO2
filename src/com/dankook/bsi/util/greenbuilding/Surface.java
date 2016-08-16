/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ import java.util.Vector;

import com.dankook.bsi.util.geometry.EDIVector3;
/*    */ 
/*    */ public class Surface
/*    */ {
/*    */   public String id;
/*    */   public String surfaceType;
/*    */   public String constructionIdRef;
/*    */   public Vector<String> adjacentSpaceIds;
/*    */   public Vector<EDIVector3> cartesianPoints;
/* 17 */   private Vector<Opening> _openings = null;
/*    */ 
/*    */   public Surface()
/*    */   {
/* 21 */     this.cartesianPoints = null;
/* 22 */     this.adjacentSpaceIds = new Vector();
/*    */   }
/*    */ 
/*    */   public Vector<Opening> getOpenings()
/*    */   {
/* 27 */     if (this._openings == null) {
/* 28 */       this._openings = new Vector();
/*    */     }
/* 30 */     return this._openings;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Surface
 * JD-Core Version:    0.6.0
 */