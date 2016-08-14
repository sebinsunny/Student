package com.production.jpsc.student;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebin on 13-03-2016.
 */
public class Product
{
    @SerializedName("sid")
    public int sid;

    @SerializedName("sem")
    public  String sem;
    @SerializedName("name")
    public  String name;
    @SerializedName("year")
    public  String year;
    @SerializedName("status")
    public  String status;
    @SerializedName("qty")
    public int qty;

    @SerializedName("price")
    public int price;
    @SerializedName("image_url")
    public String image_url;

    @SerializedName("subid")
    public int subid;


    @SerializedName("branch")
    public  String branch;

    @SerializedName("file")
    public String file;
}
