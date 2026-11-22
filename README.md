### Mini Challenge TP10 – Character Level Styling

Pada Mini Challenge ini, saya menambahkan perubahan tampilan pada karakter berdasarkan level.

- Karakter dengan level 5 ke atas menggunakan warna emas (`AppTheme.GOLD`) dan font tebal (`Font.BOLD`).
- Karakter dengan level di bawah 5 menggunakan warna putih dan font biasa (`Font.PLAIN`).
- Batas level disimpan dalam konstanta `HIGH_LEVEL_THRESHOLD` agar kode lebih mudah dibaca dan dikelola.

Logika ini ditempatkan pada bagian View karena pengaturan warna dan ketebalan teks merupakan kebutuhan tampilan, bukan perhitungan atau aturan inti dari Model.