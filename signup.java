package com.webtek.edupro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class signup extends Activity {
    Dbase myDb;
    EditText username, password, rollno, branch, phone;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        myDb = new Dbase(this);

        username = (EditText) findViewById(R.id.editText72);
        password = (EditText) findViewById(R.id.editText73);
        rollno = (EditText) findViewById(R.id.editText74);
        branch = (EditText) findViewById(R.id.editText75);
        phone = (EditText) findViewById(R.id.editText76);
        register = (Button) findViewById(R.id.button73);
        AddData();
    }


    public void AddData() {
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(username.getText().toString(), rollno.getText().toString(),
                                password.getText().toString(), branch.getText().toString(), phone.getText().toString());
                        if (isInserted == true)
                        {       Toast.makeText(signup.this, "Succesfully signed up! Login now!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(signup.this, MainActivitylog    .class));
                    }
                        else
                            Toast.makeText(signup.this, "Sign Up Failed !", Toast.LENGTH_LONG).show();


                    }
                }
        );
    }
}





