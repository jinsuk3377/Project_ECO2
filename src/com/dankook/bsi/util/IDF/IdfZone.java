/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import com.dankook.bsi.util.geometry.EDIVector3;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class IdfZone
/*    */ {
/*    */   public Vector<BuildingSurface> buildingSurfaces;
/*    */   public String name;
/*    */   private Double directionOfRelativeNorth;
/*    */   private EDIVector3 _origin;
/*    */   public People people;
/*    */   public Lights lights;
/*    */   public ElectricEquipment electricEquipment;
/*    */   public EquipmentList equipmentList;
/*    */   public EquipmentConnections equipmentConnections;
/*    */   public IdealLoadsAirSystem idealLoadsAirSystem;
/*    */   public ScheduleCompact scheduleCompact;
/*    */ 
/*    */   public IdfZone()
/*    */   {
/* 29 */     this.buildingSurfaces = new Vector();
/*    */ 
/* 31 */     this.directionOfRelativeNorth = Double.valueOf(0.0D);
/* 32 */     this._origin = new EDIVector3();
/*    */   }
/*    */ 
/*    */   public double directionOfRelativeNorth()
/*    */   {
/* 37 */     return this.directionOfRelativeNorth.doubleValue();
/*    */   }
/*    */ 
/*    */   public EDIVector3 origin()
/*    */   {
/* 42 */     return this._origin;
/*    */   }
/*    */ 
/*    */   public Integer type()
/*    */   {
/* 47 */     return Integer.valueOf(1);
/*    */   }
/*    */ 
/*    */   public Double multiplier()
/*    */   {
/* 52 */     return Double.valueOf(1.0D);
/*    */   }
/*    */ 
/*    */   public String ceilingHeight()
/*    */   {
/* 57 */     return "autocalculate";
/*    */   }
/*    */ 
/*    */   public String volume()
/*    */   {
/* 62 */     return "autocalculate";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.IdfZone
 * JD-Core Version:    0.6.0
 */