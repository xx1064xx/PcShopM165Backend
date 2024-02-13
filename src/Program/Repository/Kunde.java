package Program.Repository;

import org.bson.types.ObjectId;

import java.util.Date;

public class Kunde {

    private ObjectId kundenId;
    private String geschlecht;
    private String nachname;
    private String vorname;
    private Adresse adresse;
    private String telefon;
    private String email;
    private String sprache;
    private Date geburtsdatum;


    public Kunde(String geschlecht, String nachname, String vorname, Adresse adresse, String telefon, String email, String sprache, Date geburtsdatum) {
        this.geschlecht = geschlecht;
        this.nachname = nachname;
        this.vorname = vorname;
        this.adresse = adresse;
        this.telefon = telefon;
        this.email = email;
        this.sprache = sprache;
        this.geburtsdatum = geburtsdatum;
    }

    public Kunde(ObjectId kundenId, String geschlecht, String nachname, String vorname, Adresse adresse, String telefon, String email, String sprache, Date geburtsdatum) {
        this.kundenId = kundenId;
        this.geschlecht = geschlecht;
        this.nachname = nachname;
        this.vorname = vorname;
        this.adresse = adresse;
        this.telefon = telefon;
        this.email = email;
        this.sprache = sprache;
        this.geburtsdatum = geburtsdatum;
    }

    public Kunde() {

    }

    public ObjectId getKundenId() {
        return kundenId;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getSprache() {
        return sprache;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = this.kundenId;
    }
}
