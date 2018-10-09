package com.jotov.sd;

import java.io.File;
import java.io.IOException;


public class Main {
    static String sourceFolder;
    static String targetFolder;

    public static void main(String[] args) throws IOException  {
        Config cfg = new Config();
        sourceFolder   = cfg.getProperty("sd_path");
        targetFolder = cfg.getProperty("download_path");
        Filewalker fw = new Filewalker();
        fw.walk(sourceFolder);
    }

    private static void listSourceFolder(){
        File directory = new File(sourceFolder);
        System.out.println(directory.exists());


        File[] contentsOfDirectory = directory.listFiles();
        for (File object : contentsOfDirectory) {
            if (object.isFile()){
                System.out.format("File name: %s%n", object.getName());
            } else if (object.isDirectory()) {
                System.out.format("Directory name: %s%n", object.getName());
            }
        }
    }

}
