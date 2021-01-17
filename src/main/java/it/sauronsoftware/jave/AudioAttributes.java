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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AudioAttributes
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String DIRECT_STREAM_COPY = "copy";
/*  42 */   private String codec = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private Integer bitRate = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   private Integer samplingRate = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private Integer channels = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private Integer volume = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getCodec() {
/*  74 */     return this.codec;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCodec(String codec) {
/*  91 */     this.codec = codec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer getBitRate() {
/* 100 */     return this.bitRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBitRate(Integer bitRate) {
/* 111 */     this.bitRate = bitRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer getSamplingRate() {
/* 120 */     return this.samplingRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSamplingRate(Integer samplingRate) {
/* 131 */     this.samplingRate = samplingRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer getChannels() {
/* 140 */     return this.channels;
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
/*     */   public void setChannels(Integer channels) {
/* 152 */     this.channels = channels;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer getVolume() {
/* 161 */     return this.volume;
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
/*     */   public void setVolume(Integer volume) {
/* 173 */     this.volume = volume;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 177 */     return String.valueOf(getClass().getName()) + "(codec=" + this.codec + ", bitRate=" + 
/* 178 */       this.bitRate + ", samplingRate=" + this.samplingRate + ", channels=" + 
/* 179 */       this.channels + ", volume=" + this.volume + ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\AudioAttributes.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */