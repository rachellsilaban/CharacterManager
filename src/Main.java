
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");

        // Membuat 3 object Character menggunakan constructor pertama
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        Character wizard = new Character("Merlin", CharacterType.MAGE, 3);
        Character scout = new Character("Athena", CharacterType.ARCHER, 4);

        // Menampilkan ketiganya menggunakan toString()
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");

        hero.setLevel(hero.getLevel() + 1);

        // HP dan Attack dihitung ulang otomatis
        System.out.println("After level up: " + hero);

        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());


        // =====================================
        // MINI-CHALLENGE TP03
        // =====================================

        System.out.println();
        System.out.println("=== MINI-CHALLENGE TP03 ===");

        // Membuat satu karakter baru
        Character newHero = new Character(
            "Rachel",
            CharacterType.MAGE,
            5
        );

        // Mengatur nilai mana
        newHero.setMana(80);

        // Menampilkan nilai mana menggunakan getter
        System.out.println(">> Mana karakter: " + newHero.getMana());

        // Menampilkan informasi lengkap karakter
        System.out.println(newHero);

        // Menguji method isAlive()
        System.out.println(
            ">> Apakah karakter masih hidup? " + newHero.isAlive()
        );

    }
}
