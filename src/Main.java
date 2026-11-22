import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.2 — CRUD Test ===\n");

        CharacterManager manager = new CharacterManager();

        // 1. Tambah beberapa karakter
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        // 2. Coba tambah DUPLIKAT nama — seharusnya DITOLAK
        System.out.println();
        manager.addCharacter(new Character("Arjuna", CharacterType.HEALER, 1));

        // 3. Tampilkan total karakter
        System.out.println("\nTotal karakter saat ini: " + manager.getTotalCharacters());

        // 4. Cari karakter
        System.out.println("\n--- Pencarian ---");
        Character hasil = manager.findByName("Merlin");
        System.out.println(hasil != null ? "Ditemukan: " + hasil : "Tidak ditemukan");

        Character tidakAda = manager.findByName("Zeus");
        System.out.println(tidakAda != null ? "Ditemukan: " + tidakAda : "Zeus tidak ditemukan (sesuai harapan)");

        // 5. Hapus karakter
        System.out.println("\n--- Penghapusan ---");
        manager.removeCharacter("Athena");
        System.out.println("Total setelah hapus: " + manager.getTotalCharacters());

        // 6. Tampilkan semua karakter yang tersisa
        System.out.println("\n--- Daftar Karakter Tersisa ---");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // ===== EKSPERIMEN: Object Reference =====
        System.out.println("\n--- Eksperimen Reference ---");

        Character asli = manager.findByName("Arjuna");
        Character duplikatReferensi = asli;             // menyalin REFERENSI, bukan membuat object baru

        System.out.println("Level Arjuna sebelum: " + asli.getLevel());
        duplikatReferensi.setLevel(99);                  // mengubah LEWAT variabel lain

        System.out.println("Level Arjuna sesudah (lewat 'asli'): " + asli.getLevel());
        System.out.println("asli == duplikatReferensi? " + (asli == duplikatReferensi));

        // Bandingkan dengan getAllCharacters() yang mengembalikan SALINAN LIST:
        java.util.ArrayList<Character> salinanList = manager.getAllCharacters();
        salinanList.add(new Character("Hantu", CharacterType.MAGE, 1));   // tambah ke SALINAN list

        System.out.println("Total di manager asli: " + manager.getTotalCharacters());
        System.out.println("Total di salinan list : " + salinanList.size());

        // Menghapus elemen dari salinan list
        salinanList.removeIf(c -> c.getName().equals("Merlin"));

        System.out.println("Total manager setelah hapus dari salinan: "
                + manager.getTotalCharacters());

        System.out.println("Total salinan setelah hapus Merlin: "
                + salinanList.size());

        CharacterManager managerKosong = new CharacterManager();
        System.out.println(
            "Rata-rata level list kosong: "
            + managerKosong.getAverageLevel()
        );

        // ==========================
        // BAGIAN B - MINI CHALLENGE
        // ==========================

            System.out.println("\n=== Mini-Challenge Part B ===");

            // Pengujian 1: Rata-rata level
            double rataRata = manager.getAverageLevel();
            System.out.println("Rata-rata level karakter: " + rataRata);

            // Pengujian 2: Pencarian berdasarkan tipe
            System.out.println("\nKarakter bertipe WARRIOR:");

            java.util.ArrayList<Character> warriors =
                    manager.findByType(CharacterType.WARRIOR);

            if (warriors.isEmpty()) {
                System.out.println("Tidak ada karakter bertipe WARRIOR.");
            } else {
                for (Character c : warriors) {
                    System.out.println(c);
                }
            }

            // Pengujian tambahan: tipe yang tidak tersedia
            System.out.println("\nKarakter bertipe HEALER:");

            java.util.ArrayList<Character> healers =
                    manager.findByType(CharacterType.HEALER);

            if (healers.isEmpty()) {
                System.out.println("Tidak ada karakter bertipe HEALER.");
            } else {
                for (Character c : healers) {
                    System.out.println(c);
                }
            }
    
    
        // ==========================
        // BAGIAN C - FITUR ANALITIK
        // ==========================

        System.out.println("\n=== Mini-Challenge Part C ===");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter dengan attack power tertinggi:");
            System.out.println(strongest);
            System.out.println("Attack Power: " + strongest.getAttackPower());
        } else {
            System.out.println("Belum ada karakter yang terdaftar.");
        }


    }
    
    
}