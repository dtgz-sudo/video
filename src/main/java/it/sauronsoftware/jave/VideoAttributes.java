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
/*     */ public class VideoAttributes
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String DIRECT_STREAM_COPY = "copy";
/*  42 */   private String codec = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private String tag = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private Integer bitRate = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   private Integer frameRate = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   private VideoSize size = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getCodec() {
/*  73 */     return this.codec;
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
/*  90 */     this.codec = codec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getTag() {
/*  99 */     return this.tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTag(String tag) {
/* 109 */     this.tag = tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer getBitRate() {
/* 118 */     return this.bitRate;
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
/* 129 */     this.bitRate = bitRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer getFrameRate() {
/* 138 */     return this.frameRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFrameRate(Integer frameRate) {
/* 149 */     this.frameRate = frameRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   VideoSize getSize() {
/* 158 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(VideoSize size) {
/* 169 */     this.size = size;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 173 */     return String.valueOf(getClass().getName()) + "(codec=" + this.codec + ", bitRate=" + 
/* 174 */       this.bitRate + ", frameRate=" + this.frameRate + ", size=" + this.size + ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\VideoAttributes.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */