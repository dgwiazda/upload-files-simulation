import java.util.Collection;

public class Klient implements Comparable<Klient> {
    private static int count=0;
    private static int liczebnosc=0;
    private int miejsceWKolejce;
    private int zajeteWatki;
    private int wagaWgrywanychPlikow;
    private int iloscPlikow;
    private int waga;
    private int ktoryKlient;

    public Klient(int iloscPlikow) {
        liczebnosc++;
        this.miejsceWKolejce = 1+count;
        this.zajeteWatki = 0;
        this.wagaWgrywanychPlikow = 0;
        this.iloscPlikow = iloscPlikow;
        this.waga = 0;
        this.ktoryKlient = liczebnosc;
        count++;
    }

    public int getMiejsceWKolejce() {
        return miejsceWKolejce;
    }

    public void setMiejsceWKolejce(int miejsceWKolejce) {
        this.miejsceWKolejce = miejsceWKolejce;
    }

    public int getZajeteWatki() {
        return zajeteWatki;
    }

    public void setZajeteWatki(int zajeteWatki) {
        this.zajeteWatki = zajeteWatki;
    }

    public int getIloscPlikow() {
        return iloscPlikow;
    }

    public int getWagaWgrywanychPlikow() {
        return wagaWgrywanychPlikow;
    }

    public void setWagaWgrywanychPlikow(int wagaWgrywanychPlikow) {
        this.wagaWgrywanychPlikow = wagaWgrywanychPlikow;
    }

    public void setIloscPlikow(int iloscPlikow) {
        this.iloscPlikow = iloscPlikow;
    }

    public int getWaga() {
        return waga;
    }

    public static int getLiczebnosc() {
        return liczebnosc;
    }

    public void setWaga(int wagaWgrywanychPlikow) {
        if(wagaWgrywanychPlikow>1000){
            waga=1000;
        }
        else {
            waga=0;
        }
        waga += miejsceWKolejce + 5 * zajeteWatki;
        this.waga = waga;
    }

    public static void setCount(int count) {
        Klient.count = count;
    }

    public static int getCount() {
        return count;
    }

    public int getKtoryKlient() {
        return ktoryKlient;
    }

    @Override
    public int compareTo(Klient comparestu) {
        int compareWaga = ((Klient)comparestu).getWaga();
        return this.waga - compareWaga;
    }

    @Override
    public String toString() {
        return "[ " +
                "Klient#" + ktoryKlient +
                " miejsceWKolejce=" + miejsceWKolejce +
                ", zajeteWatki=" + zajeteWatki +
                ", wagaWgrywanychPlikow=" + wagaWgrywanychPlikow +
                ", iloscPlikow=" + iloscPlikow +
                ", waga=" + waga +
                ']';
    }

}
