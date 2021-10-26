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
            button_min, button_div, button_multiply, button_equals, button_all_clear, button_dot;
    private final int[] buttonsID = new int []{R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9};

    TextView textView;
    Calculate calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_main);
        button_add = findViewById(R.id.button_add);
        button_div = findViewById(R.id.button_div);
        button_min = findViewById(R.id.button_min);
        button_equals = findViewById(R.id.button_equals);
        button_multiply = findViewById(R.id.button_multiply);
        button_all_clear = findViewById(R.id.button_all_clear);
        button_dot = findViewById(R.id.button_dot);
        textView = findViewById(R.id.textView);
        setNumberButtonClick();
        if (savedInstanceState == null) {
            calc = new Calculate();
        } else {
            calc = (Calculate) savedInstanceState.getParcelable("calc");
            textView.setText(calc.text);
        }




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
        button_dot.setOnClickListener(v->calc.setDot(textView));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("calc", calc);
    }

    private void setNumberButtonClick() {
        for (int i = 0; i < buttonsID.length; i++) {
            findViewById(buttonsID[i]).setOnClickListener(v -> {
                Button btn = (Button) v;
                calc.setText(textView,btn);
            });
        }
    }
}