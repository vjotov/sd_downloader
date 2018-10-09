package com.jotov.sd;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    static String sourceFolder;
    static String targetFolder;

    public static void main(String[] args) throws IOException  {
        Config cfg = new Config();
        sourceFolder   = cfg.getProperty("sd_path");
        targetFolder = cfg.getProperty("download_path");
    }

}
