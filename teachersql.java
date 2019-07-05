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


public class teachersql extends Activity implements View.OnClickListener {
    EditText editRollno,editMarks;

    Button btnAdd,btnDelete,btnModify,btnView,btnViewAll;

    SQLiteDatabase db;
    @Override

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.teachersql);

        editRollno=(EditText)findViewById(R.id.editText112);

        editMarks=(EditText)findViewById(R.id.editText113);

        btnAdd=(Button)findViewById(R.id.button115);

        btnDelete=(Button)findViewById(R.id.button113);

        btnModify=(Button)findViewById(R.id.button116);

        btnView=(Button)findViewById(R.id.button114);

        btnViewAll=(Button)findViewById(R.id.button117);

        btnAdd.setOnClickListener(this);

        btnDelete.setOnClickListener(this);

        btnModify.setOnClickListener(this);

        btnView.setOnClickListener(this);

        btnViewAll.setOnClickListener(this);


        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,marks VARCHAR);");

    }

    public void onClick(View view)
    {
        if(view==btnAdd)
        {
            if(editRollno.getText().toString().trim().length()==0||
                    editMarks.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }

            db.execSQL("INSERT INTO student VALUES('"+editRollno.getText()+"','"+editMarks.getText()+ "');");
            showMessage("Success", "Record added");

            clearText();
        }
        if(view==btnDelete)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM student WHERE rollno='"+editRollno.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }
        if(view==btnModify)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }

            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'", null);
            if(c.moveToFirst())
            {

                db.execSQL("UPDATE student set marks='"+editMarks.getText()+"'WHERE rollno='"+editRollno.getText()+"'");
                // db.execSQL("UPDATE com.webtek.edupro.student SET name='"+editName.getText()+"'marks='"+editMarks.getText()+"' WHERE rollno='"+editRollno.getText()+"'");
                showMessage("Success", "Record Modified");
                return;
            }
            else
            {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }

        }
        if(view==btnView)
        {
            if(editRollno.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'", null);
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
        if(view==btnViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM student", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();

            while(c.moveToNext())
            {

                buffer.append("Rollno: "+c.getString(0)+"\n");

                buffer.append("Marks: "+c.getString(1)+"\n");

            }
            showMessage("CGPA Details", buffer.toString());

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


        editRollno.setText("");

        editMarks.setText("");

        editRollno.requestFocus();
    }
}