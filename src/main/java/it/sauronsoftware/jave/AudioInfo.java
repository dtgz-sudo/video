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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AudioInfo
/*     */ {
/*     */   private String decoder;
/*  38 */   private int samplingRate = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   private int channels = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   private int bitRate = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDecoder() {
/*  58 */     return this.decoder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDecoder(String format) {
/*  68 */     this.decoder = format;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSamplingRate() {
/*  78 */     return this.samplingRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSamplingRate(int samplingRate) {
/*  88 */     this.samplingRate = samplingRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getChannels() {
/*  98 */     return this.channels;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChannels(int channels) {
/* 108 */     this.channels = channels;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBitRate() {
/* 118 */     return this.bitRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBitRate(int bitRate) {
/* 128 */     this.bitRate = bitRate;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 132 */     return String.valueOf(getClass().getName()) + " (decoder=" + this.decoder + ", samplingRate=" + 
/* 133 */       this.samplingRate + ", channels=" + this.channels + ", bitRate=" + 
/* 134 */       this.bitRate + ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\AudioInfo.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */