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

public class Computer extends AppCompatActivity implements AsyncResponse,AdapterView.OnItemClickListener{
    private ArrayList<Product> productList;
    private ListView lvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PostResponseAsyncTask taskRead=new PostResponseAsyncTask(Computer.this,this);



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
        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList,R.layout.layout_list,dict);
        lvProduct= (ListView) findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ImageLoader.getInstance().init(UILConfig.config(Computer.this));


      
        if(position==0){
          //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            ImageLoader.getInstance().init(UILConfig.config(Computer.this));


                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/m6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

         if(position==1){
          //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==2){
          //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==3){
          //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==4){
          //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

 if(position==5){
          //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==6){
            //  ImageLoader.getInstance().init(UILConfig.config(Computer.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm5.php");

                            }
                             if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Computer.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Computer.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Computer.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/computer/mmmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }
    }
}


