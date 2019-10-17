package sample;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CheckboardMap {
    private HashMap<Character, Integer> encodeMap;
    private HashMap<Integer, Character> decodeMap;

    public CheckboardMap(){
        this.encodeMap = new HashMap<Character, Integer>(){{
            put('Q',0);put('W',1);put('E',2);
            put('R',30);put('T',31);put('Y',32);put('U',33);put('I',34);put('O',35);put('P',36);put('A',37);put('S',38);put('D',39);
            put('F',50);put('G',51);put('H',52);put('J',53);put('K',54);put('L',55);put('Z',56);put('X',57);put('C',58);put('V',59);
            put('B',80);put('N',81);put('M',82);put('Ą',83);put('Ć',84);put('Ł',85);put('Ń',86);put('Ó',87);put('Ż',88);put('Ź',89);
            put(',',40);put('.',41);put('q',42);put('w',43);put('e',44);put('r',45);put('t',46);put('y',47);put('u',48);put('i',49);
            put('o',60);put('p',61);put('a',62);put('s',63);put('d',64);put('f',65);put('g',66);put('h',67);put('j',68);put('k',69);
            put('l',90);put('z',91);put('x',92);put('c',93);put('v',94);put('b',95);put('n',96);put('m',97);put('ą',98);put('ć',99);
            put('ł',70);put('ń',71);put('ó',72);put('ż',73);put('ź',74);put('ś',75);put('Ś',76);put(' ',77);
        }};

        this.decodeMap = new HashMap<Integer, Character>(){{
            put(0,'Q');put(1,'W');put(2,'E');
            put(30,'R');put(31,'T');put(32,'Y');put(33,'U');put(34,'I');put(35,'O');put(36,'P');put(37,'A');put(38,'S');put(39,'D');
            put(50,'F');put(51,'G');put(52,'H');put(53,'J');put(54,'K');put(55,'L');put(56,'Z');put(57,'X');put(58,'C');put(59,'V');
            put(80,'B');put(81,'N');put(82,'M');put(83,'Ą');put(84,'Ć');put(85,'Ł');put(86,'Ń');put(87,'Ó');put(88,'Ż');put(89,'Ź');
            put(40,',');put(41,'.');put(42,'q');put(43,'w');put(44,'e');put(45,'r');put(46,'t');put(47,'y');put(48,'u');put(49,'i');
            put(60,'o');put(61,'p');put(62,'a');put(63,'s');put(64,'d');put(65,'f');put(66,'g');put(67,'h');put(68,'j');put(69,'k');
            put(90,'l');put(91,'z');put(92,'x');put(93,'c');put(94,'v');put(95,'b');put(96,'n');put(97,'m');put(98,'ą');put(99,'ć');
            put(70,'ł');put(71,'ń');put(72,'ó');put(73,'ż');put(74,'ź');put(75,'ś');put(76,'Ś');put(77,' ');
        }};
    }

    public String encodeText(String toEncode){
        ArrayList<Integer> encoded = new ArrayList<>();
        ArrayList<Integer> codeKey = new ArrayList<>(List.of(2,3,4));
        for (int i=0; i<toEncode.length(); i++){
            encoded.add(encodeMap.get(toEncode.charAt(i)));
        }
        Integer j=0;
            for (int i = 0; i < encoded.size(); i++) {
                encoded.set(i, encoded.get(i) * codeKey.get(j));
                if(j==2)
                    j=0;
                else
                    j++;
            }
        encoded.add(codeKey.get(0));
        encoded.add(codeKey.get(1));
        encoded.add(codeKey.get(2));
        return listIntToStrig(encoded);
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

        for (int i=0; i<toDecode.length();i++){
            int temp = toDecode.charAt(i)-'0';
            toDecodeInt.add(temp);
        }
        Integer lastKey = toDecodeInt.get(toDecodeInt.size()-1);
        Integer midKey = toDecodeInt.get(toDecodeInt.size()-2);
        Integer firstKey = toDecodeInt.get(toDecodeInt.size()-3);

        ArrayList<Integer> codeKey = new ArrayList<>(List.of(firstKey,midKey,lastKey));

        int j=0;
        for (int i=0; i<toDecodeInt.size()-3;i++){
            System.out.println(toDecodeInt.get(i));
            toDecodeInt.set(i,toDecodeInt.get(i)/codeKey.get(j));
            if(j==2)
                j=0;
            else
                j++;
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
