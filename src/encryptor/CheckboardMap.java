package encryptor;

import java.util.*;
import java.util.List;

public class CheckboardMap {
    private HashMap<Character, Integer> encodeMap;
    private HashMap<Integer, Character> decodeMap;

    public CheckboardMap() {
        this.encodeMap = new HashMap<Character, Integer>() {{
            put('o', 40);
            put('p', 41);
            put('a', 42);
            put('s', 43);
            put('d', 44);
            put('f', 45);
            put('g', 46);
            put('h', 47);
            put('j', 48);
            put('k', 49);
            put('l', 20);
            put('z', 21);
            put('x', 22);
            put('c', 23);
            put('v', 24);
            put('b', 25);
            put('n', 26);
            put('m', 27);
            put('ą', 28);
            put('ć', 29);
            put('ę', 50);
            put('ł', 51);
            put('ń', 52);
            put('ó', 53);
            put('ś', 54);
            put('ż', 55);
            put('ź', 56);
            put('.', 57);
            put(',', 58);
            put('r', 59);
            put('w', 10);
            put(' ', 11);
            put('q', 12);
            put('e', 13);
            put('t', 14);
            put('y', 15);
            put('u', 16);
            put('i', 17);
        }};

        this.decodeMap = new HashMap<Integer, Character>() {{
            put(40, 'o');
            put(41, 'p');
            put(42, 'a');
            put(43, 's');
            put(44, 'd');
            put(45, 'f');
            put(46, 'g');
            put(47, 'h');
            put(48, 'j');
            put(49, 'k');
            put(20, 'l');
            put(21, 'z');
            put(22, 'x');
            put(23, 'c');
            put(24, 'v');
            put(25, 'b');
            put(26, 'n');
            put(27, 'm');
            put(28, 'ą');
            put(29, 'ć');
            put(50, 'ę');
            put(51, 'ł');
            put(52, 'ń');
            put(53, 'ó');
            put(54, 'ś');
            put(55, 'ż');
            put(56, 'ź');
            put(57, '.');
            put(58, ',');
            put(59, 'r');
            put(10, 'w');
            put(11, ' ');
            put(12, 'q');
            put(13, 'e');
            put(14, 't');
            put(15, 'y');
            put(16, 'u');
            put(17, 'i');
        }};
    }

    public String encodeText(String toEncode) {
        ArrayList<Integer> encoded = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> codeKey = new ArrayList<>(List.of(7, 5));
        toEncode = toEncode.toLowerCase();
        for (int i = 0; i < toEncode.length(); i++) {
            encoded.add(encodeMap.get(toEncode.charAt(i)));
        }

        for (int i = 0; i < encoded.size(); i++) {
            if (encoded.get(i) < 10) {
                digits.add(encoded.get(i));
            } else {
                digits.add(encoded.get(i) / 10);
                digits.add(encoded.get(i) % 10);
            }
        }


        Integer j = 0;
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) + codeKey.get(j) >= 10) {
                int temp = (digits.get(i) + codeKey.get(j)) % 10;
                digits.set(i, temp);
            } else
                digits.set(i, digits.get(i) + codeKey.get(j));
            if (j == 1)
                j = 0;
            else
                j++;
        }

        digits.add(codeKey.get(0));
        digits.add(codeKey.get(1));

        return listIntToString(digits);
    }

    public String listIntToString(ArrayList<Integer> intList) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < intList.size(); i++) {
            result.append(intList.get(i));
        }
        return result.toString();
    }

    public String decodeText(String toDecode) {
        ArrayList<Character> decoded = new ArrayList<>();
        ArrayList<Integer> toDecodeInt = new ArrayList<>();

        for (int i = 0; i < toDecode.length() - 2; i++) {
            int temp = toDecode.charAt(i) - '0';
            int toArray = temp;
            toDecodeInt.add(toArray);
        }
        Integer lastKey = toDecode.charAt(toDecode.length() - 1) - '0';
        Integer firstKey = toDecode.charAt(toDecode.length() - 2) - '0';

        ArrayList<Integer> codeKey = new ArrayList<>(List.of(firstKey, lastKey));

        Integer j = 0;
        for (int i = 0; i < toDecodeInt.size(); i++) {
            if (toDecodeInt.get(i) - codeKey.get(j) < 0) {
                int temp = (toDecodeInt.get(i) + 10 - codeKey.get(j));
                toDecodeInt.set(i, temp);
            } else
                toDecodeInt.set(i, toDecodeInt.get(i) - codeKey.get(j));
            if (j == 1)
                j = 0;
            else
                j++;
        }

        for (int i = 0; i < toDecodeInt.size(); i++) {
            if (toDecodeInt.get(i) == 1 || toDecodeInt.get(i) == 2 || toDecodeInt.get(i) == 4 || toDecodeInt.get(i) == 5) {
                int temp = (toDecodeInt.get(i) * 10) + toDecodeInt.get(i + 1);
                decoded.add(decodeMap.get(temp));
                i++;
            } else {
                decoded.add(decodeMap.get(toDecodeInt.get(i)));
                System.out.println(decoded.get(i));
            }
        }

        return listCharToString(decoded);
    }

    public String listCharToString(ArrayList<Character> charList) {
        StringBuilder result = new StringBuilder();
        for (Character character : charList) {
            result.append(character);
        }
        return result.toString();
    }
}
