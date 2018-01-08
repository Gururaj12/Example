package com.example.dqtech.example;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText name,email,username,password,confirmpassword;
    Button signup;
    DbHelper helper=new DbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        confirmpassword= (EditText) findViewById(R.id.cnfpassword);
        signup= (Button) findViewById(R.id.lbutton);




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1=name.getText().toString();
                String useremail=email.getText().toString();
                String uusername=username.getText().toString();
                String userpassword=password.getText().toString();
                String usercpassword=confirmpassword.getText().toString();

                if (!userpassword.equals(usercpassword)){
                    Toast.makeText(Signup.this, "password not matched", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(Signup.this, "matched", Toast.LENGTH_SHORT).show();
                    Contacts contacts=new Contacts();
                    contacts.setName(username1);
                    contacts.setEmail(useremail);
                    contacts.setUsername(uusername);
                    contacts.setPassword(userpassword);
                    helper.insertdata(contacts);

                }



            }
        });



    }
}
