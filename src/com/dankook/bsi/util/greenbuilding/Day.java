/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ public class Day
/*    */ {
/*    */   private String _dayType;
/*    */   private String _dayScheduleIdRef;
/*    */ 
/*    */   public Day(String dayType, String dayScheduleIdRef)
/*    */   {
/*  9 */     this._dayType = dayType;
/* 10 */     this._dayScheduleIdRef = dayScheduleIdRef;
/*    */   }
/*    */   public String dayType() {
/* 13 */     return this._dayType; } 
/* 14 */   public String dayScheduleIdRef() { return this._dayScheduleIdRef;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Day
 * JD-Core Version:    0.6.0
 */