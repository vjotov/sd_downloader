package com.jotov.sd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.ZoneId;
import java.util.SimpleTimeZone;

public class Filemover {
    private String destinationFolder;
    public Filemover(String destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    public void move(File file) {
        String pattern = "yyyy_MM_dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println("Mover:"+file.getName()+"#"+ simpleDateFormat.format(getCreationDate(file)));
    }

    private Date getCreationDate(File file) {
        try {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            return Date.from(attr.creationTime().toInstant());
//            return attr.creationTime()
//                    .toInstant()
//                    .atZone(ZoneId.systemDefault())
//                    .toLocalDateTime();
        } catch (IOException ex) {
            System.out.print(ex.getStackTrace());
            return null;
        }
    }
}
