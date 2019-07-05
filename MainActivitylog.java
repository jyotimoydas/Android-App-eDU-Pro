package com.webtek.edupro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivitylog extends Activity {

    Dbase d=new Dbase(this);
    private EditText Username;
    private  EditText Password;
    private Button login;
    private Button students;
    private  Button teachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlog);

        Username=(EditText)findViewById(R.id.editText55);
        Password=(EditText)findViewById(R.id.password55);
        login=(Button)findViewById(R.id.button45);
        students=(Button)findViewById(R.id.button55);
        teachers=(Button)findViewById(R.id.button90);
        teachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(),Password.getText().toString());

            }
        });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivitylog.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });



        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivitylog.this,signup.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                User user=new User(MainActivitylog.this);
                String uname=Username.getText().toString();
                String pass=Password.getText().toString();
                User user1=new User(MainActivitylog.this);
                user1.setUsername(uname);
                user1.setPass(pass);
                if (Username.equals("") && Password.equals(""))
                {
                    Toast.makeText(MainActivitylog.this,"Blank Entry!Can't Log in",Toast.LENGTH_SHORT).show();
                }
                String password=d.searchpass(uname);

                if(pass.equals(password))

                {

                    Intent intent = new Intent(MainActivitylog.this, student.class);
                    startActivity(intent);


                }
                else {
                    Toast.makeText(MainActivitylog.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                }
                if(pass.equals("") )
                {
                    Toast.makeText(MainActivitylog.this, "You have not entered your password!", Toast.LENGTH_SHORT).show();
                }
                clearText();

            }
        });


    }

    public void clearText(){

        Username.setText("");
        Password.setText("");
    }

    public void validate(String username,String password)
    {
        if (username.equals("Kaushik" )&& password.equals("kaushik123") || username.equals("Ravinder") && password.equals("ravinder123")
                || username.equals("Nomi") && password.equals("nomi123") || username.equals("Sudipta") && password.equals("sudipta123"))
        {
            Intent intent = new Intent(MainActivitylog.this,teachers.class);
            startActivity(intent);
        }else
            if (username.equals("") && password.equals("")) {
                Toast.makeText(MainActivitylog.this, "Blank Entry!", Toast.LENGTH_LONG).show();
            }
            else {
        Toast.makeText(MainActivitylog.this, "You have entered wrong password", Toast.LENGTH_LONG).show();
    }}


}
