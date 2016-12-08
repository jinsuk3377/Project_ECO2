/*    */ package com.dankook.bsi.util.IDF.unit;
/*    */ 
/*    */ public class ChilledWaterPumpConfiguration extends Choice
/*    */ {
/*    */   public ChilledWaterPumpConfiguration(String string)
/*    */   {
/*  7 */     super(string);
/*  8 */     add("ConstantPrimaryNoSecondary");
/*  9 */     add("VariablePrimaryNoSecondary");
/* 10 */     add("ConstantPrimaryVariableSecondary");
/* 11 */     add("VariablePrimaryConstantSecondary");
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.unit.ChilledWaterPumpConfiguration
 * JD-Core Version:    0.6.0
 */