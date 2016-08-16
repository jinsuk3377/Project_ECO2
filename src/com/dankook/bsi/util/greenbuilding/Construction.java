/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Construction
/*    */ {
/*    */   private String _id;
/*    */   private Vector<String> _layers;
/*    */ 
/*    */   public String id()
/*    */   {
/* 13 */     return this._id;
/*    */   }
/*    */ 
/*    */   public Construction(String id) {
/* 17 */     this._id = id;
/* 18 */     this._layers = new Vector();
/*    */   }
/*    */ 
/*    */   public Vector<String> getLayerIds()
/*    */   {
/* 23 */     return this._layers;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Construction
 * JD-Core Version:    0.6.0
 */