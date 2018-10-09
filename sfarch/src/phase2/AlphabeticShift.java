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
import java.util.List;
import java.util.ArrayList;
public class AlphabeticShift {
    static List<String[]> words =new ArrayList<String[]>();
    static int position=0;
    public static void setup(){

        int size = NoiseEliminator.getSize();
        for(int i=position; i<size;i++){
           String[] sentence = NoiseEliminator.getWord(i);
           setWord(sentence);
           alphabetize();
        }
        position = size;
    }
    
    private static void alphabetize(){
        for(int i=0;i<words.size()-1;i++){
           for(int j=0;j<words.size()-i-1;j++)
           {
               if(greaterThan(words.get(j),words.get(j+1))){
                   String[] temp = words.get(j);
                   words.set(j, words.get(j+1));
                   words.set(j+1,temp);
               }
           }
        }
    }
    
    private static boolean greaterThan(String[] a, String[] b){
        for(int i=0; i< a.length; i++){
            if(a[i].compareTo(b[i])<0)
                return false;
            if(a[i].compareTo(b[i])>0)
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

