package com.jotov.sd;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException  {
        Config cfg = new Config();
        String from   = cfg.getProperty("sd_path");
        System.out.println(from);
        String to = cfg.getProperty("download_path");
        System.out.println(to);
    }
    // read config
    private static void loadConfig() throws IOException {
        String propFileName = "config.properties";
        CrunchifyGetPropertyValues properties = new CrunchifyGetPropertyValues();
        String propValues = properties.getPropValues();
    }
}
