
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Menyiapkan data karakter
        CharacterManager manager = new CharacterManager();

        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        // Mengambil data dan statistik dari Model
        var characterList = manager.getAllCharacters();
        double averageLevel = manager.getAverageLevel();

        // Menjalankan GUI di Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(characterList, averageLevel);
            window.setVisible(true);
        });
    }
}
