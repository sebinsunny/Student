package com.production.jpsc.student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Product> productList;
    private ListView lvProduct;
    protected EditText memail;
    protected EditText mpassword;
    protected Button mloginbutton;
    protected TextView mSignUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        memail = (EditText) findViewById(R.id.usernam);
       // mpassword = (EditText) findViewById(R.id.passwordfield);
      //  mSignUpTextView = (TextView) findViewById(R.id.signuplabel);


        mloginbutton = (Button) findViewById(R.id.buttonc);

       // mSignUpTextView.setOnClickListener(this);

        mloginbutton.setOnClickListener(this);
        ImageLoader.getInstance().init(UILConfig.config(Search.this));
    }


    public void onClick(View v) {
        if (v == mloginbutton) {


                        ImageLoader.getInstance().init(UILConfig.config(Search.this));
                        PostResponseAsyncTask task2 = new PostResponseAsyncTask(Search.this,new AsyncResponse() {
                            @Override
                            public void processFinish(String s) {
                                productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                BindDictionary<Product> dict=new BindDictionary<Product>();

                                dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                    @Override
                                    public String getStringValue(Product product, int position) {
                                        return product.image_url;
                                    }
                                }, new DynamicImageLoader() {
                                    @Override
                                    public void loadImage(String url, ImageView imageView) {

                                        ImageLoader.getInstance().displayImage(url, imageView);
                                        ImageLoader.getInstance().init(UILConfig.config(Search.this));
                                    }

                                });

                                FunDapter<Product> adapter=new FunDapter<>(Search.this,productList,R.layout.layout_listes,dict);
                                lvProduct= (ListView) findViewById(R.id.lvProduct);
                                lvProduct.setAdapter(adapter);









                            }});

                        task2.execute("http://www.sebinsunny.com/CC/product.php");


        }
    }
}
