package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

// Cast the String into Integer
        Integer num1 = Integer.valueOf(et1Text);
        Integer num2 = Integer.valueOf(et2Text);

        Integer result = null;
        if (view.getId() == R.id.btnPlus)
            result = num1 + num2;
        if (view.getId() == R.id.btnMinus)
            result = num1 - num2;
        if (view.getId() == R.id.btnMult)
            result = num1 * num2;
        if (view.getId() == R.id.btnDiv)
            result = num1 / num2;

        if (result != null) {
            TextView tvRes = findViewById(R.id.tvResult);
            tvRes.setText(result.toString());
        }


    }
}