package com.jackrtutorial.androidretrofit2crud.remote;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http:chemifinder.com/?search=egg&btn=";

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }

}