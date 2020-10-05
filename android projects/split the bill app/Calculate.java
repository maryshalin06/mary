package edu.udayton.splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculate extends AppCompatActivity {
        private double billAmt;
        private int numPeople;
        private double calAmt;
        private String txtOptions;
        private double tip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        final Button btnCalSplit = (Button)findViewById(R.id.btnCalSplit);

        assert btnCalSplit != null;

        View.OnClickListener btnCalSplitListener = new View.OnClickListener()
        {
            final EditText numEditText = (EditText)findViewById(R.id.numTxtEdit);
            final EditText billAmtEditText = (EditText)findViewById(R.id.billAmtEditText);
            final Spinner optionSpinner = (Spinner)findViewById(R.id.optionSpinner);
            final TextView txtResult = (TextView)findViewById(R.id.txtResult);

            @Override
            public void onClick(View v) {
                Editable Input = numEditText.getText();
                String InputAsString = Input.toString();
                Editable In = billAmtEditText.getText();
                String InAsString = In.toString();

                try {
                    billAmt = Double.parseDouble(InAsString);
                    numPeople = Integer.parseInt(InputAsString);
                  //  calAmt = billAmt/numPeople;

                    txtOptions = optionSpinner.getSelectedItem().toString();

                    if(txtOptions.equals("Excellent"))
                    {
                        tip = 0.20 * billAmt;

                    }else if(txtOptions.equals("Average"))
                    {
                        tip = 0.15 * billAmt;
                    }else if(txtOptions.equals("Poor"))
                    {
                        tip = 0.05 * billAmt;
                    }
                        calAmt=billAmt;
                        calAmt+= tip;
                        calAmt=calAmt/numPeople;
                    DecimalFormat currencyFormat = new DecimalFormat("$###,###.##");

                    String OutputString = null;
                    if(txtOptions.equals("Excellent"))
                    {
                        OutputString="The individual split share is" + currencyFormat.format(calAmt)+ "." + "One of the best meals ever! I will recommend this place to everryone I know! " + "Tip amt is" +currencyFormat.format(tip) ;
                    }else if(txtOptions.equals("Average")){
                        OutputString="The individual split share is" + currencyFormat.format(calAmt) + "." + "Everything was okay !" + "Tip amt is" +currencyFormat.format(tip);
                    }else if(txtOptions.equals("Poor"))
                    {
                        OutputString="The individual split share is" + currencyFormat.format(calAmt)+ "." + "Awful, worst experience. I can't wait to give negative reviews on Yelp!" + "Tip amt is" +currencyFormat.format(tip);
                    }

                    txtResult.setText(OutputString);

                }
                catch (Exception ex){
                    Log.e(ex.getMessage(), ex.toString());


                }
            }
        };

        btnCalSplit.setOnClickListener(btnCalSplitListener);


    }
}
