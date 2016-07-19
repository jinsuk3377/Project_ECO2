/*    */ package bsi.dankook.util.greenbuilding;
/*    */ 
/*    */ public class Schedule
/*    */ {
/*    */   private String _id;
/*    */   private String _type;
/*    */   public String name;
/*    */   public YearSchedule yearSchedule;
/*    */ 
/*    */   public String id()
/*    */   {
/* 10 */     return this._id; } 
/* 11 */   public String type() { return this._type; }
/*    */ 
/*    */   public Schedule(String id, String type)
/*    */   {
/* 15 */     this._id = id;
/* 16 */     this._type = type;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Schedule
 * JD-Core Version:    0.6.0
 */