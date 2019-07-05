package com.webtek.edupro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;



public class aboutus extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        ImageView imageView1=(ImageView)findViewById(R.id.imageView2);
        ImageView imageView2=(ImageView)findViewById(R.id.imageView3);
        ImageView imageView3=(ImageView)findViewById(R.id.imageView4);
        TextView textView=(TextView)findViewById(R.id.textView2);
        TextView textView1=(TextView)findViewById(R.id.textView3);
        TextView textView2=(TextView)findViewById(R.id.textView4);
        TextView textView3=(TextView)findViewById(R.id.textView5);
        TextView textView4=(TextView)findViewById(R.id.textView6);

        final RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar2);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutus.this, MainActivity.class);
                startActivity(i);
                String rating=String.valueOf((ratingBar.getRating()));
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}
