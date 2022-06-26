package com.example.first_project_fm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    public static String TAG = "log";

    private EditText inputText;
    private EditText filtrText;
    private TextView resultText;
    private String anagramText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        filtrText = findViewById(R.id.filtrText);
        resultText = findViewById(R.id.anagramText);

        inputText.addTextChangedListener(this);
        filtrText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //resultText.setText(inputText.getText().toString() + " " + filtrText.getText().toString());
        anagramText = new Anagram().buildAnagram(inputText.getText().toString(), filtrText.getText().toString());
        resultText.setText(anagramText);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}