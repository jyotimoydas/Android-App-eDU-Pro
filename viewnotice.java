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


public class viewnotice extends Activity implements View.OnClickListener {
    Button btnviewall;

    SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewnoticesql);

        btnviewall=(Button)findViewById(R.id.button813);

        db=openOrCreateDatabase("NotDB", Context.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS notice(Notice VARCHAR,date VARCHAR);");
    }   

    public void onClick(View view) {
        if(view==btnviewall)
        {
            Cursor c=db.rawQuery("SELECT * FROM notice", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();

            while(c.moveToNext())
            {

                buffer.append("Notice: "+c.getString(0)+"\n");

                buffer.append("date: "+c.getString(1)+"\n");

            }
            showMessage("NOTICE", buffer.toString());

        }

    }

    private void showMessage(String n, String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(n);

        builder.setMessage(s);

        builder.show();
    }
}