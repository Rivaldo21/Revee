package com.example.webview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar bar;
    private BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.btn_navigation);

        webView = (WebView) findViewById(R.id.webView);
        bar = (ProgressBar) findViewById(R.id.progressBarStyle);
        webView.setWebViewClient(new myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://revee.site/");

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                         webView.loadUrl("https://revee.site/");
                         break;
                   case  R.id.Favorite:
                         webView.loadUrl("/*Tau link iha ne*/");
                        break;
                   case  R.id.Video:
                         webView.loadUrl("/*Tau link iha ne*/");
                         break;
                    case R.id.Profile:
                         webView.loadUrl("https://revee.site/?page_id=511");
                        break;

                }
                return true;
            }
        });

        final SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setColorSchemeColors(Color.BLUE);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "Atualiza fali", Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
            }
        });

    }

       private class myWebclient extends WebViewClient {
           @Override
           public void onPageStarted(WebView view, String url, Bitmap favicon) {
               super.onPageStarted(view, url, favicon);
           }
       }
//        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
          return shouldOverrideUrlLoading(view,url);
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}