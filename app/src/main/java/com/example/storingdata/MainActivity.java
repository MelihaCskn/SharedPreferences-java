package com.example.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numberOneText;
    TextView showAgeText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOneText = findViewById(R.id.editTextNumber);
        showAgeText = findViewById(R.id.textView);

         sharedPreferences = this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);
         int storedAge= sharedPreferences.getInt("storedAge",0);

         if(storedAge==0){
             showAgeText.setText("your age: ");
         }
         else {
             showAgeText.setText("yor age:" + storedAge);
         }
    }

    public void showNumber(View view) {
        if (!numberOneText.getText().toString().matches("")) {
            int userAge = Integer.parseInt(numberOneText.getText().toString());
            showAgeText.setText("your age:" + userAge);
sharedPreferences.edit().putInt("storedAge",userAge).apply();

        }

    }
    public void delete(View view){
        int storedData=sharedPreferences.getInt("storedAge",0);
        if(storedData!=0){
            sharedPreferences.edit().remove("storedAge").apply();
            showAgeText.setText("your age: ");
        }

    }
}
