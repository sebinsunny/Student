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

public class Information extends AppCompatActivity implements AsyncResponse,AdapterView.OnItemClickListener{
    private ArrayList<Product> productList;
    private ListView lvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PostResponseAsyncTask taskRead=new PostResponseAsyncTask(Information.this,this);



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
        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
        lvProduct= (ListView) findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        if(position==0){
          //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            ImageLoader.getInstance().init(UILConfig.config(Information.this));

                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/m6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

         if(position==1){
          //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==2){
          //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==3){
          //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==4){
          //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }

 if(position==5){
          //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm5.php");

                            }
                            if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }


        if(position==6){
            //  ImageLoader.getInstance().init(UILConfig.config(Information.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                    FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_list,dict);
                    lvProduct= (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);
                    lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                            if(arg2==0){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm0.php");

                            }
                            if(arg2==1){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm1.php");

                            }
                            if(arg2==2){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm2.php");

                            }
                            if(arg2==3){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm3.php");

                            }
                            if(arg2==4){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm4.php");

                            }
                            if(arg2==5){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm5.php");

                            }
                             if(arg2==6){
                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                PostResponseAsyncTask task2 = new PostResponseAsyncTask(Information.this,new AsyncResponse() {
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
                                                ImageLoader.getInstance().init(UILConfig.config(Information.this));
                                            }

                                        });

                                        FunDapter<Product> adapter=new FunDapter<>(Information.this,productList, R.layout.layout_listes,dict);
                                        lvProduct= (ListView) findViewById(R.id.lvProduct);
                                        lvProduct.setAdapter(adapter);









                                    }});

                                task2.execute("https://syllabkerala.in/it/mmmmmmm6.php");

                            }
                        }
                    });









                }});

            task2.execute("https://syllabkerala.in/year.php");



        }
    }
}




