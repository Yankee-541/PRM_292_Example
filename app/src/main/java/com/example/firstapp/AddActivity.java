package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AddActivity extends AppCompatActivity {

    EditText title, author, pages, size;
    Button add_button, add_pic;
    Context context;
    LinearLayout list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        context = this;
//        title = findViewById(R.id.title_input);
//        author = findViewById(R.id.author_input);
        pages = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDDB = new MyDatabaseHelper(AddActivity.this);
                myDDB.addBook(title.getText().toString().trim(),
                        author.getText().toString().trim(),
                        Integer.valueOf(pages.getText().toString().trim()));
            }
        });


    }

    private void addView(){
        final View aa = getLayoutInflater().inflate(R.layout.add_cam, null, false);
        ImageView cross =(ImageView) aa.findViewById(R.id.cross2);
        cross.setVisibility(View.VISIBLE);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(aa);
            }
        });
        list.addView(aa);
    }

    private void removeView(View view){
        list.removeView(view);
    }

}