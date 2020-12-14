import java.util.Collections;
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
            while (true) {
                System.out.print("");
                if (!gui.klienci.isEmpty()) {

                    Collections.sort(gui.klienci);
                    oblugiwanyKlient =  gui.klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.oblugiwanyKlientWatek1 = miejsceObslugiwanegoKlienta;
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.wagaPlikuWatek1 = losowaCiezkoscPliku;
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
                        gui.pozostaloWatek1 = secondsToSleep;
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.pobranoWatek1 = gui.pobranoWatek1 + 3;
                                gui.pozostaloWatek1 = gui.pozostaloWatek1 - 1;
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
                            for (Klient klient : gui.klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            gui.klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.pozostaloWatek1 = 0;
                        gui.pobranoWatek1 = 0;
                        gui.oblugiwanyKlientWatek1 = 0;
                        gui.wagaPlikuWatek1 = 0;
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
            while (true) {
                System.out.print("");
                if (!gui.klienci.isEmpty() && !wolny1.get()) {

                    Collections.sort(gui.klienci);
                    oblugiwanyKlient =  gui.klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.oblugiwanyKlientWatek2 = miejsceObslugiwanegoKlienta;
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.wagaPlikuWatek2 = losowaCiezkoscPliku;
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
                        gui.pozostaloWatek2 = secondsToSleep;
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.pobranoWatek2 = gui.pobranoWatek2 + 3;
                                gui.pozostaloWatek2 = gui.pozostaloWatek2 - 1;
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
                            for (Klient klient : gui.klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            gui.klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.pozostaloWatek2 = 0;
                        gui.pobranoWatek2 = 0;
                        gui.oblugiwanyKlientWatek2 = 0;
                        gui.wagaPlikuWatek2 = 0;
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
            while (true) {
                System.out.print("");
                if (!gui.klienci.isEmpty() && !wolny1.get() && !wolny2.get()) {

                    Collections.sort(gui.klienci);
                    oblugiwanyKlient = gui.klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.oblugiwanyKlientWatek3 = miejsceObslugiwanegoKlienta;
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.wagaPlikuWatek3 = losowaCiezkoscPliku;
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
                        gui.pozostaloWatek3 = secondsToSleep;
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.pobranoWatek3 = gui.pobranoWatek3 + 3;
                                gui.pozostaloWatek3 = gui.pozostaloWatek3 - 1;
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
                            for (Klient klient : gui.klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            gui.klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.pozostaloWatek3 = 0;
                        gui.pobranoWatek3 = 0;
                        gui.oblugiwanyKlientWatek3 = 0;
                        gui.wagaPlikuWatek3 = 0;
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
            while (true) {
                System.out.print("");
                if (!gui.klienci.isEmpty() && !wolny1.get() && !wolny2.get() && !wolny3.get()) {

                    Collections.sort(gui.klienci);
                    oblugiwanyKlient = gui.klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.oblugiwanyKlientWatek4 = miejsceObslugiwanegoKlienta;
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.wagaPlikuWatek4 = losowaCiezkoscPliku;
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
                        gui.pozostaloWatek4 = secondsToSleep;
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.pobranoWatek4 = gui.pobranoWatek4 + 3;
                                gui.pozostaloWatek4 = gui.pozostaloWatek4 - 1;
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
                            for (Klient klient : gui.klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            gui.klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.pozostaloWatek4 = 0;
                        gui.pobranoWatek4 = 0;
                        gui.oblugiwanyKlientWatek4 = 0;
                        gui.wagaPlikuWatek4 = 0;
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
            while (true) {
                System.out.print("");
                if (!gui.klienci.isEmpty() && !wolny1.get() && !wolny2.get() && !wolny3.get() && !wolny4.get()) {

                    Collections.sort(gui.klienci);
                    oblugiwanyKlient = gui.klienci.get(0);

                    if (oblugiwanyKlient.getIloscPlikow() > 0) {

                        miejsceObslugiwanegoKlienta = oblugiwanyKlient.getMiejsceWKolejce();
                        gui.oblugiwanyKlientWatek5 = miejsceObslugiwanegoKlienta;
                        losowaCiezkoscPliku = ((int) (Math.random()
                                * (maxCiezkoscPliku - minCiezkoscPliku + 1) + minCiezkoscPliku));
                        gui.wagaPlikuWatek5 = losowaCiezkoscPliku;
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
                        gui.pozostaloWatek5 = secondsToSleep;
                        try {
                            for (int i = 0; i < secondsToSleep ; i++) {
                                Thread.sleep(1000);
                                gui.pobranoWatek5 = gui.pobranoWatek5 + 3;
                                gui.pozostaloWatek5 = gui.pozostaloWatek5 - 1;
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
                            for (Klient klient : gui.klienci) {
                                //miejsce w kolejce--
                                if(klient.getMiejsceWKolejce() > oblugiwanyKlient.getMiejsceWKolejce()) {
                                    klient.setMiejsceWKolejce(klient.getMiejsceWKolejce() - 1);
                                    klient.setWaga(klient.getWagaWgrywanychPlikow());
                                }
                            }
                            // usuwamy klienta bez plikow
                            gui.klienci.remove(oblugiwanyKlient);
                            //zmniejszenie Count odpowiadajacego za miejsce w kolejce
                            Klient.setCount(Klient.getCount() - 1);
                        }
                        gui.pozostaloWatek5 = 0;
                        gui.pobranoWatek5 = 0;
                        gui.oblugiwanyKlientWatek5 = 0;
                        gui.wagaPlikuWatek5 = 0;
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
