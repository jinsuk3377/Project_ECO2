/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.IdfElement;
/*    */ 
/*    */ public class Real
/*    */   implements IdfElement
/*    */ {
/*    */   private Double value;
/*  8 */   public static final Real NULL = new NullReal();
/*    */ 
/*    */   public Real(double d) {
/* 11 */     this.value = Double.valueOf(d);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 17 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 24 */     if ((o instanceof Real))
/*    */     {
/* 26 */       Real r = (Real)o;
/* 27 */       return this.value.equals(r.value);
/*    */     }
/*    */ 
/* 30 */     return this.value.equals(o);
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 36 */     return this.value.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Real
 * JD-Core Version:    0.6.0
 */