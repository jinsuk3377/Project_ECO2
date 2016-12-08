/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.geometry.EDIVector3;

/*    */ import java.util.Vector;
/*    */ 
/*    */ public class BuildingSurface
/*    */ {
/*    */   public String name;
/*    */   public Vector<String> zoneNames;
/*    */   public String boundaryCondition;
/*    */   public String surfaceType;
/*    */   public String sunExposure;
/*    */   public String windExporsure;
/*    */   public String boundaryConditionObject;
/*    */   public String constructionName;
/*    */   public Vector<EDIVector3> vertices;
/*    */   public Vector<FenestrationSurface> fenestrationSurfaces;
/*    */ 
/*    */   public BuildingSurface()
/*    */   {
/* 25 */     this.zoneNames = new Vector<String>();
/*    */   }
/*    */ 
/*    */   public BuildingSurface clone()
/*    */   {
/* 31 */     BuildingSurface clone = new BuildingSurface();
/*    */ 
/* 33 */     this.name += "_COPY";
/* 34 */     clone.zoneNames = ((Vector)this.zoneNames.clone());
/* 35 */     clone.boundaryCondition = this.boundaryCondition;
/* 36 */     clone.surfaceType = this.surfaceType;
/* 37 */     clone.sunExposure = this.sunExposure;
/* 38 */     clone.windExporsure = this.windExporsure;
/* 39 */     clone.boundaryConditionObject = this.boundaryConditionObject;
/* 40 */     clone.constructionName = this.constructionName;
/* 41 */     if (this.vertices != null)
/* 42 */       clone.vertices = ((Vector)this.vertices.clone());
/*    */     else {
/* 44 */       clone.vertices = null;
/*    */     }
/* 46 */     return clone;
/*    */   }
/*    */ 
/*    */   public String viewFactor()
/*    */   {
/* 52 */     if (this.surfaceType == "Wall") {
/* 53 */       return "0.5";
/*    */     }
/* 55 */     if (this.surfaceType == "Roof") {
/* 56 */       return "0";
/*    */     }
/*    */ 
/* 59 */     return "1";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.BuildingSurface
 * JD-Core Version:    0.6.0
 */