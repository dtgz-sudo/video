import cn.tx.Utils.VideoUtil;

import java.io.IOException;

public class VideoUtilTest {


    public void getDuration() throws IOException {
        String path = "D:\\JAVAEE+大数据基础\\教学视频\\Hadoop大数据阶段/001、大数据技术领域介绍及学习方法和发展规划 - 副本.mp4" ;
      /*  String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mp4" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.wav" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.mov" ;
        String path = "/Users/liuwen/Downloads/temp/语音测试文件/xiaoshizi.m4a" ;*/

        while (true)
        {

            long result = VideoUtil.getDuration(path);
            System.out.println(result);
            break;
        }
    }

}