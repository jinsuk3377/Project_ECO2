/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class IdfZoneList
/*    */ {
/*    */   String _id;
/*  8 */   Vector<String> _zoneIdRefs = new Vector();
/*  9 */   public Vector<ScheduleCompact> scheduleCompacts = new Vector();
/*    */   public Vector<ThermostatSetpoint> thermostatSetpoints;
/*    */   public ZoneControl zoneControl;
/*    */ 
/*    */   public IdfZoneList(String id)
/*    */   {
/* 14 */     this._id = id;
/*    */   }
/*    */ 
/*    */   public String id() {
/* 18 */     return this._id;
/*    */   }
/*    */ 
/*    */   public Vector<String> getZoneIdRefs() {
/* 22 */     return this._zoneIdRefs;
/*    */   }
/*    */ 
/*    */   public void addZoneIdRef(String id)
/*    */   {
/* 27 */     this._zoneIdRefs.add(id);
/*    */   }
/*    */ 
/*    */   public String getZoneIdRef(int index)
/*    */   {
/* 32 */     return (String)this._zoneIdRefs.get(index);
/*    */   }
/*    */ 
/*    */   public Boolean contains(String zoneId)
/*    */   {
/* 37 */     for (String zoneIdRef : this._zoneIdRefs)
/*    */     {
/* 39 */       if (zoneIdRef.equals(zoneId)) return Boolean.valueOf(true);
/*    */     }
/* 41 */     return Boolean.valueOf(false);
/*    */   }
/*    */ 
/*    */   public int getNumberOfZones()
/*    */   {
/* 47 */     return this._zoneIdRefs.size();
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.IdfZoneList
 * JD-Core Version:    0.6.0
 */