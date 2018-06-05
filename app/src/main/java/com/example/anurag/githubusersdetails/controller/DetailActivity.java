package com.example.anurag.githubusersdetails.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.anurag.githubusersdetails.GlideCircleTransformation;
import com.example.anurag.githubusersdetails.R;

public class DetailActivity extends AppCompatActivity {
    private TextView Link;
    private TextView Username;
    private TextView Followers;
    private TextView Repositories;
    private Toolbar myToolbar;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.user_image_header);
        Username = findViewById(R.id.username);
        Followers = findViewById(R.id.flink);
        Repositories = findViewById(R.id.rlink);
        Link = findViewById(R.id.link);

        String username = getIntent().getExtras().getString("login");
        String avatar_url = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");
        String followers = getIntent().getExtras().getString("followers_url");
        String repos = getIntent().getExtras().getString("repos_url");

        Link.setText(link);
        Linkify.addLinks(Link,Linkify.WEB_URLS);

        Followers.setText(followers);
        Linkify.addLinks(Followers,Linkify.WEB_URLS);

        Repositories.setText(repos);
        Linkify.addLinks(Repositories,Linkify.WEB_URLS);

        Username.setText(username);
        Glide.with(this)
                .load(avatar_url)
                .placeholder(R.drawable.load)
                .bitmapTransform(new GlideCircleTransformation(this))
                .into(imageView);

        getSupportActionBar().setTitle("Details Activity");


    }
    private Intent createShareForecastIntent(){
        String username = getIntent().getExtras().getString("login");
        String link = getIntent().getExtras().getString("link");
        String followers = getIntent().getExtras().getString("followerLink");
        String repolink = getIntent().getExtras().getString("repoLink");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome github users @"+username+", "+link +"with repo"
                        + repolink+"and followers "+followers)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.detail,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForecastIntent());
        return true;
    }
}
