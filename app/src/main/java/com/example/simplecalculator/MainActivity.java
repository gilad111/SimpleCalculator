package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,  "MainActivity::OnCreate");
    }

    public void onBtnClicked(View view) {
        // Get view handle using the view id
        EditText et1 = findViewById(R.id.etNum1);
        EditText et2 = findViewById(R.id.etNum2);

// Get the view’s text
        String et1Text = et1.getText().toString();
        String et2Text = et2.getText().toString();

        Integer result = null;

        if(!et1Text.equals("") && !et2Text.equals("")) {
            Log.e(TAG,  "two of the numbers are not empty");
          // Cast the String into Integer
           Integer num1 = Integer.valueOf(et1Text);
           Integer num2 = Integer.valueOf(et2Text);

            if (view.getId() == R.id.btnPlus)
                result = num1 + num2;
            if (view.getId() == R.id.btnMinus)
                result = num1 - num2;
            if (view.getId() == R.id.btnMult)
                result = num1 * num2;
            if (view.getId() == R.id.btnDiv) {
                if (num2 == 0) {
                    Toast.makeText(this, "Cant divide by 0", Toast.LENGTH_LONG).show();
                } else {
                    result = num1 / num2;
                }
            }
        }
        else{
            Toast.makeText(this, "One of the integers is empty", Toast.LENGTH_LONG).show();

        }

        TextView tvRes = findViewById(R.id.tvResult);
        if (result != null) {
            tvRes.setText(result.toString());
        }
        else {
            tvRes.setText("");
        }


    }
}