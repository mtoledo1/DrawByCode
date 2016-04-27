package com.example.mrb.drawbycode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class DrawByCode extends AppCompatActivity {

    DrawingArea drawBox; // All we see here is a typical widget-type definition. The custom class
                         //   for DrawingArea handles all of the drawing details.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_by_code);

        drawBox = (DrawingArea) findViewById(R.id.drawBox); // Just like adding a widget.

    }
}
