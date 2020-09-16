package com.chayan_27.webadv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.contents);
        final androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.about){
                    final AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setCancelable(true)
                            .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();

                                }
                            }).setMessage("An all in one social media app which supports over 12 original android apps and hence relieves the user from downloading each application separately thereby saving memory space and preventing distractions due to annoying notifications from them\n\nCreated By : Chayan Sharma");
                    AlertDialog alertDialog = alert.create();
                    alertDialog.setTitle("About The App");
                    alertDialog.show();



                    return true;
                }
                return false;
            }
        });

        int check= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int check2=ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (!(check == PackageManager.PERMISSION_GRANTED||check2==PackageManager.PERMISSION_GRANTED)){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 123);

        }
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
       /* List<Integer> list=new ArrayList<>();
        list.add(R.drawable.ic_google_icon);
        list.add(R.drawable.ic_instagram);
        list.add(R.drawable.ic_facebook);
        list.add(R.drawable.ic_telegram);
        list.add(R.drawable.ic_twitter);
        list.add(R.drawable.ic_linkedin);
        list.add(R.drawable.ic_youtube);
        list.add(R.drawable.ic_quora);
        list.add(R.drawable.ic_amazon_logo);
        list.add(R.drawable.ic_flipkart);
        list.add(R.drawable.ic_amazon_prime);
        list.add(R.drawable.ic_netflix_1);
*/

        List<String> list1=new ArrayList<>();
        list1.add("Google");
        list1.add("Instagram");
        list1.add("Facebook");
        list1.add("Telegram");
        list1.add("Twitter");
        list1.add("LinkedIn");
        list1.add("Youtube");
        list1.add("Quora");
        list1.add("Amazon");
        list1.add("Flipkart");
        list1.add("Prime");
        list1.add("Netflix");

        List<String> list2=new ArrayList<>();
        list2.add("https://www.google.com/images/branding/product_ios/3x/gsa_ios_60dp.png");
        list2.add("https://www.instagram.com/static/images/ico/favicon-192.png/68d99ba29cc8.png");
        list2.add("https://static.xx.fbcdn.net/rsrc.php/v3/ye/r/a36n03MSzp1.png");
        list2.add("https://web.telegram.org/img/iphone_home120.png");
        list2.add("https://abs.twimg.com/responsive-web/client-web-legacy/icon-ios.8ea219d5.png");
        list2.add("https://static-exp1.licdn.com/scds/common/u/images/logos/favicons/v1/favicon.ico");
        list2.add("https://s.ytimg.com/yts/mobile/img/apple-touch-icon-144x144-precomposed-vflopw1IA.png");
        list2.add("https://nl.quora.com/apple-touch-icon-precomposed.png");
        list2.add("https://www.amazon.com/favicon.ico");
        list2.add("https://img1a.flixcart.com/www/linchpin/batman-returns/images/logo_lite-cbb3574d.png");
        list2.add("https://m.media-amazon.com/images/G/01/digital/video/DVUI/favicons/apple-touch-icon-152x152._CB527404565_.png");
        list2.add("https://assets.nflxext.com/us/ffe/siteui/common/icons/nficon2016.png");


        List<String> urls=new ArrayList<>();

        urls.add("https://www.google.com/");
        urls.add("https://www.instagram.com/");
        urls.add("https://www.facebook.com/");
        urls.add("https://web.telegram.org/");
        urls.add("https://twitter.com/?lang=en");
        urls.add("https://in.linkedin.com/");
        urls.add("https://www.youtube.com/");
        urls.add("https://www.quora.com/");
        urls.add("https://www.amazon.in/ref=nav_logo");
        urls.add("https://www.flipkart.com/");
        urls.add("https://www.primevideo.com/");
        urls.add("https://www.netflix.com/");



        recyclerView.setAdapter(new RecycleAdap(list2,list1,urls,this));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED&&grantResults[1] == PackageManager.PERMISSION_GRANTED) {



            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 123);

            }
        }
    }
}