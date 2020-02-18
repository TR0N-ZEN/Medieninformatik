package com.example.nimmspiel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static int RandomNumber;
    static int limit=10;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO: create secret number */
        Random r = new Random();
        RandomNumber = r.nextInt(limit);
        ((EditText)findViewById(R.id.editTxt_numberInput)).setHint("Zahl");
        btnRestart = (Button)findViewById(R.id.btn_restart);

        btnRestart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                RandomNumber = r.nextInt(limit);
            }
        });
    }

    // Wurde in activity_main.xml mit Button OnClick verknüpft
    public void checkNumber(View view) {
        String inputSting = ((EditText)findViewById(R.id.editTxt_numberInput)).getText().toString();
        String output = "";
        if(!inputSting.equals("")) {
            int input = Integer.parseInt(inputSting);
            if(input < RandomNumber) {
                output = "Zu niedrig!";
            } else if(input > RandomNumber) {
                output = "Zu hoch!";
            } else if(input == RandomNumber) {
                output = "Glückwunsch!!!";
            } else {
                output = "Irgendwas ging leider schief.";
            }
            ((EditText)findViewById(R.id.editTxt_numberInput)).setText("");
            ((TextView)findViewById(R.id.txtV_result)).setText(output);

            ((TextView)findViewById(R.id.txtV_result)).setSelected(true);   //set focus

        } else { Toast.makeText(this, "Eingabe fehlt!", Toast.LENGTH_SHORT).show();}
    }
}
