package com.example.easynotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easynotes.R.id.recyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Ana ekran aktivitesi – notları listeler ve yeni not ekleme ekranına geçiş sağlar
class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: NotesDBHelper          // Veritabanı nesnesi
    private lateinit var recyclerView: RecyclerView       // Notları gösterecek liste
    private lateinit var adapter: NoteAdapter             // Liste için adaptör

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)            // Arayüz dosyasını bağla

        dbHelper = NotesDBHelper(this)                    // Veritabanını başlat
        recyclerView = findViewById(R.id.recyclerView)    // RecyclerView’u bul
        recyclerView.layoutManager = LinearLayoutManager(this) // Dikey liste olarak ayarla

        // Veritabanından tüm notları al ve adaptöre ver
        adapter = NoteAdapter(dbHelper.getAllNotes())
        recyclerView.adapter = adapter

        // "➕" butonuna tıklanınca yeni not ekranına geç
        val fab = findViewById<FloatingActionButton>(R.id.fabAddNote)
        fab.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }

    // Sayfa her göründüğünde notları güncelle (örneğin not eklenince geri dönünce)
    override fun onResume() {
        super.onResume()
        adapter.updateNotes(dbHelper.getAllNotes())
    }
}
