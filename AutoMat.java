package project_kaffeeautomat;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class AutoMat {
   
   
static Scanner eingabe = new Scanner(System.in);
    public static void main(String[] args) {
        Random zZahl= new Random();
        int auswahl=0, j=zZahl.nextInt(10);
        Quiz [] quiz = new Quiz[10];
        String[] RandomA = new String [4];
        String a="";
        
        quiz[0] = new Quiz ("Was ist ein Byte", "Eine Maßeinheit für Datenmengen", "Teil der Hardware",
       "Programmiersprache", "Ein Bildbearbeitungsprogramm");
       quiz[1] = new Quiz ("Vervollständige die Zahlenfolge: 2-7-6-11-10-15-14-?", 
               "19", "17", "18", "16");
       quiz[2] = new Quiz ("Was bedeutet die Abkürzung IT?", "Informationstechnologie", "Intelligenztest",
       "Informatik und Technik", "Integrationstaktik");
       quiz[3] = new Quiz ("Welche Begriffe bezeichnen eine Form des Speichers?", "eMMC",
       "CPU", "Cookie", "GPU"); 
       quiz[4] = new Quiz ("Aus wieviel Bits besteht eine IPv4-Adresse?",
               "32","128","64","1024");
       quiz[5] = new Quiz ("Welche Klasse ist die 127.0.0.1","A",
               "local-host","C","D");
       quiz[6] = new Quiz ("Welcher DOS-Befehl erstellt einen neuen Ordner?","md","del","copy","dir");
       quiz[7] = new Quiz ("Wieviele primäre Partitionen können auf einer Festplatte angelegt werden?",
               "4","unbegrenzt","16","2");
       quiz[8] = new Quiz ("Welche der Folgenden ist die größte Dateneinheit?",
               "Terabyte (TB)","Megabyte (MB)","Gigabyte (GB)","Kilobyte(kB)");
       quiz[9] = new Quiz ("Welche der folgenden ist die binäre Schreibweise?"
               ,"10110","3061","1982","0112011");
                
        HashSet<String> quizlist = new HashSet<>();
        
        
        
        for(int i=0; quizlist.size()<4; i++) {
            quizlist.add(quiz[j].getAntworten(zZahl.nextInt(4)));
        }
        a=(quizlist.toString().replace("[", "").replace("]", "")).trim();
        RandomA=a.split(", ");
        System.out.println(a);
        System.out.println(quiz[j].getFrage());
        for(int i=0; i<quizlist.size();i++) {
            System.out.println((i+1)+" "+RandomA[i]);
        }
        System.out.println("Antwort:");
        auswahl=eingabe.nextInt();
        
        System.out.println(RandomA[auswahl-1]);
        System.out.println(quiz[j].pruefeAntwort(RandomA[auswahl-1]));
        
    }
    
}
