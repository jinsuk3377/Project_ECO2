/*     */ package com.dankook.bsi.util.IDF;
/*     */ 
/*     */ public class Material
/*     */ {
/*     */   public String name;
/*     */   public String roughness;
/*     */   private String thickness;
/*     */   private String conductvity;
/*     */   private String density;
/*     */   private String specificHeat;
/*     */   public String thermalResistance;
/*     */   private Double thermalAbsorptance;
/*     */   private Double solarAbsorptance;
/*     */   private Double visibleAbsorptance;
/*     */   private Double defaultThermalAbsorptance;
/*     */   private Double defaultSolarAbsorptance;
/*     */   private Double defaultVisibleAbsorptance;
/*     */ 
/*     */   public Material()
/*     */   {
/*  26 */     this.name = "";
/*  27 */     setToDefault();
/*     */   }
/*     */ 
/*     */   private void setToDefault()
/*     */   {
/*  32 */     this.thickness = "";
/*  33 */     this.conductvity = "";
/*  34 */     this.density = "";
/*  35 */     this.specificHeat = "";
/*     */ 
/*  37 */     setAbsorptancesToDefault();
/*     */   }
/*     */ 
/*     */   private void setAbsorptancesToDefault()
/*     */   {
/*  42 */     if (hasMass())
/*     */     {
/*  44 */       this.defaultThermalAbsorptance = Double.valueOf(0.9D);
/*  45 */       this.defaultSolarAbsorptance = Double.valueOf(0.9D);
/*  46 */       this.defaultVisibleAbsorptance = Double.valueOf(0.9D);
/*     */     }
/*     */     else {
/*  49 */       this.defaultThermalAbsorptance = Double.valueOf(0.65D);
/*  50 */       this.defaultSolarAbsorptance = Double.valueOf(0.65D);
/*  51 */       this.defaultVisibleAbsorptance = Double.valueOf(0.65D);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean hasMass()
/*     */   {
/*  62 */     return (!getThickness().equals("")) || 
/*  58 */       (!getConductvity().equals("")) || 
/*  59 */       (!getDensity().equals("")) || 
/*  60 */       (!getSpecificHeat().equals(""));
/*     */   }
/*     */ 
/*     */   public String getRoughness()
/*     */   {
/*  69 */     if (hasMass()) {
/*  70 */       return "smooth";
/*     */     }
/*     */ 
/*  73 */     return "Rough";
/*     */   }
/*     */ 
/*     */   public Double getThermalAbsorptance()
/*     */   {
/*  79 */     if (this.thermalAbsorptance == null) {
/*  80 */       return this.defaultThermalAbsorptance;
/*     */     }
/*  82 */     return this.thermalAbsorptance;
/*     */   }
/*     */ 
/*     */   public void setThickness(String thickness)
/*     */   {
/*  87 */     this.thickness = thickness;
/*  88 */     setAbsorptancesToDefault();
/*     */   }
/*     */ 
/*     */   public String getThickness() {
/*  92 */     return this.thickness;
/*     */   }
/*     */ 
/*     */   public void setConductvity(String conductvity) {
/*  96 */     this.conductvity = conductvity;
/*  97 */     setAbsorptancesToDefault();
/*     */   }
/*     */ 
/*     */   public String getConductvity() {
/* 101 */     return this.conductvity;
/*     */   }
/*     */ 
/*     */   public void setDensity(String density) {
/* 105 */     this.density = density;
/* 106 */     setAbsorptancesToDefault();
/*     */   }
/*     */ 
/*     */   public String getDensity() {
/* 110 */     return this.density;
/*     */   }
/*     */ 
/*     */   public void setSpecificHeat(String specificHeat) {
/* 114 */     this.specificHeat = specificHeat;
/* 115 */     setAbsorptancesToDefault();
/*     */   }
/*     */ 
/*     */   public String getSpecificHeat() {
/* 119 */     return this.specificHeat;
/*     */   }
/*     */ 
/*     */   public void setSolarAbsorptance(Double solarAbsorptance) {
/* 123 */     this.solarAbsorptance = solarAbsorptance;
/*     */   }
/*     */ 
/*     */   public Double getSolarAbsorptance() {
/* 127 */     if (this.solarAbsorptance == null) {
/* 128 */       return this.defaultSolarAbsorptance;
/*     */     }
/* 130 */     return this.solarAbsorptance;
/*     */   }
/*     */ 
/*     */   public void setVisibleAbsorptance(Double visibleAbsorptance) {
/* 134 */     this.visibleAbsorptance = visibleAbsorptance;
/*     */   }
/*     */ 
/*     */   public Double getVisibleAbsorptance() {
/* 138 */     if (this.visibleAbsorptance == null) {
/* 139 */       return this.defaultVisibleAbsorptance;
/*     */     }
/* 141 */     return this.visibleAbsorptance;
/*     */   }
/*     */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.Material
 * JD-Core Version:    0.6.0
 */