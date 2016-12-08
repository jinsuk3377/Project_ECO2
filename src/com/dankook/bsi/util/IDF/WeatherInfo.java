/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class WeatherInfo
/*    */ {
/*    */   private String name;
/*    */   private Double latitude;
/*    */   private Double longitude;
/*    */   private Double timeZone;
/*    */   private Double elevation;
/*    */ 
/*    */   public WeatherInfo()
/*    */   {
/* 13 */     setToDefault();
/*    */   }
/*    */ 
/*    */   private void setToDefault()
/*    */   {
/* 18 */     this.name = "";
/* 19 */     this.latitude = Double.valueOf(0.0D);
/* 20 */     this.longitude = Double.valueOf(0.0D);
/* 21 */     this.timeZone = Double.valueOf(0.0D);
/* 22 */     this.elevation = Double.valueOf(0.0D);
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 26 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 29 */     this.name = name;
/*    */   }
/*    */   public Double getLatitude() {
/* 32 */     return this.latitude;
/*    */   }
/*    */   public void setLatitude(Double latitude) {
/* 35 */     this.latitude = latitude;
/*    */   }
/*    */   public Double getLongitude() {
/* 38 */     return this.longitude;
/*    */   }
/*    */   public void setLongitude(Double longitude) {
/* 41 */     this.longitude = longitude;
/*    */   }
/*    */   public Double getTimeZone() {
/* 44 */     return this.timeZone;
/*    */   }
/*    */   public void setTimeZone(Double timeZone) {
/* 47 */     this.timeZone = timeZone;
/*    */   }
/*    */   public Double getElevation() {
/* 50 */     return this.elevation;
/*    */   }
/*    */   public void setElevation(Double elevation) {
/* 53 */     this.elevation = elevation;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.WeatherInfo
 * JD-Core Version:    0.6.0
 */