package com.example.jonfi.fastread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonfi.fastread.Utils.FileExtension;

import java.io.File;
import java.util.ArrayList;


class DisplayFilesAdapter extends RecyclerView.Adapter<DisplayFilesAdapter.DisplayFilesViewHolder> {

    private static final String TAG = "DisplayFilesAdapter";

    private Context mContext;
    private ArrayList<String> mFileNames = new ArrayList<>();
    private ArrayList<File> mFileType = new ArrayList<>();
    private FileExtension fileExtension = new FileExtension();

    public DisplayFilesAdapter(Context mContext, ArrayList<String> mFileNames, ArrayList<File> mFileType) {

        this.mContext = mContext;
        this.mFileNames = mFileNames;
        this.mFileType = mFileType;
    }

    public DisplayFilesAdapter(ArrayList<String> mFileNameList, Context mContext) {

    }

    @NonNull
    @Override
    public DisplayFilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_display_files, parent, false);
        DisplayFilesViewHolder displayFilesViewHolder = new DisplayFilesViewHolder(view);
        return displayFilesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayFilesViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called for ." + mFileNames.toString());

        holder.fileName.setText(mFileNames.get(position));
        holder.fileImage.setImageBitmap(loadBitmapIcon(mFileType.get(position)));
        holder.itemDisplayFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: on " + mFileNames.toString());
                //TODO(1): Add a way to turn files into "fastread" format
                //TODO(2): Check whether the file is available and if you have not sent an appropriate message.
                Toast.makeText(mContext,"Clicked on " + mFileNames.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private Bitmap loadBitmapIcon(File file) {
        Bitmap bitmap;
        switch (fileExtension.getExtension(file))    {
            case ".pdf":
                bitmap = BitmapFactory.decodeFile("drawable://" + R.drawable.pdf);
                return bitmap;
            case ".doc":
                bitmap = BitmapFactory.decodeFile("drawable://" + R.drawable.doc);
                return bitmap;
            default:
                bitmap = BitmapFactory.decodeFile("drawable://" + R.drawable.ic_folder_black);
                return bitmap;
        }
    }

    @Override
    public int getItemCount() {
        return mFileNames.size();
    }

    public class DisplayFilesViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout itemDisplayFiles;
        ImageView fileImage;
        TextView fileName;

        public DisplayFilesViewHolder(View itemView) {
            super(itemView);

            itemDisplayFiles = itemView.findViewById(R.id.itemDisplayFiles);
            fileImage = itemView.findViewById(R.id.fileImage);
            fileName = itemView.findViewById(R.id.fileName);
        }
    }

}
