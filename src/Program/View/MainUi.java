package Program.View;

import Program.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainUi extends JFrame {

    private Controller controller;
    private KundenUi kundenUi;

    // UI

    // buttons
    private JButton kundenButton;
    private JButton computerButton;
    private JButton bestellungsButton;

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

    public MainUi(Controller controller) {


        this.controller = controller;

        init();

    }

    public void init() {
        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        kundenPanel = createPanelWithList("Kunden", kundenButton, kundenList);
        computerPanel = createPanelWithList("Computer", computerButton, computerList);
        bestellungsPanel = createPanelWithList("Bestellungen", bestellungsButton, bestellungsList);

        tabbedPane.addTab("Kunden", kundenPanel);
        tabbedPane.addTab("Computer", computerPanel);
        tabbedPane.addTab("Bestellungen", bestellungsPanel);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createPanelWithList(String title, JButton jButton, JList jList) {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        jList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(jList);
        jButton = new JButton("Add " + title);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(jButton, BorderLayout.SOUTH);

        jButton.addActionListener(e -> {
            String newItem = JOptionPane.showInputDialog(this, "Enter new " + title);
            if (newItem != null && !newItem.isEmpty()) {
                listModel.addElement(newItem);
            }
        });

        JList finalJList = jList;
        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = finalJList.locationToIndex(e.getPoint());
                    String item = listModel.getElementAt(index);
                    listModel.addElement(item);
                }
            }
        });

        return panel;
    }


;
}
