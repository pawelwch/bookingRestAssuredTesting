package tests;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class HelperMethods {

    static private StringBuilder stringBuilder = new StringBuilder();
    static private Random random = new Random();
    private final static char [] chars = "abcdefghijklmnoprstuwxyz".toCharArray();

    /**Metoda, ktora generuje 9cyfrowy numer telefonu, zaczynajacy sie na "1". Ze względów bezpieczeństwa
     * @return zwraca numer telefonu */
    public static String generatePhone() {
        return "8" + (RandomStringUtils.randomNumeric(10));
    }

    /** Metoda generuje losowe Stringi
     * @param length podajemy dlugosc danego lancucha
     * @return zwraca losowy ciag znaków. Przydatne podczas uzupelniania takich danych jak Imie czy Nazwisko */
    public static String generateRandomString (int length) {
        for (int i=0; i<length; i++) {
            stringBuilder.append(chars[random.nextInt(length)]);
        }
        return stringBuilder.toString();
    }
}
