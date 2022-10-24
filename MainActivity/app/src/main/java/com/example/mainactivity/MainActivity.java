package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtH2,edtH1,edtW;
        TextView txtResult ;
        Button btCalculate;
        edtW = findViewById(R.id.edtW);
        edtH1 = findViewById(R.id.edtH1);
        edtH2 = findViewById(R.id.edtH2);
        btCalculate = findViewById(R.id.btCalculate);
        txtResult = findViewById(R.id.txtResult);

        LinearLayout llMain = findViewById(R.id.llMain);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(edtW.getText().toString());
                int h1 = Integer.parseInt(edtH1.getText().toString());
                int h2 = Integer.parseInt(edtH2.getText().toString());
                int totalIn = h1 * 12 + h2;

                double totalCm = totalIn * 2.54;
                double totalM = totalCm / 100;
                double bmi = weight / (totalM * totalM);
                if (bmi > 25) {
                    txtResult.setText("You're overWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.warningW));
                } else if (bmi < 18) {
                    txtResult.setText("You're uderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.warningH1));
                } else {
                    txtResult.setText("You're healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.warningH2));
                }

            }
        });
    }
}