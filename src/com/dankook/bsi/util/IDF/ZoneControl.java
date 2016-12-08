/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class ZoneControl
/*    */ {
/*    */   public String name;
/*    */   public String zoneOrZoneListName;
/*    */   public String controlTypeScheduleName;
/* 10 */   public Vector<ControlObject> controlObjects = new Vector();
/*    */ 
/* 12 */   public Object getThermoStat() { return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.ZoneControl
 * JD-Core Version:    0.6.0
 */