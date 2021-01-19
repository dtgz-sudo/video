import cn.tx.Utils.Read;
import org.junit.Test;

public class MultimediaInfoTest {

    @Test
    public  void main() {
        Read r=new Read();

        String path = "D:\\JAVAEE+大数据基础\\教学视频\\Hadoop大数据阶段/001、大数据技术领域介绍及学习方法和发展规划 - 副本.mp4" ;
        Long length=r.ReadVideoTime(path);
        System.out.println("总时长："+length);

    }
}
