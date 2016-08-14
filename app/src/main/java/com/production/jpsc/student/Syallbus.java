package com.production.jpsc.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Syallbus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syallbus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void cs(View view) {
        Intent intent = new Intent(this, Scs.class);
        startActivity(intent);
    }
    public void me(View view) {
        Intent intent = new Intent(this, Smech.class);
        startActivity(intent);
    }

    public void civil(View view) {
        Intent intent = new Intent(this,Scivil.class);
        startActivity(intent);
    }
    public void ele(View view) {
        Intent intent = new Intent(this, Selec.class);
        startActivity(intent);
    }
    public void ec(View view) {
        Intent intent = new Intent(this, Sec.class);
        startActivity(intent);
    }

    public void cf(View view) {
        Intent intent = new Intent(this, Sit.class);
        startActivity(intent);
    }
}
