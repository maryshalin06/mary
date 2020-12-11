package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class event_description extends AppCompatActivity {

    public static final String TITLE_KEY = "KEY1";
    public static final String DESC_KEY = "KEY2";
    public static final String EVENT_KEY = "KEY3";
    public static final String QSTN_KEY = "KEY4";

    public int no_of_guests;
    public int no_of_volunteers;
    public int amount;

    EditText noOFGuests;
    Spinner volunteerSpinner;
    RadioGroup requirements;
    RadioButton radioButton;
    Button confirmBookingBtn;
    Button btnHomePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            String title = bundle.getString(TITLE_KEY);
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(title);

            String desc = bundle.getString(DESC_KEY);
            TextView descTextView = (TextView)findViewById(R.id.textView2);
            descTextView.setText(desc);

            String img = bundle.getString(EVENT_KEY);
            int image = Integer.parseInt(img);
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageResource(image);
            imageView.setContentDescription("event image");

            String qstn = bundle.getString(QSTN_KEY);
            TextView qstnTextView = (TextView)findViewById(R.id.textView7);
            qstnTextView.setText(qstn);

        }
                //Use of spinner for spinner container
        volunteerSpinner = (Spinner)findViewById(R.id.spinner);
        volunteerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                no_of_volunteers = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
                //Radio button group used for 'yes' or 'no' radio buttons
        requirements = (RadioGroup)findViewById(R.id.requirementRadioGroup);
                //onclick confirm button
        confirmBookingBtn = (Button)findViewById(R.id.button);
        confirmBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //calculate amt for each option selected
                noOFGuests = (EditText)findViewById(R.id.guest_txt);
                String guestNo = noOFGuests.getText().toString();
                no_of_guests = Integer.parseInt(guestNo);

                amount = no_of_guests * 10;
                if(no_of_volunteers == 2){
                    amount = amount + 100;
                }else if(no_of_volunteers == 5){
                    amount = amount + 250;
                }else {
                    amount = amount + 500;
                }

                int selectedId = requirements.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selectedId);
                String optedRequirement = radioButton.getText().toString();
                if(optedRequirement.equals("yes")){
                    amount = amount + 50;
                }
                Intent calIntent = new Intent(event_description.this, CalculatePage.class);
                calIntent.putExtra(CalculatePage.AMOUNT_KEY, Integer.toString(amount));
                startActivity(calIntent);
            }
        });

        btnHomePage = (Button)findViewById(R.id.btnHome);
        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(event_description.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

    }
}
