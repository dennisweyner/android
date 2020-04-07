package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exemplo.model.Todo;
import com.example.exemplo.service.TodoAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FormActivity extends AppCompatActivity {
    private TodoAPI todoAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        todoAPI = new TodoAPI();
        adicionarNovoTodo();
    }

    private void adicionarNovoTodo(){
        final EditText et_descricao = findViewById(R.id.input_form_descricao);
        final EditText et_prioridade = findViewById(R.id.input_form_prioridade);

        Button but = findViewById(R.id.button_form);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo todo = new Todo();
                todo.setPrioridade(et_prioridade.getText().toString());
                todo.setDescricao(et_descricao.getText().toString());
                try {
                    todoAPI.inserirTodo(todo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
