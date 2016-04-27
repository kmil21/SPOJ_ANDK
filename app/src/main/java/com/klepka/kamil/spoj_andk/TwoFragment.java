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
public class TwoFragment extends Fragment{

    EditText editMap;
     TextView Results2;
    private Button FindBtn;
    public class SearchTreasure
    {
        private int x, y;
        public SearchTreasure(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int getPosX()
        {
            return x;

        }

        public int getPosY()
        {
            return y;

        }
        public void setPosX(int NewX)
        {
           this.x = NewX;

        }

        public void setPosY(int NewY)
        {
            this.y = NewY;

        }


    }

    private void FindTreasure()
    {

        String MapT;
        int[][] mapTab;

        MapT = editMap.getText().toString();
       //

     if(MapT.matches(""))
        {
            Results2.setText("Bad data");
        }
        else {
         String[] splitMap = MapT.split("\\s+");
         if (splitMap.length%2 == 0) {

             Results2.setText(MapT);
             mapTab = new int[splitMap.length/2][2];
             int row=0;
             for (int i = 0;i<splitMap.length;i++)
             {
                 if(i == 0 || i%2 == 0)
                 {
                     mapTab[row][0] = Integer.parseInt(splitMap[i]);
                 }
                 else
                 {
                     mapTab[row][1] = Integer.parseInt(splitMap[i]);
                     row++;
                 }
             }
             SearchTreasure search = new SearchTreasure(0,0);
             for(int i=0;i<mapTab.length;i++)
             {
                 switch(mapTab[i][0])
                 {
                     case 0:
                         search.setPosY(search.getPosY() + mapTab[i][1]) ;
                         break;
                     case 1:
                         search.setPosY(search.getPosY() - mapTab[i][1]) ;
                         break;
                     case 2:
                         search.setPosX(search.getPosX() - mapTab[i][1]) ;
                         break;
                     case 3:
                         search.setPosX(search.getPosX() + mapTab[i][1]) ;
                         break;
                 }
             }
            MapT ="";
             if (search.getPosY() != 0 || search.getPosX() !=0)
             {
                 if(search.getPosY()>0)
                 {
                     MapT += "0 "+ Integer.toString(search.getPosY()) + "\n";
                     Results2.setText(MapT);
                 }
                 else if (search.getPosY()<0)
                 {

                     MapT += "1 "+ Integer.toString(search.getPosY())+ "\n";
                     Results2.setText(MapT);
                 }
                 if (search.getPosX() > 0)
                 {

                     MapT += "3 "+ Integer.toString(search.getPosX())+ "\n";
                     Results2.setText(MapT);
                 }
                 else if (search.getPosX() < 0)
                 {

                     MapT += "4 "+ Integer.toString(search.getPosX())+ "\n";
                     Results2.setText(MapT);
                 }
             }
             else
             {
                 MapT +="studnia" +"\n";
                 Results2.setText(MapT);
             }
            search.setPosX(0);
            search.setPosY(0);
             editMap.setText("");

         }
         else
             Results2.setText("Bad data");
         editMap.setText("");
        }

    }
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        FindBtn = (Button) v.findViewById(R.id.find_treasure);
        editMap = (EditText) v.findViewById(R.id.mapText);
        Results2 = (TextView) v.findViewById(R.id.Result2);
        FindBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FindTreasure();
            }
        });
        return v;
    }

}
