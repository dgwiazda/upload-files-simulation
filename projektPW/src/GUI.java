import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) throws ConcurrentModificationException {
            try {
                lblKlient1.setText("Klient:              " + "#" + oblugiwanyKlientWatek1);
                lblKlient2.setText("Klient:              " + "#" + oblugiwanyKlientWatek2);
                lblKlient3.setText("Klient:              " + "#" + oblugiwanyKlientWatek3);
                lblKlient4.setText("Klient:              " + "#" + oblugiwanyKlientWatek4);
                lblKlient5.setText("Klient:              " + "#" + oblugiwanyKlientWatek5);
                lblWagaPliku1.setText("Waga pliku:   " + wagaPlikuWatek1 + "MB");
                lblWagaPliku2.setText("Waga pliku:   " + wagaPlikuWatek2 + "MB");
                lblWagaPliku3.setText("Waga pliku:   " + wagaPlikuWatek3 + "MB");
                lblWagaPliku4.setText("Waga pliku:   " + wagaPlikuWatek4 + "MB");
                lblWagaPliku5.setText("Waga pliku:   " + wagaPlikuWatek5 + "MB");
                lblPobieranie1.setText("Pobrano:        " + pobranoWatek1 + "MB");
                lblPobieranie2.setText("Pobrano:        " + pobranoWatek2 + "MB");
                lblPobieranie3.setText("Pobrano:        " + pobranoWatek3 + "MB");
                lblPobieranie4.setText("Pobrano:        " + pobranoWatek4 + "MB");
                lblPobieranie5.setText("Pobrano:        " + pobranoWatek5 + "MB");
                lblCzas1.setText("Pozostało:      " + pozostaloWatek1 + "s");
                lblCzas2.setText("Pozostało:      " + pozostaloWatek2 + "s");
                lblCzas3.setText("Pozostało:      " + pozostaloWatek3 + "s");
                lblCzas4.setText("Pozostało:      " + pozostaloWatek4 + "s");
                lblCzas5.setText("Pozostało:      " + pozostaloWatek5 + "s");

                kolejka = klienci;
                for (Klient k: kolejka) {
                    if (k.getMiejsceWKolejce() == 1) {
                        pierwszy = k;
                    }
                    if (k.getMiejsceWKolejce() == 2) {
                        drugi = k;
                    }
                    if (k.getMiejsceWKolejce() == 3) {
                        trzeci = k;
                    }
                    if (k.getMiejsceWKolejce() == 4) {
                        czwarty = k;
                    }
                    if (k.getMiejsceWKolejce() == 5) {
                        piaty = k;
                    }
                }

                if (kolejka.size() < 1) {
                    lblKolejkaKlientWiecej.setText("");

                    lblKolejkaKlient5.setText("");
                    lblKolejkaPlikiKlient5.setText("");
                    lblPlikiKlienta5.setText("");
                    lblZajetePlikiKlienta5.setText("");

                    lblKolejkaKlient4.setText("");
                    lblKolejkaPlikiKlient4.setText("");
                    lblPlikiKlienta4.setText("");
                    lblZajetePlikiKlienta4.setText("");

                    lblKolejkaKlient3.setText("");
                    lblKolejkaPlikiKlient3.setText("");
                    lblPlikiKlienta3.setText("");
                    lblZajetePlikiKlienta3.setText("");

                    lblKolejkaKlient2.setText("");
                    lblKolejkaPlikiKlient2.setText("");
                    lblPlikiKlienta2.setText("");
                    lblZajetePlikiKlienta2.setText("");

                    lblKolejkaKlient1.setText("");
                    lblKolejkaPlikiKlient1.setText("");
                    lblPlikiKlienta1.setText("");
                    lblZajetePlikiKlienta1.setText("");

                }

                if(kolejka.size() > 0) {
                    lblKolejkaKlient1.setText("Klient #" + pierwszy.getKtoryKlient());
                    lblKolejkaPlikiKlient1.setText("Liczba plików:");
                    lblPlikiKlienta1.setText(pierwszy.getIloscPlikow() + " ");
                    lblZajetePlikiKlienta1.setText("+ " + pierwszy.getZajeteWatki());

                    lblKolejkaKlientWiecej.setText("");

                    lblKolejkaKlient5.setText("");
                    lblKolejkaPlikiKlient5.setText("");
                    lblPlikiKlienta5.setText("");
                    lblZajetePlikiKlienta5.setText("");

                    lblKolejkaKlient4.setText("");
                    lblKolejkaPlikiKlient4.setText("");
                    lblPlikiKlienta4.setText("");
                    lblZajetePlikiKlienta4.setText("");

                    lblKolejkaKlient3.setText("");
                    lblKolejkaPlikiKlient3.setText("");
                    lblPlikiKlienta3.setText("");
                    lblZajetePlikiKlienta3.setText("");

                    lblKolejkaKlient2.setText("");
                    lblKolejkaPlikiKlient2.setText("");
                    lblPlikiKlienta2.setText("");
                    lblZajetePlikiKlienta2.setText("");
                }
                if(kolejka.size() > 1) {
                    lblKolejkaKlient2.setText("Klient #" + drugi.getKtoryKlient());
                    lblKolejkaPlikiKlient2.setText("Liczba plików:");
                    lblPlikiKlienta2.setText(drugi.getIloscPlikow() + " ");
                    lblZajetePlikiKlienta2.setText("+ " + drugi.getZajeteWatki());

                    lblKolejkaKlientWiecej.setText("");

                    lblKolejkaKlient5.setText("");
                    lblKolejkaPlikiKlient5.setText("");
                    lblPlikiKlienta5.setText("");
                    lblZajetePlikiKlienta5.setText("");

                    lblKolejkaKlient4.setText("");
                    lblKolejkaPlikiKlient4.setText("");
                    lblPlikiKlienta4.setText("");
                    lblZajetePlikiKlienta4.setText("");

                    lblKolejkaKlient3.setText("");
                    lblKolejkaPlikiKlient3.setText("");
                    lblPlikiKlienta3.setText("");
                    lblZajetePlikiKlienta3.setText("");
                }
                if(kolejka.size() > 2) {
                    lblKolejkaKlient3.setText("Klient #" + trzeci.getKtoryKlient());
                    lblKolejkaPlikiKlient3.setText("Liczba plików:");
                    lblPlikiKlienta3.setText(trzeci.getIloscPlikow() + " ");
                    lblZajetePlikiKlienta3.setText("+ " + trzeci.getZajeteWatki());

                    lblKolejkaKlientWiecej.setText("");

                    lblKolejkaKlient5.setText("");
                    lblKolejkaPlikiKlient5.setText("");
                    lblPlikiKlienta5.setText("");
                    lblZajetePlikiKlienta5.setText("");

                    lblKolejkaKlient4.setText("");
                    lblKolejkaPlikiKlient4.setText("");
                    lblPlikiKlienta4.setText("");
                    lblZajetePlikiKlienta4.setText("");
                }
                if(kolejka.size() > 3) {
                    lblKolejkaKlient4.setText("Klient #" + czwarty.getKtoryKlient());
                    lblKolejkaPlikiKlient4.setText("Liczba plików:");
                    lblPlikiKlienta4.setText(czwarty.getIloscPlikow() + " ");
                    lblZajetePlikiKlienta4.setText("+ " + czwarty.getZajeteWatki());

                    lblKolejkaKlientWiecej.setText("");

                    lblKolejkaKlient5.setText("");
                    lblKolejkaPlikiKlient5.setText("");
                    lblPlikiKlienta5.setText("");
                    lblZajetePlikiKlienta5.setText("");
                }
                if(kolejka.size() > 4) {
                    lblKolejkaKlient5.setText("Klient #" + piaty.getKtoryKlient());
                    lblKolejkaPlikiKlient5.setText("Liczba plików:");
                    lblPlikiKlienta5.setText(piaty.getIloscPlikow() + " ");
                    lblZajetePlikiKlienta5.setText("+ " + piaty.getZajeteWatki());

                    lblKolejkaKlientWiecej.setText("");
                }
                if(kolejka.size() > 5) {
                    lblKolejkaKlientWiecej.setText("...+" + (kolejka.size() - 5));
                }
            }catch (Exception e) {
                kolejka = klienci;
                System.out.println("ehh");
            }


        }
    };
    Timer timer = new Timer(1000, taskPerformer);

    private List<Klient> klienci = new ArrayList<>();
    private List<Klient> kolejka = new ArrayList<>();

    private int oblugiwanyKlientWatek1;
    private int oblugiwanyKlientWatek2;
    private int oblugiwanyKlientWatek3;
    private int oblugiwanyKlientWatek4;
    private int oblugiwanyKlientWatek5;
    private int wagaPlikuWatek1;
    private int wagaPlikuWatek2;
    private int wagaPlikuWatek3;
    private int wagaPlikuWatek4;
    private int wagaPlikuWatek5;
    private int pobranoWatek1;
    private int pobranoWatek2;
    private int pobranoWatek3;
    private int pobranoWatek4;
    private int pobranoWatek5;
    private int pozostaloWatek1;
    private int pozostaloWatek2;
    private int pozostaloWatek3;
    private int pozostaloWatek4;
    private int pozostaloWatek5;
    private int iloscKlientowWKolejce;
    private Klient pierwszy;
    private Klient drugi;
    private Klient trzeci;
    private Klient czwarty;
    private Klient piaty;

    JButton btnDodajKlienta;
    JLabel lblWatek1;
    JLabel lblWatek2;
    JLabel lblWatek3;
    JLabel lblWatek4;
    JLabel lblWatek5;
    JLabel lblVPobierania;
    JLabel lblWagaPliku1;
    JLabel lblWagaPliku2;
    JLabel lblWagaPliku3;
    JLabel lblWagaPliku4;
    JLabel lblWagaPliku5;
    JLabel lblPobieranie1;
    JLabel lblPobieranie2;
    JLabel lblPobieranie3;
    JLabel lblPobieranie4;
    JLabel lblPobieranie5;
    JLabel lblCzas1;
    JLabel lblCzas2;
    JLabel lblCzas3;
    JLabel lblCzas4;
    JLabel lblCzas5;
    JLabel lblKlient1;
    JLabel lblKlient2;
    JLabel lblKlient3;
    JLabel lblKlient4;
    JLabel lblKlient5;
    JLabel lblKolejka;
    JLabel lblKolejkaKlient1;
    JLabel lblKolejkaKlient2;
    JLabel lblKolejkaKlient3;
    JLabel lblKolejkaKlient4;
    JLabel lblKolejkaKlient5;
    JLabel lblKolejkaKlientWiecej;
    JLabel lblKolejkaPlikiKlient1;
    JLabel lblKolejkaPlikiKlient2;
    JLabel lblKolejkaPlikiKlient3;
    JLabel lblKolejkaPlikiKlient4;
    JLabel lblKolejkaPlikiKlient5;
    JLabel lblPlikiKlienta1;
    JLabel lblPlikiKlienta2;
    JLabel lblPlikiKlienta3;
    JLabel lblPlikiKlienta4;
    JLabel lblPlikiKlienta5;
    JLabel lblZajetePlikiKlienta1;
    JLabel lblZajetePlikiKlienta2;
    JLabel lblZajetePlikiKlienta3;
    JLabel lblZajetePlikiKlienta4;
    JLabel lblZajetePlikiKlienta5;
    JFrame frame;

    public GUI() {
        lblVPobierania = new JLabel();
        lblVPobierania.setText("Prędkość pobierania: 3MB/s");
        lblVPobierania.setBounds(370,0,270,50);
        lblVPobierania.setForeground(new Color(0xFF0000));
        lblVPobierania.setFont(new Font("TimesRoman", Font.BOLD ,20));

        lblWatek1 = new JLabel();
        lblWatek1.setText("Wątek 1");
        lblWatek1.setBounds(50,60, 100, 50);
        lblWatek1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        lblWagaPliku1 = new JLabel();
        lblWagaPliku1.setText("Waga pliku:   " + wagaPlikuWatek1 + "MB");
        lblWagaPliku1.setBounds(30, 90, 200, 50);
        lblWagaPliku1.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblPobieranie1 = new JLabel();
        lblPobieranie1.setText("Pobrano:        " + pobranoWatek1 + "MB");
        lblPobieranie1.setBounds(30, 110, 200, 50);
        lblPobieranie1.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblCzas1 = new JLabel();
        lblCzas1.setText("Pozostało:      " + pozostaloWatek1 + "s");
        lblCzas1.setBounds(30, 130, 200, 50);
        lblCzas1.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblKlient1 = new JLabel();
        lblKlient1.setText("Klient:              " + "#" + oblugiwanyKlientWatek1);
        lblKlient1.setBounds(30, 150, 200, 50);
        lblKlient1.setFont(new Font("TimesRoman", Font.BOLD, 12));

        lblWatek2 = new JLabel();
        lblWatek2.setText("Wątek 2");
        lblWatek2.setBounds(250,60, 100, 50);
        lblWatek2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        lblWagaPliku2 = new JLabel();
        lblWagaPliku2.setText("Waga pliku:   " + wagaPlikuWatek2 + "MB");
        lblWagaPliku2.setBounds(230, 90, 200, 50);
        lblWagaPliku2.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblPobieranie2 = new JLabel();
        lblPobieranie2.setText("Pobrano:        " + pobranoWatek2 + "MB");
        lblPobieranie2.setBounds(230, 110, 200, 50);
        lblPobieranie2.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblCzas2 = new JLabel();
        lblCzas2.setText("Pozostało:      " + pozostaloWatek2 + "s");
        lblCzas2.setBounds(230, 130, 200, 50);
        lblCzas2.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblKlient2 = new JLabel();
        lblKlient2.setText("Klient:              " + "#" + oblugiwanyKlientWatek2);
        lblKlient2.setBounds(230, 150, 200, 50);
        lblKlient2.setFont(new Font("TimesRoman", Font.BOLD, 12));

        lblWatek3 = new JLabel();
        lblWatek3.setText("Wątek 3");
        lblWatek3.setBounds(450,60, 100, 50);
        lblWatek3.setFont(new Font("TimesRoman", Font.BOLD, 15));
        lblWagaPliku3 = new JLabel();
        lblWagaPliku3.setText("Waga pliku:   " + wagaPlikuWatek3 + "MB");
        lblWagaPliku3.setBounds(430, 90, 200, 50);
        lblWagaPliku3.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblPobieranie3 = new JLabel();
        lblPobieranie3.setText("Pobrano:        " + pobranoWatek3 + "MB");
        lblPobieranie3.setBounds(430, 110, 200, 50);
        lblPobieranie3.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblCzas3 = new JLabel();
        lblCzas3.setText("Pozostało:      " + pozostaloWatek3 + "s");
        lblCzas3.setBounds(430, 130, 200, 50);
        lblCzas3.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblKlient3 = new JLabel();
        lblKlient3.setText("Klient:              " + "#" + oblugiwanyKlientWatek3);
        lblKlient3.setBounds(430, 150, 200, 50);
        lblKlient3.setFont(new Font("TimesRoman", Font.BOLD, 12));

        lblWatek4 = new JLabel();
        lblWatek4.setText("Wątek 4");
        lblWatek4.setBounds(650,60, 100, 50);
        lblWatek4.setFont(new Font("TimesRoman", Font.BOLD, 15));
        lblWagaPliku4 = new JLabel();
        lblWagaPliku4.setText("Waga pliku:   " + wagaPlikuWatek4 + "MB");
        lblWagaPliku4.setBounds(630, 90, 200, 50);
        lblWagaPliku4.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblPobieranie4 = new JLabel();
        lblPobieranie4.setText("Pobrano:        " + pobranoWatek4 + "MB");
        lblPobieranie4.setBounds(630, 110, 200, 50);
        lblPobieranie4.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblCzas4 = new JLabel();
        lblCzas4.setText("Pozostało:      " + pozostaloWatek4 + "s");
        lblCzas4.setBounds(630, 130, 200, 50);
        lblCzas4.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblKlient4 = new JLabel();
        lblKlient4.setText("Klient:              " + "#" + oblugiwanyKlientWatek4);
        lblKlient4.setBounds(630, 150, 200, 50);
        lblKlient4.setFont(new Font("TimesRoman", Font.BOLD, 12));

        lblWatek5 = new JLabel();
        lblWatek5.setText("Wątek 5");
        lblWatek5.setBounds(850,60, 100, 50);
        lblWatek5.setFont(new Font("TimesRoman", Font.BOLD, 15));
        lblWagaPliku5 = new JLabel();
        lblWagaPliku5.setText("Waga pliku:   " + wagaPlikuWatek5 + "MB");
        lblWagaPliku5.setBounds(830, 90, 200, 50);
        lblWagaPliku5.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblPobieranie5 = new JLabel();
        lblPobieranie5.setText("Pobrano:        " + pobranoWatek5 + "MB");
        lblPobieranie5.setBounds(830, 110, 200, 50);
        lblPobieranie5.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblCzas5 = new JLabel();
        lblCzas5.setText("Pozostało:      " + pobranoWatek5 + "s");
        lblCzas5.setBounds(830, 130, 200, 50);
        lblCzas5.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        lblKlient5 = new JLabel();
        lblKlient5.setText("Klient:              " + "#" + oblugiwanyKlientWatek5);
        lblKlient5.setBounds(830, 150, 200, 50);
        lblKlient5.setFont(new Font("TimesRoman", Font.BOLD, 12));

        lblKolejka = new JLabel();
        lblKolejka.setText("Kolejka");
        lblKolejka.setBounds(450,200,200,50);
        lblKolejka.setForeground(new Color(0x0000FF));
        lblKolejka.setFont(new Font("TimesRoman", Font.BOLD ,20));

        lblKolejkaKlient1 = new JLabel();
        lblKolejkaKlient1.setText("");
        lblKolejkaKlient1.setBounds(50, 250, 200, 50);
        lblKolejkaKlient1.setFont(new Font("TimesRoman", Font.PLAIN ,20));

        lblKolejkaKlient2 = new JLabel();
        lblKolejkaKlient2.setText("");
        lblKolejkaKlient2.setBounds(250, 250, 200, 50);
        lblKolejkaKlient2.setFont(new Font("TimesRoman", Font.PLAIN ,20));

        lblKolejkaKlient3 = new JLabel();
        lblKolejkaKlient3.setText("");
        lblKolejkaKlient3.setBounds(450, 250, 200, 50);
        lblKolejkaKlient3.setFont(new Font("TimesRoman", Font.PLAIN ,20));

        lblKolejkaKlient4 = new JLabel();
        lblKolejkaKlient4.setText("");
        lblKolejkaKlient4.setBounds(650, 250, 200, 50);
        lblKolejkaKlient4.setFont(new Font("TimesRoman", Font.PLAIN ,20));

        lblKolejkaKlient5 = new JLabel();
        lblKolejkaKlient5.setText("");
        lblKolejkaKlient5.setBounds(850, 250, 200, 50);
        lblKolejkaKlient5.setFont(new Font("TimesRoman", Font.PLAIN ,20));

        lblKolejkaKlientWiecej = new JLabel();
        lblKolejkaKlientWiecej.setText("");
        lblKolejkaKlientWiecej.setBounds(1000,250,250,50);
        lblKolejkaKlientWiecej.setFont(new Font("TimesRoman", Font.BOLD ,20));

        lblKolejkaPlikiKlient1 = new JLabel();
        lblKolejkaPlikiKlient1.setText("");
        lblKolejkaPlikiKlient1.setBounds(35,300,250,50);
        lblKolejkaPlikiKlient1.setFont(new Font("TimesRoman", Font.BOLD ,16));

        lblKolejkaPlikiKlient2 = new JLabel();
        lblKolejkaPlikiKlient2.setText("");
        lblKolejkaPlikiKlient2.setBounds(235,300,250,50);
        lblKolejkaPlikiKlient2.setFont(new Font("TimesRoman", Font.BOLD ,16));

        lblKolejkaPlikiKlient3 = new JLabel();
        lblKolejkaPlikiKlient3.setText("");
        lblKolejkaPlikiKlient3.setBounds(435,300,250,50);
        lblKolejkaPlikiKlient3.setFont(new Font("TimesRoman", Font.BOLD ,16));

        lblKolejkaPlikiKlient4 = new JLabel();
        lblKolejkaPlikiKlient4.setText("");
        lblKolejkaPlikiKlient4.setBounds(635,300,250,50);
        lblKolejkaPlikiKlient4.setFont(new Font("TimesRoman", Font.BOLD ,16));

        lblKolejkaPlikiKlient5 = new JLabel();
        lblKolejkaPlikiKlient5.setText("");
        lblKolejkaPlikiKlient5.setBounds(835,300,250,50);
        lblKolejkaPlikiKlient5.setFont(new Font("TimesRoman", Font.BOLD ,16));

        lblPlikiKlienta1 = new JLabel();
        lblPlikiKlienta1.setText("");
        lblPlikiKlienta1.setBounds(70,320,250,50);
        lblPlikiKlienta1.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblPlikiKlienta2 = new JLabel();
        lblPlikiKlienta2.setText("");
        lblPlikiKlienta2.setBounds(270,320,250,50);
        lblPlikiKlienta2.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblPlikiKlienta3 = new JLabel();
        lblPlikiKlienta3.setText("");
        lblPlikiKlienta3.setBounds(470,320,250,50);
        lblPlikiKlienta3.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblPlikiKlienta4 = new JLabel();
        lblPlikiKlienta4.setText("");
        lblPlikiKlienta4.setBounds(670,320,250,50);
        lblPlikiKlienta4.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblPlikiKlienta5 = new JLabel();
        lblPlikiKlienta5.setText("");
        lblPlikiKlienta5.setBounds(870,320,250,50);
        lblPlikiKlienta5.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblZajetePlikiKlienta1 = new JLabel();
        lblZajetePlikiKlienta1.setText("");
        lblZajetePlikiKlienta1.setBounds(90,320,250,50);
        lblZajetePlikiKlienta1.setForeground(new Color(0x00FF00));
        lblZajetePlikiKlienta1.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblZajetePlikiKlienta2 = new JLabel();
        lblZajetePlikiKlienta2.setText("");
        lblZajetePlikiKlienta2.setBounds(290,320,250,50);
        lblZajetePlikiKlienta2.setForeground(new Color(0x00FF00));
        lblZajetePlikiKlienta2.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblZajetePlikiKlienta3 = new JLabel();
        lblZajetePlikiKlienta3.setText("");
        lblZajetePlikiKlienta3.setBounds(490,320,250,50);
        lblZajetePlikiKlienta3.setForeground(new Color(0x00FF00));
        lblZajetePlikiKlienta3.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblZajetePlikiKlienta4 = new JLabel();
        lblZajetePlikiKlienta4.setText("");
        lblZajetePlikiKlienta4.setBounds(690,320,250,50);
        lblZajetePlikiKlienta4.setForeground(new Color(0x00FF00));
        lblZajetePlikiKlienta4.setFont(new Font("TimesRoman", Font.BOLD ,14));

        lblZajetePlikiKlienta5 = new JLabel();
        lblZajetePlikiKlienta5.setText("");
        lblZajetePlikiKlienta5.setBounds(890,320,250,50);
        lblZajetePlikiKlienta5.setForeground(new Color(0x00FF00));
        lblZajetePlikiKlienta5.setFont(new Font("TimesRoman", Font.BOLD ,14));

        btnDodajKlienta = new JButton();
        btnDodajKlienta.setBounds(410, 480, 150, 50);
        btnDodajKlienta.addActionListener(this);
        btnDodajKlienta.setText("Dodaj klienta");

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1100, 600);
        frame.setVisible(true);
        frame.add(lblVPobierania);
        frame.add(btnDodajKlienta);
        frame.add(lblWatek1);
        frame.add(lblWatek2);
        frame.add(lblWatek3);
        frame.add(lblWatek4);
        frame.add(lblWatek5);
        frame.add(lblWagaPliku1);
        frame.add(lblWagaPliku2);
        frame.add(lblWagaPliku3);
        frame.add(lblWagaPliku4);
        frame.add(lblWagaPliku5);
        frame.add(lblPobieranie1);
        frame.add(lblPobieranie2);
        frame.add(lblPobieranie3);
        frame.add(lblPobieranie4);
        frame.add(lblPobieranie5);
        frame.add(lblCzas1);
        frame.add(lblCzas2);
        frame.add(lblCzas3);
        frame.add(lblCzas4);
        frame.add(lblCzas5);
        frame.add(lblKlient1);
        frame.add(lblKlient2);
        frame.add(lblKlient3);
        frame.add(lblKlient4);
        frame.add(lblKlient5);
        frame.add(lblKolejka);
        frame.add(lblKolejkaKlient1);
        frame.add(lblKolejkaKlient2);
        frame.add(lblKolejkaKlient3);
        frame.add(lblKolejkaKlient4);
        frame.add(lblKolejkaKlient5);
        frame.add(lblKolejkaKlientWiecej);
        frame.add(lblKolejkaPlikiKlient1);
        frame.add(lblKolejkaPlikiKlient2);
        frame.add(lblKolejkaPlikiKlient3);
        frame.add(lblKolejkaPlikiKlient4);
        frame.add(lblKolejkaPlikiKlient5);
        frame.add(lblPlikiKlienta1);
        frame.add(lblPlikiKlienta2);
        frame.add(lblPlikiKlienta3);
        frame.add(lblPlikiKlienta4);
        frame.add(lblPlikiKlienta5);
        frame.add(lblZajetePlikiKlienta1);
        frame.add(lblZajetePlikiKlienta2);
        frame.add(lblZajetePlikiKlienta3);
        frame.add(lblZajetePlikiKlienta4);
        frame.add(lblZajetePlikiKlienta5);

        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDodajKlienta) {
            int minLiczbaPlikow = 1;
            int maxLiczbaPlikow = 100;
            int losowaLiczbaPlikow;
            losowaLiczbaPlikow = (int) (Math.random() * (maxLiczbaPlikow - minLiczbaPlikow + 1) + minLiczbaPlikow);
            Klient nowy = new Klient(losowaLiczbaPlikow);
            klienci.add(nowy);
            klienci.get(Klient.getCount() - 1).setWaga(0);
            System.out.println(klienci.get(Klient.getCount() - 1));
            iloscKlientowWKolejce = Klient.getCount();
        }
    }

    public List<Klient> getKlienci() {
        return klienci;
    }

    public int getOblugiwanyKlientWatek1() {
        return oblugiwanyKlientWatek1;
    }

    public void setOblugiwanyKlientWatek1(int oblugiwanyKlientWatek1) {
        this.oblugiwanyKlientWatek1 = oblugiwanyKlientWatek1;
    }

    public int getOblugiwanyKlientWatek2() {
        return oblugiwanyKlientWatek2;
    }

    public void setOblugiwanyKlientWatek2(int oblugiwanyKlientWatek2) {
        this.oblugiwanyKlientWatek2 = oblugiwanyKlientWatek2;
    }

    public int getOblugiwanyKlientWatek3() {
        return oblugiwanyKlientWatek3;
    }

    public void setOblugiwanyKlientWatek3(int oblugiwanyKlientWatek3) {
        this.oblugiwanyKlientWatek3 = oblugiwanyKlientWatek3;
    }

    public int getOblugiwanyKlientWatek4() {
        return oblugiwanyKlientWatek4;
    }

    public void setOblugiwanyKlientWatek4(int oblugiwanyKlientWatek4) {
        this.oblugiwanyKlientWatek4 = oblugiwanyKlientWatek4;
    }

    public int getOblugiwanyKlientWatek5() {
        return oblugiwanyKlientWatek5;
    }

    public void setOblugiwanyKlientWatek5(int oblugiwanyKlientWatek5) {
        this.oblugiwanyKlientWatek5 = oblugiwanyKlientWatek5;
    }

    public int getWagaPlikuWatek1() {
        return wagaPlikuWatek1;
    }

    public void setWagaPlikuWatek1(int wagaPlikuWatek1) {
        this.wagaPlikuWatek1 = wagaPlikuWatek1;
    }

    public int getWagaPlikuWatek2() {
        return wagaPlikuWatek2;
    }

    public void setWagaPlikuWatek2(int wagaPlikuWatek2) {
        this.wagaPlikuWatek2 = wagaPlikuWatek2;
    }

    public int getWagaPlikuWatek3() {
        return wagaPlikuWatek3;
    }

    public void setWagaPlikuWatek3(int wagaPlikuWatek3) {
        this.wagaPlikuWatek3 = wagaPlikuWatek3;
    }

    public int getWagaPlikuWatek4() {
        return wagaPlikuWatek4;
    }

    public void setWagaPlikuWatek4(int wagaPlikuWatek4) {
        this.wagaPlikuWatek4 = wagaPlikuWatek4;
    }

    public int getWagaPlikuWatek5() {
        return wagaPlikuWatek5;
    }

    public void setWagaPlikuWatek5(int wagaPlikuWatek5) {
        this.wagaPlikuWatek5 = wagaPlikuWatek5;
    }

    public int getPobranoWatek1() {
        return pobranoWatek1;
    }

    public void setPobranoWatek1(int pobranoWatek1) {
        this.pobranoWatek1 = pobranoWatek1;
    }

    public int getPobranoWatek2() {
        return pobranoWatek2;
    }

    public void setPobranoWatek2(int pobranoWatek2) {
        this.pobranoWatek2 = pobranoWatek2;
    }

    public int getPobranoWatek3() {
        return pobranoWatek3;
    }

    public void setPobranoWatek3(int pobranoWatek3) {
        this.pobranoWatek3 = pobranoWatek3;
    }

    public int getPobranoWatek4() {
        return pobranoWatek4;
    }

    public void setPobranoWatek4(int pobranoWatek4) {
        this.pobranoWatek4 = pobranoWatek4;
    }

    public int getPobranoWatek5() {
        return pobranoWatek5;
    }

    public void setPobranoWatek5(int pobranoWatek5) {
        this.pobranoWatek5 = pobranoWatek5;
    }

    public int getPozostaloWatek1() {
        return pozostaloWatek1;
    }

    public void setPozostaloWatek1(int pozostaloWatek1) {
        this.pozostaloWatek1 = pozostaloWatek1;
    }

    public int getPozostaloWatek2() {
        return pozostaloWatek2;
    }

    public void setPozostaloWatek2(int pozostaloWatek2) {
        this.pozostaloWatek2 = pozostaloWatek2;
    }

    public int getPozostaloWatek3() {
        return pozostaloWatek3;
    }

    public void setPozostaloWatek3(int pozostaloWatek3) {
        this.pozostaloWatek3 = pozostaloWatek3;
    }

    public int getPozostaloWatek4() {
        return pozostaloWatek4;
    }

    public void setPozostaloWatek4(int pozostaloWatek4) {
        this.pozostaloWatek4 = pozostaloWatek4;
    }

    public int getPozostaloWatek5() {
        return pozostaloWatek5;
    }

    public void setPozostaloWatek5(int pozostaloWatek5) {
        this.pozostaloWatek5 = pozostaloWatek5;
    }
}

