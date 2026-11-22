### Mini Challenge TP12 – Status Bar Layout

Pada Mini Challenge ini, saya mengubah tampilan status bar menggunakan `BorderLayout`.

- Teks status ditempatkan di sebelah kiri menggunakan `BorderLayout.WEST`.
- Label versi ditempatkan di sebelah kanan menggunakan `BorderLayout.EAST`.
- Label versi menggunakan warna `AppTheme.TEXT_MUTED` dan font `AppTheme.FONT_MONO`.
- Nomor versi disimpan dalam satu konstanta `APP_VERSION` agar judul jendela dan label versi menggunakan nilai yang sama.

Ketika ukuran jendela diperlebar, teks status tetap berada di kiri dan label versi tetap berada di kanan karena pengaturan layout menggunakan `BorderLayout`.