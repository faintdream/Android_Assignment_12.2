package com.akashdubey.sharedpreferencedemo2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button show,save;
    TextView  name,age,phone,city;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=(Button)findViewById(R.id.showBtn);
        save=(Button)findViewById(R.id.btnSave);
        name=(TextView)findViewById(R.id.nameET);
        age=(TextView)findViewById(R.id.ageET);
        city=(TextView)findViewById(R.id.cityET);
        phone=(TextView)findViewById(R.id.phoneET);
        sharedPreferences=getPreferences(MODE_PRIVATE);
        editor=sharedPreferences.edit();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,Show.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",sharedPreferences.getString("name","NA").toString());
                bundle.putString("age",sharedPreferences.getString("age","NA").toString());
                bundle.putString("city",sharedPreferences.getString("city","NA").toString());
                bundle.putString("phone",sharedPreferences.getString("phone","NA").toString());
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences=getPreferences(MODE_PRIVATE);
                editor=sharedPreferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("age",age.getText().toString());
                editor.putString("city",city.getText().toString());
                editor.putString("phone",phone.getText().toString());
                editor.commit();
            }
        });
    }
}
