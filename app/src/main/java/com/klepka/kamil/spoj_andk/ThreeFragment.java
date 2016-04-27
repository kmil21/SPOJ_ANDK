package com.klepka.kamil.spoj_andk;

/**
 * Created by Kamil on 2016-04-25.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.klepka.kamil.spoj_andk.R;
public class ThreeFragment extends Fragment{

    private  int max_profit = 0,profit = 0 ,temp =0;
    EditText concertList;
    Button find_concert;
    TextView results3;
    public ThreeFragment() {
        // Required empty public constructor
    }

    private void FindMax()
    {
        String Concerts;
        int[][] mapTab;

        Concerts = concertList.getText().toString();
        //

        if(Concerts.matches(""))
        {
            results3.setText("Bad data");
        }
        else {
            String[] splitConcerts = Concerts.split("\\s+");

            temp =0;

            for (int i = 0; i < splitConcerts.length; i++) {
                profit = Integer.parseInt(splitConcerts[i]);
                Log.d("Profit",Integer.toString(profit));
                if (temp > 0) {
                    temp += profit;
                } else {
                    temp = profit;
                }
                if (temp > max_profit) {
                    max_profit = temp;
                }
            }

        results3.setText(Integer.toString(max_profit));
            concertList.setText("");
            temp =0;
            max_profit=0;
    }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_three, container, false);
        concertList = (EditText) v.findViewById(R.id.concertList);
        results3 = (TextView) v.findViewById(R.id.Result3);
        find_concert = (Button) v.findViewById(R.id.find_concert);

        find_concert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FindMax();
            }
        });
        return v;
    }

}
