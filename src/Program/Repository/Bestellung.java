package Program.Repository;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;

public class Bestellung {


    private ObjectId bestellungsId;
    private Date bestelldatum;
    private Kunde kunde;
    private ArrayList<Bestellposition> bestellpositionen;
    private double total;

    public Bestellung(ObjectId bestellungsId, Date bestelldatum, Kunde kunde, ArrayList<Bestellposition> bestellpositionen, double total) {
        this.bestellungsId = bestellungsId;
        this.bestelldatum = bestelldatum;
        this.kunde = kunde;
        this.bestellpositionen = bestellpositionen;
        this.total = total;
    }

    public Bestellung(Date bestelldatum, Kunde kunde, ArrayList<Bestellposition> bestellpositionen, double total) {
        this.bestelldatum = bestelldatum;
        this.kunde = kunde;
        this.bestellpositionen = bestellpositionen;
        this.total = total;
    }

    public ObjectId getBestellungsId() {
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

    public void setBestellungsId(ObjectId bestellungsId) {
        this.bestellungsId = bestellungsId;
    }
}
