package Program.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerUi extends JDialog {

    private MainUi mainUi;
    private ComputerUi computerUi;
    private SchnittstellenSelektor schnittstellenSelektor;
    private boolean isEmpty;

    // UI

    // Textfelder
    private JTextField herstellerField;
    private JTextField modellField;
    private JTextField arbeitsspeicherField;
    private JTextField cpuField;
    private JTextField massenspeicherField;
    private JTextField typField;
    private JTextField einzelpreisField;

    // Labels
    private JLabel herstellerLabel;
    private JLabel modellLabel;
    private JLabel arbeitsspeicherLabel;
    private JLabel cpuLabel;
    private JLabel massenspeicherLabel;
    private JLabel typLabel;
    private JLabel einzelpreisLabel;

    // Buttons
    private JButton speichernButton;
    private JButton abbrechenButton;
    private JButton deleteButton;
    private JButton schnittstelleAddButton;
    private JButton schnittstelleDeleteButton;

    // panels
    private JPanel buttonPanel;
    private JPanel computerPanel;
    private JPanel schnittstellenPanel;
    private JPanel schnittstellenButtonPanel;

    // lists
    private JList<String> schnittstellenList;

    // listmodels
    private DefaultListModel<String> schnittstellenListModel;

    // tabbedpanes
    private JTabbedPane tabbedPane;

    public ComputerUi (MainUi mainUi, boolean isEmpty) {

        super(mainUi, "kundenView", true);

        this.mainUi = mainUi;
        this.computerUi = this;
        this.isEmpty = isEmpty;

        init();

    }

    public void init() {

        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 500));
        setLayout(new BorderLayout());

        herstellerField = new JTextField();
        modellField = new JTextField();
        arbeitsspeicherField = new JTextField();
        cpuField = new JTextField();
        massenspeicherField = new JTextField();
        typField = new JTextField();
        einzelpreisField = new JTextField();

        herstellerLabel = new JLabel("Hersteller:");
        modellLabel = new JLabel("Modell:");
        arbeitsspeicherLabel = new JLabel("Arbeitsspeicher:");
        cpuLabel = new JLabel("Cpu:");
        massenspeicherLabel = new JLabel("Massenspeicher:");
        typLabel = new JLabel("Typ:");
        einzelpreisLabel = new JLabel("Einzelpreis");

        schnittstellenListModel = new DefaultListModel<>();

        schnittstellenList = new JList<>(schnittstellenListModel);

        schnittstellenButtonPanel = new JPanel();


        tabbedPane = new JTabbedPane();

        computerPanel = new JPanel(new GridLayout(14, 1));

        schnittstellenPanel = new JPanel(new BorderLayout());

        tabbedPane.add("Computer", computerPanel);
        tabbedPane.add("Schnittstellen", schnittstellenPanel);



        buttonPanel = new JPanel();

        speichernButton = new JButton("Speichern");
        abbrechenButton = new JButton("Abbrechen");
        deleteButton = new JButton("löschen");
        schnittstelleAddButton = new JButton("neue Schnittstelle");
        schnittstelleDeleteButton = new JButton("Schnittstelle löschen");

        buttonPanel.add(speichernButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(abbrechenButton);

        schnittstellenButtonPanel.add(schnittstelleAddButton);
        schnittstellenButtonPanel.add(schnittstelleDeleteButton);

        schnittstellenPanel.add(schnittstellenList, BorderLayout.CENTER);
        schnittstellenPanel.add(schnittstellenButtonPanel, BorderLayout.SOUTH);

        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        computerPanel.add(herstellerLabel);
        computerPanel.add(herstellerField);
        computerPanel.add(modellLabel);
        computerPanel.add(modellField);
        computerPanel.add(arbeitsspeicherLabel);
        computerPanel.add(arbeitsspeicherField);
        computerPanel.add(cpuLabel);
        computerPanel.add(cpuField);
        computerPanel.add(massenspeicherLabel);
        computerPanel.add(massenspeicherField);
        computerPanel.add(typLabel);
        computerPanel.add(typField);
        computerPanel.add(einzelpreisLabel);
        computerPanel.add(einzelpreisField);


        addActionListener();

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public void addActionListener() {
        schnittstelleAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                schnittstellenSelektor = new SchnittstellenSelektor(computerUi);

            }
        });
    }

}
