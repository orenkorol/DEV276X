public class Crypto {

    public static void main(String[] args) {

        String toNorm = normalizeText("This is some \"really\" great. (Text)!?");
        System.out.println(toNorm);

        System.out.println(caesarify(toNorm, -2));

        System.out.println(groupify("HITHERE", 2));
        System.out.println(groupify("HITHERE", 4));
        System.out.println(groupify("HITHEREORENK", 5));
        System.out.println(groupify("HITHEREORENKOROL", 6));

        System.out.println(encryptString("This is some \"really\" great. (Text)!?", 3, 3));

        System.out.println(ungroupify(encryptString("This is some \"really\" great. (Text)!?", 3, 3)));

        String cyphertext = encryptString("Who will win the election?", 5, 3);
        System.out.println(decryptString(cyphertext, 5));

    }


    public static String normalizeText(String text) {
        String result;
        result = text.replaceAll("\\p{Blank}", "");
        result = result.replaceAll("\\p{Punct}", "");
        result = result.toUpperCase();
        return result;
    }

    public static String caesarify(String s, int shift) {
        String alphabet = shiftAlphabet(shift);
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += alphabet.charAt(Math.abs((int) s.charAt(i) - 65));
        }
        return result;
    }

    //from john bryce content
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify(String stringToBreak, int groupSize) {
        String result = "";

        for (int i = 0; i < stringToBreak.length(); i++) {
            result += stringToBreak.charAt(i);
            if ((i + 1) % groupSize == 0 && (i + 1) < stringToBreak.length()) {
                result += " ";
            }
        }

        if (stringToBreak.length() % groupSize != 0) {
            int difference = groupSize - (stringToBreak.length() % groupSize);
            for (int i = 0; i < difference; i++) {
                result += "x";
            }

        }
        return result;
    }

    public static String encryptString(String toEncrypt, int shift, int groupSize) {
        String result;

        result = normalizeText(toEncrypt);
        result = caesarify(result, shift);
        result = groupify(result, groupSize);

        return result;
    }

    public static String ungroupify(String groupedString) {
        String result = "";
        int i = 0;

        while (i < groupedString.length() && groupedString.charAt(i) != 'x') {
            if (groupedString.charAt(i) != ' ') {
                result += groupedString.charAt(i);
            }
            i++;
        }

        return result;
    }

    public static String decryptString(String toDecrypt, int shift) {
        String result;

        result = ungroupify(toDecrypt);
        result = caesarify(result, shift * -1);

        return result;
    }

}
