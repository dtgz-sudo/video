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
/*    */ class ProcessKiller
/*    */   extends Thread
/*    */ {
/*    */   private Process process;
/*    */   
/*    */   public ProcessKiller(Process process) {
/* 41 */     this.process = process;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 48 */     this.process.destroy();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\ProcessKiller.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */