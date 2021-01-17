/*    */ package it.sauronsoftware.jave;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.util.ArrayList;
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
/*    */ class RBufferedReader
/*    */   extends BufferedReader
/*    */ {
/* 39 */   private ArrayList<String> lines = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RBufferedReader(Reader in) {
/* 48 */     super(in);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String readLine() throws IOException {
/* 55 */     if (this.lines.size() > 0) {
/* 56 */       return this.lines.remove(0);
/*    */     }
/* 58 */     return super.readLine();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void reinsertLine(String line) {
/* 70 */     this.lines.add(0, line);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\RBufferedReader.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */