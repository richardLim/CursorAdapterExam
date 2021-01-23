package com.example.cursoradapterexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView photoListView = findViewById(R.id.photo_list);

        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");

        MyCursorAdapter adapter = new MyCursorAdapter(this, cursor);
        photoListView.setAdapter(adapter);
    }
}