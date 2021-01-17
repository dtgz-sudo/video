/*     */ package it.sauronsoftware.jave;
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
/*     */ public class MultimediaInfo
/*     */ {
/*  31 */   private String format = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private long duration = -1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private AudioInfo audio = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private VideoInfo video = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormat() {
/*  57 */     return this.format;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFormat(String format) {
/*  67 */     this.format = format;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDuration() {
/*  78 */     return this.duration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDuration(long duration) {
/*  88 */     this.duration = duration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AudioInfo getAudio() {
/*  98 */     return this.audio;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAudio(AudioInfo audio) {
/* 108 */     this.audio = audio;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VideoInfo getVideo() {
/* 118 */     return this.video;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setVideo(VideoInfo video) {
/* 128 */     this.video = video;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 132 */     return String.valueOf(getClass().getName()) + " (format=" + this.format + ", duration=" + 
/* 133 */       this.duration + ", video=" + this.video + ", audio=" + this.audio + ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\MultimediaInfo.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */