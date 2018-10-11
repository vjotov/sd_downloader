package com.jotov.sd;

import java.io.File;

public class Filewalker {
    private Filecopier copier;
    public Filewalker(Filecopier copier){
        this.copier = copier;
    }

    public void walk( String path ) {

        File root = new File( path );
        System.out.println(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                System.out.println( "Dir:" + f.getAbsoluteFile() );
                walk( f.getAbsolutePath() );
            }
            else {
                System.out.println( "File:" + f.getAbsoluteFile() );
                copier.copy(f);
            }
        }
    }
}
