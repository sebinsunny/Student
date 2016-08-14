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

public class Electrical extends AppCompatActivity implements AsyncResponse,AdapterView.OnItemClickListener{
    private ArrayList<Product> productList;
    private ListView lvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PostResponseAsyncTask taskRead=new PostResponseAsyncTask(Electrical.this,this);



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
        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList,R.layout.layout_list,dict);
        lvProduct= (ListView) findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ImageLoader.getInstance().init(UILConfig.config(Electrical.this));


        if(position==0){
          //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            ImageLoader.getInstance().init(UILConfig.config(Electrical.this));


                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/m6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

         if(position==1){
          //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==2){
          //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==3){
          //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==4){
          //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

 if(position==5){
          //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==6){
            //  ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm5.php");

                            }
                             if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Electrical.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Electrical.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Electrical.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/electrical/mmmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }
    }
}


