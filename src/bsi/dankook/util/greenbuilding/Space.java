/*    */ package bsi.dankook.util.greenbuilding;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Space
/*    */ {
/*    */   public String name;
/*    */   public Vector<SpaceBoundary> spaceBoundaries;
/*    */   private String zoneIdRef;
/*    */   private String _id;
/*    */   public String peopleScheduleIdRef;
/*    */   public String lightScheduleIdRef;
/*    */   public String equipmentScheduleIdRef;
/*    */   public String peopleNumber;
/*    */   public String LightPower;
/*    */   public String EquipPower;
/*    */   private Vector<PeopleHeatGain> _peopleHeatGains;
/*    */ 
/*    */   public Space(String id)
/*    */   {
/* 23 */     this._id = id;
/*    */ 
/* 25 */     this.spaceBoundaries = new Vector();
/*    */   }
/*    */ 
/*    */   public String id() {
/* 29 */     return this._id;
/*    */   }
/*    */ 
/*    */   public String setZoneIdRef(String zoneIdRef) {
/* 33 */     this.zoneIdRef = zoneIdRef;
/* 34 */     return zoneIdRef;
/*    */   }
/*    */ 
/*    */   public String getZoneIdRef() {
/* 38 */     return this.zoneIdRef;
/*    */   }
/*    */ 
/*    */   public void setPeopleHeatGains(Vector<PeopleHeatGain> peopleHeatGains)
/*    */   {
/* 43 */     this._peopleHeatGains = peopleHeatGains;
/*    */   }
/*    */ 
/*    */   public Vector<PeopleHeatGain> getPeopleHeatGains()
/*    */   {
/* 48 */     if (this._peopleHeatGains == null) {
/* 49 */       this._peopleHeatGains = new Vector();
/*    */     }
/* 51 */     return this._peopleHeatGains;
/*    */   }
/*    */ 
/*    */   public String getTotalPeopleHeatGain()
/*    */   {
/* 56 */     if (this._peopleHeatGains != null) {
/* 57 */       Iterator localIterator = this._peopleHeatGains.iterator(); if (localIterator.hasNext()) { PeopleHeatGain cureValue = (PeopleHeatGain)localIterator.next();
/*    */ 
/* 59 */         if (cureValue.heatGatinType.equals("Total"));
/* 60 */         return cureValue.value;
/*    */       }
/*    */     }
/* 63 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Space
 * JD-Core Version:    0.6.0
 */