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
    private Bestellposition bestellposition;
    private boolean isEmpty;
    private String[] computerArray;

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
    private JButton abbrechenbutton;

    // panels
    private JPanel buttonPanel;
    private JPanel mainPanel;

    public BestellpositionUi (BestellungsUi bestellungsUi, boolean isEmpty, Bestellposition bestellposition) {

        super(bestellungsUi, "kundenView", true);

        this.isEmpty = isEmpty;
        this.bestellposition = bestellposition;
        this.bestellungsUi = bestellungsUi;

        init();

    }

    public void init(){

        setTitle("Bestellpositionen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(425, 250));
        setLayout(new BorderLayout());

        computerArray = getAllComputer();

        computerCombobox = new JComboBox(computerArray);
        computerLabel = new JLabel("Computer:");
        preisLabel = new JLabel("Preis:");
        preisInfoLabel = new JLabel(String.valueOf(updatePrice()));
        stueckzahlLabel = new JLabel("Stückzahl:");
        stueckzahlSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        saveButton = new JButton("speichern");
        abbrechenbutton = new JButton("abbrechen");

        buttonPanel = new JPanel();
        mainPanel = new JPanel(new GridLayout(6, 1));

        buttonPanel.add(saveButton);
        buttonPanel.add(abbrechenbutton);

        mainPanel.add(computerLabel);
        mainPanel.add(computerCombobox);
        mainPanel.add(preisLabel);
        mainPanel.add(preisInfoLabel);
        mainPanel.add(stueckzahlLabel);
        mainPanel.add(stueckzahlSpinner);

        if(!isEmpty) {
            renderBestellposition();
        }

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

                if (isEmpty) {
                    int selectedIndex = computerCombobox.getSelectedIndex();
                    Computer computer = bestellungsUi.getComputerByIndex(selectedIndex);

                    Bestellposition bestellposition = new Bestellposition(
                            computer,
                            computer.getEinzelpreis(),
                            (int) stueckzahlSpinner.getValue()
                    );

                    bestellungsUi.addToBestellpositionenList(bestellposition);
                } else {

                    Computer computer = bestellungsUi.getComputerByIndex(computerCombobox.getSelectedIndex());

                    bestellposition.setComputer(computer);
                    bestellposition.setPreis(computer.getEinzelpreis());
                    bestellposition.setStueckzahl((int) stueckzahlSpinner.getValue());

                    bestellungsUi.updateBestellposition(bestellposition);
                }

                bestellungsUi.updateTotalPrice();


            }
        });

        abbrechenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });


    }

    private void renderBestellposition() {

        Computer computer = bestellposition.getComputer();
        int anzahl = bestellposition.getStueckzahl();

        String hersteller = computer.getHersteller();
        String modell = computer.getModell();

        String computerComboboxContent = hersteller + " " + modell;

        computerCombobox.setSelectedItem(computerComboboxContent);
        stueckzahlSpinner.setValue(anzahl);


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
