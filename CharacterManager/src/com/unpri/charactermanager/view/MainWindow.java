
package com.unpri.charactermanager.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    // Konstanta batas level untuk Mini-Challenge
    private static final int GOLD_LEVEL_THRESHOLD = 5;

    private JPanel mainPanel;
    private ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.4");

        this.characterList = characterList;

        initComponents();

        pack();
        setMinimumSize(new Dimension(420, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));

        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(AppTheme.CARD_BORDER);

        mainPanel.add(createTitleLabel());

        for (Character c : characterList) {
            mainPanel.add(createCharacterLabel(c));
        }

        add(mainPanel);
    }

    // Membuat judul aplikasi
    private JLabel createTitleLabel() {

        JLabel lbl = new JLabel(
            "Daftar Karakter (" + characterList.size() + ")",
            SwingConstants.CENTER
        );

        lbl.setFont(AppTheme.FONT_TITLE);
        lbl.setForeground(AppTheme.TEXT_MAIN);

        return lbl;
    }

    // Membuat kartu karakter
    private JLabel createCharacterLabel(Character c) {

        String info = c.getName()
                + " | " + c.getType()
                + " | Lv." + c.getLevel()
                + " | HP:" + c.getHitPoints()
                + " | ATK:" + c.getAttackPower();

        JLabel lbl = new JLabel(info);

        // MINI-CHALLENGE
        // Level 5 ke atas menggunakan teks emas dan tebal
        boolean highLevel =
                c.getLevel() >= GOLD_LEVEL_THRESHOLD;

        if (highLevel) {

            lbl.setFont(
                AppTheme.FONT_BODY.deriveFont(Font.BOLD)
            );

            lbl.setForeground(AppTheme.GOLD);

        } else {

            lbl.setFont(AppTheme.FONT_BODY);
            lbl.setForeground(AppTheme.TEXT_LIGHT);
        }

        // Warna kartu berdasarkan role
        lbl.setBackground(
            AppTheme.colorFor(c.getType())
        );

        lbl.setOpaque(true);

        // Border kartu dari AppTheme
        lbl.setBorder(AppTheme.CARD_BORDER);

        // PROPERTI TAMBAHAN 1
        // Tooltip berisi informasi lengkap karakter
        lbl.setToolTipText(
            "<html>"
            + "<b>" + c.getName() + "</b><br>"
            + "Role: " + c.getType() + "<br>"
            + "Level: " + c.getLevel() + "<br>"
            + "HP: " + c.getHitPoints() + "<br>"
            + "ATK: " + c.getAttackPower()
            + "</html>"
        );

        // PROPERTI TAMBAHAN 2
        // Karakter level 1 dibuat nonaktif
        lbl.setEnabled(c.getLevel() != 1);

        // Cursor berbeda ketika diarahkan ke kartu
        lbl.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        return lbl;
    }
}
