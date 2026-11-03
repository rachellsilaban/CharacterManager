


package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    public MainWindow(
            ArrayList<Character> characterList,
            double averageLevel) {

        super("Character Manager v0.3");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel();

        mainPanel.setLayout(
            new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Judul daftar karakter
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ==="
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(titleLabel);

        // Tampilkan setiap karakter
        for (Character c : characterList) {

            String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);

            mainPanel.add(characterLabel);
        }

        // JLabel statistik di bagian bawah daftar
        JLabel averageLabel = new JLabel(
            String.format(
                java.util.Locale.US,
                "Rata-rata Level: %.1f",
                averageLevel
            )
        );

        averageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Beri jarak sebelum statistik
        mainPanel.add(
            javax.swing.Box.createVerticalStrut(15)
        );

        mainPanel.add(averageLabel);

        add(mainPanel);
    }
}


