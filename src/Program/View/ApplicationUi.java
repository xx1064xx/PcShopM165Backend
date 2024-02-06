package Program.View;

import Program.Controller.Controller;
import Program.Repository.Adresse;
import Program.Repository.Bestellung;
import Program.Repository.Kunde;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationUi extends JFrame {
    private JTabbedPane TabPane;
    private JPanel mainPanel;
    private JList computerList;
    private JList kundenList;
    private JList bestellungsList;
    private JTabbedPane bestellungTab;
    private JTextField bestellungBestellnummerField;
    private JButton newButtonBestellung;
    private JButton deleteButtonBestellung;
    private JButton saveButtonBestellung;
    private JTextField bestellungBestelldatumField;
    private JTextField bestellungKundeField;
    private JTextField bestellungTotalField;
    private JList bestellpositionList;
    private JButton newButtonBestellposition;
    private JButton deleteButtonBestellposition;
    private JButton saveButtonBestellposition;
    private JTextField bestellpositionEinzelpreisField;
    private JTextField BestellpositionComputerField;
    private JTextField bestellpositionStueckzahlField;
    private JTabbedPane tabbedPane1;
    private JList SchnittstellenList;
    private JButton newButtonSchnittstellen;
    private JButton deleteButtonSchnittstellen;
    private JButton saveButtonSchnittstellen;
    private JTextField schnittstellenSchnittstelleField;
    private JTextField computerHerstellerField;
    private JButton newButtonComputer;
    private JButton deleteButtonComputer;
    private JButton saveButtonComputer;
    private JTextField computerModellField;
    private JTextField computerArbeitsspeicherField;
    private JTextField computerCpuField;
    private JTextField computerMassenspeicherField;
    private JTextField computerTypField;
    private JTextField computerEinzelpreisField;
    private JButton newButtonKunde;
    private JButton deleteButtonKunde;
    private JButton saveButtonKunde;
    private JTextField kundenNachnameField;
    private JTextField kundenGeschlechtField;
    private JTextField kundenVornameField;
    private JTextField kundenStrasseField;
    private JTextField kundenPlzField;
    private JTextField kundenOrtField;
    private JTextField kundenTelefonField;
    private JTextField kundenEmailField;
    private JTextField kundenSpracheField;
    private JTextField kundenGeburtsdatumField;


    private Controller controller;

    public ApplicationUi(Controller controller){
        super("PcShopM165");

        this.controller = controller;

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); //Rendern vom Inhalt
        addActionListener();

    }

    private void addActionListener() {

        newButtonKunde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readKundeFromUi();
            }
        });

    }

    private void readKundeFromUi() {
        try {

            int plz = Integer.parseInt(kundenPlzField.getText());

            Adresse adresse = new Adresse(
                    kundenStrasseField.getText(),
                    plz,
                    kundenOrtField.getText()
            );

            Date date = stringToDate(kundenGeburtsdatumField.getText());

            Kunde kunde = new Kunde(
                    kundenGeschlechtField.getText(),
                    kundenNachnameField.getText(),
                    kundenVornameField.getText(),
                    adresse,
                    kundenTelefonField.getText(),
                    kundenEmailField.getText(),
                    kundenSpracheField.getText(),
                    date
            );

            controller.setKunde(kunde);

        } catch (NumberFormatException ex){

            System.err.println("Eines Fehler: " + ex.getMessage());
        }


    }

    public static Date stringToDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

/*
    private void readBestellungFromUi() {
        try {

            int bestellungsId = Integer.parseInt(bestellungBestellnummerField.getText());
            double total = Double.parseDouble(bestellungTotalField.getText());
            Bestellung bestellung = new Bestellung(
                    bestellungsId,
                    bestellungBestelldatumField.getText(),
                    strasseTxtKunde.getText(),
                    strassennummer,
                    plz,
                    wohnortTxtKunde.getText(),
                    telefonTxtKunde.getText(),
                    emailTxtKunde.getText(),
                    geburtsdatumKunde.getText()
            );

            System.out.println(nameTxtKunde.getText());
            System.out.println(kunde.getName());

            App app = new App();
            app.createNewKunde(kunde);



        } catch (NumberFormatException ex) {

            System.err.println("Fehler beim Parsen von Strassennummer oder PLZ: " + ex.getMessage());
        }
    }
*/
}
