package com.example.zad10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {

    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private ImageView bookCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookTitleTextView = findViewById(R.id.book_detail_title);
        bookAuthorTextView = findViewById(R.id.book_detail_author);
        bookCover = findViewById(R.id.img_detail_cover);

        if (getIntent().getExtras() != null) {
            Picasso.with(getApplicationContext())
                    .load("http://covers.openlibrary.org/b/id/" + getIntent().getExtras().get(MainActivity.KEY_EXTRA_IMAGE) + "-L.jpg")
                    .placeholder(R.drawable.ic_baseline_book_24).into(bookCover);

            bookAuthorTextView.setText(String.valueOf(getIntent().getExtras().get(MainActivity.KEY_EXTRA_AUTHOR)));
            bookTitleTextView.setText(String.valueOf(getIntent().getExtras().get(MainActivity.KEY_EXTRA_TITLE)));
        }

    }
}