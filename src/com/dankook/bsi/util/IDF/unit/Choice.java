/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Choice
/*    */ {
/*    */   private String value;
/*  9 */   private List<String> keys = new ArrayList();
/*    */ 
/*    */   public Choice() {
/* 12 */     this.value = "";
/*    */   }
/*    */ 
/*    */   public Choice(String value)
/*    */   {
/* 17 */     setValue(value);
/*    */   }
/*    */ 
/*    */   protected String getValue() {
/* 21 */     return this.value;
/*    */   }
/*    */ 
/*    */   protected void setValue(String value) {
/* 25 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 30 */     return this.value;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 36 */     if ((o instanceof Choice))
/*    */     {
/* 38 */       Choice c = (Choice)o;
/* 39 */       return this.value.equals(c.value);
/*    */     }
/*    */ 
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   public List<String> getKeys()
/*    */   {
/* 48 */     return this.keys;
/*    */   }
/*    */ 
/*    */   public void add(String key) {
/* 52 */     this.keys.add(key);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.Choice
 * JD-Core Version:    0.6.0
 */