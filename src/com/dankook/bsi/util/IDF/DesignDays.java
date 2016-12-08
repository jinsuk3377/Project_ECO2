/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class DesignDays
/*    */ {
/*  7 */   private ArrayList<SizingPeriodDesignDay> designDays = new ArrayList();
/*    */ 
/*    */   public Integer size() {
/* 10 */     return Integer.valueOf(this.designDays.size());
/*    */   }
/*    */ 
/*    */   public void add(SizingPeriodDesignDay designDay)
/*    */   {
/* 15 */     this.designDays.add(designDay);
/*    */   }
/*    */ 
/*    */   public SizingPeriodDesignDay getByName(String name)
/*    */   {
/* 20 */     for (SizingPeriodDesignDay designDay : this.designDays)
/*    */     {
/* 22 */       if (designDay.getName().equals(name))
/*    */       {
/* 24 */         return designDay;
/*    */       }
/*    */     }
/* 27 */     return null;
/*    */   }
/*    */ 
/*    */   public String toIdfDesc()
/*    */   {
/* 32 */     String idfDesc = "";
/* 33 */     for (SizingPeriodDesignDay designDay : this.designDays)
/*    */     {
/* 35 */       idfDesc = idfDesc + designDay.toIdfDesc() + "\r\n";
/*    */     }
/* 37 */     return idfDesc;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.DesignDays
 * JD-Core Version:    0.6.0
 */