package Program.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestellungsUi extends JDialog {

    private MainUi mainUi;
    private BestellungsUi bestellungsUi;
    private BestellpositionUi bestellpositionUi;
    private boolean isEmpty;

    // UI

    // Textfelder
    private JTextField dateField;
    private JTextField kundenField;
    private JTextField totalField;

    // Labels
    private JLabel dateLabel;
    private JLabel kundenLabel;
    private JLabel totalLabel;

    // Buttons
    private JButton speichernButton;
    private JButton abbrechenButton;
    private JButton deleteButton;
    private JButton bestellpositionAddButton;
    private JButton bestellpositionDeleteButton;

    // panels
    private JPanel buttonPanel;
    private JPanel computerPanel;
    private JPanel bestellpositionenPanel;
    private JPanel bestellpositionenButtonPanel;

    // lists
    private JList<String> bestellpositionenList;

    // listmodels
    private DefaultListModel<String> bestellpositionenListModel;

    // tabbedpanes
    private JTabbedPane tabbedPane;
    public BestellungsUi (MainUi mainUi, boolean isEmpty) {

        super(mainUi, "kundenView", true);

        this.mainUi = mainUi;
        this.bestellungsUi = this;
        this.isEmpty = isEmpty;

        init();

    }

    public void init() {

        setTitle("Bestellungen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 250));
        setLayout(new BorderLayout());

        dateField = new JTextField();
        kundenField = new JTextField();
        totalField = new JTextField();

        dateLabel = new JLabel("Bestelldatum:");
        kundenLabel = new JLabel("Kunde:");
        totalLabel = new JLabel("Total:");

        bestellpositionenListModel = new DefaultListModel<>();

        bestellpositionenList = new JList<>(bestellpositionenListModel);

        bestellpositionenButtonPanel = new JPanel();


        tabbedPane = new JTabbedPane();

        computerPanel = new JPanel(new GridLayout(6, 1));

        bestellpositionenPanel = new JPanel(new BorderLayout());

        tabbedPane.add("Bestellung", computerPanel);
        tabbedPane.add("Bestellposition", bestellpositionenPanel);



        buttonPanel = new JPanel();

        speichernButton = new JButton("Speichern");
        abbrechenButton = new JButton("Abbrechen");
        deleteButton = new JButton("löschen");
        bestellpositionAddButton = new JButton("neue Position");
        bestellpositionDeleteButton = new JButton("Position löschen");

        buttonPanel.add(speichernButton);
        if (!isEmpty){
            buttonPanel.add(deleteButton);
        }
        buttonPanel.add(abbrechenButton);

        bestellpositionenButtonPanel.add(bestellpositionAddButton);
        bestellpositionenButtonPanel.add(bestellpositionDeleteButton);

        bestellpositionenPanel.add(bestellpositionenList, BorderLayout.CENTER);
        bestellpositionenPanel.add(bestellpositionenButtonPanel, BorderLayout.SOUTH);

        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        computerPanel.add(dateLabel);
        computerPanel.add(dateField);
        computerPanel.add(kundenLabel);
        computerPanel.add(kundenField);
        computerPanel.add(totalLabel);
        computerPanel.add(totalField);


        addActionListener();

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public void addActionListener() {
        bestellpositionAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                bestellpositionUi = new BestellpositionUi(bestellungsUi, true);

            }
        });
    }

}
