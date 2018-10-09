package phase2;


import java.sql.Array;
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
public class MasterControl {
    public  static void generate(String s){
        LineStorage.setup(s);
        CircularShift.setup();
        NoiseEliminator.setup();
        AlphabeticShift.setup();
    }
    
    public List<String[]> Run(List<String> input){
    	String[] sentence = null;
    	String[] sentence2 = null;
    	//for(int i = 0;i<input.size();i++){
    		MasterControl.generate(input.get(input.size()-1));
    //	}
    	List<String[]> output = new ArrayList<String[]>();
        int sizeCS = CircularShift.getSize();
        String[] sentence3 = new String[sizeCS];
        String s = "";
        for(int i=0; i<sizeCS;i++){
            sentence = CircularShift.getWord(i);
            for(int j=0; j<sentence.length;j++){
               s += sentence[j]+" ";
            }
            sentence3[i] = s;
            s = "";
        }
        int sizeAS = AlphabeticShift.getSize();
        String[]sentence4 = new String[sizeAS];
        String s1 = "";
        for(int i=0; i<sizeAS;i++){
            sentence2 = AlphabeticShift.getWord(i);
            for(int j=0; j<sentence2.length;j++){
                s1 += sentence2[j]+" ";
            }
            sentence4[i] = s1;
            s1 = "";
        }
        output.add(sentence3);
        output.add(sentence4);
		return output;
    }
}
