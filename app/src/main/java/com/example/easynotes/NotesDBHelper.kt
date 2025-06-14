package com.example.easynotes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Veritabanı işlemleri için SQLiteOpenHelper sınıfını miras alıyoruz
class NotesDBHelper(context: Context) : SQLiteOpenHelper(context, "NotesDB", null, 1) {

    companion object {
        // Tablo ve sütun adları sabit olarak tanımlanır
        const val TABLE_NAME = "notes"          // Tablo adı: notes
        const val COL_ID = "id"                 // Sütun: id (birincil anahtar)
        const val COL_TITLE = "title"           // Sütun: not başlığı
        const val COL_CONTENT = "content"       // Sütun: not içeriği
    }

    // Veritabanı ilk oluşturulduğunda çağrılır
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +   // Otomatik artan id
                "$COL_TITLE TEXT, " +
                "$COL_CONTENT TEXT)"
        db.execSQL(createTable)  // SQL komutunu çalıştır
    }

    // Veritabanı sürümü değişirse çağrılır (şu an kullanılmaz ama gerekir)
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME") // Eski tabloyu sil
        onCreate(db)  // Yeni tabloyu oluştur
    }

    // Yeni not eklemek için fonksiyon
    fun insertNote(title: String, content: String): Boolean {
        val db = writableDatabase  // Yazılabilir veritabanı al
        val values = ContentValues().apply {
            put(COL_TITLE, title)     // Başlık sütununa veri ekle
            put(COL_CONTENT, content) // İçerik sütununa veri ekle
        }
        val result = db.insert(TABLE_NAME, null, values) // Veriyi tabloya ekle
        return result != -1L     // Eklenmişse true döner
    }

    // Tüm notları listeleyen fonksiyon
    fun getAllNotes(): List<Note> {
        val notes = mutableListOf<Note>()               // Boş liste oluştur
        val db = readableDatabase                       // Okunabilir veritabanı
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // Veritabanında veri varsa tek tek oku
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID))
                val title = cursor.getString(cursor.getColumnIndexOrThrow(COL_TITLE))
                val content = cursor.getString(cursor.getColumnIndexOrThrow(COL_CONTENT))
                notes.add(Note(id, title, content))     // Listeye notu ekle
            } while (cursor.moveToNext())
        }

        cursor.close() // Belleği temizle
        return notes   // Not listesini döndür
    }
}
