/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Pa
/*    */ {
/*  6 */   public static final Pa NULL = new NullPa();
/*    */   private Double value;
/*    */ 
/*    */   public Pa(Double pa)
/*    */   {
/*  9 */     this.value = pa;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 14 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object pa)
/*    */   {
/* 19 */     if ((pa instanceof Pa))
/*    */     {
/* 21 */       return this.value.equals(((Pa)pa).value);
/*    */     }
/*    */ 
/* 24 */     return this.value.equals(pa);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Pa
 * JD-Core Version:    0.6.0
 */