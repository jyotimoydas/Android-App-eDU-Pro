package com.webtek.edupro;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.webtek.edupro.R;


public class student extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Button button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dibru.online/fee_payment/student/auth/login"));
                startActivity(i);
            }
        });
        Button button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/ServiceLogin/signinchooser?service=classroom&passive=1209600&continue=https%3A%2F%2Fclassroom.google.com%2F%3Femr%3D0&followup=https%3A%2F%2Fclassroom.google.com%2F%3Femr%3D0&flowName=GlifWebSignIn&flowEntry=ServiceLogin\""));
                startActivity(i);
            }
        });

       Button button23=(Button)findViewById(R.id.button23);
       button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new User(student.this).removeuser();
                Intent intent=new Intent(student.this,MainActivitylog.class);
                startActivity(intent);
                finish();
            }
        });
        final TextView textView=(TextView)findViewById(R.id.textView11);
        final TextView textView1=(TextView)findViewById(R.id.textView21);
       Button butt=(Button)findViewById(R.id.button20);
       butt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences sharedpref=getSharedPreferences("student_view",MODE_PRIVATE);
               String name=sharedpref.getString("username","");
               String pw=sharedpref.getString("password","");
               textView.setText(name+" ");
               textView1.setText(pw+" ");

           }
       });
    }
}
