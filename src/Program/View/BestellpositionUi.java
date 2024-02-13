package Program.View;

import javax.swing.*;
import java.awt.*;

public class BestellpositionUi extends JDialog {

    private BestellungsUi bestellungsUi;
    private boolean isEmpty;

    // UI

    // labels
    private JLabel computerLabel;
    private JLabel preisInfoLabel;
    private JLabel preisLabel;
    private JLabel stueckzahlInfoLabel;
    private JLabel stueckzahlLabel;

    // combobox

    private JComboBox computerCombobox;

    // buttons
    private JButton saveButton;
    private JButton deleteButton;
    private JButton abbrechenbutton;

    // panels
    private JPanel buttonPanel;
    private JPanel mainPanel;

    public BestellpositionUi (BestellungsUi bestellungsUi, boolean isEmpty) {

        super(bestellungsUi, "kundenView", true);

        this.isEmpty = isEmpty;
        this.bestellungsUi = bestellungsUi;

        init();

    }

    public void init(){

        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 250));
        setLayout(new BorderLayout());

        computerCombobox = new JComboBox();
        computerLabel = new JLabel("Computer:");
        preisLabel = new JLabel("Preis:");
        preisInfoLabel = new JLabel("");
        stueckzahlLabel = new JLabel("Stückzahl:");
        stueckzahlInfoLabel = new JLabel("");

        saveButton = new JButton("speichern");
        deleteButton = new JButton("löschen");
        abbrechenbutton = new JButton("abbrechen");

        buttonPanel = new JPanel();
        mainPanel = new JPanel(new GridLayout(6, 1));

        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(abbrechenbutton);

        mainPanel.add(computerLabel);
        mainPanel.add(computerCombobox);
        mainPanel.add(preisLabel);
        mainPanel.add(preisInfoLabel);
        mainPanel.add(stueckzahlLabel);
        mainPanel.add(stueckzahlInfoLabel);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }
}
