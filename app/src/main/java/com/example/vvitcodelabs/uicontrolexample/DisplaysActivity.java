package com.example.vvitcodelabs.uicontrolexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplaysActivity extends AppCompatActivity {
    TextView display_name, display_email, display_type, display_number;
    DBHelper helper;
    ImageView addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displays);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
       display_name = findViewById(R.id.id_display_name);
       display_email = findViewById(R.id.id_display_email);
       display_type = findViewById(R.id.id_display_type);
       display_number = findViewById(R.id.id_display_number);
       addContact = findViewById(R.id.newContactButton);

       addContact.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(DisplaysActivity.this,MainActivity.class);
               i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(i);
               finish();
           }
       });


       helper = new DBHelper(this, null, null, 0);

       Contact contact = helper.getData();

       if(contact != null) {
           display_name.setText(contact.getContact_name());
           display_number.setText(contact.getContact_name());
           display_type.setText(contact.getContact_type());
           display_email.setText(contact.getContact_email());
       }
    }
}
