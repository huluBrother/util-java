package org.zhx.audio;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        String dir = "F:\\BaiduNetdiskDownload\\07. 微服务架构阶段\\1. spring boot";//14 小时
        dir = "F:\\BaiduNetdiskDownload\\07. 微服务架构阶段\\2. SpringData"; //7 个小时
        dir = "F:\\BaiduNetdiskDownload\\07. 微服务架构阶段\\3. SpringCloud";//11 个小时
        dir = "F:\\BaiduNetdiskDownload\\07. 微服务架构阶段\\3. SpringCloud\\04第四章 RabbitMQ实战";
        dir = "F:\\BaiduNetdiskDownload\\07. 微服务架构阶段\\3. SpringCloud\\05第五章 Eureka注册中心讲解";
        dir = "F:\\BaiduNetdiskDownload";
        dir = "F:\\BaiduNetdiskDownload\\08. 分布式亿级高并发电商项";

        File source = new File(dir);
        Encoder encoder = new Encoder();
        File[] fileArray = source.listFiles();
        List<File> files = new ArrayList<>();
        for (File file : fileArray){
            files.add(file);
        }

        long sum =0;
        while(files.size() > 0){
            File file = files.get(0);
            try{
                if(file.isFile() && isAudioFile(file)){
                    try {
                        MultimediaInfo m = encoder.getInfo(file);
                        long fileMs = m.getDuration();
                        long fms = fileMs % 1000;//毫秒
                        long fs = fileMs / 1000;//秒
                        long fmin = fs / 60;//分钟
                        fs = fs % 60;//分钟外秒数
                        long fh = fmin / 60;//小时
                        fmin = fmin % 60;//小时外分钟

                        System.out.println(file.getAbsolutePath()+"/" + file.getName() +
                                "==>" + fh +":" + fmin+":" + fs+" (" + fms + ")");
                        long ls = m.getDuration()/1000;  //ls是获取到的秒数
                        sum += ls;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        //System.out.println("异常文件" + file.getAbsolutePath()+"/"+file.getName());
                    }
                }else if(file.isDirectory()){
                    for(File f : file.listFiles()){
                        files.add(f);
                    }
                }else{
                    System.out.println("非视频文件:" +file.getName());
                }
            }finally {
                files.remove(file);
            }

        }
        double sum1 = (double)sum;
        double sum2 =sum1/3600;// 转换成为了小时
        if(sum2 > 3){
            System.out.println(sum2 + "h");
        }else{
            System.out.println(sum1 / 60 + "min");
        }

    }

    public static boolean isAudioFile(File file){
        final List<String> audioSuffixNames = new ArrayList<>();
        audioSuffixNames.add(".mp4");
        audioSuffixNames.add(".avi");

        String filename = file.getName();
        int index = filename.lastIndexOf(".");
        if(index == -1)
            return false;
        String fileSuffixName = filename.substring(index);
        return audioSuffixNames.contains(fileSuffixName);
    }
}
