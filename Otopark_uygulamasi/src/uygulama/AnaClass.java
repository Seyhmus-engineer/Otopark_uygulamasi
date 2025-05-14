package uygulama;

import java.text.ParseException;
import java.util.Scanner;

public class AnaClass {
    public static void main(String[] args) throws ParseException {
        Scanner k = new Scanner(System.in);
        OtoList list = new OtoList(k);
        int secim = -1;
        while (secim != 0) {
            System.out.println("1-otoparka arac girisi ");
            System.out.println("2-otoparktan arac cikisi  ");
            System.out.println("3-otoparktaki araclari listele ");
            System.out.println("4-toplam gelir( TL ) ");
            System.out.println("0-cikis");
            System.out.print("Seciminiz: ");
            secim = Integer.parseInt(k.nextLine());

            switch (secim) {
                case 1: list.ekle(); break;
                case 2: list.sil(); break;
                case 3: list.yazdir(); break;
                case 4: System.out.println("Toplam gelir: " + list.ToplamUcret + " TL "); break;
                case 0: System.out.println("cikis yaptiniz.."); break;
                default: System.out.println("hatali secim! [0-4]"); break;
            }
        }
    }
}
