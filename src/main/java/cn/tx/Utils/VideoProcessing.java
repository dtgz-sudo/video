package cn.tx.Utils;

import cn.tx.model.Video;
import org.apache.commons.io.FilenameUtils;

import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.*;

/**
 * -Xmx8096m -Xms512m
 */
public class VideoProcessing {
    // 视频所在目录
    private String path = "D:\\计算机考研\\【特 训】2019考研英语（二）60天抢分班（陈曲 韩苏 赵楠楠）\\【01】赵楠楠-极速阅读";
    private int length = 0;
    private volatile List<Video> list = new Vector<>();
    private List<File> files = null;
    private TextArea ta; // text 文本框

    public VideoProcessing(String path,TextArea ta) throws Exception {
        this.path = path;
        this.ta = ta;
        Date date1 = new Date();
        files = getAllFile();
        length = files.size();

        System.out.println("查找视频文件一共使用：" + ( System.currentTimeMillis() - date1.getTime() ) + "毫秒");
        ta.append("查找视频文件一共使用：" + ( System.currentTimeMillis() - date1.getTime() ) + "毫秒");
        ta.append("\r\n");
        Date date3 = new Date();

        //多线程处理 files 集合
        // 50个线程同时处理
        List<VideoThread> threadList = new ArrayList<>();
        int Threadlength = 50; // 线程数量
        int lengthOfFiles = files.size();//视频数量
        int length = lengthOfFiles / Threadlength; // 一个线程处理的文件数量
        int iOfTFiles = 0;// files文件
        for (int ii = 0; ii < Threadlength; ii++) {
            VideoThread thread = new VideoThread(length, list);
            threadList.add(thread);
            thread.setName("线程:" + ii);
            List<File> Tfiles = thread.getFiles();
            for (int j = 0; j < length && j < lengthOfFiles; j++) {
                Tfiles.add(files.get(iOfTFiles++));
            }
            if ( ii == Threadlength - 1 ) {
                while (iOfTFiles < lengthOfFiles) {
                    Tfiles.add(files.get(iOfTFiles++));
                }
            }
        }


        //所有线程开启
        for (VideoThread thread : threadList) {
            thread.start();
        }
        //所有线程设置守护线程
        for (VideoThread thread : threadList) {
            thread.join();
        }
        PoiUtils poiUtils = new PoiUtils();
        // 写道excel中
        String targetFilePath = getLastName("\\");
        if ( targetFilePath.equals("") ) {
            targetFilePath = getLastName("/");
        }
        if ( targetFilePath.equals("") ) {
            targetFilePath = "默认名称";
        }

        System.out.println("读取视频文件一共使用：" + ( System.currentTimeMillis() - date3.getTime() ) + "毫秒");
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();    //这便是读取桌面路径的方法了
        String deskPath = com.getPath();
        System.out.println("EXCEL绝对地址为:" + deskPath + "\\" + targetFilePath + ".xlsx");
        ta.append("读取视频文件一共使用：" + ( System.currentTimeMillis() - date3.getTime() ) + "毫秒");
        ta.append("\r\n");
        ta.append("EXCEL绝对地址为:" + deskPath + "\\" + targetFilePath + ".xlsx");
        ta.append("\r\n");
        Date date4 = new Date();
        //System.out.println(list);

        list.sort(new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                Video video1 = (Video) o1;
                Video video2 = (Video) o2;
                return video1.name.compareTo(video2.name);
            }
        });
        System.out.println("排序的时间：" + ( ( System.currentTimeMillis() - date4.getTime() ) ) + "毫秒");
        ta.append("排序的时间：" + ( ( System.currentTimeMillis() - date4.getTime() ) ) + "毫秒");
        ta.append("\r\n");
        Date date5 = new Date();
        poiUtils.writeExcel(deskPath + "\\" + targetFilePath + ".xlsx", list);

        System.out.println("向Excel文件写入数据一共使用：" + ( ( System.currentTimeMillis() - date5.getTime() ) ) + "毫秒");
        System.out.println("程序一共使用：" + ( ( System.currentTimeMillis() - date1.getTime() ) ) + "毫秒");
        ta.append("向Excel文件写入数据一共使用：" + ( ( System.currentTimeMillis() - date5.getTime() ) ) + "毫秒");
        ta.append("\r\n");
        ta.append("程序一共使用：" + ( ( System.currentTimeMillis() - date1.getTime() ) ) + "毫秒");
        ta.append("\r\n");

    }


    private  List<File> getAllFile() {
        List<File> files = new ArrayList<>();
        File file = new File(path);
        findVedio(files, file);

        return files;
    }

    /**
     * 递归 查找视频
     *
     * @param files
     * @param file
     */
    private  void findVedio(List<File> files, File file) {

        try {
            if ( file != null ) {
                if ( file.isDirectory() ) {
                    File[] files1 = file.listFiles();
                    if ( files1 != null ) //文件夹不为空
                    {
                        for (int i = 0; i < files1.length; i++) {
                            if ( file.isDirectory() ) {
                                findVedio(files, files1[i]);
                            } else if ( isVedeo(files1[i]) ) {
                                files.add(files1[i]);
                            }
                        }
                    }


                } else {
                    if ( isVedeo(file) )
                        files.add(file);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 判断文件是否是视频
     *
     * @param file
     * @return
     */
    private  boolean isVedeo(File file) {


        if ( file != null ) {
            String name = FilenameUtils.getExtension(file.getName());// 获取扩展名
            if ( !"".equals(name) && ( name.equalsIgnoreCase("mp4")
                    || name.equalsIgnoreCase("flv")
                    || name.equalsIgnoreCase("mxf")
                    || name.equalsIgnoreCase("mov")
                    || name.equalsIgnoreCase("avi") ) ) {
                return true;
            }
        }

        return false;
    }

    public  String getLastName(String filename) {
        if ( filename == null ) {
            return null;
        } else {
            int index = indexOfExtension(filename);
            return index == -1 ? "" : path.substring(index + 1);
        }
    }

    public  int indexOfExtension(String filename) {
        if ( filename == null ) {
            return -1;
        } else {
            int extensionPos = path.lastIndexOf(filename);
            int lastSeparator = indexOfLastSeparator(filename);
            return lastSeparator > extensionPos ? -1 : extensionPos;
        }
    }

    public  int indexOfLastSeparator(String filename) {
        if ( filename == null ) {
            return -1;
        } else {
            int lastUnixPos = path.lastIndexOf(filename);
            int lastWindowsPos = path.lastIndexOf(filename);
            return Math.max(lastUnixPos, lastWindowsPos);
        }
    }
}
