package com.example.easynotes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextContent: EditText
    private lateinit var buttonSave: Button

    private lateinit var dbHelper: NotesDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextContent = findViewById(R.id.editTextContent)
        buttonSave = findViewById(R.id.buttonSave)

        dbHelper = NotesDBHelper(this)

        buttonSave.setOnClickListener {
            val title = editTextTitle.text.toString()
            val content = editTextContent.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                dbHelper.insertNote(title, content)
                Toast.makeText(this, "Not kaydedildi", Toast.LENGTH_SHORT).show()
                finish() // Not kaydedildikten sonra önceki ekrana dön
            } else {
                Toast.makeText(this, "Lütfen başlık ve içerik girin", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
