package com.example.javaappversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EditText wt , ht_cm ;
        TextView result ;
        Button button ;
        LinearLayout linear ;
        linear =findViewById(R.id.linearMain);
        wt =findViewById(R.id.edit_weight);
        ht_cm =findViewById(R.id.edit_height_cm);
        button =findViewById(R.id.button);
        result =findViewById(R.id.edit_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(wt.getText().toString()) ;
                int heightCm = Integer.parseInt(ht_cm.getText().toString());

                double finalHeight = heightCm/100.0 ;

                double bmi = weight/(finalHeight*finalHeight) ;




                if(bmi > 25)
                {
                    result.setText("Overweight");
                    linear.setBackgroundColor(getResources().getColor(R.color.overwt));
                } else if (bmi < 18) {

                    result.setText("malnourished");
                    linear.setBackgroundColor(getResources().getColor(R.color.underwt));
                } else {
                    result.setText("perfect");
                    linear.setBackgroundColor(getResources().getColor(R.color.perfectwt));
                }



            }
        });
    }
}