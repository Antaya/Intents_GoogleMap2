package com.example.intents_googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText textEdit;
    private String textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEdit = findViewById(R.id.text_edit);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        textInput = textEdit.getText().toString();
        if (checkIsLetter(textInput) == true) {
            Uri objectNameUri = Uri.parse("geo:?q=" + textEdit.getText().toString());
            intent.setData(objectNameUri);

        } else {
            Uri coordinatesUri = Uri.parse("geo:" + textEdit.getText().toString());
            intent.setData(coordinatesUri);
        }

        // Запускаем приложения
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public boolean checkIsLetter(String textInput) {
        char[] textInputToArray = textInput.toCharArray(); // Преобразуем строку в массив символов (char)
        for (int i = 0; i < textInputToArray.length; i++) {
            Character.isLetter(i);
        }
        return true;
    }
}