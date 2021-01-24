package com.example.cursoradapterexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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

        photoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Cursor cursor = (Cursor)parent.getAdapter().getItem(position);
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));

                Toast.makeText(MainActivity.this, "사진 경로 : " + path, Toast.LENGTH_SHORT).show();

/*                cursor.moveToPosition(position);
                position*/
            }

        });
    }
}