package topic6;


import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.*;;


public class AnagramTest {
    
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
    
    @Ignore
    @Test
    public void testKeyList(){
        String a = "asdfghjkl";
        assertThat(a.length(), is(anagram.getWordSign(a).size()));
        System.out.println(anagram.getWordSign(a));        
    }
    
    @Ignore
    @Test
    public void testDupKeyList(){
        String a = "absdfhghjkbl";
        assertThat(a.length(), is(anagram.getWordSign(a).size()));
        System.out.println(anagram.getWordSign(a));        
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
    
    @Ignore
    @Test
    public void testSpecficWords(){
        anagram.loadDictionary();
        anagram.buildMap();
        String s1 = "stop";
        String s2 = "host";
        System.out.println("The word is " + s1 +", sign is:" + anagram.getWordSign(s1) + ", words list are:" +anagram.getStringBySign(s1));        
        System.out.println("The word is " + s2 +", sign is:" + anagram.getWordSign(s2) + ", words list are:" +anagram.getStringBySign(s2));        
    
    }
    @Test
    public void testInfo(){
        anagram.loadDictionary();
        anagram.buildMap();
        anagram.info();
        anagram.listAllAnagrams();
    }
    
    @Ignore
    @Test
    public void testLongestWords(){
        anagram.loadDictionary();
        anagram.buildMap();
        HashMap<List<Character>, List<String>> wordsList = anagram.getLongestWords();
    	for(List<Character> charList: wordsList.keySet()){
    		System.out.println("key is:" + charList + ", wordList is:"+ anagram.getSortedWords().get(charList));
    	}
    }
    
    @Test
    public void testLongestAnagramWords(){
        anagram.loadDictionary();
        anagram.buildMap();
        HashMap<List<Character>, List<String>> wordsList = anagram.getLongestAnagramWords();
        for(List<Character> charList: wordsList.keySet()){
            System.out.println("key is:" + charList + ", wordList is:"+ anagram.getSortedWords().get(charList));
        }
    }
    
    @Test
    public void testMostAnagramWordsList(){
        anagram.loadDictionary();
        anagram.buildMap();
        HashMap<List<Character>, List<String>> wordsList = anagram.getMostAnagramWords();
    	for(List<Character> charList: wordsList.keySet()){
    		System.out.println("key is:" + charList + ", wordList is:"+ anagram.getSortedWords().get(charList));
    	}
    }
}
