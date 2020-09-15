package com.chayan_27.webadv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.IOException;

import im.delight.android.webview.AdvancedWebView;

public class WebAct extends AppCompatActivity implements AdvancedWebView.Listener {

    private AdvancedWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.close){
                    finish();
                    return true;
                }
                return false;
            }
        });

        Intent intent=getIntent();



        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.setMixedContentAllowed(true);
       /* mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                String s2=url.substring(url.indexOf(":")+1);

                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(s2));


                request.setMimeType(mimetype);


                String cookies = CookieManager.getInstance().getCookie(s2);


                request.addRequestHeader("cookie", cookies);


                request.addRequestHeader("User-Agent", userAgent);


                request.setDescription("Downloading file...");


                request.setTitle(URLUtil.guessFileName(s2, contentDisposition,
                        mimetype));


                request.allowScanningByMediaScanner();


                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(
                        Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(
                                s2, contentDisposition, mimetype));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File",
                        Toast.LENGTH_LONG).show();
            }
        });*/



        //mWebView.setDesktopMode(true);

        mWebView.setWebChromeClient(new ChromeClient());
        mWebView.loadUrl(intent.getStringExtra("url"));
        mWebView.setLongClickable(true);
    }


    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) { }

    @Override
    public void onPageFinished(String url) { }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) { }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
        /*try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }catch (Exception e){
            String s2=url.substring(url.indexOf(":")+1);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(s2));
            startActivity(i);
        }*/
        try {
            AdvancedWebView.handleDownload(this, url, suggestedFilename);
        }catch (Exception e){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getIntent().getStringExtra("url")));
            startActivity(i);
           // String s2=url.substring(url.indexOf(":")+1);
            //AdvancedWebView.handleDownload(this,, suggestedFilename);
           /* CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse("https://stackoverflow.com"));*/

        }

      /*  String s2=url.substring(url.indexOf(":")+1);
       *//* String s1= s2.substring(0,url.indexOf(":")+1);
        String s3=s1.substring(url.indexOf(":")+1);
        s3=s3.trim();*//*


        Log.d("URL",s2);
       AdvancedWebView.handleDownload(WebAct.this,s2, URLUtil.guessFileName(url, contentDisposition,
               mimeType)

       );*/
       /* Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(s2));
        startActivity(i);*/


    }

    @Override
    public void onExternalPageRequest(String url) { }


    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
    }


    @Override
    public int getRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    private class ChromeClient extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        ChromeClient() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.close,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.close){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/



}