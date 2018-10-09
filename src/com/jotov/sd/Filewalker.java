package com.jotov.sd;

import java.io.File;

public class Filewalker {
    private Filemover mover;
    public Filewalker(Filemover mover){
        this.mover = mover;
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
                mover.move(f);
            }
        }
    }
}
