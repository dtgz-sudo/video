/*    */ package it.sauronsoftware.jave;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VideoSize
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int width;
/*    */   private int height;
/*    */   
/*    */   public VideoSize(int width, int height) {
/* 51 */     this.width = width;
/* 52 */     this.height = height;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 61 */     return this.width;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 70 */     return this.height;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     return String.valueOf(getClass().getName()) + " (width=" + this.width + ", height=" + this.height + 
/* 75 */       ")";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\VideoSize.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */