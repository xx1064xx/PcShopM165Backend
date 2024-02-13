package Program.View;

import javax.swing.*;
import java.awt.*;

public class KundenUi extends JDialog {

    private MainUi mainUi;
    private boolean isEmpty;

    // UI

    // Textfelder
    private JTextField geschlechtField;
    private JTextField nachnameField;
    private JTextField vornameField;
    private JTextField strasseField;
    private JTextField plzField;
    private JTextField ortField;
    private JTextField telefonField;
    private JTextField emailField;
    private JTextField spracheField;
    private JTextField geburtsdatumField;

    // Labels
    private JLabel geschlechtLabel;
    private JLabel nachnameLabel;
    private JLabel vornameLabel;
    private JLabel strasseLabel;
    private JLabel plzLabel;
    private JLabel ortLabel;
    private JLabel telefonLabel;
    private JLabel emailLabel;
    private JLabel spracheLabel;
    private JLabel geburtsdatumLabel;

    // Buttons
    private JButton speichernButton;
    private JButton abbrechenButton;
    private JButton deleteButton;

    // panels

    private JPanel buttonPanel;
    private JPanel mainPanel;

    public KundenUi (MainUi mainUi, boolean isEmpty) {

        super(mainUi, "kundenView", true);

        this.mainUi = mainUi;
        this.isEmpty = isEmpty;

        init();

    }

    public void init() {

        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 500));
        setLayout(new BorderLayout());

        // Textfelder initialisieren
        geschlechtField = new JTextField();
        nachnameField = new JTextField();
        vornameField = new JTextField();
        strasseField = new JTextField();
        plzField = new JTextField();
        ortField = new JTextField();
        telefonField = new JTextField();
        emailField = new JTextField();
        spracheField = new JTextField();
        geburtsdatumField = new JTextField();

        // Labels initialisieren
        geschlechtLabel = new JLabel("Geschlecht:");
        nachnameLabel = new JLabel("Nachname:");
        vornameLabel = new JLabel("Vorname:");
        strasseLabel = new JLabel("Strasse:");
        plzLabel = new JLabel("PLZ:");
        ortLabel = new JLabel("Ort:");
        telefonLabel = new JLabel("Telefon:");
        emailLabel = new JLabel("E-Mail:");
        spracheLabel = new JLabel("Sprache:");
        geburtsdatumLabel = new JLabel("Geburtsdatum:");

        // Buttons initialisieren
        speichernButton = new JButton("Speichern");
        abbrechenButton = new JButton("Abbrechen");
        deleteButton = new JButton("löschen");

        buttonPanel = new JPanel();
        mainPanel = new JPanel(new GridLayout(20, 1));

        buttonPanel.add(speichernButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(abbrechenButton);

        mainPanel.add(nachnameLabel);
        mainPanel.add(nachnameField);
        mainPanel.add(vornameLabel);
        mainPanel.add(vornameField);
        mainPanel.add(geschlechtLabel);
        mainPanel.add(geschlechtField);
        mainPanel.add(strasseLabel);
        mainPanel.add(strasseField);
        mainPanel.add(plzLabel);
        mainPanel.add(plzField);
        mainPanel.add(ortLabel);
        mainPanel.add(ortField);
        mainPanel.add(telefonLabel);
        mainPanel.add(telefonField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(spracheLabel);
        mainPanel.add(spracheField);
        mainPanel.add(geburtsdatumLabel);
        mainPanel.add(geburtsdatumField);



        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

}
