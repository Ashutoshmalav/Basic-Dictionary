package com.example.dictionaryashu11dec;
import java.util.HashMap;
import java.util.Locale;

public class DictionaryUsingHashMap {
    private HashMap<String,String> dictionary;

    public DictionaryUsingHashMap() {
        this.dictionary = new HashMap<>();
        addWordList();
    }

    public boolean addWords(String word, String meaning){
        try{
            dictionary.put(word,meaning);

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
    public String getMeaning(String word){
        if(dictionary.containsKey(word.toLowerCase())){
            return dictionary.get(word.toLowerCase());
        }
        else{
            return "Word does not exist in Dictionary";
        }
    }
    private void addWordList(){
        addWords("shubh", "Auspicious");
        addWords("Phase", "a stage in the development of something");
        addWords("project", "an individual or collaborative enterprise that is carefully planned to achieve a particular aim");
        addWords("start", "beginning");
        addWords("Depreciating assets ", "Whose value decreases with time");

    }
}
