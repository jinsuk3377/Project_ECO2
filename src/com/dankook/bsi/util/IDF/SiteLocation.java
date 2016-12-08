/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.unit.Degree;
/*    */ import com.dankook.bsi.util.IDF.unit.Hour;
/*    */ import com.dankook.bsi.util.IDF.unit.Meter;
/*    */ 
/*    */ public class SiteLocation
/*    */ {
/*    */   public String name;
/*    */   public Degree latitude;
/*    */   public Degree longitude;
/*    */   public Hour timeZone;
/*    */   public Meter elevation;
/*    */ 
/*    */   public SiteLocation()
/*    */   {
/* 18 */     this.timeZone = Hour.NULL;
/* 19 */     this.elevation = Meter.NULL;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.SiteLocation
 * JD-Core Version:    0.6.0
 */