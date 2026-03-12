package com.works.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.works.R
import com.works.models.Note

class NoteAdapter(val list: List<Note>, val onLongClick: (Note) -> Unit) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    class NoteHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.itemTitle)
        val detail: TextView = view.findViewById(R.id.itemDetail)
        val date: TextView = view.findViewById(R.id.itemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val note = list[position]
        holder.title.text = note.title
        holder.detail.text = note.detail
        holder.date.text = note.date
        holder.itemView.setOnLongClickListener {
            Log.d("TAG", "onBindViewHolder: " + note.id)
            onLongClick(note)
            true
        }
    }
}