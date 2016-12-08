/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class FuelType extends Choice
/*    */ {
/*    */   public FuelType(String fuelType)
/*    */   {
/*  7 */     super(fuelType);
/*  8 */     add("Electricity");
/*  9 */     add("NaturalGas");
/* 10 */     add("PropaneGas");
/* 11 */     add("FuelOil#1");
/* 12 */     add("FuelOil#2");
/* 13 */     add("Coal");
/* 14 */     add("Diesel");
/* 15 */     add("Gasoline");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.FuelType
 * JD-Core Version:    0.6.0
 */