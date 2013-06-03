package topic6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BadAnagramTest {
    
    BadAnagram anagram = null;
    
    @Before
    public void beforeTest()
    {
       System.out.println("=====================A new case start=====================");
//       anagram = new BadAnagram("longwords.dict");
       anagram = new BadAnagram("simple.dict");
    }
    
    @After
    public void afterTest()
    {
        System.out.println("=====================A new case end=======================");
    }
    
    @Test
    public void testTimeOfSorted() throws InterruptedException{
        anagram.loadDictionary();
        Long timestamp1 = System.currentTimeMillis();
        anagram.buildMap();
        Long timestamp2 = System.currentTimeMillis();
        System.out.println("The time when start buliding the map is:" + timestamp1);
        System.out.println("The time when end buliding the map is:" + timestamp2);
        System.out.println("The total mill seconds are:" + (timestamp2 - timestamp1));
    }
    
    @Test
    public void testInfo(){
        anagram.loadDictionary();
        anagram.buildMap();
        anagram.infoOfSingleWords();
        anagram.sizeOfMap();
    }

    @Test
    public void testOk() {
        String s = "abc";
        ArrayList<Character> charList = new ArrayList<Character>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            charList.add(ch[i]);
        }
        
        String[] so = new String[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            so[i] = String.valueOf(charList.get(i));
        }
        System.out.println(so.toString());
        
        String[] sk = {"m", "n"};
        StringBuffer sb = new StringBuffer();
        for (String t : sk)
            sb.append(t);
        System.out.println(sb.toString());
        

    }
}
