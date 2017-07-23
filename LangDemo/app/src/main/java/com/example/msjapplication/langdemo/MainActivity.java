package com.example.msjapplication.langdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.eng){
            setLanguage("English");
        }else if (item.getItemId() == R.id.hin){
            setLanguage("Hindi");
        }
        return true;
    }

    public void setLanguage(String language){


        sharedPreferences.edit().putString("language" , language).apply();
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(language);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.example.msjapplication.langdemo" , Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , "");
        if(language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setTitle("CHOOSE LANGUAGE")
                    .setMessage("Which language would you like ?")
                    .setPositiveButton("ENGLISH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            setLanguage("ENGLISH");
                        }
                    })
                    .setNegativeButton("HINDI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            setLanguage("HINDI");
                        }
                    })
                    .show();
        }else{
            textView.setText(language);
        }
    }
}
