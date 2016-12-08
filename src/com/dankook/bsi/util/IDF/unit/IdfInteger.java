/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.IdfElement;
/*    */ 
/*    */ public class IdfInteger
/*    */   implements IdfElement
/*    */ {
/*  7 */   public static final IdfInteger NULL = new NullInteger();
/*    */   private Integer value;
/*    */ 
/*    */   public IdfInteger(int value)
/*    */   {
/* 12 */     this.value = Integer.valueOf(value);
/*    */   }
/*    */ 
/*    */   public IdfInteger(Integer value)
/*    */   {
/* 17 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 23 */     return this.value.toString();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 29 */     if ((o instanceof IdfInteger))
/*    */     {
/* 31 */       IdfInteger idfInteger = (IdfInteger)o;
/* 32 */       return this.value.equals(idfInteger.value);
/*    */     }
/*    */ 
/* 35 */     return this.value.equals(o);
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 41 */     return this.value.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.IdfInteger
 * JD-Core Version:    0.6.0
 */