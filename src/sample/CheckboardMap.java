package sample;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CheckboardMap {
    private HashMap<Character, Integer> encodeMap;
    private HashMap<Integer, Character> decodeMap;

    public CheckboardMap(){
        this.encodeMap = new HashMap<Character, Integer>(){{
            put('q',0);put('w',1);put('e',3);put('t',6);put('y',7);put('u',8);put('i',9);
            put('o',40);put('p',41);put('a',42);put('s',43);put('d',44);put('f',45);put('g',46);put('h',47);put('j',48);put('k',49);
            put('l',20);put('z',21);put('x',22);put('c',23);put('v',24);put('b',25);put('n',26);put('m',27);put('ą',28);put('ć',29);
            put('ę',50);put('ł',51);put('ń',52);put('ó',53);put('ś',54);put('ż',55);put('ź',56);put('.',57);put(',',58);put('r',59);
            }};

        this.decodeMap = new HashMap<Integer, Character>(){{
            put(0,'q');put(1,'w');put(3,'e');put(6,'t');put(7,'y');put(8,'u');put(9,'i');
            put(40,'o');put(41,'p');put(42,'a');put(43,'s');put(44,'d');put(45,'f');put(46,'g');put(47,'h');put(48,'j');put(49,'k');
            put(20,'l');put(21,'z');put(22,'x');put(23,'c');put(24,'v');put(25,'b');put(26,'n');put(27,'m');put(28,'ą');put(29,'ć');
            put(50,'ę');put(51,'ł');put(52,'ń');put(53,'ó');put(54,'ś');put(55,'ż');put(56,'ź');put(57,'.');put(58,',');put(59,'r');
        }};
    }

    public String encodeText(String toEncode){
        ArrayList<Integer> encoded = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> codeKey = new ArrayList<>(List.of(2,3));
        for (int i=0; i<toEncode.length(); i++){
            encoded.add(encodeMap.get(toEncode.charAt(i)));
        }

        for (int i=0; i<encoded.size(); i++){
            if(encoded.get(i)<10){
                digits.add(encoded.get(i));
            }
            else {
                digits.add(encoded.get(i)/10);
                digits.add(encoded.get(i)%10);
            }
        }


        Integer j=0;
        for(int i=0; i<digits.size();i++){
            if(digits.get(i)+codeKey.get(j)>10){
                int temp = (digits.get(i)+codeKey.get(j))%10;
                digits.set(i, temp);
            }
            else
                digits.set(i, digits.get(i) + codeKey.get(j));
            if(j==1)
                j=0;
            else
                j++;
        }

        for (Integer i: digits){
            System.out.println(i);
        }

        digits.add(codeKey.get(0));
        digits.add(codeKey.get(1));

        return listIntToStrig(digits);
    }

    public String listIntToStrig(ArrayList<Integer> intList){
        String result = "";
        for (int i=0; i<intList.size();i++){
            result += intList.get(i);
        }
        return result;
    }

    public String decodeText(String toDecode){
        ArrayList<Character> decoded = new ArrayList<>();
        ArrayList<Integer> toDecodeInt = new ArrayList<>();

        for (int i=0; i<toDecode.length()-2;i+=2){
            int temp = toDecode.charAt(i)-'0';
            int temp2 = toDecode.charAt(i+1)-'0';
            int toArray = temp*10+temp2;
            toDecodeInt.add(toArray);
        }
        Integer lastKey = toDecode.charAt(toDecode.length()-1)-'0';
        Integer firstKey = toDecode.charAt(toDecode.length()-2)-'0';

        for(Integer i : toDecodeInt){
            System.out.println(i);
        }

        ArrayList<Integer> codeKey = new ArrayList<>(List.of(firstKey,lastKey));

        int j=0;
        for (int i=0; i<toDecodeInt.size()-2;i++){
            System.out.println(toDecodeInt.get(i));
            //if(toDecodeInt.get(i)-)

            toDecodeInt.set(i,toDecodeInt.get(i)/codeKey.get(j));
            System.out.println(toDecodeInt.get(i));
        }

        for (int i=0; i<toDecodeInt.size()-3; i++){
            if(toDecodeInt.get(i) == 0 || toDecodeInt.get(i) == 1 || toDecodeInt.get(i) == 2){
                decoded.add(decodeMap.get(i));
            }
            else {
                int int1 = toDecodeInt.get(i);
                int int2 = toDecodeInt.get(i + 1);
                int result = int1 * 10 + int2;
                decoded.add(decodeMap.get(result));
                i++;
            }
        }
        return listCharToString(decoded);
    }

    public String listCharToString(ArrayList<Character> charList){
        String result = "";
        for (int i=0; i<charList.size();i++){
            result += charList.get(i);
        }
        return result;

    }

}
