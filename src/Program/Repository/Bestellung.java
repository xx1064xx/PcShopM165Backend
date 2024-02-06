package Program.Repository;

import java.util.ArrayList;
import java.util.Date;

public class Bestellung {


    private int bestellungsId;
    private Date bestelldatum;
    private Kunde kunde;
    private ArrayList<Bestellposition> bestellpositionen;
    private double total;

    public Bestellung() {

    }

    public int getBestellungsId() {
        return bestellungsId;
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

    public void setBestellungsId(int bestellungsId) {
        this.bestellungsId = bestellungsId;
    }
}
