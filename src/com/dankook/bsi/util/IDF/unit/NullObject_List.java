/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class NullObject_List extends Object_List
/*    */ {
/*    */   public NullObject_List()
/*    */   {
/*  6 */     super("");
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 12 */     return "Null ObjectList";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 18 */     return o instanceof NullObject_List;
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 24 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.NullObject_List
 * JD-Core Version:    0.6.0
 */