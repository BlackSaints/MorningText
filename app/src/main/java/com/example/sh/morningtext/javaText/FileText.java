package com.example.sh.morningtext.javaText;

import java.io.File;

public class FileText {

    public static void main(String[] args) {
        File file = new File("F:\\A");
        System.out.println(file.getName());
        tree(file,1);
    }

    /**
     * 递归调用获取子目录文件名
     */
    private static void tree(File file,int level) {
        String prestr = "";
        for (int i = 0; i < level; i++) {
            prestr += "------";
        }
        File[] childs = file.listFiles();
        for (int i = 0; i < childs.length; i++) {
            System.out.println(prestr+childs[i].getName());
            if(childs[i].isDirectory()){
                tree(childs[i],level+1);
            }
        }
    }

}
