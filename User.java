package com.webtek.edupro;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HP on 22-01-2018.
 */

public class User {
    private String username,pass;
    private  Context context;
    SharedPreferences sharedPreferences;

    public  User(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("student_view",context.MODE_PRIVATE);
    }

    public String getUsername() {
        username=sharedPreferences.getString("username","");
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
        sharedPreferences.edit().putString("username",username).commit();
    }

    public String getPass() {
        pass=sharedPreferences.getString("pass","");
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        sharedPreferences.edit().putString("password",pass).commit();
    }
    public void removeuser()
    {
        sharedPreferences.edit().clear().commit();
    }


}