package Program.View;

import Program.Repository.Bestellposition;
import Program.Repository.Computer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BestellpositionUi extends JDialog {

    private BestellungsUi bestellungsUi;
    private boolean isEmpty;

    // UI

    // labels
    private JLabel computerLabel;
    private JLabel preisInfoLabel;
    private JLabel preisLabel;
    private JSpinner stueckzahlSpinner;
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

        setTitle("Bestellpositionen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(425, 250));
        setLayout(new BorderLayout());

        computerCombobox = new JComboBox(getAllComputer());
        computerLabel = new JLabel("Computer:");
        preisLabel = new JLabel("Preis:");
        preisInfoLabel = new JLabel(String.valueOf(updatePrice()));
        stueckzahlLabel = new JLabel("Stückzahl:");
        stueckzahlSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

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
        mainPanel.add(stueckzahlSpinner);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addActionListener();

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

    private void addActionListener() {
        computerCombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                preisInfoLabel.setText(String.valueOf(updatePrice()));

            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                int selectedIndex = computerCombobox.getSelectedIndex();
                Computer computer = bestellungsUi.getComputerByIndex(selectedIndex);

                Bestellposition bestellposition = new Bestellposition(
                    computer,
                        computer.getEinzelpreis(),
                        (int) stueckzahlSpinner.getValue()
                );

                bestellungsUi.addToBestellpositionenList(bestellposition);

            }
        });

    }

    private String[] getAllComputer() {

        ArrayList<Computer> computers = bestellungsUi.getAllComputer();
        String[] computerArray = new String[computers.size()];

        for (int i = 0; i < computers.size(); i++) {
            Computer computer = computers.get(i);
            String hersteller = computer.getHersteller();
            String modell = computer.getModell();
            computerArray[i] = hersteller + " " + modell;
        }

        return computerArray;

    }

    private double updatePrice() {

        int selectedIndex = computerCombobox.getSelectedIndex();

        double price = bestellungsUi.getPrice(selectedIndex);


        return price;
    }

}
