/*    */ package com.dankook.bsi.util.IDF;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Construction
/*    */ {
/*    */   public String name;
/*    */   private Vector<String> layers;
/*    */ 
/*    */   public Construction()
/*    */   {
/* 11 */     this.layers = new Vector();
/*    */   }
/*    */ 
/*    */   public void setOutsideLayer(String outsideLayer)
/*    */   {
/* 16 */     if (thereIsOutsideLayer().booleanValue())
/*    */     {
/* 18 */       this.layers.set(0, outsideLayer);
/*    */     }
/*    */     else
/* 21 */       this.layers.add(outsideLayer);
/*    */   }
/*    */ 
/*    */   public String getOutsideLayer()
/*    */   {
/* 27 */     if (thereIsOutsideLayer().booleanValue())
/*    */     {
/* 29 */       return (String)this.layers.get(0);
/*    */     }
/*    */ 
/* 32 */     return "";
/*    */   }
/*    */ 
/*    */   private Boolean thereIsOutsideLayer()
/*    */   {
/* 38 */     if (this.layers.size() > 0)
/*    */     {
/* 40 */       return Boolean.valueOf(true);
/*    */     }
/*    */ 
/* 43 */     return Boolean.valueOf(false);
/*    */   }
/*    */ 
/*    */   public Vector<String> getLayers()
/*    */   {
/* 49 */     return this.layers;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.Construction
 * JD-Core Version:    0.6.0
 */