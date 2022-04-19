package com.example.jogomatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gameOne(View view) {
        Intent it = new Intent(this, Aritimetica.class);
        startActivity(it);
    }

    public void gameTwo(View view) {
        Intent it = new Intent(this, MaiorValor.class);
        startActivity(it);
    }

}