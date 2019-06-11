package com.bankmandiri.helloandroid2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bankmandiri.helloandroid2.databinding.ItemTodoBinding;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bankmandiri.helloandroid2.R;
import com.bankmandiri.helloandroid2.detail.OnItemClickListener;
import com.bankmandiri.helloandroid2.model.Todo;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private ItemTodoBinding binding;

    public TodoViewHolder(@NonNull ItemTodoBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    public void bind(final Todo todo,final OnItemClickListener listener) {
            binding.setTodo(todo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(todo);
                }
            });

    }
}