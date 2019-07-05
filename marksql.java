package com.webtek.edupro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class marksql extends Activity implements View.OnClickListener {
    EditText editRollno,editMarks;

    Button btnView;

    SQLiteDatabase db;
    @Override

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.teachersql);

        editRollno=(EditText)findViewById(R.id.editText300);

        editMarks=(EditText)findViewById(R.id.editText304);

        btnView=(Button)findViewById(R.id.button324);

        btnView.setOnClickListener(this);

        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,marks VARCHAR);");

    }
    public void onClick(View view)
    {
        if(view==btnView)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE Rollno='"+editRollno.getText()+"'", null);
            if(c.moveToFirst())
            {
                editMarks.setText(c.getString(1));

            }
            else
            {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }
        }
    }

    private void clearText() {
        editRollno.setText("");

        editMarks.setText("");

        editRollno.requestFocus();
    }


    private void showMessage(String error, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(error);

        builder.setMessage(s);

        builder.show();

        }
    }