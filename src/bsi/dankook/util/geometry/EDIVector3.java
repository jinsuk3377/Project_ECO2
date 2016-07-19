/*    */ package bsi.dankook.util.geometry;
/*    */ 
/*    */ public class EDIVector3
/*    */ {
/*  7 */   public double EPSILON = 1.0E-016D;
/*    */   public Double x;
/*    */   public Double y;
/*    */   public Double z;
/*    */ 
/*    */   public EDIVector3()
/*    */   {
/* 14 */     this.x = Double.valueOf(0.0D);
/* 15 */     this.y = Double.valueOf(0.0D);
/* 16 */     this.z = Double.valueOf(0.0D);
/*    */   }
/*    */ 
/*    */   public EDIVector3(Double x, Double y, Double z)
/*    */   {
/* 21 */     this.x = x;
/* 22 */     this.y = y;
/* 23 */     this.z = z;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 28 */     return "(" + this.x.toString() + 
/* 29 */       ", " + this.y.toString() + 
/* 30 */       ", " + this.z.toString() + ")";
/*    */   }
/*    */ 
/*    */   public boolean equals(Object anObject)
/*    */   {
/* 36 */     if (this == anObject) {
/* 37 */       return true;
/*    */     }
/* 39 */     if ((anObject instanceof EDIVector3)) {
/* 40 */       EDIVector3 anotherVector = (EDIVector3)anObject;
/*    */ 
/* 46 */       return (Math.abs(anotherVector.x.doubleValue() - this.x.doubleValue()) < this.EPSILON) && 
/* 43 */         (Math.abs(anotherVector.y.doubleValue() - this.y.doubleValue()) < this.EPSILON) && 
/* 44 */         (Math.abs(anotherVector.z.doubleValue() - this.z.doubleValue()) < this.EPSILON);
/*    */     }
/*    */ 
/* 50 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.geometry.EDIVector3
 * JD-Core Version:    0.6.0
 */