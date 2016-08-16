/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ public class WeekSchedule
/*    */ {
/*    */   private final String _id;
/*    */   private final String _type;
/*    */   public Day day;
/*    */ 
/*    */   public String id()
/*    */   {
/*  9 */     return this._id; } 
/* 10 */   public String type() { return this._type; }
/*    */ 
/*    */   public WeekSchedule(String id, String type)
/*    */   {
/* 14 */     this._id = id;
/* 15 */     this._type = type;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.WeekSchedule
 * JD-Core Version:    0.6.0
 */