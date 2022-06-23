package com.example.first_project_fm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "log";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.inputText);
        EditText editText2 = findViewById(R.id.filtrText);
        TextView textView = findViewById(R.id.anagramText);


        editText.addTextChangedListener(new TextWatcher() {
            String str = editText2.getText().toString();




            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

                Log.i(TAG, "beforeTextChanged");
                //new Anagram().buildAnagram(s, editText2.getText());
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged");
            }

            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged");
                Log.d(TAG, "InputText: " + s.toString());
                //Log.d(TAG, editText2.getText().toString());
                //TextView textView = findViewById(R.id.anagramText);
               // Log.d(TAG, "filtrText: " + editText2.getText().toString());
                //this.str = s.toString();

                if (editText2.getText().length() < 1) {
                    Log.d(TAG, "if true: " + s);
                    textView.setText(s);
                } else {
                    Log.d(TAG, "if false: " + s);
                    textView.setText(new Anagram().buildAnagram(s.toString(), str));
                }

            }
        });

        editText2.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                Log.i(TAG, "beforeTextChanged");

                //new Anagram().buildAnagram(s, editText2.getText());
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged");
            }

            public void afterTextChanged(Editable s) {
                String str = editText.getText().toString();
                Log.d(TAG, "значение str: " + str);

                Log.i(TAG, "afterTextChanged");
                Log.d(TAG, "InputText: " + str);
                //Log.d(TAG, editText2.getText().toString());
                //TextView textView = findViewById(R.id.anagramText);
                Log.d(TAG, "filtrText: " + editText2.getText().toString());

                if (editText2.getText().length() < 1) {
                    Log.d(TAG, "if true: " + s);
                    textView.setText(str);
                } else {
                    Log.d(TAG, "if false: " + s);
                    textView.setText(new Anagram().buildAnagram(str, s.toString()));
                }

            }
        });
    }
}