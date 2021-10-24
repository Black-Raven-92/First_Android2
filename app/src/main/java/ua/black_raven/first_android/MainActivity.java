package ua.black_raven.first_android;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3,
            button4, button5, button6, button7, button8, button9, button0, button_add,
            button_min, button_div, button_multiply, button_equals, button_all_clear;

    TextView textView;
    Calculate calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.calculate_main);
        if (calc == null) calc = new Calculate();
        else calc = (Calculate) savedInstanceState.getParcelable("calc");
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button_add = findViewById(R.id.button_add);
        button_div = findViewById(R.id.button_div);
        button_min = findViewById(R.id.button_min);
        button_equals = findViewById(R.id.button_equals);
        button_multiply = findViewById(R.id.button_multiply);
        button_all_clear = findViewById(R.id.button_all_clear);
        textView = findViewById(R.id.textView);


        button0.setOnClickListener(v -> calc.setText(textView, button0));
        button1.setOnClickListener(v -> calc.setText(textView, button1));
        button2.setOnClickListener(v -> calc.setText(textView, button2));
        button3.setOnClickListener(v -> calc.setText(textView, button3));
        button4.setOnClickListener(v -> calc.setText(textView, button4));
        button5.setOnClickListener(v -> calc.setText(textView, button5));
        button6.setOnClickListener(v -> calc.setText(textView, button6));
        button7.setOnClickListener(v -> calc.setText(textView, button8));
        button9.setOnClickListener(v -> calc.setText(textView, button9));
        button_all_clear.setOnClickListener(v -> calc.Clear(textView));

        button_add.setOnClickListener(v ->
        {
            if (textView.getText().length() != 0) calc.Plus(textView);
        });
        button_min.setOnClickListener(v ->
        {
            if (textView.getText().length() != 0) calc.Minus(textView);
        });
        button_multiply.setOnClickListener(v ->
        {
            if (textView.getText().length() != 0) calc.Multiply(textView);
        });
        button_div.setOnClickListener(v ->
        {
            if (textView.getText().length() != 0) calc.Dev(textView);
        });
        button_equals.setOnClickListener(v -> calc.Equals(textView));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calc = (Calculate) savedInstanceState.getParcelable("calc");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("calc", calc);
    }
}