/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ public class People
/*    */ {
/*    */   public String name;
/*    */   public String zoneOrZoneListName;
/*    */   public String numberOfPeopleScheduleName;
/*    */   public String numberOfPeopleCalculationMethod;
/*    */   public String numberOfPeople;
/*    */   public String activityLevelScheduleName;
/*    */   public Double _peoplePerZoneFloorArea;
/*    */ 
/*    */   public People()
/*    */   {
/* 16 */     setToDefault();
/*    */   }
/*    */ 
/*    */   private void setToDefault() {
/* 20 */     this.numberOfPeopleCalculationMethod = "people";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.People
 * JD-Core Version:    0.6.0
 */