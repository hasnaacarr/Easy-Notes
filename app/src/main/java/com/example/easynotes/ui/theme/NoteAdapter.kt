package com.example.easynotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// RecyclerView için özel adaptör – notları gösterir
class NoteAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    // Tek bir satırın bileşenlerini tutan sınıf
    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.noteTitle)     // Başlık
        val contentText: TextView = view.findViewById(R.id.noteContent) // İçerik
    }

    // Her satır (görünüm) oluşturulurken çağrılır
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    // Her satır ekrana bağlandığında çağrılır
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]                       // O anki not
        holder.titleText.text = note.title               // Başlığı yaz
        holder.contentText.text = note.content           // İçeriği yaz
    }

    // Toplam kaç not varsa onu döndür
    override fun getItemCount() = notes.size

    // Notlar değiştiğinde RecyclerView’ı güncelle
    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}
