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


public class noticesql extends Activity implements View.OnClickListener {
    EditText editNotice,editdate;
    Button btnnotice,btnDELETE;

    SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.noticesql);

        editNotice=(EditText)findViewById(R.id.editText5);
        editdate=(EditText)findViewById(R.id.editText7);

        btnnotice=(Button)findViewById(R.id.button25);

        btnDELETE.setOnClickListener(this);

        db=openOrCreateDatabase("NotDB", Context.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS notice(Notice VARCHAR,date VARCHAR);");
    }

    public void onClick(View view) {

        if (view == btnnotice) {

            if (editdate.getText().toString().trim().length() == 0 ||

                    editNotice.getText().toString().trim().length() == 0) {

                showMessage("Error", "Please enter all values");


                return;

            }

            db.execSQL("INSERT INTO com.webtek.edupro.notice VALUES('" + editdate.getText() + "','" + editNotice.getText() +
                    "');");
            showMessage("Success", "Record added");

            clearText();
        }
        if(view==btnDELETE)
        {
            if(editdate.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM com.webtek.edupro.notice WHERE rollno='"+editdate.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM com.webtek.edupro.notice WHERE rollno='"+editdate.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }
    }
    private void showMessage(String error, String s)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(error);

        builder.setMessage(s);

        builder.show();

    }

    private void clearText() {


        editdate.setText("");

        editNotice.setText("");

        editdate.requestFocus();
    }
}