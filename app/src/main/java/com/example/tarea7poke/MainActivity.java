package com.example.tarea7poke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.prefs = this.getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        String username = this.prefs.getString("username", "");

        //Comprobar si las shared preferences contienen un usuario
        if (TextUtils.isEmpty(username)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, PokedexActivity.class);
            startActivity(intent);
        }
    }
}