/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class GroundTemperature
/*    */ {
/*  7 */   private Vector<Double> _temperatures = new Vector();
/*    */ 
/*    */   public GroundTemperature()
/*    */   {
/* 11 */     this._temperatures.clear();
/* 12 */     this._temperatures.add(Double.valueOf(20.030000000000001D));
/* 13 */     this._temperatures.add(Double.valueOf(20.030000000000001D));
/* 14 */     this._temperatures.add(Double.valueOf(20.129999999999999D));
/* 15 */     this._temperatures.add(Double.valueOf(20.300000000000001D));
/* 16 */     this._temperatures.add(Double.valueOf(20.43D));
/* 17 */     this._temperatures.add(Double.valueOf(20.52D));
/* 18 */     this._temperatures.add(Double.valueOf(20.620000000000001D));
/* 19 */     this._temperatures.add(Double.valueOf(20.77D));
/* 20 */     this._temperatures.add(Double.valueOf(20.780000000000001D));
/* 21 */     this._temperatures.add(Double.valueOf(20.550000000000001D));
/* 22 */     this._temperatures.add(Double.valueOf(20.440000000000001D));
/* 23 */     this._temperatures.add(Double.valueOf(20.199999999999999D));
/*    */   }
/*    */ 
/*    */   public String type()
/*    */   {
/* 28 */     return "BuildingSurface";
/*    */   }
/*    */ 
/*    */   public Vector<Double> getTemperatures()
/*    */   {
/* 33 */     return this._temperatures;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.GroundTemperature
 * JD-Core Version:    0.6.0
 */