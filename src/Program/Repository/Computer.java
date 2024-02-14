package Program.Repository;

import Program.Controller.Controller;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Computer{

    private ObjectId computerId;
    private String hersteller;
    private String modell;
    private int arbeitsspeicher;
    private String cpu;
    private int massenspeicher;
    private String typ;
    private double einzelpreis;
    private ArrayList<Schnittstelle> schnittstellen;

    public Computer(String hersteller, String modell, int arbeitsspeicher, String cpu, int massenspeicher, String typ, double einzelpreis, ArrayList<Schnittstelle> schnittstellen) {
        this.hersteller = hersteller;
        this.modell = modell;
        this.arbeitsspeicher = arbeitsspeicher;
        this.cpu = cpu;
        this.massenspeicher = massenspeicher;
        this.typ = typ;
        this.einzelpreis = einzelpreis;
        this.schnittstellen = schnittstellen;
    }

    public Computer(ObjectId computerId, String hersteller, String modell, int arbeitsspeicher, String cpu, int massenspeicher, String typ, double einzelpreis, ArrayList<Schnittstelle> schnittstellen) {
        this.computerId = computerId;
        this.hersteller = hersteller;
        this.modell = modell;
        this.arbeitsspeicher = arbeitsspeicher;
        this.cpu = cpu;
        this.massenspeicher = massenspeicher;
        this.typ = typ;
        this.einzelpreis = einzelpreis;
        this.schnittstellen = schnittstellen;
    }

    public Computer() {

    }


    public ObjectId getComputerId() {
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

    public void setComputerId(ObjectId computerId) {
        this.computerId = computerId;
    }
}
