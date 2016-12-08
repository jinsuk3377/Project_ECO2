/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Degree
/*    */ {
/*    */   private Double value;
/*    */ 
/*    */   public Degree()
/*    */   {
/*  9 */     this.value = Double.valueOf(0.0D);
/*    */   }
/*    */ 
/*    */   public Degree(Double degree)
/*    */   {
/* 14 */     this.value = degree;
/*    */   }
/*    */ 
/*    */   public Degree(String s) {
/* 18 */     this.value = new Double(s);
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 22 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 30 */     return ((obj instanceof Degree)) && 
/* 30 */       (this.value.equals(((Degree)obj).value));
/*    */   }
/*    */   public Double getValue() {
/* 33 */     return this.value;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Degree
 * JD-Core Version:    0.6.0
 */