package Program.Repository;

import Program.Controller.Controller;

import java.util.ArrayList;

public class Computer{

    private int computerId;
    private String hersteller;
    private String modell;
    private int arbeitsspeicher;
    private String cpu;
    private int massenspeicher;
    private String typ;
    private double einzelpreis;
    private ArrayList<Schnittstelle> schnittstellen;

    public Computer() {

    }


    public int getComputerId() {
        return computerId;
    }

    public String getHersteller() {
        return hersteller;
    }

    public String getModell() {
        return modell;
    }

    public int getArbeitsspeicher() {
        return arbeitsspeicher;
    }

    public String getCpu() {
        return cpu;
    }

    public int getMassenspeicher() {
        return massenspeicher;
    }

    public String getTyp() {
        return typ;
    }

    public double getEinzelpreis() {
        return einzelpreis;
    }

    public ArrayList<Schnittstelle> getSchnittstellen() {
        return schnittstellen;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setArbeitsspeicher(int arbeitsspeicher) {
        this.arbeitsspeicher = arbeitsspeicher;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMassenspeicher(int massenspeicher) {
        this.massenspeicher = massenspeicher;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setEinzelpreis(double einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public void setSchnittstellen(ArrayList<Schnittstelle> schnittstellen) {
        this.schnittstellen = schnittstellen;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }
}
