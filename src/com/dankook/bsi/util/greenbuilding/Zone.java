/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ public class Zone
/*    */ {
/*    */   private String _id;
/*  8 */   public String airChangesPerHour = "";
/*  9 */   public String designHeatT = "";
/* 10 */   public String designCoolT = "";
/*    */ 
/* 12 */   public String id() { return this._id; }
/*    */ 
/*    */   public Zone(String id) {
/* 15 */     this._id = id;
/*    */ 
/* 17 */     this.designHeatT = "0.0";
/* 18 */     this.designCoolT = "0.0";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Zone
 * JD-Core Version:    0.6.0
 */