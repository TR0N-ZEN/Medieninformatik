package com.example.a3praxis_bungjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnQuersumme;
    Button btnFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnQuersumme = (Button)findViewById(R.id.btn_Quersumme);
        btnFibonacci = (Button)findViewById(R.id.btn_Fibonacci);
    }

    public void calculateDigitSum(View view){
        String inputQuersumme = ((EditText)findViewById(R.id.input_Quersumme)).getText().toString();
        int Uebertrag = 0;
        int number;
        for (int x = 0; x < inputQuersumme.length(); x++) { /* Schleife durchläuft String inputQuersumme und greift Character nach Durchlaufvariable x ab und konvertiert sie in Integer und addiert sie auf die bisherige Summe (Uebertrag)*/
            number = Character.getNumericValue(inputQuersumme.charAt(x));
            Uebertrag = Uebertrag + number;
        }
        String Ergebnis = Integer.toString(Uebertrag);
        ((TextView)findViewById(R.id.output_Quersumme)).setText(Ergebnis);
        ((TextView)findViewById(R.id.output_Quersumme)).setSelected(true);

    }

    public void calculateFibonacciRow(View view){
        String textAusgabe = "";
        int fibRow [] = new int[30]; /*30-stelliges array für integer*/
        fibRow[0]= 0;
        fibRow[1]=1;
        for(int i = 2; i <30; i++){ /*Schleife mit Rückbezug auf vorherigen beiden Werte - nach Fibomnacci*/
            fibRow[i]= fibRow[i-1]+ fibRow[i-2];
        }
        for(int i = 0; i <30; i++){
            textAusgabe += "  " + fibRow[i]+ " \n";
        }
        ((TextView)findViewById(R.id.result_Fibonacci)).setText(textAusgabe);
        ((TextView)findViewById(R.id.result_Fibonacci)).setSelected(true);
    }
}
