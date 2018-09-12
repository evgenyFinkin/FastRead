package com.example.jonfi.fastread.server;
import com.example.jonfi.fastread.Utils.FileExtension;

import java.io.File;

public class FileLoader {

    private File dir;

    public void setDir(File dir) {
        this.dir = dir;
    }
    private FileExtension fileExtension = new FileExtension();


    private File Search_Dir(File dir)   {
        File[] fileList = dir.listFiles();
        if(fileList != null)    {
            for(File file : fileList)   {
                if(file.isDirectory())  {
                    Search_Dir(file);
                }
                switch (fileExtension.getExtension(dir))    {
                    case ".pdf":
                        return dir;
                    case ".doc":
                        return dir;
                }
            }
        }
        return dir;
    }

}
