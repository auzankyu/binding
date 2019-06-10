package com.bankmandiri.helloandroid2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bankmandiri.helloandroid2.databinding.ItemTodoBinding;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bankmandiri.helloandroid2.R;
import com.bankmandiri.helloandroid2.model.Todo;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private ItemTodoBinding binding;
//    private ImageView avatar;
//    private TextView name;

    public TodoViewHolder(@NonNull ItemTodoBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
//        avatar = itemView.findViewById(R.id.avatar);
//        name = itemView.findViewById(R.id.name);
    }

    public void bind(Todo todo) {
            binding.setTodo(todo);
//        name.setText(todo.getName());
    }
}