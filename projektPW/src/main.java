import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class main {

    public static void main(String[] args) {
        GUI gui = new GUI();

        int minCiezkoscPliku = 1;
        int maxCiezkoscPliku = 1500;
        int predkoscPobierania = 3;
        AtomicBoolean wolny1 = new AtomicBoolean(true);
        AtomicBoolean wolny2 = new AtomicBoolean(true);
        AtomicBoolean wolny3 = new AtomicBoolean(true);
        AtomicBoolean wolny4 = new AtomicBoolean(true);

        Thread thread1 = new Thread(() -> {
            int losowaCiezkoscPliku;
            int secondsToSleep;
            int miejsceObslugiwanegoKlienta;
            Klient oblugiwanyKlient;
            List<Klient> klienci = gui.getKlienci();
            while (true) {
                System.out.print("");
                if (!klienci.isEmpty()) {

                    Collections.sort(klienci);
                    oblugiwanyKlient = klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.setOblugiwanyKlientWatek1(miejsceObslugiwanegoKlienta);
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.setWagaPlikuWatek1(losowaCiezkoscPliku);
                        //ilosc plikow --
                        oblugiwanyKlient.setIloscPlikow(oblugiwanyKlient.getIloscPlikow() - 1);
                        //zajęte wątki ++
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() + 1);
                        //waga wgrywanych plików + nowy plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() +
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());
                        //zajecie wątku
                        wolny1.set(false);


                        //czas wrzucania pliku
                        secondsToSleep = losowaCiezkoscPliku / predkoscPobierania + 1;

                        gui.setPozostaloWatek1(secondsToSleep);
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.setPobranoWatek1(gui.getPobranoWatek1() + 3);
                                gui.setPozostaloWatek1(gui.getPozostaloWatek1() - 1);
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        //zajete watki --
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() - 1);
                        //waga wgrywanych plikow - wrzucony plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() -
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());


                        if (oblugiwanyKlient.getIloscPlikow() == 0 && oblugiwanyKlient.getZajeteWatki() == 0) {
                            for (Klient klient : klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.setPozostaloWatek1(0);
                        gui.setPobranoWatek1(0);
                        gui.setOblugiwanyKlientWatek1(0);
                        gui.setWagaPlikuWatek1(0);
                        wolny1.set(true);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            int losowaCiezkoscPliku;
            int secondsToSleep;
            int miejsceObslugiwanegoKlienta;
            Klient oblugiwanyKlient;
            List<Klient> klienci = gui.getKlienci();
            while (true) {
                System.out.print("");
                if (!klienci.isEmpty() && !wolny1.get()) {

                    Collections.sort(klienci);
                    oblugiwanyKlient =  klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.setOblugiwanyKlientWatek2(miejsceObslugiwanegoKlienta);
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.setWagaPlikuWatek2(losowaCiezkoscPliku);
                        //ilosc plikow --
                        oblugiwanyKlient.setIloscPlikow(oblugiwanyKlient.getIloscPlikow() - 1);
                        //zajęte wątki ++
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() + 1);
                        //waga wgrywanych plików + nowy plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() +
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());
                        //zajecie wątku
                        wolny2.set(false);


                        //czas wrzucania pliku
                        secondsToSleep = losowaCiezkoscPliku / predkoscPobierania + 1;
                        gui.setPozostaloWatek2(secondsToSleep);
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.setPobranoWatek2(gui.getPobranoWatek2() + 3);
                                gui.setPozostaloWatek2(gui.getPozostaloWatek2() - 1);
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        //zajete watki --
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() - 1);
                        //waga wgrywanych plikow - wrzucony plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() -
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());


                        if (oblugiwanyKlient.getIloscPlikow() == 0 && oblugiwanyKlient.getZajeteWatki() == 0) {
                            for (Klient klient : klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.setPozostaloWatek2(0);
                        gui.setPobranoWatek2(0);
                        gui.setOblugiwanyKlientWatek2(0);
                        gui.setWagaPlikuWatek2(0);
                        wolny2.set(true);
                    }
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            int losowaCiezkoscPliku;
            int secondsToSleep;
            int miejsceObslugiwanegoKlienta;
            Klient oblugiwanyKlient;
            List<Klient> klienci = gui.getKlienci();
            while (true) {
                System.out.print("");
                if (!klienci.isEmpty() && !wolny1.get() && !wolny2.get()) {

                    Collections.sort(klienci);
                    oblugiwanyKlient = klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.setOblugiwanyKlientWatek3(miejsceObslugiwanegoKlienta);
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.setWagaPlikuWatek3(losowaCiezkoscPliku);
                        //ilosc plikow --
                        oblugiwanyKlient.setIloscPlikow(oblugiwanyKlient.getIloscPlikow() - 1);
                        //zajęte wątki ++
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() + 1);
                        //waga wgrywanych plików + nowy plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() +
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());
                        //zajęcie wątku
                        wolny3.set(false);


                        //czas wrzucania pliku
                        secondsToSleep = losowaCiezkoscPliku / predkoscPobierania + 1;
                        gui.setPozostaloWatek3(secondsToSleep);
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.setPobranoWatek3(gui.getPobranoWatek3() + 3);
                                gui.setPozostaloWatek3(gui.getPozostaloWatek3() - 1);
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                        //zajete watki --
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() - 1);
                        //waga wgrywanych plikow - wrzucony plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() -
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());


                        if (oblugiwanyKlient.getIloscPlikow() == 0 && oblugiwanyKlient.getZajeteWatki() == 0) {
                            for (Klient klient : klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.setPozostaloWatek3(0);
                        gui.setPobranoWatek3(0);
                        gui.setOblugiwanyKlientWatek3(0);
                        gui.setWagaPlikuWatek3(0);
                        wolny3.set(true);
                    }
                }
            }
        });

        Thread thread4 = new Thread(() -> {
            int losowaCiezkoscPliku;
            int secondsToSleep;
            int miejsceObslugiwanegoKlienta;
            Klient oblugiwanyKlient;
            List<Klient> klienci = gui.getKlienci();
            while (true) {
                System.out.print("");
                if (!klienci.isEmpty() && !wolny1.get() && !wolny2.get() && !wolny3.get()) {

                    Collections.sort(klienci);
                    oblugiwanyKlient = klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.setOblugiwanyKlientWatek4(miejsceObslugiwanegoKlienta);
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.setWagaPlikuWatek4(losowaCiezkoscPliku);
                        //ilosc plikow --
                        oblugiwanyKlient.setIloscPlikow(oblugiwanyKlient.getIloscPlikow() - 1);
                        //zajęte wątki ++
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() + 1);
                        //waga wgrywanych plików + nowy plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() +
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());
                        //zajęcie wątku
                        wolny4.set(false);


                        //czas wrzucania pliku
                        secondsToSleep = losowaCiezkoscPliku / predkoscPobierania + 1;
                        gui.setPozostaloWatek4(secondsToSleep);
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.setPobranoWatek4(gui.getPobranoWatek4() + 3);
                                gui.setPozostaloWatek4(gui.getPozostaloWatek4() - 1);
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                        //zajete watki --
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() - 1);
                        //waga wgrywanych plikow - wrzucony plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() -
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());

                        if (oblugiwanyKlient.getIloscPlikow() == 0 && oblugiwanyKlient.getZajeteWatki() == 0) {
                            for (Klient klient : klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.setPozostaloWatek4(0);
                        gui.setPobranoWatek4(0);
                        gui.setOblugiwanyKlientWatek4(0);
                        gui.setWagaPlikuWatek4(0);
                        wolny4.set(true);
                    }
                }
            }
        });
        Thread thread5 = new Thread(() -> {
            int losowaCiezkoscPliku;
            int secondsToSleep;
            int miejsceObslugiwanegoKlienta;
            Klient oblugiwanyKlient;
            List<Klient> klienci = gui.getKlienci();
            while (true) {
                System.out.print("");
                if (!klienci.isEmpty() && !wolny1.get() && !wolny2.get() && !wolny3.get() && !wolny4.get()) {

                    Collections.sort(klienci);
                    oblugiwanyKlient = klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.setOblugiwanyKlientWatek5(miejsceObslugiwanegoKlienta);
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.setWagaPlikuWatek5(losowaCiezkoscPliku);
                        //ilosc plikow --
                        oblugiwanyKlient.setIloscPlikow(oblugiwanyKlient.getIloscPlikow() - 1);
                        //zajęte wątki ++
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() + 1);
                        //waga wgrywanych plików + nowy plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() +
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());


                        //czas wrzucania pliku
                        secondsToSleep = losowaCiezkoscPliku / predkoscPobierania + 1;
                        gui.setPozostaloWatek5(secondsToSleep);
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.setPobranoWatek5(gui.getPobranoWatek5() + 3);
                                gui.setPozostaloWatek5(gui.getPozostaloWatek5() - 1);
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                        //zajete watki --
                        oblugiwanyKlient.setZajeteWatki(oblugiwanyKlient.getZajeteWatki() - 1);
                        //waga wgrywanych plikow - wrzucony plik
                        oblugiwanyKlient.setWagaWgrywanychPlikow(
                                oblugiwanyKlient.getWagaWgrywanychPlikow() -
                                        losowaCiezkoscPliku);
                        //nowa waga
                        oblugiwanyKlient.setWaga(oblugiwanyKlient.getWagaWgrywanychPlikow());


                        if (oblugiwanyKlient.getIloscPlikow() == 0 && oblugiwanyKlient.getZajeteWatki() == 0) {
                            for (Klient klient : klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.setPozostaloWatek5(0);
                        gui.setPobranoWatek5(0);
                        gui.setOblugiwanyKlientWatek5(0);
                        gui.setWagaPlikuWatek5(0);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }



}
