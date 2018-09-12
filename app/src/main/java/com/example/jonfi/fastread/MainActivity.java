package com.example.jonfi.fastread;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jonfi.fastread.server.FileLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mFileNames = new ArrayList<>();
    private ArrayList<File> mFileType = new ArrayList<>();
    private File dir= Environment.getExternalStorageDirectory();
    FileLoader fileLoader = new FileLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        //TODO: Scan for relevant files and add the to mFileType

    }
    
}
