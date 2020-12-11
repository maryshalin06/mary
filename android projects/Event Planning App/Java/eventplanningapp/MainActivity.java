package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This button on Clicking will take you to the next page
        Button btn1 = (Button)findViewById(R.id.btn1);

        View.OnClickListener btn1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aboutIntent = new Intent(MainActivity.this, appPage.class);

                startActivity(aboutIntent);
                    //using intent to start another activity

            }
        };

        btn1.setOnClickListener(btn1Listener);
    }
}

import android.view.View;
import android.widget.Button;

public class appPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_page);
        //this button on clicking will take you to next page
        Button btn2 = (Button)findViewById(R.id.btn2);

        View.OnClickListener btn2Listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent loginIntent = new Intent(appPage.this, theme_pg.class);
                startActivity(loginIntent);
                //using intent to start next activity
            }

        };

        btn2.setOnClickListener(btn2Listener);
    }
}
