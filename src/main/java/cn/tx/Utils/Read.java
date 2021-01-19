package cn.tx.Utils;

import ws.schild.jave.MultimediaObject;
import ws.schild.jave.info.MultimediaInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;

public class Read {


    /**
     *
     * @描述：获取视频时长
     * @param FileUrl
     * @return Long 单位为毫秒
     */
   public static Long  ReadVideoTime(String FileUrl) {
        File source=new File(FileUrl);
       // String length = "";
        long ls=0l;
        try {
            MultimediaObject instance = new MultimediaObject(source);
            MultimediaInfo result = instance.getInfo();
             ls = result.getDuration() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }



    /**
     *
     * @描述：获取视频大小
     * @param source
     * @return
     */
    @SuppressWarnings({ "resource" })
    String ReadVideoSize(File source) {
        FileChannel fc = null;
        String size = "";
        try {
            FileInputStream fis = new FileInputStream(source);
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            size = fileSize.divide(new BigDecimal(1048576), 2,RoundingMode.HALF_UP) + "MB";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return size;
    }

}