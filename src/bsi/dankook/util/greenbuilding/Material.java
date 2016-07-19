/*    */ package bsi.dankook.util.greenbuilding;
/*    */ 
/*    */ public class Material
/*    */ {
/*  6 */   public String M_Thcikness = "";
/*  7 */   public String M_Conductivity = "";
/*  8 */   public String M_Density = "";
/*  9 */   public String M_SpecificHeat = "";
/* 10 */   public String R_Value = "";
/*    */ 
/* 12 */   private String _id = "";
/*    */ 
/* 14 */   public String id() { return this._id;
/*    */   }
/*    */ 
/*    */   public Material(String id)
/*    */   {
/* 19 */     this._id = id;
/*    */   }
/*    */ 
/*    */   public Boolean hasMass()
/*    */   {
/* 25 */     if ((!this.M_Thcikness.equals("")) && 
/* 26 */       (!this.M_Conductivity.equals("")) && 
/* 27 */       (!this.M_Density.equals("")) && 
/* 28 */       (!this.M_SpecificHeat.equals("")))
/*    */     {
/* 30 */       return Boolean.valueOf(true);
/*    */     }
/*    */ 
/* 33 */     return Boolean.valueOf(false);
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.GreenBuilding.Material
 * JD-Core Version:    0.6.0
 */