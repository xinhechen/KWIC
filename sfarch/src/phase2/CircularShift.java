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
public class CircularShift {
    static List<String[]> words =new ArrayList<String[]>();
    
    public static void setup(){
        int size = LineStorage.getSize();
        String[] sentence = new String[size];
        for(int i=0; i<size; i++){
            sentence[i] = LineStorage.getWord(i);
        }
        
        //Perform the CS
        for(int i=0; i<size; i++){
            setWord(shift(sentence, i));
        }
    }
    
    private static String[] shift(String[] sentence, int shiftNum){
        int size = sentence.length;
        String[] shifted = new String[size];
        for(int i=0;i<size;i++){
            shifted[i]=sentence[shiftNum+i];
            if(shiftNum+i==size-1)
                shiftNum = 0-i-1;
        }

        return shifted;
    }
    private static void setWord(String[] w){
        words.add(w);
    }
    
    public static int getSize(){
        return words.size();
    }
    
    public static String[] getWord(int index1){
        return words.get(index1);
    }
}