package hu.petrik.szuperhosprojekt;

import java.text.MessageFormat;

public abstract class Bosszuallo implements Szuperhos {
    private double szuperero;
    boolean vanEGyengesege;

    public Bosszuallo(double szuperero, boolean vanEGyengesege) {
        this.szuperero = szuperero;
        this.vanEGyengesege = vanEGyengesege;
    }

    public abstract boolean megmentiAVilagot();

    @Override
    public double mekkoraAzEreje() {
        return szuperero;
    }

    @Override
    public boolean legyoziE(Szuperhos szuperhos) {
        if (szuperhos instanceof Bosszuallo && vanEGyengesege && szuperhos.mekkoraAzEreje() < mekkoraAzEreje()) {
            return true;
        }
        if (szuperhos instanceof Batman && mekkoraAzEreje() >= szuperhos.mekkoraAzEreje()*2) {
            return true;
        }

        return false;
    }

    public double getSzuperero() {
        return szuperero;
    }

    public void setSzuperero(double szuperero) {
        this.szuperero = szuperero;
    }

    public boolean isVanEGyengesege() {
        return vanEGyengesege;
    }

    public void setVanEGyengesege(boolean vanEGyengesege) {
        this.vanEGyengesege = vanEGyengesege;
    }

    @Override
    public String toString() {
        String gyengeseg = vanEGyengesege ? "van gyengesége" : "nincs gyengesége";
        return MessageFormat.format("Szupererő: {0,number,#.##}; {1}", szuperero, gyengeseg);
    }
}
