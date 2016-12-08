/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.IdfElement;
/*    */ 
/*    */ public class CubicMeterPerSec
/*    */   implements IdfElement
/*    */ {
/*  7 */   public static final CubicMeterPerSec AUTO_SIZE = new AutoSizeCubicMeterPerSec();
/*  8 */   public static final CubicMeterPerSec NULL = new NullCubicMeterPerSec();
/*  9 */   private Double value = Double.valueOf(0.0D);
/*    */ 
/*    */   public CubicMeterPerSec(double value)
/*    */   {
/* 13 */     this.value = Double.valueOf(value);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 18 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 23 */     if ((o instanceof CubicMeterPerSec))
/*    */     {
/* 25 */       CubicMeterPerSec volumePerSec = (CubicMeterPerSec)o;
/* 26 */       return this.value.equals(volumePerSec.value);
/*    */     }
/*    */ 
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 35 */     return this.value.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.CubicMeterPerSec
 * JD-Core Version:    0.6.0
 */