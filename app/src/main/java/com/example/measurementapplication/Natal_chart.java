package com.example.measurementapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.nlf.calendar.Lunar;

public class Natal_chart extends AppCompatActivity {
    public static void actionActivity(Context context) {
        Intent intent = new Intent(context, Natal_chart.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acyivity_natal_chart);



    }
}
