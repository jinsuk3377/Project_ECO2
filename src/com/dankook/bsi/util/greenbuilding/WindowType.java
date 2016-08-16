/*    */ package com.dankook.bsi.util.greenbuilding;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class WindowType
/*    */ {
/*  7 */   private String _id = "";
/*    */   private Double _uValue;
/*    */   private Vector<SolarHeatGainCoeff> _solarHeatGainCoeffs;
/*    */   private Double _transmittance;
/* 13 */   public String name = "";
/*    */ 
/*    */   public WindowType(String id)
/*    */   {
/* 17 */     this._id = id;
/*    */   }
/*    */ 
/*    */   public String id() {
/* 21 */     return this._id;
/*    */   }
/*    */ 
/*    */   public Double U_Value() {
/* 25 */     return this._uValue;
/*    */   }
/*    */ 
/*    */   public void setUValue(String value) {
/* 29 */     this._uValue = Double.valueOf(Double.parseDouble(value));
/*    */   }
/*    */ 
/*    */   public Boolean hasSolarHeatGainCoeff()
/*    */   {
/* 34 */     if ((this._solarHeatGainCoeffs != null) && 
/* 35 */       (this._solarHeatGainCoeffs.size() > 0)) {
/* 36 */       return Boolean.valueOf(true);
/*    */     }
/* 38 */     return Boolean.valueOf(false);
/*    */   }
/*    */ 
/*    */   public Double solarHeatGainCoeff()
/*    */   {
/* 43 */     for (SolarHeatGainCoeff solarHeatGainCoeff : this._solarHeatGainCoeffs)
/*    */     {
/* 45 */       if (solarHeatGainCoeff.solarIncidentAngle.equals(""))
/* 46 */         return Double.valueOf(solarHeatGainCoeff.value);
/*    */     }
/* 48 */     return Double.valueOf(0.0D);
/*    */   }
/*    */ 
/*    */   public void addSolarHeatGainCoeff(SolarHeatGainCoeff readSolarHeatGainCoeff)
/*    */   {
/* 53 */     if (this._solarHeatGainCoeffs == null) {
/* 54 */       this._solarHeatGainCoeffs = new Vector();
/*    */     }
/*    */ 
/* 57 */     this._solarHeatGainCoeffs.add(readSolarHeatGainCoeff);
/*    */   }
/*    */ 
/*    */   public Double transmittance()
/*    */   {
/* 62 */     return this._transmittance;
/*    */   }
/*    */ 
/*    */   public void setTransmittance(String Transmittance) {
/* 66 */     this._transmittance = Double.valueOf(Double.parseDouble(Transmittance));
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.WindowType
 * JD-Core Version:    0.6.0
 */