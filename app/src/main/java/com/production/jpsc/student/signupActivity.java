package com.production.jpsc.student;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

/**
 * Created by Tony Davis on 02-03-2016.
 */
public class signupActivity extends Activity implements View.OnClickListener {

    EditText mfirstname;
    EditText msecondname;
    EditText msemester;
    EditText mdepartment;
    EditText madmno;
    EditText mcontactno;
    EditText adds;
    EditText memail;
    EditText mpassword;
    RadioButton mgenderm;
    RadioButton mgenderf;
    Button mRegisterbutton,s;
    String gender;
    String firstname, depart, secondname, semester, mb, admno, contactno, add, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        memail = (EditText) findViewById(R.id.emailid);
        mpassword = (EditText) findViewById(R.id.passwordid);
        mRegisterbutton = (Button) findViewById(R.id.registerid);

        s=(Button) findViewById(R.id.register);

        mRegisterbutton.setOnClickListener(this);
s.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v==mRegisterbutton){
            HashMap postData = new HashMap();
            String username = memail.getText().toString();
            String password = mpassword .getText().toString();
            postData.put("username", username);
            postData.put("password", password);
            PostResponseAsyncTask task1 = new PostResponseAsyncTask(signupActivity.this, postData, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    //     Log.d(LOG, s);
                    if (s.contains("")) {
                        Toast.makeText(signupActivity.this, "Registered", Toast.LENGTH_LONG).show();
                       // Intent in = new Intent(signupActivity.this, MainActivity.class);
                       // startActivity(in);

                    } else {
                        //Toast.makeText(signupActivity.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            });

            task1.execute("https://syllabkerala.in/regester.php");
        }




        if (v == s) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://syllabkerala.in/student.php"));
            startActivity(browserIntent);
        }


    }
}
