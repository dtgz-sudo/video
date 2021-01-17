/*     */ package it.sauronsoftware.jave;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Hashtable;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class Encoder
/*     */ {
/*  42 */   private static final Pattern FORMAT_PATTERN = Pattern.compile("^\\s*([D ])([E ])\\s+([\\w,]+)\\s+.+$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private static final Pattern ENCODER_DECODER_PATTERN = Pattern.compile(
/*  49 */       "^\\s*([D ])([E ])([AVS]).{3}\\s+(.+)$", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private static final Pattern PROGRESS_INFO_PATTERN = Pattern.compile(
/*  56 */       "\\s*(\\w+)\\s*=\\s*(\\S+)\\s*", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private static final Pattern SIZE_PATTERN = Pattern.compile(
/*  63 */       "(\\d+)x(\\d+)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   private static final Pattern FRAME_RATE_PATTERN = Pattern.compile(
/*  70 */       "([\\d.]+)\\s+(?:fps|tb\\(r\\))", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private static final Pattern BIT_RATE_PATTERN = Pattern.compile(
/*  77 */       "(\\d+)\\s+kb/s", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private static final Pattern SAMPLING_RATE_PATTERN = Pattern.compile(
/*  84 */       "(\\d+)\\s+Hz", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   private static final Pattern CHANNELS_PATTERN = Pattern.compile(
/*  91 */       "(mono|stereo)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   private static final Pattern SUCCESS_PATTERN = Pattern.compile(
/*  98 */       "^\\s*video\\:\\S+\\s+audio\\:\\S+\\s+global headers\\:\\S+.*$", 
/*  99 */       2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FFMPEGLocator locator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Encoder() {
/* 111 */     this.locator = new DefaultFFMPEGLocator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Encoder(FFMPEGLocator locator) {
/* 122 */     this.locator = locator;
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
/*     */   public String[] getAudioDecoders() throws EncoderException {
/* 135 */     ArrayList<String> res = new ArrayList();
/* 136 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 137 */     ffmpeg.addArgument("-formats");
/*     */     try {
/* 139 */       ffmpeg.execute();
/* 140 */       RBufferedReader reader = null;
/* 141 */       reader = new RBufferedReader(new InputStreamReader(
/* 142 */             ffmpeg.getInputStream()));
/*     */       
/* 144 */       boolean evaluate = false; String line;
/* 145 */       while ((line = reader.readLine()) != null) {
/* 146 */         if (line.trim().length() == 0) {
/*     */           continue;
/*     */         }
/* 149 */         if (evaluate) {
/* 150 */           Matcher matcher = ENCODER_DECODER_PATTERN.matcher(line);
/* 151 */           if (matcher.matches()) {
/* 152 */             String decoderFlag = matcher.group(1);
/* 153 */             String audioVideoFlag = matcher.group(3);
/* 154 */             if ("D".equals(decoderFlag) && 
/* 155 */               "A".equals(audioVideoFlag)) {
/* 156 */               String name = matcher.group(4);
/* 157 */               res.add(name);
/*     */             }  continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 162 */         if (line.trim().equals("Codecs:")) {
/* 163 */           evaluate = true;
/*     */         }
/*     */       } 
/* 166 */     } catch (IOException e) {
/* 167 */       throw new EncoderException(e);
/*     */     } finally {
/* 169 */       ffmpeg.destroy();
/*     */     } 
/* 171 */     int size = res.size();
/* 172 */     String[] ret = new String[size];
/* 173 */     for (int i = 0; i < size; i++) {
/* 174 */       ret[i] = res.get(i);
/*     */     }
/* 176 */     return ret;
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
/*     */   public String[] getAudioEncoders() throws EncoderException {
/* 189 */     ArrayList<String> res = new ArrayList();
/* 190 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 191 */     ffmpeg.addArgument("-formats");
/*     */     try {
/* 193 */       ffmpeg.execute();
/* 194 */       RBufferedReader reader = null;
/* 195 */       reader = new RBufferedReader(new InputStreamReader(
/* 196 */             ffmpeg.getInputStream()));
/*     */       
/* 198 */       boolean evaluate = false; String line;
/* 199 */       while ((line = reader.readLine()) != null) {
/* 200 */         if (line.trim().length() == 0) {
/*     */           continue;
/*     */         }
/* 203 */         if (evaluate) {
/* 204 */           Matcher matcher = ENCODER_DECODER_PATTERN.matcher(line);
/* 205 */           if (matcher.matches()) {
/* 206 */             String encoderFlag = matcher.group(2);
/* 207 */             String audioVideoFlag = matcher.group(3);
/* 208 */             if ("E".equals(encoderFlag) && 
/* 209 */               "A".equals(audioVideoFlag)) {
/* 210 */               String name = matcher.group(4);
/* 211 */               res.add(name);
/*     */             }  continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 216 */         if (line.trim().equals("Codecs:")) {
/* 217 */           evaluate = true;
/*     */         }
/*     */       } 
/* 220 */     } catch (IOException e) {
/* 221 */       throw new EncoderException(e);
/*     */     } finally {
/* 223 */       ffmpeg.destroy();
/*     */     } 
/* 225 */     int size = res.size();
/* 226 */     String[] ret = new String[size];
/* 227 */     for (int i = 0; i < size; i++) {
/* 228 */       ret[i] = res.get(i);
/*     */     }
/* 230 */     return ret;
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
/*     */   public String[] getVideoDecoders() throws EncoderException {
/* 243 */     ArrayList<String> res = new ArrayList();
/* 244 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 245 */     ffmpeg.addArgument("-formats");
/*     */     try {
/* 247 */       ffmpeg.execute();
/* 248 */       RBufferedReader reader = null;
/* 249 */       reader = new RBufferedReader(new InputStreamReader(
/* 250 */             ffmpeg.getInputStream()));
/*     */       
/* 252 */       boolean evaluate = false; String line;
/* 253 */       while ((line = reader.readLine()) != null) {
/* 254 */         if (line.trim().length() == 0) {
/*     */           continue;
/*     */         }
/* 257 */         if (evaluate) {
/* 258 */           Matcher matcher = ENCODER_DECODER_PATTERN.matcher(line);
/* 259 */           if (matcher.matches()) {
/* 260 */             String decoderFlag = matcher.group(1);
/* 261 */             String audioVideoFlag = matcher.group(3);
/* 262 */             if ("D".equals(decoderFlag) && 
/* 263 */               "V".equals(audioVideoFlag)) {
/* 264 */               String name = matcher.group(4);
/* 265 */               res.add(name);
/*     */             }  continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 270 */         if (line.trim().equals("Codecs:")) {
/* 271 */           evaluate = true;
/*     */         }
/*     */       } 
/* 274 */     } catch (IOException e) {
/* 275 */       throw new EncoderException(e);
/*     */     } finally {
/* 277 */       ffmpeg.destroy();
/*     */     } 
/* 279 */     int size = res.size();
/* 280 */     String[] ret = new String[size];
/* 281 */     for (int i = 0; i < size; i++) {
/* 282 */       ret[i] = res.get(i);
/*     */     }
/* 284 */     return ret;
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
/*     */   public String[] getVideoEncoders() throws EncoderException {
/* 297 */     ArrayList<String> res = new ArrayList();
/* 298 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 299 */     ffmpeg.addArgument("-formats");
/*     */     try {
/* 301 */       ffmpeg.execute();
/* 302 */       RBufferedReader reader = null;
/* 303 */       reader = new RBufferedReader(new InputStreamReader(
/* 304 */             ffmpeg.getInputStream()));
/*     */       
/* 306 */       boolean evaluate = false; String line;
/* 307 */       while ((line = reader.readLine()) != null) {
/* 308 */         if (line.trim().length() == 0) {
/*     */           continue;
/*     */         }
/* 311 */         if (evaluate) {
/* 312 */           Matcher matcher = ENCODER_DECODER_PATTERN.matcher(line);
/* 313 */           if (matcher.matches()) {
/* 314 */             String encoderFlag = matcher.group(2);
/* 315 */             String audioVideoFlag = matcher.group(3);
/* 316 */             if ("E".equals(encoderFlag) && 
/* 317 */               "V".equals(audioVideoFlag)) {
/* 318 */               String name = matcher.group(4);
/* 319 */               res.add(name);
/*     */             }  continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 324 */         if (line.trim().equals("Codecs:")) {
/* 325 */           evaluate = true;
/*     */         }
/*     */       } 
/* 328 */     } catch (IOException e) {
/* 329 */       throw new EncoderException(e);
/*     */     } finally {
/* 331 */       ffmpeg.destroy();
/*     */     } 
/* 333 */     int size = res.size();
/* 334 */     String[] ret = new String[size];
/* 335 */     for (int i = 0; i < size; i++) {
/* 336 */       ret[i] = res.get(i);
/*     */     }
/* 338 */     return ret;
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
/*     */   public String[] getSupportedEncodingFormats() throws EncoderException {
/* 353 */     ArrayList<String> res = new ArrayList();
/* 354 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 355 */     ffmpeg.addArgument("-formats");
/*     */     try {
/* 357 */       ffmpeg.execute();
/* 358 */       RBufferedReader reader = null;
/* 359 */       reader = new RBufferedReader(new InputStreamReader(
/* 360 */             ffmpeg.getInputStream()));
/*     */       
/* 362 */       boolean evaluate = false; String line;
/* 363 */       while ((line = reader.readLine()) != null) {
/* 364 */         if (line.trim().length() == 0) {
/*     */           continue;
/*     */         }
/* 367 */         if (evaluate) {
/* 368 */           Matcher matcher = FORMAT_PATTERN.matcher(line);
/* 369 */           if (matcher.matches()) {
/* 370 */             String encoderFlag = matcher.group(2);
/* 371 */             if ("E".equals(encoderFlag)) {
/* 372 */               String aux = matcher.group(3);
/* 373 */               StringTokenizer st = new StringTokenizer(aux, ",");
/* 374 */               while (st.hasMoreTokens()) {
/* 375 */                 String token = st.nextToken().trim();
/* 376 */                 if (!res.contains(token))
/* 377 */                   res.add(token); 
/*     */               } 
/*     */             } 
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 384 */         if (line.trim().equals("File formats:")) {
/* 385 */           evaluate = true;
/*     */         }
/*     */       } 
/* 388 */     } catch (IOException e) {
/* 389 */       throw new EncoderException(e);
/*     */     } finally {
/* 391 */       ffmpeg.destroy();
/*     */     } 
/* 393 */     int size = res.size();
/* 394 */     String[] ret = new String[size];
/* 395 */     for (int i = 0; i < size; i++) {
/* 396 */       ret[i] = res.get(i);
/*     */     }
/* 398 */     return ret;
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
/*     */   public String[] getSupportedDecodingFormats() throws EncoderException {
/* 412 */     ArrayList<String> res = new ArrayList();
/* 413 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 414 */     ffmpeg.addArgument("-formats");
/*     */     try {
/* 416 */       ffmpeg.execute();
/* 417 */       RBufferedReader reader = null;
/* 418 */       reader = new RBufferedReader(new InputStreamReader(
/* 419 */             ffmpeg.getInputStream()));
/*     */       
/* 421 */       boolean evaluate = false; String line;
/* 422 */       while ((line = reader.readLine()) != null) {
/* 423 */         if (line.trim().length() == 0) {
/*     */           continue;
/*     */         }
/* 426 */         if (evaluate) {
/* 427 */           Matcher matcher = FORMAT_PATTERN.matcher(line);
/* 428 */           if (matcher.matches()) {
/* 429 */             String decoderFlag = matcher.group(1);
/* 430 */             if ("D".equals(decoderFlag)) {
/* 431 */               String aux = matcher.group(3);
/* 432 */               StringTokenizer st = new StringTokenizer(aux, ",");
/* 433 */               while (st.hasMoreTokens()) {
/* 434 */                 String token = st.nextToken().trim();
/* 435 */                 if (!res.contains(token))
/* 436 */                   res.add(token); 
/*     */               } 
/*     */             } 
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 443 */         if (line.trim().equals("File formats:")) {
/* 444 */           evaluate = true;
/*     */         }
/*     */       } 
/* 447 */     } catch (IOException e) {
/* 448 */       throw new EncoderException(e);
/*     */     } finally {
/* 450 */       ffmpeg.destroy();
/*     */     } 
/* 452 */     int size = res.size();
/* 453 */     String[] ret = new String[size];
/* 454 */     for (int i = 0; i < size; i++) {
/* 455 */       ret[i] = res.get(i);
/*     */     }
/* 457 */     return ret;
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
/*     */   
/*     */   public MultimediaInfo getInfo(File source) throws InputFormatException, EncoderException {
/* 475 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 476 */     ffmpeg.addArgument("-i");
/* 477 */     ffmpeg.addArgument(source.getAbsolutePath());
/*     */     try {
/* 479 */       ffmpeg.execute();
/* 480 */     } catch (IOException e) {
/* 481 */       throw new EncoderException(e);
/*     */     } 
/*     */     try {
/* 484 */       RBufferedReader reader = null;
/* 485 */       reader = new RBufferedReader(new InputStreamReader(
/* 486 */             ffmpeg.getErrorStream()));
/* 487 */       return parseMultimediaInfo(source, reader);
/*     */     } finally {
/* 489 */       ffmpeg.destroy();
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MultimediaInfo parseMultimediaInfo(File source, RBufferedReader reader) throws InputFormatException, EncoderException {
/* 512 */     Pattern p1 = Pattern.compile("^\\s*Input #0, (\\w+).+$\\s*", 
/* 513 */         2);
/* 514 */     Pattern p2 = Pattern.compile(
/* 515 */         "^\\s*Duration: (\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d).*$", 
/* 516 */         2);
/* 517 */     Pattern p3 = Pattern.compile(
/* 518 */         "^\\s*Stream #\\S+: ((?:Audio)|(?:Video)|(?:Data)): (.*)\\s*$", 
/* 519 */         2);
/* 520 */     MultimediaInfo info = null;
/*     */     try {
/* 522 */       int step = 0;
/*     */       while (true) {
/* 524 */         String line = reader.readLine();
/* 525 */         if (line == null) {
/*     */           break;
/*     */         }
/* 528 */         if (step == 0) {
/* 529 */           String token = String.valueOf(source.getAbsolutePath()) + ": ";
/* 530 */           if (line.startsWith(token)) {
/* 531 */             String message = line.substring(token.length());
/* 532 */             throw new InputFormatException(message);
/*     */           } 
/* 534 */           Matcher m = p1.matcher(line);
/* 535 */           if (m.matches()) {
/* 536 */             String format = m.group(1);
/* 537 */             info = new MultimediaInfo();
/* 538 */             info.setFormat(format);
/* 539 */             step++;
/*     */           } 
/* 541 */         } else if (step == 1) {
/* 542 */           Matcher m = p2.matcher(line);
/* 543 */           if (m.matches()) {
/* 544 */             long hours = Integer.parseInt(m.group(1));
/* 545 */             long minutes = Integer.parseInt(m.group(2));
/* 546 */             long seconds = Integer.parseInt(m.group(3));
/* 547 */             long dec = Integer.parseInt(m.group(4));
/* 548 */             long duration = dec * 100L + seconds * 1000L + 
/* 549 */               minutes * 60L * 1000L + 
/* 550 */               hours * 60L * 60L * 1000L;
/* 551 */             info.setDuration(duration);
/* 552 */             step++;
/*     */           } else {
/* 554 */             step = 3;
/*     */           } 
/* 556 */         } else if (step == 2) {
/* 557 */           Matcher m = p3.matcher(line);
/* 558 */           if (m.matches()) {
/* 559 */             String type = m.group(1);
/* 560 */             String specs = m.group(2);
/* 561 */             if ("Video".equalsIgnoreCase(type)) {
/* 562 */               VideoInfo video = new VideoInfo();
/* 563 */               StringTokenizer st = new StringTokenizer(specs, ",");
/* 564 */               for (int i = 0; st.hasMoreTokens(); i++) {
/* 565 */                 String token = st.nextToken().trim();
/* 566 */                 if (i == 0) {
/* 567 */                   video.setDecoder(token);
/*     */                 } else {
/* 569 */                   boolean parsed = false;
/*     */                   
/* 571 */                   Matcher m2 = SIZE_PATTERN.matcher(token);
/* 572 */                   if (!parsed && m2.find()) {
/* 573 */                     int width = Integer.parseInt(m2
/* 574 */                         .group(1));
/* 575 */                     int height = Integer.parseInt(m2
/* 576 */                         .group(2));
/* 577 */                     video.setSize(new VideoSize(width, 
/* 578 */                           height));
/* 579 */                     parsed = true;
/*     */                   } 
/*     */                   
/* 582 */                   m2 = FRAME_RATE_PATTERN.matcher(token);
/* 583 */                   if (!parsed && m2.find()) {
/*     */                     try {
/* 585 */                       float frameRate = 
/* 586 */                         Float.parseFloat(m2.group(1));
/* 587 */                       video.setFrameRate(frameRate);
/* 588 */                     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */                     
/* 591 */                     parsed = true;
/*     */                   } 
/*     */                   
/* 594 */                   m2 = BIT_RATE_PATTERN.matcher(token);
/* 595 */                   if (!parsed && m2.find()) {
/* 596 */                     int bitRate = Integer.parseInt(m2
/* 597 */                         .group(1));
/* 598 */                     video.setBitRate(bitRate);
/* 599 */                     parsed = true;
/*     */                   } 
/*     */                 } 
/*     */               } 
/* 603 */               info.setVideo(video);
/* 604 */             } else if ("Audio".equalsIgnoreCase(type)) {
/* 605 */               AudioInfo audio = new AudioInfo();
/* 606 */               StringTokenizer st = new StringTokenizer(specs, ",");
/* 607 */               for (int i = 0; st.hasMoreTokens(); i++) {
/* 608 */                 String token = st.nextToken().trim();
/* 609 */                 if (i == 0) {
/* 610 */                   audio.setDecoder(token);
/*     */                 } else {
/* 612 */                   boolean parsed = false;
/*     */                   
/* 614 */                   Matcher m2 = SAMPLING_RATE_PATTERN
/* 615 */                     .matcher(token);
/* 616 */                   if (!parsed && m2.find()) {
/* 617 */                     int samplingRate = Integer.parseInt(m2
/* 618 */                         .group(1));
/* 619 */                     audio.setSamplingRate(samplingRate);
/* 620 */                     parsed = true;
/*     */                   } 
/*     */                   
/* 623 */                   m2 = CHANNELS_PATTERN.matcher(token);
/* 624 */                   if (!parsed && m2.find()) {
/* 625 */                     String ms = m2.group(1);
/* 626 */                     if ("mono".equalsIgnoreCase(ms)) {
/* 627 */                       audio.setChannels(1);
/* 628 */                     } else if ("stereo"
/* 629 */                       .equalsIgnoreCase(ms)) {
/* 630 */                       audio.setChannels(2);
/*     */                     } 
/* 632 */                     parsed = true;
/*     */                   } 
/*     */                   
/* 635 */                   m2 = BIT_RATE_PATTERN.matcher(token);
/* 636 */                   if (!parsed && m2.find()) {
/* 637 */                     int bitRate = Integer.parseInt(m2
/* 638 */                         .group(1));
/* 639 */                     audio.setBitRate(bitRate);
/* 640 */                     parsed = true;
/*     */                   } 
/*     */                 } 
/*     */               } 
/* 644 */               info.setAudio(audio);
/*     */             } 
/*     */           } else {
/* 647 */             step = 3;
/*     */           } 
/*     */         } 
/* 650 */         if (step == 3) {
/* 651 */           reader.reinsertLine(line);
/*     */           break;
/*     */         } 
/*     */       } 
/* 655 */     } catch (IOException e) {
/* 656 */       throw new EncoderException(e);
/*     */     } 
/* 658 */     if (info == null) {
/* 659 */       throw new InputFormatException();
/*     */     }
/* 661 */     return info;
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
/*     */   private Hashtable parseProgressInfoLine(String line) {
/* 676 */     Hashtable table = null;
/* 677 */     Matcher m = PROGRESS_INFO_PATTERN.matcher(line);
/* 678 */     while (m.find()) {
/* 679 */       if (table == null) {
/* 680 */         table = new Hashtable();
/*     */       }
/* 682 */       String key = m.group(1);
/* 683 */       String value = m.group(2);
/* 684 */       table.put(key, value);
/*     */     } 
/* 686 */     return table;
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
/*     */   public void encode(File source, File target, EncodingAttributes attributes) throws IllegalArgumentException, InputFormatException, EncoderException {
/* 713 */     encode(source, target, attributes, null);
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
/*     */   public void encode(File source, File target, EncodingAttributes attributes, EncoderProgressListener listener) throws IllegalArgumentException, InputFormatException, EncoderException {
/* 743 */     String formatAttribute = attributes.getFormat();
/* 744 */     Float offsetAttribute = attributes.getOffset();
/* 745 */     Float durationAttribute = attributes.getDuration();
/* 746 */     AudioAttributes audioAttributes = attributes.getAudioAttributes();
/* 747 */     VideoAttributes videoAttributes = attributes.getVideoAttributes();
/* 748 */     if (audioAttributes == null && videoAttributes == null) {
/* 749 */       throw new IllegalArgumentException(
/* 750 */           "Both audio and video attributes are null");
/*     */     }
/* 752 */     target = target.getAbsoluteFile();
/* 753 */     target.getParentFile().mkdirs();
/* 754 */     FFMPEGExecutor ffmpeg = this.locator.createExecutor();
/* 755 */     if (offsetAttribute != null) {
/* 756 */       ffmpeg.addArgument("-ss");
/* 757 */       ffmpeg.addArgument(String.valueOf(offsetAttribute.floatValue()));
/*     */     } 
/* 759 */     ffmpeg.addArgument("-i");
/* 760 */     ffmpeg.addArgument(source.getAbsolutePath());
/* 761 */     if (durationAttribute != null) {
/* 762 */       ffmpeg.addArgument("-t");
/* 763 */       ffmpeg.addArgument(String.valueOf(durationAttribute.floatValue()));
/*     */     } 
/* 765 */     if (videoAttributes == null) {
/* 766 */       ffmpeg.addArgument("-vn");
/*     */     } else {
/* 768 */       String codec = videoAttributes.getCodec();
/* 769 */       if (codec != null) {
/* 770 */         ffmpeg.addArgument("-vcodec");
/* 771 */         ffmpeg.addArgument(codec);
/*     */       } 
/* 773 */       String tag = videoAttributes.getTag();
/* 774 */       if (tag != null) {
/* 775 */         ffmpeg.addArgument("-vtag");
/* 776 */         ffmpeg.addArgument(tag);
/*     */       } 
/* 778 */       Integer bitRate = videoAttributes.getBitRate();
/* 779 */       if (bitRate != null) {
/* 780 */         ffmpeg.addArgument("-b");
/* 781 */         ffmpeg.addArgument(String.valueOf(bitRate.intValue()));
/*     */       } 
/* 783 */       Integer frameRate = videoAttributes.getFrameRate();
/* 784 */       if (frameRate != null) {
/* 785 */         ffmpeg.addArgument("-r");
/* 786 */         ffmpeg.addArgument(String.valueOf(frameRate.intValue()));
/*     */       } 
/* 788 */       VideoSize size = videoAttributes.getSize();
/* 789 */       if (size != null) {
/* 790 */         ffmpeg.addArgument("-s");
/* 791 */         ffmpeg.addArgument(String.valueOf(String.valueOf(size.getWidth())) + "x" + 
/* 792 */             String.valueOf(size.getHeight()));
/*     */       } 
/*     */     } 
/* 795 */     if (audioAttributes == null) {
/* 796 */       ffmpeg.addArgument("-an");
/*     */     } else {
/* 798 */       String codec = audioAttributes.getCodec();
/* 799 */       if (codec != null) {
/* 800 */         ffmpeg.addArgument("-acodec");
/* 801 */         ffmpeg.addArgument(codec);
/*     */       } 
/* 803 */       Integer bitRate = audioAttributes.getBitRate();
/* 804 */       if (bitRate != null) {
/* 805 */         ffmpeg.addArgument("-ab");
/* 806 */         ffmpeg.addArgument(String.valueOf(bitRate.intValue()));
/*     */       } 
/* 808 */       Integer channels = audioAttributes.getChannels();
/* 809 */       if (channels != null) {
/* 810 */         ffmpeg.addArgument("-ac");
/* 811 */         ffmpeg.addArgument(String.valueOf(channels.intValue()));
/*     */       } 
/* 813 */       Integer samplingRate = audioAttributes.getSamplingRate();
/* 814 */       if (samplingRate != null) {
/* 815 */         ffmpeg.addArgument("-ar");
/* 816 */         ffmpeg.addArgument(String.valueOf(samplingRate.intValue()));
/*     */       } 
/* 818 */       Integer volume = audioAttributes.getVolume();
/* 819 */       if (volume != null) {
/* 820 */         ffmpeg.addArgument("-vol");
/* 821 */         ffmpeg.addArgument(String.valueOf(volume.intValue()));
/*     */       } 
/*     */     } 
/* 824 */     ffmpeg.addArgument("-f");
/* 825 */     ffmpeg.addArgument(formatAttribute);
/* 826 */     ffmpeg.addArgument("-y");
/* 827 */     ffmpeg.addArgument(target.getAbsolutePath());
/*     */     try {
/* 829 */       ffmpeg.execute();
/* 830 */     } catch (IOException e) {
/* 831 */       throw new EncoderException(e);
/*     */     }  try {
/*     */       long duration;
/* 834 */       String lastWarning = null;
/*     */       
/* 836 */       long progress = 0L;
/* 837 */       RBufferedReader reader = null;
/* 838 */       reader = new RBufferedReader(new InputStreamReader(
/* 839 */             ffmpeg.getErrorStream()));
/* 840 */       MultimediaInfo info = parseMultimediaInfo(source, reader);
/* 841 */       if (durationAttribute != null) {
/* 842 */         duration = 
/* 843 */           Math.round(durationAttribute.floatValue() * 1000.0F);
/*     */       } else {
/* 845 */         duration = info.getDuration();
/* 846 */         if (offsetAttribute != null) {
/* 847 */           duration -= 
/* 848 */             Math.round(offsetAttribute.floatValue() * 1000.0F);
/*     */         }
/*     */       } 
/* 851 */       if (listener != null) {
/* 852 */         listener.sourceInfo(info);
/*     */       }
/* 854 */       int step = 0;
/*     */       String line;
/* 856 */       while ((line = reader.readLine()) != null) {
/* 857 */         if (step == 0) {
/* 858 */           if (line.startsWith("WARNING: ")) {
/* 859 */             if (listener != null)
/* 860 */               listener.message(line); 
/*     */           } else {
/* 862 */             if (!line.startsWith("Output #0")) {
/* 863 */               throw new EncoderException(line);
/*     */             }
/* 865 */             step++;
/*     */           } 
/* 867 */         } else if (step == 1 && 
/* 868 */           !line.startsWith("  ")) {
/* 869 */           step++;
/*     */         } 
/*     */         
/* 872 */         if (step == 2) {
/* 873 */           if (!line.startsWith("Stream mapping:")) {
/* 874 */             throw new EncoderException(line);
/*     */           }
/* 876 */           step++;
/*     */         }
/* 878 */         else if (step == 3 && 
/* 879 */           !line.startsWith("  ")) {
/* 880 */           step++;
/*     */         } 
/*     */         
/* 883 */         if (step == 4) {
/* 884 */           line = line.trim();
/* 885 */           if (line.length() > 0) {
/* 886 */             Hashtable table = parseProgressInfoLine(line);
/* 887 */             if (table == null) {
/* 888 */               if (listener != null) {
/* 889 */                 listener.message(line);
/*     */               }
/* 891 */               lastWarning = line; continue;
/*     */             } 
/* 893 */             if (listener != null) {
/* 894 */               String time = (String)table.get("time");
/* 895 */               if (time != null) {
/* 896 */                 int dot = time.indexOf('.');
/* 897 */                 if (dot > 0 && dot == time.length() - 2 && 
/* 898 */                   duration > 0L) {
/* 899 */                   String p1 = time.substring(0, dot);
/* 900 */                   String p2 = time.substring(dot + 1);
/*     */                   try {
/* 902 */                     long i1 = Long.parseLong(p1);
/* 903 */                     long i2 = Long.parseLong(p2);
/* 904 */                     progress = i1 * 1000L + 
/* 905 */                       i2 * 100L;
/* 906 */                     int perm = 
/* 907 */                       (int)Math.round((progress * 1000L) / 
/* 908 */                         duration);
/* 909 */                     if (perm > 1000) {
/* 910 */                       perm = 1000;
/*     */                     }
/* 912 */                     listener.progress(perm);
/* 913 */                   } catch (NumberFormatException numberFormatException) {}
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 919 */             lastWarning = null;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 924 */       if (lastWarning != null && 
/* 925 */         !SUCCESS_PATTERN.matcher(lastWarning).matches()) {
/* 926 */         throw new EncoderException(lastWarning);
/*     */       }
/*     */     }
/* 929 */     catch (IOException e) {
/* 930 */       throw new EncoderException(e);
/*     */     } finally {
/* 932 */       ffmpeg.destroy();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\新建文件夹\jave-1.0.2_2\jave-1.0.2\jave-1.0.2.jar!\it\sauronsoftware\jave\Encoder.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */