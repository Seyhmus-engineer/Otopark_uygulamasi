package uygulama;

// Çift yönlü dairesel bağlı liste yapısı
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OtoList {

    Scanner k = new Scanner(System.in);

    OtoSinif bas = null;
    OtoSinif son = null;
    OtoSinif temp = bas;
    OtoSinif temp2 = temp;

    String plaka;
    String giris;
    String cikis;
    long dakika;
    double ucret;
    long ToplamUcret = 0;

    void ekle() {

        System.out.print("Otopark a giris yapacak aracın plakası: ");
        plaka = k.nextLine();
        System.out.print("Aracin giris zamanı(ss:dd)            : ");
        giris = k.nextLine();

        OtoSinif arac = new OtoSinif(plaka, giris);

        if (bas == null) {
            bas = arac;
            son = arac;

            bas.next = son;
            son.back = bas;
            bas.back = son;
            son.next = bas;
            System.out.println(plaka + " plakalı arac otoparka eklendi");
        } else {
            son.next = arac;
            arac.back = son;
            son = arac;
            son.next = bas;
            bas.back = son;
            System.out.println(plaka + " plakalı arac otoparka eklendi");
        }

    }

    void sil() throws ParseException {

        if (bas == null) {
            System.out.println("Otopark bos!");
        } else {

            System.out.print("Otopark a cikis yapacak aracın plakası: ");
            plaka = k.nextLine();
            System.out.print("Aracin cikis zamanı(ss:dd)            : ");
            cikis = k.nextLine();

            if (bas == son && bas.plaka.equals(plaka)) {
                ucrethesapla(bas, cikis);
                bas = null;
                son = null;
                System.out.println(plaka + " plakalı arac otoparktan ayrildi");
            } else if (bas != son && bas.plaka.equals(plaka)) {
                ucrethesapla(bas, cikis);
                bas = bas.next;
                bas.back = son;
                son.next = bas;
                System.out.println(plaka + " plakalı arac otoparktan ayrildi");
            } else {
                temp = bas;

                while (temp != son) {
                    if (temp.plaka.equals(plaka)) {
                        ucrethesapla(temp, cikis);
                        temp2.next = temp.next;
                        temp.next.back = temp2;
                        System.out.println(plaka + " plakalı arac otoparktan ayrildi");
                    }
                    temp2 = temp;
                    temp = temp.next;
                }
                if (temp.plaka.equals(plaka)) {
                    ucrethesapla(temp, cikis);
                    son = temp2;
                    son.next = bas;
                    bas.back = son;
                    System.out.println(plaka + " plakalı arac otoparktan ayrildi");
                }
            }
        }
    }

    void ucrethesapla(OtoSinif temp3, String cikis2) throws ParseException {

        giris = temp3.giris;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Date d1, d2;
        d1 = sdf.parse(giris);
        d2 = sdf.parse(cikis);

        dakika = d2.getTime() - d1.getTime();
        dakika = dakika / 60000;
        if ((dakika / 60) < 1) {
            ucret = 0 * (dakika / 60);
            System.out.println("1 saat den az kaldığınız için ücret talep etmiyoruz");
        } else if ((dakika / 60) >= 1 && (dakika / 60) <= 2) {
            ucret = 35 * (dakika / 60);
        } else if ((dakika / 60) > 2 && (dakika / 60) <= 4) {
            ucret = 50 * (dakika / 60);
        } else {
            ucret = 80 * (dakika / 60);
        }

        System.out.println("Aracin otopark kalis bilgileri:");
        System.out.println("Süre: " + dakika + " dk ");
        System.out.println("Ücret: " + ucret + " TL ");
        ToplamUcret += ucret;
    }

    void yazdir() {

        if (bas == null) {
            System.out.println("Otoparkta arac yok");
        } else {
            System.out.println("PLAKA \t\t GİRİŞ SAATİ");
            temp = bas;
            while (temp != son) {
                System.out.println(temp.plaka + "\t\t " + temp.giris);
                temp = temp.next;
            }
            System.out.println(temp.plaka + "\t\t " + temp.giris);
        }
    }

}
