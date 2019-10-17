package sample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckboardMap {
    private HashMap<Integer, Character> myMap;

    public CheckboardMap(){
        myMap = new HashMap<Integer, Character>(){{
            put(0,'Q');put(1,'W');put(2,'E');put(30,'R');put(31,'T');
            put(32,'Y');put(33,'U');put(34,'I');put(35,'O');put(36,'P');
            put(37,'A');put(38,'S');put(39,'D');put(50,'F');put(51,'G');
            put(52,'H');put(53,'J');put(54,'K');put(55,'L');put(56,'Z');
            put(57,'A');put(58,'A');put(59,'A');put(1,'A');put(1,'A');
            put(1,'A');put(1,'A');put(1,'A');put(1,'A');put(1,'A');
            put(1,'A');put(1,'A');put(1,'A');put(1,'A');put(1,'A');
        }};
    }
}
