package com.klepka.kamil.spoj_andk;

/**
 * Created by Kamil on 2016-04-25.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.klepka.kamil.spoj_andk.R;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment{

    private Spinner spin_case;
    private int num_Case = 1;
    EditText edit,edit2;
    TextView Results;
    private Button countBtn;
    private String temp = "";
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void FillSpinner()
    {


        List<String> numCase = new ArrayList<String>();
        for(int i = 1;i<=10;i++)
        {
            numCase.add(Integer.toString(i));
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (getActivity(), R.layout.spinner_item,numCase);

        spin_case.setAdapter(dataAdapter);
    }

    private void setEditTexts(boolean active)
    {


        if (!active) {

            edit.setEnabled(false);

            edit2.setEnabled(false);

            countBtn.setEnabled(false);
    }
        else
        {
            edit.setEnabled(true);
            edit2.setEnabled(true);

            countBtn.setEnabled(true);
        }
    }

    public void onClickCount()
    {
        int a,b;
        if(edit.getText().toString().matches("") || edit2.getText().toString().matches("") ) {
        }
        else {
            a = Integer.parseInt(edit.getText().toString());
            b = Integer.parseInt(edit2.getText().toString());
            //Results.setText(edit.getText());
            edit.setText("");
            edit2.setText("");
            temp += Integer.toString(pow(a, b)) + "\n";
            Results.setText(temp);

            if (num_Case == 0) {
                setEditTexts(false);
                temp ="";
                Results.setText(temp);
            }
            num_Case--;
        }
    }
    private int pow (int a, int b)
    {
        int result = a%10;
        int power = (b - 1) % 4;
        switch (result) {

            case 1:
                break;
            case 2:
                result = new int[] { 2, 4, 8, 6 }[power];
                break;
            case 3:
                result = new int[] { 3, 9, 7, 1 }[power];
                break;
            case 4:
                result = new int[] { 4, 6, 4, 6 }[power];
                break;
            case 5: break;
            case 6: break;
            case 7:
                result = new int[] { 7, 9, 3, 1 }[power];
                break;
            case 8:
                result = new int[] { 8, 4, 2, 6 }[power];
                break;
            case 9:
                result = new int[] { 9, 1, 9, 1 }[power];
                break;
            case 0:
                break;

        }

        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_one, container, false);
        spin_case = (Spinner) v.findViewById(R.id.spin_case);
        FillSpinner();
        edit = (EditText) v.findViewById(R.id.numA);
        edit2 = (EditText) v.findViewById(R.id.numB);
        countBtn = (Button) v.findViewById(R.id.countBtn);
       //spin_case.setEnabled(false);
        setEditTexts(false);
        Results = (TextView) v.findViewById(R.id.Result);
        spin_case.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int position, long id) {
                num_Case = Integer.parseInt(parent.getItemAtPosition(position).toString());

                setEditTexts(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickCount();
            }
        });

        return v;
    }

}
