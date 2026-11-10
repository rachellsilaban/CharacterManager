import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 1. Siapkan data karakter
        CharacterManager manager = new CharacterManager();

        // Main.java: 8 karakter agar scrollbar benar-benar teruji
        manager.addCharacter(new Character("Arjuna",    CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin",    CharacterType.MAGE,    3));
        manager.addCharacter(new Character("Athena",    CharacterType.ARCHER,  4));
        manager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 7));
        manager.addCharacter(new Character("Morgana",   CharacterType.MAGE,    1));
        manager.addCharacter(new Character("Artemis",   CharacterType.ARCHER,  6));
        manager.addCharacter(new Character("Bima",      CharacterType.WARRIOR, 8));
        manager.addCharacter(new Character("Circe",     CharacterType.MAGE,    2));
        // 2. Ambil data dan hitung statistik
        ArrayList<Character> characters = manager.getAllCharacters();

        // 3. Tampilkan jendela aplikasi
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(characters);

            window.setVisible(true);
        });
    }
}

