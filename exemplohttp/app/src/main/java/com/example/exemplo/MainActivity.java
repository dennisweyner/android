package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.exemplo.adapter.TodoListAdapter;
import com.example.exemplo.model.Todo;
import com.example.exemplo.service.TodoAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TodoListAdapter adapter;
    private List<Todo> todos;
    private TodoAPI todoAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoAPI = new TodoAPI();
        iniciarListView();
        iniciarAcaoBotaoAdd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillArrayTest();
    }

    private void iniciarListView() {
        todos = new ArrayList<>();
        ListView listView = findViewById(R.id.listview_main_ac);
        adapter = new TodoListAdapter(this, todos);
        listView.setAdapter(adapter);
    }

    private void iniciarAcaoBotaoAdd() {
        FloatingActionButton button = findViewById(R.id.activity_main_floatBT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FormActivity.class);
                startActivity(i);
            }
        });
    }

    private void fillArrayTest() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    todos.clear();
                    todos.addAll(todoAPI.listarTodos());
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException ex) {

                }
            }
        });
    }
}
