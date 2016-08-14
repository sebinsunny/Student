package com.production.jpsc.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Newsfeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






}

    public void result(View view) {
        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
    }

    public void tech(View view) {
        Intent intent = new Intent(this, Tech.class);
        startActivity(intent);
    }

    public void web(View view) {
        Intent intent = new Intent(this, Web.class);
        startActivity(intent);
    }


}