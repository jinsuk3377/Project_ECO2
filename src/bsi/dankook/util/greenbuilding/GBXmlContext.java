/*    */ package bsi.dankook.util.greenbuilding;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class GBXmlContext
/*    */ {
/*    */   public HashMap<String, String> spaceProperties;
/*    */   public Vector<WeekSchedule> weekSchedules;
/*    */   public Vector<DaySchedule> daySchedules;
/*    */   public Vector<Schedule> schedules;
/*    */   public Vector<Zone> zones;
/*    */   public Vector<Material> materials;
/*    */   public Vector<WindowType> windowTypes;
/*    */   public Location location;
/*    */   public Vector<Space> spaces;
/*    */   public HashMap<String, Surface> surfaces;
/*    */   public HashMap<String, Layer> layerHashMap;
/*    */   public Vector<Construction> constructions;
/* 20 */   public String documentHistory = "";
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.GBXmlContext
 * JD-Core Version:    0.6.0
 */