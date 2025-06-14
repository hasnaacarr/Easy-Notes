package com.example.easynotes  // Dosyanın bulunduğu paket adı

// Kotlin'de veri tutmak için kullanılan kısa yol: data class
data class Note(
    val id: Int = 0,         // Her notun veritabanında benzersiz bir kimliği olur (otomatik artar)
    val title: String,       // Not başlığı
    val content: String      // Not içeriği
)
