/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.IdfElement;
/*    */ 
/*    */ public class Percent
/*    */   implements IdfElement
/*    */ {
/*  7 */   public static final Percent NULL = new NullPercent();
/*    */   private Double value;
/*    */ 
/*    */   public Percent(double value)
/*    */   {
/* 11 */     this.value = Double.valueOf(value);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 16 */     return this.value.toString() + "%";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 21 */     if ((o instanceof Percent))
/*    */     {
/* 23 */       Percent percent = (Percent)o;
/* 24 */       return this.value.equals(percent.value);
/*    */     }
/*    */ 
/* 27 */     return this.value.equals(o);
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 33 */     return toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Percent
 * JD-Core Version:    0.6.0
 */