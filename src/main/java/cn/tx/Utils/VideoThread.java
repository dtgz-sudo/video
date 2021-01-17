package cn.tx.Utils;

import cn.tx.model.Video;
import it.sauronsoftware.jave.Encoder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class VideoThread extends Thread {
    //public static AtomicInteger i = new AtomicInteger();
    //static AtomicInteger i = new AtomicInteger();
    private    int i = 0;

    // 视频解码类
    private static Encoder encoder = new Encoder();
    //   视频处理类
    private it.sauronsoftware.jave.MultimediaInfo m = null;
    private int length = 0;
    private volatile List<Video> list = new Vector<>();
    private List<File> files =new ArrayList<>();


    @Override
    public void run() {
        super.run();
            // System.out.println(this.getName() + " 开始工作");
        length = files.size();
            for (; i < length; i++) {

                File file = files.get( i);
                {
                    try {
                   //     System.out.println(i.get());
                    String name = file.getName();
                    double size = file.length() * 1.0 / 1024 / 1024;
                    //       System.out.println(name + ":" + size + "Mb");
                    m = encoder.getInfo(file);
                    long ls = m.getDuration();
                    Date date = new Date(ls);
                    DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    formatter.setTimeZone(TimeZone.getTimeZone("GMT-0"));
                    String time = formatter.format(ls);
                    Video video = new Video(name, (int) Math.round(size), time);

                    synchronized (encoder)
                    {
                        list.add(video);
                    }
                 //  System.out.println(this.getName() + " : " +i+video);
//                    System.out.println(video);
//                    System.out.println();
//                    System.out.println();
                    } catch (Exception e) {
                        System.out.println(this.getName()+e.getMessage());
                    }
                }
            }



    }


    public VideoThread(int length, List<Video> list) {
        this.length = length;
        this.list = list;
    }
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

}
