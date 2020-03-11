import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main( String[] args ){
        try{
            String pathRoot = null;
            String fileName = "VGERMJRobotServiceDetail_20191105.txt";
            String username = "";
            //jar 中没有目录的概念
            URL location = Application.class.getProtectionDomain().getCodeSource().getLocation();//获得当前的URL
            File file = new File(location.getPath());//构建指向当前URL的文件描述符
            if(file.isDirectory()){//如果是目录,指向的是包所在路径，而不是文件所在路径
                pathRoot = file.getAbsolutePath();//直接返回绝对路径
            }else{//如果是文件,这个文件指定的是jar所在的路径(注意如果是作为依赖包，这个路径是jvm启动加载的jar文件名)
                pathRoot = file.getParent();//返回jar所在的父路径
            }

            int len = args.length;
            if(len == 3){
                pathRoot = args[0];
                fileName = args[1];
                username = args[2];
            }else if(len == 2){
                fileName = args[1];
                username = args[2];
            }else if(len == 1){
                username = args[2];
            }else{
                System.err.println("没有输入要查询的路径名字");
                System.exit(1);
            }


            Path path = Paths.get(pathRoot, fileName);
            Path targetPath = Paths.get(pathRoot,"log.txt");
            List<String> strings = Files.readAllLines(path, Charset.forName("UTF-8"));
            List<String> outString = new ArrayList<>();
            for(String str : strings){
                if(str.contains(username)){
                    if(str.contains("init:")){
                        outString.clear();
                    }
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(str.substring(str.indexOf(username) + username.length()));
                    outString.add(buffer.toString().trim());
                }
            }
            if(!Files.exists(targetPath)){
                Files.createFile(targetPath);
            }
            Files.write(targetPath,outString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
