package com.production.jpsc.student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class Tech extends AppCompatActivity implements AsyncResponse {

    private ArrayList<Product> productList;
    private ListView lvProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PostResponseAsyncTask taskRead=new PostResponseAsyncTask(Tech.this,this);



        taskRead.execute("https://syllabkerala.in/s.php");

    }

    @Override
    public void processFinish(String s) {
        ImageLoader.getInstance().init(UILConfig.config(Tech.this));
        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

        BindDictionary<Product> dict=new BindDictionary<Product>();
        dict.addDynamicImageField(R.id.imagViewa, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.file;
            }
        }, new DynamicImageLoader() {
            @Override
            public void loadImage(String url, ImageView imageView) {

                ImageLoader.getInstance().displayImage(url, imageView);
                ImageLoader.getInstance().init(UILConfig.config(Tech.this));
            }

        });
        dict.addStringField(R.id.tvNam, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.name;
            }
        });
        FunDapter<Product> adapter=new FunDapter<>(Tech.this,productList,R.layout.web,dict);
        lvProduct= (ListView) findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        //lvProduct.setOnItemClickListener((AdapterView.OnItemClickListener) this);



    }
}
