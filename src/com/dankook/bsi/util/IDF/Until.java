/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class Until
/*    */ {
/*    */   private String _time;
/*    */   private Double _value;
/*    */ 
/*    */   public String getTime()
/*    */   {
/* 10 */     return this._time;
/*    */   }
/*    */ 
/*    */   public Double getValue()
/*    */   {
/* 15 */     return this._value;
/*    */   }
/*    */ 
/*    */   public Until(String time, double value)
/*    */   {
/* 21 */     this._time = time;
/* 22 */     this._value = Double.valueOf(value);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.Until
 * JD-Core Version:    0.6.0
 */