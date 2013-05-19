package topic6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;


public class Anagram {
    
    private static Logger log = Logger.getLogger(Anagram.class);
    
    String fileName;
    
    List<String> wordsList;
    
    HashMap<List<Character>, List<String>> sortedWords;
    
    
    public Anagram(String fileName){
        this.fileName = fileName;
        wordsList = new ArrayList<String>();
        sortedWords = new HashMap<List<Character>, List<String>>();        
    }
    

    public void loadDictionary() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String r = br.readLine();
            while (r != null) {
                wordsList.add(r);
                r = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("not such file exists:" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("errors when read file:" + fileName);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    public void buildMap(){
        if(wordsList.isEmpty()){
            return;
        }
        
        ArrayList<Character> keys = new ArrayList<Character>();

        for (String temp:wordsList){
            keys = getWordSign(temp);
            if(sortedWords.containsKey(keys)){
                sortedWords.get(keys).add(temp);
            }
            else{
                ArrayList<String> newItem= new ArrayList<String>();
                newItem.add(temp);
                sortedWords.put(keys, newItem);
            }
        }
    }

    public ArrayList<Character> getWordSign(String word) {
        ArrayList<Character> charList = new ArrayList<Character>();

        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            charList.add(ch[i]);
        }
        Collections.sort(charList);
        return charList;
    }
    
    public ArrayList<String> getStringBySign(String s) {
        if (s == null) {
            return null;
        }

        ArrayList<Character> wordSign = getWordSign(s);

        if (sortedWords.containsKey(wordSign)) {
            return (ArrayList<String>) sortedWords.get(wordSign);
        }

        return null;

    }
    
    public void wordsSortedInfo(){
        System.out.println("The size after build the map is:" + sortedWords.size());
    }
    
    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public List<String> getWordsList() {
        return wordsList;
    }


    public void setWordsList(List<String> wordsList) {
        this.wordsList = wordsList;
    }    

    public void printWordList() {
        System.out.println(wordsList);
    }

}
