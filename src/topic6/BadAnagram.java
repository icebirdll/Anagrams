package topic6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BadAnagram {
String fileName;
    
    List<String> wordsList;
    //temp for all the combination of one words
    HashSet<String> wordsCombineList = new HashSet<String>();
    
    HashMap<String, List<String>> sortedWords;
    
    public BadAnagram(String fileName){
        this.fileName = fileName;
        wordsList = new ArrayList<String>();
        sortedWords = new HashMap<String, List<String>>();        
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
        } catch (IOException e) {
            e.printStackTrace();
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
        String keys = null;

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
    
    private void WordsCombineSet(List<Character> datas, List<Character> target,
            int num) {
        if (target.size() == num) {
            System.out.println("datas: " + datas);
            System.out.println("target: " + target);
            System.out.println("num: " + num);
            wordsCombineList.add(target.toString());
            return;
        }
        
        for (int i = 0; i < datas.size(); i++) {
            List<Character> newDatas = new ArrayList<Character>(datas);
            List<Character> newTarget = new ArrayList<Character>(target);
            newTarget.add(newDatas.get(i));
            newDatas.remove(i);
            WordsCombineSet(newDatas, newTarget, num);
        }
    }

    public void createWordsCombineSet(List<Character> datas, List<Character> target,
            int num) {
        wordsCombineList.clear();
        WordsCombineSet(datas, target, num);
    }
    
//    public String stringListToString(List<String> target){
//        StringBuffer s = new StringBuffer();
//        for (String t : target)
//            s.append(t);
//        return s.toString();
//    }
    
    public static ArrayList<Character> stringToCharacterList(String word) {
        ArrayList<Character> charList = new ArrayList<Character>();
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            charList.add(ch[i]);
        }
        return charList;
    }
    
//    public String[] charListToStringList(char[] ci) {
//        String[] so = new String[ci.length];
//        for (int i = 0; i < ci.length; i++) {
//            so[i] = String.valueOf(ci[i]);
//        }
//        return so;
//    }
    
    public void isAnagram(HashSet<String> combineWordsList){
        int count = 0;
        for (String s : combineWordsList) {
            if (wordsCombineList.contains(s)) {
                
                count++;
            }
        }
    }

    public String getWordSign(String word) {
        char[] signArray = word.toCharArray();
        Arrays.sort(signArray);
        return new String(signArray);
    }
}
