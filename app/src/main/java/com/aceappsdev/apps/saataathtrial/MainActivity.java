package com.aceappsdev.apps.saataathtrial;

import android.icu.util.RangeValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aceappsdev.apps.saataathtrial.structure.*;


public class MainActivity extends AppCompatActivity {

    Button btnList ;
    Button btnShuffle;
    Button btnDeal;

    TextView tvDisplay;

    Deck deck;

    View.OnClickListener l = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnList :
                    tvDisplay.setText(deck.toString());
                    break;
                case R.id.btnShuffle:
                    deck.randomShuffle();
                    tvDisplay.setText(deck.toString());
                    break;
                case R.id.btnDeal:
                    deal();
                    break;
            }
            tvDisplay.setText(deck.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deck = new Deck();

        tvDisplay = (TextView)findViewById(R.id.tvDisplay);
        btnList = (Button) findViewById(R.id.btnList);
        btnShuffle = (Button) findViewById(R.id.btnShuffle);
        btnDeal = (Button) findViewById(R.id.btnDeal);

        btnList.setOnClickListener(l);
        btnShuffle.setOnClickListener(l);
        btnDeal.setOnClickListener(l);
    }

    private void deal(){

    }
}
