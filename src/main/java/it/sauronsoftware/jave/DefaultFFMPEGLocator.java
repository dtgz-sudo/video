/*     */ package it.sauronsoftware.jave;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultFFMPEGLocator
/*     */   extends FFMPEGLocator
/*     */ {
/*     */   private static final int myEXEversion = 1;
/*     */   private String path;
/*     */   
/*     */   public DefaultFFMPEGLocator() {
/*     */     boolean isWindows;
/*  55 */     String os = System.getProperty("os.name").toLowerCase();
/*  56 */     if (os.indexOf("windows") != -1) {
/*  57 */       isWindows = true;
/*     */     } else {
/*  59 */       isWindows = false;
/*     */     } 
/*     */     
/*  62 */     File temp = new File(System.getProperty("java.io.tmpdir"), "jave-1");
/*     */     
/*  64 */     if (!temp.exists()) {
/*  65 */       temp.mkdirs();
/*  66 */       temp.deleteOnExit();
/*     */     } 
/*     */     
/*  69 */     String suffix = isWindows ? ".exe" : "";
/*  70 */     File exe = new File(temp, "ffmpeg" + suffix);
/*  71 */     if (!exe.exists()) {
/*  72 */       copyFile("ffmpeg" + suffix, exe);
/*     */     }
/*     */     
/*  75 */     if (isWindows) {
/*  76 */       File dll = new File(temp, "pthreadGC2.dll");
/*  77 */       if (!dll.exists()) {
/*  78 */         copyFile("pthreadGC2.dll", dll);
/*     */       }
/*     */     } 
/*     */     
/*  82 */     if (!isWindows) {
/*  83 */       Runtime runtime = Runtime.getRuntime();
/*     */       try {
/*  85 */         runtime.exec(new String[] { "/bin/chmod", "755", 
/*  86 */               exe.getAbsolutePath() });
/*  87 */       } catch (IOException e) {
/*  88 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     this.path = exe.getAbsolutePath();
/*     */   }
/*     */   
/*     */   protected String getFFMPEGExecutablePath() {
/*  96 */     return this.path;
/*     */   }
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
/*     */   private void copyFile(String path, File dest) throws RuntimeException {
/* 110 */     InputStream input = null;
/* 111 */     OutputStream output = null;
/*     */     try {
/* 113 */       input = getClass().getResourceAsStream(path);
/* 114 */       output = new FileOutputStream(dest);
/* 115 */       byte[] buffer = new byte[1024];
/*     */       int l;
/* 117 */       while ((l = input.read(buffer)) != -1) {
/* 118 */         output.write(buffer, 0, l);
/*     */       }
/* 120 */     } catch (IOException e) {
/* 121 */       throw new RuntimeException("Cannot write file " + 
/* 122 */           dest.getAbsolutePath());
/*     */     } finally {
/* 124 */       if (output != null) {
/*     */         try {
/* 126 */           output.close();
/* 127 */         } catch (Throwable throwable) {}
/*     */       }
/*     */ 
/*     */       
/* 131 */       if (input != null)
/*     */         try {
/* 133 */           input.close();
/* 134 */         } catch (Throwable throwable) {} 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\DefaultFFMPEGLocator.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */