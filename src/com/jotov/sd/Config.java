package com.jotov.sd;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.Properties;

public class Config
{
    Properties configFile;
    public Config()
    {
        String filename = "/config.properties";
        InputStream is = Config.class.getResourceAsStream(filename);
        System.out.println(is==null);

        configFile = new java.util.Properties();
        try {
            configFile.load(is);
        }catch(Exception eta){
            eta.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        String value = this.configFile.getProperty(key);
        return value;
    }
}