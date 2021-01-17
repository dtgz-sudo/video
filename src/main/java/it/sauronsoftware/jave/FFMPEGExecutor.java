/*     */ package it.sauronsoftware.jave;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FFMPEGExecutor
/*     */ {
/*     */   private String ffmpegExecutablePath;
/*  41 */   private ArrayList args = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private Process ffmpeg = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private ProcessKiller ffmpegKiller = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private InputStream inputStream = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private OutputStream outputStream = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   private InputStream errorStream = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFMPEGExecutor(String ffmpegExecutablePath) {
/*  76 */     this.ffmpegExecutablePath = ffmpegExecutablePath;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addArgument(String arg) {
/*  86 */     this.args.add(arg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() throws IOException {
/*  96 */     int argsSize = this.args.size();
/*  97 */     String[] cmd = new String[argsSize + 1];
/*  98 */     cmd[0] = this.ffmpegExecutablePath;
/*  99 */     for (int i = 0; i < argsSize; i++) {
/* 100 */       cmd[i + 1] = (String) this.args.get(i);
/*     */     }
/* 102 */     Runtime runtime = Runtime.getRuntime();
/* 103 */     this.ffmpeg = runtime.exec(cmd);
/* 104 */     this.ffmpegKiller = new ProcessKiller(this.ffmpeg);
/* 105 */     runtime.addShutdownHook(this.ffmpegKiller);
/* 106 */     this.inputStream = this.ffmpeg.getInputStream();
/* 107 */     this.outputStream = this.ffmpeg.getOutputStream();
/* 108 */     this.errorStream = this.ffmpeg.getErrorStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() {
/* 117 */     return this.inputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream getOutputStream() {
/* 126 */     return this.outputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getErrorStream() {
/* 135 */     return this.errorStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroy() {
/* 142 */     if (this.inputStream != null) {
/*     */       try {
/* 144 */         this.inputStream.close();
/* 145 */       } catch (Throwable throwable) {}
/*     */ 
/*     */       
/* 148 */       this.inputStream = null;
/*     */     } 
/* 150 */     if (this.outputStream != null) {
/*     */       try {
/* 152 */         this.outputStream.close();
/* 153 */       } catch (Throwable throwable) {}
/*     */ 
/*     */       
/* 156 */       this.outputStream = null;
/*     */     } 
/* 158 */     if (this.errorStream != null) {
/*     */       try {
/* 160 */         this.errorStream.close();
/* 161 */       } catch (Throwable throwable) {}
/*     */ 
/*     */       
/* 164 */       this.errorStream = null;
/*     */     } 
/* 166 */     if (this.ffmpeg != null) {
/* 167 */       this.ffmpeg.destroy();
/* 168 */       this.ffmpeg = null;
/*     */     } 
/* 170 */     if (this.ffmpegKiller != null) {
/* 171 */       Runtime runtime = Runtime.getRuntime();
/* 172 */       runtime.removeShutdownHook(this.ffmpegKiller);
/* 173 */       this.ffmpegKiller = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\FFMPEGExecutor.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */