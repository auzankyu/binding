package com.bankmandiri.helloandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.bankmandiri.helloandroid2.adapter.TodoAdapter;
import com.bankmandiri.helloandroid2.databinding.ActivityMainBinding;
import com.bankmandiri.helloandroid2.model.Todo;
import android.databinding.DataBindingUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TodoAdapter adapter;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initList();
        binding.add.setOnClickListener(this);
    }

    private void initList() {
        List<Todo> users = new ArrayList<>();
        users.add(new Todo("anka", false));
        users.add(new Todo("ahda", true));
        adapter = new TodoAdapter(users);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.binding.mainRcvTodo.setLayoutManager(layoutManager);
        this.binding.mainRcvTodo.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            adapter.add(new Todo(binding.todo.getText().toString() , binding.checkbox.isChecked()));
            binding.todo.setText("");
        }

    }
}
