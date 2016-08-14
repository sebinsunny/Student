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

public class Sit extends AppCompatActivity implements AsyncResponse, AdapterView.OnItemClickListener {

    private ArrayList<Product> productList;
    private ListView lvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PostResponseAsyncTask taskRead = new PostResponseAsyncTask(Sit.this, this);


        taskRead.execute("https://syllabkerala.in/data.php");
    }

    @Override
    public void processFinish(String s) {

        productList = new JsonConverter<Product>().toArrayList(s, Product.class);

        BindDictionary<Product> dict = new BindDictionary<Product>();
        dict.addStringField(R.id.tvName, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.sem;
            }
        });
        FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_list, dict);
        lvProduct = (ListView) findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int arg2, long id) {
        ImageLoader.getInstance().init(UILConfig.config(Sit.this));
        if (arg2 == 0) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m0.php");

        }
        if (arg2 == 1) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m1.php");

        }
        if (arg2 == 2) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m2.php");

        }
        if (arg2 == 3) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m3.php");

        }
        if (arg2 == 4) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m4.php");

        }
        if (arg2 == 5) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m5.php");

        }
        if (arg2 == 6) {
            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
            PostResponseAsyncTask task2 = new PostResponseAsyncTask(Sit.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    productList = new JsonConverter<Product>().toArrayList(s, Product.class);

                    BindDictionary<Product> dict = new BindDictionary<Product>();

                    dict.addDynamicImageField(R.id.imageViewa, new StringExtractor<Product>() {
                        @Override
                        public String getStringValue(Product product, int position) {
                            return product.file;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String url, ImageView imageView) {

                            ImageLoader.getInstance().displayImage(url, imageView);
                            ImageLoader.getInstance().init(UILConfig.config(Sit.this));
                        }

                    });

                    FunDapter<Product> adapter = new FunDapter<>(Sit.this, productList, R.layout.layout_listes, dict);
                    lvProduct = (ListView) findViewById(R.id.lvProduct);
                    lvProduct.setAdapter(adapter);


                }
            });

            task2.execute("https://syllabkerala.in/sit/m6.php");

        }


    }
}







