package com.production.jpsc.student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
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

public class Electronics extends AppCompatActivity implements AsyncResponse,AdapterView.OnItemClickListener{
    private ArrayList<Product> productList;
    private ListView lvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PostResponseAsyncTask taskRead=new PostResponseAsyncTask(Electronics.this,this);



        taskRead.execute("https://syllabkerala.in/data.php");
    }

    @Override
    public void processFinish(String s) {

        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

        BindDictionary<Product> dict=new BindDictionary<Product>();
        dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.sem;
            }
        });
        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList,R.layout.layout_list,dict);
        lvProduct= (ListView) findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ImageLoader.getInstance().init(UILConfig.config(Electronics.this));

       
        if(position==0){
          //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            ImageLoader.getInstance().init(UILConfig.config(Electronics.this));

                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/m6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

         if(position==1){
          //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==2){
          //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==3){
          //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==4){
          //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

 if(position==5){
          //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==6){
            //  ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict=new BindDictionary<Product>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.year;
                        }
                    });
                    FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm5.php");

                            }
                             if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electronics.this,new AsyncResponse() {
                                    @Override
                                    public void processFinish(String s) {
                                        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                                        BindDictionary<Product> dict=new BindDictionary<Product>();

                                        dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                                            @Override
                                            public String getStringValue(Product product, int position) {
                                                return product.file;
                                            }
                                        }, new DynamicImageLoader() {
                                            @Override
                                            public void loadImage(String url, ImageView imageView) {

                                                ImageLoader.getInstance().displayImage(url, imageView);
                                                ImageLoader.getInstance().init(UILConfig.config(Electronics.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electronics.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electronics/mmmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }
    }
}


