package Program.Repository;

public class Adresse {

    private String strasse;
    private int plz;
    private String ort;

    public Adresse() {

    }

    public String getStrasse() {
        return strasse;
    }

    public int getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
