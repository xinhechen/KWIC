package phase2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xinhe
 */
public class LineStorage {
    static String[] words;  
    public static void setup(String sentence){
        String[] split = sentence.split(" ");
        int size = split.length;
        words = new String[size];
        for(int i=0;i<size;i++){
            setWord(split[i],i);
        }
    }
    
    private static void setWord(String w,int index){
        words[index] = w.toLowerCase();
    }
    
    public static int getSize(){
        return words.length;
    }
    
    public static String getWord(int index){
        return words[index];
    }
}
