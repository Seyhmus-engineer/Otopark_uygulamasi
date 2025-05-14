package uygulama;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AnaClassTest {

    private void runMainWithInput(String input, String... expectedOutputs) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AnaClass.main(null);

        String output = outputStream.toString();
        for (String expected : expectedOutputs) {
            assertTrue("Beklenen çıktı bulunamadı: " + expected, output.contains(expected));
        }

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testSecim0_Cikis() throws Exception {
        runMainWithInput("0\n", "cikis yaptiniz");
    }

    @Test
    public void testSecim1_Ekle() throws Exception {
        runMainWithInput("1\n34ABC123\n10:00\n0\n", "plakalı arac otoparka eklendi");
    }

    @Test
    public void testSecim2_Cikis() throws Exception {
        runMainWithInput("1\n34DEF456\n10:00\n2\n34DEF456\n11:00\n0\n",
            "plakalı arac otoparktan ayrildi", "Ücret:");
    }

    @Test
    public void testSecim3_Yazdir() throws Exception {
        runMainWithInput("1\n34XYZ789\n09:00\n3\n0\n", "PLAKA", "34XYZ789");
    }

    @Test
    public void testSecim4_ToplamGelir() throws Exception {
        runMainWithInput("1\n34AAA111\n08:00\n2\n34AAA111\n10:00\n4\n0\n", "Toplam gelir:");
    }

    @Test
    public void testHataliSecim() throws Exception {
        runMainWithInput("9\n0\n", "hatali secim");
    }
}
