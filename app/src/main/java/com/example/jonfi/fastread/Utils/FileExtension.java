package com.example.jonfi.fastread.Utils;

import java.io.File;

public class FileExtension {
    public String getExtension(File file) {
            return String.valueOf(file.getName().lastIndexOf('.'));
    }
}
