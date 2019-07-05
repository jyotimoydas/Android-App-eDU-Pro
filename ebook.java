package com.webtek.edupro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ebook);

        ImageView imageView99 = (ImageView) findViewById(R.id.imageView99);
        Button button99 = (Button) findViewById(R.id.button99);
        button99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://iips.icci.edu.iq/images/exam/databases-ramaz.pdf"));
                startActivity(i);
            }
        });
        ImageView imageView92 = (ImageView) findViewById(R.id.imageView92);
        Button button92 = (Button) findViewById(R.id.button92);
        button92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cie-wc.edu/Microprocessor-7-19-2011.pdf?pdf=Microprocessor"));
                startActivity(i);
            }
        });
        ImageView imageView93 = (ImageView) findViewById(R.id.imageView93);
        Button button93 = (Button) findViewById(R.id.button93);
        button93.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cplusplus.com/files/tutorial.pdf"));
                startActivity(i);

            }
        });
        ImageView imageView94 = (ImageView) findViewById(R.id.imageView94);
        Button button94 = (Button) findViewById(R.id.button94);
        button94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://userspages.uob.edu.bh/mangoud/mohab/Courses_files/ssbook_204.pdf"));
                startActivity(i);

            }
        });
    }}