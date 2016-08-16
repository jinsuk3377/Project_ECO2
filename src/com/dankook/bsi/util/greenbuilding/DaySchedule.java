/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ public class DaySchedule
/*    */ {
/*    */   private String _id;
/*    */   private String _type;
/*    */   public String[] scheduleValues;
/*    */ 
/*    */   public String id()
/*    */   {
/*  9 */     return this._id; } 
/* 10 */   public String type() { return this._type; }
/*    */ 
/*    */   public DaySchedule(String id, String type) {
/* 13 */     this._id = id;
/* 14 */     this._type = type;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.DaySchedule
 * JD-Core Version:    0.6.0
 */