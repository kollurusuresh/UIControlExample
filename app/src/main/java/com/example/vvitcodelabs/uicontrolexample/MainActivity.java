package com.example.vvitcodelabs.uicontrolexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText contact_name, contact_email;
    EditText contact_number;
    Spinner contact_type;
    Button save;
    AlertDialog.Builder alert;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact_name=findViewById(R.id.id_contact_name);
        contact_type=findViewById(R.id.id_contact_type);
        contact_number=findViewById(R.id.id_contact_number);
        contact_email=findViewById(R.id.id_contact_email);
        save=findViewById(R.id.id_save);
        helper = new DBHelper(this, null, null, 0);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert=new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Save Contact");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contact contact = new Contact();
                        contact.setContact_name(contact_name.getText().toString());
                        contact.setContact_number((contact_number.getText().toString()));
                        contact.setContact_email(contact_email.getText().toString());
                        contact.setContact_type(contact_type.getSelectedItem().toString());
                        helper.storeDate(contact);
                        Toast.makeText(getApplicationContext(),"Contact Saved", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity.this,DisplaysActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
            }
        });
    }
}
