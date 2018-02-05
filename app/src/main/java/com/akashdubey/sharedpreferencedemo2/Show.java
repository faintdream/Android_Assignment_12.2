package com.akashdubey.sharedpreferencedemo2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Show extends AppCompatActivity {
    TextView name,age,phone,city;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        name=(TextView)findViewById(R.id.nameET);
        age=(TextView)findViewById(R.id.ageET);
        city=(TextView)findViewById(R.id.cityET);
        phone=(TextView)findViewById(R.id.phoneET);
        name.setText(getIntent().getExtras().getString("name"));
        age.setText(getIntent().getExtras().getString("age"));
        city.setText(getIntent().getExtras().getString("city"));
        phone.setText(getIntent().getExtras().getString("phone"));
    }
}
