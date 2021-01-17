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
/*     */ public class VideoInfo
/*     */ {
/*     */   private String decoder;
/*  37 */   private VideoSize size = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private int bitRate = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private float frameRate = -1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDecoder() {
/*  56 */     return this.decoder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDecoder(String codec) {
/*  66 */     this.decoder = codec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VideoSize getSize() {
/*  75 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSize(VideoSize size) {
/*  85 */     this.size = size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFrameRate() {
/*  95 */     return this.frameRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFrameRate(float frameRate) {
/* 105 */     this.frameRate = frameRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBitRate() {
/* 115 */     return this.bitRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBitRate(int bitRate) {
/* 125 */     this.bitRate = bitRate;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 129 */     return String.valueOf(getClass().getName()) + " (decoder=" + this.decoder + ", size=" + this.size + 
/* 130 */       ", bitRate=" + this.bitRate + ", frameRate=" + this.frameRate + ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\VideoInfo.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */