/*     */ package it.sauronsoftware.jave;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class EncodingAttributes
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  36 */   private String format = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   private Float offset = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private Float duration = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   private AudioAttributes audioAttributes = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private VideoAttributes videoAttributes = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getFormat() {
/*  71 */     return this.format;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormat(String format) {
/*  82 */     this.format = format;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Float getOffset() {
/*  91 */     return this.offset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOffset(Float offset) {
/* 102 */     this.offset = offset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Float getDuration() {
/* 111 */     return this.duration;
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
/*     */   public void setDuration(Float duration) {
/* 123 */     this.duration = duration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AudioAttributes getAudioAttributes() {
/* 134 */     return this.audioAttributes;
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
/*     */   public void setAudioAttributes(AudioAttributes audioAttributes) {
/* 147 */     this.audioAttributes = audioAttributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   VideoAttributes getVideoAttributes() {
/* 158 */     return this.videoAttributes;
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
/*     */   public void setVideoAttributes(VideoAttributes videoAttributes) {
/* 171 */     this.videoAttributes = videoAttributes;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 175 */     return String.valueOf(getClass().getName()) + "(format=" + this.format + ", offset=" + 
/* 176 */       this.offset + ", duration=" + this.duration + ", audioAttributes=" + 
/* 177 */       this.audioAttributes + ", videoAttributes=" + this.videoAttributes + 
/* 178 */       ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\EncodingAttributes.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */