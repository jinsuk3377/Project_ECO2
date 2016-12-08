/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Watt
/*    */ {
/*  5 */   public static final Watt NULL = new NullWatt();
/*  6 */   public static final Watt AUTO_SIZE = new AutosizeWatt();
/*    */   private Double value;
/*    */ 
/*    */   public Watt(double value)
/*    */   {
/* 12 */     this.value = Double.valueOf(value);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 17 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 22 */     if ((o instanceof Watt))
/*    */     {
/* 24 */       return this.value.equals(((Watt)o).value);
/*    */     }
/*    */ 
/* 27 */     return this.value.equals(o);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Watt
 * JD-Core Version:    0.6.0
 */