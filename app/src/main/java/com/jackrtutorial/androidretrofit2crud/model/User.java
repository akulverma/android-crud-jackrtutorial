package com.jackrtutorial.androidretrofit2crud.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("Barcode")
    @Expose
    private int barcode;

    @SerializedName("Product Name")
    @Expose
    private String product_name;

    @SerializedName("Ingredients")
    @Expose
    private String ingredients;

    @SerializedName("Status")
    @Expose
    private int status;

    public User() {
    }

    public User(int barcode, String product_name, String ingredients, int status) {
        this.barcode = barcode;
        this.product_name = product_name;
        this.ingredients = ingredients;
        this.status = status;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}