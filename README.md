# 📝 Easy Notes

Basit, kullanıcı dostu bir not alma uygulamasıdır. Kotlin diliyle ve Android Studio kullanılarak geliştirilmiştir. Kullanıcılar not başlığı ve içeriği girerek notlarını kaydedebilir, uygulamaya geri döndüklerinde tüm notlarını liste halinde görebilirler.

## 📱 Özellikler

- Yeni not ekleme
- Notları SQLite veritabanında saklama
- Notları liste halinde görüntüleme
- Modern ve sade arayüz (Material Design)

---

## 🛠️ Kullanılan Teknolojiler

- **Kotlin**
- **Android SDK**
- **SQLite** (yerel veritabanı)
- **RecyclerView** (notları listelemek için)
- **Material Design** (FloatingActionButton dahil)

---

## 📂 Proje Yapısı
EasyNotes/
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/easynotes/
│ │ │ │ ├── MainActivity.kt
│ │ │ │ ├── AddNoteActivity.kt
│ │ │ │ ├── Note.kt
│ │ │ │ ├── NoteAdapter.kt
│ │ │ │ └── NotesDBHelper.kt
│ │ │ ├── res/
│ │ │ │ ├── layout/
│ │ │ │ │ ├── activity_main.xml
│ │ │ │ │ ├── activity_add_note.xml
│ │ │ │ │ └── note_item.xml
---

## 🚀 Kurulum ve Çalıştırma

1. Android Studio ile projeyi açın.
2. Gerekli Gradle bağımlılıklarının yüklenmesini bekleyin.
3. `MainActivity.kt` içerisindeki `setContentView` ve `RecyclerView` yapıları düzgün çalışacak şekilde `activity_main.xml` tanımlanmış olmalıdır.
4. Uygulamanın sorunsuz çalışabilmesi için `AndroidManifest.xml` içinde tema `Theme.MaterialComponents.DayNight.DarkActionBar` temasıyla uyumlu olmalıdır.
5. `Run > Run 'app'` diyerek emülatörde veya cihazda uygulamayı başlatın.

---

## 📸 Ekran Görüntüleri

> Eklemediysen buraya daha sonra ekran görüntüsü ekleyebilirsin.

---

## 💾 Veritabanı

Notlar `SQLite` veritabanında saklanır. Uygulama kapansa bile notlar cihazda kalır.

Tablo yapısı:

| ID | Başlık | İçerik |
|----|--------|--------|
| Int | Text  | Text   |

---

## 📌 Uygulama Akışı

1. Uygulama açılır ➝ `MainActivity`
2. `RecyclerView` ile tüm notlar gösterilir
3. `FloatingActionButton` ile ➕ butonuna basılır
4. `AddNoteActivity` ekranı açılır
5. Not yazılır ve "Kaydet" butonuna basılır
6. Notlar veritabanına kaydedilir ve ana ekrana geri dönülür

---

## 📌 Uygulama Ekran Görüntüsü
![image](https://github.com/user-attachments/assets/e8f9994a-b29a-4005-b6cf-a34cfd93f072)

