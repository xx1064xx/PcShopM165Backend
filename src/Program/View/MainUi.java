package Program.View;

import Program.Controller.Controller;
import Program.Repository.Bestellung;
import Program.Repository.Computer;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainUi extends JFrame {

    private int selectedKundenIndex;
    private int selectedComputerIndex;
    private int selectedBestellungsIndex;
    private Controller controller;
    private MainUi mainUi;
    private KundenUi kundenUi;
    private ComputerUi computerUi;
    private BestellungsUi bestellungsUi;

    // UI

    // buttons
    private JButton kundenAddButton;
    private JButton computerAddButton;
    private JButton bestellungsAddButton;
    private JButton kundenEditButton;
    private JButton computerEditButton;
    private JButton bestellungsEditButton;

    // lists
    private JList<String> kundenList;
    private JList<String> computerList;
    private JList<String> bestellungsList;

    // panels
    private JPanel kundenPanel;
    private JPanel computerPanel;
    private JPanel bestellungsPanel;
    private JPanel kundenButtonPanel;
    private JPanel computerButtonPanel;
    private JPanel bestellungsButtonPanel;
    // tabbedpane
    private JTabbedPane tabbedPane;

    // scrollpanes
    private JScrollPane kundenListScrollPane;
    private JScrollPane computerListScrollPane;
    private JScrollPane bestellungsListScrollPane;

    // listmodels
    private DefaultListModel<String> kundenListModel;
    private DefaultListModel<String> computerListModel;
    private DefaultListModel<String> bestellungsListModel;


    // functions

    public MainUi(Controller controller) {

        this.controller = controller;
        this.mainUi = this;

        controller.readAllKunden();
        controller.readAllComputer();
        controller.readAllBestellungen();

        init();

    }

    public void init() {
        setTitle("Verwaltung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMinimumSize(new Dimension(425, 500));

        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        kundenPanel = new JPanel(new BorderLayout());
        computerPanel = new JPanel(new BorderLayout());
        bestellungsPanel = new JPanel(new BorderLayout());

        kundenListModel = new DefaultListModel<>();
        computerListModel = new DefaultListModel<>();
        bestellungsListModel = new DefaultListModel<>();

        kundenList = new JList<>(kundenListModel);
        computerList = new JList<>(computerListModel);
        bestellungsList = new JList<>(bestellungsListModel);

        kundenListScrollPane = new JScrollPane(kundenList);
        computerListScrollPane = new JScrollPane(computerList);
        bestellungsListScrollPane = new JScrollPane(bestellungsList);

        kundenButtonPanel = new JPanel();
        computerButtonPanel = new JPanel();
        bestellungsButtonPanel = new JPanel();

        kundenAddButton = new JButton("Neuer Kunde");
        computerAddButton = new JButton("Neuer Computer");
        bestellungsAddButton = new JButton("Neue Bestellung");

        kundenEditButton = new JButton("Kunde bearbeiten");
        computerEditButton = new JButton("Computer bearbeiten");
        bestellungsEditButton = new JButton("Bestellung bearbeiten");

        kundenButtonPanel.add(kundenAddButton);
        kundenButtonPanel.add(kundenEditButton);

        computerButtonPanel.add(computerAddButton);
        computerButtonPanel.add(computerEditButton);

        bestellungsButtonPanel.add(bestellungsAddButton);
        bestellungsButtonPanel.add(bestellungsEditButton);

        kundenPanel.add(kundenListScrollPane, BorderLayout.CENTER);
        kundenPanel.add(kundenButtonPanel, BorderLayout.SOUTH);

        computerPanel.add(computerListScrollPane, BorderLayout.CENTER);
        computerPanel.add(computerButtonPanel, BorderLayout.SOUTH);

        bestellungsPanel.add(bestellungsListScrollPane, BorderLayout.CENTER);
        bestellungsPanel.add(bestellungsButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Kunden", kundenPanel);
        tabbedPane.addTab("Computer", computerPanel);
        tabbedPane.addTab("Bestellungen", bestellungsPanel);

        add(tabbedPane, BorderLayout.CENTER);

        addActionListener();

        updateAllKunden();
        updateAllComputer();
        updateAllBestellungen();

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    // eventlisteners

    public void addActionListener() {

        kundenAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                kundenUi = new KundenUi(mainUi, true, null, -1);

            }
        });

        computerAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                computerUi = new ComputerUi(mainUi, true, null, -1);

            }
        });

        bestellungsAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                bestellungsUi = new BestellungsUi(mainUi, true, null, -1);

            }
        });

        kundenEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedKundenIndex = kundenList.getSelectedIndex();

                if (selectedKundenIndex < 0) {
                    System.out.println("kein Kunde ausgewählt");
                } else {

                    Kunde kunde = controller.getKundeByIndex(selectedKundenIndex);

                    kundenUi = new KundenUi(mainUi, false, kunde, selectedKundenIndex);

                }
            }
        });

        computerEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedComputerIndex = computerList.getSelectedIndex();

                if (selectedComputerIndex < 0) {
                    System.out.println("kein Computer ausgewählt");
                } else {

                    Computer computer = controller.getComputerByIndex(selectedComputerIndex);

                    computerUi = new ComputerUi(mainUi, false, computer, selectedComputerIndex);

                }

            }
        });

        bestellungsEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedBestellungsIndex = bestellungsList.getSelectedIndex();

                if (selectedBestellungsIndex < 0) {
                    System.out.println("keine Bestellung ausgewählt");
                } else {

                    Bestellung bestellung = controller.getBestellungByIndex(selectedBestellungsIndex);

                    bestellungsUi = new BestellungsUi(mainUi, false, bestellung, selectedBestellungsIndex);

                }

            }
        });

    }

    public ArrayList<Kunde> getAllKunden() {

        ArrayList<Kunde> kunden = controller.getAllKunden();

        return kunden;

    }

    public ArrayList<Computer> getAllComputer() {

        ArrayList<Computer> computers = controller.getAllComputer();

        return computers;

    }

    // kunden

    public void addNewKunde(Kunde kunde) {
        controller.addNewKunde(kunde);
    }
    public void updateKunde(Kunde kunde) {
        controller.updateKunde(kunde);
    }
    public void deleteKunde(ObjectId kundenId) {
        controller.deleteKunde(kundenId);
    }

    public Kunde getKundeByIndex(int index) {
        Kunde kunde = controller.getKundeByIndex(index);
        return kunde;
    }

    public void updateAllKunden() {

        kundenListModel.removeAllElements();

        for (Kunde kunde : controller.getAllKunden()){
            String eintrag = kunde.getVorname() + " " + kunde.getNachname();
            kundenListModel.addElement(eintrag);
        }

        kundenList.setModel(kundenListModel);

    }



    // computer
    public void updateAllComputer() {

        computerListModel.removeAllElements();

        for (Computer computer : controller.getAllComputer()){
            String eintrag = computer.getHersteller() + " " + computer.getModell();
            computerListModel.addElement(eintrag);
        }

        computerList.setModel(computerListModel);

    }



    public Computer getComputerByIndex(int index) {
        Computer computer = controller.getComputerByIndex(index);
        return computer;
    }

    public void addNewComputer(Computer computer) {
        controller.addNewComputer(computer);
    }
    public void deleteComputer(ObjectId computerId) {
        controller.deleteComputer(computerId);
    }
    public void updateComputer(Computer computer) {
        controller.updateComputer(computer);
    }


    // bestellungen

    public void addNewBestellung(Bestellung bestellung) {
        controller.addNewBestellung(bestellung);
    }

    public void updateAllBestellungen() {

        bestellungsListModel.removeAllElements();

        for (Bestellung bestellung : controller.getAllBestellungen()){

            Kunde kunde = bestellung.getKunde();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String bestellDatum = dateFormat.format(bestellung.getBestelldatum());


            String eintrag = kunde.getVorname() + " " + kunde.getNachname() + " | " + bestellDatum;

            bestellungsListModel.addElement(eintrag);
        }

        bestellungsList.setModel(bestellungsListModel);

    }

}
