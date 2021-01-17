package cn.tx.model;

public class Video  implements Comparable{

    //视频名字
   public  String name;

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", time='" + time + '\'' +
                '}'+"\n";
    }

    //视频大小
    int size ;

    public Video(String name, int size, String time) {
        this.name = name;
        this.size = size;
        this.time = time;
    }

    //视频时长
    String  time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Video(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        Video video = (Video) o;
        return this.name .compareTo(video.name);
    }
}
