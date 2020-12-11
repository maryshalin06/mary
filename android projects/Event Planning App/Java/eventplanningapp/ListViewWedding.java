package edu.udayton.eventplanningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ListviewWedding extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_listview_wedding);
        List<String> weddingTheme = Arrays.asList(getResources().getStringArray(R.array.themeWedding));
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_listview_wedding, R.id.weddingTheme, weddingTheme));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(ListviewWedding.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Fairy Tale Wedding ");
                intent.putExtra(event_description.DESC_KEY, " Fairy tale theme wedding is pretty much what every girl in their life would have imagined since their childhood. We here at Spurce will help you achieve that dreamy wedding of yours by arranging everything u need. All you have to do is just answer few questions for us to make the arrangements to make your wedding dream a reality !!");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.fairytaletheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require a wedding cake ? ");
                break;

            case 1:
                intent = new Intent(ListviewWedding.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Garden Theme Wedding ");
                intent.putExtra(event_description.DESC_KEY, " Are you a nature lover? We can make your special day happen in a place where you love to be at and enjoy. We make the decorations and arrangements needed be it in the middle of the forest or just as simple at your backyard. Just help us by answering few questions and we're good to go !");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.gardentheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require a wedding cake ? ");
                break;

            case 2:
                intent = new Intent(ListviewWedding.this, event_description.class);
                intent.putExtra(event_description.TITLE_KEY, "Beach Theme Wedding ");
                intent.putExtra(event_description.DESC_KEY, "Who doesn't like have a wedding in a breezy location? We sure do? We have variety of ideas in making this an ideal wedding theme for all of you. All you have to do is give us few details and you're good to go!");
                intent.putExtra(event_description.EVENT_KEY, Integer.toString(R.drawable.beachtheme));
                intent.putExtra(event_description.QSTN_KEY, "Do you require a wedding cake ? ");
                break;
                //use of extra intents to display list activity and go to event page

            default:
                Toast.makeText(ListviewWedding.this, "Invalid choice made", Toast.LENGTH_LONG).show();
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
