/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class TimeStep
/*    */ {
/*    */   private Integer _value;
/*    */ 
/*    */   public TimeStep(int timeStep)
/*    */   {
/*  9 */     this._value = Integer.valueOf(timeStep);
/*    */   }
/*    */ 
/*    */   public Integer getValue()
/*    */   {
/* 14 */     return this._value;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return this._value.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.TimeStep
 * JD-Core Version:    0.6.0
 */