package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class theme_pg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_pg);

        LinearLayout weddingPartyLayout = (LinearLayout)findViewById(R.id.weddingPartyLinearLayout);
        weddingPartyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(theme_pg.this, ListviewWedding.class);
                startActivity(intent);
                //navigates to next page that has list Activity
            }
        });

        LinearLayout birthdayPartyLayout = (LinearLayout)findViewById(R.id.birthdayPartyLayout);
        birthdayPartyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(theme_pg.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Birthday Party ");
                intent.putExtra(event_description.DESC_KEY, " Birthday parties are special! Everyone wants to have the time of their lives when its their birthday. Why waste that day on not celebrating it just because you find it hard to put everything together and organize a party! We are here for you. Let us know your requirements and we will provide ypu the assistance you need in getting your party arranged. Go ahead and select what is required.");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.birthdaytheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require a birthday cake ? ");
                startActivity(intent);
                //Navigates to Event Description Page
            }
        });

        LinearLayout gradCeremonyLayout = (LinearLayout)findViewById(R.id.gradCeremonyLayout);
        gradCeremonyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(theme_pg.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Graduation Ceremony ");
                intent.putExtra(event_description.DESC_KEY, " Congrats !! You've done your parents and teachers proud. You should definitely celebrate to make this memorable. We have a team that would arrange the required decorations, facilities for guests and other requirements needed. What you should do? Just sit back and give us the required details and you're all set. As a gift we are getting food arranged as a complimentary for you. Yayy! ");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.gradtheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require a Champaign ? ");
                startActivity(intent);
            }
        });

        LinearLayout fundRaiserLayout = (LinearLayout)findViewById(R.id.fundRaiserLayout);
        fundRaiserLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(theme_pg.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Fund Raiser Event ");
                intent.putExtra(event_description.DESC_KEY, " Looking forward to hosting a fun raiser charity event. That's amazing and we're here for you to support your good deed. As an encouragement and appreciation to the work you're doing we will give you complimentary music system, mike and podium arranged with a proper stage setup to present your ideas to the crowd. Go ahead and give us few details by clicking these options.");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.fundraisertheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require food arranged ? ");
                startActivity(intent);
            }
        });

        LinearLayout halloweenEventLayout = (LinearLayout)findViewById(R.id.halloweenEventLayout);
        halloweenEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(theme_pg.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Halloween Event ");
                intent.putExtra(event_description.DESC_KEY, " It's that time of the year! YES!! It's Halloween y'all. Kids love to go to trick or treating and I bet you would love to host small party like a gathering for your friends and other kids at your home or at your backyard. We are here to help you arrange and setup. Get free candies on us.");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.halloweentheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require decorations arranged ? ");
                startActivity(intent);
            }
        });

        LinearLayout workshopLayout = (LinearLayout)findViewById(R.id.workshopLayout);
        workshopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(theme_pg.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Workshop/Seminar Events ");
                intent.putExtra(event_description.DESC_KEY, "We understand how important it is for an organisation that conducts workshops amd seminars for their students. We are here to help you with the arrangements you need to conduct a workshop. We will arrange free food for the people who attend these workshops. Go ahead and select the requirements to avail our services");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.workshoptheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require projector arranged ? ");
                startActivity(intent);
            }
        });
    }
}
