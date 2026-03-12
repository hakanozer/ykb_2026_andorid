package com.works.utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.works.models.Note

class DB(context: Context) : SQLiteOpenHelper(context, "app.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE note (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "detail TEXT," +
                    "date TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS note")
        onCreate(db)
    }

    // NOT EKLEME
    fun addNote(title: String, detail: String, date: String): Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("detail", detail)
        values.put("date", date)
        val status = db.insert("note", null, values)
        db.close()
        return status
    }

    // NOT SİLME
    fun deleteNote(id: Int): Int {
        val db = writableDatabase
        val status = db.delete(
            "note",
            "id=?",
            arrayOf(id.toString())
        )
        db.close()
        return status
    }

    // NOTLARI LİSTELE
    fun getNotes(): ArrayList<Note> {
        val list = ArrayList<Note>()
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM note ORDER BY id DESC",
            null
        )
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val title = cursor.getString(1)
            val detail = cursor.getString(2)
            val date = cursor.getString(3)
            val note = Note(id, title, detail, date)
            list.add(note)
        }
        cursor.close()
        db.close()
        return list
    }

}