package com.production.jpsc.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class log extends AppCompatActivity implements View.OnClickListener{


    protected EditText memail;
    protected EditText mpassword;
    protected Button mloginbutton;
    protected TextView mSignUpTextView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);

        memail = (EditText) findViewById(R.id.usernamefield);
        mpassword = (EditText) findViewById(R.id.passwordfield);
        mSignUpTextView = (TextView) findViewById(R.id.signuplabel);




        mloginbutton = (Button) findViewById(R.id.button);

        mSignUpTextView.setOnClickListener(this);

        mloginbutton.setOnClickListener(this);

    }


    public void onClick(View v) {
        if(v==mloginbutton) {


                HashMap postData = new HashMap();
                String username = memail.getText().toString();
                String password = mpassword .getText().toString();
                postData.put("tusername", username);
                postData.put("tpassword", password);
                PostResponseAsyncTask task1 = new PostResponseAsyncTask(log.this, postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        //     Log.d(LOG, s);
                        if (s.contains("")) {
                            Toast.makeText(log.this, "successfully login", Toast.LENGTH_LONG).show();
                            Intent in = new Intent(log.this, Chat.class);
                            startActivity(in);

                        } else {
                            Toast.makeText(log.this, "try again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                task1.execute("https://syllabkerala.in/can.php");


        }
        if(v==mSignUpTextView){

                startActivity(new Intent(this,signupActivity.class));





            }




        }





















































public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }



}
