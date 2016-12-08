/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class Object_List
/*    */ {
/*    */   private String value;
/*  7 */   public static final Object_List NULL = new NullObject_List();
/*    */ 
/*    */   public Object_List(String name) {
/* 10 */     this.value = name;
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 15 */     return this.value;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 21 */     if ((o instanceof Object_List))
/*    */     {
/* 23 */       Object_List objectList = (Object_List)o;
/* 24 */       return this.value.equals(objectList.value);
/*    */     }
/*    */ 
/* 27 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Object_List
 * JD-Core Version:    0.6.0
 */