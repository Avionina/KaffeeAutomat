package project_kaffeeautomat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import static project_kaffeeautomat.AutoMat.eingabe;

/**
 * @author MMoschkau
 */
public class AutomatProgramm {

//    public static Scanner eing = new Scanner(System.in);
    public static void main(String[] args) {
        int zaehler = 0;
        ArrayList Bestand = new ArrayList();
        lagerauffuellen(Bestand);
        start(Bestand, zaehler);

    }

    public static void lagerauffuellen(ArrayList Bestand) {
        Bestand.add(new Kompunenten(100, "Becher", 10, 0));
        Bestand.add(new Kaffee(11, "Kaffee", 10, 0.5));
        Bestand.add(new Tee(21, "Schwarzer Tee", 5, 0.5));
        Bestand.add(new Tee(22, "Grüner Tee", 5, 0.5));
        Bestand.add(new Kompunenten(101, "Milch", 10, 0.05));
        Bestand.add(new Kompunenten(102, "Zucker", 10, 0.05));
        Bestand.add(new Kompunenten(103, "Wasser", 10, 0.05));
        Bestand.add(new Suppe(31, "Tomatensuppe", 10, 0.5));
        Bestand.add(new Suppe(32, "Linsensuppe", 10, 0.5));
        Bestand.add(new Suppe(33, "Gemüsesuppe", 10, 0.5));
        Bestand.add(new Geld(201, "2 Euro", 10, 0.0));
        Bestand.add(new Geld(202, "1 Euro", 10, 0.0));
        Bestand.add(new Geld(203, "50 Cent", 10, 0.0));
        Bestand.add(new Geld(204, "20 Cent", 10, 0.0));
        Bestand.add(new Geld(205, "10 Cent", 10, 0.0));
        Bestand.add(new Geld(206, "5 Cent", 10, 0.0));
    }

    public static void start(ArrayList Bestand, int zaehler) {
        Scanner eing = new Scanner(System.in);
        boolean automatoffen = false;
        try {
            System.out.println("******************************");
            System.out.println("************Auswahl***********");
            System.out.println("*************Menü*************");
            System.out.printf("1.\t\t\tKaffee\n");
            System.out.printf("2.\t\t\t   Tee\n");
            System.out.println("3.\t\t\t Suppe");
            System.out.println("4.\t\t    Heißwasser");
            System.out.println("******************************");
            System.out.println("9.\t\t  Kundenwunsch");
            System.out.print("Eingabe :");
            int aus = eing.nextInt();
            switch (aus) {
                case 1:
                    kaffeestart(Bestand, zaehler);
                    break;
                case 2:
                    teestart(Bestand, zaehler);
                    break;
                case 3:
                    suppestart(Bestand, zaehler);
                    break;
                case 4:
                    hwstart(Bestand, zaehler);
                    break;
                case 9:
                    kundenwunsch(Bestand, zaehler);
                    break;
                case 100:
                    break;
                case 9001:
                    automatoffen = true;
                    einbruch(automatoffen, Bestand);
                    break;
                default:
                    System.out.println("Falsche Eingabe.");

                    start(Bestand, zaehler);
            }
        } catch (InputMismatchException IME) {
            System.out.println("Falsche Eingabe");
        }
    }

    public static void kaffeestart(ArrayList Bestand, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.printf("1.\t\t\tKaffee\n");
        System.out.printf("2.\t       Latte Macchiato\n");
        System.out.println("3.\t\t\t Mocca");
        System.out.println("4.\t\t      Espresso");
        System.out.print("Eingabe :");
        int aus = eing.nextInt();
        double preis = 0;
        switch (aus) {
            case 1:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 11) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }

                    if (a.getNummer() == 103) {
                        a.setAnzahl(a.getAnzahl() - 2);
                        preis += a.getPreis();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 11) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                    if (a.getNummer() == 101) {
                        a.setAnzahl(a.getAnzahl() - 2);
                        preis += a.getPreis();
                    }
                }
                break;
            case 3:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 11) {
                        a.setAnzahl(a.getAnzahl() - 3);
                        preis += a.getPreis();
                    }
                    if (a.getNummer() == 103) {
                        a.setAnzahl(a.getAnzahl() - 2);
                        preis += a.getPreis();
                    }
                }
                break;
            case 4:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 11) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                    if (a.getNummer() == 103) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                }
                break;
            default:
                System.out.println("Falsche Eingabe");
                kaffeestart(Bestand, zaehler);
        }
        zuckerWahl(Bestand, preis, zaehler);
    }

    public static void teestart(ArrayList Bestand, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.printf("1.\t\t Schwarzer Tee\n");
        System.out.printf("2.\t\t    Grüner Tee\n");
        System.out.print("Eingabe :");
        int aus = eing.nextInt();
        double preis = 0;
        switch (aus) {
            case 1:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 21) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                    if (a.getNummer() == 103) {
                        a.setAnzahl(a.getAnzahl() - 2);
                        preis += a.getPreis();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 22) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                        System.out.println(a);
                    }
                    if (a.getNummer() == 103) {
                        a.setAnzahl(a.getAnzahl() - 2);
                        preis += a.getPreis();
                    }
                }
                break;
            default:
                System.out.println("Falsche Eingabe");
                teestart(Bestand, zaehler);
        }
        zuckerWahl(Bestand, preis, zaehler);

    }

    public static void hwstart(ArrayList Bestand, int zaehler) {
        double preis = 0;
        for (int i = 0; i < Bestand.size(); i++) {
            Vorrat a = (Vorrat) Bestand.get(i);
            if (a.getNummer() == 103) {
                a.setAnzahl(a.getAnzahl() - 2);
                preis += a.getPreis();
            }
        }
        becherWahl(Bestand, preis, zaehler);
    }

    public static void suppestart(ArrayList Bestand, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.printf("1.\t\t  Tomatensuppe\n");
        System.out.printf("2.\t\t   Linsensuppe\n");
        System.out.println("3.\t\t   Gemüsesuppe\n");
        System.out.print("Eingabe :");
        int aus = eing.nextInt();
        double preis = 0;
        switch (aus) {
            case 1:

                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 1) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 1) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();

                    }
                }
                break;
            case 3:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 1) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        System.out.println(a.getAnzahl());
                        preis += a.getPreis();

                    }
                }
                break;
            default:
                System.out.println("Falsche Eingabe");
                suppestart(Bestand, zaehler);
        }
    }

    public static void zuckerWahl(ArrayList Bestand, double preis, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.println("1.\t\t    mit Zucker");
        System.out.println("2.\t\t   ohne Zucker");
        System.out.print("Eingabe :");
        int aus = eing.nextInt();
        switch (aus) {

            case 1:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 102) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Falsch Eingabe");
                zuckerWahl(Bestand, preis, zaehler);
        }
        milchWahl(Bestand, preis, zaehler);
    }

    public static void milchWahl(ArrayList Bestand, double preis, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.println("1.\t\t     mit Milch");
        System.out.println("2.\t\t    ohne Milch");
        System.out.print("Eingabe :");
        int aus = eing.nextInt();
        switch (aus) {
            case 1:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 101) {
                        a.setAnzahl(a.getAnzahl() - 1);
                        preis += a.getPreis();
                    }
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Falsche Eingabe");
                milchWahl(Bestand, preis, zaehler);
        }
        becherWahl(Bestand, preis, zaehler);
    }

    public static void becherWahl(ArrayList Bestand, double preis, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.println("1.\t\t    mit Becher");
        System.out.println("2.\t\t   ohne Becher");
        System.out.print("Eingabe :");
        int aus = eing.nextInt();
        switch (aus) {
            case 1:
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 100) {
                        a.setAnzahl(a.getAnzahl() - 1);
                    }
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Falsche Eingabe");
                becherWahl(Bestand, preis, zaehler);
        }
        preis(Bestand, preis, zaehler);
    }

    public static void preis(ArrayList Bestand, double preis, int zaehler) {
        Scanner eing = new Scanner(System.in);
        double betrag = 0;
        System.out.println("******************************");
        System.out.println("************Auswahl***********");
        System.out.println("*************Menü*************");
        System.out.println("**Quiz für ein Gratis Produkt*");
        System.out.println("1.                          Ja");
        System.out.println("2.                        Nein");

        System.out.print("Eingabe :");
        int aus = eing.nextInt();

        if (aus == 1) {
            try {
                preis = quiz(preis);
            } catch (InputMismatchException IME) {
                System.out.println("Falsche Eingabe");
            } catch (ArrayIndexOutOfBoundsException AIE) {
                System.out.println("Falsche Eingabe");
            }
        }
        double preis2 = preis;
        while (preis > betrag) {
            System.out.printf("Der Preis beträgt %.2f\n", preis);
            System.out.println("Bitte Betrag einwerfen");
            System.out.println("Eingabe:");
            betrag += eing.nextDouble();
        }
        preis2 = betrag;
        while (betrag != 0.0) {
            if (betrag >= 2.00) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 201) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        betrag -= 2.00;
                    }
                }
            } else if (betrag >= 1.00) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 202) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        betrag -= 1.00;
                    }
                }
            } else if (betrag >= 0.50) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 203) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        betrag -= 0.50;
                    }
                }
            } else if (betrag >= 0.20) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 204) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        betrag -= 0.20;
                    }
                }
            } else if (betrag >= 0.10) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 205) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        betrag -= 0.10;
                    }
                }
            } else if (betrag >= 0.05) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 206) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        betrag -= 0.05;
                    }
                }
            }
        }
        if (preis2 > preis) {
            preis2 = preis2 - preis;
            System.out.printf("Ihr Rückgeld Beträgt %.2f\n", preis2);
            System.out.println("******************************");
        }
        while (preis2 > 0.04) {
            if (preis2 >= 2.00) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 201) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        preis2 = preis2 - 2.00;
                        System.out.println("Ausgabe: 2€");
                    }
                }
            } else if (preis2 >= 1.00) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 202) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        preis2 = preis2 - 1.00;
                        System.out.println("Ausgabe: 1€");
                    }
                }
            } else if (preis2 >= 0.50) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 203) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        preis2 = preis2 - 0.50;
                        System.out.println("Ausgabe: 0,50€");
                    }
                }
            } else if (preis2 >= 0.20) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 204) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        preis2 = preis2 - 0.20;
                        System.out.println("Ausgabe: 0,20€");
                    }
                }
            } else if (preis2 >= 0.10) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 205) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        preis2 = preis2 - 0.10;
                        System.out.println("Ausgabe: 0,10€");
                    }
                }
            } else if (preis2 >= 0.04) {
                for (int i = 0; i < Bestand.size(); i++) {
                    Vorrat a = (Vorrat) Bestand.get(i);
                    if (a.getNummer() == 206) {
                        a.setAnzahl(a.getAnzahl() + 1);
                        preis2 = preis2 - 0.05;
                        System.out.println("Ausgabe: 0,05€");
                    }
                }

            }
        }
        zaehler++;
        if (zaehler == 2) {
            System.out.println("Starte Selbstreinigung");
            zaehler = 0;
            System.out.println("******************************");
        }

        pruefen(Bestand);
        start(Bestand, zaehler);

    }

    public static double quiz(double preis) {
        Random zZahl = new Random();
        int auswahl = 0, j = zZahl.nextInt(10);
        Quiz[] quiz = new Quiz[10];
        String[] RandomA = new String[4];
        String a = "";

        quiz[0] = new Quiz("Was ist ein Byte", "Eine Maßeinheit für Datenmengen", "Teil der Hardware",
                "Programmiersprache", "Ein Bildbearbeitungsprogramm");
        quiz[1] = new Quiz("Vervollständige die Zahlenfolge: 2-7-6-11-10-15-14-?",
                "19", "17", "18", "16");
        quiz[2] = new Quiz("Was bedeutet die Abkürzung IT?", "Informationstechnologie", "Intelligenztest",
                "Informatik und Technik", "Integrationstaktik");
        quiz[3] = new Quiz("Welche Begriffe bezeichnen eine Form des Speichers?", "eMMC",
                "CPU", "Cookie", "GPU");
        quiz[4] = new Quiz("Aus wieviel Bits besteht eine IPv4-Adresse?",
                "32", "128", "64", "1024");
        quiz[5] = new Quiz("Welche Klasse ist die 127.0.0.1", "A",
                "local-host", "C", "D");
        quiz[6] = new Quiz("Welcher DOS-Befehl erstellt einen neuen Ordner?", "md", "del", "copy", "dir");
        quiz[7] = new Quiz("Wieviele primäre Partitionen können auf einer Festplatte angelegt werden?",
                "4", "unbegrenzt", "16", "2");
        quiz[8] = new Quiz("Welche der Folgenden ist die größte Dateneinheit?",
                "Terabyte (TB)", "Megabyte (MB)", "Gigabyte (GB)", "Kilobyte(kB)");
        quiz[9] = new Quiz("Welche der folgenden ist die binäre Schreibweise?",
                "10110", "3061", "1982", "0112011");

        HashSet<String> quizlist = new HashSet<>();

        for (int i = 0; quizlist.size() < 4; i++) {
            quizlist.add(quiz[j].getAntworten(zZahl.nextInt(4)));
        }
        a = (quizlist.toString().replace("[", "").replace("]", "")).trim();
        RandomA = a.split(", ");
        System.out.println(a);
        System.out.println(quiz[j].getFrage());
        for (int i = 0; i < quizlist.size(); i++) {
            System.out.println((i + 1) + " " + RandomA[i]);
        }
        System.out.println("Antwort:");
        auswahl = eingabe.nextInt();

        System.out.println(RandomA[auswahl - 1]);
        boolean richtig = quiz[j].pruefeAntwort(RandomA[auswahl - 1]);
        System.out.println(quiz[j].pruefeAntwort(RandomA[auswahl - 1]));

        if (richtig == true) {
            preis = 0.0;
        }
        System.out.println("******************************");
        return preis;
    }

    public static void pruefen(ArrayList Bestand) {

        for (int i = 0; i < Bestand.size(); i++) {
            Vorrat a = (Vorrat) Bestand.get(i);
            if (a.getAnzahl() < 5) {
                System.out.println("Schreibe Email");
                System.out.println("Es mangelt an:");
                System.out.println(a.getName());
                System.out.println("Anzahl " + a.getAnzahl());
                System.out.println("******************************");

            }
        }
    }

    public static void einbruch(boolean offen, ArrayList Bestand) {
        if (offen == true) {
            System.out.println("Rüttel,Rüttel");
            System.out.println("Knarz Tür öffnet sich");
            System.out.println("Löse Alarm aus");
            System.out.println("Schreibe EMail");
            System.out.println("Anruf 112");

        } else if (offen == false) {
            pruefen(Bestand);

        }

    }

    public static void kundenwunsch(ArrayList Bestand, int zaehler) {
        Scanner eing = new Scanner(System.in);
        System.out.println("Bitte geben Sie ihren Wunsch ein Beenden mit ##");
        String d = "##";
        String b = "";
        while (eing.hasNext()) {

            if (eing.hasNext(d)) {
                break;
            } else {
                try {
                    b = b + "\n" + eing.nextLine();
                } catch (IllegalStateException ile) {
                    System.out.println("Es ist ein Fehler aufgetretenm.\nMöglicherweise steht das Eingabegerät nicht mehr zur Verfügung");
                }
            }
        }
        System.out.println("Sende Email mit dem Inhalt\n" + b);
        start(Bestand, zaehler);

    }
}
