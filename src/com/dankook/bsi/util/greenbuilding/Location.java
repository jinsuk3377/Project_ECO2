/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ public class Location
/*    */ {
/*  5 */   private String _name = "";
/*  6 */   private String _latitude = "";
/*  7 */   private String _longitude = "";
/*  8 */   private String _CADModelAzimuth = "";
/*    */ 
/*    */   public String name() {
/* 11 */     return this._name;
/*    */   }
/*    */ 
/*    */   public String latitude() {
/* 15 */     return this._latitude;
/*    */   }
/*    */ 
/*    */   public String longitude() {
/* 19 */     return this._longitude;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 23 */     this._name = name;
/*    */   }
/*    */ 
/*    */   public void setLatitude(String latitude) {
/* 27 */     this._latitude = latitude;
/*    */   }
/*    */ 
/*    */   public void setLongitude(String longitude) {
/* 31 */     this._longitude = longitude;
/*    */   }
/*    */ 
/*    */   public String getCADmodelAzimuth() {
/* 35 */     return this._CADModelAzimuth;
/*    */   }
/*    */ 
/*    */   public void setCADModelAzimuth(String cadModelAzimuth) {
/* 39 */     this._CADModelAzimuth = cadModelAzimuth;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Location
 * JD-Core Version:    0.6.0
 */