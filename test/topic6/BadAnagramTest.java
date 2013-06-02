package topic6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BadAnagramTest {
    
    Anagram anagram = null;
    
    @Before
    public void beforeTest()
    {
       System.out.println("=====================A new case start=====================");
       anagram = new Anagram("Unabr.dict");
    }
    
    @After
    public void afterTest()
    {
        System.out.println("=====================A new case end=======================");
    }

    @Test
    public void testGetWordSign(){
        BadAnagram ba = new BadAnagram("anagram");
        String s = "moonlake";
        System.out.println(ba.getWordSign(s));
    }
    
    @Test
    public void testGetWordsCombineSet() {
        BadAnagram ba = new BadAnagram("anagram");
        HashSet<String> hs = new HashSet<String>();
        String s = "ab";
        ba.createWordsCombineSet(BadAnagram.stringToCharacterList(s),
                new ArrayList<Character>(), s.length());
    }
    
}
