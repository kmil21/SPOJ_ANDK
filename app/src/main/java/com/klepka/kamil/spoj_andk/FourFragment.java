package com.klepka.kamil.spoj_andk;

/**
 * Created by Kamil on 2016-04-25.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.klepka.kamil.spoj_andk.R;
public class FourFragment extends Fragment{

    EditText pinwheel;
    Button draw_pinwheel;
    TextView results4;
    public FourFragment() {
        // Required empty public constructor
    }

    private void DrawPinwheel()
    {
        int n =0, t;

        t = Integer.parseInt(pinwheel.getText().toString());
        if (t == 0)

        if (t < 0)
            n = t * (-1);
        if (t > 0)
            n = t;
        char[][] tab = new char[400][400];//tablica znakowa dwuwymiarowa do "rysowania" wiatraczka
        for (int i = 0; i < 2 * n; i++)
        {
            for (int k = 0; k < 2 * n; k++)                    {
                tab[i][k] = '.';
            }
        }
        if (t > 0)//Wiatraczek lewo skrętny
        {
            for (int i = 0, p = 0; i < n; i++, p++)
            {
                tab[n - p - 1][ n - p - 1] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n - p - 1][ n - p - 1 - k] = '*';
                tab[n - p - 1][ n + p] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n - p - 1 - k][ n + p] = '*';
                tab[n + p][ n - p - 1] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n + p + k][ n - p - 1] = '*';
                tab[n + p][ n + p] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n + p][ n + p + k] = '*';
            }
        }
        if (t < 0) // Wiatraczek prawo skrętny
        {
            for (int i = 0, p = 0; i < n; i++, p++)
            {
                tab[n - p - 1][ n - p - 1] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n - p - 1 - k][ n - p - 1] = '*';

                tab[n - p - 1][ n + p] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n - p - 1][ n + p + k] = '*';

                tab[n + p][ n - p - 1] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n + p][ n - p - 1 - k] = '*';

                tab[n + p][ n + p] = '*';
                for (int k = 1; k + p < n; k++)
                    tab[n + p + k][ n + p] = '*';
            }
        }
        String StrPinwheel= "";
        for (int i = 0; i < 2 * n; i++)
        {
            for (int k = 0; k < 2 * n; k++)
            {
               StrPinwheel += (tab[i][ k]);
            }
            StrPinwheel+= "\n";
        }
        results4.setText(StrPinwheel);
        pinwheel.setText("");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_four, container, false);
        pinwheel = (EditText) v.findViewById(R.id.pinwheel);
        draw_pinwheel = (Button) v.findViewById(R.id.draw_pinwheel);
        results4 = (TextView) v.findViewById(R.id.Result4);

        draw_pinwheel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DrawPinwheel();
            }
        });
        return v;
    }

}
