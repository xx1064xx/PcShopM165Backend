package Program.View;

import Program.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainUi extends JFrame {

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

    // lists
    private JList<String> kundenList;
    private JList<String> computerList;
    private JList<String> bestellungsList;

    // panels
    private JPanel mainPanel;
    private JPanel kundenPanel;
    private JPanel computerPanel;
    private JPanel bestellungsPanel;

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

        init();

    }

    public void init() {
        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
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

        kundenAddButton = new JButton("Neuer Kunde");
        computerAddButton = new JButton("Neuer Computer");
        bestellungsAddButton = new JButton("Neue Bestellung");

        kundenPanel.add(kundenListScrollPane, BorderLayout.CENTER);
        kundenPanel.add(kundenAddButton, BorderLayout.SOUTH);

        computerPanel.add(computerListScrollPane, BorderLayout.CENTER);
        computerPanel.add(computerAddButton, BorderLayout.SOUTH);

        bestellungsPanel.add(bestellungsListScrollPane, BorderLayout.CENTER);
        bestellungsPanel.add(bestellungsAddButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Kunden", kundenPanel);
        tabbedPane.addTab("Computer", computerPanel);
        tabbedPane.addTab("Bestellungen", bestellungsPanel);

        add(tabbedPane, BorderLayout.CENTER);

        addActionListener();
        addMouseListener();

        setVisible(true);
    }

    // eventlisteners

    public void addActionListener() {

        kundenAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                kundenUi = new KundenUi(mainUi);

            }
        });

        computerAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                computerUi = new ComputerUi(mainUi);

            }
        });

        bestellungsAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                bestellungsUi = new BestellungsUi(mainUi);

            }
        });

    }

    public void addMouseListener() {
        kundenList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    System.out.println("doppelklick");

                }
            }
        });

        computerList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    System.out.println("doppelklick");

                }
            }
        });

        bestellungsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    System.out.println("doppelklick");

                }
            }
        });
    }


}
