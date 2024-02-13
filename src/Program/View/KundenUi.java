package Program.View;

import Program.Repository.Adresse;
import Program.Repository.Kunde;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KundenUi extends JDialog {

    private MainUi mainUi;
    private boolean isEmpty;

    // UI

    // Textfelder
    private JComboBox geschlechtCombobox;
    private JTextField nachnameField;
    private JTextField vornameField;
    private JTextField strasseField;
    private JTextField plzField;
    private JTextField ortField;
    private JTextField telefonField;
    private JTextField emailField;
    private JComboBox spracheComboBox;
    private JFormattedTextField geburtsdatumFormattedField;

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

        String[] genders = {
                "Mann", "Frau", "Anderes", "Agender", "Androgyn", "Androgyn", "Bigender", "Cis", "Cisgeschlechtlich",
                "Cisgeschlechtlich", "Cisgeschlechtlich", "Cisgeschlechtlich", "Cisgeschlechtlich", "Cisgeschlechtlich",
                "Cisgeschlechtlich", "Weiblich zu Männlich", "FTM", "Geschlechterfluid", "Geschlechtsnonkonform",
                "Geschlechtsfragestellend", "Geschlechtsvariant", "Geschlechtsqueer", "Intersex", "Männlich zu Weiblich",
                "MTF", "Weder", "Neutrois", "Nicht-binär", "Pangender", "Trans", "Trans", "Trans Frau", "Trans Frau",
                "Trans Mann", "Trans Mann", "Trans Person", "Trans Person", "Trans Frau", "Trans Frau", "Transfeminin",
                "Transgender", "Transgender Frau", "Transgender Mann", "Transgender Mann", "Transgender Person", "Transgender Frau",
                "Transmaskulin", "Transsexuell", "Transsexuelle Frau", "Transsexueller Mann", "Transsexueller Mann",
                "Transsexuelle Person", "Transsexuelle Frau"
        };

        String[] languages = {
                "Englisch", "Spanisch", "Chinesisch (Mandarin)", "Hindi", "Französisch", "Bengalisch", "Russisch", "Portugiesisch",
                "Urdu", "Indonesisch", "Deutsch", "Japanisch", "Swahili", "Marathi", "Telugu", "Türkisch", "Koreanisch", "Tamil",
                "Gujarati", "Polnisch", "Vietnamesisch", "Ukrainisch", "Malaiisch", "Persisch", "Kantonesisch", "Paschtu", "Hausa",
                "Thai", "Punjabi", "Swedisch", "Oriya", "Niederländisch", "Javanisch", "Bhojpuri", "Filipino", "Yoruba", "Xhosa",
                "Nepali", "Sindhi", "Igbo", "Maithili", "Amharisch", "Uigurisch", "Fulfulde", "Oromo", "Rumänisch", "Burmese",
                "Azerbaijani", "Cebuano"
        };

        try {

            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");

            dateFormatter.setPlaceholderCharacter('_');

            geburtsdatumFormattedField = new JFormattedTextField(dateFormatter);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        geschlechtCombobox = new JComboBox(genders);
        nachnameField = new JTextField();
        vornameField = new JTextField();
        strasseField = new JTextField();
        plzField = new JTextField();
        ortField = new JTextField();
        telefonField = new JTextField();
        emailField = new JTextField();
        spracheComboBox = new JComboBox(languages);

        // sorgt dafür, dass in einem Textfeld nurnoch int geschrieben können
        ((AbstractDocument) plzField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        geschlechtLabel = new JLabel("Geschlecht:");
        nachnameLabel = new JLabel("Nachname:");
        vornameLabel = new JLabel("Vorname:");
        strasseLabel = new JLabel("Strasse:");
        plzLabel = new JLabel("PLZ:");
        ortLabel = new JLabel("Ort:");
        telefonLabel = new JLabel("Telefon:");
        emailLabel = new JLabel("E-Mail:");
        spracheLabel = new JLabel("Sprache:");
        geburtsdatumLabel = new JLabel("Geburtsdatum: (yyyy-MM-dd)");

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
        mainPanel.add(geschlechtCombobox);
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
        mainPanel.add(spracheComboBox);
        mainPanel.add(geburtsdatumLabel);
        mainPanel.add(geburtsdatumFormattedField);



        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addActionListener();

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public void addActionListener() {

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                readDataFromUi();
                dispose();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void readDataFromUi() {

        try {
            int plz = Integer.parseInt(plzField.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(geburtsdatumFormattedField.getText());

            Adresse adresse = new Adresse(
                    strasseField.getText(),
                    plz,
                    ortField.getText()
            );

            Kunde kunde = new Kunde(
                    (String) geschlechtCombobox.getSelectedItem(),
                    nachnameField.getText(),
                    vornameField.getText(),
                    adresse,
                    telefonField.getText(),
                    emailField.getText(),
                    (String) spracheComboBox.getSelectedItem(),
                    date
            );

            mainUi.addNewKunde(kunde);

        } catch (NumberFormatException | ParseException e) {
            System.err.println(e.getMessage());
        }

    }

}
