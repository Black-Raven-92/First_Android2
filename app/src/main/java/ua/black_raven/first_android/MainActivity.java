package ua.black_raven.first_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String name;
    private String lastNAme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_main);
        Button button1 = findViewById(R.id.button1);
        Button buttonClear = findViewById(R.id.button11);

        EditText res = findViewById(R.id.textView);
        button1.setOnClickListener(v->res.setText("1"));
        buttonClear.setOnClickListener(v->res.setText("0"));











    }
}