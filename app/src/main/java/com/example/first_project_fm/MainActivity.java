package com.example.first_project_fm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText inputText;
    private EditText filterText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        filterText = findViewById(R.id.filtrText);
        resultText = findViewById(R.id.anagramText);

        inputText.addTextChangedListener(this);
        filterText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String anagramText = Anagram.buildAnagram(inputText.getText().toString(), filterText.getText().toString());
        resultText.setText(anagramText);
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
}