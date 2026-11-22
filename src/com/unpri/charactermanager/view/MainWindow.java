
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    public MainWindow(ArrayList<Character> characterList, double averageLevel) {
        super("Character Manager v0.4");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel();

        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ==="
        );
        mainPanel.add(titleLabel);

        for (Character c : characterList) {
            String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);
            mainPanel.add(characterLabel);
        }

        // Menampilkan statistik rata-rata level
        JLabel averageLabel = new JLabel(
            String.format("Rata-rata Level: %.1f", averageLevel)
        );
        mainPanel.add(averageLabel);

        add(mainPanel);
    }
}
