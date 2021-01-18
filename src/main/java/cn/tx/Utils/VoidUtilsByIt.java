package cn.tx.Utils; /**
 * @Author:psw
 * @Description:获取视频宽高大小时间工具类
 */

import it.sauronsoftware.jave.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public class VoidUtilsByIt {
    public static void main(String[] args){
        File source = new File("http://flv4.people.com.cn/videofile3//CCTV1/2018/1/14/CCTV1_1500000_20181114_30322514_0_113_android_l.mp4");
        Encoder encoder = new Encoder();
        FileChannel fc= null;
        String size = "";
        try {
            it.sauronsoftware.jave.MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            System.out.println("此视频时长为:"+ls/60000+"分"+(ls)/1000+"秒！");
            //视频帧宽高
            System.out.println("此视频高度为:"+m.getVideo().getSize().getHeight());
            System.out.println("此视频宽度为:"+m.getVideo().getSize().getWidth());
            System.out.println("此视频格式为:"+m.getFormat());
            FileInputStream fis = new FileInputStream(source);
            fc= fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP) + "MB";
            System.out.println("此视频大小为"+size);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null!=fc){
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param path
     * @return Map
     */
    public static Map<String, Object> getVoideMsg(String path){

        Map<String, Object> map = new HashMap<String, Object>();
        File file = new File(path);
        Encoder encoder = new Encoder();
        FileChannel fc= null;
        String size = "";

        if(file != null){
            try {
                it.sauronsoftware.jave.MultimediaInfo m = encoder.getInfo(file);
                long ls = m.getDuration();

                FileInputStream fis = new FileInputStream(file);
                fc= fis.getChannel();
                BigDecimal fileSize = new BigDecimal(fc.size());
                size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP) + "MB";

                map.put("height", m.getVideo().getSize().getHeight());
                map.put("width", m.getVideo().getSize().getWidth());
                map.put("format", m.getFormat());
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (null!=fc){
                    try {
                        fc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return map;
    }
}

