package com.bankmandiri.helloandroid2.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bankmandiri.helloandroid2.MainActivity;
import com.bankmandiri.helloandroid2.R;
import com.bankmandiri.helloandroid2.databinding.ActivityDetailBinding;
import com.bankmandiri.helloandroid2.model.Todo;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        setSupportActionBar(binding.toolbar);

        Todo todo = getIntent().getExtras().getParcelable("todo");
        binding.setTodo(todo);

        binding.edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.edit) {
            String name = binding.name.getText().toString().trim();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("todo", new Todo(name, true));
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
