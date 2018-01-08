package com.example.dqtech.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText lemail,lpswd;
    Button llogin;
    Button signup;

    DbHelper helper=new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail= (EditText) findViewById(R.id.luser);
        lpswd= (EditText) findViewById(R.id.lpswd);
        signup= (Button) findViewById(R.id.sbutton);

        llogin= (Button) findViewById(R.id.llogin);
        llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l=lemail.getText().toString();
                String o=lpswd.getText().toString();
               String pass=helper.searc(l);
                if (pass.equals(o)){
                    Intent intent=new Intent(Login.this,Home.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "password not matched", Toast.LENGTH_SHORT).show();
                }


            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);

            }
        });
    }
}
