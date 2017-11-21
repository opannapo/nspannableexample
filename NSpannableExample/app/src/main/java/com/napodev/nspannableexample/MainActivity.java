package com.napodev.nspannableexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import lib.napodev.nspannable.ObjSpanCreator;
import lib.napodev.nspannable.SimpleSpanCreator;
import lib.napodev.nspannable.SpanClickListener;
import lib.napodev.nspannable.SpanObj;
import lib.napodev.nspannable.SpanStartWith;

public class MainActivity extends AppCompatActivity {

    private TextView tText, tText2, tText3;
    private TextView tTextLabel, tTextLabel2, tTextLabel3;

    private int color = Color.parseColor("#ff00ff");
    private int color2 = Color.parseColor("#FF08A0D7");

    private final String TEXT = "@opannapo start following @novita";
    private final String TEXT2 = "The heavy metal, Metallica will visit Jakarta on Augusts 25, 2013.";
    private final String TEXT3 = "#Google is working on a program to train 100,000 #Android developers in Indonesia. By unveiling multiple initiatives across #training partners and universities, Google is looking to make #world-class Android developer education accessible to all students and developers across #Indonesia.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tText = (TextView) findViewById(R.id.tText);
        tText2 = (TextView) findViewById(R.id.tText2);
        tText3 = (TextView) findViewById(R.id.tText3);
        tTextLabel = (TextView) findViewById(R.id.tTextLabel);
        tTextLabel2 = (TextView) findViewById(R.id.tTextLabel2);
        tTextLabel3 = (TextView) findViewById(R.id.tTextLabel3);

        Spannable s = new SimpleSpanCreator()
                .ofText(TEXT)
                .find("@opannapo", "@novita")
                .spandColor(color, color2)
                .setBold(true)
                .setItalic(false)
                .setSpanClickListener(tText, new SpanClickListener() {
                    @Override
                    public void clicked(String text) {
                        Log.d("CLICK", "link clicked " + text);
                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        tTextLabel.setText("Original :\n" + TEXT + "\n\nSpannable :");
        tText.setText(s);


        SpanObj obj1 = new SpanObj().find("Metallica").color(Color.RED).bold(true).italic(false);
        SpanObj obj2 = new SpanObj().find("Jakarta").color(Color.BLACK).bold(true).italic(true);
        SpanObj obj3 = new SpanObj().find("Augusts 25").color(Color.BLUE).bold(false).italic(true);
        Spannable s2 = new ObjSpanCreator()
                .ofText(TEXT2)
                .find(obj1, obj2, obj3)
                .setSpanClickListener(tText2, new SpanClickListener() {
                    @Override
                    public void clicked(String text) {
                        Log.d("CLICK", "link clicked " + text);
                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        tTextLabel2.setText("Original :\n" + TEXT2 + "\n\nSpannable :");
        tText2.setText(s2);


        Spannable s3 = new SpanStartWith()
                .ofText(TEXT3)
                .startWith("#")
                .spandColor(Color.parseColor("#14af9b"))
                .setBold(false)
                .setItalic(true)
                .setSpanClickListener(tText3, new SpanClickListener() {
                    @Override
                    public void clicked(String text) {
                        Log.d("CLICK", "link clicked " + text);
                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        tTextLabel3.setText("Original :\n" + TEXT3 + "\n\nSpannable :");
        tText3.setText(s3);
    }
}