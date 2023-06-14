
package project_kaffeeautomat;



public class Quiz {
    private String Frage="";
    private String Antwort0="";
    private String Antwort1="";
    private String Antwort2="";
    private String Antwort3="";
    Quiz (String Frage, String a0, String a1, String a2, String a3)  {
        this.Frage=Frage;
        Antwort0=a0;
        Antwort1=a1;
        Antwort2=a2;
        Antwort3=a3;
    }


    public String getFrage() {
        return Frage;
    }

    public String getAntworten(int nr) {
        String a="";
        if(nr==0) {
            a=Antwort0;
        }
        if (nr==1) {
            a=Antwort1;
        }
        if (nr==2) {
            a=Antwort2;
        }
        if (nr==3) {
            a=Antwort3;
        }
        return a;
    }

    public boolean pruefeAntwort(String A)  {
        return A.equals(Antwort0);
    
    }
}

