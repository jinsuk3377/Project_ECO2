/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.IDF.unit.Choice;
/*    */ 
/*    */ public class DayType extends Choice
/*    */ {
/*    */   public DayType(String string)
/*    */   {
/*  8 */     super(string);
/*  9 */     add("Sunday");
/* 10 */     add("Monday");
/* 11 */     add("Tuesday");
/* 12 */     add("Wednesday");
/* 13 */     add("Thursday");
/* 14 */     add("Friday");
/* 15 */     add("Saturday");
/* 16 */     add("Holiday");
/* 17 */     add("SummerDesignDay");
/* 18 */     add("WinterDesignDay");
/* 19 */     add("CustomDay1");
/* 20 */     add("CustomDay2");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.DayType
 * JD-Core Version:    0.6.0
 */