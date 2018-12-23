package com.wwz.xunhuan.suanfa;

import java.io.*;
import java.util.Arrays;

/**
 * 编写一个程序，将d:\java目录下的所有.java文件复制到d:\jad目录下，
 * 并将原来文件的扩展名从.java改为.jad。
 */
public class Jad2Java {

    public static void main(String[] args) throws Exception {
        File srcDir = new File("java");
        if(!(srcDir.exists() && srcDir.isDirectory()))
            throw new Exception("目录不存在");
        File[] files = srcDir.listFiles(
                (dir, name) -> name.endsWith(".java")
        );
        System.out.println(files.length);
        File destDir = new File("jad");
        if(!destDir.exists()) destDir.mkdir();
        for(File f :files){
            FileInputStream fis = new FileInputStream(f);
            String destFileName = f.getName().replaceAll("\\.java$", ".jad");
            FileOutputStream fos = new FileOutputStream(new File(destDir,destFileName));
            copy(fis,fos);
            fis.close();
            fos.close();
        }
    }

    private static void copy(InputStream ips, OutputStream ops) throws Exception{
        int len = 0;
        byte[] buf = new byte[1024];
        while((len = ips.read(buf)) != -1){
            ops.write(buf,0,len);
        }

    }
    //分析listFiles方法内部的策略模式实现原理
 /*   File[] listFiles(FileFilter filter){
        File[] files = listFiles(filter);
        //Arraylist acceptedFilesList = new ArrayList();
        File[] acceptedFiles = new File[files.length];
        int pos = 0;
        for(File file: files){
            boolean accepted = filter.accept(file);
            //acceptedFilesList.add(file);
            if(accepted) acceptedFiles[pos++] = file;
        }

        Arrays.copyOf(acceptedFiles,pos);
        return (File[])accpetedFilesList.toArray();

    }*/

}
/**
 * 由本题总结的思想及策略模式的解析：
 * 1.
 * class jad2java{
 * 	1. 得到某个目录下的所有的java文件集合
 * 		1.1 得到目录 File srcDir = new File("d:\\java");
 * 		1.2 得到目录下的所有java文件：File[] files = srcDir.listFiles(new MyFileFilter());
 * 		1.3 只想得到.java的文件： class MyFileFilter implememyts FileFilter{
 * 			public boolean accept(File pathname){
 * 				return pathname.getName().endsWith(".java")
 *                        }* 		}
 *
 * 	2.将每个文件复制到另外一个目录，并改扩展名
 * 		2.1 得到目标目录，如果目标目录不存在，则创建之
 * 		2.2 根据源文件名得到目标文件名，注意要用正则表达式，注意.的转义。
 * 		2.3 根据表示目录的File和目标文件名的字符串，得到表示目标文件的File。
 * 			//要在硬盘中准确地创建出一个文件，需要知道文件名和文件的目录。
 * 		2.4 将源文件的流拷贝成目标文件流，拷贝方法独立成为一个方法，方法的参数采用抽象流的形式。
 * 			//方法接受的参数类型尽量面向父类，越抽象越好，这样适应面更宽广。
 * }
 */
