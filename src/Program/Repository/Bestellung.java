package Program.Repository;

import java.util.ArrayList;
import java.util.Date;

public class Bestellung {

    private int bestellnummer;
    private Date bestelldatum;
    private Kunde kunde;
    private ArrayList<Bestellposition> bestellpositionen;
    private double total;

    public Bestellung() {

    }


    public int getBestellnummer() {
        return bestellnummer;
    }

    public Date getBestelldatum() {
        return bestelldatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public ArrayList<Bestellposition> getBestellpositionen() {
        return bestellpositionen;
    }

    public double getTotal() {
        return total;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public void setBestelldatum(Date bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setBestellpositionen(ArrayList<Bestellposition> bestellpositionen) {
        this.bestellpositionen = bestellpositionen;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
