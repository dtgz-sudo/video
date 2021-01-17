/*    */ package it.sauronsoftware.jave;
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
/*    */ public abstract class FFMPEGLocator
/*    */ {
/*    */   protected abstract String getFFMPEGExecutablePath();
/*    */   
/*    */   FFMPEGExecutor createExecutor() {
/* 46 */     return new FFMPEGExecutor(getFFMPEGExecutablePath());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\FFMPEGLocator.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */