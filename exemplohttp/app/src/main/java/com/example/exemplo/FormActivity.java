package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    private EditText inputPrioridade;
    private EditText inputDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        inputDescricao = (EditText) findViewById(R.id.input_form_descricao);
        inputPrioridade = (EditText) findViewById(R.id.input_form_prioridade);

        Bundle args = getIntent().getBundleExtra("args_main");

        
    }
}
