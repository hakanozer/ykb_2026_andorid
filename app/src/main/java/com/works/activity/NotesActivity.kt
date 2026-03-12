package com.works.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.works.R
import com.works.adapter.NoteAdapter
import com.works.models.Note
import com.works.utils.DB
import java.util.Calendar

class NotesActivity : AppCompatActivity() {

    lateinit var db: DB

    lateinit var editTitle: EditText
    lateinit var editDetail: EditText
    lateinit var editDate: EditText
    lateinit var btnSave: Button
    lateinit var recyclerNotes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notes)
        db = DB(this)
        init()
    }

    private fun init() {
        editTitle = findViewById(R.id.editTitle)
        editDetail = findViewById(R.id.editDetail)
        editDate = findViewById(R.id.editDate)
        btnSave = findViewById(R.id.btnSave)
        recyclerNotes = findViewById(R.id.recyclerNotes)
        editDate.setOnClickListener {
            showDatePicker()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val noteList = db.getNotes()
        val adaptar = NoteAdapter(noteList, ::onLongClick)
        recyclerNotes.layoutManager = LinearLayoutManager(this)
        recyclerNotes.adapter = adaptar
        btnSave.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val title = editTitle.text.toString()
        val detail = editDetail.text.toString()
        val date = editDate.text.toString()
        val status = db.addNote(title, detail, date)
        if (status > -1) {
            editTitle.text.clear()
            editDetail.text.clear()
            editDate.text.clear()
            editTitle.requestFocus()
            val noteList = db.getNotes()
            val adaptar = NoteAdapter(noteList, ::onLongClick)
            recyclerNotes.adapter = adaptar
        }
    }

    private fun onLongClick(note: Note) {
        val status = db.deleteNote(note.id)
        if (status > -1) {
            val noteList = db.getNotes()
            val adaptar = NoteAdapter(noteList, ::onLongClick)
            recyclerNotes.adapter = adaptar
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            this,
            { _, year, month, day ->
                val selectedDate = "$day/${month+1}/$year"
                editDate.setText(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

}