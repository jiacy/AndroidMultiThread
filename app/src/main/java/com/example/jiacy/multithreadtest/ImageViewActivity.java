package com.example.jiacy.multithreadtest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;


public class ImageViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.image_view);

        Button bt1 = (Button) findViewById(R.id.update_image);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView iv = (ImageView) findViewById(R.id.my_image_view);
                Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").into(iv);
//                Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
//                SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
//                draweeView.setImageURI(uri);
            }
        });
    }
}
