package cn.tx.Utils;

import cn.tx.model.Video;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程分析视频
 */
public class VideoThread extends Thread {
    //public static AtomicInteger i = new AtomicInteger();
    //static AtomicInteger i = new AtomicInteger();
    private int i = 0;
    private static int count = 0;// 处理的视频的个数
    //    // 视频解码类
//    private static Encoder encoder = new Encoder();
//    //   视频处理类
//    private it.sauronsoftware.jave.MultimediaInfo m = null;
    private int length = 0;
    private volatile List<Video> list = null;
    private List<File> files = new ArrayList<>();
    // 线程静态锁
    //  private static Object object = new Object();
    // 多线程锁修改为ReentrantLock
    ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        super.run();
        // System.out.println(this.getName() + " 开始工作");
        length = files.size();
        String name = "";
        double size = 0l;
        //       System.out.println(name + ":" + size + "Mb");
        String path = "";
        long ls = 0;
        Date date = new Date(ls);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        String time = formatter.format(ls);
        for (; i < length; i++) {

            File file = files.get(i);
            {
                try {
                    //     System.out.println(i.get());
                    name = file.getName();
                    size = file.length() * 1.0 / 1024 / 1024;
                    //       System.out.println(name + ":" + size + "Mb");
                    path = file.getAbsolutePath();
                    ls = Read.ReadVideoTime(path);
                    date = new Date(ls);
                    formatter.setTimeZone(TimeZone.getTimeZone("GMT-0"));
                    time = formatter.format(ls);
                    Video video = new Video(name, (int) Math.round(size), time);
                    // 加锁保证原子性
                    lock.lock();
                    list.add(video);
                    //System.out.println(ObjectSize.getSizeOf(list));
                    System.out.println(this.getName() + " : " + count++ + video);
                    lock.lock();

//                    System.out.println(video);
//                    System.out.println();
//                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.getName() + " 完成任务");

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
