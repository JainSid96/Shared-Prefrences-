package com.example.msjapplication.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.StringSearch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.msjapplication.sharedprefrences" , Context.MODE_PRIVATE);
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Sid");
        friends.add("Arpit");
        try {
            sharedPreferences.edit().putString("friends" , ObjectSerializer.serialize(friends)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> newFriends = new ArrayList<>();
        try {

            newFriends = (ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("friends" , ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //sharedPreferences.edit().putString("Username" , "Siddhant").apply();
        //String username = sharedPreferences.getString("Username" , "");
        Toast.makeText(this , "newFriends : " + newFriends.toString() , Toast.LENGTH_SHORT).show();


    }
}
