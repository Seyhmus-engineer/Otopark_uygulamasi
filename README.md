# Otopark Yönetim Sistemi

Bu proje, bir otopark yönetim sistemini simüle eden bir Java uygulamasıdır. Araçların giriş ve çıkış saatlerini takip ederek otopark ücretlerini hesaplar ve toplam geliri kaydeder.

## Özellikler
- **Araç ekleme:** Kullanıcıdan plaka ve giriş saatini alarak otoparka ekler.
- **Araç çıkarma:** Kullanıcıdan plaka ve çıkış saatini alarak otoparktan çıkarır ve ücreti hesaplar.
- **Ücret hesaplama:** Araçların otoparkta kaldığı süreye göre dinamik ücret hesaplar.
- **Araç listeleme:** Otoparktaki mevcut araçları listeler.
- **Toplam gelir hesaplama:** Otoparkın elde ettiği toplam ücreti görüntüler.

## Kullanım
Program, ana menü üzerinden kullanıcıya çeşitli seçenekler sunar:

```
1- Otoparka araç girişi
2- Otoparktan araç çıkışı
3- Otoparktaki araçları listele
4- Toplam gelir (TL)
0- Çıkış
```

## Çalıştırma Talimatları
1. Java'nın sisteminizde kurulu olduğundan emin olun.
2. Proje dosyalarını bir Java projesi olarak açın.
3. Ana sınıf olarak `AnaClass` dosyasını çalıştırın.
4. Terminal veya konsoldan menü seçeneklerini kullanarak programı yönetin.

## Ücretlendirme Politikası
- **İlk 1 saat ücretsizdir.**
- **1-2 saat:** 35 TL / saat
- **2-4 saat:** 50 TL / saat
- **4 saat ve üzeri:** 80 TL / saat

## Gereksinimler
- Java 8 veya üstü
- Derleyici veya IDE (Eclipse, IntelliJ IDEA, NetBeans vs.)

## Örnek Kullanım
```
Otoparka giriş yapacak aracın plakası: 34ABC123
Aracın giriş zamanı (ss:dd): 14:30
34ABC123 plakalı araç otoparka eklendi.

Otoparka çıkış yapacak aracın plakası: 34ABC123
Aracın çıkış zamanı (ss:dd): 16:45
Süre: 135 dk
Ücret: 100 TL
34ABC123 plakalı araç otoparktan ayrıldı.
```

## Lisans
Bu proje açık kaynaklıdır ve dilediğiniz gibi kullanılabilir.

