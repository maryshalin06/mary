package edu.udayton.splitthebillapp;

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
        Button btnBill = (Button)findViewById(R.id.btnBill);
        View.OnClickListener btnBillListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent billIntent = new Intent(MainActivity.this, Calculate.class);
                startActivity(billIntent);
            }
        };
                btnBill.setOnClickListener(btnBillListener);
    }
}
