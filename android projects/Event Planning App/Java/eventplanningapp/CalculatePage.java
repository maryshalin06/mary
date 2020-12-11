package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatePage extends AppCompatActivity {
    public static final String AMOUNT_KEY = "AMOUNT";
    public String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_page);
                    //Button for sending email
        Button btnEmail = (Button)findViewById(R.id.btnEmail);

        View.OnClickListener btnMailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(CalculatePage.this, FeedbackPage.class);
                startActivity(mailIntent);
            }
        };

        Intent myIntent = getIntent();
        Bundle myExtras = myIntent.getExtras();
                //display total amount
        if(myExtras != null){
            amount = myExtras.getString(AMOUNT_KEY);
            TextView bookingAmountView = (TextView)findViewById(R.id.textView10);
            String comment = "Thank you for the Reservation! Your Booking has been confirmed. Your total amount is $" + amount  + ".You can pay on the day of service.";
            bookingAmountView.setText(comment);
        }
        btnEmail.setOnClickListener(btnMailListener);
    }
}
