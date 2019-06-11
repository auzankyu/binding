package com.bankmandiri.helloandroid2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bankmandiri.helloandroid2.activity.DetailActivity;
import com.bankmandiri.helloandroid2.adapter.TodoAdapter;
import com.bankmandiri.helloandroid2.databinding.ActivityMainBinding;
import com.bankmandiri.helloandroid2.detail.OnItemClickListener;
import com.bankmandiri.helloandroid2.dialog.AddDialog;
import com.bankmandiri.helloandroid2.dialog.AddDialogListener;
import com.bankmandiri.helloandroid2.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AddDialogListener {

    TodoAdapter adapter;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        initList();
        binding.add.setOnClickListener(this);
    }

    private void initList() {
        List<Todo> users = new ArrayList<>();
        users.add(new Todo("lazuardi", false));
        users.add(new Todo("auzan", true));
        adapter = new TodoAdapter(users, new OnItemClickListener() {
            @Override
            public void onItemClick(Todo todo) {
                Toast.makeText(MainActivity.this, "Item Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("todo", todo);
                startActivity(intent);
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                menuAdd();
                return true;
            case R.id.menu_setting:
                menuSetting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void menuAdd() {
        Toast.makeText(this, "Add Me", Toast.LENGTH_SHORT).show();
        AddDialog dialog = new AddDialog(this);
        dialog.show();
    }

    private void menuSetting() {
        Toast.makeText(this,"Go to Setting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdd(String name, boolean done) {
        adapter.add(new Todo(name, done));
    }
}
