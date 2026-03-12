package com.works.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.works.databinding.ItemTodoBinding
import com.works.models.DocTodo

class TodoAdapter(
    private val list: ArrayList<DocTodo>
) : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    class TodoHolder(val binding: ItemTodoBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {

        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TodoHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {

        val item = list[position]

        holder.binding.tvTitle.text = item.data.title
        holder.binding.tvDetail.text = item.data.detail

        holder.binding.viewColor.setBackgroundColor(item.data.color)
    }
}