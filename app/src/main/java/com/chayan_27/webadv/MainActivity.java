package com.chayan_27.webadv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.contents);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        List<Integer> list=new ArrayList<>();
        list.add(R.drawable.ic_instagram);
        list.add(R.drawable.ic_facebook);
        list.add(R.drawable.ic_telegram);
        list.add(R.drawable.ic_twitter);
        list.add(R.drawable.ic_linkedin);
        list.add(R.drawable.ic_youtube);
        list.add(R.drawable.ic_medium);
        list.add(R.drawable.ic_amazon_logo);
        list.add(R.drawable.ic_flipkart);
        list.add(R.drawable.ic_amazon_prime);
        list.add(R.drawable.ic_netflix_1);

        List<String> list1=new ArrayList<>();
        list1.add("Instagram");
        list1.add("Facebook");
        list1.add("Telegram");
        list1.add("Twitter");
        list1.add("LinkedIn");
        list1.add("Youtube");
        list1.add("Medium");
        list1.add("Amazon");
        list1.add("Flipkart");
        list1.add("Prime");
        list1.add("Netflix");

        List<String> urls=new ArrayList<>();
        urls.add("https://www.instagram.com/");
        urls.add("https://www.facebook.com/");
        urls.add("https://web.telegram.org/");
        urls.add("https://twitter.com/?lang=en");
        urls.add("https://in.linkedin.com/");
        urls.add("https://www.youtube.com/");
        urls.add("https://medium.com/");
        urls.add("https://www.amazon.in/ref=nav_logo");
        urls.add("https://www.flipkart.com/");
        urls.add("https://www.primevideo.com/");
        urls.add("https://www.netflix.com/");

        recyclerView.setAdapter(new RecycleAdap(list,list1,urls,this));

    }
}