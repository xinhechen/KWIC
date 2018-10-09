package phase2;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xinhe
 */
public class NoiseEliminator {
    static String[] noise= {"a","an","and","are","as","at","be", "by","for","from","has","he","in","is","it","its","of","on","that","the","to","was","were","will","with"};
    static List<String[]> words =new ArrayList<String[]>();
    static int position=0;
    public static void setup(){

        int size = CircularShift.getSize();
        for(int i=position; i<size;i++){
           String[] sentence = CircularShift.getWord(i);
            if(!isNoise(sentence[0]))
                setWord(sentence);
        }
        position = size;
    }
    
    private static boolean isNoise(String w){
        for(int i=0;i<noise.length;i++){
            if (noise[i].equals(w))
                return true;
        }
        return false;
    }
    
    public static void setWord(String[] sentence){
        words.add(sentence);
    }
    
     public static int getSize(){
        return words.size();
    }
    
    public static String[] getWord(int index){
        return words.get(index);
    }
}