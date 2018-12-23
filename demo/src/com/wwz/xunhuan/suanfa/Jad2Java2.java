package com.wwz.xunhuan.suanfa;

import java.io.*;

public class Jad2Java2 {
    public static void main(String[] args) throws Exception {
        File srcDir=new File("D:\\usr\\test\\java");
        if (!(srcDir.exists()&&srcDir.isDirectory())){
            throw new Exception("目录不存在");
        }
        //文件以.java结尾的文件数组
        File[] files = srcDir.listFiles((file, name) -> name.endsWith(".java"));
        System.out.println(files.length);
        File desDir=new File("D:\\usr\\test\\jad");
        if (!desDir.exists())desDir.mkdir();
        for (File file:files){
            if (!file.isDirectory()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                String destFileName = file.getName().replaceAll("\\.java", ".jad");
                FileOutputStream fileOutputStream = new FileOutputStream(new File(desDir, destFileName));
                copy(fileInputStream, fileOutputStream);
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }
    private static void copy(InputStream inputStream, OutputStream outputStream) throws Exception {
        int length;
        byte[] beties = new byte[1024];
        while ((length=inputStream.read(beties))!=-1){
            outputStream.write(beties,0,length);
        }
    }
}
