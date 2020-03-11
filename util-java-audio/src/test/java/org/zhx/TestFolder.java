package org.zhx;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestFolder {

    @Test
    public void testTime() {
        File root = new File("F:\\BaiduNetdiskDownload");
        Encoder encoder = new Encoder();
        long totalTime = 0L;

        List<File> allFile = new ArrayList<>();
        for (File f : root.listFiles()) {
            allFile.add(f);
        }
        List<String> excess = new ArrayList<>();
        //392.6 h
        excess.add(".accelerate");
        excess.add("03. 网页开发和设计");  //38.5h
        excess.add("04. Servlet和JSP(JAVAEE基础)");//33.1h
        excess.add("05. 高级框架阶段");//116.rh
        excess.add("06. 互联网架构阶段");//143.1h
        excess.add("07. 微服务架构阶段");//29.5h
        excess.add("08. 分布式亿级高并发电商项");//25.6h
        excess.add("09.100套毕设项目(第一季42套含源码和辅导视频)【北京尚学堂·百战程序员】");//6.0h
        MultimediaInfo m = null;
        while (!allFile.isEmpty()) {
            File file = allFile.remove(0);
            if(excess.contains(file.getName())){
                System.out.println("目录:" + file.getName() + " 已经完成" );
                continue;
            }
            if (file.isFile()) {
                if (file.getName().endsWith("pdf")
                        || file.getName().endsWith("txt")
                        || file.getName().endsWith("url")
                        || file.getName().endsWith("conf")
                        || file.getName().endsWith("cnf")
                        || file.getName().endsWith("gz")
                        || file.getName().endsWith("tar")
                        || file.getName().endsWith("doc")
                        || file.getName().endsWith("docx")
                        || file.getName().endsWith("ppt")
                        || file.getName().endsWith("pptx")
                        || file.getName().endsWith("exe")
                        || file.getName().endsWith("MDF")
                        || file.getName().endsWith("rar")
                        || file.getName().endsWith("zip")) {
                    //System.out.println(file.getName() + "无用计算");
                    continue;
                }
                try {
                    m = encoder.getInfo(file);

                    long fileMs = m.getDuration();
                    long fms = fileMs % 1000;//毫秒
                    long fs = fileMs / 1000;//秒
                    long fmin = fs / 60;//分钟
                    fs = fs % 60;//分钟外秒数
                    long fh = fmin / 60;//小时
                    fmin = fmin % 60;//小时外分钟

                    System.out.println(file.getName() + "==>" + fh + ":" + fmin + ":" + fs + ":" + fms);
                    long ls = m.getDuration() / 1000;  //ls是获取到的秒数
                    totalTime += ls;
                } catch (EncoderException e) {
                    System.err.println(file.getName() + " error");
                }
            } else {
                for (File f : file.listFiles()) {
                    allFile.add(f);
                }
            }
        }
        double sum1 = (double) totalTime;
        double sum2 = sum1 / 3600;// 转换成为了小时
        System.out.println(sum2);
    }

    @Test
    public void testSingleTime() {
        File root = new File("F:\\BaiduNetdiskDownload\\05. 高级框架阶段\\12. nginx服务器\\收费视频_13_nginx_198元");
        Encoder encoder = new Encoder();
        long totalTime = 0L;

        List<File> allFile = new ArrayList<>();
        for (File f : root.listFiles()) {
            allFile.add(f);
        }
        MultimediaInfo m = null;
        while (!allFile.isEmpty()) {
            File file = allFile.remove(0);
            if (file.isFile()) {
                try {
                    m = encoder.getInfo(file);

                    long fileMs = m.getDuration();
                    long fms = fileMs % 1000;//毫秒
                    long fs = fileMs / 1000;//秒
                    long fmin = fs / 60;//分钟
                    fs = fs % 60;//分钟外秒数
                    long fh = fmin / 60;//小时
                    fmin = fmin % 60;//小时外分钟

                    System.out.println(file.getName() + "==>" + fh + ":" + fmin + ":" + fs + ":" + fms);
                    long ls = m.getDuration() / 1000;  //ls是获取到的秒数
                    totalTime += ls;
                } catch (EncoderException e) {
                    System.err.println(file.getName() + " error");
                }
            } else {
                for (File f : file.listFiles()) {
                    allFile.add(f);
                }
            }
        }
        double sum1 = (double) totalTime;
        double sum2 = sum1 / 3600;// 转换成为了小时
        System.out.println(sum2);
    }
}
