package org.zhx.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SendMailUtil {
    public final static String PROTOCOL = "smtp";
    public final static String HOST = "smtp.exmail.qq.com";
    public final static int DEFAULT_PORT = 465;

    private String fromEmailAddress = "zhanghexiang@smzy.cc";
    private String fromEmailAddresssPassword = "sMZY201705";
    private List<String> receiveEmailAddresses = new ArrayList<>();
    private List<String> CCEmailAddresses = new ArrayList<>();
    private List<String> BCCEmailAddresses = new ArrayList<>();
    private List<String> eMailAttachments = new ArrayList<>();

    private String emailSubject;
    private String emailContent;

    public SendMailUtil(Properties properties){
        String str = (String)properties.get("username");
        if(str != null && !"".equals(str)){
            this.fromEmailAddress = str;
        }
        str = (String)properties.get("password");
        if(str != null && !"".equals(str)){
            this.fromEmailAddresssPassword = str;
        }

        String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+";
        str = (String)properties.get("to");
        if(str != null && !"".equals(str)){
            String[] arr = str.split(":");
            for(String s : arr){
                if(s.matches(reg)){
                    this.receiveEmailAddresses.add(s);
                }else{
                    //不是邮箱
                }
            }
        }

        str = (String)properties.get("cc");
        if(str != null && !"".equals(str)){
            String[] arr = str.split(":");
            for(String s : arr){
                if(s.matches(reg)){
                    this.CCEmailAddresses.add(s);
                }else{
                    //不是邮箱
                }
            }
        }

        str = (String)properties.get("bcc");
        if(str != null && !"".equals(str)){
            String[] arr = str.split(":");
            for(String s : arr){
                if(s.matches(reg)){
                    this.BCCEmailAddresses.add(s);
                }else{
                    //不是邮箱
                }
            }
        }

        str = (String)properties.get("subject");
        if(str != null && !"".equals(str)){
            this.emailSubject = str;
        }

        str = (String)properties.get("content");
        if(str != null && !"".equals(str)){
            this.emailContent = str;
        }

        str = (String)properties.get("attachments");
        if(str != null && !"".equals(str)){
            String[] arr = str.split(":");
            for(String s : arr){
                this.eMailAttachments.add(s);
            }
        }
    }

    public boolean sendEmail(String contentStr){
        try{
            Properties properties = new Properties();
            properties.put("mail.transport.protocol", PROTOCOL);// 连接协议
            properties.put("mail.smtp.host", HOST);// 主机名
            properties.put("mail.smtp.port", DEFAULT_PORT);// 端口号
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
            properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
            // 得到回话对象
            Session session = Session.getInstance(properties);
            // 获取邮件对象
            Message message = new MimeMessage(session);

            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress(fromEmailAddress));

            // 设置收件人邮箱地址
            //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
            //message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("panjiyang@smzy.cc"),new InternetAddress("zhanghx@smzy.cc")});
            InternetAddress[] to = new InternetAddress[this.receiveEmailAddresses.size()];
            for(int i=0;i<this.receiveEmailAddresses.size();i++){
                try{
                    String receive = this.receiveEmailAddresses.get(i);
                    InternetAddress address = new InternetAddress(receive);
                    to[i] = address;
                }catch (Exception e){
                    throw new RuntimeException("存在不合法的邮箱地址" + this.receiveEmailAddresses.get(i));
                }
            }
            message.setRecipients(Message.RecipientType.TO, to);

//        // 设置抄送人邮箱地址
//        message.setRecipients(Message.RecipientType.CC, new InternetAddress[]{new InternetAddress("panjiyang@smzy.cc"),new InternetAddress("zhanghx@smzy.cc")});
            if(this.CCEmailAddresses.size() > 0 ){
                InternetAddress[] cc = new InternetAddress[this.CCEmailAddresses.size()];
                for(int i=0;i<this.CCEmailAddresses.size();i++){
                    try{
                        String receive = this.CCEmailAddresses.get(i);
                        InternetAddress address = new InternetAddress(receive);
                        cc[i] = address;
                    }catch (Exception e){
                        throw new RuntimeException("存在不合法的抄送邮箱地址" + this.CCEmailAddresses.get(i));
                    }
                }
                message.setRecipients(Message.RecipientType.CC, cc);
            }


//        // 设置秘密抄送人邮箱地址
//        message.setRecipients(Message.RecipientType.BCC, new InternetAddress[]{new InternetAddress("panjiyang@smzy.cc"),new InternetAddress("zhanghx@smzy.cc")});
            if(this.BCCEmailAddresses.size() > 0 ){
                InternetAddress[] bcc = new InternetAddress[this.BCCEmailAddresses.size()];
                for(int i=0;i<this.BCCEmailAddresses.size();i++){
                    try{
                        String receive = this.BCCEmailAddresses.get(i);
                        InternetAddress address = new InternetAddress(receive);
                        bcc[i] = address;
                    }catch (Exception e){
                        throw new RuntimeException("存在不合法的秘密抄送邮箱地址" + this.BCCEmailAddresses.get(i));
                    }
                }
                message.setRecipients(Message.RecipientType.BCC, bcc);
            }

            // 设置邮件标题
            message.setSubject(this.emailSubject);
//        // 设置邮件内容
//        message.setText("邮件内容邮件内容邮件内容xmqtest");

            //设置邮件附件及主题
            // 添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 添加邮件正文
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(this.emailContent  + "\n" + contentStr, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);

            // 遍历添加附件
            List<File> fileList = new ArrayList<File>();
            for(String filename : this.eMailAttachments){
                fileList.add(new File(filename));
            }
            if (fileList != null && fileList.size() > 0) {
                for (File file : fileList) {
                    try{
                        BodyPart attachmentBodyPart = new MimeBodyPart();
                        DataSource source = new FileDataSource(file);
                        attachmentBodyPart.setDataHandler(new DataHandler(source));
                        attachmentBodyPart.setFileName(file.getName());
                        multipart.addBodyPart(attachmentBodyPart);
                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                }
            }

            // 将多媒体对象放到message中
            message.setContent(multipart);

            // 得到邮差对象
            Transport transport = session.getTransport();
            // 连接自己的邮箱账户
            transport.connect(this.fromEmailAddress, this.fromEmailAddresssPassword);// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getFromEmailAddresssPassword() {
        return fromEmailAddresssPassword;
    }

    public void setFromEmailAddresssPassword(String fromEmailAddresssPassword) {
        this.fromEmailAddresssPassword = fromEmailAddresssPassword;
    }

    public List<String> getReceiveEmailAddresses() {
        return receiveEmailAddresses;
    }

    public void setReceiveEmailAddresses(List<String> receiveEmailAddresses) {
        this.receiveEmailAddresses = receiveEmailAddresses;
    }

    public List<String> getCCEmailAddresses() {
        return CCEmailAddresses;
    }

    public void setCCEmailAddresses(List<String> CCEmailAddresses) {
        this.CCEmailAddresses = CCEmailAddresses;
    }

    public List<String> getBCCEmailAddresses() {
        return BCCEmailAddresses;
    }

    public void setBCCEmailAddresses(List<String> BCCEmailAddresses) {
        this.BCCEmailAddresses = BCCEmailAddresses;
    }

    public List<String> geteMailAttachments() {
        return eMailAttachments;
    }

    public void seteMailAttachments(List<String> eMailAttachments) {
        this.eMailAttachments = eMailAttachments;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public static void main(String args[]){
        BufferedReader reader = null;
        try {
            File f = new File("File/multiValue.properties");
            System.out.println(f.getAbsolutePath());
            FileInputStream in = new FileInputStream(f);
            BufferedInputStream bin = new BufferedInputStream(in);
            Reader rin = new InputStreamReader(bin, Charset.forName("UTF-8"));
            reader = new BufferedReader(rin);
        } catch (FileNotFoundException e) {}
        Properties properties=new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {}

        if(args.length > 0)
            new SendMailUtil(properties).sendEmail(args[0]);
        else
            new SendMailUtil(properties).sendEmail("");

        try {
            //DingDingRobot.notifyDingDing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
