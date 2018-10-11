package com.jotov.sd;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Filecopier {
    private String destinationFolder;
    public Filecopier(String destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    public void copy(File file) {
        String pattern = "yyyy_MM_dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fileDate = simpleDateFormat.format(getCreationDate(file));
        System.out.println("Copy :"+file.getName()+"#"+ fileDate);

        try {
            Path sourcePath = getSourcePath(file);
            Path targetPath = prepareTargetPath(file, fileDate);
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch( IOException e) {
            e.printStackTrace();
        }
    }

    private Path getSourcePath(File file) {
       return Paths.get(file.toURI());
    }

    private Path prepareTargetPath(File file, String date) throws IOException {
        String dstntnFolder = destinationFolder + "/" + date;
        String dstntnFile = dstntnFolder + "/" + file.getName();
        URI targetURI = new File(dstntnFolder).toURI();
        Path folderPath = Paths.get(targetURI);
        if(Files.notExists(folderPath)) {
            Files.createDirectory(folderPath);
        }
        Path filePath = Paths.get(new File(dstntnFile).toURI());

        return filePath;
    }

    private Date getCreationDate(File file) {
        try {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            return Date.from(attr.lastModifiedTime().toInstant());
        } catch (IOException ex) {
            System.out.print(ex.getStackTrace());
            return null;
        }
    }
}
