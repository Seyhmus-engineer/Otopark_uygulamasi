
package uygulama;


public class OtoSinif {
    
    String plaka;
    String giris;
    String cikis;
    long dakika;
    double ucret;
    
    OtoSinif next;
    OtoSinif back;

    public OtoSinif(String plaka, String giris) {
        this.plaka = plaka;
        this.giris = giris;
        this.next=null;
        this.back=null;
    }
    
    
    
    
}
