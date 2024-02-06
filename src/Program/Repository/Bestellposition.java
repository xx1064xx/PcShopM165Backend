package Program.Repository;

public class Bestellposition {

    private Computer computer;
    private double preis;
    private int stueckzahl;

    public Bestellposition() {

    }

    public Computer getComputer() {
        return computer;
    }

    public double getPreis() {
        return preis;
    }

    public int getStueckzahl() {
        return stueckzahl;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setStueckzahl(int stueckzahl) {
        this.stueckzahl = stueckzahl;
    }
}
