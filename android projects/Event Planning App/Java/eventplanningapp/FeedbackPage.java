package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackPage extends AppCompatActivity {

    private EditText mailTo;
    private EditText mailSubject;
    private EditText mailContent;
    private Button subbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_page);

        mailTo = (EditText) findViewById(R.id.textTo);
        mailSubject = (EditText) findViewById(R.id.textSubject);
        mailContent = (EditText) findViewById(R.id.textMessage);
        subbtn = (Button) findViewById(R.id.buttonSend);
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        //Use implicit event to send email
                    Intent it = new Intent(Intent.ACTION_SEND);
                    it.putExtra(Intent.EXTRA_EMAIL, new String[]{mailTo.getText().toString()});
                    it.putExtra(Intent.EXTRA_SUBJECT, mailSubject.getText().toString());
                    it.putExtra(Intent.EXTRA_TEXT, mailContent.getText());
                    it.setType("message/rfc822");
                    startActivity(Intent.createChooser(it, "Choose Mail App"));

            }
        });
}
}
